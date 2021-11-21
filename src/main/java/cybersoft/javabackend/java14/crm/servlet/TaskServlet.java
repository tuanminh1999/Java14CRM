package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.utils.JspConst;
import cybersoft.javabackend.java14.crm.utils.UrlConst;

@WebServlet(name="taskServlet", urlPatterns = {
		UrlConst.TASK
})
public class TaskServlet extends HttpServlet{

	private static final long serialVersionUID = -4094289534816596435L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(JspConst.TASK).forward(request, response);
	}
}
