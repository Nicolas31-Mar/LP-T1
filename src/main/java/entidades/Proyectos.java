package entidades;

public class Proyectos {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String fecInicio;
	private String fecCulminacion;
	private String asesor;
	private double presupuesto;
	
	public Proyectos() {
		super();
	}

	public Proyectos(int id, String nombre, String descripcion, String fecInicio, String fecCulminacion, String asesor,
			double presupuesto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecInicio = fecInicio;
		this.fecCulminacion = fecCulminacion;
		this.asesor = asesor;
		this.presupuesto = presupuesto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(String fecInicio) {
		this.fecInicio = fecInicio;
	}

	public String getFecCulminacion() {
		return fecCulminacion;
	}

	public void setFecCulminacion(String fecCulminacion) {
		this.fecCulminacion = fecCulminacion;
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
}
