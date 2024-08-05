package com.servlet;

import java.io.IOException;
import java.util.Date;

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

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String noteTitle=request.getParameter("noteTitle");
			String noteContent=request.getParameter("noteContent");
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			Configuration configuration =new Configuration();
			configuration.configure();
			SessionFactory factory=configuration.buildSessionFactory();
			Session session=factory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Note note=(Note)session.get(Note.class, noteId);
			
			
			note.setNoteTitle(noteTitle);
			note.setNoteContent(noteContent);
			note.setAddedDate(new Date());
			
			transaction.commit();
			session.close();
			
			response.sendRedirect("AllNotes.jsp");
		} catch (NumberFormatException | HibernateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
