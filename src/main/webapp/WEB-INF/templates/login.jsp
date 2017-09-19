<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Login</title>
	</head>
	<body>
		<c:if test="${error}"><p>Invalid username or password</p></c:if>
		<form action="login" method="post">
			<input type="text" name="username" placeholder="username"/><br />
			<input type="password" name="password" placeholder="password"/><br />
			<button type="submit">Login</button>
		</form>
	</body>
	<script type="text/javascript" src="static/js/lib/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		/*<![CDATA[*/
			
			$(document).ready(function() {
				$("form").submit(function() {
					//validate
					
				});
			});
			
		/*]]>*/
	</script>
</html>