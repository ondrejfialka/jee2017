package cz.ucl.jee.lec08;

import javax.jms.JMSException;

public class Ex06CallEJBSend {
	private MessagingServiceLocator locator;
	
	private Ex06CallEJBSend() {
		locator = new MessagingServiceLocator();
	}

	private void doSend() throws JMSException {
		locator.getTopicSenderBean().publishMessage("A message sent from a SLSB at " + System.currentTimeMillis());
		
		System.out.println("EJB call succeeded");
	}
	
	public static void main(String[] args) throws JMSException {
		Ex06CallEJBSend instance = new Ex06CallEJBSend();
		instance.doSend();
	}

}
