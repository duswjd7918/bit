package java63.servlets.test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* Web browser에게 출력하기 ^ㅡ^  
 * 
 * ServletRequest  = >  요청 정보를 다루는 도구.
 * ServletResponse = >  응답 정보를 다루는 도구
 * 
 * 
 * */
@WebServlet("/test01/Test01")
public class Test01 extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		//1.ServletResponse도구를 사용하여 출력스트림을 준비한다.
		PrintWriter out = response.getWriter();
		
		//2.출력스트림을 사용하여 ==> 웹 브라우저로 출력한당
		out.println("아하~~!~ 안녕하세요?  Hello, 곤니찌와, ");
	}

}
//결과는 한글깨짐--ㅋㅋㅋ