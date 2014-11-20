package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/product/list")
public class ProductListServlet extends GenericServlet{

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
		

		int pageNo =0;
		int pageSize = 0;
		
	    if (request.getParameter("pageNo") != null) {
	      pageNo = Integer.parseInt((String)request.getParameter("pageNo"));
	      pageSize = 3;
	    }
	    
	    if (request.getParameter("pageSize") != null) {
	      pageSize = Integer.parseInt((String)request.getParameter("pageSize"));
	    }
	    
	    
	    out.println("<html>");
		out.println("<body>");
	    for (Product product : productDao.selectList(pageNo, pageSize)) {
	      
			out.println(product.getNo()+"   ");
			out.println(product.getName()+"   ");
			out.println(product.getQuantity()+"   ");
			out.println(product.getMakerNo()+"   ");
			out.println("<br>");
			
	    }
	    
	    out.println("</body>");
		out.println("</html>");

	}

}
