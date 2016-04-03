package fr.secondtrade.businessdao.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column(length = 20)
	private String firstname;
	@Column(length = 20)
	private String lastname;
	
	//Default constructor
	public Person(){}

	//Constructor using fields
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString(){
		return String.format("User[%s, %s, %s, %s]", id, version, firstname, lastname);
	}
	
}
