package pe.gob.sunarp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pe.gob.sunarp.models.Sistema;
import pe.gob.sunarp.models.Usuario;
import pe.gob.sunarp.service.ListarService;
import pe.gob.sunarp.service.LoginService;
import pe.gob.sunarp.util.Mensaje;
import pe.gob.sunarp.util.UsuarioLogged;

/**
 * Servlet implementation class PrincipalControler
 */
@WebServlet({"/get_datos", "/get_lista"})
public class PrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		switch (path) {
		case "/get_datos":
			getDatos(request, response);
			break;
		case "/get_lista":
			getLista(request, response);
			break;
		}
	}
	
	/**================================================================
	============OBTENER LOS DATOS DEL USUARIO LOGUEADO=================
	================================================================**/	
	private void getDatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Entrada
		HttpSession session = request.getSession();
		
		System.err.println("Se va poner el nombre:");
		System.err.println("c_t_nombre: " + session.getAttribute("c_t_nombre"));
		System.err.println("no_area: " + session.getAttribute("no_area"));
		System.err.println("ap_pate_empl: " + session.getAttribute("ap_pate_empl"));
		System.err.println("ap_mate_empl: " + session.getAttribute("ap_mate_empl"));
		System.err.println("no_empl: " + session.getAttribute("no_empl"));
		
		String c_t_nombre = (String) session.getAttribute("c_t_nombre");
		String no_area = (String) session.getAttribute("no_area");
		String ap_pate_empl = (String) session.getAttribute("ap_pate_empl");
		String ap_mate_empl = (String) session.getAttribute("ap_mate_empl");
		String no_empl = (String) session.getAttribute("no_empl");
		
		
		System.err.println("CONTROLLER: " + PrincipalController.class.getName() + "\n"
			+ "private void : get_datos" + "\n" + "Nombre de área: " + no_area + "\n" + "Nombre completo: " + c_t_nombre + "\n" + "Usuario: " + ap_pate_empl + " " + ap_mate_empl + " " + no_empl);
		
		// Definir usuario
		UsuarioLogged obj = new UsuarioLogged();
		obj.setC_t_nombre(c_t_nombre);
		obj.setNo_empl(no_empl);
		obj.setAp_pate_empl(ap_pate_empl);
		obj.setAp_mate_empl(ap_mate_empl);
		obj.setNo_area(no_area);
		
		// Crear objeto JSON
		UtilController.usuarioJSON(response, obj);
	}
	
	
	private void getLista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Entrada
		
		HttpSession session = request.getSession();
		String DNI = (String) session.getAttribute("DNI");
						
		// Proceso
		ListarService service = new ListarService();
		List<Sistema> lista = service.getLista(DNI)	;
		
		String mensaje = "";
		for(Sistema sist : lista ) {
			mensaje += "Nombre de sistema: " + sist.getSistema() + "---------->" + "Estado: "+ sist.getIn_estd() + "\n";
		}
		System.err.println("==========================LISTA DE SISTEMAS============================\n" + mensaje);
		
		// Crear cadena JSON
		Gson gson = new Gson();
		String cadenaJson = gson.toJson(lista);
		// Respuesta
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(cadenaJson);
		response.getWriter().flush();
		
	}

}
