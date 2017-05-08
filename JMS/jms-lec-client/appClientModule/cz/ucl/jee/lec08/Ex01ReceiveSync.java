package cz.ucl.jee.lec08;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Ex01ReceiveSync {
private MessagingServiceLocator locator;
	
	private Ex01ReceiveSync() {
		locator = new MessagingServiceLocator();
	}	
	
	private void doReceive() throws JMSException {
		ConnectionFactory cf = locator.getConnectionFactory();
		
		Connection con = cf.createConnection("jms","jms");
		Session sess = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		
		Destination testQueue = locator.getTestQueue();
		MessageConsumer receiver = sess.createConsumer(testQueue);
				
		con.start();
		TextMessage msg = (TextMessage) receiver.receive();
		System.out.println("Synchronously received message with text '" + msg.getText()+"'");
		msg.acknowledge();
		
		sess.close();
		con.close();
	}
	
	public static void main(String[] argv) throws JMSException {
		Ex01ReceiveSync instance = new Ex01ReceiveSync();
		instance.doReceive();
	}
}