package cz.ucl.jee.lec08;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

@MessageDriven(name = "ex05receiverResponder", 
	activationConfig={
		@ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
		@ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/test"),
		@ActivationConfigProperty(propertyName="messageSelector", 
		propertyValue="UclPriority IS NOT NULL AND UclPriority < 5")})

public class Ex05ReceiverResponderBean implements MessageListener {
	@Resource(mappedName = "java:jboss/DefaultJMSConnectionFactory")
	private ConnectionFactory cf;

	@Override
	@TransactionAttribute
	public void onMessage(Message receivedMessage) {
		TextMessage msg = (TextMessage) receivedMessage;
		try {
			System.out.println("Low priority receiver got message with text "
					+ msg.getText());

			Destination dest = msg.getJMSReplyTo();
			if (dest != null) {
				Connection con = cf.createConnection();
				Session sess = con.createSession(false,
						Session.AUTO_ACKNOWLEDGE);
				MessageProducer sender = sess.createProducer(dest);
				Message replyMsg = sess.createTextMessage("Reply to  '"
						+ msg.getText() + "' at " + System.currentTimeMillis());
				sender.send(replyMsg);

				sender.close();
				sess.close();
				con.close();

				System.out
						.println("Response to low priority message generated");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
