<%@page import="model.Student"%>
<%@page import="model.Memo"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="model.Staff"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>学生名簿</title>
	</head>

	<body>
<%
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		ArrayList<Student> studentList = 
				(ArrayList)request.getAttribute("studentList");
%>	
		<p id="top"><%=loginUser.getStaffName()%>先生がログイン中</p>
		<form action="LoginLogoutServlet" method="GET">
			<p><input type="submit" value="ログアウト"></p>
		</form>
		<p>学生情報の登録は<a href="registerStudent.jsp">こちら</a></p>
		
		<table border="1">
			<thead>
				<tr>
					<th>学籍番号</th>
					<th>氏名</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
<%
				for(Student student: studentList) {
%>
					<tr>
						<td><%=student.getStudentNumber()%></td>
						<td><%=student.getStudentName()%></td>
						<td>
							<form action="DetailServlet">
								<input type="submit" name=<%=student.getStudentNumber()%> value="詳細・編集・削除">
							</form>
						</td>
					</tr>
<%
				}
%>
			</tbody>
		
		</table>
		
		<a href="#top">ページ最上部へ</a>
	</body>
</html>