package dominio;

public class Chat {
	
	private Usuario usuario;
	private Mensaje mensaje;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	public Chat(Usuario usuario, Mensaje mensaje) 
	{
		this.usuario = usuario;
		this.mensaje = mensaje;
	}


}
