import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Players extends Application {
	public static void main(String[] args) {
		launch();

	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
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
		PathTransition pt = new PathTransition();
		pt.setNode(WR);
		pt.setPath(path);
		pt.setDuration(Duration.seconds(5));
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
		
		
		pane.getChildren().addAll(QB,WR,DB);
		Scene scene = new Scene(pane,800,840);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	

}
