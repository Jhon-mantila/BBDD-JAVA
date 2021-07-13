package modelo;

public class productos {

	private int codigo;
	
	private String nProducto;
	
	private String seccion;
	
	private Double precio;
	
	private String ciudad;
	
	public productos() {
		
		codigo = 0;
		
		nProducto = "";
		
		seccion = "";
		
		precio = 0.0;
		
		ciudad = "";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getnProducto() {
		return nProducto;
	}

	public void setnProducto(String nProducto) {
		this.nProducto = nProducto;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
