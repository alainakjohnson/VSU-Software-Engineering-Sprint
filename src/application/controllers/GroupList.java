package application.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
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
	    public int activeNum = 0;
	    public int popularNum = 0;
	    
	    public ComboBox<Integer> selectPopular;
	    public ComboBox<Integer> selectActive;
	    public ComboBox<Group> joinGroup;

		
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	setGroups();
	    	
	    	ObservableList<Integer> popularOptions = FXCollections.observableArrayList(1, 2, 3);
	    	selectPopular.setItems(popularOptions);
	    	    	
	    	ObservableList<Integer> activeOptions = FXCollections.observableArrayList(1, 2, 3);
	    	selectActive.setItems(activeOptions);
	    	
	    	ObservableList<Group> joinableGroups = FXCollections.observableArrayList(Context.getInstance().getSiteManager().getGroups());
	    	joinGroup.setItems(joinableGroups);
			}

	    public void getActiveNum(ActionEvent actionEvent) throws IOException {
	    	activeNum = selectActive.getValue();
	    	setActiveGroups(activeNum);
	    	}  
	    
	    public void getPopularNum(ActionEvent actionEvent) throws IOException {
	    	popularNum = selectPopular.getValue();
	    	setPopularGroups(popularNum);
	    	}    
	    
	    public void joinGroup(ActionEvent actionEvent) throws IOException {
	    	Context.getInstance().currentMember().joinGroup(joinGroup.getValue(), LocalDateTime.now());
	    	}    
	    
	    public void complete(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void setGroups(){
	    	groups = Context.getInstance().getSiteManager().getGroups();
	    	allGroups.setText(groups.toString());
	        }
	    
	    public void setActiveGroups(int activeNum){
	    	if(activeNum < Context.getInstance().getSiteManager().getGroups().size()) {
	    		activeGroups = Context.getInstance().getSiteManager().getActiveGroups(activeNum);
		    	mostActiveGroups.setText(activeGroups.toString());
		    	actionLabel.setText("");
	    		}
	    	else if(Context.getInstance().getSiteManager().getGroups().size() == 0) {
	    		actionLabel.setText("There are no groups to display");
	    		}
	    	else {
	    		activeGroups = Context.getInstance().getSiteManager().getGroups();
	    		mostActiveGroups.setText(activeGroups.toString());
	    		actionLabel.setText("There are fewer groups than requested");
	    		}
	       }    
	    
	    public void setPopularGroups(int popularNum){
	    	if(popularNum < Context.getInstance().getSiteManager().getGroups().size()) {
	    		popularGroups = Context.getInstance().getSiteManager().getPopularGroups(popularNum);
		    	mostPopularGroups.setText(popularGroups.toString());
		    	actionLabel.setText("");
	    		}
	    	else if(Context.getInstance().getSiteManager().getGroups().size() == 0) {
	    		actionLabel.setText("There are no groups to display");
	    		}
	    	else {
	    		popularGroups = Context.getInstance().getSiteManager().getGroups();
	    		mostPopularGroups.setText(popularGroups.toString());
	    		actionLabel.setText("There are fewer groups than requested");
	    		}
	        }
}