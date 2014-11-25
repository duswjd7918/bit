package java63.servlets.test04;

import java.io.IOException;
import java.io.PrintWriter;

import java63.servlets.test04.dao.ProductDao;
import java63.servlets.test04.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test04/product/list")
public class ProductListServlet extends GenericServlet {

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
		/*ProductDao productDao = (ProductDao) this.getServletContext()
				.getAttribute("productDao");*/
		ProductDao productDao = (ProductDao) ContextLoaderListener.appCtx
	    		.getBean("productDao"); //Spring에서꺼내 ㅋ ㅋ 
		

		out.println("<html>");
		out.println("<head>");
		//다른 서블릿을 실행->실행 후 제어권이 되돌아온다.
		RequestDispatcher rd =
				request.getRequestDispatcher("/common/header");
		rd.include(request, response);
		  out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<h1>제품목록</h1>");
		out.println("<p><a href='product-form.html' class='btn btn-info'> ㅅ ㅐ ㅈ ㅔ 품</a></p>");
		out.println("<table class='table table-hover'>");
		out.println("<tr>");
		out.println(" <th>#</th><th>제품</th><th>수량</th><th>제조사</th>");
		out.println("</tr>");
		 for (Product product : productDao.selectList(pageNo, pageSize)) {
		      out.println("<tr>");
		      out.println("  <td>" + product.getNo() + "</td>");
		      out.println("  <td><a href='view?no="
		      		+product.getNo()+ "'>"+ product.getName() + "</a></td>");
		      out.println("  <td>" + product.getQuantity() + "</td>");
		      out.println("  <td>" + product.getMakerNo() + "</td>");
		      out.println("</tr>");
		    }
        out.println("</table>");
        out.println("</div>");
        out.println("<script src='../../js/jquery-1.11.1.js'></script>");
      
        out.println("</body>");
      //다른 서블릿을 실행->실행 후 제어권이 되돌아온다.
      		rd =request.getRequestDispatcher("/common/footer");
      		rd.include(request, response);
      
        out.println("</html>");
        System.out.println("servie()실행 완료");

	}
}
