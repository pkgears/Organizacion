package clases;

public class Actividad {
	private String descripcion, 
					tipo, 
					fecha, 
					hora, 
					duración, 
					nombre_persona, 
					nombre_organizacion,
					nombre_negocio;
	
	public Actividad(){
		
	}

	public Actividad(String descripcion, String tipo, String fecha, String hora, String duración, String nombre_persona,
			String nombre_organizacion, String nombre_negocio) {
		super();
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.fecha = fecha;
		this.hora = hora;
		this.duración = duración;
		this.nombre_persona = nombre_persona;
		this.nombre_organizacion = nombre_organizacion;
		this.nombre_negocio = nombre_negocio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripción(String descripción) {
		this.descripcion = descripción;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDuracion() {
		return duración;
	}

	public void setDuracion(String duración) {
		this.duración = duración;
	}

	public String getNombrePersona() {
		return nombre_persona;
	}

	public void setNombrePersona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}

	public String getNombreOrganizacion() {
		return nombre_organizacion;
	}

	public void setNombreOrganizacion(String nombre_organizacion) {
		this.nombre_organizacion = nombre_organizacion;
	}

	public String getNombreNegocio() {
		return nombre_negocio;
	}

	public void setNombreNegocio(String nombre_negocio) {
		this.nombre_negocio = nombre_negocio;
	}
	
	
}
