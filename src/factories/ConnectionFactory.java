package factories;

import java.sql.Connection;
import java.sql.DriverManager;

//F�brica de conex�es..
public class ConnectionFactory {

	//atributos constantes
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bdprojeto05?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "coti";
	
	//m�todo para retornar uma conex�o com o banco de dados
	public static Connection getConnection() throws Exception {
		//retornar uma instancia de conex�o com o mysql
		return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
	}
}
