package com.seventeam.gsf.models;

public class AbstractUsuario {
	
	private String password;
	private String login;
	
	public AbstractUsuario(String password, String login) {
		this.password = password;
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
}
