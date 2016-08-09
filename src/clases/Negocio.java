package clases;

public class Negocio {
	private String título, 
					descripción, 
					nombre_organización, 
					nombre_persona, 
					fecha_cierre,
					estado;
	private float valor;
	
	public Negocio(){
		
	}
	

	public Negocio(String título, String descripción, String nombre_organización, String nombre_persona,
			String fecha_cierre, String estado, float valor) {
		super();
		this.título = título;
		this.descripción = descripción;
		this.nombre_organización = nombre_organización;
		this.nombre_persona = nombre_persona;
		this.fecha_cierre = fecha_cierre;
		this.estado = estado;
		this.valor = valor;
	}


	public String getTítulo() {
		return título;
	}

	public void setTítulo(String título) {
		this.título = título;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public String getNombreOrganización() {
		return nombre_organización;
	}

	public void setNombreOrganización(String nombre_organización) {
		this.nombre_organización = nombre_organización;
	}

	public String getNombrePersona() {
		return nombre_persona;
	}

	public void setNombrePersona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}

	public String getFechaCierre() {
		return fecha_cierre;
	}

	public void setFechaCierre(String fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
