/* Redirect!
 => 클라이언트에게 콘텐츠를 보내지 않느다.
 => 응답헤더에 다시요청할 주소를 보낸다.
 
 */
package java63.servlets.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java63.servlets.test02.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


@WebServlet("/test02/product/delete")
public class ProductDeleteServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  SqlSessionFactory sqlSessionFactory;
  ProductDao productDao;
  
  public ProductDeleteServlet() {
    try {
      String resource = "java63/servlets/test02/dao/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      productDao = new ProductDao();
      productDao.setSqlSessionFactory(sqlSessionFactory);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
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
    
    /* Redirect의 응답내용
     * -> Location헤더에 재요청 URL이 있다.
     * ->client에 어떤 내용을 출력하지 않고
     *   페이지를  바로 전환하는 효과를 내구싶을때 쓰는거야 ~
HTTP/1.1 302 Found
Server: Apache-Coyote/1.1
Location: http://192.168.0.120:8080/web02/test02/product/list
Content-Type: text/html;charset=UTF-8
Content-Length: 0
Date: Thu, 20 Nov 2014 06:40:18 GMT
     *   
     *   
     *
     * */
  }
  
}