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


		<form action="LogoutServlet" method="GET">
			<p><input type="submit" value="ログアウト"></p>
		</form>
		<p>学生情報の登録は<a href="registerStudent.jsp">こちら</a></p>
		
		<table>
			<thead>
				<th></th>
				<th>学籍番号</th>
				<th>氏名</th>
				<th>メモ</th>
				<th>メモ作成者</th>
			</thead>
			<tbody>
				<td><a href="#">編集・削除</a></td>
				<td></td>
				<td></td>
				<td>
					<form action="#">
						<input type="submit" value="表示/非表示">
					</form>
				</td>
				<td></td>
			</tbody>
		
		</table>
		
		<a href="#">ページ最上部へ</a>
	</body>
</html>