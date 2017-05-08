package cz.ucl.jee.lec08;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class Ex05SendAndReceiveResponse {
	private MessagingServiceLocator locator;
	
	private Ex05SendAndReceiveResponse() {
		locator = new MessagingServiceLocator();
	}

	private void doSend() throws JMSException, IOException {
		ConnectionFactory cf = locator.getConnectionFactory();
		Connection con = cf.createConnection("jms","jms");
		Session sess = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		
		Destination testQueue = locator.getTestQueue();
		MessageProducer sender = sess.createProducer(testQueue);
		
		Destination replyQueue = sess.createTemporaryQueue();
		
		Message msg1 = sess.createTextMessage("A low priority message sent at " + System.currentTimeMillis());
		msg1.setIntProperty("UclPriority", 2);
		msg1.setJMSReplyTo(replyQueue);
		sender.send(msg1);
		
		Message msg2 = sess.createTextMessage("A high priority message sent at " + System.currentTimeMillis());
		msg2.setIntProperty("UclPriority", 7);
		msg2.setJMSReplyTo(replyQueue);
		sender.send(msg2);		
		
		MessageConsumer receiver = sess.createConsumer(replyQueue);
		receiver.setMessageListener(new Ex03Listener());
		con.start();
		
		sender.close();
		
		System.out.println("Press any key to stop listening for new messages.");
		System.in.read();
		sess.close();
		con.close();
		
		System.out.println("Messages sent");
	}
	
	public static void main(String[] args) throws JMSException, IOException {
		Ex05SendAndReceiveResponse instance = new Ex05SendAndReceiveResponse();
		instance.doSend();
	}

}
