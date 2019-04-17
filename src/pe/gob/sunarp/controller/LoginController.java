package pe.gob.sunarp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pe.gob.sunarp.models.Usuario;
import pe.gob.sunarp.service.LoginService;
import pe.gob.sunarp.util.Mensaje;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({"/LOGIN", "/principal", "/inicio"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		switch (path) {
		case "/LOGIN":
			login(request, response);
			break;
		case "/principal":
			principal(request, response);
			break;
		case "/inicio":
			cerrarSesion(request, response);
			break;
		}

	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Entrada
		String user = request.getParameter("user").toUpperCase();
		String pass = request.getParameter("pass");
		String mensaje = "Usuario y/o Contraseña incorrectos: " + user + ", " + pass;
		
		// Proceso
		LoginService service = new LoginService();
		boolean logged = service.login(user, pass);
		
		if(logged){ // Si el se ha logueado
			
			Usuario usuario = service.getUsuario(user); // traer datos de usuario
			HttpSession session = request.getSession(); // crear session
			
			// llenar atributos de sesion
			session.setAttribute("co_empl", usuario.getCo_empl());
			session.setAttribute("c_t_nombre", usuario.getC_t_nombre());
			session.setAttribute("ap_pate_empl", usuario.getAp_pate_empl());
			session.setAttribute("ap_mate_empl", usuario.getAp_mate_empl());
			session.setAttribute("no_empl", usuario.getNo_empl());
			session.setAttribute("osuser", usuario.getOsuser());
			session.setAttribute("co_usua", usuario.getCo_usua());
			session.setAttribute("in_estd", usuario.getIn_estd());
			session.setAttribute("co_area", usuario.getCo_area());
			session.setAttribute("no_area", usuario.getNo_area());
			session.setAttribute("DNI", usuario.getDNI());
			
			session.setAttribute("is_logged", 1);
			
			System.err.println("\nSessión creada:");
			System.err.println("co_empl : " + session.getAttribute("co_empl"));
			System.err.println("c_t_nombre : " + session.getAttribute("c_t_nombre"));
			System.err.println("ap_pate_empl : " + session.getAttribute("ap_pate_empl"));
			System.err.println("ap_mate_empl : " + session.getAttribute("ap_mate_empl"));
			System.err.println("no_empl : " + session.getAttribute("no_empl"));
			System.err.println("osuser : " + session.getAttribute("osuser"));
			System.err.println("co_usua : " + session.getAttribute("co_usua"));
			System.err.println("in_estd : " + session.getAttribute("in_estd"));
			System.err.println("co_area : " + session.getAttribute("co_area"));
			System.err.println("no_area : " + session.getAttribute("no_area"));
			System.err.println("is_logged : " + session.getAttribute("is_logged"));
			System.err.println("DNI : " + session.getAttribute("DNI"));
			
			mensaje = "Bienvenido " + user;
			
		}
		
		System.err.println("\n" + mensaje);
		// Salida
		Mensaje message = new Mensaje();
		message.setCode(logged);
		message.setMessage(mensaje);
		
		// Convertir salida a JSON
		UtilController.messageJSON(response, message);
	}
	
	protected void principal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		
		try {
			// Validar si esta logueado el usuario
			HttpSession session = request.getSession();
			int is_logged = (int) session.getAttribute("is_logged");
			
			if(is_logged == 1) {
				rd = request.getRequestDispatcher("logged.html");
			} else {
				rd = request.getRequestDispatcher("index.html");
			}
			
			} catch (Exception e) {
				System.err.println(e.getMessage());

				//rd = request.getRequestDispatcher("logged.html");
			}
		
		rd.forward(request, response);
	}
	
	protected void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		RequestDispatcher rd = null;
		// Inactivando sesion
		HttpSession session = request.getSession();
		
		session.setAttribute("is_logged", 0);
		
		rd = request.getRequestDispatcher("index.html");

		rd.forward(request, response);
	}
}
