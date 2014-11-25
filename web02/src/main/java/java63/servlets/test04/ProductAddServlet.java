package java63.servlets.test04;

import java.io.IOException;

import java63.servlets.test04.dao.ProductDao;
import java63.servlets.test04.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test04/product/add")
public class ProductAddServlet extends GenericServlet {
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
    
    //AppInitServlet.productDao.insert(product); ←방법1   ↓ 방법2
    //ContextLoaderListener.productDao.insert(product);
    //방법3 ↓  ProductDao를 ServletContext보관소에서 꺼내는 방식 사용
    // 단점이있다면.. 방법1.2보다 코드가 늘었긔...
    // 장점!  특정 클래스에 종속되지 않는다. 유지보수에 좋다 THIS is BETTER!
    /*ProductDao productDao = (ProductDao) this.getServletContext()
    									.getAttribute("productDao");*/
    
    ProductDao productDao = (ProductDao) ContextLoaderListener.appCtx
    		.getBean("productDao");
     try{
       productDao.insert(product);
     }catch (Exception e){
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

