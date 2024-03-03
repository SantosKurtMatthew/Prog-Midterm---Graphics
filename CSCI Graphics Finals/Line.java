/**
The Line class extends the DrawingObject abstract class. The constructor takes the starting x and y position, 
the ending x and y position, thickness, and color of the line as its parameters.
The draw method draws the line, using the setStroke() method to change the thickness.

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
import javax.swing.*;
public class Line extends DrawingObject{
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private int thickness;
	private Color color;

	/**	
		Constructor takes the arguments and initializes the values
		@param x1 the starting x coordinate
		@param y1 the starting y coordinate
		@param x2 the ending x coordinate
		@param y2 the ending y coordinate
		@param thickness the thickness of the line
		@param color the color of the line
	**/
	public Line(double x1, double y1, double x2, double y2, int thickness, Color color){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.thickness = thickness;
		this.color = color;
	}

	/**	
		The line is drawn using Line2D.Double and Graphics2D
		@param g2d The Graphics2D object
	**/
	public void draw(Graphics2D g2d){
		Line2D.Double l = new Line2D.Double(x1, y1, x2, y2);
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(thickness));
		g2d.draw(l);
		g2d.setStroke(new BasicStroke(1));
	}
}