package ex02_button;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PasswordExam extends Application{

	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(10));
		
		PasswordField pf = new PasswordField();
		pf.setAlignment(Pos.BOTTOM_CENTER);
		pf.setPrefSize(100, 100);;
		pf.setText("test");
		
		PasswordField pf1 = new PasswordField();
		pf1.setPromptText("test");
		
		hbox.getChildren().addAll(pf, pf1);
		hbox.setPrefSize(300, 200);
		
		primaryStage.setScene(new Scene(hbox));
		primaryStage.setTitle("Password Ex");
		primaryStage.show();
	}
	
}
