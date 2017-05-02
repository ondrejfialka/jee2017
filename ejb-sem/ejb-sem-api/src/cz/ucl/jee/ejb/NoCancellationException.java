package cz.ucl.jee.ejb;

@SuppressWarnings("serial")
public class NoCancellationException extends Exception {
	private String reason;	

	public NoCancellationException(String reason) {
		super(reason);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
