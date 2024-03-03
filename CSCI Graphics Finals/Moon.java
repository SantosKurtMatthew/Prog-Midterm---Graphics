import java.awt.*;
import java.awt.geom.*;

public class Moon extends DrawingObject{
	private Circle inner, outer, glow1, glow2, glow3;
	private boolean full1, full2,full3;
	private int x1, y1, s1, x2, y2, s2, x3, y3, s3;
	public Moon() {
		full1 = true;
		full2 = true;
		full3 = true;
		x1 = 600;
		y1 = 0;
		s1 = 200;
		x2 = 575;
		y2 = -25;
		s2 = 250;
		x3 = 550;
		y3 = -50;
		s3 = 300;
	}
	
	public void draw(Graphics2D g2d){


		inner = new Circle(650, 50, 90, new Color(231, 230, 230));
		outer = new Circle(650, 50, 100, new Color(136, 136, 136));
		glow1 = new Circle(x1, y1, s1, new Color(255,255,153,10));
		glow2 = new Circle(x2, y2, s2, new Color(255,255,153,10));
		glow3 = new Circle(x3, y3, s3, new Color(255,255,153,10));

		
		outer.draw(g2d);
		inner.draw(g2d);
		glow1.draw(g2d);
		glow2.draw(g2d);
		glow3.draw(g2d);


	}

	public void glowFlow(int flickerCounter){
		if(flickerCounter % 30 == 0){
			if(full3 == true){
				x3 = 550;
				y3 = -50;
				s3 = 300;
				
				full3 = false;
			}
			else{
				x3 = 575;
				y3 = -25;
				s3 = 250;

				full3 = true;
			}	
		}

		if(flickerCounter % 20 == 0){
			if(full2 == true){
				x2 = 575;
				y2 = -25;
				s2 = 250;

				full2 = false;
			}
			else{
				x2 = 550;
				y2 = -50;
				s2 = 300;

				full2 = true;
			}	
		}
		if(flickerCounter % 10 == 0){
			if(full1 == true){
				x1 = 600;
				y1 = 0;
				s1 = 200;
				full1 = false;
			}
			else{
				x1 = 625;
				y1 = 25;
				s1 = 150;
				full1 = true;
			}	
		}

	}
}