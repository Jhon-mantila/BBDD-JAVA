package ConectaDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Marco_Aplicacion mimarco = new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Marco_Aplicacion extends JFrame{
	
	private Connection miConexion;
	
	private PreparedStatement PreparadaSeccion;
	
	private PreparedStatement PreparadaCiudad;
	
	private PreparedStatement PreparadaTodos;
	
	private final String ConsultaSección="SELECT codigo, seccion, nombre, precio, ciudad FROM productos WHERE seccion=?";
	
	private final String ConsultaCiudades= "SELECT codigo, seccion, nombre, precio, ciudad FROM productos WHERE ciudad=?";
	
	private final String ConsultaTodos = "SELECT codigo, seccion, nombre, precio, ciudad FROM productos WHERE seccion=? AND ciudad=?";
	
	private JComboBox secciones, paises;
	
	private JTextArea resultado;
	
	
	public Marco_Aplicacion() {
		
		setTitle("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout (new BorderLayout());
		
		JPanel menus =new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		
		secciones = new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises = new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		
		resultado = new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);
		
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta = new JButton("Consultar");
		
		botonConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				ejecutaConsulta();
			}
			
			
		});
		
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		setVisible(true);
		
		//CONECTAR CON LA BASE DE DATOS
		
		try {
			
			// 1. Crear Conexión
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio", "root", ""); 
			
			//2. Crear Objecto Statement
			
			Statement miStatement = miConexion.createStatement();
			
			//3. Ejecutar sql
			
			String consulta= "SELECT DISTINCTROW seccion FROM productos";
			
			ResultSet miResultado = miStatement.executeQuery(consulta);
			
			//4. Recorrer el ResulSet
			
			while (miResultado.next()) {
				
				secciones.addItem(miResultado.getString(1));
			}
			
			miResultado.close();
			
			
			///////////////////////// CONSULTA PAISES EN EL COMBO BOX /////////////////////////////////
			
			//3. Ejecutar sql
			
			consulta= "SELECT DISTINCTROW ciudad FROM productos";
			
			miResultado = miStatement.executeQuery(consulta);
			
			//4. Recorrer el ResulSet
			
			while (miResultado.next()) {
				
				paises.addItem(miResultado.getString(1));
			}
			
			miResultado.close();
			
			
		}catch(Exception e) {
			
			System.out.println("NO CONECTA");
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
	private void ejecutaConsulta() {
		
		ResultSet rs=null;
		
		String seccion=(String) secciones.getSelectedItem();
		
		String ciudad = (String) paises.getSelectedItem();
		
		try {
			
			resultado.setText("");
			
			if (!seccion.equals("Todos") && ciudad.equals("Todos")) {	
			
				PreparadaSeccion = miConexion.prepareStatement(ConsultaSección);
				
				PreparadaSeccion.setString(1,seccion);
				
				rs = PreparadaSeccion.executeQuery();
			
			}else if (seccion.equals("Todos") && !ciudad.equals("Todos")) {
				
				PreparadaCiudad = miConexion.prepareStatement(ConsultaCiudades);
				
				PreparadaCiudad.setString(1, ciudad);
				
				rs = PreparadaCiudad.executeQuery();
				
			}else if (!seccion.equals("Todos") && !ciudad.equals("Todos")) {
				
				PreparadaTodos = miConexion.prepareStatement(ConsultaTodos);
				
				PreparadaTodos.setString(1, seccion);
				
				PreparadaTodos.setString(2, ciudad);
				
				rs = PreparadaTodos.executeQuery();
				
			}
			
			
			while (rs.next()) {
				
				resultado.append(rs.getString("codigo")+"  "+ rs.getString("seccion")+"  "+rs.getString("nombre")+ "  "+ rs.getString("ciudad") +"\n");
			}
			
			
		} catch (SQLException e) {
			
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		
		
		
	}
}
