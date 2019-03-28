package Inicio;

import java.sql.*;

public class ConnectionDB {
	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:file:C:\\Users\\Super\\eclipse-workspace\\TiendaM08\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
		public static Connection getConection() {
			Connection conn=null;
			try {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, "SA", "");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("ERROR "+e);
			}
			return conn;
			
		}
		
		public ConnectionDB() {
			super();
		}
}
