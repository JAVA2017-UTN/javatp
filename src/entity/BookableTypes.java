package entity;

public class BookableTypes {
	private int id;
	private String nombre;
	private int cantReservasPendientes;
	
	public BookableTypes(int id, String nombre, int cantReservasPendientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantReservasPendientes = cantReservasPendientes;
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

	public int getCantReservasPendientes() {
		return cantReservasPendientes;
	}

	public void setCantReservasPendientes(int cantReservasPendientes) {
		this.cantReservasPendientes = cantReservasPendientes;
	}
	
	
	
	

}
