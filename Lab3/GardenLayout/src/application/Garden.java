package application;

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
	Point2D lastPosition;
	Point2D clickpoint;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
			Flower =  new Flower(new Point2D (70,90),Color.RED,true,25);
			
			
			FlowerBed = new FlowerBed(new Point2D(200,100),new Point2D(50,25),Color.YELLOW,true);
			root.getChildren().add(FlowerBed.getRectangle());
			root.getChildren().add(Flower.getCircle());
			
			
			
			//root.getChildren().add(circle);
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
				Flower.move(delataX,delataY);
				FlowerBed.move(delataX, delataY);
				
			}
			
		break;
		
		}
			
		lastPosition = clickpoint;
	}
};
			
			
			
	public static void main(String[] args) {
		launch(args);
	}
}
