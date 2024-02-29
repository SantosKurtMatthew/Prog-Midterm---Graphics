import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.font.*;

public class RedGate extends DrawingObject{
	class Shingle extends DrawingObject{
		private double x;
		private double y;
		private Color color;

		public Shingle(double x, double y, Color color){
			this.x = x;
			this.y = y;
			this.color = color;
		}	

		public void draw(Graphics2D g2d){
			Rectangle2D.Double body = new Rectangle2D.Double(x, y, 20, 80);
			Ellipse2D.Double roundcap = new Ellipse2D.Double(x, y+70, 20, 20);
			g2d.setColor(color);
			g2d.fill(body);
			g2d.fill(roundcap);
		}

	}
	public RedGate(){

	}

	public void draw(Graphics2D g2d){
		Rectangle2D.Double background = new Rectangle2D.Double(0,0,800,600);
		Point2D start = new Point2D.Float(400, 0);
		Point2D end = new Point2D.Float(400, 600);
		float[] dist = {0.0f, 1.0f};
		Color[] colors = {Color.BLACK, new Color(6, 40, 96)};	
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fill(background);

		Circle moonInner = new Circle(650, 50, 90, new Color(231, 230, 230));
		Circle moonOuter = new Circle(650, 50, 100, new Color(136, 136, 136));
		moonOuter.draw(g2d);
		moonInner.draw(g2d);

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

		g2d.setColor(new Color(86, 16, 16)); //Dark Red Color 
		g2d.fill(mainPillarLeft);
		g2d.fill(mainPillarRight);
		g2d.fill(leftPillar);
		g2d.fill(rightPillar);

		Rectangle2D.Double goldLiningMain = new Rectangle2D.Double(200, 240, 400, 10);
		Ellipse2D.Double goldCapLeft = new Ellipse2D.Double(190, 235, 15, 15);
		Ellipse2D.Double goldCapRight = new Ellipse2D.Double(595, 235, 15, 15);

		Rectangle2D.Double goldLiningLeft = new Rectangle2D.Double(50, 365, 150, 10);
		Ellipse2D.Double goldCapLeftLeft = new Ellipse2D.Double(40, 360, 15, 15);

		Rectangle2D.Double goldLiningRight = new Rectangle2D.Double(600, 365, 150, 10);
		Ellipse2D.Double goldCapRightRight = new Ellipse2D.Double(745, 360, 15, 15);

		g2d.setColor(new Color(255, 192, 31)); //Yellowish Gold Color
		g2d.fill(goldLiningMain);
		g2d.fill(goldCapLeft);
		g2d.fill(goldCapRight);

		g2d.fill(goldLiningLeft);
		g2d.fill(goldCapLeftLeft);

		g2d.fill(goldLiningRight);
		g2d.fill(goldCapRightRight);


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