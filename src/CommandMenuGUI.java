

import javafx.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CommandMenuGUI extends Application {

	public void start(Stage primaryStage)
	{
		GridPane pane1 = new GridPane();
		Label mapLabel = new Label("Map"); 
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 725, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pandorum");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
