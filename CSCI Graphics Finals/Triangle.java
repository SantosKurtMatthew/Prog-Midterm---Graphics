/**
The Triangle class is a basic shape and extends the DrawingObject abstract class.
It is drawn using a Path2D object.

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

public class Triangle extends DrawingObject{
	private double oneX;
	private double oneY;
	private double twoX;
	private double twoY;
	private double threeX;
	private double threeY;
	private Color color;
	private Path2D.Double triangle;
	private String type;
	
	/**
		The constructor initializes the values.
		The coordinates for the 3 vertexes of the triangle, the color, and whether the triangle is filled or drawn are taken as arguments.
		@param oneX the x coordinate of the first vertex
		@param oneY the y coordinate of the first vertex
		@param twoX the x coordinate of the second vertex
		@param twoY the y coordinate of the second vertex
		@param threeX the x coordinate of the third vertex
		@param threeY the y coordinate of the third vertex
		@param color the color of the triangle
		@param type takes "fill" or "draw" as arguments in order to decide how to create the triangle
	**/
	public Triangle(double oneX, double oneY, double twoX, double twoY, double threeX, double threeY, Color color, String type) {
		this.oneX = oneX;
		this.oneY = oneY;
		this.twoX = twoX;
		this.twoY = twoY;
		this.threeX = threeX;
		this.threeY = threeY;
		this.color = color;
		this.type = type;
	}

	/**	
		The triangle is drawn using Path2D.Double and Graphics2D
		Starting from the first vertex, going to the second, then the third. It closes the path afterwards.
		Then it fills or draws the triangle.
		@param g2d The Graphics2D object
	**/
	public void draw(Graphics2D g2d) {
		
		triangle = new Path2D.Double();
		triangle.moveTo(oneX, oneY);
		triangle.lineTo(twoX, twoY);
		triangle.lineTo(threeX, threeY);
		triangle.closePath();
		g2d.setColor(color);
		
		if( type.equals( "fill" ) )
			g2d.fill(triangle);
		else if( type.equals( "draw" ) )
			g2d.draw(triangle);
		
	}

}