import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.font.*;

public class Lantern extends DrawingObject{
	private float x;
	private float y;
	private float xOriginal;
	private float yOriginal;
	private float newBaseY;
	private boolean up;

	public Lantern(float x, float y){
		//allowed space is (650, 235)
		this.x = x;
		this.y = y;
		yOriginal = y;
		xOriginal = x;
		up = false;
		newBaseY = y;
	}

	public void draw(Graphics2D g2d){
		//One Lantern is 60 pixels wide and 70 pixels tall
		Path2D.Double l = new Path2D.Double();
		l.moveTo(x+15, y);
		l.lineTo(x+45, y);
		l.lineTo(x+60, y+25);
		l.lineTo(x+40, y+70);
		l.lineTo(x+20, y+70);
		l.lineTo(x, y+25);
		l.closePath();

		Point2D start = new Point2D.Float(x+75, y);
		Point2D end = new Point2D.Float(x+75, y+70);
		float[] dist = {0.0f, 0.4f, 1.0f};
		Color[] colors = {new Color(255, 192, 31), new Color(255, 224,143), Color.WHITE};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(l);

		Point2D loc = new Point2D.Float(x+15, y+40);
		Font font = new Font ("TimesRoman", Font.BOLD, 30);
		FontRenderContext frc = g2d.getFontRenderContext();
		TextLayout layout = new TextLayout("嘎", font, frc);
		g2d.setColor(new Color(144, 35, 35));
		layout.draw(g2d, (float)loc.getX(), (float)loc.getY());
	}

	public void flow() {
		x ++;
		if(x > 800){
			x = xOriginal;
			y = yOriginal;
		}
		
		if(y == newBaseY+10){
			up = true;
		}
		else if(y == newBaseY) {
			up = false;
			newBaseY -= 3;
		}
		
		if( up ) {
			y -= 0.5;
		}
		else{
			y += 0.5;
		}
		

	}

}