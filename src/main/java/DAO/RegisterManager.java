package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterManager {

	private Connection con = null;
	private PreparedStatement ps = null;
	
	public void registerStudent(String studentNumber, String studentName) {
		try {
			//DBへの接続処理
			getConnect();
			
			//SQL文の作成
			String sql = "INSERT INTO student VALUES (?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, studentNumber);
			ps.setString(2, studentName);
			System.out.println(ps);
			
			ps.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
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