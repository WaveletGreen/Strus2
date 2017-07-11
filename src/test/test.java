package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Users;
import util.HibernateSessionFactory;

public class test {

	public static void main(String[] args) {
		p1();
	}

	private static void p1() {
//		System.out.println("----------");
//		Session session = HibernateSessionFactory.getSession();
//		String hql = "from Users where username=:username and password=:password";
//		Query query = session.createQuery(hql);
//		query.setString("username", "fancyears");
//		query.setString("password", "fancyears");
//		Users users=(Users) query.uniqueResult();
//		System.out.println(users.getUsername());
		File file=new File("src/filter/common.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while (reader.ready()) {
				System.out.println(reader.readLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
