/**
The Rain class extends the DrawingObject abstract class.
It is a Line2D drawn at a specific coordinate.
It can be animated to fall downwards.

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

public class Rain extends DrawingObject {
	
	private Line2D.Double drop;
	private int x, y;
	
	/**
		The constructor initializes the variables needed for the ducky.
		@param x the x value of the rain drop
	**/	
	public Rain(int x) {
		this.x = x;
		y = 30+(int)(Math.random()*500);

	}

	/**
		The line is drawn.
		@param g2d the Graphics2D object
	**/
	public void draw(Graphics2D g2d) {
		drop = new Line2D.Double(x, y, x, y+60);
		
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(new Color(255,255,255,100));
		g2d.draw(drop);
	}
	
	/**
		To be used with the timer in SceneCanvas.
		The raindrop falls downward and upon hitting the bottom of the screen is reset.
	**/
	public void flow() {
		y += 50;

		if(y > 600){
			y=0;
		}
	}
}