import java.awt.*;
import java.awt.geom.*;

public class Cloud extends DrawingObject{

	private double x;
	private double y;
	private double size;
	private Color color;
	private Ellipse2D.Double e1;
	private Ellipse2D.Double e2;
	private Ellipse2D.Double e3;
	private Ellipse2D.Double e4;

	public Cloud(double x, double y, double size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	
	public void draw(Graphics2D g2d){
		
	}
	public void drawCloudOne(Graphics2D g2d) {
		e1 = new Ellipse2D.Double(x,y+size*.7,size*1.75,size);
		e2 = new Ellipse2D.Double(x+size*.6,y,size*3,size*1.7);
		e3 = new Ellipse2D.Double(x+size*2.6,y+size*.7,size*2,size);
		e4 = new Ellipse2D.Double(x+size*3.8,y+size*1.2,size*1.5,size*.5);
		g2d.setColor(color);
		g2d.fill(e1);
		g2d.fill(e2);
		g2d.fill(e3);
		g2d.fill(e4);
	}
	
	public void drawCloudTwo(Graphics2D g2d) {
		e1 = new Ellipse2D.Double(x,y+size*.5,size*2,size*.8);
		e2 = new Ellipse2D.Double(x+size*1.1,y,size*3,size*1.5);
		e3 = new Ellipse2D.Double(x+size*2.9,y+size*.3,size*2.1,size);
		g2d.setColor(color);
		g2d.fill(e1);
		g2d.fill(e2);
		g2d.fill(e3);
	}
	
	public void drawCloudThree(Graphics2D g2d) {
		e1 = new Ellipse2D.Double(x,y+size*.8,size*1.75,size*.8);
		e2 = new Ellipse2D.Double(x+size*.7,y,size*2.8,size*1.8);
		e3 = new Ellipse2D.Double(x+size*2.7,y+size*.3,size*2.1,size*1.4);
		e4 = new Ellipse2D.Double(x+size*3.9,y+size*.8,size*1.5,size*.8);
		g2d.setColor(color);
		g2d.fill(e1);
		g2d.fill(e2);
		g2d.fill(e3);
		g2d.fill(e4);
	}
	
}