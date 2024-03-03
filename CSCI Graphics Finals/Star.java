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