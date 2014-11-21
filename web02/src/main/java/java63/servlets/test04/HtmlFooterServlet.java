package java63.servlets.test04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* Include에 사용할 서블릿
  
  HTML페이지의 헤더부분의 출력을 맡는다.
*/
@WebServlet("/common/footer")
public class HtmlFooterServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		//web application 경로 알아내기~  ex) webAppPath = /web02
		String webAppPath = this.getServletContext().getContextPath();

		PrintWriter out = response.getWriter();

		out.println("<p><address class='copyright'> Copyright&copy;Java63 </address></p>");
		
		//HTML Entity=> HTML의 상수값.
		//ex.   &amp; => &
		//      &lt;  => <
		//      &gt;  => >
		//      &copy;=> (C)
		//      &reg; => (R)
		//      &yen; =>엔화
	}
}
