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

@WebServlet("/product/add")
public class ProductAddServlet extends GenericServlet{

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
		
		
		
		out.println("<html>");
		out.println("<body>");
	    try {
	      Product product = new Product();
	      product.setName((String)request.getParameter("name"));
	      product.setQuantity(Integer.parseInt((String)request.getParameter("qty")));
	      product.setMakerNo(Integer.parseInt((String)request.getParameter("mkno")));
	      
	      productDao.insert(product);
	      out.println("<p>저장하였습니다.</p>");
	     
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	     
	      out.println("<p>서버가 바쁩니다. 잠시 후 다시 시도하세요.</p>");
	     
	    }
	    out.println("</body>");
		out.println("</html>");
		
	}

}