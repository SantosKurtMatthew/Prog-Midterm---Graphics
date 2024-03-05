import java.awt.*;
import java.awt.geom.*;


public class Bamboo extends DrawingObject{
	private double x;
	private double y;
	private double size;
	private Rectangle2D.Double stem;
	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;

	public Bamboo(double x, double y, double size){
		
		stem = new Rectangle2D.Double(x, y, size/2, 24*size);

		l1 = new Line(x-1, ((y+100)/25)*size, x+size/2, ((y+100)/25)*size, 3, new Color(51,51,0));
		l2 = new Line(x-1, ((y+150)/25)*size, x+size/2, ((y+150)/25)*size, 3, new Color(51,51,0));
		l3 = new Line(x-1, ((y+200)/25)*size, x+size/2, ((y+200)/25)*size, 3, new Color(51,51,0));
		l4 = new Line(x-1, ((y+250)/25)*size, x+size/2, ((y+250)/25)*size, 3, new Color(51,51,0));

	}

	public void draw(Graphics2D g2d){
		g2d.setColor(new Color(19, 38, 14));
		g2d.fill(stem);
		g2d.setStroke(new BasicStroke((int)size/10));
		l1.draw(g2d);
		l2.draw(g2d);
		l3.draw(g2d);
		l4.draw(g2d);
	}

}