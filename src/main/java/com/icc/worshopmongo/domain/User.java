package com.icc.worshopmongo.domain;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String idString;
	private String name;
	private String mail;
	
	public User() {}
	
	public User(String idString, String name, String mail) {
		super();
		this.idString = idString;
		this.name = name;
		this.mail = mail;
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idString == null) ? 0 : idString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (idString == null) {
			if (other.idString != null)
				return false;
		} else if (!idString.equals(other.idString))
			return false;
		return true;
	}
	
	
	

}
