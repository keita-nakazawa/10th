<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>ログインページ</title>
		<style>
			#alert {
				color : red;
			}
		</style>
	</head>

	<body>
		<h1>ログイン(職員専用)</h1>
		<form action="LoginServlet" method="POST">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="staffId" pattern="^[0-9A-Za-z]+$" placeholder="半角英数字" required></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="pass" required></td>
				</tr>
			</table>
			<p><input type="submit" value="ログイン"></p>
		</form>
		
<%
		if(request.getAttribute("login") == "fail") {
%>
			<p id="alert">ログインに失敗しました。IDもしくはパスワードが違います。</p>
<%
		}

%>
		
		<hr>
		<p>※セッションが破棄されているか確認する欄※</p>
		<p>session.getAttribute("user") = <%=session.getAttribute("user")%></p>
		
	</body>
</html>