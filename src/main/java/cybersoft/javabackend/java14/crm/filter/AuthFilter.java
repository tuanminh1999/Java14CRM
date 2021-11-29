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

import cybersoft.javabackend.java14.crm.entity.User;
import cybersoft.javabackend.java14.crm.util.SessionUtil;
import cybersoft.javabackend.java14.crm.util.UrlConst;



@WebFilter(urlPatterns = { UrlConst.ROOT })
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String url = request.getRequestURI(); // lấy link hiện tại đang request vào.
		User user = ((User) SessionUtil.getInstance().getValue(request, "login"));
		// MEMBER
		if (url.startsWith(request.getContextPath()+UrlConst.CREATE_PROJECT) ||
				url.startsWith(request.getContextPath()+UrlConst.MANAGE_PROJECT) ||
				url.startsWith(request.getContextPath()+UrlConst.CREATE_USER) ||
				url.startsWith(request.getContextPath()+UrlConst.USER_LIST)) {
			if (user != null) {
				if(user.getRole().getName().equalsIgnoreCase("MEMBER")) {
					response.sendRedirect(request.getContextPath() + UrlConst.HOME);
				} else if ((user.getRole().getName().equalsIgnoreCase("LEADER") && (url.startsWith(request.getContextPath()+UrlConst.CREATE_PROJECT) ||
						url.startsWith(request.getContextPath()+UrlConst.MANAGE_PROJECT)))){
					response.sendRedirect(request.getContextPath() + UrlConst.HOME);
				}else {
					chain.doFilter(request, response);
				}
			}else {
				response.sendRedirect(request.getContextPath() + UrlConst.SIGN_IN);
			}
		} 
		else {
			if (request.getSession().getAttribute("login") != null) {
				chain.doFilter(request, response);
			} else if (UrlConst.SIGN_IN.equals(request.getServletPath())) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + UrlConst.SIGN_IN);
			}
		}

		
	}

}
