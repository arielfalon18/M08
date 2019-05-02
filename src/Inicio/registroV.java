package Inicio;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;



/**
 * Servlet implementation class registroV
 */
@WebServlet("/registroV")
public class registroV extends HttpServlet {
	Properties prop = new Properties();
	InputStream is = null;
	
	private static final long serialVersionUID = 1L;
	private static Pattern dato2 =null;
	private static Pattern dato3 =null;
	
       
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
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			is = new FileInputStream("/datos.properties");
			prop.load(is);
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		// TODO Auto-generated method stub
		Pattern dato1 = Pattern.compile(prop.getProperty("servidor.datos3"));
		dato2 = Pattern.compile(prop.getProperty("servidor.datos4"));
		dato3 = Pattern.compile(prop.getProperty("servidor.datos5"));
		
		String nick = request.getParameter("nick");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		Matcher ComprobarNick = dato1.matcher(nick);
		Matcher ComprobarCorreo = dato3.matcher(mail);
		Matcher Comprobarpass = dato2.matcher(pass);
		Connection con=null;
		Statement stmt=null;
		
		
		
		if(ComprobarNick.find()){
			if(ComprobarCorreo.find()) {
				if(Comprobarpass.find()) {
					
					try {
						if(loginCase.insertUser(nick,mail,pass)==true) {
							response.sendRedirect("Ok.jsp");
							loginCase.insertUser(nick,mail,pass);
						}else {
							response.sendRedirect("YaexisteUsuario.jsp");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					response.sendRedirect("ErrorP.jsp");
				}	
			}else {
				response.sendRedirect("ErrorC.jsp");
				
			}	
		}else {
			response.sendRedirect("Error.jsp");
		}
		
	}

}
