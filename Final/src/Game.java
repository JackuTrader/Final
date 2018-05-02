import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application implements EventHandler<ActionEvent>{
	PathTransition wrPlay = null;
	Circle QB = new Circle(10);
	Circle WR = new Circle(10);
	Circle DB = new Circle(10);
	Pane pane = new Pane();
	VBox hbox = new VBox();
	Text co = new Text();
	
	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		hbox.setSpacing(10);
		hbox.getChildren().addAll(co);
		buttons(hbox);
		createField(pane);
		createPlayers(pane);
		Scene scene = new Scene(pane,800,840);
		Scene scene2 = new Scene(hbox,135,150);
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage secondStage = new Stage();
		secondStage.setScene(scene2);
		secondStage.show();
		
	}
	public void setCallOuts(String t) {
		co.setText(t);
		co.setX(100);
		co.setY(100);
	}
	public void buttons(Pane pane){
		Button p1 = new Button("Player One");
		pane.getChildren().addAll(p1);
		p1.setOnAction(this);
	}
	
	//Makes the players
	public void createPlayers(Pane pane) {		
		QB.setCenterX(400);
		QB.setCenterY(420);
		
		WR.setCenterY(420);
		WR.setCenterX(170);
		
		DB.setCenterX(170);
		DB.setCenterY(400);
		
		QB.setFill(Color.BLUE);
		WR.setFill(Color.BLUE);
		DB.setFill(Color.RED);
		
		runPathWR();
		runPathDB();
		
		pane.getChildren().addAll(QB,WR,DB);
	}
	
	//Creates football field
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

	@Override
	public void handle(ActionEvent event) {
		int player1 = (int)(Math.random()*10);
		int player2 = (int)(Math.random()*10);
		
		if(player1>player2) {
			foward(pane);
		}
		else if(player1<player2) {
			backward(pane);
		}
		else {
			runPathWR();
			runPathDB();
			setCallOuts("Ball dropped. No gains.");
		}
	}
	
	//Moves player foward by 10 yards
	public void foward(Pane pane) {
		double qbp2 = QB.getCenterY();
		double wrp2 = WR.getCenterY();
		double dbp2 = DB.getCenterY();
		QB.setCenterY(qbp2-70);
		WR.setCenterY(wrp2-70);
		DB.setCenterY(dbp2-70);
		runPathWR();
		runPathDB();
		setCallOuts("Catch for 10 yards!");
		win(QB);
	}
	
	//Moves player backward by 10 yards
	public void backward(Pane pane) {
		double qbp2 = QB.getCenterY();
		double wrp2 = WR.getCenterY();
		double dbp2 = DB.getCenterY();
		QB.setCenterY(qbp2+70);
		WR.setCenterY(wrp2+70);
		DB.setCenterY(dbp2+70);
		runPathWR();
		runPathDB();
		setCallOuts("Interception for 10 yards!");
		win(QB);
	}
	
	//Sets up win condition
	public void win(Circle c) {
		if(c.getCenterY()>=770) {
			setCallOuts("Player 2 wins!");
			
		}
		else if(c.getCenterY()<=70) {
			setCallOuts("Player 1 wins!");
			
		}
	}
	
	//Creates run Path for wide receiver
	public void runPathDB() {
		wrPlay = new PathTransition();
		Polyline path = new Polyline();
		double y = WR.getCenterY();
		path.getPoints().addAll(new Double[]{170.0,(y-20),
					170.0,(y-60),
					300.0,(y-80)});
		wrPlay.setNode(DB);
		wrPlay.setPath(path);
		wrPlay.setDuration(Duration.seconds(3));
		wrPlay.setCycleCount(1);
		wrPlay.play();
			
		}
	
	public void runPathWR() {
		wrPlay = new PathTransition();
		Polyline path = new Polyline();
		double y = QB.getCenterY();
		path.getPoints().addAll(new Double[]{170.0,y,
					170.0,(y-40),
					300.0,(y-70)});
		wrPlay.setNode(WR);
		wrPlay.setPath(path);
		wrPlay.setDuration(Duration.seconds(3));
		wrPlay.setCycleCount(1);
		wrPlay.play();
	}
}


