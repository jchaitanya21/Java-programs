
package com.mycompany.crud_operations;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        String address = request.getParameter("address");
        

        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setGrade(grade);
        s.setAddress(address);
        

        int status = StudDao.update(s);
        if (status > 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Record updated successfully!');");
            out.println("location='view_student.jsp';");
            out.println("</script>");
//            response.sendRedirect("ViewServlet"); 
//            response.sendRedirect("view_employee.jsp");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Sorry! unable to save record');");
            out.println("location='view_student.jsp';");
            out.println("</script>");
        }

        out.close();
    }

}
