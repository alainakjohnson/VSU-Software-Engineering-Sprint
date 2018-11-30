package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import application.classes.Group;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class CreateGroup implements Initializable {

	
		@FXML	
		private GridPane rootPane;
		public TextField title;
		public TextField description;
	    public Label sceneTitle;
	    public Label actionLabel;
	    public Group group;
		
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	Context.getInstance().newGroup();
			}

	    public void submit(ActionEvent actionEvent) throws IOException {
	    	createGroup();
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void createGroup() {
	    	Group group = new Group(title.getText(), description.getText(), LocalDateTime.now());
		    Context.getInstance().createGroup(group);
		    System.out.println(Context.getInstance().newGroup());
		    
		    Context.getInstance().currentMember().joinGroup(group, LocalDateTime.now());
	    	System.out.println(Context.getInstance().currentMember().getScreenName() + " has joined " + Context.getInstance().newGroup().getTitle());
	    }
	    
}