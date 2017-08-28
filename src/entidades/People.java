package entidades;

public class People {
	
	private int dni;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasenia;
	private boolean estado;
	private int id;

	
	public People() {
	dni = 0;
	nombre = null;
	apellido = null;
	usuario = null;
	contrasenia = null;
	estado = false;
	}
	
	public void setPeople(int dniNum, String nom, String ape, String usu, String con, boolean est) {
	dni = dniNum;
	nombre = nom;
	apellido = ape;
	usuario = usu;
	contrasenia = con;
	estado = est;
	}
	
	
	private int getDni() {
		return dni;
	}
	
	private String getNombre() {
		return nombre;
	}
	
	private String getApellido() {
		return apellido;
	}
	
	private String getUsuario() {
		return usuario;
	}
	
	private boolean getEstado() {
		return estado;
	}
	
	private int getId() {
		return id;
	}

}
