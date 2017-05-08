package cz.ucl.jee.lec08;

import javax.ejb.Remote;

@Remote
public interface Ex06TopicSender {
	public void publishMessage(String msgText);
}
