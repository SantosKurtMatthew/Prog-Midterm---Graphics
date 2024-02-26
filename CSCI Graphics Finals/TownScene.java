import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class TownScene extends DrawingObject{
	private RedGate rg;

	public TownScene(){
		rg = new RedGate();
	}

	public void draw(Graphics2D g2d){
		Rectangle2D.Double background = new Rectangle2D.Double(0,0,800,600);
		Point2D start = new Point2D.Float(400, 0);
		Point2D end = new Point2D.Float(400, 600);
		float[] dist = {0.0f, 1.0f};
		Color[] colors = {Color.BLACK, new Color(6, 40, 96)};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(background);

		Circle moonInner = new Circle(650, 50, 90, new Color(231, 230, 230));
		Circle moonOuter = new Circle(650, 50, 100, new Color(136, 136, 136));
		moonOuter.draw(g2d);
		moonInner.draw(g2d);
		
		rg.draw(g2d);

	}


}