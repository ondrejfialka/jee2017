package cz.ucl.jee.lec08;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

public class Ex06ReceiveAsyncTopic {
private MessagingServiceLocator locator;
	
	private Ex06ReceiveAsyncTopic() {
		locator = new MessagingServiceLocator();
	}	
	
	private void doReceive() throws JMSException, IOException {
		ConnectionFactory cf = locator.getConnectionFactory();
		Connection con = cf.createConnection("jms","jms");
		Session sess = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination testTopic = locator.getTestTopic();
		MessageConsumer receiver = sess.createConsumer(testTopic);
		receiver.setMessageListener(new Ex03Listener());
		
		con.start();	
		
		System.out.println("Press any key to stop listening for new messages.");
		System.in.read();
		
		sess.close();
		con.close();
	}
	
	
	public static void main(String[] argv) throws JMSException, IOException {
		Ex06ReceiveAsyncTopic instance = new Ex06ReceiveAsyncTopic();
		instance.doReceive();
	}
}