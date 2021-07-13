package controlador;

import java.sql.*;

public class Conexion {
	
	private Connection miConexion;
	
	public Conexion() {
		
	}
	
	public Connection dameConexion() {
		
		
		try {
			
			// 1. Crear Conexión
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio", "root", ""); 
			
		}catch(Exception e){
			
			System.out.println("No Conecto");
			
		}
		
		return miConexion;
	}

}
