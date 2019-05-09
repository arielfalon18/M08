package Inicio;
/**
 * @author Ariel Falon
 */
import java.beans.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class registroV
 */
@WebServlet("/registroV")
public class registroV extends HttpServlet {
	Properties prop = new Properties();
	InputStream is = null;
	
	private static final long serialVersionUID = 1L;
	private  Pattern dato2 =null;
	private  Pattern dato3 =null;
	final Logger LOGGER = Logger.getLogger("Inicio");
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registroV() {
    	
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Te realizara el properties para las constraseñas y tambien te y vera si los las variables estan bien realizadas
	 * si esta todo bien te llevara al fichero correcto si esta mal te llevara al fichero incorrecto
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*try {
			
			prop.load(new FileInputStream("datos.properties"));
		} catch(IOException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}*/
		//No funciona properties
		// TODO Auto-generated method stub
		Pattern dato1 = Pattern.compile("^[a-z 0-9]{1,9}$");
		Pattern dato2 = Pattern.compile("^[a-z 0-9]{8,}$");
		Pattern dato3 = Pattern.compile("\\w+\\.?\\w+@\\w+\\.\\w+");
		
		String nick = request.getParameter("nick");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		Matcher ComprobarNick = dato1.matcher(nick);
		Matcher ComprobarCorreo = dato3.matcher(mail);
		Matcher Comprobarpass = dato2.matcher(pass);
		Connection con=null;
		Statement stmt=null;
			if(ComprobarCorreo.find() && ComprobarNick.find()) {
				if(Comprobarpass.find()) {
					
					try {
						if(loginCase.insertUser(nick,mail,pass)==true) {
							response.sendRedirect("Ok.jsp");
							loginCase.insertUser(nick,mail,pass);
						}else {
							response.sendRedirect("YaexisteUsuario.jsp");
						}
					} catch (SQLException e) {
						LOGGER.log(Level.SEVERE, e.toString());
					}
				}else {
					response.sendRedirect("ErrorP.jsp");
				}	
			}else {
				response.sendRedirect("ErrorC.jsp");
			}	
		
		
	}

}
