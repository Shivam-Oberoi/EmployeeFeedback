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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/app.js"></script>
<script type="text/javascript">
	var userId = ${sessionScope.user.id };
</script>
</head>
<body onload="javascript: getProjectList();">
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

	<div class="form" id="project">
		<div id="message" style="color: green;text-align: center;"></div>
		Select the Employee for Feedback
		<select id="employeeList" onchange="javascript: openNewFeedbackForm()">
			<option value="-1">Select</option>
			<c:forEach var="employee" items="${employeeList}">
				<option value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</select>
	</div>
	
	<%-- <div class="form">
		<div id="message" style="color: green;text-align: center;"></div>
		Select the Employee for Feedback
		<select id="employeeList" onchange="javascript: openNewFeedbackForm()">
			<option value="-1">Select</option>
			<c:forEach var="employee" items="${employeeList}">
				<option value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</select>
	</div> --%>
	<div style="float: right; margin-top: -57px;">Welcome <c:out value="${sessionScope.user.name }"/> | <a href="/logout">Logout</a></div>
	
	<div style="margin-top: 10px;display: none;">
		<table id="question_tbl" class="tableCSS">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Question</th>
					<th>Feedback</th>			
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<button onclick="javascript: submitFeedback()" style="margin: 10px 10px 10px 941px;">Submit</button>
	</div>
</body>
</html>