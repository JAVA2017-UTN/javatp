package entidades;

public class BookableItems {
	private int id;
	private String nombre;
	private BookableTypes tipoElemento;


	public BookableItems() {
		nombre = null;
		tipoElemento = null;
	}
	
	public void setBookableItems(String nom, BookableTypes tipo) {
		nombre = nom;
		tipoElemento = tipo;
	}
	
	private String getNombre() {
		return nombre;
	}
	
	private int getId() {
		return id;
	}
	
	private BookableTypes getTipoElemento() {
		return tipoElemento;
	}
	
}
