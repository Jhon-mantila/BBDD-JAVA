package vista;

import java.awt.*;

import javax.swing.*;

import controlador.*;

public class Marco_Aplicacion extends JFrame{

	public JComboBox secciones, paises;
	
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
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		addWindowListener(new ControladorCargaSecciones(this));
		
		setVisible(true);
	}
}
