package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class Register implements Initializable {

	
		@FXML	
		private GridPane rootPane;
		public TextField firstname;
		public TextField lastname;
		public TextField email;
	    public TextField screenname;
	    public Label sceneTitle;
	    public Label actionLabel;
		
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	Context.getInstance().currentMember(email.getText());
			}

	    public void submit(ActionEvent actionEvent) throws IOException {
	    	registerMember();
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	
	    	}    
	    
	    public void registerMember() {
		    Context.getInstance().setCurrentMember(firstname.getText(), lastname.getText(), screenname.getText(), email.getText(), LocalDateTime.now());
		    Context.getInstance().getSiteManager().addMember(firstname.getText(), lastname.getText(), screenname.getText(), email.getText(), LocalDateTime.now());
		    Context.getInstance().currentMember(email.getText());
	    }
	    
}