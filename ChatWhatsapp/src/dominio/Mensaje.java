package dominio;

import java.time.LocalDateTime;

public class Mensaje {
	
	private int id;
	private Usuario usuario1;
	private Usuario usuario2;
	private LocalDateTime fecha;
	private String mensaje;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Mensaje(int id, Usuario usuario1, Usuario usuario2, LocalDateTime fecha, String mensaje) 
	{
		this.id = id;
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.fecha = fecha;
		this.mensaje = mensaje;
	}
	
}
