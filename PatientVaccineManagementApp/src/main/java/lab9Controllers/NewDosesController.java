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
 * Servlet implementation class NewDosesController
 */
@WebServlet("/NewDosesController")
public class NewDosesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewDosesController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/NewDosesLab.jsp").forward(request, response);
	}

	
	@SuppressWarnings("unchecked")
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
             String name = request.getParameter("name");
     		 int doses = Integer.parseInt(request.getParameter("doses"));
             String sql = "update vaccines set doses_received = doses_received + "+doses+",doses_left = doses_left + "+doses+" where name = '"+name+"'";
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
