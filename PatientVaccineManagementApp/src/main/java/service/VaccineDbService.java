package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VaccineDbService {

	//INFO FOR LOGIN
	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu40";

    private String username = "cs3220stu40";

    private String password = "OLPQFivHo6Wx";

    private Connection connection;
    
    //Constructor
    public VaccineDbService() {
    	try {
    		connection = DriverManager.getConnection(url, username, password);
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    	}
    }
    
    //CLOSE CONNECTION
    public void close() {
    	if( connection != null) {
    		try {
    			connection.close();
    		}
    		catch( SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    //
}
