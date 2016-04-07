package fr.secondtrade.businessdao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "issuers")
public class Issuer extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	@Column(length = 40)
	private String name;
	@Column(length = 40,name="ISIN")
	private String isinCode;
	@Column(length = 40)
	private String symbol;
	
	
	public Issuer() {}


	public Issuer(String name, String isinCode, String symbol) {
		this.name = name;
		this.isinCode = isinCode;
		this.symbol = symbol;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIsinCode() {
		return isinCode;
	}


	public void setIsinCode(String isinCode) {
		this.isinCode = isinCode;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	@Override
	public String toString() {
		return String.format("Issuer[%s, %s, %s, %s, %s]", id, version, name, isinCode,symbol);
	}
	
	
}
