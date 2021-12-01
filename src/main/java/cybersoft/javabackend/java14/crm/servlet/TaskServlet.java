package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.service.TaskService;
import cybersoft.javabackend.java14.crm.service.UserService;
import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet(name="taskServlet", urlPatterns = {
		UrlConst.TASK_LIST,
		UrlConst.CREATE_TASK
})
public class TaskServlet extends HttpServlet{

	private static final long serialVersionUID = -4094289534816596435L;
	private TaskService taskService;
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		taskService = new TaskService();
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		switch (path) {
		case UrlConst.TASK_LIST:
//			if (request.getParameter("id") != null) {
//				int userId = Integer.parseInt(request.getParameter("id"));
//				userService.deleteUser(userId);
//			}
			request.setAttribute("tasks", taskService.getTask());
			request.setAttribute("users", userService.getUser());
			request.getRequestDispatcher(JspConst.TASK_LIST).forward(request, response);
			break;
		case UrlConst.CREATE_TASK:
//			if (request.getParameter("id") != null) {
//				int userId = Integer.parseInt(request.getParameter("id"));
//				request.setAttribute("user", userService.findOneByUserId(userId));
//			}
//			request.setAttribute("roles", roleService.getRole());
			request.getRequestDispatcher(JspConst.CREATE_TASK).forward(request, response);
			break;
		}
		//request.getRequestDispatcher(JspConst.TASK_LIST).forward(request, response);
	}
}
