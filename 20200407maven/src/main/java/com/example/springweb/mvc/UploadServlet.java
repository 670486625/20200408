package com.example.springweb.mvc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import jdbc.Mario;
import jdbc.MarioPool;
import jdbc.MarioPoolHelp;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������Ӧ��������
		doPost(request, response);
		System.out.println("doGet");
		
		
	}
	

	// ���� POST ��������ķ���
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String homeworkName = request.getParameter("homeworkName");
		String homeworkContent = request.getParameter("homeworkContent");
		String newHomeworkName = new String(homeworkName.getBytes("ISO-8859-1"),"UTF-8");
		String newHomeworkContent = new String(homeworkContent.getBytes("ISO-8859-1"),"UTF-8");
		
		//���ݿ����
		//Mario mario=new Mario();
		int i=MarioPoolHelp.marioPool.getMario();
		if(i!=99) {
			
			String sql = "insert into homework values(null,'" + newHomeworkName + "','" + newHomeworkContent + "')";
			//System.out.println("1");
			int a = MarioPoolHelp.marioPool.marioArray[i].executeUpdate(sql);
			 MarioPoolHelp.marioPool.returnMario(i);
			
			request.getRequestDispatcher("/jsp/uploadSuccessPage.jsp").forward(request, response);
			
		}else {
			request.setAttribute("message","���ݿ����ӳ�����");
			request.getRequestDispatcher("/jsp/falsePage.jsp").forward(request, response);
		}
	     
		
	}
}
