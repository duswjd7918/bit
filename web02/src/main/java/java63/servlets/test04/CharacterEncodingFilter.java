package java63.servlets.test04;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	FilterConfig filterConfig;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {
		//다음 필터를 실행하기 전에 해야할 일
		request.setCharacterEncoding(filterConfig.getInitParameter("charset"));
		System.out.println("요청데이터 한글 UTF-8 설정 완료!");
		
		//다음 필터 실행하기 (Filter도 annotation처리할 수 있ㄷㅏ.그치만 ㄴㄴ)
		//단, 더 이상 다음 필터가 없으면 Tomcat server는 해당 servlet을 실행한다.
		nextFilter.doFilter(request, response);
		
		//다음 필터 또는 서블릿의 service()를 실행한 후 해야할 일
		System.out.println("CharacterEncodingFilter 필터 나 가 기");
	}

	@Override
	public void destroy() {	}

}
