import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBH {
// This class is in charge of establishing the connection to the database. It is instantiated each time a connection is needed. 
//This is handy in case the address of the database changes, so it has to be changed only here and not on every class.
// Each time it is used, we just have to adapt the sql call, depending on the needs.
	    
	protected int rowCounter;


	public DBH (){
		
	}
	    
	   
	public ResultSet executeCall(String sql){
	
		
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){ System.out.println(e);}
			
			
			  Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
	    	int rowCounter = 0;
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1/Narnia_Hospital?user=root&password=");

	    	    
	    	    stmt = conn.createStatement();

	    	    
	    	    if (stmt.execute(sql)) {
	    	        rs = stmt.getResultSet();
	    	        return rs;
	    	    }
	    	    
	    	    
	    	} catch (SQLException e) {
	    		System.out.println(e);
	    	}

		
		return null; 
	} 
		
		
}

