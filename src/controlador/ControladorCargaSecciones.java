package controlador;

import vista.*;
import modelo.*;

import java.awt.event.*;

public class ControladorCargaSecciones extends WindowAdapter{
	
	
	cargaSecciones obj = new cargaSecciones();
	
	private Marco_Aplicacion elmarco;
	
	
	public ControladorCargaSecciones (Marco_Aplicacion elmarco) {
		
		this.elmarco = elmarco;
	}
	
	public void windowOpened(WindowEvent e) {
		
		obj.ejecutaConsultas();
		
		try {
			
			while(obj.rs.next()) {
				
				elmarco.secciones.addItem(obj.rs.getString(1));
				
			}
			
		}catch(Exception e2) {
			
			e2.printStackTrace();
		}
		
	}

}
