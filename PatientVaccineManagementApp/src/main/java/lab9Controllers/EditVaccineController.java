package lab9Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab9Model.VaccineModelLab;


/**
 * Servlet implementation class EditVaccineController
 */
@WebServlet("/EditVaccineController")
public class EditVaccineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditVaccineController() {
        super();
    }
	@SuppressWarnings("unchecked")
	private VaccineModelLab getEntry(int id) {
    	List<VaccineModelLab> entries = (List<VaccineModelLab>) getServletContext().getAttribute("vaccines");
    	for(VaccineModelLab entry : entries)
    		if(entry.getId() == id) return entry;
    	return null;
   
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		VaccineModelLab entry = getEntry(Integer.parseInt(id));
		request.setAttribute("entry", entry);
		request.getRequestDispatcher("/EditVaccineLab.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		//Add doses to existing dose
				Connection c = null; 
				try
		         {
		             String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu40";
		             String username = "cs3220stu40";
		             String password = "OLPQFivHo6Wx";
		             

		             c = DriverManager.getConnection( url, username, password );
		             Statement stmt = c.createStatement();
		             //Get info from form
		             int id = Integer.parseInt(request.getParameter("id"));
		             String name = request.getParameter("name");
		     		 int doses = Integer.parseInt(request.getParameter("doses"));
		     		 int days = Integer.parseInt(request.getParameter("days"));
		             String sql = "update vaccines set name = '"+name+"',doses_required = "+doses+",days_between_doses = " + days+" where id = "+id+"";
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
