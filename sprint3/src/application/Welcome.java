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


public class Welcome extends Application {
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
			Text scenetitle = new Text("");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
			grid.add(scenetitle, 0, 0, 2, 1);
			
			
			Label firstName = new Label("First Name:");
			grid.add(firstName, 0, 1);

			TextField fnTextField = new TextField();
			grid.add(fnTextField, 1, 1);
			
			
			Label lastName = new Label("Last Name:");
			grid.add(lastName, 0, 2);

			TextField lnTextField = new TextField();
			grid.add(lnTextField, 1, 2);
			
			Label email = new Label("Email:");
			grid.add(email, 0, 3);

			TextField emailTextField = new TextField();
			grid.add(emailTextField, 1, 3);
			
			Label screenName = new Label("Screen Name:");
			grid.add(screenName, 0, 4);

			TextField screenTextField = new TextField();
			grid.add(screenTextField, 1, 4);
	        
	       
	        Button submitBtn = new Button();
	        grid.add(submitBtn, 1, 5);
	        submitBtn.setText("Create Account");
	        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Create Member Action");
	            }
	        });
	        
	        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
