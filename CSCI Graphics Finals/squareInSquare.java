import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.font.*;

public class squareInSquare extends DrawingObject{
	private double x, y;

	private Square inner, outer;

	public squareInSquare(double x, double y){
		this.x = x;
		this.y = y;
		
		//outer = new Square(x+25, y+25, 50, Color.GREEN);
	}

	public void draw(Graphics2D g2d){
		outer = new Square(x, y, 100, Color.YELLOW);
		inner = new Square(x+25, y+25, 50, Color.GREEN);
		
		outer.draw(g2d);
		inner.draw(g2d);
	}

	public void moveLeft(){
		x -= 5;
	}
	public void moveRight(){
		x += 5;
	}
	public double giveX(){
		System.out.println("THE RETURNED  X IS " + x);
		return x;
	}	

}