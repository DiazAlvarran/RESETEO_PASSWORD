package pe.gob.sunarp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.gob.sunarp.models.Usuario;
import pe.gob.sunarp.service.LoginService;
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
		
		//System.out.println(request.getParameterValues("sistemas"));
		
		String[] sistemas = request.getParameterValues("sistemas[]");
		String mensaje = "";
		
		for(String sistema : sistemas) {
			mensaje = mensaje + sistema + "\n";
		}
		
		System.err.println("\n=============SISTEMAS==============\n" + mensaje);

	}

}
