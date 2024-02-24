import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
	private int width;
	private int height;
	private Bamboo b1;




	public SceneCanvas(int w, int h){
		width = w;
		height = h;
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

		Mountain m1 = new Mountain();
		m1.draw(g2d);

		Line2D.Double vertMiddle = new Line2D.Double(400, 0, 400, 600);
		Line2D.Double vertMiddle2 = new Line2D.Double(600, 0, 600, 600);
		Line2D.Double horiMiddle = new Line2D.Double(0, 300, 800, 300);
		g2d.setColor(Color.RED);
		g2d.draw(horiMiddle);
		g2d.draw(vertMiddle);
		g2d.draw(vertMiddle2);

	}
}
