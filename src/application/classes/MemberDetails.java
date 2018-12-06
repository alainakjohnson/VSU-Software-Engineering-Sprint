package application.classes;

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

public class MemberDetails implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public Label actionLabel;
	    
	    public Label memberTitle;
	    public Label memberProfile;
	    public Label memberGroups;
	    public Label memberQuestions;
	    public Label memberAnswers;
	    public Label memberPoints;
		
		public int activeNum = 0;
		public int questionFilter = 0;
		public int answerFilter = 0;

		List<Group> userGroups = new ArrayList<Group>();
	    List<Group> activeGroups = new ArrayList<Group>();
	    
	    List<Question> userQuestions = new ArrayList<Question>();
	    List<Answer> userAnswer = new ArrayList<Answer>();
		
	    public Label groupTitle;
	    
	    public ComboBox<Integer> filterQuestions;
	    public ComboBox<Integer> filterAnswers;
	    public ComboBox<Integer> selectActive;
	    public ComboBox<Group> selectGroup;
		
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	
	    	memberTitle.setText("Details for Member: " + Context.getInstance().currentMember().getScreenName());
	    	memberGroups.setText(Context.getInstance().currentMember().getScreenName() + "'s Groups");
	    	memberProfile.setText(Context.getInstance().currentMember().toString());
	    	memberPoints.setText("Member's Points: " + String.valueOf(Context.getInstance().currentMember().getPoints()));
	    	
	    	ObservableList<Group> userGroups = FXCollections.observableArrayList(Context.getInstance().currentMember().getGroups());
	    	selectGroup.setItems(userGroups);
	    	
	    	ObservableList<Integer> activeOptions = FXCollections.observableArrayList(1, 2, 3);
	    	selectActive.setItems(activeOptions);
			}
	    
	    
	    public void setActiveGroups(int activeNum){
	    	if(activeNum < Context.getInstance().currentMember().getGroups().size()) {
		    	ObservableList<Group> activeGroups = FXCollections.observableArrayList(Context.getInstance().currentMember().getGroups(activeNum));
		    	selectGroup.setItems(activeGroups);
		    	actionLabel.setText("Displaying " + activeNum + "most active groups");
		    	
	    		}
	    	else {
	    		ObservableList<Group> activeGroups = FXCollections.observableArrayList(Context.getInstance().currentMember().getGroups());
	    		selectGroup.setItems(activeGroups);
	    		
	    		actionLabel.setText("There are fewer groups than requested.");
	    		}
	       }    
	    
	    public void seePosts(ActionEvent actionEvent) throws IOException {
	    	memberQuestions.setText(Context.getInstance().currentMember().getQuestions(selectGroup.getValue()).toString());
	    	memberAnswers.setText(Context.getInstance().currentMember().getAnswers(selectGroup.getValue()).toString());
	    	
	    	ObservableList<Integer> questionOptions = FXCollections.observableArrayList(1, 2, 3);
	    	filterQuestions.setItems(questionOptions);
	    	
	    	ObservableList<Integer> answerOptions = FXCollections.observableArrayList(1, 2, 3);
	    	filterAnswers.setItems(answerOptions);
	    	}    
	    
	    public void getActiveNum(ActionEvent actionEvent) throws IOException {
	    	activeNum = selectActive.getValue();
	    	setActiveGroups(activeNum);
	    	}  
	    
	    public void filterQuestions(ActionEvent actionEvent) throws IOException {
	    	questionFilter = filterQuestions.getValue();
	    	setQuestionNum(questionFilter);
	    	}  
	    
	    public void filterAnswers(ActionEvent actionEvent) throws IOException {
	    	answerFilter = filterAnswers.getValue();
	    	setAnswerNum(answerFilter);
	    	}  

	    public void complete(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}  
	    
	    
	    /// QUESTION RELATED
	    
	    public void setQuestionNum(int questionFilter){
	    	if(questionFilter < Context.getInstance().currentMember().getQuestions(selectGroup.getValue()).size()) {
	    	memberQuestions.setText(Context.getInstance().currentMember().getQuestions(selectGroup.getValue(), questionFilter).toString());
		    actionLabel.setText("Displaying " + questionFilter + " most recent questions");
		    	
	    		}
	    	else {
	    		memberQuestions.setText(Context.getInstance().currentMember().getQuestions(selectGroup.getValue()).toString());
	    		actionLabel.setText("There are fewer questions than requested.");
	    		}
	       }    
	    
	    /// ANSWER RELATED
	    
	    public void setAnswerNum(int answerFilter){
	    	if(answerFilter < Context.getInstance().currentMember().getAnswers(selectGroup.getValue()).size()) {
	    	memberAnswers.setText(Context.getInstance().currentMember().getQuestions(selectGroup.getValue(), answerFilter).toString());
		    actionLabel.setText("Displaying " + answerFilter + " most recent answers");
		    	
	    		}
	    	else {
	    		memberAnswers.setText(Context.getInstance().currentMember().getAnswers(selectGroup.getValue()).toString());
	    		actionLabel.setText("There are fewer answers than requested.");
	    		}
	       }    

}