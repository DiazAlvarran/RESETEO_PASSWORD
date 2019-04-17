package pe.gob.sunarp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.gob.sunarp.models.Sistema;
import pe.gob.sunarp.models.Usuario;
import pe.gob.sunarp.service.LoginService;
import pe.gob.sunarp.service.ResetService;
import pe.gob.sunarp.util.Mensaje;

/**
 * Servlet implementation class ResetService
 */
@WebServlet("/reset_password")
public class ResetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		switch (path) {
		case "/reset_password":
			resetPassword(request, response);
			break;
		}
	}
	
	protected void resetPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sistema = request.getParameter("sistema");
		String id_user = request.getParameter("id_user");
		String dbl = request.getParameter("dbl");
		
		System.err.println("\nSistema: " + sistema + " - id_user: " + id_user + " - dbl: " + dbl);
		
		String mensaje = "";
		ResetService service = new ResetService();
		
		mensaje += service.resetPassword(id_user, dbl);
		
		System.err.println("\nSistema: " + sistema + "\nMensaje: " + mensaje);

	}

}
