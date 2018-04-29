import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		Rectangle background = new Rectangle();
		background.setHeight(800);
		background.setWidth(1350);
		background.setFill(Color.DARKGREEN);
		pane.getChildren().addAll(background);
		Scene scene = new Scene(pane,1350,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
