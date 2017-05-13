package ru.mail.urbanovichalexandr.services.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
public class UserAuthStorage {

	private Integer login;
	private Integer password;

	public Integer getLogin() {
		return login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserAuthStorage [login=" + login + ", password=" + password + "]";
	}
	
	

}
