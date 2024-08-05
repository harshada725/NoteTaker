<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="all_web.jsp" %>
</head>
<body>
	<div class="container-fuild">
        <%@include file="Navbar.jsp" %>
        <br>
        <div class="container d-flex flex-column justify-content-center align-items-center" style="height: 80vh;">
            <h2>Kindly enter your details.</h2>
            <div class="col-md-6">
                <form action="SaveNoteServlet" method="post">
                    <div class="mb-3">
                        <label for="NoteTitle" class="form-label">Note_Title</label>
                        <input required type="text" class="form-control" id="NoteTitle" name="noteTitle" placeholder="Enter here">
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label">Note_Content</label>
                        <textarea required id="content" placeholder="Enter your content here" class="form-control" name="noteContent" style="height:300px;"></textarea>
                    </div>
                    <div class="container text-center">
                        <button type="submit" class="btn btn-primary">Add Note</button>
                         <button type="reset" class="btn btn-secondary">Clear</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>