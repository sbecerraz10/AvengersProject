package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class MenuController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void play(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("¡BIENVENIDO!");
		dialog.setContentText("Por favor ingeresa tu nickname: ");
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent()) {
			try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("application/Nombre.fxml"));
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
	
	@FXML
	public void ranking(ActionEvent event) {
		
	}
	
	@FXML
	public void search(ActionEvent event) {
		
	}

}
