package diseño;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Layout1 
{
	private AnchorPane anchorPane;
	private Button entrar;
	private Button regresar;
	private HBox hbox1;
	private HBox hbox2;
	private Label titulolabel;
	private Label clavelabel;
	private Label usuarioLabel;
	private Label avisolabel;
	private PasswordField clavetext;
	private TextField usertext;
	private VBox vbox1;
	private VBox vbox2;
	
	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	public Button getIniciar() {
		return entrar;
	}

	public Button getRegresar() {
		return regresar;
	}

	public HBox getHbox1() {
		return hbox1;
	}
	
	public HBox getHbox2() {
		return hbox2;
	}

	public Label getTitulolabel() {
		return titulolabel;
	}

	public Label getClavelabel() {
		return clavelabel;
	}

	public Label getUsuarioLabel() {
		return usuarioLabel;
	}

	public Label getAvisolabel() {
		return avisolabel;
	}

	public void setAvisolabel(Label avisolabel) {
		this.avisolabel = avisolabel;
	}

	public PasswordField getClavetext() {
		return clavetext;
	}

	public void setClavetext(PasswordField clavetext) {
		this.clavetext = clavetext;
	}

	public TextField getUsertext() {
		return usertext;
	}

	public void setUsertext(TextField usertext) {
		this.usertext = usertext;
	}

	public VBox getVbox1() {
		return vbox1;
	}

	public void setVbox(VBox vbox1) {
		this.vbox1 = vbox1;
	}
	
	public VBox getVbox2() {
		return vbox2;
	}

	public void setVbox2(VBox vbox2) {
		this.vbox2 = vbox2;
	}
	
	public Layout1() 
	{
		avisolabel = new Label();
		titulolabel = new Label("Whatsapp");
		usuarioLabel = new Label("Usuario:");
		clavelabel = new Label("Contraseña:");
		entrar = new Button("Entrar");
		regresar = new Button("Regresar");
		usertext = new TextField();
		clavetext = new PasswordField();	
		hbox1 = new HBox(50);
		hbox2 = new HBox(18);
		vbox1 = new VBox(20);;
		anchorPane = new AnchorPane();
	}
	
	public void contenidoVbox1() 
	{		
		hbox1.getChildren().addAll(usuarioLabel, usertext);
		hbox2.getChildren().addAll(clavelabel, clavetext);
		vbox1.getChildren().addAll(hbox1, hbox2);		
	}
	
	public VBox contenidoVbox2() 
	{
		vbox2 = new VBox(15, avisolabel, regresar);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setId("vbox");
		vbox2.setStyle("-fx-background-color:#20dad8");
		return vbox2;
	}
	
	public void notificar(String username, String password) 
	{
		if(username.equals("") || password.equals(""))
			avisolabel.setText("Datos Incorrectos");
		else
			avisolabel.setText("Datos Incorrectos");	
	}
	
	public AnchorPane anchor() 
	{
		anchorPane.getChildren().addAll(titulolabel, vbox1,entrar);
		AnchorPane.setLeftAnchor(titulolabel, 50d);
    	AnchorPane.setTopAnchor(titulolabel, 30d);
    	AnchorPane.setLeftAnchor(entrar, 130d);
    	AnchorPane.setBottomAnchor(entrar, 10d);
    	AnchorPane.setLeftAnchor(vbox1, 30d);
    	AnchorPane.setTopAnchor(vbox1, 130d);
    	anchorPane.setStyle("-fx-background-color:#93ff9f");
    	return anchorPane;
	}
	
	public void styles() 
	{
		entrar.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: '';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
		
		regresar.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: '';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);\r\n");
		avisolabel.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: '';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);"
				);
		titulolabel.setStyle("-fx-font-weight: bold;\r\n"
				+ "	-fx-font-family: '';\r\n"
				+ "	-fx-font-size: 450%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
		
		usuarioLabel.setStyle("-fx-font-weight: bold;\r\n"
				+ "	-fx-font-family: '';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
		
		clavelabel.setStyle("-fx-font-weight: bold;\r\n"
				+ "	-fx-font-family: '';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
		
		usertext.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: '';\r\n"
				+ "	-fx-font-size: 120%;\r\n"
				+ "	-fx-focus-traversable: false;");
		
		clavetext.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: '';\r\n"
				+ "	-fx-font-size: 120%;\r\n"
				+ "	-fx-focus-traversable: false;\r\n");
		
		
	}
}
