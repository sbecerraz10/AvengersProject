package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
		System.out.println();
		System.out.println(Main.getIndexModel().getHeadCharacter().getNickname());
		//character1.setImage(new Image(Main.getIndexModel().getHeadCharacter().getImage()));
		
	}

	
	public void actPage() {
		
	}
	

}
