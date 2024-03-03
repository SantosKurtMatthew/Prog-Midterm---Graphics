import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Trapezoid extends DrawingObject{
	private double x;
	private double y;
	private double width;
	private double height;
	private Color color;

	public Trapezoid(double x, double y, double width, double height, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public void draw(Graphics2D g2d){
		Path2D.Double t = new Path2D.Double();
		t.moveTo(x+(50), y);
		t.lineTo(x, y+height);
		t.lineTo(x+width, y+height);
		t.lineTo(x+width-(50), y);
		t.closePath();
		g2d.setColor(color);
		g2d.fill(t);
	}
}