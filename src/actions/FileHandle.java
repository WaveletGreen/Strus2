package actions;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.Users;

public class FileHandle extends ActionSupport {
	private File myFile;
	private String myFileFileName;
	private Users users;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	@Override
	public String execute() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload/" + users.getUsername());
		System.out.println("-----------" + path);
		File filePath = new File(path);
		if (!filePath.isDirectory()) {
			filePath.mkdirs();
		}
		long time = new Date().getTime();
		File newFile = new File(filePath
				+ "\\"
				+ (time + myFileFileName.substring(myFileFileName
						.lastIndexOf("."))));
		System.out.println(newFile.getPath());
		FileUtils.copyFile(myFile, newFile);
		return SUCCESS;
	}

}
