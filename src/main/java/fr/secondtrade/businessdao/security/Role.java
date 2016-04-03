package fr.secondtrade.businessdao.security;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.secondtrade.businessdao.entities.AbstractEntity;


@Entity
@Table(name = "ROLES")
public class Role extends AbstractEntity {
	
	private static final long serialVersionUID = 1L; // propriétés
	private String name;
	// constructeurs
	public Role() { }
	public Role(String name) { 
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// identité
	@Override
	public String toString() {
		return String.format("Role[%s]", name);
	}

}
