package ConectaDB;

import java.sql.*;

public class Conectar {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		try {
			
			// 1. Crear Conexi�n
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio", "root", ""); 
			
			//2. Crear Objecto Statement
			
			Statement miStatement = miConexion.createStatement();
			
			
			//3. Ejecutar sql
			
			ResultSet miResultado = miStatement.executeQuery("SELECT * FROM productos");
			
			//4. Recorrer el ResulSet
			
			while (miResultado.next()) {
				
				System.out.println(miResultado.getInt("codigo")+ " " + miResultado.getString("nombre")+" "+ (miResultado.getDouble("precio")+100)+" "+ miResultado.getDate("Fecha")+" " +miResultado.getString("ciudad"));
			}
			
		}catch(Exception e) {
			
			System.out.println("NO CONECTA");
			
			e.printStackTrace();
			
		}
		

	}

}
