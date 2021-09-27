<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>ログインページ</title>
		<style>
			#message {
				color : red;
			}
		</style>
	</head>

	<body>
		<h1>ログイン(職員専用)</h1>
<%
		if(request.getAttribute("message") != null) {
			String message = (String)request.getAttribute("message");
%>
			<p id="message"><%=message%></p>
<%
		}
%>	
		<form action="LoginLogoutServlet" method="POST">
			<table>
				<tr>
					<td>職員ID</td>
					<td><input type="text" name="staffId" pattern="^[0-9]+$" placeholder="数字" required></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="pass" required></td>
				</tr>
			</table>
			<p><input type="submit" value="ログイン"></p>
		</form>
	</body>
</html>