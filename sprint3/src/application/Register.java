package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;


public class Register extends Application {
	@Override
	public void start(Stage primaryStage) {

			GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));
	        
	        Scene scene = new Scene(grid,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.setTitle("Sprint 3");
			Text scenetitle = new Text("Welcome [Screen Name]");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			grid.add(scenetitle, 0, 0, 2, 1);

	        Button groupsBtn = new Button();
	        grid.add(groupsBtn, 0, 1);
	        groupsBtn.setText("Groups");
	        groupsBtn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Groups List Action");
	            }
	        });
	        
	        Button createGroupBtn = new Button();
	        grid.add(createGroupBtn, 0, 2);
	        createGroupBtn.setText("Create Group");
	        createGroupBtn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Create Group Action");
	            }
	        });
	        
	        Button searchGroupsBtn = new Button();
	        grid.add(searchGroupsBtn, 1, 1);
	        searchGroupsBtn.setText("Search Groups");
	        searchGroupsBtn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Search Groups Action");
	            }
	        });
	        
	        Button btn = new Button();
	        grid.add(btn, 1, 2);
	        btn.setText("[Button]");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Not sure why this button was in the drawing");
	            }
	        });
	        
	        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
