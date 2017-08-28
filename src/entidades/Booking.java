package entidades;
import java.sql.Date;
import java.sql.Time;

public class Booking {
	private String detalle;
	private Date fecha;
	private Time hora;
	private BookableTypes tipoElemento;
	private BookableItems elemento;
	
	
	public Booking(String detalle, Date fecha, Time hora, BookableTypes tipoElemento, BookableItems elemento) {
		super();
		this.detalle = detalle;
		this.fecha = fecha;
		this.hora = hora;
		this.tipoElemento = tipoElemento;
		this.elemento = elemento;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public BookableTypes getTipoElemento() {
		return tipoElemento;
	}


	public void setTipoElemento(BookableTypes tipoElemento) {
		this.tipoElemento = tipoElemento;
	}


	public BookableItems getElemento() {
		return elemento;
	}


	public void setElemento(BookableItems elemento) {
		this.elemento = elemento;
	}
	
	
}
