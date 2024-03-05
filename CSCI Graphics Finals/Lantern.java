/**
The Lantern class extends the DrawingObject abstract class.
It draws a lantern with a gradient background and a text in the center.
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
import javax.swing.*;
import java.awt.font.*;

public class Lantern extends DrawingObject{
	private float x;
	private float y;
	private float xOriginal;
	private float yOriginal;
	private float newBaseY;
	private boolean up;

	/**
		The constructor initializes the values. The size of the lantern is constant.
		@param x the starting x value of the lantern
		@param y the starting y value of the lantern
	**/
	public Lantern(float x){
		this.x = x;
		y = (int)(10+Math.random()*200);
		yOriginal = y;
		xOriginal = x;
		newBaseY = y;
		
		if( (int)(Math.random()*2) == 0 )
			up = false;
		else
			up = true;
	}
	
	/**
		The lantern is drawn using a Path2D object.
		It is filled using the LinearGradientPaint object.
		The text is drawn using the TextLayout object.
		@param g2d the Graphics2D object
	**/
	public void draw(Graphics2D g2d){
		//One Lantern is 60 pixels wide and 70 pixels tall
		Path2D.Double l = new Path2D.Double();
		l.moveTo(x+15, y);
		l.lineTo(x+45, y);
		l.lineTo(x+60, y+25);
		l.lineTo(x+40, y+70);
		l.lineTo(x+20, y+70);
		l.lineTo(x, y+25);
		l.closePath();

		Point2D start = new Point2D.Float(x+75, y);
		Point2D end = new Point2D.Float(x+75, y+70);
		float[] dist = {0.0f, 0.4f, 1.0f};
		Color[] colors = {new Color(255, 192, 31), new Color(255, 224,143), Color.WHITE};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(l);

		Point2D loc = new Point2D.Float(x+15, y+40);
		Font font = new Font ("TimesRoman", Font.BOLD, 30);
		FontRenderContext frc = g2d.getFontRenderContext();
		TextLayout layout = new TextLayout("嘎", font, frc);
		g2d.setColor(new Color(144, 35, 35, 100));
		layout.draw(g2d, (float)loc.getX(), (float)loc.getY());
	}

	public void flow(int stateCounter) {
		
		if( x >= 800 || y < 0 ){
			x = -10;
			y = yOriginal;
			newBaseY = y;
			up = false;
		}
		
		x++;
		if(up){
			y-=0.5;
		}
		else{
			y += 0.5;
		}
		
		if (up == false && stateCounter % 10 == 0){
			up = true;
		}
		else if (up == true && stateCounter % 10 == 0){
			up = false;
		}
		
			
	}
}