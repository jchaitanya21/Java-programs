<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>  
        <%@include file="components/common_css.jsp" %>
    </head>  
    <body>  
        <div class="container bg-dark text-white">
            <h1>Add New Student</h1> 
            <div class="row">
                <div class="col-sm-12 col-md-6 col-lg-6">
                    <form action="SaveServlet" method="post" name="myForm" onsubmit="return validateForm()">  
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" name="name" class="form-control" placeholder="Enter Name" id="name">
                        </div>
                        <div class="form-group">
                            <label for="grade">Grade:</label>
                            <input type="text" name="grade" class="form-control" placeholder="Enter grade" id="grade" required>
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input type="text" name="address" class="form-control" placeholder="Enter Address" id="address" required>
                        </div>
                        
                        <input type="submit" class="btn btn-success" value="Save Student">   
                    </form>  
                     
                    <a href="view_student.jsp " class="btn-info">View Students Details</a>  
                </div>
            </div>
        </div>
        <%@include file="components/common_js.jsp" %>
        <<script src="components/validations.js"></script>
    </body>  
</html>
