package lab9Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab9Model.VaccineModelLab;


/**
 * Servlet implementation class ListVaccineController
 */
@WebServlet("/ListVaccineController")
public class ListVaccineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListVaccineController() {
        super();
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection c = null; 
		try
         {
             String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu40";
             String username = "cs3220stu40";
             String password = "OLPQFivHo6Wx";
             

             c = DriverManager.getConnection( url, username, password );
             Statement stmt = c.createStatement();
             
             //SQL statement to get departments
             ResultSet rs = stmt.executeQuery("select * from vaccines" );
             //Create list
             //Create list of departments
             List<VaccineModelLab> vaccines = new ArrayList<VaccineModelLab>();

             while( rs.next() )
             {
            	 //Set vaccine object
            	 VaccineModelLab v = new VaccineModelLab();
            	 v.setId(rs.getInt("id"));
            	 v.setVaccineName(rs.getString("name"));
            	 v.setDosesRequired(rs.getInt("doses_required"));
            	 v.setDaysBetweenDoses(rs.getInt("days_between_doses"));
            	 v.setDosesRecieved(rs.getInt("doses_received"));
            	 v.setDosesLeft(rs.getInt("doses_left"));
            	 vaccines.add(v);
            	 
                 
                 
             }
             //set attribute
             getServletContext().setAttribute("vaccines", vaccines);
           //DIRECT TO PAGE
     		request.getRequestDispatcher("/ListVaccineLab.jsp").forward(request, response);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
