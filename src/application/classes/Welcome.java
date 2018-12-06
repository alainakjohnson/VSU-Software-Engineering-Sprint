package application.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public Label sceneTitle;

	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	sceneTitle.setText("Welcome back, " + (Context.getInstance().currentMember().getScreenName()));
				}

	    public void createGroup(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/creategroup.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void memberDetails(ActionEvent actionEvent) throws IOException {
	    	//Context.getInstance().activeMember(Context.getInstance().currentMember().getEmailAddress());
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/memberdetails.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void groupList(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/grouplist.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void logout(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
}