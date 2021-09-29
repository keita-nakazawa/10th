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
		String studentNumber = (String)session.getAttribute("studentNumber");
		String studentName = (String)session.getAttribute("studentName");
		String memoText = (String)session.getAttribute("memoText");
		String staffName = (String)session.getAttribute("staffName");
%>
		<p><%=loginUser.getStaffName()%>先生がログイン中</p>
		<p>学生の詳細</p>
		<form action="EditServlet" method="POST">
			<dl>
				<dt>学籍番号</dt>
				<dd>
					<input type="text" name="studentNumber" value=<%=studentNumber%>>
				</dd>
				
				<dt>氏名</dt>
				<dd>
					<input type="text" name="studentName" value=<%=studentName%>>
				</dd>
			
				<dt>メモ</dt>
				<dd>
					<textarea name="memoText"><%=memoText%></textarea>
				</dd>
				
				<dt>メモ作成者</dt>
				<dd><%=staffName%></dd>
			</dl>
			<p>
				<input type="submit" value="編集内容を保存する">
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