package com.example.jwT.model;

public class JwtEntity {

	private String username;
	private String password;

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JwtEntity(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public JwtEntity() {
	}

	@Override
	public String toString() {
		return "JwtEntity [username=" + username + ", password=" + password + "]";
	}

}
