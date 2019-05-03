package Inicio;

import java.io.IOException;
import java.sql.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Servlet implementation class TiendaR
 */
@WebServlet("/TiendaR")
public class TiendaR extends HttpServlet {
	Properties prop = new Properties();
	InputStream is = null;
	Pattern dato2 =null;
	final Logger LOGGER = Logger.getLogger("Inicio");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			is = new FileInputStream("/datos.properties");
			prop.load(is);
		} catch(IOException e) {
			LOGGER.log(Level.SEVERE, e.toString());
		}
		// TODO Auto-generated method stub
		doGet(request, response);
		//EXPRESIONES REGULARES
		
		Pattern dato1 = Pattern.compile(prop.getProperty("servidor.datos1"));
		dato2 = Pattern.compile(prop.getProperty("servido.datos2"));
		String nick = request.getParameter("nick");
		String comentario = request.getParameter("comentario");
		String cantidad=request.getParameter("cantidad");
		String pagamentoM=request.getParameter("pago");
		String[] SeleIMG = request.getParameterValues("IMG");
		
		Matcher ComprobarNick = dato1.matcher(nick);
		Matcher ComprobarCantidad = dato2.matcher(cantidad);
		
		String radio=TiendaU.saberButton(pagamentoM);
		String chaeck=TiendaU.checkBu(SeleIMG);
		
		if(ComprobarNick.find()){
			if(ComprobarCantidad.find()){
				if(TiendaU.inserTienda(nick, chaeck, radio, cantidad, comentario)==true) {
					response.sendRedirect("CompraOK.jsp");
					TiendaU.inserTienda(nick, chaeck, radio, cantidad, comentario);
				}else {
					response.sendRedirect("CompraNoOk.jsp");
				}
			}else {
				response.sendRedirect("errorCantidad.jsp");
			}
		}else {
			response.sendRedirect("Error.jsp");
		}
		
	}
	

}
