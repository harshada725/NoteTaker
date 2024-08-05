<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.entities.Note"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit page</title>
<%@include file="all_web.jsp" %>
</head>
<body>

	<div class="container-fuild">
	<%@include file="Navbar.jsp" %>
	
	<%
	int noteId=Integer.parseInt(request.getParameter("noteId").trim());
	Configuration configuration = new Configuration();
    configuration.configure();
    SessionFactory factory = configuration.buildSessionFactory();
    Session session3 = factory.openSession();
    Note note=(Note)session3.get(Note.class,noteId);
    
    session3.close();
    factory.close();
	%>
	
	<div class="container d-flex flex-column justify-content-center align-items-center" style="height: 80vh;">
            <h2>Kindly Edit your details.</h2>
            <div class="col-md-6">
                <form action="UpdateServlet" method="post">
                <input value="<%=note.getNoteId() %>" name="noteId" type="hidden"/>
                    <div class="mb-3">
                        <label for="NoteTitle" class="form-label">Note_Title</label>
                        <input required type="text" class="form-control" id="NoteTitle" name="noteTitle" placeholder="Enter here" value="<%= note.getNoteTitle()%>"/>
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label">Note_Content</label>
                        <textarea required id="content" placeholder="Enter your content here" class="form-control" name="noteContent" style="height:300px;"><%= note.getNoteContent() %>
                        </textarea>
                    </div>
                    <div class="container text-center">
                        <button type="submit" class="btn btn-success">Save Your Note</button>
                         
                </form>
            </div>
        </div>
	
	
	</div>
</body>
</html>