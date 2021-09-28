<%@ page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>削除確認</title>
	</head>
	
	<body>
<%
		Student student = (Student)session.getAttribute("student");
%>
		<p>本当に以下の学生の情報を削除しますか?</p>
		<p>学籍番号：<%=student.getStudentNumber()%></p>
		<p>氏名：<%=student.getStudentName()%></p>
		<form action="DeleteServlet">
			<input type="submit" value="削除">
		</form>
		
		<p><a href="studentDetail.jsp">学生の詳細へ戻る</a></p>
	</body>
</html>