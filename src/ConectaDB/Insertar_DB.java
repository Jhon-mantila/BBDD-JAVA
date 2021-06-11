package ConectaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insertar_DB {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		try {
			
			// 1. Crear Conexión
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio", "root", ""); 
			
			//2. Crear Objecto Statement
			
			Statement miStatement = miConexion.createStatement();
			
			
			//3. Insertar registros
			
			/*String intruccionSql = "INSERT INTO productos (nombre, precio, fecha, ciudad) VALUES ('ZANAHORIA', 550.2, '2021-02-15', 'BOGOTA')";
									
			int registro = miStatement.executeUpdate(intruccionSql);*/
			
			
			/*String actSql = "UPDATE productos SET precio=325 WHERE codigo = 9";
			
			miStatement.executeUpdate(actSql);*/
			
			String delSql = "DELETE FROM productos WHERE codigo=9";
			
			miStatement.executeUpdate(delSql);
			
			
		
			
		}catch(Exception e) {
			
			System.out.println("NO CONECTA");
			
			e.printStackTrace();
			
		}

	}

}
