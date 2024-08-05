<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes</title>
<%@include file="all_web.jsp" %>
<style>
	.title
	{
	    text-align:center;
	    margin-top:20px;
	}
    .card-container {
        display: flex;
        justify-content: center;
        padding: 20px;
    }
    .card {
        width: 80%;
        margin: 10px;
    }
    .card-body {
        padding: 20px;
    }
</style>
</head>
<body>

<div class="Container">
<%@include file="Navbar.jsp" %>
<br>
   <h1 class="title">All Notes:</h1>
</div>

<div class="row">
<div class="col-12">
<%
    Configuration configuration = new Configuration();
    configuration.configure();
    SessionFactory factory = configuration.buildSessionFactory();
    Session session2 = factory.openSession();
    
    Query q = session2.createQuery("from Note");
    List<Note> list = q.list();
    for(Note note : list)
    {
%>
        <div class="card-container">
            <div class="card mt-3">
                <img class="card-img-top m-2 mx-auto" style="max-width:50px;" src="Image/note.png" alt="Card image cap">
                <div class="card-body px-5">
                    <h5 class="card-title"><%= note.getNoteTitle() %></h5>
                    <p class="card-text"><%= note.getNoteContent() %></p>
                    <p><b><%= note.getAddedDate() %></b></p>
                    <div class="container text-center mt-2">
                    	<a class="btn btn-danger" href="DeleteServlet?noteId=<%= note.getNoteId() %>" >Delete</a>
                    	<a href="edit.jsp?noteId=<%= note.getNoteId() %>" class="btn btn-primary">Update</a>
                    </div>
                </div>
            </div>
        </div>
<%
    }
     
%>

</div>

</div>

</body>
</html>
