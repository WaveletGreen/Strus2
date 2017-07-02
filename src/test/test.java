package test;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.User;
import entity.Users;
import util.HibernateSessionFactory;

public class test {

	public static void main(String[] args) {
		p1();
	}

	private static void p1() {
		
		System.out.println(((Users)query.uniqueResult()).getUsername());
	}

}
