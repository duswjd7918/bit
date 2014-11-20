package java63.servlets.test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* 한글 출력할 때 깨지는 문제 해결하자!
 * 
 * 이유: ServletResponse가 준 출력 스트림은 
 *		기본적으로 출력할 때 ISO-8859-1로 인코딩한다.
 * 한글은 ISO-8859-1 문자 집단에 없기 때문에   ?물음표로 대체하여 출력.
 * 
 * 해결책:ServletResponse로 부터 출력 스트림을 얻기 전에 
 * 		출력할 내용의 타입과 문자집합을 설정한다.
 *  ---> response.setCharacterEncoding("UTF-8");
 *  ---> response.setContentType("text/plain;charset=UTF-8")
 *  
 *  MIME => 콘텐츠의 타입을 표현
*/
@WebServlet("/test01/Test02")
public class Test02 extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
	
		//response.setCharacterEncoding("UTF-8"); //<-방법1
		response.setContentType("text/plain;charset=UTF-8");//<-방법2
		//.......................▲MIME tpye...▲인코딩문자
		PrintWriter out = response.getWriter();
		
		out.println("아하~~!~ 안녕하세요?  Hello, 곤니찌와, ");
	}

}
