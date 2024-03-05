/**
The Bamboo class extends the DrawingObject abstract class.
It draws a Bamboo using a Rectangle2D and multiple Lines.
It is scalable.

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

public class Bamboo extends DrawingObject{
	private double x;
	private double y;
	private double size;
	private Rectangle2D.Double stem;
	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;

	/**
		The constructor initializes the variables needed for the ducky.
		@param x the starting x value of the bamboo
		@param y the starting y value of the bamboo
		@param size the general size of the bamboo
	**/
	public Bamboo(double x, double y, double size){
		
		stem = new Rectangle2D.Double(x, y, size/2, 24*size);

		l1 = new Line(x-1, ((y+100)/25)*size, x+size/2, ((y+100)/25)*size, 3, new Color(51,51,0));
		l2 = new Line(x-1, ((y+150)/25)*size, x+size/2, ((y+150)/25)*size, 3, new Color(51,51,0));
		l3 = new Line(x-1, ((y+200)/25)*size, x+size/2, ((y+200)/25)*size, 3, new Color(51,51,0));
		l4 = new Line(x-1, ((y+250)/25)*size, x+size/2, ((y+250)/25)*size, 3, new Color(51,51,0));

	}

	/**
		The bamboo is drawn by drawing the Rectangle2D and the multiple Lines.
		@param g2d the Graphics2D object.
	**/
	public void draw(Graphics2D g2d){
		g2d.setColor(new Color(19, 38, 14));
		g2d.fill(stem);
		g2d.setStroke(new BasicStroke((int)size/10));
		l1.draw(g2d);
		l2.draw(g2d);
		l3.draw(g2d);
		l4.draw(g2d);
	}

}