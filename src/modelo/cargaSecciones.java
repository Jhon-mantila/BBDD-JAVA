package modelo;

import java.sql.*;
import controlador.*;


public class cargaSecciones {
	
	 Conexion miConexion;
	 
	 public ResultSet rs;
	 
	 public cargaSecciones(){
		 
		 miConexion = new Conexion();
		  
	 }
	 
	 public String ejecutaConsultas() {
		 
		 productos miProducto = null;
		 
		 Connection accesoBBDD = miConexion.dameConexion();
		 
		 try {
			 
			 Statement secciones = accesoBBDD.createStatement();
			 
			 rs = secciones.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");
			 
			 while(rs.next()) {
				 
				 miProducto = new productos();
				 
				 miProducto.setSeccion(rs.getString(1));
				 
				 return miProducto.getSeccion();
				 
			 }
			 
			 rs.close();
		 }catch(Exception e) {
			 
			 
		 }
		 
		 return miProducto.getSeccion();
		 
	 }
	 
	 
}
