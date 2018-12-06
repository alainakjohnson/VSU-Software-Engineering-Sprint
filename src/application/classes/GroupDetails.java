package application.classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GroupDetails implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public Label actionLabel;
	    
	    public Label mostActiveMembers;
	    public Label allPosts;
	    
	    public TextField qTitleBlank;
	    public TextField qTextBlank;
		
		public int activeNum = 0;

		List<Member> members = new ArrayList<Member>();
	    List<Member> activeMems = new ArrayList<Member>();
		
	    public Label groupTitle;
	    
	    public ComboBox<Integer> selectActive;
	    public ComboBox<Member> selectMembers;
	    public ComboBox<Post> selectQuestions;
	    
		
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
	    	Context.getInstance().activeMember(selectMembers.getValue().getEmailAddress());
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/memberdetails.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void complete(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}  
	    
	    public void setActiveGroups(int activeNum){
	    	if(activeNum < Context.getInstance().getSiteManager().getMembers().size()) {
		    	ObservableList<Member> activeMems = FXCollections.observableArrayList(Context.getInstance().getSiteManager().getActiveMembers(activeNum));
		    	selectMembers.setItems(activeMems);
		    	actionLabel.setText("Displaying " + activeNum + "most active groups");
		    	
	    		}
	    	else {
	    		ObservableList<Member> activeMems = FXCollections.observableArrayList(Context.getInstance().getSiteManager().getMembers());
		    	selectMembers.setItems(activeMems);
	    		
	    		actionLabel.setText("There are fewer members than requested");
	    		}
	       }    
	    
 ///QUESTION RELATED
	    
	    public void submitQuestion(ActionEvent actionEvent) throws IOException {
	    	Context.getInstance().currentMember().addQuestion(Context.getInstance().getGroup(), getQuestion(), LocalDateTime.now());
	    	System.out.println(Context.getInstance().getGroup().getQuestions());
		    }
	    
	    
	    public Question getQuestion() {
	    	Question question = new Question(qTitleBlank.getText(), qTextBlank.getText(), LocalDateTime.now());
	    	return question;
	    }
	    
	    public void groupPosts(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/groupposts.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    //

}