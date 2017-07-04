<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'viewAllerror.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-3.2.1.slim.js"></script>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function update(obj, oldPsw) {
		target = $(obj).parent().prev().prev();
		target.html("<input value=" + oldPsw + " onblur=canSubmit(this)>");
		$(obj).text("提交");
	}
	function canSubmit(obj) {
		target = $(obj);
		parent = target.parent();
		newPsw = target.val();
		parent.text(newPsw);
		newTarget = target.parent().next().next();
		$(obj).css("visibility", "hidden");
	// 		target.parent().next().next().html("<a href='UserFuncs_update.action?delName='" + parent.prev().text() + "&updatePsw=" + parent.text() + ">更新</a>");
	}
</script>
</head>

<body>
	<table border="1px red solid" align="center">
		<tr>
			<th colspan="3">查询所有用户</th>
		</tr>
		<tr>
			<td>用户名</td>
			<td>密码</td>
			<td colspan="2">操作</td>
		</tr>
		<s:iterator value="list" var="u">
			<tr>
				<td><s:property value="username" /></td>
				<td><s:property value="password" /></td>
				<td><a
					href='UserFuncs_delet.action?delName=<s:property value="username"/>'>删除</a></td>
				<td><a href='javascript:void(0)'
					onclick='update(this,"<s:property value="password"/>")'>更新</a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
