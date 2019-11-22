package com.biz.hello.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View_01
 * 
 * 
 * 
 * /view/01: URI, java Web에서는 path라고 함
 * /view: view path, 01 view path router라고 함
 * 
 */
@WebServlet("/view/01")
public class View_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_01() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		
		String strName = request.getParameter("strName");
		
		response.setStatus(404);			// httpCode를 임의로 response에 세팅
		
		/*
		 * httpCode
		 * server에서 webborwser에게 데이터를 보내기 전 현재 서버의 상태가 어떠한지
		 * 숫자값으로 전송해 네트워크의 성능을 높이는 용도로 시용
		 * 
		 * 2xx: 정상 데이터를 추출 중이니 기다릴 것
		 * 3xx: 이전 상태와 유사, 동일하니 너에게 줄 것이 없다
		 * 4xx: 요청사항이 잘못 전달
		 * 404: Not Found
		 * 400: Query data를 request.getParameter()로 받았으나 문제가 있음
		 * 5xx: 서버 App이 작동되는 과정에서 Exception이 발생
		 * 
		 * 
		 */
		
		PrintWriter pw = response.getWriter();
		pw.println("나는 view01 입니다");
		pw.printf("나는 %s입니다", strName);
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
