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