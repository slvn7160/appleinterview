package com.apple.iterview;

import java.io.Serializable;

public class Country implements Serializable{
	
	private static final long serialVersionUID = -5494904646082069854L;
	private String name;
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", status=" + status + "]";
	}
	
	

}
