package com.tasteshared.Utils;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8980386032436705885L;
	public String chefId;
	public String password;
	@Override
	public String toString() {
		return "Person [chefId=" + chefId + ", password=" + password + "]";
	}
	public Person(String chefId, String password) {
		super();
		this.chefId = chefId;
		this.password = password;
	}
	
}
