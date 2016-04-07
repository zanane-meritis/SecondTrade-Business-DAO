package fr.secondtrade.businessdao.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class Agent extends Person {
	private static final long serialVersionUID = 1L;

	public Agent() {}

	public Agent(String firstname,String lastname){
		super(firstname, lastname);
	}

	public String toString() {
		return String.format("Agent[%s]", super.toString());
	}
}
