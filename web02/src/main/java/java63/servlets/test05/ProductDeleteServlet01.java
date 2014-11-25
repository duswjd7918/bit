/* Redirect!
 => 클라이언트에게 콘텐츠를 보내지 않느다.
 => 응답헤더에 다시요청할 주소를 보낸다.
 
 */
package java63.servlets.test05;

import java.io.IOException;
import java.io.PrintWriter;

import java63.servlets.test05.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


//@WebServlet("/test05/product/delete")
public class ProductDeleteServlet01 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  //SqlSessionFactory sqlSessionFactory;
 
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    
	  int no = Integer.parseInt(request.getParameter("no"));
    //ContextLoaderListener.productDao.delete(no);
        
	    ApplicationContext appCtx =
	            WebApplicationContextUtils.getWebApplicationContext(
	                this.getServletContext());
	        
	        ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
    productDao.delete(no);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet' href='../../css/common.css'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>삭제 결과</h1>");
    out.println("<p>삭제하였습니다</p>");
    out.println("</div>");
    
    out.println("</body>");
    out.println("</html>");
   
    /* Redirect는 클라이언트에 재요청 URL만 보낸다.
     * 따라서ㅓㅓㅓ 이전에  출력한 컨턴츠는 취소한다.
     * 즉, 버퍼에 출력된 내용은 클라이언트로 보내지않구 버린다.
     * 위의 출력문은 작성할 필요가읎다.*/
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
    
    
  }
  
}