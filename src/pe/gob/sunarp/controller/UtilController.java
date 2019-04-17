package pe.gob.sunarp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.gob.sunarp.util.Mensaje;
import pe.gob.sunarp.util.UsuarioLogged;

public class UtilController {
	
	public static void messageJSON(HttpServletResponse response, Mensaje message) throws IOException {
		
		Gson gson = new Gson();
		String textoJson = gson.toJson(message);
		
		// Respuesta
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(textoJson);
		response.getWriter().flush();
		System.err.println("\ntextoJson: " + textoJson);
		
	}
	
	public static void usuarioJSON(HttpServletResponse response, UsuarioLogged obj) throws IOException {
		
		Gson gson = new Gson();
		String textoJson = gson.toJson(obj);
		
		// Respuesta
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(textoJson);
		response.getWriter().flush();
		System.err.println("\ntextoJson: " + textoJson);
		
	}
	
}
