

<%@page import="com.mycompany.crud_operations.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Students</title>
        <%@include file="components/common_css.jsp" %>
    </head>
    <body>
        <div class="container">
            <%@page import="com.mycompany.crud_operations.StudDao,java.util.*,java.sql.*"%>  

            <h1>Student List</h1>  

            <table class="table table-bordered table-dark text-white">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Grade</th>
                        <th scope="col">Address</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Connection con = StudDao.getConnection();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
                            if (con != null) {
                                PreparedStatement ps = con.prepareStatement("select * from student");
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                    %>
                    <tr>
                        <td scope="row"><%= rs.getString("id")%></td>
                        <td><%= rs.getString("name")%></td>
                        <td><%= rs.getString("grade")%></td>
                        <td><%= rs.getString("address")%></td>
                        <td>
                            <a href="edit_student.jsp?id=<%= rs.getString("id")%>" class="btn btn-primary">Edit</a>

                        </td>  
                        <td>
                            <a href="DeleteServlet?id=<%= rs.getString("id")%>" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                    <%
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </tbody>
            </table
            <br>
            <a href='index.jsp' class="btn btn-Primary">Add New Student</a>
        </div>
        <%@include file="components/common_js.jsp" %>
    </body>
</html>

