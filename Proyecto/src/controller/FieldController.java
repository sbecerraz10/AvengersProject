package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import modelo.Gemma;

public class FieldController implements Initializable{
	
	private Gemma gemma;
	
	private Timeline thread;

    @FXML
    private ImageView field;

    @FXML
    private ImageView gema1;

    @FXML
    private ImageView gema2;

    @FXML
    private ImageView gema3;

    @FXML
    private ImageView gema4;

    @FXML
    private ImageView gema5;

    @FXML
    private ImageView gema6;
    
    @FXML
    private ImageView character;
    
    @FXML
    private ImageView g;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		field.setImage(new Image(Main.getIndexModel().getFieldChoose().getImage()));
		gema1.setOpacity(0.30);
		gema2.setOpacity(0.30);
		gema3.setOpacity(0.30);
		gema4.setOpacity(0.30);
		gema5.setOpacity(0.30);
		gema6.setOpacity(0.30);	
		character.setImage(new Image(Main.getIndexModel().getCharacterChoose().getImage()));

			thread = new Timeline(new KeyFrame(Duration.ZERO, e-> {
				g.setImage(new Image("/images/Gema_Alma.png"));
				gemma = Main.getIndexModel().getFieldChoose().getRootGemma();
				gemma.move();
				g.setLayoutY(gemma.getPosy());
				g.setLayoutX(gemma.getPosx());
				
				
			}),new KeyFrame(Duration.millis(30)));
			
			thread.setCycleCount(Animation.INDEFINITE);
			thread.play();
			
		
	}
	
	public void receiveScene(Scene scene) {
		onKeyPressed(scene);
	}

	@FXML
	public void onKeyPressed(Scene scene) {
		scene.setOnKeyPressed(e->{
			switch(e.getCode()) {
			case LEFT: 
				disableRight();
				disableUp();
				disableDown();
				moveLeft();
					break;
				case RIGHT: 
				disableLeft();
				disableUp();
				disableDown();
				moveRight();
					break;	
				case UP: 
				disableDown();
				disableRight();
				disableLeft();
				moveUp();
					break;
				case DOWN: 
				disableUp();
				disableRight();
				disableLeft();
				moveDown();
					break;
				default:
					break;
				}
			
		});
	}
	
	private void moveDown() {
		Main.getIndexModel().getCharacterChoose().setDown(true);
		Main.getIndexModel().getCharacterChoose().move();
		character.setLayoutX(Main.getIndexModel().getCharacterChoose().getPosx());
		character.setLayoutY(Main.getIndexModel().getCharacterChoose().getPosy());
		
	}

	private void moveUp() {
		Main.getIndexModel().getCharacterChoose().setUp(true);
		Main.getIndexModel().getCharacterChoose().move();
		character.setLayoutX(Main.getIndexModel().getCharacterChoose().getPosx());
		character.setLayoutY(Main.getIndexModel().getCharacterChoose().getPosy());
		
	}

	public void moveRight() {
		Main.getIndexModel().getCharacterChoose().setRight(true);
		Main.getIndexModel().getCharacterChoose().move();
		character.setLayoutX(Main.getIndexModel().getCharacterChoose().getPosx());
		character.setLayoutY(Main.getIndexModel().getCharacterChoose().getPosy());
	}
	
	public void moveLeft() {
		Main.getIndexModel().getCharacterChoose().setLeft(true);
		Main.getIndexModel().getCharacterChoose().move();
		character.setLayoutX(Main.getIndexModel().getCharacterChoose().getPosx());
		character.setLayoutY(Main.getIndexModel().getCharacterChoose().getPosy());
	}
	
	public void disableRight() {
		Main.getIndexModel().getCharacterChoose().setRight(false);
	}
	
	public void disableLeft() {
		Main.getIndexModel().getCharacterChoose().setLeft(false);
	}
	
	public void disableUp() {
		Main.getIndexModel().getCharacterChoose().setUp(false);
	}
	
	public void disableDown() {
		Main.getIndexModel().getCharacterChoose().setDown(false);
	}
	
}