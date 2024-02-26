import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import java.util.*;
import java.awt.font.*;

public class SceneCanvas extends JComponent{
	private int width;
	private int height;
	private Bamboo b1;
	private MountainScene ms;
	private TownScene ts;

	public SceneCanvas(){
		b1 = new Bamboo(100, 0, 100);
	}

	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON
		);
		
		g2d.setRenderingHints(rh);
		

		System.out.println("THIS WORKS HERE");
		System.out.println("PRINT DUCKY HERE");

		ms = new MountainScene();
		ts = new TownScene();

		//ms.draw(g2d);
		ts.draw(g2d);

		Path2D.Double lantern = new Path2D.Double();
		lantern.moveTo(60, 0);
		lantern.lineTo(90, 0);
		lantern.lineTo(105, 25);
		lantern.lineTo(85, 70);
		lantern.lineTo(65, 70);
		lantern.lineTo(45, 25);
		lantern.closePath();
		

		Point2D start = new Point2D.Float(75, 0);
		Point2D end = new Point2D.Float(75, 70);
		float[] dist = {0.0f, 0.4f, 1.0f};
		Color[] colors = {new Color(255, 192, 31), new Color(255, 224,143), Color.WHITE};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(lantern);
		g2d.setColor(Color.BLACK);
		//g2d.draw(lantern);

		Point2D loc = new Point2D.Float(60, 40);
		Font font = new Font ("TimesRoman", Font.BOLD, 30);
		FontRenderContext frc = g2d.getFontRenderContext();
		TextLayout layout = new TextLayout("嘎", font, frc);
		g2d.setColor(new Color(144, 35, 35));
		layout.draw(g2d, (float)loc.getX(), (float)loc.getY());


		Line2D.Double vertMiddle = new Line2D.Double(400, 0, 400, 600);
		Line2D.Double horiMiddle = new Line2D.Double(0, 300, 800, 300);
		g2d.setColor(Color.RED);
		g2d.draw(horiMiddle);
		g2d.draw(vertMiddle);

	}
}
