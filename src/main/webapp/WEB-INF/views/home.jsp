<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Service</title>
<script src="https://code.jquery.com/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0/angular.min.js"></script>
</head>
<body>
	<div class="fluid-container">
		<div class="container">
			<h1>Welcome to Rest API</h1>
			<div>
				<h3>click on below bottom</h3>
				<div class="alert alert-info">
				<p>Use password as password@123</p>
				</div>
				<div >
					<a href="<c:url value="/user/list"/>" class="btn btn-info" role="button">Link Button</a>
					</div>
					<div>
						<p>Add .xml or .json for extension in the end of url</p>
					</div>
				</div>
			</div>
			</div>
</body>
</html>