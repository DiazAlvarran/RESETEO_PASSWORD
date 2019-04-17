package pe.gob.sunarp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import pe.gob.sunarp.database.AccesoDB;
import pe.gob.sunarp.models.Usuario;

public class LoginService {

	// ruta al servidor de red con protocolo ldap
	private final String LPDA_URL = "ldap://snrpzrixdc01.sunarp.gob.pe";

	// dominio para los usuarios
	private final String DOMAIN = "sunarp.gob.pe";

	// Método para loguearse desde el Active Directory (usuario y contraseña de red)
	public boolean login(String username, String password) {

		Hashtable env = new Hashtable();

		// configuración e ingreso de credenciales
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, LPDA_URL);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, username.toUpperCase() + "@" + DOMAIN); // usuario de red - Ejm:
																					// JPEREZ@sunarp.gob.pe
		env.put(Context.SECURITY_CREDENTIALS, password); // contraseña de red

		try {
			// Crear contexto inicial (validar parámetros ingresados)
			DirContext ctx = new InitialDirContext(env);

			return true; // Si el usuario y contraseña es correcto

		} catch (NamingException ex) {
			System.err.println("Credenciales incorrectas\n"+ 
								"NamingException: " + ex.getMessage());
		}

		return false; // Si el usuario o contraseña no es correcto

	}
	
	public static Usuario getUsuario(String user) {
		
		Connection cn = null;
		Usuario usuario = new Usuario();
		
        try {
        		// Conectamos a la BD
                cn = AccesoDB.getConnection();
                // Proceso
                
                String sql = "SELECT OTE.CO_EMPL, SP.C_T_NOMBRE, OTE.AP_PATE_EMPL, OTE.AP_MATE_EMPL, OTE.NO_EMPL, OTE.OSUSER, OTE.CO_USUA, OTE.IN_ESTD, SPTU.CO_AREA, SPTJ.DE_AREA, OTE.DNI\r\n" + 
                		"FROM ORLCDBA.TP_EMPL OTE, SIGARP.PERM_TA_USUA SPTU, SIGARP.PERM_TA_JEFE SPTJ, SIGARP.TRABAJADOR SP\r\n" + 
                		"WHERE\r\n" + 
                		"OTE.OSUSER = ? AND SPTU.CO_USUA = OTE.CO_USUA AND SPTJ.CO_AREA = SPTU.CO_AREA AND SP.C_C_LIB_ELECTORAL = OTE.DNI AND ROWNUM = 1";
                
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = cn.prepareStatement(sql); // creamos consulta
                ps.setString(1, user); // asignamos parámetros
                rs = ps.executeQuery(); // ejecutamos query
                
                if(rs.next()) {
                	
                    usuario.setCo_empl(rs.getString("CO_EMPL"));
                    usuario.setC_t_nombre(rs.getString("C_T_NOMBRE"));
                    usuario.setAp_pate_empl(rs.getString("AP_PATE_EMPL"));
                    usuario.setAp_mate_empl(rs.getString("AP_MATE_EMPL"));
                    usuario.setNo_empl(rs.getString("NO_EMPL"));
                    usuario.setOsuser(rs.getString("OSUSER"));
                    usuario.setCo_usua(rs.getString("CO_USUA"));
                    usuario.setIn_estd(rs.getString("IN_ESTD"));
                    usuario.setCo_area(rs.getString("CO_AREA"));
                    usuario.setNo_area(rs.getString("DE_AREA"));
                    usuario.setDNI(rs.getString("DNI"));

                }
                
                ps.close();
                rs.close();
                
        } catch (SQLException e) {
        	System.err.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
        	System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            	System.err.println("Exception: " + e.getMessage());
            }
        }
		
		return usuario;
	}

}
