package com.biz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServlet 클래스를 상속받아서 생성한 서블릿 클래스
 * 사용자가 Web을 통해 request를 보내면 
 * 요청을 수신해서 처리할 App의 대문 역할을 하는 클래스
 * console 환경에서 main() method가 있는 클래스와 비슷한 역할을 수행
 * 
 * 1. 사용자 web browser를 통해 request를 보내면
 * 2. 서버 컴퓨터의 네트워크를 통해서 전송된 데이터를 TomCat이 수신
 * 3. URL의 context 부분을 확인하여 현재 실행되고 있는 프로젝트가 있는지 확인
 * 4. 프로젝트에 작성되어 있는 Servlet 클래스들이 있는지 확인
 * 5. servlet의 @WebServlet() 항목에 설정된 path를 scan하여 사용자의 요청을 해당 클래스의 doGet(), doPost() method로 전달을 수행
 * 
 * tomcat은 App이 Server에 의해 실행되면 (Run As Server)
 * 1. 프로젝트에 담겨있는 모든 *.jsp 파일을 내부적으로 다시 *_jsp.java로 언어컴파일(translation)을 수행하고
 * 2. *_jsp.java를 *_jsp.class 파일로 컴파일을 수행
 * 3. 이 *_jsp.class들을 container에 리스트로 올려두고 request를 대기
 * 4. (사용자가 생성한 servlet, tomcat이 생성한 _jsp.class 모두) servlet 클래스가 있으면 이 클래스들도 모두 컴파일을 수행하고 객체로 선언, 생성하여 cotainer에 리스트로 올려두고
 * 5. web에 request가 오면 이 container 리스트에서 해당 정보를 찾아서 사용자의 요청을 처리
 * 
 * @WebServlet()
 * 사용자의 request URL(URI) 중에 path라고 하는 부분의 ID값을 설정하는 부분
 * WAS(Web App Service, Web App Server)환경에서는 클래스 이름은 외부로 직접 노출되지 않고 path에 지정된 값을 통해서 외부 접근을 허용
 * 
 * 
 * id값은 현재 프로젝트에서 유일한 값이어야 한다
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str_name = request.getParameter("str_name");	//jsp의 input box(str_name)에 담겨온 문자열을 추출하여 str_name 변수에 담기
		String str_dept = request.getParameter("str_dept");
		String str_grade = request.getParameter("str_grade");
		
		System.out.println(str_name);
		System.out.println(str_dept);
		System.out.println(str_grade);
		
		response.setContentType("text/html);charset=UTF-8");	//web에 문자열 보낼 때 한글(영어이외)문자의 encoding 설정
		
		//PrintWriter pw = response.getWriter();	// server에서 web으로 데이터를 return하는 통로 오픈
		//pw.println(str_name);
		//pw.close();
		
		String sendString = "?str_name= " + URLEncoder.encode(str_name,"UTF-8") + "&str_dept=" + URLEncoder.encode(str_dept,"UTF-8") +"&str_grade=" + URLEncoder.encode(str_grade,"UTF-8");

		response.sendRedirect("/JSP_04_Servlet/view.jsp"+sendString); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
