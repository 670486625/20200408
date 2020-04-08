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

public class SubmitHomework2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		doPost(request, response);
		System.out.println("doGet");

	}

	// 处理 POST 方法请求的方法
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		String homeworkNum = request.getParameter("homeworkNum");
		String studentName = request.getParameter("studentName");
		String homeworkContent = request.getParameter("homeworkContent");
		int newHomeNum = Integer.parseInt(homeworkNum);
		String newStudentName = new String(studentName.getBytes("ISO-8859-1"), "UTF-8");
		String newHomeworkContent = new String(homeworkContent.getBytes("ISO-8859-1"), "UTF-8");

		 System.out.println(homeworkNum+"222"+studentName+"222"+newHomeworkContent);

		// 数据库操作
		// Mario mario=new Mario();
		int i = MarioPoolHelp.marioPool.getMario();
		if (i != 99) {

			String sql = "insert into submitHomework values(null,'" + newHomeNum + "','" + newStudentName + "','"
					+ newHomeworkContent + "')";
			// System.out.println("1");
			int a = MarioPoolHelp.marioPool.marioArray[i].executeUpdate(sql);
			MarioPoolHelp.marioPool.returnMario(i);

			request.getRequestDispatcher("/jsp/uploadSuccessPage.jsp").forward(request, response);

		} else {
			request.setAttribute("message", "数据库连接池已满");
			request.getRequestDispatcher("/jsp/falsePage.jsp").forward(request, response);
		}

	}
}
