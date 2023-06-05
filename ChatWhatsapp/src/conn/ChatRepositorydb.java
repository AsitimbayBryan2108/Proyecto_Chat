package conn;

import java.util.ArrayList;
import java.util.List;
import dominio.Chat;
import dominio.Mensaje;
import dominio.Usuario;

public class ChatRepositorydb {

	private UserRepositorydb usuario;
	private MessageRepositorydb mensaje;
		
	public ChatRepositorydb() {
		usuario = new UserRepositorydb();
		mensaje = new MessageRepositorydb();
	}

	public UserRepositorydb getUsuario() {
		return usuario;
	}

	public void setUsuario(UserRepositorydb usuario) {
		this.usuario = usuario;
	}

	public MessageRepositorydb getMensaje() {
		return mensaje;
	}

	public void setMensaje(MessageRepositorydb mensaje) {
		this.mensaje = mensaje;
	}
		
	public List<Chat> getChat(int userId){
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
