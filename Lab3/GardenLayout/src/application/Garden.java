package application;
	
import java.awt.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Garden extends Application {
	Pane root;
	Scene scene;
	Flower Flower;
	FlowerBed FlowerBed;
	Circle circle;
	Rectangle rect;
	Point lastPosition;
	Point2D clickpoint;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			rect = new Rectangle();
			rect.setHeight(200);
			rect.setWidth(300);
			rect.setX(0);
			rect.setY(0);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.DARKGOLDENROD);
			root.getChildren().add(rect);
			
			circle = new Circle();
			circle.setCenterX(250);
			circle.setCenterY( 100);
			circle.setRadius(25);
			circle.setFill(Color.PEACHPUFF);;
			circle.setStroke(Color.BLACK);
			circle.setStrokeWidth(1);
			root.getChildren().add(circle);
			scene.setOnMouseDragged(mouseHandler);
			scene.setOnMouseReleased(mouseHandler);
			scene.setOnMousePressed (mouseHandler);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			clickpoint = new Point2D(mouseEvent.getX(),mouseEvent.getY());
			System.out.println(clickpoint.getX()+""+clickpoint.getY());
			String eventName = mouseEvent.getEventType().getName();
			
			switch(eventName) {
			
			case("MOUSE_DRAGGED"):
				
			if(lastPosition != null) {
				
				System.out.println("Dragging");
				double delataX = clickpoint.getX()-lastPosition.getX();
				double delataY = clickpoint.getY()-lastPosition.getY();
				//flower.move(delataX,delataY);
				
			}
			
		break;
		
		}
			
		//lastPosition = clickpoint;
	}
};
			
			
			
	public static void main(String[] args) {
		launch(args);
	}
}
