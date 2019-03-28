package Inicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUsuario {
	public static boolean login(String user,String pass) {
		Connection con;
		con = ConnectionDB.getConection();
		PreparedStatement ps =null;
		
		try {
			String consultaL="select * from usuario where NOMBRE=? password=?;";
			ps = con.prepareStatement(consultaL);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet Respuesta = ps.executeQuery();
			if (Respuesta.next()) {
				return true;
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
