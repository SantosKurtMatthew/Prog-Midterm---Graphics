import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import java.util.*;
import java.awt.font.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.*;

//Timer tutorial https://www.youtube.com/watch?v=tHNWIWxRDDA&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=73
public class SceneCanvas extends JComponent implements ActionListener{
	private int width;
	private int height;
	private Mountain m;
	ArrayList <DrawingObject> mountains;

	private RedGate rg;
	private Lantern l1, l2, l3, l4, l5;
	ArrayList <DrawingObject> town;

	private Ducky d1;
	private int stateCounter;

	javax.swing.Timer timer;

	public SceneCanvas(){
		timer = new javax.swing.Timer(250, this);
		timer.start();
		stateCounter = 0;

		m = new Mountain();
		mountains = new ArrayList<DrawingObject>();
		mountains.add(m);

		rg = new RedGate();
		l1 = new Lantern(200, 25);
		l2 = new Lantern(10, 50);
		l3 = new Lantern(250, 60);
		l4 = new Lantern(140, 90);
		l5 = new Lantern(50, 140);

		town = new ArrayList<DrawingObject>();
		town.add(rg);
		town.add(l1);
		town.add(l2);
		town.add(l3);
		town.add(l4);
		town.add(l5);

		d1 = new Ducky();
	}

	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON
		);
		
		g2d.setRenderingHints(rh);

		
		

		for(int i = 0; i<town.size(); i++){
			//mountains.get(i).draw(g2d);
			town.get(i).draw(g2d);
		}
		d1.draw(g2d);


		Line2D.Double vertMiddle = new Line2D.Double(400, 0, 400, 600);
		Line2D.Double horiMiddle = new Line2D.Double(0, 300, 800, 300);
		g2d.setColor(Color.RED);
		g2d.draw(horiMiddle);
		g2d.draw(vertMiddle);

	}

	public void actionPerformed(ActionEvent ae){
		l1.flow();
		l2.flow();
		l3.flow();
		l4.flow();
		l5.flow();

		if (stateCounter%2 == 0){
			d1.rotateRight();
			System.out.println(stateCounter/2);
		}
		else{
			d1.rotateLeft();
			System.out.println(stateCounter);
		}
		stateCounter++;
		repaint();
		
	}
	public Lantern getLantern(){
		return l1;
	}
}
