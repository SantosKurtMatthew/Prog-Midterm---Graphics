import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class MountainScene extends DrawingObject{
	private Mountain m;

	public MountainScene(){
		m = new Mountain();
	}

	public void draw(Graphics2D g2d){


		m.draw(g2d);

	}


}