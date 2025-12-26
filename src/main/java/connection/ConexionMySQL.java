package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
	// Atributos
	private static final String	HOST ="localhost";
	private static final String	PUERTO ="3306";
	private static final String	BASE_DE_DATOS ="db_cesta_fresca";
	private static final String	USUARIO ="root";
	private static final String	PASSWORD ="";
	private static final String	URL ="jdbc:mysql://"+HOST+":"+PUERTO+"/"+BASE_DE_DATOS+"?serverTimezone=America/Lima";
	// Metodos
	
	public static Connection obtenerConexion() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(URL,USUARIO,PASSWORD);
	
	}
		
}
