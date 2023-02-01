package ex01_group;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz02 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox root = new HBox(10);
		
		VBox vbox = new VBox(10);
		
		Pane p1 = new Pane();
		p1.setPrefSize(300, 100);
		p1.setStyle("-fx-background-color:red;");
		
		Pane p2 = new Pane();
		p2.setPrefSize(300, 100);
		p2.setStyle("-fx-background-color:black;");
		
		vbox.getChildren().addAll(p1,p2);
		
		Pane p3 = new Pane();
		p3.setPrefSize(200, 200);
		p3.setStyle("-fx-background-color:blue;");
		
		root.setPadding(new Insets(10));
		root.getChildren().addAll(vbox,p3);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quiz02");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
