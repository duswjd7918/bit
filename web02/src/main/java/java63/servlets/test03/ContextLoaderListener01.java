package java63.servlets.test03;
/* ServletContextListener는
 * 웹 어플리케이션이 시작하거나 종료하는 이벤트에대해 작업수행한다.
 * 
 * 컨텍스트 파라미터란?
 *  웹 어플리케이션에서 사용할 환경변수 정의할 때 사용
 *  모든 서블릿ㅇㅣ 사용할 수 있다.
 *  
 *  설정방법? web.xml에 다음과 같이 설정한다.
 *  <context-param>
 *  	<param-name>키</param-name>
 *      <param-value>값</param-value>
 *  </context-param>
 *  
 *  사용방법?
 *  ServletContext의 getInitParameter(키)호출!
 *  */
import java.io.InputStream;
import java63.servlets.test03.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//@WebListener
public class ContextLoaderListener01 implements ServletContextListener {//Spring MVC에 있는 크래슈?이름
	//Context: webApp이란겨
	//ContextLoader: Context의 실행환경?을 로드해주는 ㅈ ㅏ.

	public static ProductDao productDao;
	

	
	//웹어플리케이션이 시작할 때 호출됨.
	//=> 서블릿이 사용할 공통자원을 준비
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {
			  ServletContext ctx = sce.getServletContext();
		      InputStream inputStream = 
		    		  Resources.getResourceAsStream(
		    				  ctx.//getServletConfig().
		    				  getInitParameter("mybatisConfig"));
		      SqlSessionFactory sqlSessionFactory = 
		          new SqlSessionFactoryBuilder().build(inputStream);
		      
		      productDao = new ProductDao();
		      productDao.setSqlSessionFactory(sqlSessionFactory);
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}

	//웹어플리케이션이 종료할때 홓출됨.
	//서블릿이 사용한 자원을 해제할때
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	} 

}
