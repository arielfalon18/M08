package Inicio;
/**
 * @author Ariel Falon
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUsuario {
	private LoginUsuario() {}
	/**
	 * 
	 * @param user
	 * @param pass
	 * @return la respuesta del SQL 
	 * Te hara un select y te buscara el nombre y el password si existe en la base de datos te da una 
	 * respuesta
	 */
	public static boolean login(String user,String pass) {
		Connection con;
		con = ConnectionDB.getConection();
		PreparedStatement ps =null;
		String psw="password";
		
		try {
			String consultaL="select * from usuario where NOMBRE=? "+psw+"=?;";
			ps = con.prepareStatement(consultaL);
			ps.setString(1, user);
			ps.setString(2, pass);
			
			try (ResultSet Respuesta = ps.executeQuery()) {
				if (Respuesta.next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
