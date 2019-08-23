package com.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubadBean {

	@Id
	private String name;
	private String password;
	private String clgcode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClgcode() {
		return clgcode;
	}
	public void setClgcode(String clgcode) {
		this.clgcode = clgcode;
	}
	@Override
	public String toString() {
		return "SubadBean [name=" + name + ", password=" + password + ", clgcode=" + clgcode + "]";
	}
	
	
	
}
