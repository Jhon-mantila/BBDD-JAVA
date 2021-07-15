package modelo;

import java.sql.*;
import controlador.*;


public class cargaMenus {
	
	 Conexion miConexion;
	 
	 public ResultSet rs;
	 
	 public ResultSet  rs2;
	 
	 public cargaMenus(){
		 
		 miConexion = new Conexion();
		  
	 }
	 
	 public String ejecutaConsultas() {
		 
		 productos miProducto = null;
		 
		 Connection accesoBBDD = miConexion.dameConexion();
		 
		 try {
			 
			 Statement secciones = accesoBBDD.createStatement();
			 
			 Statement paises = accesoBBDD.createStatement();
			 
			 rs = secciones.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");
			 
			 rs2 = paises.executeQuery("SELECT DISTINCTROW CIUDAD FROM PRODUCTOS");
			 
			 while(rs.next()) {
				 
				 miProducto = new productos();
				 
				 miProducto.setSeccion(rs.getString(1));
				 
				 miProducto.setCiudad(rs2.getString(1));
				 
				 //return miProducto.getSeccion();
				 
			 }
			 
			 rs.close();
			 
			 rs2.close();
			 
			 accesoBBDD.close();
			 
		 }catch(Exception e) {
			 
			 
		 }
		 
		 return miProducto.getSeccion();
		 
	 }
	 
	 
}
