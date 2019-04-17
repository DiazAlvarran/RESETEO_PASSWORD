package pe.gob.sunarp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;
import pe.gob.sunarp.database.AccesoDB;
import pe.gob.sunarp.models.Sistema;

public class ResetService {
	
	public String resetPassword(String id_user, String dbl) {
		
		// Entradas
		Connection cn = null;
		String mensaje = "";
				
        try {
        		// Conectamos a la BD
                cn = AccesoDB.getConnection();
                
                // Proceso
                String sql = "{call ADMINDB.SP_RESET_PASS(?,?)}";
                CallableStatement cstm = cn.prepareCall(sql);
                cstm.setString(1, id_user);
                cstm.setString(2, dbl);            
                cstm.executeUpdate();

                cstm.close();
                
                mensaje += "\nSe ha reseteado la contraseña en : " + dbl;
                                
        } catch (SQLException e) {
        	mensaje += e.getMessage();
        	System.err.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
        	mensaje += e.getMessage();
        	System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            	mensaje = e.getMessage();
            	System.err.println("Exception: " + e.getMessage());
            }
        }
		
        return mensaje;
	}
	
}
