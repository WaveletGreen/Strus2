package actions;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import entity.Users;
import util.HibernateSessionFactory;

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
	private Users user;
	private String email;

	public Users getUser() {
		return user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String execute() {
		System.out.println("----------");
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Users where username=:username and password=:password";
		Query query = session.createQuery(hql);
		query.setString("username", "fancyears");
		query.setString("password", "fancyears");
		Users users=(Users) query.uniqueResult();
		if ( users!= null) {
			this.user=users;
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
