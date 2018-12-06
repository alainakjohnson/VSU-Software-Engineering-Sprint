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

public class GroupPosts implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public Label sceneTitle;
	    public Label actionLabel;
	    public Label answerDisplay;
	    public Label commentDisplay;
	    
	    public int questionFilter = 0;
		public int answerFilter = 0;
		
		public TextField aTextBlank;
	    
		public ComboBox<Question> allQuestions;
	    public ComboBox<Integer> filterQuestions;
	    public ComboBox<Integer> filterAnswers;	    
	    
	    List<Question> questions = new ArrayList<Question>();
		
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	sceneTitle.setText("Recent Posts for " + Context.getInstance().getGroup().getTitle());
	    	setQuestions();
	    	setAnswers();
			}
	    
	    public void setQuestions(){
	    	ObservableList<Integer> questionOptions = FXCollections.observableArrayList(1, 2, 3);
	    	filterQuestions.setItems(questionOptions);
	    	
	    	ObservableList<Question> groupQuestions = FXCollections.observableArrayList( Context.getInstance().getGroup().getQuestions());
	    	allQuestions.setItems(groupQuestions);
	        }
	    
	    public void setAnswers(){
	    	ObservableList<Answer> groupAnswers = FXCollections.observableArrayList( Context.getInstance().getGroup().getAnswers());
	    	answerDisplay.setText(groupAnswers.toString());
	    	
	    	ObservableList<Integer> answerOptions = FXCollections.observableArrayList(1, 2, 3);
	    	filterAnswers.setItems(answerOptions);
	        }
	    
	    public void reply(ActionEvent actionEvent) throws IOException {
	    	Answer answer = new Answer(allQuestions.getValue(), aTextBlank.getText(), LocalDateTime.now());
	    		Context.getInstance().currentMember().addAnswer(Context.getInstance().getGroup(), allQuestions.getValue(), answer, LocalDateTime.now());
	    		answerDisplay.setText(allQuestions.getValue().getAnswer().toString());
	    		}
	    
	    public void complete(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}  
	    
	    public void filterQuestions(ActionEvent actionEvent) throws IOException {
	    	questionFilter = filterQuestions.getValue();
	    	setQuestionNum(questionFilter);
	    	}  
//	    
	    public void filterAnswers(ActionEvent actionEvent) throws IOException {
	    	answerFilter = filterAnswers.getValue();
	    	setAnswerNum(answerFilter);
	    	}  
	    
	    public void questionAnswers(ActionEvent actionEvent) throws IOException {
	    	ObservableList<Answer> specificAnswers = FXCollections.observableArrayList(allQuestions.getValue().getAnswer());
	    	answerDisplay.setText(specificAnswers.toString());
	    	}  
	    
	    /// QUESTION RELATED
	    
	    public void setQuestionNum(int questionFilter){
	    	if(questionFilter < Context.getInstance().getGroup().getQuestions().size()) {
	    	ObservableList<Question> groupQuestions = FXCollections.observableArrayList(Context.getInstance().getGroup().getQuestions(questionFilter));
	    	allQuestions.setItems(groupQuestions);
		    actionLabel.setText("Displaying " + questionFilter + " most recent questions");	
	    		}
	    	else {
	    		ObservableList<Question> groupQuestions = FXCollections.observableArrayList(Context.getInstance().getGroup().getQuestions());
		    	allQuestions.setItems(groupQuestions);
	    		actionLabel.setText("There are fewer questions than requested.");
	    		}
	       }    
	    
	    /// ANSWER RELATED
	    
	    public void setAnswerNum(int answerFilter){
	    	if(answerFilter < Context.getInstance().getGroup().getAnswers().size()) {
		    	ObservableList<Answer> groupAnswers = FXCollections.observableArrayList(Context.getInstance().getGroup().getAnswers(answerFilter));
	    		answerDisplay.setText(groupAnswers.toString());
			    actionLabel.setText("Displaying " + answerFilter + " most recent answers");	
		    	}
	    	else {
		    	ObservableList<Answer> groupAnswers = FXCollections.observableArrayList(Context.getInstance().getGroup().getAnswers());
		    	answerDisplay.setText(groupAnswers.toString());
		    	actionLabel.setText("There are fewer answers than requested.");
		    	}
	       }    
    
}