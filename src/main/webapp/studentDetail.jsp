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
					<input type="text" pattern="^[0-9A-Za-z]{1,10}$" maxlength="10" name="studentNumber" value="<%=studentNumber%>">
				</dd>
				
				<dt>氏名</dt>
				<dd>
					<input type="text" pattern="^[^!&quot;#$%&'\*\+\-\.,\/:;<>?@\[\\\]^_`{|}~]+$" name="studentName" value="<%=studentName%>">
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
		<form action="ReturnServlet">
			<input type="submit" value="学生名簿一覧へ戻る">
		</form>		
	</body>
</html>



<!-- 
https://pointsandlines.jp/server-side/php/smarty-input-value
https://www-creators.com/archives/1827
https://wakatech.jp/sanitize
 -->