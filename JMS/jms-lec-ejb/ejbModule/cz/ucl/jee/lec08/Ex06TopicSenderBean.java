package cz.ucl.jee.lec08;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

@Stateless(name = "ex06topicSender")
public class Ex06TopicSenderBean implements Ex06TopicSender {
	@Resource(mappedName="java:/jms/topic/test")
	private Destination testTopic;

	@Resource(mappedName="java:jboss/DefaultJMSConnectionFactory")
	private ConnectionFactory cf;

	@Override
	public void publishMessage(String msgText) {
		try {
			Connection con = cf.createConnection();
			Session sess = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageProducer sender = sess.createProducer(testTopic);

			Message msg1 = sess
					.createTextMessage(msgText);
			sender.send(msg1);

			sender.close();
			sess.close();
			con.close();
			System.out.println("Message published");
		} catch (JMSException e) {
			System.out.println("Message sending failed in Ex06TopicSenderBean");
		}
	}

}
