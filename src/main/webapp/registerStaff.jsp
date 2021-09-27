<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>新規登録ページ</title>
	</head>

	<body>
		<h1>新規登録(職員専用)</h1>
		<form action="RegisterServlet" method="POST">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="staffId" pattern="^[0-9]+$" maxlength="11" placeholder="数字" required></td>
				</tr>
				<tr>
					<td>職員氏名</td>
					<td><input type="text" name="staffName" required></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="pass" required
						pattern="^[a-zA-Z0-9!-/:-@¥[-`{-~]+$" maxlength="10" placeholder="半角英数字記号10文字以内"></td>
				</tr>
				<tr>
					<td>パスワード(2回目)</td>
					<td><input type="password" name="pass2" required 
						pattern="^[a-zA-Z0-9!-/:-@¥[-`{-~]+$" maxlength="10" placeholder="半角英数字記号10文字以内"></td>
				</tr>
			</table>
			<p><input type="submit" value="新規登録"></p>
		</form>
		
		<!-- 
		if文内に新規登録失敗時のメッセージ書く
		入力したメールアドレスは既に使用されています。
		入力したIDは既に使用されています。
		2回目のパスワードが間違っています。
		 -->
		
		<p><a href="login.jsp">ログインページへ戻る</a></p>

	</body>
</html>

<!-- 
https://qiita.com/grrrr/items/0b35b5c1c98eebfa5128
 -->