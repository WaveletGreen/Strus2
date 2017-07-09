package imp;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Userfile;
import entity.Users;
import service.FileHandlerService;
import util.HibernateSessionFactory;

public class FileHandlerServiceImpl implements FileHandlerService {

	@Override
	public String upload(Users user, String[] fileName, File[] files) throws IOException {

		String parentPath = ServletActionContext.getServletContext().getRealPath("/upload//" + user.getUsername());
		// 创建文件夹路径，为每个用户创建文件夹，方便文件夹管理
		System.out.println("------测试----------------" + parentPath);
		File path = new File(parentPath);
		if (!path.isDirectory()) {
			path.mkdirs();
		}
		long time = 0;
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		// 保存新名字
		String[] newFileName = new String[fileName.length];
		// 统一保存在服务文件夹下面
		for (int i = 0; i < fileName.length; i++) {
			// 获取日期作为新文件名，为了方便搜索，将username+time作为文件的主键
			time = new Date().getTime();
			newFileName[i] = user.getUsername() + time + fileName[i].substring(fileName[i].lastIndexOf("."));
			File newFile = new File(path + "//" + (newFileName[i]));
			System.out.println("------测试----------------" + newFile.getName());
			FileUtils.copyFile(files[i], newFile);
		}
		// 统一持久化
		for (int i = 0; i < files.length; i++) {
			Userfile file = new Userfile(newFileName[i], user, fileName[i]);
			session.save(file);
		}
		tx.commit();
		session.close();
		return "success";
	}

	@Override
	public List<Userfile> download(Users user) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Userfile where users.username=:username";
		Query query = session.createQuery(hql);
		query.setString("username", user.getUsername());
		List<Userfile> fileLists = query.list();
		return fileLists;
	}

}
