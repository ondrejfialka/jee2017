package cz.ucl.jee.lec04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="memberManager")
@ViewScoped
public class MemberManager implements Serializable{
	
	private Person member;
	private List<Person> allMembers;

	public MemberManager() {
		super();
		member = new Person();
		allMembers = new ArrayList<Person>();
	}

	public Person getMember() {
		return member;
	}

	public void setMember(Person member) {
		this.member = member;
	}	

	public List<Person> getAllMembers() {
		return allMembers;
	}

	public String saveMember() {
		System.out.println("Saving member " + member);
		allMembers.add(member);
		member = new Person();
		return "memberSaved";
	}

}
