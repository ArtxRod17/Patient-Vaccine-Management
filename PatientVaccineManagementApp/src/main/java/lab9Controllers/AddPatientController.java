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
 * Servlet implementation class AddPatientController
 */
@WebServlet("/AddPatientController")
public class AddPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddPatientController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/AddPatientForm.jsp").forward(request, response);
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
             String pName = request.getParameter("pName");
     		 int vacId = Integer.parseInt(request.getParameter("vName"));
             String sql = "insert into patients (first_name,last_name,vaccine_id,first_dose_date) values ('"+pName+"',' ',"+vacId+",NOW())";
             String updatesql = "update vaccines set doses_left = doses_left - 1 where id = "+vacId+"";
             stmt.executeUpdate(sql);
             stmt.executeUpdate(updatesql);
            
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

}
