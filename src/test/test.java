package test;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Users;
import util.HibernateSessionFactory;

public class test {

	public static void main(String[] args) {
		p1();
	}

	private static void p1() {
		System.out.println("----------");
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Users where username=:username and password=:password";
		Query query = session.createQuery(hql);
		query.setString("username", "fancyears");
		query.setString("password", "fancyears");
		Users users=(Users) query.uniqueResult();
		System.out.println(users.getUsername());
	}

}
