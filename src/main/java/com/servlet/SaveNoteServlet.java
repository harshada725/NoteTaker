package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Note;


public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			String noteTitle=request.getParameter("noteTitle");
			String noteContent=request.getParameter("noteContent");
			
			Note note=new Note(0, noteTitle,noteContent,new Date());
			//System.out.println(note.getNoteId()+" : "+note.getNoteTitle());
			
			Configuration configuration =new Configuration();
			configuration.configure();
			SessionFactory factory=configuration.buildSessionFactory();
			Session session=factory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.save(note);
			
			
			
			
			transaction.commit();
			session.close();
			out.println("<h1 style='text-align:center;'>Note is added successfully!</h2>");
			out.println("<h1 style='text-align:center;'><a href='AllNotes.jsp'>View all</a></h1>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
