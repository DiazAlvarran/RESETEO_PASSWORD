package pe.gob.sunarp.pruebas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pe.gob.sunarp.database.AccesoDB;
import pe.gob.sunarp.models.Sistema;
import pe.gob.sunarp.models.Usuario;
import pe.gob.sunarp.service.ListarService;
import pe.gob.sunarp.service.ResetService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String username = "GESPINOZAM";
		//String password = "Pushock8";
		
		//String username = "EENCARNACION";
		//String password = "Suna1306";
		
		/*String username = "RTAMBRAICO";
		String password = "Lorena14"*/;
		
		/*String username = "EENCARNACIONS";
		String password = "Suna1306";
		
		Login instance = new Login();	

		boolean result = instance.login(username, password);
		
		String mensajeLogin = result ? "Logueado" : "Ingrese nuevamente usuario y contraseña";
		
		System.out.println(mensajeLogin);*/
		
		/*
		Usuario u = getUsuario("CPUMA");
		*/
		
		/*ListarService service = new ListarService();
		List<Sistema> lista = service.getLista("73201250");
		
		String mensaje = "";
		
		for(Sistema sist : lista ) {
			mensaje += "Nombre de sistema: " + sist.getSistema() + " ----------> " + "EXISTE: " + sist.getExiste() + "\n";
		}
		
		System.out.println("==========================LISTA DE SISTEMAS============================\n" + mensaje);*/
		
		
		
		
		/*=============================================================================
		 * ====================================PRUEBA ResetService.java================
		 * ============================================================================*/
		
		// Entradas
		String id_user = "JDIAZA";
		String dbl = "@DBL_0101_UNICA";
		
		// Salida
		String mensaje = "";
		
		ResetService service = new ResetService();
		mensaje += service.resetPassword(id_user, dbl);
		
		System.err.println(mensaje);
		
	}
}
