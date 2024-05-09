package bank.management.system;

import java.sql.*;

public class Conn {

	//JDBC has 5 step connection process
	//1. Register the driver 
	//2. Create connection
	//3. Create statement 
	//4. Execute query
	//5. close connection
	
	Connection c;
	Statement s;
	
	public Conn() {
		
		try {
			//Class.forName(com.mysql.cj.jdbc.Driver);   // yaha apne driver ka naam likho but humne connector jar file impor tkrli hai no tension
			// STEP 1
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "manager");           // STEP 2
			s = c.createStatement();																			// Step 3
		} catch (Exception e) {
			System.out.println(e); // jo bhi error aayenga wo yaha se print hojayenga
		}
	}
	
	
	
}
