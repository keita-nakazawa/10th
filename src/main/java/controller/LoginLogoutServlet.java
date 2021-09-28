package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginManager;
import model.Staff;

@WebServlet("/LoginLogoutServlet")
public class LoginLogoutServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログイン処理
		String staffId = request.getParameter("staffId");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		
		LoginManager loginManager = new LoginManager();
		Staff staff = loginManager.loginUser(staffId, pass);

		loginManager.loginOrNot(staff, session, request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログアウト処理
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
}
