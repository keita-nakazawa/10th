package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ListManager;
import DAO.RegisterManager;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String studentNumber = request.getParameter("studentNumber");
		String studentName = request.getParameter("studentName");
		
		RegisterManager registerManager = new RegisterManager();
		registerManager.registerStudent(studentNumber, studentName);
		
		//request内の学生名簿一覧を更新
		ListManager listManager = new ListManager();
		request.setAttribute("studentList", listManager.getStudentList());
		
		RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
		rd.forward(request, response);
	
	}
}
