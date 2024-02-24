import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Mountain extends DrawingObject{


	class MountainBlock extends DrawingObject{
		private float x;
		private float y;
		private float width;
		private float height;
		private boolean opaque;

		public MountainBlock(float x, float y, float width, float height, boolean opaque){
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.opaque = opaque;

		}	

		public void draw(Graphics2D g2d){
			Rectangle2D.Double r = new Rectangle2D.Double(x, y, width, height);
			System.out.println(opaque);
			Point2D start = new Point2D.Float(x+(x/2), y);
			Point2D end = new Point2D.Float(x+(x/2), y+height);
			float[] dist = {0.0f, 0.35f, 1.0f};
			Color[] colors = {Color.BLACK, Color.GRAY, Color.WHITE};	
			if (opaque == false){
				colors[0] = new Color(0, 0 ,0);
				colors[1] = new Color(128, 128, 128, 200);
				colors[2] = new Color(255, 255, 255);//{, , };	
			}
			
			LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
			g2d.setPaint(p);
			g2d.fill(r);
		}
	}
	public Mountain(){
	}

	public void draw(Graphics2D g2d){
		MountainBlock m1peak1 = new MountainBlock(150, 100, 100, 500, true);
		m1peak1.draw(g2d);
		MountainBlock m1peak2 = new MountainBlock(115, 150, 75, 450, true);
		m1peak2.draw(g2d);
		MountainBlock m1peak3 = new MountainBlock(230, 275, 80, 325, true);
		m1peak3.draw(g2d);
		MountainBlock m1peak4 = new MountainBlock(90, 375, 50, 225, true);
		m1peak4.draw(g2d);

		MountainBlock m2peak1 = new MountainBlock(500, 210, 70, 390, true);
		m2peak1.draw(g2d);
		MountainBlock m2peak2 = new MountainBlock(570, 310, 40, 290, true);
		m2peak2.draw(g2d);
		MountainBlock m2peak3 = new MountainBlock(460, 390, 40, 210, true);
		m2peak3.draw(g2d);
		MountainBlock m2peak4 = new MountainBlock(440, 450, 90, 150, true);
		m2peak4.draw(g2d);

		MountainBlock m3peak1 = new MountainBlock(880, 120, 70, 480, true);
		m3peak1.draw(g2d);
		MountainBlock m3peak2 = new MountainBlock(840, 190, 40, 410, true);
		m3peak2.draw(g2d);
		MountainBlock m3peak3 = new MountainBlock(810, 340, 50, 260, true);
		m3peak3.draw(g2d);
		MountainBlock m3peak4 = new MountainBlock(825, 400, 70, 200, true);
		m3peak4.draw(g2d);

		
		float alpha = 0.5f; //draw half transparent
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(ac);

		MountainBlock b1peak1 = new MountainBlock(-20 ,180, 60, 420, false);
		b1peak1.draw(g2d);
		MountainBlock b1peak2 = new MountainBlock(10, 275, 50, 325, false);
		b1peak2.draw(g2d);
		MountainBlock b1peak3 = new MountainBlock(-40, 400, 60, 200, false);
		b1peak3.draw(g2d);

	}
}