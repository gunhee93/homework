package ex01_group;







import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Quiz01 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Group g = new Group();
		Pane p1 = new Pane();
		Pane p2 = new Pane();
		Pane p3 = new Pane();
		
		Circle c = new Circle(50, Color.BLUE);
		c.relocate(20, 20);
		Rectangle r = new Rectangle(100,100,Color.RED);
		r.relocate(70, 70);
		
		p1.setPrefSize(200, 200);
		p1.setStyle("-fx-background-color:black");
		p1.setLayoutX(20);
		p1.setLayoutY(20);
		
		Ellipse e = new Ellipse(100, 100, 80, 25);
		e.setFill(Color.BLACK);
		
		p2.setPrefSize(200, 200);
		p2.setLayoutX(240);
		p2.setLayoutY(20);
		p2.setStyle("-fx-background-color:yellow;");
		
		p3.setPrefSize(400, 200);
		p3.setLayoutX(20);
		p3.setLayoutY(250);
		p3.setStyle("-fx-background-color:red;");
		
		p1.getChildren().addAll(c,r);
		p2.getChildren().add(e);
		g.getChildren().addAll(p1,p2,p3);
		
		Scene scene = new Scene(g,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quiz01");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
