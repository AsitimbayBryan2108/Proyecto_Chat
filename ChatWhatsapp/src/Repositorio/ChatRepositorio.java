package Repositorio;

import java.util.ArrayList;
import java.util.List;

import dominio.Chat;
import dominio.Mensaje;
import dominio.Usuario;

public class ChatRepositorio 
{
	
	private UsuarioRepositorio usuario;
	private MensajeRepositorio mensaje;
	
	public ChatRepositorio() 
	{
		usuario = new UsuarioRepositorio();
		mensaje = new MensajeRepositorio();
	}

	public UsuarioRepositorio getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRepositorio usuario) {
		this.usuario = usuario;
	}

	public MensajeRepositorio getMensaje() {
		return mensaje;
	}

	public void setMensaje(MensajeRepositorio mensaje) {
		this.mensaje = mensaje;
	}
	
	public List<Chat> getChat(int userId)
	{
		List<Chat> contactMsj = new ArrayList<Chat>();
		List<Usuario> contactos = usuario.getUsuarios();
		
		for(Usuario l: contactos) {
			if(l.getId() == userId)
				continue;			
			Mensaje ultimoMsj = mensaje.getUltimoMsj(userId, l.getId());			
			if(ultimoMsj == null)
				continue;		
			Usuario contacto = usuario.userId(l.getId());		
			contactMsj.add(new Chat(contacto, ultimoMsj));		
		}				
		return contactMsj;		
	}

}
