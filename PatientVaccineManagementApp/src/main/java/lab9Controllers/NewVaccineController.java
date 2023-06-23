package lab9Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import lab9Model.VaccineModelLab;

/**
 * Servlet implementation class NewVaccineController
 */
@WebServlet("/NewVaccineController")
public class NewVaccineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public NewVaccineController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/NewVaccineLab.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null; 
		try
         {
             String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu40";
             String username = "cs3220stu40";
             String password = "OLPQFivHo6Wx";
             

             c = DriverManager.getConnection( url, username, password );
             Statement stmt = c.createStatement();
             //Get info from form
             String name = request.getParameter("name");
      		 int doses = Integer.parseInt(request.getParameter("doses"));
      		 int days = Integer.parseInt(request.getParameter("days"));
             String sql = "insert into vaccines (name,doses_required,days_between_doses,doses_received,doses_left)\n"
             		+ "values ('"+name+"',"+doses+","+days+",0,0)";
             stmt.executeUpdate(sql);
            
     		//Create Entry
     		response.sendRedirect("ListVaccineController");
         } catch( SQLException e ) {
             throw new ServletException(e);
         } finally {
             try {
                 if( c != null ) {
                	 c.close();
                 }
             } catch( SQLException e)
             {
                 throw new ServletException(e);
             }
         }
		
	
	}

}
