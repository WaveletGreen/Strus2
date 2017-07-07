package actions;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.Users;

public class FileDownload extends ActionSupport {
	private InputStream downloadStream;
	private String fileName;
	private Users users;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getDownloadStream() {
		return downloadStream;
	}

	public InputStream getDownloadStrea() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/upload/" + users.getUsername() + "/" + fileName);
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
