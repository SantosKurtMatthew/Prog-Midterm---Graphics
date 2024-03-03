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
	private Cloud c1, c2, c3, c4, f1, f2, f3, f4, f5, f6;
	ArrayList <DrawingObject> mountains;

	private RedGate rg;
	private Lantern l1, l2, l3, l4, l5;
	private Star s1, s2;
	private Moon moon;
	ArrayList <DrawingObject> town;

	private Ducky d1;
	private int backgroundNumber;
	
	
	javax.swing.Timer timer;
	private int stateCounter;


	public SceneCanvas(){
		setPreferredSize(new Dimension(800,600));
		stateCounter = 0;
		timer = new javax.swing.Timer(50, this);
		timer.start();
		m = new Mountain();
		c1 = new Cloud(-100,0,(20+(int)(Math.random()*30)),Color.WHITE);
		c2 = new Cloud(-300,100,(20+(int)(Math.random()*30)),Color.WHITE);
		c3 = new Cloud(-500,25,(20+(int)(Math.random()*30)),Color.WHITE);
		c4 = new Cloud(-700,0,(20+(int)(Math.random()*30)),Color.WHITE);
		f1 = new Cloud(-100,400,(50+(int)(Math.random()*30)),new Color(255,255,255,100));
		f2 = new Cloud(-200,500,(50+(int)(Math.random()*30)),new Color(255,255,255,100));
		f3 = new Cloud(-400,450,(50+(int)(Math.random()*30)),new Color(255,255,255,100));
		f4 = new Cloud(-500,400,(50+(int)(Math.random()*30)),new Color(255,255,255,100));
		f5 = new Cloud(-600,500,(50+(int)(Math.random()*30)),new Color(255,255,255,100));
		f6 = new Cloud(-700,450,(50+(int)(Math.random()*30)),new Color(255,255,255,100));
		mountains = new ArrayList<DrawingObject>();
		mountains.add(m);
		mountains.add(c1);
		mountains.add(c2);
		mountains.add(c3);
		mountains.add(c4);
		mountains.add(f1);
		mountains.add(f2);
		mountains.add(f3);
		mountains.add(f4);
		mountains.add(f5);
		mountains.add(f6);
		
		rg = new RedGate();
		l1 = new Lantern(-10, 50);
		l2 = new Lantern(-100, 25);
		l3 = new Lantern(-200, 75);
		l4 = new Lantern(-325, 150);
		l5 = new Lantern(-400, 90);
		s1 = new Star(350, 15, 2, 1);
		s2 = new Star(425, 100, 1, 2);
		moon = new Moon();

		town = new ArrayList<DrawingObject>();
		town.add(rg);
		town.add(l1);
		town.add(l2);
		town.add(l3);
		town.add(l4);
		town.add(l5);
		town.add(s1);
		town.add(s2);
		town.add(moon);


		d1 = new Ducky(100, 100);
		backgroundNumber = 1;
		

	}

	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON
		);
		
		g2d.setRenderingHints(rh);
		
		if(backgroundNumber == 0){
			for(int i = 0; i<mountains.size(); i++){
				mountains.get(i).draw(g2d);
			}	
		}
		else if(backgroundNumber == 1){
			for(int i = 0; i<town.size(); i++){
				town.get(i).draw(g2d);
			}	
		}
		d1.draw(g2d);

	}


	public void actionPerformed(ActionEvent ae){
		stateCounter++;
		if(backgroundNumber == 0){
			c1.flow();
			c2.flow();
			c3.flow();
			c4.flow();
			
			f1.flow();
			f2.flow();
			f3.flow();
			f4.flow();
			f5.flow();
			f6.flow();
		}
		else if(backgroundNumber == 1){
			l1.flow();
			l2.flow();
			l3.flow();
			l4.flow();
			l5.flow();

			s1.glowFlow(stateCounter);
			s2.glowFlow(stateCounter);

			moon.glowFlow(stateCounter);
		}
		repaint();
	}
	
	public void changeBackground(double spawnX){
		if (backgroundNumber == 0){
			backgroundNumber = 1;
			d1.spawnAt(spawnX, d1.giveY());
			repaint();
		}
		else if(backgroundNumber == 1){
			backgroundNumber = 0;
			d1.spawnAt(spawnX, d1.giveY());
			repaint();
		}
	}

	public Ducky getDucky(){
		return d1;
	}
}
