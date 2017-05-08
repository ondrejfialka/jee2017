package cz.ucl.jee.lec08;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessagingServiceLocator {
		public static final String JMS_FACTORY_LOCATION = "jms/RemoteConnectionFactory"; //"ConnectionFactory";		
		public static final String LEC08_TEST_QUEUE_LOCATION = "jms/queue/test";
		public static final String LEC08_TEST_TOPIC_LOCATION = "jms/topic/test";
		public static final String EJB_EX06_LOCATION = "jms-lec/jms-lec-ejb/ex06topicSender!cz.ucl.jee.lec08.Ex06TopicSender";

		private Context ctx;		

		public MessagingServiceLocator() {
			Properties prop = new Properties();
			  
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
			prop.put(Context.SECURITY_PRINCIPAL, "username");
			prop.put(Context.SECURITY_CREDENTIALS, "password");
			          
			prop.put("jboss.naming.client.ejb.context", true);
			  
			try {
				ctx = new InitialContext(prop);
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
		}
	
		public ConnectionFactory getConnectionFactory() {
			try {
				return (ConnectionFactory) ctx.lookup(JMS_FACTORY_LOCATION);
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public Queue getTestQueue() {
			try {
				return (Queue) ctx.lookup(LEC08_TEST_QUEUE_LOCATION);
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public Topic getTestTopic() {
			try {
				return (Topic) ctx.lookup(LEC08_TEST_TOPIC_LOCATION);
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}

		public Ex06TopicSender getTopicSenderBean() {
			try {
				return (Ex06TopicSender) ctx.lookup(EJB_EX06_LOCATION);
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}


}
