<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'download.jsp' starting page</title>

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
	2222222222
	<img alt="ssssssss"
		src="C:/Users/Administrator/Desktop/admin1499532704983.jpg">
	22222222222
	<table>
		<s:iterator value="fileLists" var="file">
			<tr>
				<td><a
					href="file_FileHandle_download?downloadFileName=<s:property value="#file.newfilename"/>&oldName=<s:property
							value="#file.oldfilename" />"><img
						width="250px" height="300px"
						alt="<s:property
							value="#file.oldfilename" />"
						src="<s:property value="user.username"/>/<s:property value="#file.newfilename"/>"></a></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>
