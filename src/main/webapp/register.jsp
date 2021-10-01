<%@page import="model.Staff"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>学生の登録</title>
	</head>

	<body>
<%
		Staff loginUser = (Staff)session.getAttribute("loginUser");
%>
		<p><%=loginUser.getStaffName()%>先生がログイン中</p>
		
		<p>学生の新規登録</p>
		<form action="RegisterServlet" method="POST">
			<dl>
				<dt>学籍番号</dt>
				<dd>
					<input type="text" pattern="^[0-9A-Za-z]{1,10}$" maxlength="10" name="studentNumber" placeholder="半角英数字">
				</dd>
				
				<dt>氏名</dt>
				<dd>
					<input type="text" pattern="^[^!&quot;#$%&'\*\+\-\.,\/:;<>?@\[\\\]^_`{|}~]+$" name="studentName" placeholder="入力可能な半角記号→ ( ) =">
				</dd>
<!--			バックエンド側でもはじく処理をする必要あり。
				<dt>メモ</dt>
				<dd>
					<textarea name="memoText"></textarea>
				</dd>
-->
			</dl>
			<p>
				<input type="submit" value="登録">
			</p>
		</form>
		<form action="ReturnServlet">
				<p><input type="submit" value="学生名簿一覧へ戻る"></p>
			</form>
	</body>
</html>


<!-- 
https://pointsandlines.jp/server-side/php/smarty-input-value
https://www-creators.com/archives/1827
https://wakatech.jp/sanitize
 -->