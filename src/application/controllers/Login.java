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
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class Login implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public TextField screenname;
	    public Label sceneTitle;
	    public Label actionLabel;
	    
	    Preferences preferences;
	    

	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	}
	    
	    public void submit(ActionEvent actionEvent) throws IOException {
	    	
	    	if ((screenname.getText()).equals(Context.getInstance().currentMember().getScreenName())) {
		    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
		    	rootPane.getChildren().setAll(pane);
		    	}
	    	else {
	    		actionLabel.setText("Invalid User");
	    		}
	    }
	    
	    public void register(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/register.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}   
	    
}