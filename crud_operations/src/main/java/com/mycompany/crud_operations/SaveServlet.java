/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud_operations;

/**
 *
 * @author hp
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String grade = request.getParameter("grade");
            String address = request.getParameter("address");
            
            
            Student s = new Student();
            s.setName(name);
            s.setGrade(grade);
            s.setAddress(address);
            
            
            int status = StudDao.save(s);
            if (status > 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Record saved successfully!');");
                out.println("location='index.jsp';");
                out.println("</script>");
//            request.getRequestDispatcher("index.jsp").include(request, response);
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Sorry! unable to save record');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
        }
    }

}
