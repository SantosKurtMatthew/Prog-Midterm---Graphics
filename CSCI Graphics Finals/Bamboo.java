import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Bamboo extends DrawingObject{
	private double x;
	private double y;
	private Rectangle2D.Double stem;
	private Line l1;
	private Line l2;
	private Line l3;


	public Bamboo(){
		stem = new Rectangle2D.Double(500, 0, 100, 500);

		//Line(double x1, double y1, double x2, double y2, double thickness, double Color)
		l1 = new Line(500, 400, 600, 400, 3, new Color(51,51,0));

	}

	public void draw(Graphics2D g2d){
		System.out.println("THIS BAMBOO PRINTS");
		g2d.setColor(new Color(19, 38, 14));
		g2d.fill(stem);
		l1.draw(g2d);
	}
}