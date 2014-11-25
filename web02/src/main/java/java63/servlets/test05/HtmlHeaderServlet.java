package java63.servlets.test05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* Include에 사용할 서블릿
   HTML페이지의 헤더부분의 출력을 맡는다.
 
   이거원래 jsp로만들어야했는데 별거없어서 걍 내비두ㅠㅓ*/
@WebServlet("/common/header")
public class HtmlHeaderServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		//web application 경로 알아내기~  ex) webAppPath = /web02
		String webAppPath = this.getServletContext().getContextPath();

		PrintWriter out = response.getWriter();

		
		out.println("<link rel='stylesheet'"); 
		out.println("      href='"
				+ webAppPath+ "/css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet'"); 
		out.println("      href='"
				+ webAppPath+ "/css/bootstrap-theme.min.css'>");
		out.println("<link rel='stylesheet' href='"
				+ webAppPath+"/css/common.css'>");
		
	}

}
