/**
The BambooBack class extends the DrawingObject abstract class.
It creates the background for the forest scene by drawing multiple Rectangle2D objects.

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


public class BambooBack extends DrawingObject {
	private int x;
	
	/**
		The constructor does not have to initialize anything.
	**/
	public BambooBack() {
	}
	
	/**
		The BambooBackSegment class extends the DrawingObject abstract class.
		It creates a rectangle to be used in the BambooBack.
	**/
	class BambooBackSegment extends DrawingObject {
		
		private Rectangle2D.Double r1, r2, r3, r4, r5;
		
		/**
			The constructor initializes the variables
			@param x the x value of the segment
		**/
		public BambooBackSegment(int x) {
			r1 = new Rectangle.Double(x+10,-50,30,800);
			r2 = new Rectangle.Double(x+100,-50,30,800);
			r3 = new Rectangle.Double(x+200,-50,30,800);
			r4 = new Rectangle.Double(x+300,-50,30,800);
			r5 = new Rectangle.Double(x+350,-50,30,800);
		}

		/**
			The segments or the Rectangles are drawn, possibly with rotations.
			@param g2d the Graphics2D object
		**/
		public void draw(Graphics2D g2d){
			
			AffineTransform reset = g2d.getTransform();
			g2d.setColor(new Color(19, 38, 14, 100));
			
			g2d.rotate(Math.toRadians(-5),x+10,300);
			g2d.fill(r1);
			g2d.setTransform(reset);
			
			g2d.fill(r2);
			g2d.fill(r3);
			
			g2d.rotate(Math.toRadians(5),x+250,300);
			g2d.fill(r4);
			g2d.setTransform(reset);
			
			g2d.rotate(Math.toRadians(-15),x+300,300);		
			g2d.fill(r5);
			g2d.setTransform(reset);
		}
	}
	
	/**
		The background is drawn with a Rectangle2D and LinearGradientPaint.
		Two BambooBackSegment objects are drawn with different x values.
		@param g2d the Graphics2D object
	**/
	public void draw(Graphics2D g2d) {
		Rectangle2D.Double background = new Rectangle2D.Double(0,0,800,600);
		Point2D start = new Point2D.Float(400, 0);
		Point2D end = new Point2D.Float(400, 600);
		float[] dist = {0.0f, 1.0f};
		Color[] colors = {Color.BLACK, new Color(6, 40, 96)};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(background);
		
		BambooBackSegment bbs1 = new BambooBackSegment(0);
		BambooBackSegment bbs2 = new BambooBackSegment(390);
		bbs1.draw(g2d);
		bbs2.draw(g2d);
	}
	
}