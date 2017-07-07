package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private Set userfiles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Users(String username, String password, Set userfiles) {
		this.username = username;
		this.password = password;
		this.userfiles = userfiles;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getUserfiles() {
		return this.userfiles;
	}

	public void setUserfiles(Set userfiles) {
		this.userfiles = userfiles;
	}

}