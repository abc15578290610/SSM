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
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
