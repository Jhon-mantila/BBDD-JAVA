package controlador;

import java.awt.event.*;
import java.sql.*;

import modelo.*;

import vista.*;

public class ControladorBtnEjecuta implements ActionListener {
	
	private Marco_Aplicacion elmarco;
	
	private ResultSet resultadoConsulta;
	
	EjecutaConsultas obj = new EjecutaConsultas();

	public ControladorBtnEjecuta(Marco_Aplicacion elmarco) {
		
		this.elmarco = elmarco;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
		String seleccionSeccion = (String)elmarco.secciones.getSelectedItem();
		
		String seleccionPais = (String)elmarco.paises.getSelectedItem();
		
		//elmarco.resultado.append(obj.filtaBaseDatos(seleccionSeccion, seleccionPais));
		
		//elmarco.resultado.append("\n");
		
		resultadoConsulta = obj.filtaBaseDatos(seleccionSeccion, seleccionPais);
		
		
		try {
		
			elmarco.resultado.setText(" ");
			
			while (resultadoConsulta.next()) {
				
				elmarco.resultado.append(resultadoConsulta.getString(1));
				
				elmarco.resultado.append("--");
				
				elmarco.resultado.append(resultadoConsulta.getString(2));
				
				elmarco.resultado.append("--");
				
				elmarco.resultado.append(resultadoConsulta.getString(3));
				
				elmarco.resultado.append("\n");
			}
			
		} catch (SQLException e) {
			
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		
	}

}
