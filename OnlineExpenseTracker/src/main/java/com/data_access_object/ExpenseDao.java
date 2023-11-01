package com.data_access_object;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.criteria.From;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Where;
import org.hibernate.query.Query;

import com.entity.Expense;
import com.entity.User;

//import antlr.collections.List;
//import java.util.*;

public class ExpenseDao {

	private SessionFactory factory=null;
	private Session session = null;
	private Transaction tx = null; 
	
	
	public ExpenseDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public boolean saveExpense(Expense expense )
	{
		boolean f=false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(expense);
			tx.commit();
			f=true;
		} catch (Exception e) {
			if(tx!=null)
			{
				tx.commit();
				f=true;
			}
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public List<Expense> getAllExpenses(User user) {
	    List<Expense> list = new ArrayList<Expense>();
	    
	    try {
	        session = factory.openSession();
	        
	        // Correct the HQL query, and bind the parameter :us to the user object.
	        Query q = session.createQuery("FROM Expense WHERE user = :us");
	        q.setParameter("us", user);
	        
	        list = q.list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    
	    return list;
	}
	
	public Expense getExpenseById(int id)
	{
		Expense ex = null;
		try {
			session=factory.openSession();
			Query q=session.createQuery("from Expense where id=:id");
			q.setParameter("id", id);
			ex = (Expense)q.uniqueResult();
;		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ex;
	}
	
	
	public boolean updateExpense(Expense expense )
	{
		boolean f=false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(expense);
			tx.commit();
			f=true;
		} catch (Exception e) {
			if(tx!=null)
			{
				tx.commit();
				f=true;
			}
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	public boolean deleteExpense(int id)
	{
		boolean f = false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Expense ex = session.get(Expense.class, id);
			session.delete(ex);
			
			tx.commit();
			f=true;
			} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
