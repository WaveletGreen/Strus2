package actions;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
public class UserFuncs extends ActionSupport {
	private static final long serialVersionUID = -4186964667292763280L;
	private Users user;
	private String email;
	private String msg = "";
	private List<Users> list;
	private String delName;

	public String getDelName() {
		return delName;
	}

	public void setDelName(String delName) {
		this.delName = delName;
	}

	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

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

	/**
	 * user登陆功能
	 * 
	 * @return
	 */

	public String login() {
		System.out.println("----------");
		System.out.println("+++++++++++++" + user.getUsername());
		System.out.println("+++++++++++++" + user.getPassword());
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Users where username=:username and password=:password";
		Query query = session.createQuery(hql);
		query.setString("username", user.getUsername());
		query.setString("password", user.getPassword());
		Users users = (Users) query.uniqueResult();
		if (users != null) {
			this.user = users;
			return SUCCESS;
		} else {
			addFieldError("msg", "用户名或密码错误!");
			return INPUT;
		}

	}

	/**
	 * user注册功能
	 */
	public String regist() {
		System.out.println("++++++++++++");
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		return SUCCESS;
	}

	public void validateRegist() {
		System.out.println("----------" + user.getUsername());
		System.out.println("---------->" + user.getPassword());
		if (user.getUsername().length() < 3)
			addFieldError("name_error", "用户名太短");
		if (user.getPassword().length() < 3)
			addFieldError("password_error", "密码长度太短");
	}

	@SuppressWarnings("unchecked")
	public String viewAll() {
		System.out.println("----->" + user.getUsername());
		if ("admin".equals(user.getUsername())) {
			Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("from Users");
			list = query.list();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getUsername());
			}
			session.close();
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String delet() {
		System.out.println("--------------" + delName);
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Users delUser = (Users) session.get(Users.class, delName);
		Query query = session.createQuery("from Users");
		if (delUser != null) {
			session.delete(delUser);
			tx.commit();
		}
		list = query.list();
		session.close();
		return "commonPage";
	}
	public String update() {
		
		return "commonPage";
	}
}
