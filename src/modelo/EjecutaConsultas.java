package modelo;

import controlador.*;

import java.sql.*;

public class EjecutaConsultas {
	
	//String pruebas = "";
	
	private Conexion miConexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaSeccion, enviaConsultaCiudad, enviaConsultaAmbos;
	
	private final String consultaSeccion = "SELECT SECCION, PRECIO, CIUDAD FROM productos WHERE SECCION=?";
	
	private final String consultaCiudad = "SELECT SECCION, PRECIO, CIUDAD FROM productos WHERE CIUDAD=?";
	
	private final String consultaAmbos = "SELECT SECCION, PRECIO, CIUDAD FROM productos WHERE CIUDAD=? AND SECCION=?";
	
	
	public EjecutaConsultas() {
		
		miConexion = new Conexion();
	}
	
	
	public ResultSet filtaBaseDatos(String seccion, String pais) {
		
		Connection conecta = miConexion.dameConexion();
		
		rs=null;
		
		try {
			
		
		if (!seccion.equals("Todos") && pais.equals("Todos")) {
			
			//pruebas = "Has escogido Seccion";
			enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
			
			enviaConsultaSeccion.setString(1,seccion);
			
			rs = enviaConsultaSeccion.executeQuery();
			
			
			
		}else if (seccion.equals("Todos") && !pais.equals("Todos")) {
			
			 enviaConsultaCiudad = conecta.prepareStatement(consultaCiudad);
			 
			 enviaConsultaCiudad.setString(1,pais);
			 
			
			 
			 rs = enviaConsultaCiudad.executeQuery();
			
		}else {
			
			//pruebas = "Has escogido Ambos";
			
			 enviaConsultaAmbos = conecta.prepareStatement(consultaAmbos);
			 
			 enviaConsultaAmbos.setString(1,pais);
			 
			 enviaConsultaAmbos.setString(2,seccion);
			 
			 rs = enviaConsultaAmbos.executeQuery();
		}
		
		}catch(Exception e) {
			
			
		}
		//return pruebas;
		
		return rs;
	}

}
