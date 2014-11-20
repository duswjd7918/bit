package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/help")
public class HelpServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//<-방법2
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");

		out.println("<p> help</p>");
		out.println("<p> list?pageNo=페이지번호&pageSize=페이지사이즈 </p>");
		out.println("<p> view?no=제품번호</p>");
		out.println("<p> add?name=제품이름&qty=제품수량&mkno=메이커번호</p>");
		out.println("<p> delete?no=제품번호</p>");
		out.println("<p> update?no=제품번호</p>");

		out.println("</body>");
		out.println("</html>");


	}

}
