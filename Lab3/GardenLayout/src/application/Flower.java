package application;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements GardenObject {
	Circle circle;
	
	public Flower(Point2D a,Color RED,boolean b){
		circle = new Circle();
		circle.setCenterX(250);
		circle.setCenterY(100);
		circle.setRadius(25);
		circle.setFill(Color.PEACHPUFF);;
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(1);
		
	}
	public Circle getCircle(){
		return circle;
	}
	@Override
	public void move(double dX, double dY) {
		circle.setCenterX(circle.getCenterX()+dX);
		circle.setCenterY(circle.getCenterY()+dY);
	
	}
	

}
