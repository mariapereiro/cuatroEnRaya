package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

	//static: para no crear un objeto a la hora de llamarlo
	public static Connection instance = null;
	
	//final: no modificara su valor
	public static final String JDBC_BDD_URL = "jdbc:mysql://localhost:3306/cuatro_en_raya";
	
	//Patrón singleton
	public static Connection getConnection() throws SQLException {
		
		if(instance == null) {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "");
		
			instance= DriverManager.getConnection(JDBC_BDD_URL, props);
		}
		
		return instance;
	}
}
