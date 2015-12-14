package cn.lzg.sdrdemo.entity;

import java.io.Serializable;

/**
 * @author Wolf.Lang
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 522889572773714584L;
	
	private String id;
	private String name;
	private String password;
	
	public User() {}
	
	public User(String id,String name,String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "userId:"+this.id + "\nuserName:"+this.name + "\npassWord:"+this.password;
	}
}
