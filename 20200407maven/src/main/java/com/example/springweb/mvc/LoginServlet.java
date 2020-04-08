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

public class LoginServlet extends HttpServlet {
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
		String username = request.getParameter("userName");
		//System.out.println(username);
		String password = request.getParameter("userPassword");
		String newUsername = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		//System.out.println(newUsername);
		String newPassword = new String(password.getBytes("ISO-8859-1"),"UTF-8");
		
		//���ݿ����
		//Mario mario=new Mario();
		int i=MarioPoolHelp.marioPool.getMario();
		if(i!=99) {
			String sql="select * from member where memberName="+"'"+newUsername+"'";//�����ѯ���
			//System.out.println(sql);
		     ResultSet rs=MarioPoolHelp.marioPool.marioArray[i].executeQuery(sql);//ִ��sql���
		     MarioPoolHelp.marioPool.returnMario(i);
		     //ֻ�ж�һ������
		     try {
				if(rs.next())
				 {
				     if(newPassword.equals(rs.getObject("memberPassword"))){
				    	 //����session
				    	 HttpSession session = request.getSession();
				    	 session.setAttribute("myName", newUsername);
				    	 request.setAttribute("name",newUsername);
							request.getRequestDispatcher("/jsp/successfulPage.jsp").forward(request, response);
				     }
				     else{
				    	request.setAttribute("message","�������");
						request.getRequestDispatcher("/jsp/falsePage.jsp").forward(request, response);
						
				     }
				 }else{
					 request.setAttribute("message","�޴��˺�");
					 request.getRequestDispatcher("/jsp/falsePage.jsp").forward(request, response);
					 
				 }
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		}else {
			request.setAttribute("message","���ݿ����ӳ�����");
			request.getRequestDispatcher("/jsp/falsePage.jsp").forward(request, response);
		}
	     
		
	}
}
