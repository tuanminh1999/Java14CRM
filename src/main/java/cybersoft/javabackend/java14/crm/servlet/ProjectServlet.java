package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet(name="projectServlet", urlPatterns = {
		UrlConst.CREATE_PROJECT,
		UrlConst.MANAGE_PROJECT
})
public class ProjectServlet extends HttpServlet{

	private static final long serialVersionUID = 5101353279731457467L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case UrlConst.CREATE_PROJECT:
			request.getRequestDispatcher(JspConst.CREATE_PROJECT).forward(request, response);
			break;
		case UrlConst.MANAGE_PROJECT:
			request.getRequestDispatcher(JspConst.MANAGE_PROJECT).forward(request, response);
			break;
		}
	}
}
