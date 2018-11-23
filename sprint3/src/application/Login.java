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


public class Login extends Application {
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
			Text scenetitle = new Text("LOG IN");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
			grid.add(scenetitle, 0, 0);
			
			
			Label email = new Label("Email:");
			grid.add(email, 0, 1);

			TextField emailTextField = new TextField();
			grid.add(emailTextField, 1, 1);
			
			Label screenName = new Label("Screen Name:");
			grid.add(screenName, 0, 2);

			TextField screenTextField = new TextField();
			grid.add(screenTextField, 1, 2);
	        
	       
	        Button submitBtn = new Button();
	        grid.add(submitBtn, 1, 5);
	        submitBtn.setText("Login");
	        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Login Member Action");
	            }
	        });
	        
	        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
