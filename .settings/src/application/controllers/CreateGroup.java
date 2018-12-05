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
	    	Context.getInstance().getGroup(title.getText());
			}

	    public void submit(ActionEvent actionEvent) throws IOException {
	    	createGroup();
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void createGroup() {
	    	Context.getInstance().setNewGroup(title.getText(), description.getText(),LocalDateTime.now());
	    	Context.getInstance().getSiteManager().addGroup(title.getText(), description.getText(),LocalDateTime.now());
		    System.out.println(Context.getInstance().getSiteManager().getGroup(title.getText()));
		    Context.getInstance().getGroup(title.getText());
		    Context.getInstance().currentMember().joinGroup(Context.getInstance().getGroup(), LocalDateTime.now()); //autojoins member to group
		    
	    	System.out.println(Context.getInstance().currentMember().getScreenName() + " has joined " + Context.getInstance().getGroup().getTitle());
	    }
}