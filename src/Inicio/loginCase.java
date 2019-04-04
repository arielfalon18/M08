package Inicio;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;

public class loginCase {
	public static boolean insertUser(String user,String upass, String uEmail) {
		Connection con;
		
		con = ConnectionDB.getConection();
		PreparedStatement ps =null;
		
		PreparedStatement psN =null;
		Connection conN;
		conN = ConnectionDB.getConection();
		try {
			
			String consultaN="select * from usuario where NOMBRE=?;";
			psN = conN.prepareStatement(consultaN);
			psN.setString(1, user);
			try (ResultSet Respuesta = ps.executeQuery()) {
				if (Respuesta.next()) {
					return true;
				}
			}
			}else {
				String consulta ="insert into usuario (nombre,email,password) VALUES (?,?,?);";
				ps = con.prepareStatement(consulta);
				ps.setString(1, user);
				ps.setString(2, upass);
				ps.setString(3, uEmail);
				con.commit();
				
				if (ps.executeUpdate() ==1) {
					return true;
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
		}
		return false;
	}
	
}
