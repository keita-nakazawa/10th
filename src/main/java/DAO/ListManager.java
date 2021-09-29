package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class ListManager {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public ArrayList<Student> getStudentList() {
		ArrayList<Student> studentList = new ArrayList<>();
		
		try {
			//データベースへの接続処理
			getConnect();
		
			String sql = "SELECT * FROM student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String studentNumber = rs.getString("student_number");
				String studentName = rs.getString("student_name");
				Student student = new Student(studentNumber, studentName);
				studentList.add(student);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		
		return studentList;
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



//public ArrayList<Memo> getMemoList() {
//	ArrayList<Memo> memoList = new ArrayList<>();
//	
//	try {
//		//データベースへの接続処理
//		getConnect();
//	
//		String sql = "SELECT * FROM memo";
//		ps = con.prepareStatement(sql);
//		rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			int memoId = rs.getInt("memo_id");
//			String studentNumber = rs.getString("student_number");
//			int updatedStaffId = rs.getInt("updated_staff_id");
//			String memoText = rs.getString("memo");
//			Memo memo = new Memo(memoId, studentNumber, updatedStaffId, memoText);
//			memoList.add(memo);
//		}
//	} catch(ClassNotFoundException e) {
//		e.printStackTrace();
//	} catch(SQLException e) {
//		e.printStackTrace();
//	} finally {
//		closeAll();
//	}
//	
//	return memoList;
//}
//
//public ArrayList<Staff> getStaffList() {
//	ArrayList<Staff> staffList = new ArrayList<>();
//	
//	try {
//		//データベースへの接続処理
//		getConnect();
//	
//		String sql = "SELECT * FROM staff";
//		ps = con.prepareStatement(sql);
//		rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			int staffId = rs.getInt("staff_id");
//			String staffName = rs.getString("staff_name");
//			String pass = rs.getString("login_password");
//			Staff staff = new Staff(staffId, staffName, pass);
//			staffList.add(staff);
//		}
//	} catch(ClassNotFoundException e) {
//		e.printStackTrace();
//	} catch(SQLException e) {
//		e.printStackTrace();
//	} finally {
//		closeAll();
//	}
//	
//	return staffList;
//}