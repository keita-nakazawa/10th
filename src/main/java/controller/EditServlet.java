package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Memo;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNumber = request.getParameter("studentNumber");
		String studentName = request.getParameter("studentName");
		String memoText = request.getParameter("memo");
		
		HttpSession session = request.getSession();
		Memo memo = (Memo)session.getAttribute("memo");
		
		
		
		
		if(memoText.equals(memo.getMemo()) == false) {
			//メモ作成者更新処理
			
			
			//memoTextが無記入、かつmemoがnullの場合はtrue? false?
		}
	}

}
