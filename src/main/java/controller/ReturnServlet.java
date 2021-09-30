 package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ListManager;

@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request内の学生名簿一覧を更新
		ListManager listManager = new ListManager();
		request.setAttribute("studentList", listManager.getStudentList());
		
		RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
		rd.forward(request, response);
	}
}
