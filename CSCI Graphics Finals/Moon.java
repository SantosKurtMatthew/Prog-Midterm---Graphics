/**
The Moon class extends the DrawingObject abstract class.
It is drawn using multiple Circles. It has an animation function for the glow growing and shrinking in size.

@author Nicole (Coeli) Pararuan (234814) and Kurt Santos (235666)
@version March 6, 2024
**/

/*
I have not discussed the Java language code in my program
with anyone other than my instructor or the teaching assistants
assigned to this course.

I have not used Java language code obtained from another student,
or any other unauthorized source, either modified or unmodified.

If any Java language code or documentation used in my program
was obtained from another source, such as a textbook or website,
that has been clearly noted with a proper citation in the comments
of my program.
*/
import java.awt.*;
import java.awt.geom.*;

public class Moon extends DrawingObject{
	private Circle inner, outer, glow1, glow2, glow3;
	private boolean full1, full2,full3;
	private int x1, y1, s1, x2, y2, s2, x3, y3, s3;
	private Color innerColor, outerColor;

	/**	
		Constructor takes the arguments and initializes the values
		@param innerColor the color of the inner circle of the moon
		@param outerColor the color of the outer circle (the shade) of the moon
	**/
	public Moon(Color innerColor, Color outerColor) {
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
		this.innerColor = innerColor;
		this.outerColor = outerColor;
	}
	
	/**	
		The moon and its glow are drawn using 5 Circles in total.
		@param g2d The Graphics2D object
	**/
	public void draw(Graphics2D g2d){
		inner = new Circle(650, 50, 90, innerColor);
		outer = new Circle(650, 50, 100, outerColor);
		glow1 = new Circle(x1, y1, s1, new Color(255,255,153,10));
		glow2 = new Circle(x2, y2, s2, new Color(255,255,153,10));
		glow3 = new Circle(x3, y3, s3, new Color(255,255,153,10));

		outer.draw(g2d);
		inner.draw(g2d);
		glow1.draw(g2d);
		glow2.draw(g2d);
		glow3.draw(g2d);
	}

	/**
		This method is meant to be used with the timer in the SceneCanvas class in order to animate the glow of the moon.
		In order to make the pulsing slower, the pulsing only happens at specific intervals of the timer. It will either 
		shrink or set the glow circle back to its normal size. Each of the 3 glow circles of the moon has a different interval.
	**/
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