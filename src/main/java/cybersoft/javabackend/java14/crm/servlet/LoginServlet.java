package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.entity.Login;
import cybersoft.javabackend.java14.crm.repository.LoginRepository;
import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet(name = "startServlet", urlPatterns = UrlConst.LogIn)
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -9065973247091639836L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.Login).forward(req, resp);
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			LoginRepository loginRepository = new LoginRepository();
			Login l = loginRepository.checkLogIn(email, password);
			if (l == null) {
				resp.sendRedirect("login.jsp");
			} else {
				resp.sendRedirect("home.jsp");
			}
		} catch (Exception e) {
		}
	}
}
