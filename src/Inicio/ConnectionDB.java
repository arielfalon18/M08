package Inicio;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:file:C:\\Users\\Super\\eclipse-workspace\\TiendaM08\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
		public static Connection getConection() {
			Connection conn=null;
			final Logger LOGGER = Logger.getLogger("Inicio");
			try {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, "SA", "");
			} catch (ClassNotFoundException | SQLException e) {
				LOGGER.log(Level.SEVERE, e.toString());
			}
			return conn;
			
		}
		
		public ConnectionDB() {
			super();
		}
}
