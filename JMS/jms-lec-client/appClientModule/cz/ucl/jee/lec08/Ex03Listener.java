package cz.ucl.jee.lec08;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Ex03Listener implements MessageListener {

	@Override
	public void onMessage(Message receivedMessage) {
		if (receivedMessage instanceof TextMessage){
			TextMessage msg = (TextMessage) receivedMessage;
			try {
				System.out.println("Asynchronously received message with text " + msg.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
