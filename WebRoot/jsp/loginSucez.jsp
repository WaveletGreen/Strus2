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

<title>My JSP 'loginSucez.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	欢迎
	<s:property value="user.username" />
	<a
		href='userUserFuncs_viewAll.action?user.username=<s:property value="user.username" />'>查看所有用户

	</a>
	<a href="jsp/fileupload.jsp">上传文件</a>
	<form action="publicArticle.action">
		<fieldset style="width: 980px;margin: 0 auto;">
			<legend>发帖</legend>
			主题:<input type="text" name="theme" /> <br />
			<textarea rows="50" cols="100" name="content"></textarea>
		</fieldset>
		<input type="submit"/>
	</form>
	<br>
</body>
</html>
