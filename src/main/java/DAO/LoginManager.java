package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Staff;

public class LoginManager {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public Staff loginUser(String staffId, String pass) {
 		Staff staff = null;
 		String staffName = null;
 		int iStaffId = Integer.parseInt(staffId);
 		
		try {			
			//データベースへの接続処理
			getConnect();
			
			//SQL文の作成
			String sql =
					"SELECT * FROM staff WHERE (staff_id = ?) && (login_password = ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, iStaffId);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//ログイン情報が正しい場合の処理
				staffName = rs.getString("staff_name");
				staff = new Staff(iStaffId, staffName, pass);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		
		return staff;
	}
	
	public void loginOrNot(Staff staff, HttpSession session, HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		if(staff != null) {
			//ログイン成功時処理
			session.setAttribute("loginUser", staff);
			
			ListManager listManager = new ListManager();
			session.setAttribute("studentList", listManager.getStudentList());

			RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
			rd.forward(request, response);
		} else {
			//ログイン失敗時処理
			String message = "ログインに失敗しました</br>"
					+ "入力内容をご確認ください";
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
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
			if(rs != null) {
				rs.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
