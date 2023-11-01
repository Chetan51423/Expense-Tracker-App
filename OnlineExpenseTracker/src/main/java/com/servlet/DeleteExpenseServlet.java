package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data_access_object.ExpenseDao;
import com.db.HibernateUtil;
import com.entity.Expense;


@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		int id  = Integer.parseInt(req.getParameter("id"));
		
		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f = dao.deleteExpense(id);
		
		HttpSession session = req.getSession();		
		if(f)
		{
			session.setAttribute("msg", "Expense Deleted successfully");
			res.sendRedirect("user/viewExpense.jsp");
			
		}
		else {
			session.setAttribute("msg", "Something is wrong on server");
			res.sendRedirect("user/viewExpense.jsp");
					}
	}
}
