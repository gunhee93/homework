package ex02_button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DateExam extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane p = new Pane();

		DatePicker dp = new DatePicker();
		dp.setPrefSize(100, 30);
		dp.setLayoutX(20);
		dp.setLayoutY(20);

		p.getChildren().add(dp);
		p.setPrefSize(300, 200);

		primaryStage.setScene(new Scene(p));
		primaryStage.setTitle("Date Ex");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
