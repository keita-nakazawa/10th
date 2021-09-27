<%@ page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザ削除ページ</title>
	</head>

	<body>
<%	
		User user = (User)session.getAttribute("user");
%>
		<p>本当に <%=user.getId()%> さんのユーザ情報を削除してもよろしいですか?</p>

		<form action="DeleteServlet" method="GET">
			<p><input type="submit" value="はい"></p>
		</form>
		<p><a href="mypage.jsp">マイページに戻る</a></p>
		<!--
		<form action="mypage.jsp">
			<p><input type="submit" value="いいえ"></p>
		</form>
		-->
	</body>
</html>