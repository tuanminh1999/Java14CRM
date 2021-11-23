package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.service.UserService;
import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet(name="userServlet", urlPatterns = {
		UrlConst.USER_LIST,
		UrlConst.CREATE_USER
})
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = -4224315611215393558L;
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case UrlConst.USER_LIST:
			request.setAttribute("users", userService.getUser()); 
			request.getRequestDispatcher(JspConst.USER_LIST).forward(request, response);
			break;
		case UrlConst.CREATE_USER:
			request.getRequestDispatcher(JspConst.CREATE_USER).forward(request, response);
			break;
		}
	}
}
