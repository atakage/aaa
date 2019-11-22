package com.biz.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/come")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Welcome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html;charset=UTF-8");	//지금부터 browser로 전송되는 데이터는 text/html 문서이고 utf-8 방식으로 encoding해 취급

		PrintWriter pw = response.getWriter(); // response 객체는 server에서 webbrowser로 연결되는 통로와 정보를 가지고 있음
		// response로부터 writer객체를 요청하는데
		// 이 writer 객체는 서버에서 어떤 데이터를 webbrowser로 보내는 통로로 사용이 됨

		pw.println("<body>");

		pw.println("<h2>우리집에 오신 것을 환영합니다</h2>");
		pw.println("<p>나는 servlet에서 보내는 메시지이니다</p>");

		pw.println("</body>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
