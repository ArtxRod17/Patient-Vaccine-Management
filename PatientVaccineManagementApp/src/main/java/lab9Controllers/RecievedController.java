package lab9Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab9Model.PatientModel;
import lab9Model.VaccineModelLab;


/**
 * Servlet implementation class RecievedController
 */
@WebServlet("/RecievedController")
public class RecievedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RecievedController() {
        super();
     
    }
   @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            String sql = "update patients set second_dose_date = NOW() where id ="+id+"";
            stmt.executeUpdate(sql);
    		//Create Entry
            response.sendRedirect("ListPatientsController");
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
