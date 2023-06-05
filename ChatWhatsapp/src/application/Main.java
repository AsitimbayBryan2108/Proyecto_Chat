package application;
	
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dominio.Chat;
import dominio.Mensaje;
import dominio.Usuario;
import Repositorio.ChatRepositorio;
import Repositorio.MensajeRepositorio;
import Repositorio.UsuarioRepositorio;
import diseño.Mensajes;
import diseño.Layout1;
import diseño.ImagenPerfil;
import diseño.ImagenChat;
import diseño.Layout2;
import diseño.ImagenSuperior;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Main extends Application 
{
	UsuarioRepositorio usuarios = new UsuarioRepositorio();
	MensajeRepositorio mensajes = new MensajeRepositorio();
	ChatRepositorio chats = new ChatRepositorio();
	
	public static void main(String[] args) {
		launch(args);
	}
	
    @Override
    public void start(Stage stage1) throws Exception { 	
    	Layout1 scene = new Layout1();
       	scene.contenidoVbox1();  
    	Scene scene1 = new Scene(scene.anchor(), 360, 280);
    	scene1.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
    	stage1.setTitle("Whatsapp");
    	stage1.setScene(scene1);
    	stage1.show();  	
    	scene.styles();
    	scene.getIniciar().setOnAction(new EventHandler<ActionEvent>() {
			
	@Override
	public void handle(ActionEvent event) {
		if(usuarios.password(scene.getUsertext().getText(), scene.getClavetext().getText()) == null) {
			scene.notificar(scene.getUsertext().getText(), scene.getClavetext().getText());	
			stage1.close();
			Stage stage2 = new Stage();
			Scene scene2 = new Scene(scene.contenidoVbox2(), 250, 150);
			scene2.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
			stage2.setTitle("Incorrecto");
			stage2.setScene(scene2);
			stage2.show();				
			scene.getRegresar().setOnAction(new EventHandler<ActionEvent>() 
			{	
				@Override
				public void handle(ActionEvent event) 
				{
					scene.getUsertext().clear();
					scene.getClavetext().clear();
					stage2.close();
					stage1.show();
				}
				});				
	}
		
		else {
			stage1.close();
			
			Layout2 escena2 = new Layout2(10);
			escena2.getPanelIzq().setContent(escena2.getVbox());
			
			ImagenSuperior topleft = new ImagenSuperior(scene.getUsertext().getText());
			topleft.styles();
			ImagenSuperior topright = new ImagenSuperior();
			Mensajes inferior = new Mensajes();
			inferior.styles();
			escena2.setInferior(inferior.getHbox());
			topleft.topLeft();
			escena2.setSuperiorIzquierdo(topleft.getTopleft());
			escena2.setSuperiorDerecho(topright.getTopright());
			escena2.anchor1();
								
			Usuario usuario = usuarios.userName(scene.getUsertext().getText());
			
			int incremento = 0;
			for(Chat activos: chats.getChat(usuario.getId())) {
				ImagenPerfil imagenPerfil = new ImagenPerfil();
				imagenPerfil.styles();
				imagenPerfil.contenido(activos.getUsuario().getImagen(), activos.getUsuario().getNombre(), 
				activos.getMensaje().getMensaje(), activos.getMensaje().getFecha());
				
				imagenPerfil.leftDesign();
				imagenPerfil.getLeftdesign().setId(String.valueOf(activos.getUsuario().getId()));	
				
				escena2.setDiseñoIzquierdo(imagenPerfil.getLeftdesign());
				escena2.getVbox().getChildren().add(escena2.getDiseñoIzquierdo());
				
				incremento = incremento + 1;

				imagenPerfil.getLeftdesign().addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

	 @Override
	 public void handle(MouseEvent event) {	
				Layout2 fp = new Layout2();	
				Usuario contacto = usuarios.userId(Integer.valueOf(imagenPerfil.getLeftdesign().getId()));
						
				topright.getTopright().getChildren().clear();
				topright.topRight(contacto.getId());
						
				escena2.visible();
				//escena2.styles();
				escena2.getPanelDer().setVvalue(1.0);									
					
				for(Mensaje msj: mensajes.conversaciones(usuario.getId(), contacto.getId())) {
				ImagenChat imagenChat = new ImagenChat();
				imagenChat.styles();
							
				if(msj.getUsuario1().getId() == usuario.getId()) {		
				imagenChat.messageUser(msj.getUsuario1().getImagen(), msj.getMensaje(), msj.getFecha());										
				fp.getFlowpane().getChildren().add(imagenChat.getLadoDerecho());
				}
							
				else{
					imagenChat.messageContact(msj.getUsuario1().getImagen(), msj.getMensaje(), msj.getFecha());
					fp.getFlowpane().getChildren().add(imagenChat.getLadoDerecho());	
					}

				inferior.getBoton().setOnAction(new EventHandler<ActionEvent>() {
	
								
	 @Override
	 public void handle(ActionEvent event) {
		 if(!inferior.getTexto().getText().equals("")) {	
										
		DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("dd MMM, YYYY  HH:mm");
		LocalDateTime fecha = LocalDateTime.now();
										
		ImagenChat imagenChat = new ImagenChat();
		imagenChat.styles();

		imagenChat.messageUser(usuario.getImagen(), inferior.getTexto().getText(), fecha);

		fp.getFlowpane().getChildren().add(imagenChat.getLadoDerecho());
											
		imagenPerfil.getMensaje().setText(inferior.getTexto().getText());
		imagenPerfil.getDatetime().setText(datetimeformat.format(fecha));
											
		escena2.ajusteDesplDer(fp.getFlowpane());
										
		Mensaje newMessage = new Mensaje(activos.getMensaje().getId()+1, usuario, contacto, fecha, inferior.getTexto().getText());											
		mensajes.addMensajes(newMessage);
		inferior.getTexto().clear();
												
				}
			}
		});
								
		escena2.getPanelDer().setContent(fp.getFlowpane());
				}			
			}
		});
	}					
		Stage stage3 = new Stage();
		Scene scene3 = new Scene(escena2.getAnchorPane(), 1000, 600);
		scene3.setFill(Color.AQUAMARINE);
		scene3.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
		stage3.setTitle("Mensajeria");
		stage3.setScene(scene3);
		stage3.show();
		topleft.getLogout().setOnAction(new EventHandler<ActionEvent>() {
						
			@Override
			public void handle(ActionEvent arg0) {
				scene.getUsertext().clear();
				scene.getClavetext().clear();

				stage3.close();
				stage1.show();
			
			}
		});
	}	
}
});
}
}

