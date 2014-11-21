package java63.servlets.test03;
//서블릿생성!
//클라이언트가 요청했을 때 생성된다.
	
//쿨라이언트 요청이 없더라도 강제로 서블릿을 생성하는ㄴ방법
//=>웹어플리케이션을 시작할 때 생성된다.
//=>배치설정에 다음을 추가한다.  <load-on-startup>1</load-on-startup>
	//태그에 주는 숫자는 실행순서를 의미한다.
	//여러개의 서블릿이 있을 떄 작은 수를 갖는 서블릿이 먼저 생성된다.
/*<servlet>
  <servlet-name>Hello</servlet-name>
  <servlet-class>java63.servlets.Hello</servlet-class> 
  <load-on-startup>1</load-on-startup>
</servlet>
	*/
import java.io.IOException;
import java.io.InputStream;
import java63.servlets.test03.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*@WebServlet(
		//name="AppInit",
		loadOnStartup=1
		)*/
public class AppInitServlet extends GenericServlet {
	
	private static final long serialVersionUID = 8309254850072708414L;

	public static ProductDao productDao;
	public AppInitServlet(){
		System.out.println("AppInitServlet 생성됨.");
	}
	
	/*외부자원을 참조하는 경우,
	가능한 하드코딩하지말고 설정파일에서  "읽어오는 방식"으로 처리해
	
	설정파일? web.xml
			설정방법은?
				<servlet>
					<servlet-name>... </servlet-name>
					<servlet-class>...</servlet-class>
					<init-param>
						<param-name>키</param-name>
						<param-value>값</param-value>
					</init-param>
				</servlet>
			 설정한 값을 꺼내는 방법은?
			 ServletConfig의 getInitParameter("키")
	*/
	@Override
	public void init() throws ServletException {
		try {
		      InputStream inputStream = 
		    		  Resources.getResourceAsStream(
		    				  this.//getServletConfig().
		    				  getInitParameter("mybatisConfig"));
		      SqlSessionFactory sqlSessionFactory = 
		          new SqlSessionFactoryBuilder().build(inputStream);
		      
		      productDao = new ProductDao();
		      productDao.setSqlSessionFactory(sqlSessionFactory);
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
	
	
	//URL 없으니 실행되지 않을 메서드임!!!!!!!
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {	}

}
