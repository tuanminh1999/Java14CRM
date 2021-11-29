package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.service.RoleService;
import cybersoft.javabackend.java14.crm.service.UserService;
import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet(name = "auth", urlPatterns = {
		UrlConst.LOGIN,
		UrlConst.SIGN_UP,
		
})
public class AuthServlet extends HttpServlet {

	private static final long serialVersionUID = -9065973247091639836L;
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String path = request.getServletPath();
		switch (path) {
		case UrlConst.LOGIN:
			if (userService.checkLogIn(email, password) != null) {
				request.setAttribute("message", "Đăng nhập thành công");
				request.setAttribute("alert", "success");
			} else {
				request.setAttribute("message", "Đăng nhập thất bại bại");
				request.setAttribute("alert", "danger");
			}
			request.getRequestDispatcher(JspConst.LOGIN).forward(request, response);
			break;
		case UrlConst.SIGN_UP:
			request.getRequestDispatcher(JspConst.SIGN_UP).forward(request, response);
			break;
		}
	}
}
