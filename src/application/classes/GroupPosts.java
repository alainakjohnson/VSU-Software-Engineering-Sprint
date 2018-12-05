package application.classes;

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

public class GroupPosts implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public Label sceneTitle;
	    public Label actionLabel;
	    public Label questionDisplay;
	    List<Question> questions = new ArrayList<Question>();
		
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
	    	sceneTitle.setText("Recent Posts for " + Context.getInstance().getGroup().getTitle());
	    	setListView();
			}

	    public void complete(ActionEvent actionEvent) throws IOException {
	    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/welcome.fxml"));
	    	rootPane.getChildren().setAll(pane);
	    	}    
	    
	    public void setListView(){
	    	questions = Context.getInstance().getGroup().getQuestions();
	    	questionDisplay.setText(questions.toString());
	        }
	    
}