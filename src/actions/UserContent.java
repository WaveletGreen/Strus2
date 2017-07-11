package actions;

import com.opensymphony.xwork2.ActionSupport;

public class UserContent extends ActionSupport{
	private static final long serialVersionUID = 6282343392410708505L;
	private String content;
	private String theme;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
