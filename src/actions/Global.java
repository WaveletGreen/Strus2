package actions;

import com.opensymphony.xwork2.ActionSupport;

public class Global extends ActionSupport {

	@Override
	public String execute() throws Exception {
		String lang = getText("username");
		System.out.println("--------------------------------------" + lang);
		return SUCCESS;
	}

}
