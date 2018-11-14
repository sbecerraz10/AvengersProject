package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import exception.NicknameNotValid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.MediaException.Type;
import javafx.stage.Stage;
import modelo.Index;

public class MenuController implements Initializable{
	
	private Index index;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		index = new Index();
	}
	
	@FXML
	public void play(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("¡BIENVENIDO!");
		dialog.setContentText("Por favor ingeresa tu nickname: ");
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent()) {
			try {
			String nickName = result.get();
			index.registrerUser(nickName);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/IndexWindow.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NicknameNotValid e) {
				Alert a = new Alert(AlertType.ERROR);
				a.show();
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
