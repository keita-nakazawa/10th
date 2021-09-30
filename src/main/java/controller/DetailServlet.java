package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DetailManager;
import model.Memo;
import model.Staff;
import model.Student;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//学生の詳細表示処理
		DetailManager detailManager = new DetailManager();
		
		Student student = detailManager.searchStudent(request);
		Memo memo = detailManager.searchMemo(student);
		Staff staff = detailManager.searchStaff(memo);

		HttpSession session = request.getSession();
		session.setAttribute("studentNumber", student.getStudentNumber());
		session.setAttribute("studentName", student.getStudentName());
		session.setAttribute("memoId", memo.getMemoId());
		session.setAttribute("memoText", memo.getMemoText());
		session.setAttribute("staffName", staff.getStaffName());

		RequestDispatcher rd = request.getRequestDispatcher("studentDetail.jsp");
		rd.forward(request, response);
	}
}