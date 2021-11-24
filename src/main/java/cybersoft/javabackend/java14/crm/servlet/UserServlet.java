package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.entity.User;
import cybersoft.javabackend.java14.crm.service.RoleService;
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
	private RoleService roleService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userService = new UserService();
		roleService = new RoleService();
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
			request.setAttribute("roles", roleService.getRole());
			request.getRequestDispatcher(JspConst.CREATE_USER).forward(request, response);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		user.setPassword(password);
		user.setPhone(phone);
		user.setRoleId(roleId);
		
		if(userService.addUser(user)) {
			request.setAttribute("message", "Thêm thành công");
			request.setAttribute("alert", "success");
		}else {
			request.setAttribute("message", "Thêm thất bại công");
			request.setAttribute("alert", "danger");
		}
		request.setAttribute("roles", roleService.getRole());
		request.getRequestDispatcher(JspConst.CREATE_USER).forward(request, response);
	}
}
