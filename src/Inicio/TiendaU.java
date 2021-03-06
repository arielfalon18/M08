package Inicio;
/**
 * @author Ariel Falon
 */
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiendaU {
	static Logger LOGGER = Logger.getLogger("Inicio");
	private TiendaU() {}
	/**
	 * 
	 * @param nick
	 * @param seleIMG
	 * @param pagamentoM
	 * @param cantidad
	 * @param comentario
	 * @return Te hara un insert de los productos de la tienda digamos que te hara un insert 
	 */
	public static boolean inserTienda(String nick,String seleIMG,String pagamentoM,String cantidad,String comentario) {
		Connection con;
		final Logger LOGGER = Logger.getLogger("Inicio");
		
		Level datosDL = Level.SEVERE;

		con = ConnectionDB.getConection();
		PreparedStatement ps =null;
		LOGGER.log(Level.SEVERE, seleIMG);


		try {
			String consulta ="insert into Tienda (NICK, Producto, Payment, Cantidad, Comments) VALUES (?,?,?,?,?);";
			ps = con.prepareStatement(consulta);
			LOGGER.log(datosDL,"\n"+ps);

			ps.setString(1, nick);
			ps.setString(2, seleIMG);
			ps.setString(3, pagamentoM);
			ps.setString(4, cantidad);
			ps.setString(5, comentario);
			con.commit();
			if (ps.executeUpdate() ==1) {
				return true;
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
	public static String saberButton(String texto) {
		String respuesta = "";
		if ("cash".equals(texto)) {
			respuesta="cash";
		} else if ("credito_card".equals(texto)) {
			respuesta= "credito card";
		}else if ("pay_pal".equals(texto)) {
			respuesta= "pay pal";
		}
		return respuesta;

	}
	public static String checkBu(String[] texto) {
		String respuesr = "";


		for (int i = 0; i < texto.length; i++) {

			respuesr=respuesr+ " "+texto[i]+" ";
			LOGGER.log(Level.SEVERE, texto[i]);

		}

		return respuesr;
	}
	public static String nombre(String texto) {
		String nombre=texto;
		return nombre;
	}

}