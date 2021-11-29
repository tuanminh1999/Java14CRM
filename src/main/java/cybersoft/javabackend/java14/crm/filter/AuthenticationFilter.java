package cybersoft.javabackend.java14.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.util.UrlConst;



@WebFilter(urlPatterns = { UrlConst.ROOT })
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		if (request.getSession().getAttribute("login") != null) {
			chain.doFilter(request, response);
		} else if (UrlConst.SIGN_IN.equals(request.getServletPath())) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + UrlConst.SIGN_IN);
		}
	}

}
