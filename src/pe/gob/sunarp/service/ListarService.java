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

public class ListarService {
	
	public List<Sistema> getLista(String DNI) {
		
		Connection cn = null;
		List<Sistema> lista = null;
		
        try {
        		// Conectamos a la BD
                cn = AccesoDB.getConnection();
                // Proceso
                
                String sql = "{call ADMINDB.SP_GET_SYSTEMS_PRUEBA(?,?)}";
                CallableStatement cstm = cn.prepareCall(sql);
                cstm.setString(1, DNI);
                cstm.registerOutParameter(2, OracleTypes.CURSOR);
                cstm.executeUpdate();
                ResultSet rs = (ResultSet) cstm.getObject(2);
                
                
                //lista = JdbcUtil.rsToList(rs);
                lista = new ArrayList<>();
                while (rs.next()) {
                	Sistema sist = mapRow(rs);
                    lista.add(sist);
                }

                rs.close();
                cstm.close();
                                
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
		
		return lista;
	}
	
	private Sistema mapRow(ResultSet rs) throws SQLException {

        Sistema sist = new Sistema();
        	
        sist.setCo_empl(rs.getString("CO_EMPL"));
        sist.setId_user(rs.getString("ID_USER"));
        sist.setIn_estd(rs.getString("IN_ESTD"));
        sist.setSistema(rs.getString("SISTEMA"));
        sist.setValor(rs.getString("VALOR"));
        sist.setTabla_dbl(rs.getString("TABLA_DBL"));
        sist.setTabla(rs.getString("TABLA"));
        sist.setDbl(rs.getString("DBL"));

        return sist;
    }
	
}
