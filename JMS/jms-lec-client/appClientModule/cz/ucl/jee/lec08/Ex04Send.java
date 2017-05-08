package cz.ucl.jee.lec08;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class Ex04Send {
	private MessagingServiceLocator locator;
	
	private Ex04Send() {
		locator = new MessagingServiceLocator();
	}

	private void doSend() throws JMSException {
		ConnectionFactory cf = locator.getConnectionFactory();
		Connection con = cf.createConnection("jms","jms");
		Session sess = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		
		Destination testQueue = locator.getTestQueue();
		MessageProducer sender = sess.createProducer(testQueue);
		
		Message msg1 = sess.createTextMessage("A low priority message sent at " + System.currentTimeMillis());
		msg1.setIntProperty("UclPriority", 4);
		sender.send(msg1);
		
		Message msg2 = sess.createTextMessage("A high priority message sent at " + System.currentTimeMillis());
		msg2.setIntProperty("UclPriority", 7);
		sender.send(msg2);
		
		sender.close();
		
		sess.close();
		con.close();
		
		System.out.println("Messages sent");
	}
	
	public static void main(String[] args) throws JMSException {
		Ex04Send instance = new Ex04Send();
		instance.doSend();
	}

}
