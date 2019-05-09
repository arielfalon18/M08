package Inicio;
/**
 * @author Ariel Falon
 *
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginE
 */
@WebServlet("/loginE")
public class loginE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginE() {
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
	 * Verifica si el nombre y el password introducionos estan bien si no pues 
	 * Si esta bien te llevara al fichero bienvenido o al fichero error
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String nick = request.getParameter("nick");
		String pass = request.getParameter("pass");
		if(LoginUsuario.login(nick,pass)==true) {
			response.sendRedirect("Error.jsp");
		}else {
			response.sendRedirect("LoginUs.jsp");
			
		}
	}

}
