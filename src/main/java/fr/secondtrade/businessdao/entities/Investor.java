package fr.secondtrade.businessdao.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inverstors")
public class Investor extends Person {
	
	private static final long serialVersionUID = 1L;
	
	public Investor() {}
	
	public Investor(String firstname,String lastname){
		super(firstname, lastname);
	}
	
	public String toString() {
		return String.format("Investor[%s]", super.toString());
	}
}
