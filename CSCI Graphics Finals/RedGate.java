/**
The RedGate class extends the DrawingObject abstract class.
It draws a red gate using a variety of classes, including the Shingle inner class.
It makes use of LinearGradientPaint and TextLayout objects as well.

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

public class RedGate extends DrawingObject{

	/**
		The Shingle class extends the DrawingObject abstract class.
		It uses a Rectangle2D and Ellipse2D object in order to make a single shingle.
	**/
	class Shingle extends DrawingObject{
		private double x;
		private double y;
		private Color color;

		/**
			The constructor initializes the values
			@param x the x value of the top left of the rectangle
			@param y the y value of the top left of the rectangle
			@param color the color of the shingle
		**/
		public Shingle(double x, double y, Color color){
			this.x = x;
			this.y = y;
			this.color = color;
		}	

		/**	
			The shingle is drawn. The Ellipse is put at the bottom of the Rectangle.
			@param g2d The Graphics2D object
		**/
		public void draw(Graphics2D g2d){
			Rectangle2D.Double body = new Rectangle2D.Double(x, y, 20, 80);
			Ellipse2D.Double roundcap = new Ellipse2D.Double(x, y+70, 20, 20);
			g2d.setColor(color);
			g2d.fill(body);
			g2d.fill(roundcap);
		}

	}

	// The constructor does not have to initalize any values for the RedGate object itself.
	public RedGate(){
	}

	/**
		The background is drawn using a Rectangle2D and the LinearGradientPaint object.
		It draws a gate using Trapezoid, Rectangle2D and the Shingle inner class. 
		The yellow lining is drawn using Lines and Circles.
		The text on the gate is drawn using the TextLayout object.
		Source: https://docs.oracle.com/javase/8/docs/api/java/awt/font/TextLayout.html#:~:text=TextLayout%20objects%20are%20constructed%20from,do%20not%20affect%20the%20TextLayout%20.
	**/
	public void draw(Graphics2D g2d){
		Rectangle2D.Double background = new Rectangle2D.Double(0,0,800,600);
		Point2D start = new Point2D.Float(400, 0);
		Point2D end = new Point2D.Float(400, 600);
		float[] dist = {0.0f, 1.0f};
		Color[] colors = {Color.BLACK, new Color(6, 40, 96)};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(background);

		Color goldColor = new Color(255, 192, 31);
		Line goldLiningMain = new Line(200, 245, 600, 245, 10, goldColor);
		Circle goldCapLeft = new Circle(190, 235, 15, goldColor);
		Circle goldCapRight = new Circle(595, 235, 15, goldColor);

		goldLiningMain.draw(g2d);
		goldCapLeft.draw(g2d);
		goldCapRight.draw(g2d);

		Line goldLiningLeft = new Line(50, 370, 200, 370, 10, goldColor);
		Circle goldCapLeftLeft = new Circle(40, 360, 15, goldColor);
		goldLiningLeft.draw(g2d);
		goldCapLeftLeft.draw(g2d);

		Line goldLiningRight = new Line(600, 370, 750, 370, 10, goldColor);
		Circle goldCapRightRight = new Circle(745, 360, 15, goldColor);
		goldLiningRight.draw(g2d);
		goldCapRightRight.draw(g2d);

		Trapezoid mainGate = new Trapezoid(150, 250, 500, 100, new Color(144, 35, 35));
		mainGate.draw(g2d);
		Trapezoid leftGate = new Trapezoid(0, 375, 250, 100, new Color(144, 35, 35));
		leftGate.draw(g2d);
		Trapezoid rightGate = new Trapezoid(550, 375, 250, 100, new Color(144, 35, 35));
		rightGate.draw(g2d);

		Rectangle2D.Double mainPillarLeft = new Rectangle2D.Double(200, 350, 50, 250);		
		Rectangle2D.Double mainPillarRight = new Rectangle2D.Double(550, 350, 50, 250);
		Rectangle2D.Double leftPillar = new Rectangle2D.Double(50, 475, 50, 125);
		Rectangle2D.Double rightPillar = new Rectangle2D.Double(700, 475, 50, 125);

		Square leftPillarLeftBox = new Square(190, 590, 10, new Color(86, 16, 16));
		Square leftPillarRightBox = new Square(250, 590, 10, new Color(86, 16, 16));
		leftPillarLeftBox.draw(g2d);
		leftPillarRightBox.draw(g2d);
		Square rightPillarLeftBox = new Square(540, 590, 10, new Color(86, 16, 16));
		Square rightPillarRightBox = new Square(600, 590, 10, new Color(86, 16, 16));
		rightPillarLeftBox.draw(g2d);
		rightPillarRightBox.draw(g2d);

		g2d.setColor(new Color(86, 16, 16)); //Dark Red Color 
		g2d.fill(mainPillarLeft);
		g2d.fill(mainPillarRight);
		g2d.fill(leftPillar);
		g2d.fill(rightPillar);

		for (int i = 200; i<580; i += 27.14){
			Shingle s = new Shingle(i, 250, new Color(227, 77, 77));
			s.draw(g2d);	
		}
		for (int i = 50; i<200; i += 25){
			Shingle s = new Shingle(i, 375, new Color(227, 77, 77));
			s.draw(g2d);	
		}
		for (int i = 605; i<750; i += 25){
			Shingle s = new Shingle(i, 375, new Color(227, 77, 77));
			s.draw(g2d);	
		}

		Rectangle2D.Double gateWireTop = new Rectangle2D.Double(250, 365, 300, 10);
		Rectangle2D.Double gateWireBottom = new Rectangle2D.Double(250, 425, 300, 10);
		Rectangle2D.Double gateTextFrame = new Rectangle2D.Double(300, 375, 200, 50);
		g2d.setColor(new Color(255, 192, 31)); //Yellowish Gold Color
		g2d.fill(gateTextFrame);

		g2d.setColor(new Color(86, 16, 16)); //Dark Red Color 
		g2d.fill(gateWireTop);
		g2d.fill(gateWireBottom);

		Point2D loc = new Point2D.Float(325, 410);
		Font font = new Font ("TimesRoman", Font.BOLD, 30);
		FontRenderContext frc = g2d.getFontRenderContext();
		TextLayout layout = new TextLayout("鸭 子 之 地", font, frc);
		layout.draw(g2d, (float)loc.getX(), (float)loc.getY());
		
	}
}