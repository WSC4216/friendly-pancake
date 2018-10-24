<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<s:form action="loginAction" method="post">
		<s:textfield name="user.user_name" id="user_name" label="用户名"></s:textfield>
		<s:textfield name="user.pwd" id="user_pwd" label="密码"></s:textfield>
		<img name="d" src="authImg">
		<s:textfield name="vercode"></s:textfield>
		<s:submit value="登录"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
</body>
</html>