/**
The Star class is a composite shape and extends the DrawingObject abstract class. 
It is drawn using a Square and 4 Triangles on the sides of the Square and a Line going diagonally through. 
There are two types of stars with different lengths of the side triangles.
It also has a circle for the glow of the star.
It has an animation function for the glow growing and shrinking in size. 

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

public class Star extends DrawingObject{
	
	private int x, y, size, type, flickerCounter;
	private Triangle north, south, west, east;
	private Square center;
	private Line shimmer;
	private Color starColor, shimmerColor, glowColor;
	private Circle glow;
	private double glowSize, glowPosition;
	private boolean glowFull;
	
	/**	
		Constructor takes the arguments and initializes the values
		@param x the x value of the star
		@param y the y value of the star
		@param size the size of the star
		@param type the type of the star
	**/
	public Star(int x, int y, int size, int type) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.type = type;
		starColor = new Color(255,255,153);
		shimmerColor = new Color(255,255,153,100);
		glowColor = new Color(255,255,153,15);
		glowSize = size;
		glowFull = true;
		flickerCounter = 0;	
		glowPosition = -15;
	}
	
	/**	
		The star and its glow are drawn using the Square, 4 Triangles, Line, and Circle.
		If the star is type 1, the sides of the star are shorter than the top and bottom.
		If it is type 2, all of the Triangles are the same size.
		@param g2d The Graphics2D object
	**/
	public void draw(Graphics2D g2d){
		
		north = new Triangle(x+size*20, y, x+size*18, y+size*18, x+size*22, y+size*18, starColor, "fill");
		south = new Triangle(x+size*20, y+size*40, x+size*18, y+size*22, x+size*22, y+size*22, starColor, "fill");
		center = new Square(x+size*18, y+size*18, size*4, starColor);
		shimmer = new Line(x+size*10, y+size*10, x+size*30, y+size*30, size, shimmerColor);
		
		if( type == 1 ) {
			west = new Triangle(x+size*10, y+size*20, x+size*18, y+size*18, x+size*18, y+size*22, starColor, "fill");
			east = new Triangle(x+size*30, y+size*20, x+size*22, y+size*18, x+size*22, y+size*22, starColor, "fill");
		}
		else if( type == 2 ) {
			west = new Triangle(x, y+size*20, x+size*18, y+size*18, x+size*18, y+size*22, starColor, "fill");
			east = new Triangle(x+size*40, y+size*20, x+size*22, y+size*18, x+size*22, y+size*22, starColor, "fill");
		}
		
		glow = new Circle(x + (size * glowPosition),  y + (size * glowPosition), glowSize * 70, glowColor);
		
		north.draw(g2d);
		south.draw(g2d);
		west.draw(g2d);
		east.draw(g2d);
		center.draw(g2d);
		shimmer.draw(g2d);
		
		glow.draw(g2d);
		
	}

	/**
		This method is meant to be used with the timer in the SceneCanvas class in order to animate the glow of the star.
		In order to make the pulsing slower, the pulsing only happens at specific intervals of the timer. It will either 
		shrink or set the glow circle back to its normal size.
	**/
	public void glowFlow(int flickerCounter){
		if(flickerCounter % 10 == 0){
			if(glowFull == true){
				glowSize = size;
				glowPosition = -15;
				glowFull = false;
			}
			else{
				glowSize = size*0.8;
				glowPosition = -7.5;
				glowFull = true;
			}	
		}

	}
}