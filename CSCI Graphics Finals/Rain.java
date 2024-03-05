import java.awt.*;
import java.awt.geom.*;

public class Rain extends DrawingObject {
	
	private Line2D.Double drop;
	private int x, y;
	
	public Rain(int x) {
		this.x = x;
		y = 30+(int)(Math.random()*500);

	}
	
	public void draw(Graphics2D g2d) {

		drop = new Line2D.Double(x, y, x, y+60);
		
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(new Color(255,255,255,100));
		g2d.draw(drop);
	}
	
	public void flow() {
		y += 50;

		if(y > 600){
			y=0;
		}
		
		
	}
	
}