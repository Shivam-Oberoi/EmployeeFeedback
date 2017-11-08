<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<title>Spring Boot</title>
</head>
<body>
	<header>
		<div style="float: left">
			<img style="margin: 0px 10px 10px 0px"
				src="/resources/image/logo-min.jpg">
		</div>
		<div>
			<h1 style="text-align: center; width: 1875px;">Employee Feedback System</h1>
		</div>
		<hr>
	</header>
	<section style="height: 1500px;background-image: url('/resources/image/background.jpg');background-repeat: no-repeat;background-size: cover;">
		<div class="login">
			<div style="color: red;">${message}</div>
			<form:form action="login" modelAttribute="user" method="post"
				style="margin: 30px 70px 10px 70px; width: 100%;">
				<table>
					<tr>
						<td>Username</td>
						<td><form:input id="name" path="username" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:password id="name" path="password" /></td>
					</tr>
					<tr>
						<td colspan="2" style="padding-left: 84px;padding-top: 10px;">
							<input type="submit" value="Submit" />
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</section>
</body>
</html>