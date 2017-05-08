package cz.ucl.jee.lec08;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name="ex04receiver", activationConfig={
		@ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
		@ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/test"),
		@ActivationConfigProperty(propertyName="messageSelector",
				propertyValue="UclPriority IS NOT NULL AND UclPriority >= 5")
})
public class Ex04ReceiverBean implements MessageListener {

	@Override
	@TransactionAttribute
	public void onMessage(Message receivedMessage) {
		TextMessage msg = (TextMessage) receivedMessage;
		try {
			System.out.println("High priority receiver got message with text " + msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
