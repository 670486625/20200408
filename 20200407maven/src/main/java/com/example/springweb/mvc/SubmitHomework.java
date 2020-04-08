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

public class SubmitHomework extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		doPost(request, response);
		System.out.println("doGet");
		
		
	}
	

	// 处理 POST 方法请求的方法
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		
		
		int i=MarioPoolHelp.marioPool.getMario();
		if(i!=99) {
			String sql="select * from homework";//定义查询语句
			ResultSet rs=MarioPoolHelp.marioPool.marioArray[i].executeQuery(sql);
			 MarioPoolHelp.marioPool.returnMario(i);
			
			int[] homeworkNumSet=new int[100];
			int homeworkNumSetNum=0;
			String[] homeworkNameSet=new String[100];
			int homeworkNameSetNum=0;
			String[] homeworkContentSet=new String[100];
			int homeworkContentSetNum=0;
			
			try {
				while(rs.next()) {
					//System.out.println((String) rs.getObject("homeworkName"));
					homeworkNumSet[homeworkNumSetNum]=(int) rs.getObject("homeworkNum");
					homeworkNumSetNum++;
					homeworkNameSet[homeworkNameSetNum]=(String) rs.getObject("homeworkName");
					homeworkNameSetNum++;
					homeworkContentSet[homeworkContentSetNum]=(String) rs.getObject("homeworkContent");
					homeworkContentSetNum++;
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			request.setAttribute("homeworkNumSet",homeworkNumSet);
			request.setAttribute("homeworkNameSet",homeworkNameSet);
			request.setAttribute("homeworkContentSet",homeworkContentSet);
			
			request.getRequestDispatcher("/jsp/submitHomework.jsp").forward(request, response);
			
		}else {
			request.setAttribute("message","数据库连接池已满");
			request.getRequestDispatcher("/jsp/falsePage.jsp").forward(request, response);
		}
		
	    
	     
		
	}
}

