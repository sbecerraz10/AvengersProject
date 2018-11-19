package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import exception.CharacterNotChoosen;
import exception.FieldNotChoosen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class IndexController implements Initializable{
	
	@FXML
    private ImageView field1;
    @FXML
    private ImageView character1;

    @FXML
    private ImageView leftArrowCharacter, rightArrowCharacter;
    @FXML
    private ImageView leftArrowField, rightArrowField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(Main.getIndexModel().getHeadCharacter().getNickname());
		character1.setImage(new Image(Main.getIndexModel().getHeadCharacter().getImage()));
		
	}
	
	@FXML
	public void selectCharacter(MouseEvent event) {
		character1.setOpacity(0.30);
		leftArrowCharacter.setVisible(false);
		rightArrowCharacter.setVisible(false);
		
	}
	
	@FXML
	public void selectField(MouseEvent event) {
		field1.setOpacity(0.30);
		leftArrowField.setVisible(false);
		rightArrowField.setVisible(false);
		//Falta metodo escoger campo en el modelo
	}
	
	@FXML
	public void play(ActionEvent event) {
		try {
			Main.getIndexModel().chooseField(field1.getImage().impl_getUrl());
			Main.getIndexModel().chooseCharacter(character1.getImage().impl_getUrl());
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/FieldWindow.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}catch(IOException e) {
			
		} catch (FieldNotChoosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CharacterNotChoosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void backToMenu(MouseEvent event) {
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/MenuWindow.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
