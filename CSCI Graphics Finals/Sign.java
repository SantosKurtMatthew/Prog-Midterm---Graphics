/**
The Sign class is a composite shape and extends the DrawingObject abstract class. 
The constructor takes the starting x and y coordinates where the point of reference is the top left corner of the woodPlank.
The draw method will draw the woodPlank (a square) and a woodStake (a line) going vertically through the middle of the plank.
It will also draw text that says "Duck Land <-" onto the plank using the TextLayout object.

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
import java.awt.font.*;

public class Sign extends DrawingObject{
	private int x, y;
	private boolean stickExists;
	private String location, direction;

	/**	
		Constructor takes the arguments and initializes the values
		@param x the starting x coordinate of the woodenPlank square
		@param y the starting y coordinate of the woodenPlank square
		@param stickExists whether or not the wooden stick will be drawn
		@param location the location that will be printed on the sign
		@param direction the arrow to be printed on the sign
	**/
	public Sign(int x, int y, boolean stickExists, String location, String direction){
		this.x = x;
		this.y = y;
		this.stickExists = stickExists;
		this.location = location;
		this.direction = direction;
	}

	/**	
		The square and line are drawn using the basic shape classes, then
		the text is drawn using the TextLayout object.
		@param g2d The Graphics2D object
	**/
	public void draw(Graphics2D g2d){
		
		Square woodPlank = new Square(x, y, 60, new Color(179, 146, 70));
		if (stickExists){
			Line woodStake = new Line(x+30, y-5, x+30, y+75, 5, new Color(117, 98, 53));
			woodStake.draw(g2d);	
		}
		woodPlank.draw(g2d);

		Font font = new Font ("TimesRoman", Font.PLAIN, 15);
		FontRenderContext frc = g2d.getFontRenderContext();
		Point2D loc1 = new Point2D.Float(x+12, y+20);
		TextLayout layout1 = new TextLayout("Duck", font, frc);
		Point2D loc2 = new Point2D.Float(x+12, y+35);
		TextLayout layout2 = new TextLayout(location, font, frc);
		g2d.setColor(Color.BLACK);
		layout1.draw(g2d, (float)loc1.getX(), (float)loc1.getY());
		layout2.draw(g2d, (float)loc2.getX(), (float)loc2.getY());
		
		Font fontBold = new Font ("TimesRoman", Font.BOLD, 15);
		TextLayout layout3 = new TextLayout(direction, fontBold, frc);
		Point2D loc3 = new Point2D.Float(x+25, y+50);
		layout3.draw(g2d, (float)loc3.getX(), (float)loc3.getY());
	}
}