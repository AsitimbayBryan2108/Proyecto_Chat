package diseño;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Layout2 {
	private HBox inferior;
	private HBox superiorIzquierdo;
	private HBox superiorDerecho;
	private HBox diseñoDerechos;
	private HBox diseñoIzquierdo;
	private AnchorPane anchorPane;
	private ScrollPane panelIzq;
	private ScrollPane panelDer;
	private FlowPane flowpane;
	private VBox vbox;
	private VBox fondo;

	public Layout2() {
		flowpane = new FlowPane();
	}

	public HBox getSuperiorIzquierdo() {
		return superiorIzquierdo;
	}

	public void setSuperiorIzquierdo(HBox topleft) {
		this.superiorIzquierdo = topleft;
	}

	public HBox getSuperiorDerecho() {
		return superiorDerecho;
	}

	public void setSuperiorDerecho(HBox topright) {
		this.superiorDerecho = topright;
	}

	public HBox getDiseñoIzquierdo() {
		return diseñoIzquierdo;
	}

	public void setDiseñoIzquierdo(HBox leftdesign) {
		this.diseñoIzquierdo = leftdesign;
	}

	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	public void setAnchorPane(AnchorPane anchorPane) {
		this.anchorPane = anchorPane;
	}

	public ScrollPane getPanelIzq() {
		return panelIzq;
	}

	public void setPanelIzq(ScrollPane panelIzq) {
		this.panelIzq = panelIzq;
	}

	public ScrollPane getPanelDer() {
		return panelDer;
	}

	public void setPanelDer(ScrollPane panelDer) {
		this.panelDer = panelDer;
	}

	public FlowPane getFlowpane() {
		return flowpane;
	}

	public void setFlowpane(FlowPane flowpane) {
		this.flowpane = flowpane;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}
	
	public HBox getInferior() {
		return inferior;
	}

	public void setInferior(HBox inferior) {
		this.inferior = inferior;
	}

	public HBox getDiseñoDerechos() {
		return diseñoDerechos;
	}

	public void setDiseñoDerechos(HBox rightdesign) {
		this.diseñoDerechos = rightdesign;
	}
	
	public VBox getFondo() {
		return fondo;
	}

	public void setFondo(VBox fondo) {
		this.fondo = fondo;
	}

	public VBox addRightdesign(HBox [] hbox) {
		for(int m = 0; m < hbox.length; m++) {
			vbox.getChildren().add(hbox[m]);	
		}
		
		return vbox;
	}
	public Layout2(int vboxspacing) {
		panelIzq = new ScrollPane();
		panelDer = new ScrollPane();		
		vbox = new VBox(vboxspacing);
		fondo = new VBox();
	}
	public void anchor1() {
		panelDer.setVisible(false);
		superiorDerecho.setVisible(false);
		inferior.setVisible(false);

		anchorPane = new AnchorPane(fondo, superiorIzquierdo, superiorDerecho, panelIzq, panelDer, inferior);
		anchorPane.setStyle("-fx-background-color:#83867a");
		AnchorPane.setTopAnchor(superiorIzquierdo, 0d);
		AnchorPane.setLeftAnchor(superiorIzquierdo, 0d);
		AnchorPane.setRightAnchor(superiorIzquierdo, 705d);
		AnchorPane.setTopAnchor(superiorDerecho, 0d);
		AnchorPane.setLeftAnchor(superiorDerecho, 295d);
		AnchorPane.setRightAnchor(superiorDerecho, 0d);
		AnchorPane.setLeftAnchor(panelIzq, 0d);
		AnchorPane.setRightAnchor(panelIzq, 705d);
		AnchorPane.setTopAnchor(panelIzq, 60d);
		AnchorPane.setBottomAnchor(panelIzq, 0d);
		AnchorPane.setLeftAnchor(panelDer, 295d);
		AnchorPane.setRightAnchor(panelDer, 0d);
		AnchorPane.setTopAnchor(panelDer, 60d);
		AnchorPane.setBottomAnchor(panelDer, 45d);
		AnchorPane.setLeftAnchor(inferior, 295d);
		AnchorPane.setRightAnchor(inferior, 0d);
		AnchorPane.setBottomAnchor(inferior, 0d);
		AnchorPane.setLeftAnchor(fondo, 295d);
		AnchorPane.setRightAnchor(fondo, 0d);
		AnchorPane.setTopAnchor(fondo, 0d);
		AnchorPane.setBottomAnchor(fondo, 0d);
	}
	
	public void visible() 
	{
		panelDer.setVisible(true);
		superiorDerecho.setVisible(true);
		inferior.setVisible(true);
		fondo.setVisible(true);
	}
	
	public void ajusteDesplDer(FlowPane flowPane) 
	{
		flowPane.setStyle("-fx-background-color:#f8efd2");
		flowPane.heightProperty().addListener(new ChangeListener<Object>() {
	@Override
	public void changed(ObservableValue<?> observable, Object oldvalue, Object newValue)
	{	
		panelDer.setVvalue((double)newValue);
		panelDer.setStyle("-fx-background-color:#20dad8");
	}
		});
	}

}