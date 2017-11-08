package com.nagarro.model;

public class Login {

	private String jsp;
	private String message;
	private User user;

	public Login(User user) {
		super();
		this.user = user;
	}

	public String getJsp() {
		return jsp;
	}

	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Login [jsp=" + jsp + ", message=" + message + ", user=" + user + "]";
	}
	
}
