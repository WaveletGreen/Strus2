<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="js/jquery-3.2.1.slim.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript">
	$(document).ready($(function() {
		// 		$(".sub").focusin(function() {
		// 			alert("ssss");
		// 			$(this).css("style", "");
		// 		});
		// 		$("#loginPassword").focus(function() {
		// 			$("#loginPassword").val("");
		// 			$("#loginPassword").css("style", "");
		// 		});
		// 		$(".sub").each(function() {
		// 			$(this).focus(function() {
		// 				$(this).css("style", "");
		// 			})
		// 		});

	}));
	function langSet(lang) {
		window.location.href ="<%=basePath%>
	langSet.action?request_locale="
				+ lang;
	}
// 	function langSetA(){
// 	document.getElementById("")
// 	}
</script>
</head>
<body>
	<div id="container">
		<a href="langSet.action?request_locale=en_US">英文</a> <a
			href="langSet.action?request_locale=zh_CN">中文</a>
		<div class="msgDiv">
			<s:fielderror fieldName="msg"></s:fielderror>
		</div>
		<select id="langSelector" onchange="langSetA()">
			<!-- 		onclick并不支持IE以外的浏览器，有待改进 -->
			<option onchange="langSet('zh_CN')" onclick="langSet('zh_CN')">中文</option>
			<option onclick="langSet('en_US')">英文</option>
		</select>
		<form action="userUserFuncs_login.action" id="loginForm">
			<s:actionerror />
			<table>
				<tr>
					<td><s:text name="username" /></td>
					<td><input name="user.username" id="loginName" class="sub" />
					</td>
				</tr>
				<tr>
					<td><s:text name="password" /></td>
					<td><input name="user.password" id="loginPassword" class="sub" />
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="<s:text name="login"/>" /></td>
				</tr>
			</table>
		</form>
		<a href="preDownload.action">查看文件</a>
	</div>
</body>
</html>
