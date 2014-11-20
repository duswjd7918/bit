package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/product/delete")
public class ProductDeleteServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//<-방법2
		PrintWriter out = response.getWriter();

		ProductDao productDao= null;
		try{
			productDao= new ProductDao();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		 int no = Integer.parseInt((String)request.getParameter("no"));
	    
	    Product product = productDao.selectOne(no);
	    
	    out.println("<html>");
		out.println("<body>");
	    if (product == null) {
	      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
	      out.println("</body>");
		  out.println("</html>");
	      return;
	    }
	    
	    
	    productDao.delete(no);
	    out.println("<p>삭제하였습니다.<p>");
	   
		out.println("</body>");
		out.println("</html>");


	}

}