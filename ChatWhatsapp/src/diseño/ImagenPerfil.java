package diseño;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class ImagenPerfil 
{
	private Circle imagen;
	private Label nombre;
	private Label mensaje;
	private Label datetime;
	private HBox leftdesign;
	
	public Circle getImagen() {
		return imagen;
	}

	public void setImagen(Circle imagen) {
		this.imagen = imagen;
	}

	public Label getNombre() {
		return nombre;
	}

	public void setNombre(Label nombre) {
		this.nombre = nombre;
	}

	public Label getMensaje() {
		return mensaje;
	}

	public void setMensaje(Label mensaje) {
		this.mensaje = mensaje;
	}

	public Label getDatetime() {
		return datetime;
	}

	public void setDatetime(Label datetime) {
		this.datetime = datetime;
	}

	public HBox getLeftdesign() {
		return leftdesign;
	}

	public void setLeftdesign(HBox leftdesign) {
		this.leftdesign = leftdesign;
	}
	
	public ImagenPerfil() 
	{
		imagen = new Circle(25);
		nombre = new Label();
		mensaje = new Label();
		datetime = new Label();
		leftdesign = new HBox(20);
		imagen.setStroke(Color.TRANSPARENT);
		imagen.setSmooth(true);
	}
	
	public void contenido(String foto, String name, String message, LocalDateTime date) 
	{
		DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("dd MMM, YYYY  HH:mm");
		imagen.setFill(new ImagePattern(new Image(foto)));
		nombre.setText(name);
		mensaje.setText(message);
		datetime.setText(datetimeformat.format(date));			
	}
	
	public HBox leftDesign() 
	{
		HBox hbox = new HBox(10, nombre, datetime);
		hbox.setAlignment(Pos.CENTER);
		VBox vbox = new VBox(10, hbox, mensaje);
		leftdesign.getChildren().addAll(imagen, vbox);
		return leftdesign;
	}

	public void styles() 
	{
		nombre.setStyle("-fx-font-family: '';\r\n"
				+ "	-fx-font-weight: bold;\r\n"
				+ "	-fx-font-size: 120%;\r\n"
				+ "	-fx-pref-width: 92px;");	
		mensaje.setStyle("-fx-font-family: '';\r\n"
				+ "	-fx-font-weight: normal;\r\n"
				+ "	-fx-font-size: 90%;\r\n"
				+ "	-fx-max-width: 200px;");		
		datetime.setStyle("-fx-font-family: '';\r\n"
				+ "	-fx-font-weight: normal;\r\n"
				+ "	-fx-font-size: 90%;");		
		leftdesign.setStyle("-fx-padding: 8px, 5px, 8px, 5px;\r\n"		
				+ "	-fx-alignment: center;"
				+"-fx-background-color:#20dad8");
	}
}
