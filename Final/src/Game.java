import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {
	PathTransition wrPlay = null;
	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		createField(pane);
		createPlayers(pane);
		Scene scene = new Scene(pane,800,840);
		primaryStage.setScene(scene);
		primaryStage.show();
		wrPlay.play();
		
	}
	public void createPlayers(Pane pane) {
		Circle QB = new Circle(10);
		Circle WR = new Circle(10);
		Circle DB = new Circle(10);
		
		QB.setCenterX(400);
		QB.setCenterY(280);
		WR.setCenterY(280);
		WR.setCenterX(170);
		DB.setCenterX(170);
		DB.setCenterY(260);
		
		QB.setFill(Color.BLUE);
		WR.setFill(Color.BLUE);
		DB.setFill(Color.RED);
		
		Polyline path = new Polyline();
		path.getPoints().addAll(new Double[]{170.0,280.0,
				170.0,140.0,
				380.0,100.0});
		wrPlay = new PathTransition();
		wrPlay.setNode(WR);
		wrPlay.setPath(path);
		wrPlay.setDuration(Duration.seconds(5));
		wrPlay.setCycleCount(Timeline.INDEFINITE);
		//wrPlay.play();
		
		pane.getChildren().addAll(QB,WR,DB);
	}
	
	public void createField(Pane pane) {
		Text t = new Text();
		t.setText("TOUCHDOWN");
		t.setFill(Color.WHITE);
		t.setScaleX(10);
		t.setScaleY(7);
		t.setX(360);
		t.setY(35);
		Text t2 = new Text();
		t2.setText("TOUCHDOWN");
		t2.setFill(Color.WHITE);
		t2.setScaleX(10);
		t2.setScaleY(7);
		t2.setX(360);
		t2.setY(815);
		t2.setRotate(180);;
		Rectangle turf = new Rectangle();
		Rectangle l1 = new Rectangle(800,7);
		Rectangle l2 = new Rectangle(800,7);
		Rectangle l3 = new Rectangle(800,7);
		Rectangle l4 = new Rectangle(800,7);
		Rectangle l5 = new Rectangle(800,7);
		Rectangle l6 = new Rectangle(800,7);
		Rectangle l7 = new Rectangle(800,7);
		Rectangle l8 = new Rectangle(800,7);
		Rectangle l9 = new Rectangle(800,7);
		Rectangle in1 = new Rectangle(800,70);
		Rectangle in2 = new Rectangle(800,70);
		
		//lines
		l1.setFill(Color.WHITE);
		l2.setFill(Color.WHITE);
		l3.setFill(Color.WHITE);
		l4.setFill(Color.WHITE);
		l5.setFill(Color.WHITE);
		l6.setFill(Color.WHITE);
		l7.setFill(Color.WHITE);
		l8.setFill(Color.WHITE);
		l9.setFill(Color.WHITE);
		l1.setY(700);
		l2.setY(630);
		l3.setY(560);
		l4.setY(490);
		l5.setY(420);
		l6.setY(350);
		l7.setY(280);
		l8.setY(210);
		l9.setY(140);
		
		turf.setHeight(1200);
		turf.setWidth(800);
		turf.setFill(Color.DARKSEAGREEN);
		in1.setFill(Color.DARKGREEN);
		in2.setFill(Color.DARKGREEN);
		in1.setStroke(Color.WHITE);
		in2.setStroke(Color.WHITE);
		in1.setStrokeWidth(3);
		in2.setStrokeWidth(3);
		in1.setY(770);
		pane.getChildren().addAll(turf,in1,in2,l1,l2,l3,l4,l5,l6,l7,l8,l9,t,t2);
		
	}

}
