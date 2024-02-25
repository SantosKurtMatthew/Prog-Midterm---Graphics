import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class MountainScene extends DrawingObject{
	private Mountain m;

	public MountainScene(){
		m = new Mountain();
	}

	public void draw(Graphics2D g2d){
		Rectangle2D.Double background = new Rectangle2D.Double(0,0,800,950);
		Point2D start = new Point2D.Float(400, 0);
		Point2D end = new Point2D.Float(400, 600);
		float[] dist = {0.0f, 0.2f, 0.8f};
		Color[] colors = {new Color(26,77,146), new Color(102, 148, 198), Color.WHITE};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(background);

		m.draw(g2d);

	}


}