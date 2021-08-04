package com.glancelot.models;

public class LoginForm {
	
	private String email;
	private String password;
	
	public LoginForm(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginForm [email=" + email + ", password=" + password + "]";
	}
	
	

}
