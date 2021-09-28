package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//学生の詳細表示処理
		
//		ArrayList<Memo> memoList = (ArrayList)session.getAttribute("memoList");
//		ArrayList<Staff> staffList = (ArrayList)session.getAttribute("staffList");
		
//		Student student = DetailManager.searchStudent(studentList, request);
//		Memo memo = DetailManager.searchMemo(student, memoList);
//		Staff staff = DetailManager.searchStaff(memo, staffList);

//		request.setAttribute("student", student);
//		request.setAttribute("memo", memo);
//		request.setAttribute("staff", staff);
		
		RequestDispatcher rd = request.getRequestDispatcher("studentDetail.jsp");
		rd.forward(request, response);
	}
}