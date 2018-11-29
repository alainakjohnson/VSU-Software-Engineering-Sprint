package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;

public class Menu implements Initializable {

		@FXML	
		private GridPane rootPane;
	    public Label actionLabel;
	    
	   
	    @Override
		public void initialize (URL url, ResourceBundle rb) {
				}

		public void existingUser(ActionEvent actionEvent) throws IOException {
		    	//actionLabel.setText("login");
		    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
		    	rootPane.getChildren().setAll(pane);
				}

	    public void newUser(ActionEvent actionEvent) throws IOException {
		    	//actionLabel.setText("login");
		    	GridPane pane = FXMLLoader.load(getClass().getResource("../fxml/register.fxml"));
		    	rootPane.getChildren().setAll(pane);
				}
	    }
