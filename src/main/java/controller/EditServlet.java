package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EditManager;
import DAO.ListManager;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//フォームに入力された学生情報とメモの取得
		String newStudentNumber = request.getParameter("studentNumber");
		String newStudentName = request.getParameter("studentName");
		String newMemoText = request.getParameter("memoText");
		
		//sessionに元々格納されていた学生情報とメモの取得
		HttpSession session = request.getSession();
		String oldStudentNumber = (String)session.getAttribute("studentNumber");
		String oldStudentName = (String)session.getAttribute("studentName");
		String oldMemoText = (String)session.getAttribute("memoText");
		
		//フォーム入力内容とsessionを比較し、必要に応じてDBとsession内の学生情報・メモを更新
		EditManager editManager = new EditManager();
		editManager.changeMemo(newMemoText, oldMemoText, session);
		editManager.changeStudentNumber(newStudentNumber, oldStudentNumber, session);
		editManager.changeStudentName(newStudentName, oldStudentName, session);
		
		//session内の学生名簿一覧を更新
		ListManager listManager = new ListManager();
		session.setAttribute("studentList", listManager.getStudentList());
		
		RequestDispatcher rd = request.getRequestDispatcher("studentDetail.jsp");
		rd.forward(request, response);
	}
}
