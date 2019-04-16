/**
 * 
 */
package com.java.main;
import java.io.Serializable;
/**
 * @author Administrator
 *
 */
public class User  implements Serializable{
	private static final long serialVersionUID = 1L;
	public String userName;
	public String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
