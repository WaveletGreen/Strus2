package customInterceptor;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import actions.UserContent;

public class ContentValidate extends AbstractInterceptor {
	private static final long serialVersionUID = 4446367069262697308L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object object = invocation.getAction();
		if (object != null) {
			if (object instanceof UserContent) {
				UserContent action = (UserContent) object;
				String content = action.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						ServletActionContext.getServletContext().getResourceAsStream("filter/common.txt")));
				while (reader.ready()) {
					System.out.println("---------------" + content);
					String rep = reader.readLine();
					System.out.println("--------" + rep + "-----------");
					content = content.replaceAll(rep, "***");
					System.out.println("--------------->>>>>" + content);
				}
				action.setContent(content);
				reader.close();
				return invocation.invoke();
			}
		}
		return Action.ERROR;
	}

}
