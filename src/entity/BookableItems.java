package entity;

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
	
	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public BookableTypes getTipoElemento() {
		return tipoElemento;
	}
	
}
