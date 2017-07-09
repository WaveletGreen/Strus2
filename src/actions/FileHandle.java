package actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.Userfile;
import entity.Users;
import imp.FileHandlerServiceImpl;
import service.FileHandlerService;

/**
 * 提供用户上传和下载服务，支持多文件上传
 * 
 * @author Administrator
 *
 */
public class FileHandle extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5763585077794352588L;
	private File[] myFile;// 上传的文件数组
	private String[] myFileFileName;// 上传的文件名数组
	private Users user;// 登录的用户
	private List<Userfile> fileLists;// 文件列表
	private Map<String, Object> session = new HashMap<String, Object>();// 从SessionAware中获取HttpSession
	private InputStream downloadStream;// 输入流，需要正确关闭才不会出现异常，待解决
	private String oldName;

	private String downloadFileName;// 下载文件名

	/**
	 * 这个流对象是用来传输文件到浏览器的流对象
	 * 
	 * @return
	 */
	public InputStream getDownloadStream() {
		return ServletActionContext.getServletContext()
				.getResourceAsStream("/upload/" + ((Users) session.get("user")).getUsername() + "/" + downloadFileName);
	}

	public void setDownloadStream(InputStream downloadStream) {
		this.downloadStream = downloadStream;
	}

	/**
	 * 获取HttpSession
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public List<Userfile> getFileLists() {
		return fileLists;
	}

	public File[] getMyFile() {
		return myFile;
	}

	public void setMyFile(File[] myFile) {
		this.myFile = myFile;
	}

	public String[] getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String[] myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	/**
	 * 用户上传服务
	 * 
	 * @return
	 */
	public String upload() {
		FileHandlerService service = new FileHandlerServiceImpl();
		try {
			// 从httpSession中获取user
			this.user = (Users) session.get("user");
			System.out.println(user.getUsername());
			service.upload(user, myFileFileName, myFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "upload";
	}

	/**
	 * 预下载，因为点击超链接会产生一个新的action处理，因此要链式传递到下一个action中，并将内容加载进action中
	 * 实际就是放到HttpSession中
	 * 
	 * @return
	 */
	public String preDownload() {
		FileHandlerService service = new FileHandlerServiceImpl();
		fileLists = service.download((Users) session.get("user"));
		user = (Users) session.get("user");
		return SUCCESS;
	}

	public void setFileLists(List<Userfile> fileLists) {
		this.fileLists = fileLists;
	}

	/**
	 * 下载功能
	 * 
	 * @return
	 */
	public String download() {
		
		return "download";
	}

}
