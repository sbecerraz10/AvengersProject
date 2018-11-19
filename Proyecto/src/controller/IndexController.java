package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
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
	
	public void selectCharacter(ActionEvent event) {
		Button button = (Button) event.getSource();
		String id = button.getId();
		
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
