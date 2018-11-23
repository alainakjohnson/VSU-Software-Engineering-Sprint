package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;


public class Main extends Application {
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
			Text scenetitle = new Text("Welcome! Please sign in.");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			grid.add(scenetitle, 0, 0, 2, 1);
			
			
	        Button registerBtn = new Button();
	        grid.add(registerBtn, 0, 1);
	        registerBtn.setText("New Member");
	        registerBtn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Register action");
	            }
	        });
	        
	       
	        Button loginBtn = new Button();
	        grid.add(loginBtn, 1, 1);
	        loginBtn.setText("Returning Member");
	        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Login action");
	            }
	        });
	        
	        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
