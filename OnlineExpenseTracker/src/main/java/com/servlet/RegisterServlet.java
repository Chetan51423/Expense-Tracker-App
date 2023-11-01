package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data_access_object.UserDao;
import com.entity.User;
import com.db.HibernateUtil;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet 
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		String about = req.getParameter("about");
		
		User u = new User(fullname, email, password, about);
		
		UserDao dao= new UserDao(HibernateUtil.getSessionFactory());
		
		boolean f = dao.saveuser(u);
		HttpSession session = req.getSession();
		if(f)
		{
			session.setAttribute("msg", "Save successfully");
			res.sendRedirect("Register.jsp");
			
		}
		else {
			session.setAttribute("msg", "Something is wrong on server");
			res.sendRedirect("Register.jsp");
					}
		
	}
}
