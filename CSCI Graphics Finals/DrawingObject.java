import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public abstract class DrawingObject{
	Graphics g;
	Graphics2D g2d = (Graphics2D) g;

	public abstract void draw(Graphics2D g2d);
}