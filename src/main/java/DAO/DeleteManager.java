package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class DeleteManager {

	private Connection con = null;
	private PreparedStatement ps = null;
	
	public void deleteStudent(HttpSession session) {
		try {
			//DBへの接続処理
			getConnect();
			
			//SQL文の作成
			String sql = "DELETE FROM student WHERE student_number = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)session.getAttribute("studentNumber"));
			System.out.println(ps);
			
			ps.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}	
	
	public void getConnect() throws ClassNotFoundException, SQLException{
		Class.forName("org.mariadb.jdbc.Driver");

		String url = "jdbc:mysql://localhost/campus";
		String user = "root";
		String password = "";
		
		con = DriverManager.getConnection(url, user, password);
	}
	
	public void closeAll() {
		try {
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
