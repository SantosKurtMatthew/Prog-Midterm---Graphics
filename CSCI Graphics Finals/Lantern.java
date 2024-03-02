import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.font.*;

public class Lantern extends DrawingObject{
	private float x;
	private float y;
	private float yOriginal;

	public Lantern(float x, float y){
		this.x = x;
		this.y = y;
		yOriginal = y;
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

	public double giveX(){
		System.out.println("THE RETURNED  X IS " + x);
		return x;
	}

	public void flow() {
		x += 3;
		if(x > 800){
			x = 0;
		}
		if(y == yOriginal+5){
			y -= 10;
		}
		else{
			y += 5;
		}

	}

}