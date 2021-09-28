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
		Student student = (Student)session.getAttribute("student");
		Memo memo = (Memo)session.getAttribute("memo");
		Staff staff = (Staff)session.getAttribute("staff");
%>
		<p><%=loginUser.getStaffName()%>先生がログイン中</p>
		<p>学生の詳細</p>
		<form action="EditServlet" method="POST">
			<dl>
				<dt>学籍番号</dt>
				<dd>
					<input type="text" name="studentNumber" value=<%=student.getStudentNumber()%>>
				</dd>
				
				<dt>氏名</dt>
				<dd>
					<input type="text" name="studentName" value=<%=student.getStudentName()%>>
				</dd>
			
				<dt>メモ</dt>
				<dd>
					<textarea name="memo"><%
						if(memo != null) {%><%=memo.getMemo()%><%}
					%></textarea>
				</dd>
				
				<dt>メモ作成者</dt>
				<dd>
<%
					if(staff != null) {
%>
						<%=staff.getStaffName()%>
<%
					}
%>
				</dd>
			</dl>
			
			<p>
				<input type="submit" value="編集内容を保存する">
				※変更を加えていない場合でも、メモ作成者だけは更新されます
			</p>
		</form>
		
		<form action="delete.jsp">
			<input type="submit" value="この学生の情報を削除する">
		</form>
		<br>
		<br>
		<p><a href="studentList.jsp">学生名簿一覧へ戻る</a></p>
		
	</body>
</html>