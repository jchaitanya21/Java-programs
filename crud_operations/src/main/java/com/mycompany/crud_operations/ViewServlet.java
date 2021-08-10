
package com.mycompany.crud_operations;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<a href='index.html'>Add New Student</a>");
            out.println("<h1>List of Students</h1>");
            
            List<Student>list = StudDao.getAllStudents();
            
            out.print("<table border='1' width='100%'");
            out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");
            list.forEach(s -> {
                out.print("<tr><td>" + s.getId() + "</td><td>" + s.getName() + "</td><td>" + s.getGrade() + "</td><td>" + s.getAddress() + "</td><td><a href='EditServlet?id=" + s.getId() + "'>edit</a></td>  <td><a href='DeleteServlet?id=" + s.getId() + "'>delete</a></td></tr>");
            });
            out.print("</table>");
        }
    }
}
