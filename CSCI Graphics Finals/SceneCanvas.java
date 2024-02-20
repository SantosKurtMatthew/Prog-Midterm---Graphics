import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
	private int width;
	private int height;

	public DrawingCanvas(int w, int h){
		width = w;
		height = h;
	}

	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON
		);
		
		g2d.setRenderingHints(rh);
		
		System.out.println("THIS WORKS");
		System.out.println("PRINT DUCKY HERE");

		Path2D.Double torso = new Path2D.Double();
		torso.moveTo(230, 235);
		torso.curveTo(190, 400, 350, 500, 420, 290);
		torso.curveTo(375, 325, 325, 300, 320, 235);
		g2d.setColor(new Color(247, 245, 218));
		g2d.fill(torso);
		g2d.setColor(Color.BLACK);
		g2d.draw(torso);

		
		Ellipse2D.Double head = new Ellipse2D.Double(200, 100, 150, 150); //(200-350, 100-250)
		Path2D.Double ahoge = new Path2D.Double();
		ahoge.moveTo(245, 110);
		ahoge.curveTo(245, 60, 272, 80, 275, 90); // Left Curve (245-275, 110-90)
		ahoge.curveTo(300, 90, 305, 85, 305, 110); // Right Curve (275-305, 90-110)
		//It is like this to prevent weird textures/overlapping cause the fill covers the draw
		g2d.setColor(Color.YELLOW);
		g2d.setColor(new Color(247, 245, 218));
		g2d.fill(ahoge);
		g2d.setColor(Color.BLACK);
		g2d.draw(ahoge);
		g2d.setColor(Color.YELLOW);
		g2d.setColor(new Color(247, 245, 218));
		g2d.fill(head);
		g2d.setColor(Color.BLACK);
		g2d.draw(head);

		Ellipse2D.Double leftEye = new Ellipse2D.Double(210, 152, 18, 23);
		Ellipse2D.Double rightEye = new Ellipse2D.Double(265, 160, 20, 25);

		g2d.setColor(Color.BLACK);
		g2d.fill(leftEye);
		g2d.fill(rightEye);

		Path2D.Double goggle = new Path2D.Double();
		goggle.moveTo(205,150);
		goggle.curveTo(245,120,290,145,300,170); //Top Curve (205-300, 150-170)
		goggle.curveTo(310, 185, 295, 210, 280, 200); //Right Curve (310-280, 170-200)
		goggle.curveTo(264, 180, 231, 175, 225, 180); //Bottom Curve (290-225, 200-180)
		goggle.curveTo(210, 180, 195, 210, 205, 150); //Left Curve (225-205, 180-150)

		g2d.setColor(new Color(119, 209, 242, 120));
		g2d.fill(goggle);
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.BLACK);
		g2d.draw(goggle);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.YELLOW);
		g2d.draw(goggle);

		Path2D.Double bill = new Path2D.Double();
		bill.moveTo(265, 190);
		bill.lineTo(245, 210);
		bill.curveTo(250, 235, 175, 215, 190, 200);
		bill.lineTo(230,180);
		bill.curveTo(240, 175, 245, 180, 265,190);
		
		g2d.setStroke(new BasicStroke(1));
		
		g2d.setColor(Color.ORANGE);
		g2d.fill(bill);
		g2d.setColor(Color.BLACK);
		g2d.draw(bill);

		g2d.setColor(Color.BLACK);
		g2d.rotate(Math.toRadians(45),245,190);
		g2d.fill(new Ellipse2D.Double(245, 190, 2, 5));
		g2d.fill(new Ellipse2D.Double(235, 195, 2, 5));

		g2d.rotate(Math.toRadians(-45),245,190);

		

	}
}
