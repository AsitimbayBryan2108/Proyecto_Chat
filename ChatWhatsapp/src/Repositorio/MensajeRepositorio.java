package Repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dominio.Mensaje;
import dominio.Usuario;

public class MensajeRepositorio 
{
	
	private List<Mensaje> mensajes = new ArrayList<Mensaje>();
	private UsuarioRepositorio usuario = new UsuarioRepositorio();
	
	public MensajeRepositorio() 
	{
		Usuario Bryan = usuario.userId(1);
		Usuario Danny = usuario.userId(2);
		Usuario David = usuario.userId(3);
		
		//Bryan//
		mensajes.add(new Mensaje(1, Danny, Bryan, LocalDateTime.of(2022, 11, 16, 12, 30), "Oye el barca si que roba partidos!"));
		mensajes.add(new Mensaje(2, Bryan, Danny, LocalDateTime.of(2022, 11, 16, 12, 30), "Que dice si va volando y sin 12 jugadores en la cancha"));
		mensajes.add(new Mensaje(3, Bryan, David, LocalDateTime.of(2022, 11, 16, 12, 30), "Confirma para caer al city mall"));
		mensajes.add(new Mensaje(4, David, Bryan, LocalDateTime.of(2022, 11, 16, 12, 30), "Dale pilas"));

		//Danny//
		mensajes.add(new Mensaje(5, Danny, David, LocalDateTime.of(2022, 11, 16, 12, 30), "Pilas ese peloteo en samanes"));
		mensajes.add(new Mensaje(6, David, Danny, LocalDateTime.of(2022, 11, 16, 12, 30), "De una loco a que hora ?"));		
		mensajes.add(new Mensaje(7, Danny, Bryan, LocalDateTime.of(2022, 11, 16, 12, 30), "jajajajaja no molestes"));
		mensajes.add(new Mensaje(8, Bryan, Danny, LocalDateTime.of(2022, 11, 16, 12, 30), "Ya vas a ver que ahora viene el triplete de xavi"));
	
		//David//
		mensajes.add(new Mensaje(9, David, Bryan, LocalDateTime.of(2022, 11, 16, 12, 30), "Pero a que hora? mas o menos"));
		mensajes.add(new Mensaje(10, Bryan, David, LocalDateTime.of(2022, 11, 16, 12, 30), "A eso de las 3"));	
		mensajes.add(new Mensaje(11, Danny, David, LocalDateTime.of(2022, 11, 16, 12, 30), "Vamos en la mañana tipo 10"));
		mensajes.add(new Mensaje(12, David, Danny, LocalDateTime.of(2022, 11, 16, 12, 30), "Claro ahi no hay mucha gente"));	
	}
	
	public List<Mensaje> getMensajes()
	{
		return mensajes;
	}
	
	public List<Mensaje> conversaciones(int usuario1, int usuario2) 
	{
		List<Mensaje> resultado = new ArrayList<Mensaje>();
		for(Mensaje msj: mensajes) {
			if((msj.getUsuario1().getId() == usuario1 && msj.getUsuario2().getId() == usuario2) || (
					msj.getUsuario1().getId() == usuario2 && msj.getUsuario2().getId() == usuario1))
				resultado.add(msj);
		}
		return resultado;		
	}
	
	public Mensaje getUltimoMsj(int usuario1, int usuario2) 
	{
		List<Mensaje> resultado = conversaciones(usuario1, usuario2);		
		if(resultado.size() == 0)
			return null;
		return resultado.get(resultado.size()-1);		
	}
	
	public void addMensajes(Mensaje mensaje) 
	{
		mensajes.add(mensaje);		
	}

}
