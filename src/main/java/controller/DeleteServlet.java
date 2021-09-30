package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeleteManager;
import DAO.ListManager;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DBから学生情報削除
		DeleteManager deleteManager = new DeleteManager();
		HttpSession session = request.getSession();
		deleteManager.deleteStudent(session);
		
		//session内の学生名簿一覧を更新
		ListManager listManager = new ListManager();
		session.setAttribute("studentList", listManager.getStudentList());
		
		RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
		rd.forward(request, response);
	}
}
