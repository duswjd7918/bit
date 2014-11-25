package java63.servlets.test04;
/* 공통으로 사용하는 자원은 보통 ServletContext에 보관한다.
 * 
 * ServletContext : 웹 애플리케이션 시작 시 생성되어 종료하면 제거된다.
 * HttpSession    : 최초 요청 시 생성. 타임아웃 또는 무효화 명령 시 제거된다.
 * HttpServletRequest: 요청 때 마다 생성. 응답 후 제거됨.
 * PageContext    : JSP에서 사용됨. 각 JSP 실행할 때 마다 생성되구 
 * 					실행 완료되면 제거됨.
 * */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {//Spring MVC에 있는 크래슈?이름
	//Context: webApp이란겨 //ContextLoader: Context의 실행환경?을 로드해주는 ㅈ ㅏ.
	static ApplicationContext appCtx;
	
	
	//웹어플리케이션이 시작할 때 호출됨.
	//=> 서블릿이 사용할 공통자원을 준비
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {
			appCtx = new ClassPathXmlApplicationContext(
		 			 new String[]{"java63/servlets/test04/application-context.xml"});
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
