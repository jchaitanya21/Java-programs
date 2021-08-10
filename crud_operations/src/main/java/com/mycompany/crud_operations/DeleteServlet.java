
package com.mycompany.crud_operations;


import com.mycompany.crud_operations.StudDao;
import java.io.IOException;  
import java.io.PrintWriter;
//import static java.lang.System.out;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException { 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        int status = StudDao.delete(id);  
        
        if (status > 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Student deleted successfully!');");
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
        //response.sendRedirect("ViewServlet");  
    }  
}  
