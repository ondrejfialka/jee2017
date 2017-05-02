package cz.ucl.jee.ejb;

@SuppressWarnings("serial")
public class NoRoomAvailableException extends Exception {
	private Integer maxAvailableCapacity;	

	public Integer getMaxAvailableCapacity() {
		return maxAvailableCapacity;
	}

	public void setMaxAvailableCapacity(Integer maxAvailableCapacity) {
		this.maxAvailableCapacity = maxAvailableCapacity;
	}
	
	
}
