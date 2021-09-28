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
		Student student = (Student)request.getAttribute("student");
		Memo memo = (Memo)request.getAttribute("memo");
		Staff staff = (Staff)request.getAttribute("staff");
%>
		<p><%=loginUser.getStaffName()%>先生がログイン中</p>
		<p>学生の詳細</p>
		
		<form action="">
			<dl>
				<dt>学籍番号</dt>
				<dd>
					<input type="text" value=<%=student.getStudentNumber()%>>
				</dd>
				
				<dt>氏名</dt>
				<dd>
					<input type="text" value=<%=student.getStudentName()%>>
				</dd>
			
				<dt>メモ</dt>
				<dd>
					<textarea></textarea>
				</dd>
				
				<dt>メモ作成者</dt>
				<dd></dd>
			</dl>
		</form>
	</body>
</html>