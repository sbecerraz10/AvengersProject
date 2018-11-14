package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import modelo.Index;

public class IndexController implements Initializable{
	
	@FXML
    private ImageView campo1;

    @FXML
    private ImageView campo2;

    @FXML
    private ImageView campo3;

    @FXML
    private ImageView campo4;

    @FXML
    private ImageView personaje1;

    @FXML
    private ImageView personaje2;

    @FXML
    private ImageView personaje3;

    
    @FXML
    private ImageView personaje4;
    
    private Index index;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void receiveIndex(Index index) {
		this.index = index;
	}
	
	public void actPage() {

	}
	

}
