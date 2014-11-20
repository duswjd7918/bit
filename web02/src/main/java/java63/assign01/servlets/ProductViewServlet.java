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

@WebServlet("/product/view")
public class ProductViewServlet extends GenericServlet{
	/*ProductDao productDao;
	Product product;
	*/

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//<-방법2
		
		PrintWriter out = response.getWriter();
		Product product = null;
		ProductDao productDao= null;
		
		try{
			productDao= new ProductDao();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		int no = Integer.parseInt(request.getParameter("no"));
		product = productDao.selectOne(no);

		out.println("<html>");
	    out.println("<body>");
		if (product == null) {
		      out.println("<p>해당 번호의 제품 정보를 찾을 수 없습니다.</p>");
		      out.println("</body>");
			  out.println("</html>");
		      return;
		}
		    
		    out.println("<p>제품번호: " + no +"</p>");
		    out.println("<p>제품명: " + product.getName()+"</p>");
		    out.println("<p>수량: " + product.getQuantity()+"</p>");
		    out.println("<p>제조사 번호: " + product.getMakerNo()+"</p>");
		    out.println("</body>");
		    out.println("</html>");
	}

}