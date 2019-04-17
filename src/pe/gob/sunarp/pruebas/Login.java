package pe.gob.sunarp.pruebas;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class Login {
	
	// ruta al servidor de red con protocolo ldap
	private final String LPDA_URL = "ldap://snrpzrixdc01.sunarp.gob.pe"; 
	
	// dominio para los usuarios
	private final String DOMAIN = "sunarp.gob.pe";
	
	// M�todo para loguearse desde el Active Directory (usuario y contrase�a de red)
	public boolean login(String username, String password) {
		
		Hashtable env = new Hashtable();
		
		// configuraci�n e ingreso de credenciales
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, LPDA_URL);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, username.toUpperCase() + "@" + DOMAIN); // usuario de red - Ejm: JPEREZ@sunarp.gob.pe
		env.put(Context.SECURITY_CREDENTIALS, password); // contrase�a de red

		try {
			
			// Crear contexto inicial (validar par�metros ingresados)
			DirContext ctx = new InitialDirContext(env);
			
			return true; // Si el usuario y contrase�a es correcto
			
		} catch (NamingException ex) {

			ex.printStackTrace();

		}

		return false; // Si el usuario y contrase�a no es correcto

	}

}
