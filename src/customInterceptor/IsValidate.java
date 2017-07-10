package customInterceptor;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class IsValidate extends ActionSupport implements Interceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext atx = invocation.getInvocationContext();
		Map<String, Object> session = atx.getSession();
		Object user = session.get("user");
		if (user != null) {
			return invocation.invoke();
		} else {
			ActionSupport support = (ActionSupport) invocation.getAction();
			support.addActionError("您还未登录，请登陆");
			return Action.INPUT;
		}
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

}
