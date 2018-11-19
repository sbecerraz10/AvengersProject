package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FieldController implements Initializable{

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//field.setImage(new Image(Main.getIndexModel().));
		gema1.setOpacity(0.30);
		gema2.setOpacity(0.30);
		gema3.setOpacity(0.30);
		gema4.setOpacity(0.30);
		gema5.setOpacity(0.30);
		gema6.setOpacity(0.30);		
	}

}
