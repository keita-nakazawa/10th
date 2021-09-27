<%@ page import="model.Student"%>
<%@ page import="model.Memo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Staff"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>学生の詳細</title>
	</head>

	<body>
<%
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		ArrayList<Memo> memoList = 
				(ArrayList)session.getAttribute("memoList");
		ArrayList<Staff> staffList = 
				(ArrayList)session.getAttribute("staffList");
		ArrayList<Student> studentList = 
				(ArrayList)session.getAttribute("studentList");
%>
		
		<p>学生の詳細</p>
		<ul>
			<li>
				<p>学籍番号</p>
				<p><%=%></p>
			</li>
			<li>
				<p>氏名</p>
				<p></p>
			</li>
			<li>
				<p>メモ</p>
				<p></p>
			</li>
		</ul>
	</body>
</html>