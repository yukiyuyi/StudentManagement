package domain;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uname;
	private String upassword;
	
	public User(String uname,String upassword) {
		this.uname=uname;
		this.upassword=upassword;
	}
	public User() {
		this("", "");
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(this==obj) {
			return true;
		}
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		User user = (User) obj;
		if(uname.equals(user.getUname())&&upassword.equals(user.upassword)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return uname + " " + upassword;
	}
}
