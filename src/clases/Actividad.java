package clases;

public class Actividad {
	private String descripción, 
					tipo, 
					fecha, 
					hora, 
					duración, 
					nombre_persona, 
					nombre_organización,
					nombre_negocio;
	
	public Actividad(){
		
	}

	public Actividad(String descripción, String tipo, String fecha, String hora, String duración, String nombre_persona,
			String nombre_organización, String nombre_negocio) {
		super();
		this.descripción = descripción;
		this.tipo = tipo;
		this.fecha = fecha;
		this.hora = hora;
		this.duración = duración;
		this.nombre_persona = nombre_persona;
		this.nombre_organización = nombre_organización;
		this.nombre_negocio = nombre_negocio;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
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

	public String getDuración() {
		return duración;
	}

	public void setDuración(String duración) {
		this.duración = duración;
	}

	public String getNombrePersona() {
		return nombre_persona;
	}

	public void setNombrePersona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}

	public String getNombreOrganización() {
		return nombre_organización;
	}

	public void setNombreOrganización(String nombre_organización) {
		this.nombre_organización = nombre_organización;
	}

	public String getNombreNegocio() {
		return nombre_negocio;
	}

	public void setNombreNegocio(String nombre_negocio) {
		this.nombre_negocio = nombre_negocio;
	}
	
	
}
