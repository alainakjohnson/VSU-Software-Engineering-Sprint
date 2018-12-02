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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.classes.Member;

public class GroupDetails implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public Label actionLabel;
	    
	    public Label mostActiveMembers;
	    public Label allPosts;
		
		public int activeNum = 0;

		List<Member> members = new ArrayList<Member>();
	    List<Member> activeMems = new ArrayList<Member>();
		
	    public Label groupTitle;
	    
	    public ComboBox<Integer> selectActive;
	    public ComboBox<Member> selectMembers;
		
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	groupTitle.setText("Details for Group: " + Context.getInstance().getGroup().getTitle());
	    	
	    	ObservableList<Integer> activeOptions = FXCollections.observableArrayList(1, 2, 3);
	    	selectActive.setItems(activeOptions);
	    	
	    	ObservableList<Member> allMembers = FXCollections.observableArrayList(Context.getInstance().getGroup().getMembers());
	    	selectMembers.setItems(allMembers);
	    	
			}
	    
	    public void getActiveNum(ActionEvent actionEvent) throws IOException {
	    	activeNum = selectActive.getValue();
	    	setActiveGroups(activeNum);
	    	}  
	    
	    public void readMore(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/memberdetails.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void moreQuestions(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/questiondetail.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void complete(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}  
	    
	    public void setActiveGroups(int activeNum){
	    	if(activeNum < Context.getInstance().getSiteManager().getMembers().size()) {
	    		activeMems = Context.getInstance().getSiteManager().getActiveMembers(activeNum);
		    	mostActiveMembers.setText(activeMems.toString());
		    	actionLabel.setText("");
	    		}
	    	else {
	    		activeMems = Context.getInstance().getSiteManager().getMembers();
	    		mostActiveMembers.setText(activeMems.toString());
	    		actionLabel.setText("There are fewer members than requested");
	    		}
	       }    

}