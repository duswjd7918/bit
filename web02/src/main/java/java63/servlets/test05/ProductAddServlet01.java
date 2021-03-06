package java63.servlets.test05;

import java.io.IOException;
import java63.servlets.test05.dao.ProductDao;
import java63.servlets.test05.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//@WebServlet("/test05/product/add")
public class ProductAddServlet01 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
	  //다음코드는 필터로 대체한다!!
      //    request.setCharacterEncoding("UTF-8");
    
    Product product = new Product();
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
 //spring에서 제공해주는고였지 ContextLoaderListenerㅋ_ㅋ ㅂㅇㅂㅇ
 /*   ProductDao productDao = (ProductDao) ContextLoaderListener.appCtx
    		.getBean("productDao");*/
    //spring의 ContextLoaderListener가 준비한 ApplicationContext객체 꺼내기
     ApplicationContext appCtx = // WebApplicationContext appCtx =     (ㅇ)
    		 WebApplicationContextUtils.getWebApplicationContext(
    				 this.getServletContext());
     
     ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
     
     
     try{
       productDao.insert(product);
     } catch (Exception e){
    	 /*Forward로 다른 서블릿에게 제어권을 위임하긔
    	  *제어권이 넘어가면 돌아오지 않는다.
    	  */
    	 RequestDispatcher rd =
 				request.getRequestDispatcher("/common/error");
    	 request.setAttribute("error",e);
 		 rd.forward(request, response);
     } 
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}

