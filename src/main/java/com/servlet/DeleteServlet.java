package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Note;



public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			Configuration configuration =new Configuration();
			configuration.configure();
			SessionFactory factory=configuration.buildSessionFactory();
			Session session=factory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Note note=(Note)session.get(Note.class, noteId);
			session.delete(note);
			
			transaction.commit();
			session.close();
			
			response.sendRedirect("AllNotes.jsp");
		} catch (NumberFormatException | HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
