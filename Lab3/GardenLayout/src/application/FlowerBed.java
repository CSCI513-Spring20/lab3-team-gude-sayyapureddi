package application;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FlowerBed implements GardenObject {
	Rectangle rect;
	public FlowerBed(Point2D a,Point2D c,Color R,boolean b) {
		rect = new Rectangle();
		rect.setHeight(a.getX());
		rect.setWidth(a.getY());
		rect.setX(c.getX());
		rect.setY(c.getY());
		rect.setStroke(Color.BLACK);
		rect.setFill(R);
	}
	public Rectangle getRectangle(){
		return rect;
	}
	@Override
	public void move(double dX, double dY) {
		rect.setX(rect.getX()+dX);
		rect.setY(rect.getY()+dY);	
	
	}
	
}
