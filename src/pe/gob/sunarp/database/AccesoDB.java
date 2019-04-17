package pe.gob.sunarp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {
	 
	public static void main(String[] args) {
	
		try {
			getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
        Connection cn = null;
        try {
            // Paso 1: Cargar el driver a memoria 
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            // Paso 2: Obtener el objeto Connection 
            //String url = "jdbc:oracle:thin:@172.17.36.25:1521:XE";
            String url = "jdbc:oracle:thin:@172.20.90.47:1521:or0101";
            //String url = "jdbc:oracle:thin:@172.20.190.10:1530:or0101_1";
            //String url = "jdbc:oracle:thin:@localhost:1521:XE";
            
            cn = DriverManager.getConnection(url, "ADMINDB", "ADMINDB");
            
            System.err.println("\nConnect DB: " + url + "\n" + "User: ADMINDB");
            
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de la base de datos.");
        } catch (Exception e) {
            throw new SQLException("No se puede establecer la conexión con la BD.");
        }
        return cn;
    }
	
}
