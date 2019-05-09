package Inicio;
/**
 * @author Ariel Falon 
 *
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @param DRIVER
 * @param URL
 * @param conn
 * @param usu
 * @param ps
 * @param LOGGER
 * @return Base de datos
 * Esto se conectara a la base de datos de hsqldb con el usuario y constraseña introducida
 * tambien usamos el lloger para usar un system.err
 *
 */
public class ConnectionDB {
	
	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:file:C:\\Users\\Super\\eclipse-workspace\\TiendaM08\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
		/**
		 * 
		 * @return Respuesta de la base de datos
		 */
		public static Connection getConection() {
			Connection conn=null;
			String usu="SA";
			String ps="";
			final Logger LOGGER = Logger.getLogger("Inicio");
			try {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, usu, ps);
			
				
			} catch (ClassNotFoundException | SQLException e) {
				LOGGER.log(Level.SEVERE, e.toString());
				
				
				
			}
			return conn;
			
		}
		
		private ConnectionDB() {
			super();
		}
}
