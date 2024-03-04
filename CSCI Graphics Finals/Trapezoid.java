/**
The Trapezoid class is a basic shape and extends the DrawingObject abstract class. 
The constructor takes the starting x and y coordinates where the point of reference is the top left corner of a rectangle surrounding the trapezoid, the width, 
the height and the color of the trapezoid.
The Trapezoid is drawn using a Path2D.Double object.

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

public class Trapezoid extends DrawingObject{
	private double x;
	private double y;
	private double width;
	private double height;
	private Color color;
	/**	
		Constructor takes the arguments and initializes the values
		@param x the leftmost x value of the trapezoid
		@param y the uppermost y value of the trapezoid
		@param width the widht of the trapezoid
		@param height the height of the trapezoid
		@param color the color of the trapezoid

	**/
	public Trapezoid(double x, double y, double width, double height, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	/**	
		The trapezoid is drawn using Path2D.Double and Graphics2D
		@param g2d The Graphics2D object
	**/
	public void draw(Graphics2D g2d){
		Path2D.Double t = new Path2D.Double();
		t.moveTo(x+(50), y);
		t.lineTo(x, y+height);
		t.lineTo(x+width, y+height);
		t.lineTo(x+width-(50), y);
		t.closePath();
		g2d.setColor(color);
		g2d.fill(t);
	}
}