/**
The Square class extends the DrawingObject abstract class. The constructor takes the starting x and y coordinates, 
the size of the square, and its color as parameters. The draw method will draw the circle given the previous parameters.

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

public class Square extends DrawingObject{
	private double x;
	private double y;
	private double size;
	private Color color;

	/**
		Constructor takes the arguments and initializes the values
		@param x the starting x position of the square
		@param y the starting y position of the square
		@param size the width and height of the square
		@param color the color of the square
	**/ 
	public Square(double x, double y, double size, Color color){
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}

	/**	The circle is drawn using Rectangle2D.Double and Graphics2D
		@param g2d The Graphics2D object
	**/
	public void draw(Graphics2D g2d){
		Rectangle2D.Double r = new Rectangle2D.Double(x, y, size, size);
		g2d.setColor(color);
		g2d.fill(r);
	}

}