package actions;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

/**
 * 三种方式实现Action处理<br/>
 * <p>
 * 1.一个普通的类
 * </p>
 * <p>
 * 2.实现Action接口
 * </p>
 * <strong>3. 继承ActionSupport，使本处理Action功能更加完全(推荐)</strong>
 * 
 * @author Administrator
 * 
 */
public class Login extends ActionSupport {
	private static final long serialVersionUID = -4186964667292763280L;
	private User user;
	private String email;

	public User getUser() {
		return user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() {
		System.out.println(user.getUserName() + "-----------"
				+ user.getPassword());
		System.out.println("---------" + email);
		return SUCCESS;
	}
}
