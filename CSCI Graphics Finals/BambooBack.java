import java.awt.*;
import java.awt.geom.*;


public class BambooBack extends DrawingObject {

	private int x;
	
	public BambooBack() {
	}
	
	class BambooBackSegment extends DrawingObject {
		
		private Rectangle2D.Double r1, r2, r3, r4, r5;
		
		public BambooBackSegment(int x) {
			r1 = new Rectangle.Double(x+10,-50,30,800);
			r2 = new Rectangle.Double(x+100,-50,30,800);
			r3 = new Rectangle.Double(x+200,-50,30,800);
			r4 = new Rectangle.Double(x+300,-50,30,800);
			r5 = new Rectangle.Double(x+350,-50,30,800);
		}
		
		public void draw(Graphics2D g2d){
			
			AffineTransform reset = g2d.getTransform();
			g2d.setColor(new Color(19, 38, 14, 100));
			
			g2d.rotate(Math.toRadians(-5),x+10,300);
			g2d.fill(r1);
			g2d.setTransform(reset);
			
			g2d.fill(r2);
			g2d.fill(r3);
			
			g2d.rotate(Math.toRadians(5),x+250,300);
			g2d.fill(r4);
			g2d.setTransform(reset);
			
			g2d.rotate(Math.toRadians(-15),x+300,300);		
			g2d.fill(r5);
			g2d.setTransform(reset);
		}
	}
	
	public void draw(Graphics2D g2d) {
		Rectangle2D.Double background = new Rectangle2D.Double(0,0,800,600);
		Point2D start = new Point2D.Float(400, 0);
		Point2D end = new Point2D.Float(400, 600);
		float[] dist = {0.0f, 1.0f};
		Color[] colors = {Color.BLACK, new Color(6, 40, 96)};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(background);
		
		BambooBackSegment bbs1 = new BambooBackSegment(0);
		BambooBackSegment bbs2 = new BambooBackSegment(390);
		bbs1.draw(g2d);
		bbs2.draw(g2d);
	}
	
}