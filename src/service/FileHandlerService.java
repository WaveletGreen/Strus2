package service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import entity.Userfile;
import entity.Users;

/**
 * 处理用户文件上传下载的服务
 * 
 * @author Administrator
 *
 */
public interface FileHandlerService {
	/**
	 * 文件上传服务
	 * 
	 * @param user
	 * @return
	 * @throws IOException 
	 */
	public String upload(Users user, String[] fileName,File[] files) throws IOException;

	/**
	 * 下载服务
	 * 
	 * @param user
	 *            操作的用户
	 * @return
	 */
	public List<Userfile> download(Users user);
}
