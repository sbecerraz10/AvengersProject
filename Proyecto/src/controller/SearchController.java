package controller;

import java.net.URL;
import java.util.ResourceBundle;

import exception.NicknameNotValid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import modelo.Index;


public class SearchController implements Initializable{
	
	Index index = new Index();
	
    @FXML
    private Button B_Select;

    @FXML
    private Button B_Home;
    
    @FXML
    private ListView<String> ListView;
    
    @FXML
    void b_Home(ActionEvent event) {

    }

    @FXML
    void b_select(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			index.registrerUser("Sierra");
		} catch (NicknameNotValid e) {
			e.printStackTrace();
		}
		
		for(int i = 0 ; i<index.getUsers().size();i++) {
    		ListView.getItems().add(index.getUsers().get(i).getName()+"-   Puntaje:  ("+index.getUsers().get(i).getScore()+")");
    		}
		
	}

}
