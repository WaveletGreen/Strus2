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

<title>My JSP 'regist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/login.css">

<script type="text/javascript" src="js/jquery-3.2.1.slim.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript">
// 	$(function() {
// 		$("#loginForm").submit(function() {
// 			if ($("#loginPassword").val() != $("#confPassword").val()) {
// 				alert($("#loginPassword").val());
// 				return false;
// 			}
// 		})
// 	});
</script>
</head>

<body>
	<div class="msgRegDiv">
		<s:fielderror fieldName="name_error"></s:fielderror>
		<s:fielderror fieldName="password_error"></s:fielderror>
	</div>
	<form action="UserFuncs_regist.action" id="loginForm">
		<table>
			<thead>注册
			</thead>
			<tr>
				<td>用户名：</td>
				<td><input name="user.username" id="loginName" class="sub"
					value=<s:property value="user.username"/>><span id="spName"
					style="color:red"></span></td>
			</tr>
			<tr>
				<td>密&emsp;码：</td>
				<td><input type="password" name="user.password"
					id="loginPassword" class="sub" /><span id="spPsw"
					style="color:red"></span></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" id="confPassword" class="sub" /><span
					id="spCfPsw" style="color:red"></span></td>
			</tr>

			<tr>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
