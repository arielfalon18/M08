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



/**
 * Servlet implementation class registroV
 */
@WebServlet("/registroV")
public class registroV extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
       
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
		
		
		
		if(ComprobarNick.find()){
			if(ComprobarCorreo.find()) {
				if(Comprobarpass.find()) {
					
					if(loginCase.insertUser(nick,mail,pass)==true) {
						response.sendRedirect("Ok.jsp");
						loginCase.insertUser(nick,mail,pass);
					}else {
						response.sendRedirect("YaexisteUsuario.jsp");
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
