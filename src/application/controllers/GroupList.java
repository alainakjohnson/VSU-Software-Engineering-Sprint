package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.classes.Group;

public class GroupList implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public Label actionLabel;
	   
	    public Label allGroups;
	    public Label mostPopularGroups;
	    public Label mostActiveGroups;
	    List<Group> groups = new ArrayList<Group>();
	    List<Group> popularGroups = new ArrayList<Group>();
	    List<Group> activeGroups = new ArrayList<Group>();
		
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	setGroups();
			}

	    public void complete(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void setGroups(){
	    	groups = Context.getInstance().getSiteManager().getGroups();
	    	popularGroups = Context.getInstance().getSiteManager().getPopularGroups(2);
	    	activeGroups = Context.getInstance().getSiteManager().getActiveGroups(2);
	    	allGroups.setText(groups.toString());
	    	mostPopularGroups.setText(popularGroups.toString());
	    	mostActiveGroups.setText(activeGroups.toString());
	    	
	    	
	        }
	    
}