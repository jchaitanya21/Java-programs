

<%@page import="com.mycompany.crud_operations.StudDao,java.util.*"%>
<%@page import="com.mycompany.crud_operations.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Student</title>  
        <%@include file="components/common_css.jsp" %>
    </head>  
    <body>  
        <div class="container bg-dark text-white">
            <h1>Edit Student</h1> 
            <div class="row">
                <div class="col-sm-12 col-md-6 col-lg-6">
                    <%
                        String sid = request.getParameter("id");
                        int id = Integer.parseInt(sid);

                        Student s = StudDao.getStudentById(id);                  
                    %>
                    <form action="EditServlet2" method="post">  
                        <input type="hidden" name="id" value="<%= s.getId() %>"/>
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" name="name" class="form-control" value="<%= s.getName() %>" id="name">
                        </div>
                        <div class="form-group">
                            <label for="grade">Grade:</label>
                            <input type="text" name="grade" class="form-control" value="<%= s.getGrade() %>" id="grade" required>
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input type="text" name="address" class="form-control" value="<%= s.getAddress() %>" id="address">
                        </div>
                        
                        <input type="submit" class="btn btn-success" value="Save Student">   
                    </form>  
                    
                    <a href="view_student.jsp" class="btn btn-Primary">View Student Table</a>  
                </div>
            </div>
        </div>
        <%@include file="components/common_js.jsp" %>
    </body>  
</html>

