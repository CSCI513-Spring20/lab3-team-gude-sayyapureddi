package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FlowerBed implements GardenObject {
	Rectangle rect;
	List<GardenObject> flowers = new ArrayList<GardenObject>();
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
	public boolean ContainsPoint(Point2D point) {
		boolean layout = (point.getX() >= rect.getX() && point.getX() <= rect.getX()+rect.getWidth()
		&& point.getY()>= rect.getY() && point.getY() <= rect.getY()+rect.getHeight());
      return layout;
	}
	public void addChild(GardenObject shape){
		flowers.add(shape);
	}
	@Override
	public void move(double dX, double dY) {
		rect.setX(rect.getX()+dX);
		rect.setY(rect.getY()+dY);	
		for(GardenObject flower: flowers){
			flower.move(dX,dY);
		}
	
	}
	
}
