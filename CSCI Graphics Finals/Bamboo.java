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
	private Line l4;

	public Bamboo(double x, double y){
		stem = new Rectangle2D.Double(x, y, 100, 500);

		//Line(double x1, double y1, double x2, double y2, double thickness, double Color)
		l1 = new Line(x, y+100, x+100, y+100, 3, new Color(51,51,0));
		l2 = new Line(x, y+170, x+100, y+170, 3, new Color(51,51,0));
		l3 = new Line(x, y+280, x+100, y+280, 3, new Color(51,51,0));
		l4 = new Line(x, y+400, x+100, y+400, 3, new Color(51,51,0));

	}

	public void draw(Graphics2D g2d){
		g2d.setColor(new Color(19, 38, 14));
		g2d.fill(stem);
		l1.draw(g2d);
		l2.draw(g2d);
		l3.draw(g2d);
		l4.draw(g2d);
	}
}