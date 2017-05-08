package cz.ucl.jee.lec08;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class Ex02Send {
	private MessagingServiceLocator locator;
	
	private Ex02Send() {
		locator = new MessagingServiceLocator();
	}

	private void doSend() throws JMSException {
		ConnectionFactory cf = locator.getConnectionFactory();
		Connection con = cf.createConnection("jms","jms");
		Session sess = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		
		Destination testQueue = locator.getTestQueue();
		MessageProducer sender = sess.createProducer(testQueue);
		
		Message msg = sess.createTextMessage("Hi, current time is " + new Date(System.currentTimeMillis()));
		sender.send(msg);
		
		sess.close();
		con.close();
		
		System.out.println("Message sent");
	}
	
	public static void main(String[] args) throws JMSException {
		Ex02Send instance = new Ex02Send();
		instance.doSend();
	}

}
