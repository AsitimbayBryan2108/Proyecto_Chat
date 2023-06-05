package Repositorio;

import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;

public class UsuarioRepositorio {

private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioRepositorio() {
		usuarios.add(new Usuario(1, "Bryan", "Asitimbay", "TRexAsitimbayBr", "12345", "En linea", "https://lofrev.net/wp-content/photos/2016/05/barca-logo.jpg"));
		usuarios.add(new Usuario(2, "Danny", "Rivadeneria", "Danny11", "1234", "En linea", "https://logos-world.net/wp-content/uploads/2020/06/Real-Madrid-symbol.png"));
		usuarios.add(new Usuario(3, "David", "Mendoza", "David977", "123", "Desconectado", "https://i.ytimg.com/vi/I-R7U8dQY3Q/hqdefault.jpg"));
	
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario userId(int id) {
		for(Usuario user: usuarios) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public Usuario userName(String username) {
		for(Usuario user: usuarios) {
			if(user.getUsername().equals(username))
				return user;
		}
		return null;
	}
	
	public Usuario password(String username, String clave) {
		for(Usuario user: usuarios) {
			if(user.getUsername().equals(username) && user.getClave().equals(clave))
				return user;
		}
		return null;
	}
	
}
