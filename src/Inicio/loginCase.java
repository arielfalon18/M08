package Inicio;
/**
 * @author Ariel Falon
 *
 */
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;


public class loginCase {
	private loginCase() {}
	/**
	 * 
	 * @param user
	 * @param upass
	 * @param uEmail
	 * @return
	 * @throws SQLException
	 * Te busca un nombre  con el dato introducido y si ese nombre no existe pues 
	 * te lo creara si existe no hara nada 
	 */
	static boolean insertUser(String user,String upass, String uEmail) throws SQLException {
		Connection con;
		Connection datos=ConnectionDB.getConection();
		con = datos;
		PreparedStatement ps =null;
		String consultaN;
		PreparedStatement psN =null;
		Connection conN;
		conN = datos;
		try {
			
			consultaN="select * from usuario where NOMBRE=?;";
			psN = conN.prepareStatement(consultaN);
			psN.setString(1, user);
			try (ResultSet Respuesta = psN.executeQuery()){
				if (Respuesta.next()) {
					
					
					return false;
					
					
				}else {
					String consultaB ="insert into usuario (nombre,email,password) VALUES (?,?,?);";
					ps = con.prepareStatement(consultaB);
					ps.setString(1, user);
					ps.setString(2, upass);
					ps.setString(3, uEmail);
					con.commit();
					
					if (ps.executeUpdate() ==1) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			psN.close();
		}
		return false;
	}
	
}
