package entity;

public class BookableItems {
	private int id;
	private String nombre;
	private int id_tipoElemento;


	public BookableItems() {
		nombre = null;
	}
	
	public void setBookableItems(int id, String nom, int id_tipo) {
		this.id = id;
		nombre = nom;
		id_tipoElemento = id_tipo;
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

	public int getId_tipoElemento() {
		return id_tipoElemento;
	}

	public void setId_tipoElemento(int id_tipoElemento) {
		this.id_tipoElemento = id_tipoElemento;
	}

	
}
