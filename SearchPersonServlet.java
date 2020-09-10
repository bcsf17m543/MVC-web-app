import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class SearchPersonServlet extends HttpServlet {
  //Process the HTTP Get request
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    String u_name=request.getParameter("Name");



    
    out.println("<html>");
    out.println("<head><title>Search Person</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");
   
     if(u_name=="")
     {
       out.println("<h1>Please Enter a value<h1>");
       out.println("<button onclick=window.location.href='http://localhost:8080/lab_13/search.html'>Search Person</button>");

      }
     else{
        request.setAttribute("key", u_name);
        
       RequestDispatcher rd = request.getRequestDispatcher("/ShowPersonServlet");
        
        rd.forward(request,response);

     }
    

  }

}