package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import model.Memo;
import model.Staff;
import model.Student;

public class DetailManager {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public Student searchStudent(HttpServletRequest request) {
		Student student = null;
		
		try {
			//データベースへの接続処理
			getConnect();
			
			//SQL文の作成
			String sql = "SELECT * FROM student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//該当学籍番号の検索
			while(rs.next()) {
				String studentNumber = rs.getString("student_number");
				if(request.getParameter(studentNumber) != null) {
					String studentName = rs.getString("student_name");
					student = new Student(studentNumber, studentName);
					break;
				}
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return student;
	}
	
	public Memo searchMemo(Student student) {
		Memo memo = null;
		
		try {
			//データベースへの接続処理
			getConnect();
			
			//SQL文の作成
			String sql = "SELECT * FROM memo";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//該当メモの検索
			while(rs.next()) {
				if(student.getStudentNumber().equals(rs.getString("student_number"))) {
					int memoId = rs.getInt("memo_id");
					String studentNumber = rs.getString("student_number");
					int updatedStaffId = rs.getInt("updated_staff_id");
					String mem = rs.getString("memo");
					memo = new Memo(memoId, studentNumber, updatedStaffId, mem);
					break;
				}
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return memo;
	}
	
	public Staff searchStaff(Memo memo) {
		Staff staff = null;
		
		if(memo != null) {
			try {
				//データベースへの接続処理
				getConnect();
				
				//SQL文の作成
				String sql = "SELECT * FROM staff";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				//職員(メモ作成者)の検索
				while(rs.next()) {
					if(memo.getUpdatedStaffId() == rs.getInt("staff_id")) {
						int staffId = rs.getInt("staff_id");
						String staffName = rs.getString("staff_name");
						staff = new Staff(staffId, staffName);
						break;
					}
				}
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
		}
		return staff;
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


//https://www.sejuku.net/blog/14621
//「==」と「.equals」の違い