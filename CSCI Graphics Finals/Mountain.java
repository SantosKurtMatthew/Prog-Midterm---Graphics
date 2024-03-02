import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Mountain extends DrawingObject{


	class MountainBlock extends DrawingObject{
		private float x;
		private float y;
		private float width;
		private float height;

		public MountainBlock(float x, float y, float width, float height){
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}	

		public void draw(Graphics2D g2d){
			Rectangle2D.Double r = new Rectangle2D.Double(x, y, width, height);
			Point2D start = new Point2D.Float(x+(x/2), y);
			Point2D end = new Point2D.Float(x+(x/2), y+height);
			float[] dist = {0.0f, 0.35f, 1.0f};
			Color[] colors = {Color.BLACK, Color.GRAY, Color.WHITE};	

			
			LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
			g2d.setPaint(p);
			g2d.fill(r);
		}
	}
	public Mountain(){
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

		MountainBlock m1peak1 = new MountainBlock(150, 100, 100, 500);
		m1peak1.draw(g2d);
		MountainBlock m1peak2 = new MountainBlock(115, 150, 75, 450);
		m1peak2.draw(g2d);
		MountainBlock m1peak3 = new MountainBlock(230, 275, 80, 325);
		m1peak3.draw(g2d);
		MountainBlock m1peak4 = new MountainBlock(90, 375, 50, 225);
		m1peak4.draw(g2d);

		MountainBlock m2peak1 = new MountainBlock(500, 210, 70, 390);
		m2peak1.draw(g2d);
		MountainBlock m2peak2 = new MountainBlock(570, 310, 40, 290);
		m2peak2.draw(g2d);
		MountainBlock m2peak3 = new MountainBlock(460, 390, 40, 210);
		m2peak3.draw(g2d);
		MountainBlock m2peak4 = new MountainBlock(440, 450, 90, 150);
		m2peak4.draw(g2d);

		MountainBlock m3peak1 = new MountainBlock(880, 120, 70, 480);
		m3peak1.draw(g2d);
		MountainBlock m3peak2 = new MountainBlock(840, 190, 40, 410);
		m3peak2.draw(g2d);
		MountainBlock m3peak3 = new MountainBlock(810, 340, 50, 260);
		m3peak3.draw(g2d);
		MountainBlock m3peak4 = new MountainBlock(825, 400, 70, 200);
		m3peak4.draw(g2d);

		
		float alpha = 0.3f; //draw half transparent
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(ac);

		MountainBlock b1peak1 = new MountainBlock(-20 ,180, 60, 420);
		b1peak1.draw(g2d);
		MountainBlock b1peak2 = new MountainBlock(10, 275, 50, 325);
		b1peak2.draw(g2d);
		MountainBlock b1peak3 = new MountainBlock(-40, 400, 60, 200);
		b1peak3.draw(g2d);

		MountainBlock b2peak1 = new MountainBlock(355, 160, 65, 440);
		b2peak1.draw(g2d);
		MountainBlock b2peak2 = new MountainBlock(330, 200, 50, 400);
		b2peak2.draw(g2d);
		MountainBlock b2peak3 = new MountainBlock(410, 350, 30, 250);
		b2peak3.draw(g2d);

		MountainBlock b3peak1 = new MountainBlock(680, 210, 70, 390);
		b3peak1.draw(g2d);
		MountainBlock b3peak2 = new MountainBlock(730, 260, 50, 340);
		b3peak2.draw(g2d);
		MountainBlock b3peak3 = new MountainBlock(640, 330, 60, 270);
		b3peak3.draw(g2d);
		MountainBlock b3peak4 = new MountainBlock(670, 375, 70, 225);
		b3peak4.draw(g2d);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

	}
}