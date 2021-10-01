package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import model.Staff;

public class EditManager {

	private Connection con = null;
	private PreparedStatement ps = null;
	
	public void changeStudentNumber(String newStudentNumber,String oldStudentNumber, HttpSession session) {
		if(newStudentNumber.equals(oldStudentNumber) == false) {
			try {
				//DBへの接続処理
				getConnect();
				
				//SQL文の作成
				String sql = "UPDATE student SET student_number = ? WHERE student_number = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, newStudentNumber);
				ps.setString(2, oldStudentNumber);
				System.out.println(ps);
				
				ps.executeUpdate();
				
				session.setAttribute("studentNumber", newStudentNumber);
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
		}
	}
	
	public void changeStudentName(String newStudentName,String oldStudentName, String newStudentNumber, HttpSession session) {
		if(newStudentName.equals(oldStudentName) == false) {
			try {
				//DBへの接続処理
				getConnect();
				
				//SQL文の作成
				String sql = "UPDATE student SET student_name = ? WHERE student_number = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, newStudentName);
				ps.setString(2, newStudentNumber);
				System.out.println(ps);
				
				ps.executeUpdate();
				
				session.setAttribute("studentName", newStudentName);
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
		}
	}
	
	public void changeMemo(String newMemoText,String oldMemoText, HttpSession session) {
		if(newMemoText.equals(oldMemoText) == false) {
			try {
				//DBへの接続処理
				getConnect();

				int memoId = (Integer)session.getAttribute("memoId");
				int staffId =
						((Staff)session.getAttribute("loginUser")).getStaffId();
				String studentNumber =
						(String)session.getAttribute("studentNumber");
				String staffName =
						((Staff)session.getAttribute("loginUser")).getStaffName();
				
				if(memoId == 0) {
					//該当学生のメモデータがDBにない時のSQL文
					String sql = "INSERT INTO memo VALUES (null, ?, ?, ?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, studentNumber);
					ps.setInt(2, staffId);
					ps.setString(3, newMemoText);
				} else {
					//該当学生のメモデータがDBにある時のSQL文
					String sql = "UPDATE memo SET memo_text = ?, updated_staff_id = ?"
							+ " WHERE memo_id = ?";
					ps = con.prepareStatement(sql);
					ps.setString(1, newMemoText);
					ps.setInt(2, staffId);
					ps.setInt(3, memoId);
				}
				System.out.println(ps);
				ps.executeUpdate();
				
				session.setAttribute("memoText", newMemoText);
				session.setAttribute("staffName", staffName);
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
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
