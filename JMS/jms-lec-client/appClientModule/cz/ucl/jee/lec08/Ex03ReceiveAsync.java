package cz.ucl.jee.lec08;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

public class Ex03ReceiveAsync {
private MessagingServiceLocator locator;
	
	private Ex03ReceiveAsync() {
		locator = new MessagingServiceLocator();
	}	
	
	private void doReceive() throws JMSException, IOException {
		ConnectionFactory cf = locator.getConnectionFactory();
		Connection con = cf.createConnection("jms","jms");
		Session sess = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination testQueue = locator.getTestQueue();
		MessageConsumer receiver = sess.createConsumer(testQueue);
		receiver.setMessageListener(new Ex03Listener());
		
		con.start();	
		
		System.out.println("Press any key to stop listening for new messages.");
		System.in.read();
		
		sess.close();
		con.close();
	}
	
	
	public static void main(String[] argv) throws JMSException, IOException {
		Ex03ReceiveAsync instance = new Ex03ReceiveAsync();
		instance.doReceive();
	}
}