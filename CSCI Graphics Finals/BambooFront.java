import java.awt.*;
import java.awt.geom.*;


public class BambooFront extends DrawingObject {


	private Bamboo b1, b2, b3, b4, b5, b6, b7;
	
	public BambooFront() {
		
		b1 = new Bamboo(50, 0, 45);
		b2 = new Bamboo(150, -25, 55);
		b3 = new Bamboo(250, -50, 90);
		b4 = new Bamboo(425, -35, 70);
		b5 = new Bamboo(475, -20, 55);
		b6 = new Bamboo(600, -50, 70); 
		b7 = new Bamboo(700, 0, 45);
	}
	
	public void draw(Graphics2D g2d) {
		
		AffineTransform reset = g2d.getTransform();
		
		b1.draw(g2d);
		
		g2d.rotate(Math.toRadians(10),200,300);
		b2.draw(g2d);
		g2d.setTransform(reset);
		
		b3.draw(g2d);
		
		g2d.rotate(Math.toRadians(20),425,300);
		b4.draw(g2d);
		g2d.setTransform(reset);
		
		g2d.rotate(Math.toRadians(-15),475,300);
		b5.draw(g2d);
		g2d.setTransform(reset);
		
		b6.draw(g2d); 
		
		g2d.rotate(Math.toRadians(-5),700,300);
		b7.draw(g2d);
		g2d.setTransform(reset);
	}

}