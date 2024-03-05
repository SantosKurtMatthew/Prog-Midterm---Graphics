/**
The Cloud class extends the DrawingObject abstract class.
It draws one of 3 possible cloud shapes. 
It is animated using a timer in SceneCanvas.

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

public class Cloud extends DrawingObject{

	private double x;
	private double y;
	private double size;
	private Color color;
	private int cloudNumber;
	private Ellipse2D.Double e1;
	private Ellipse2D.Double e2;
	private Ellipse2D.Double e3;
	private Ellipse2D.Double e4;
	private boolean fog;

	/**
		The constructor initializes the values. The type of the cloud is randomly generated.
		Random Integer Source: https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
		@param x the starting x value of the cloud
		@param y the starting y value of the cloud
		@param fog decides transulency and size
	**/
	public Cloud(double x, double y, boolean fog) {
		this.x = x;
		this.y = y;
		this.fog = fog;
		cloudNumber = (int)(Math.random()*3);
		
		if( fog ) {
			size = (50+(int)(Math.random()*30));
			color = new Color(255,255,255,100);
		}
		else {
			size = (20+(int)(Math.random()*30));
			color = Color.WHITE;
		}
		
	}
	
	/**
		The cloud is drawn using multiple ellipses in different positions.
		They are then filled with the color set in the constructor.
		@param g2d the Graphics2D object
	**/
	public void draw(Graphics2D g2d){
		
		if (cloudNumber == 0){
			e1 = new Ellipse2D.Double(x,y+size*.8,size*1.75,size*.8);
			e2 = new Ellipse2D.Double(x+size*.7,y,size*2.8,size*1.8);
			e3 = new Ellipse2D.Double(x+size*2.7,y+size*.3,size*2.1,size*1.4);
			e4 = new Ellipse2D.Double(x+size*3.9,y+size*.8,size*1.5,size*.8);
			g2d.setColor(color);
			g2d.fill(e1);
			g2d.fill(e2);
			g2d.fill(e3);
			g2d.fill(e4);
		}
		else if(cloudNumber == 1){
			e1 = new Ellipse2D.Double(x,y+size*.5,size*2,size*.8);
			e2 = new Ellipse2D.Double(x+size*1.1,y,size*3,size*1.5);
			e3 = new Ellipse2D.Double(x+size*2.9,y+size*.3,size*2.1,size);
			g2d.setColor(color);
			g2d.fill(e1);
			g2d.fill(e2);
			g2d.fill(e3);
		}
		else if(cloudNumber == 2){
			e1 = new Ellipse2D.Double(x,y+size*.7,size*1.75,size);
			e2 = new Ellipse2D.Double(x+size*.6,y,size*3,size*1.7);
			e3 = new Ellipse2D.Double(x+size*2.6,y+size*.7,size*2,size);
			e4 = new Ellipse2D.Double(x+size*3.8,y+size*1.2,size*1.5,size*.5);
			g2d.setColor(color);
			g2d.fill(e1);
			g2d.fill(e2);
			g2d.fill(e3);
			g2d.fill(e4);
		}
	}
	
	/**
		The cloud's x value increases by 4. 
		This is repeatedly called using a timer in order to animate the cloud.
		If the cloud hits the edge of the canvas, it is regenerated at the opposite edge.
	**/
	public void flow() {
		x -= 4;
		
		if (x < -200) {
			cloudNumber = (int)(Math.random()*3);
			
			if( fog )
				size = (50+(int)(Math.random()*30));
			else 
				size = (20+(int)(Math.random()*30));
			
			x = 850;
		}
	}


}