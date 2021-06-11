package ConectaDB;

import java.sql.*;

public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		try {
			
			//1. Conexion 
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio", "root", "");
			
			//2. Crear Objecto PrepareStatement
			
			PreparedStatement sentencia  = miConexion.prepareStatement("SELECT * FROM productos WHERE ciudad=? and seccion=?");		
				//Establecer parametros de la sentencia	
			sentencia.setString(1, "MEDELLIN");
			sentencia.setString(2, "TECNOLOGIA");
			
			//3. Ejecutar sql
			ResultSet resultado = sentencia.executeQuery();	
			
			//4. Recorrer el resultado
			while (resultado.next()) {
				
				System.out.println(resultado.getInt("codigo") + " " + resultado.getString("nombre"));
			}
			
			resultado.close();
					
		}catch(Exception e) {
			
			System.out.println("NO CONECTA");
			
			e.printStackTrace();
		}

	}

}
