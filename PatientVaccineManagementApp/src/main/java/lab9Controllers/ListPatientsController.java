package lab9Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab9Model.PatientModel;
import lab9Model.PatientViewModel;




/**
 * Servlet implementation class ListPatientsController
 */
@WebServlet("/ListPatientsController")
public class ListPatientsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListPatientsController() {
        super();
 
    }
    

    /*public void init( ServletConfig config) throws ServletException{
    	super.init(config);
    	List<PatientModel> entries = new ArrayList<PatientModel>();
    	Date myDate = parseDate("2/18/2021");
    	Date myDate2 = parseDate("3/11/2021");
    	entries.add(new PatientModel("John Doe",1,myDate,myDate2));
    	entries.add(new PatientModel("John Doe",1,myDate,null));
    	entries.add(new PatientModel("Tom Smith",2,myDate2,null));
    	entries.add(new PatientModel("Jim Lee",1,null,null));
 
    	
    	getServletContext().setAttribute("patients", entries);
    }*/
    
    
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
             ResultSet rs = stmt.executeQuery( "select patients.id,concat(first_name,' ',last_name)as name,vaccine_id,\n"
             		+ "vaccines.name as vaccine_name,vaccines.doses_required,vaccines.doses_left,first_dose_date,\n"
             		+ "second_dose_date\n"
             		+ "from patients join vaccines on patients.vaccine_id = vaccines.id order by patients.id ASC" );
             //Create list
             //Create list of departments
             List<PatientViewModel> patients = new ArrayList<PatientViewModel>();

             while( rs.next() )
             {
            	 //Set Department name
                 PatientViewModel entry = new PatientViewModel();
                 entry.setId(rs.getInt("id"));
                 entry.setName(rs.getString("name"));
                 entry.setVaccineId(rs.getInt("vaccine_id"));
                 entry.setVaccineName(rs.getString("vaccine_name"));
                 entry.setVaccineDosesRequired(rs.getInt("doses_required"));
                 entry.setVaccineDosesLeft(rs.getInt("doses_left"));
                 entry.setFirstDoseDate(rs.getDate("first_dose_date"));
                 entry.setSecondDoseDate(rs.getDate("second_dose_date"));
                 patients.add(entry);
                 
             }
             //set attribute
             getServletContext().setAttribute("patients", patients);
           //DIRECT TO PAGE
     		request.getRequestDispatcher("/ListPatientsDisplay.jsp").forward(request, response);
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

