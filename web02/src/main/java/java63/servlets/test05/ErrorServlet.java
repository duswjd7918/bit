package java63.servlets.test05;

import java.io.IOException;
import java.io.PrintWriter;
import java63.servlets.test05.dao.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/common/error")
public class ErrorServlet extends HttpServlet {

	
	// 아래의 메서드는 service(ServletRequest, ServletResponse)메서드가 호출한다.
	//GET/POST/PUT 등 모든 방식의 요청에 대해 처리하고 싶다면
	//다음과 같은 service()메서드를 재정의하라.
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ProductDao productDao = (ProductDao) this.getServletContext()
				.getAttribute("productDao");
		

		out.println("<html>");
		out.println("<head>");
		//다른 서블릿을 실행->실행 후 제어권이 되돌아온다.
		RequestDispatcher rd =
				request.getRequestDispatcher("/common/header");
		rd.include(request, response);
    	out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<p>잠시 후 다시 시도해주십쇼 ^^.....from error servlet</p>");

      
        //out.println("<script src='../../js/jquery-1.11.1.js'></script>");
      
        //다른 서블릿을 실행->실행 후 제어권이 되돌아온다.
  		rd =request.getRequestDispatcher("/common/footer");
  		rd.include(request, response);
        out.println("</div>");
  		out.println("</body>");
        out.println("</html>");
      
        //오류에대한 자세한 정보는...콘솔창에 출력하라... (사용자에겐 비밀@!)
        Exception e = (Exception) request.getAttribute("error");
        e.printStackTrace();
	}
}
