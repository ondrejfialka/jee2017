package cz.ucl.jee.lec04.additional;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Data1 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String input;
	
	public Data1(){
		input = "Hello :)";
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
}
