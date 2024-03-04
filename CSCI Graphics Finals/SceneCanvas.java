/**
The SceneCanvas class creates the canvas where all the DrawingObjects are drawn and added into respective arraylists for each scene.
It extends the JComponent class and implements the ActionListener interface in order to create a timer for automatic animation.
For this project, it contains two scenes: the Mountains and the Town.

@author Nicole (Coeli) Pararuan (234814) and Kurt Santos (235666)
@version March 6, 2024
**/

/*
I have not discussed the Java language code in my program
with anyone other than my instructor or the teaching assistants
assigned to this course.

I have not used Java language code obtained from another student,
or any other unauthorized source, either modified or unmodified.

If any Java language code or documentation used in my program
was obtained from another source, such as a textbook or website,
that has been clearly noted with a proper citation in the comments
of my program.
*/

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import java.util.*;
import java.awt.font.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.*;


public class SceneCanvas extends JComponent implements ActionListener{
	private int width;
	private int height;
	private Mountain m;
	private Sign sign1; 
	private Cloud c1, c2, c3, c4, f1, f2, f3, f4, f5, f6;
	ArrayList <DrawingObject> mountains;

	private RedGate rg;
	private Lantern l1, l2, l3, l4, l5;
	private Star star1, star2;

	private Moon moon, sun;
	ArrayList <DrawingObject> town;

	private Ducky d1;
	private int backgroundNumber;
	
	
	javax.swing.Timer timer;
	private int stateCounter;

	/**
		Constructor initializes the values of the objects and adds them to the respective arraylists for the scenes.
		The backgroundNumber variable is used to decide which scene to draw or which arraylist to iterate through.
		The timer is set to run every 0.05 seconds. The stateCounter variable is to slow down the animations that require it.
		Timer Source: https://www.youtube.com/watch?v=tHNWIWxRDDA&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=73
	**/ 
	public SceneCanvas(){
		setPreferredSize(new Dimension(800,600));
		stateCounter = 0;
		timer = new javax.swing.Timer(50, this);
		timer.start();
		d1 = new Ducky(100, 100);

		m = new Mountain();
		sun = new Moon(new Color(250, 220, 100), new Color(224, 168, 36));
		sign1 = new Sign(505, 135);
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
		mountains.add(sun);
		mountains.add(sign1);
		mountains.add(c1);
		mountains.add(c2);
		mountains.add(c3);
		mountains.add(c4);
		mountains.add(d1);
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
		star1 = new Star(350, 15, 2, 1);
		star2 = new Star(425, 100, 1, 2);
		moon = new Moon(new Color(231, 230, 230), new Color(136, 136, 136));

		town = new ArrayList<DrawingObject>();
		town.add(rg);
		town.add(l1);
		town.add(l2);
		town.add(l3);
		town.add(l4);
		town.add(l5);
		town.add(star1);
		town.add(star2);
		town.add(moon);
		town.add(d1);

		backgroundNumber = 0;
	}

	@Override
	/**
		This draws the objects using the Graphics2D object which was casted from a Graphics object.
		It iterates through an arraylist and prints each item for the respective scene.
		@param g the Graphics object to be casted into Graphics2D
	**/ 
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
		
	}

	/**
		This is for all of the automatic animations. It is reliant on the timer object.
		For the mountain scene, it animates the clouds and fog as well as the sun. 
		For the town scene, it animates the lanterns, the stars, and the moon.
		@param ae the ActionEvent object
	**/ 
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

			sun.glowFlow(stateCounter);
		}
		else if(backgroundNumber == 1){
			l1.flow();
			l2.flow();
			l3.flow();
			l4.flow();
			l5.flow();

			star1.glowFlow(stateCounter);
			star2.glowFlow(stateCounter);

			moon.glowFlow(stateCounter);
		}
		repaint();
	}
	
	/**
		This changes the background by changing the backgroundNumber variable.
		@param spawnX the value of x where the duck should spawn in the next background
	**/ 
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

	/**
		Returns the Ducky object
		@return d1 the ducky object
	**/ 
	public Ducky getDucky(){
		return d1;
	}
}
