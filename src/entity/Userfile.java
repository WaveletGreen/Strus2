package entity;

/**
 * Userfile entity. @author MyEclipse Persistence Tools
 */

public class Userfile implements java.io.Serializable {

	// Fields

	private String newfilename;
	private Users users;
	private String oldfilename;

	// Constructors

	/** default constructor */
	public Userfile() {
	}

	/** minimal constructor */
	public Userfile(String newfilename, Users users) {
		this.newfilename = newfilename;
		this.users = users;
	}

	/** full constructor */
	public Userfile(String newfilename, Users users, String oldfilename) {
		this.newfilename = newfilename;
		this.users = users;
		this.oldfilename = oldfilename;
	}

	// Property accessors

	public String getNewfilename() {
		return this.newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
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

}