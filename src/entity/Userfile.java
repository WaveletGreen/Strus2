package entity;

/**
 * Userfile entity. @author MyEclipse Persistence Tools
 */

public class Userfile implements java.io.Serializable {

	// Fields

	private String username;
	private Users users;
	private String oldfilename;
	private String newfilename;

	// Constructors

	/** default constructor */
	public Userfile() {
	}

	/** minimal constructor */
	public Userfile(String username, Users users) {
		this.username = username;
		this.users = users;
	}

	/** full constructor */
	public Userfile(String username, Users users, String oldfilename,
			String newfilename) {
		this.username = username;
		this.users = users;
		this.oldfilename = oldfilename;
		this.newfilename = newfilename;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getOldfilename() {
		return this.oldfilename;
	}

	public void setOldfilename(String oldfilename) {
		this.oldfilename = oldfilename;
	}

	public String getNewfilename() {
		return this.newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

}