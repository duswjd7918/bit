package java63.servlets.test04;

import java.io.IOException;
import java.io.PrintWriter;
import java63.servlets.test04.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/common/error")
public class ErrorServlet extends GenericServlet {

	private static final long serialVersionUID = -7118904807595837783L;
	static final int PAGE_DEFAULT_SIZE=3;
	
	//SqlSessionFactory sqlSessionFactory;	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service()실행 시작.");
		int pageNo = 0;
		int pageSize=0;
		
		if(request.getParameter("pageNo")!=null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize=PAGE_DEFAULT_SIZE;
		}
		if(request.getParameter("pageSize")!=null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		
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
		out.println("<p>잠시 후 다시 시도해주십쇼 ^^.....</p>");

      
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
