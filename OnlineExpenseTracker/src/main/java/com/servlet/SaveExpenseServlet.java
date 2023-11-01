package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data_access_object.ExpenseDao;
import com.data_access_object.UserDao;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;

/**
 * Servlet implementation class saveServlet
 */
@WebServlet("/saveExpense")
public class SaveExpenseServlet extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		
		HttpSession session = req.getSession();
		
		User u = (User)session.getAttribute("loginUser");
		Expense ex = new Expense(title, date, time, description, price, u);
		
		
		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f = dao.saveExpense(ex);
		
		
		
		if(f)
		{
			session.setAttribute("msg", "Expense Added successfully");
			res.sendRedirect("user/addExpense.jsp");
			
		}
		else {
			session.setAttribute("msg", "Something is wrong on server");
			res.sendRedirect("user/addExpense.jsp");
					}
		
	}
}
