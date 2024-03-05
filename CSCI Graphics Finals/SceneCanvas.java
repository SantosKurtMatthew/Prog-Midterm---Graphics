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

	private Ducky d1;
	private Sign mSignLeft, mSignRight, rgSignLeft, rgSignRight, fSignLeft, fSignRight; 

	private Mountain m;
	private Cloud c1, c2, c3, c4, f1, f2, f3, f4, f5, f6;
	ArrayList <DrawingObject> mountains;

	private RedGate rg;
	private Lantern l1, l2, l3, l4, l5, l6;
	private Star star1, star2, star3;

	private Moon moon, sun;
	ArrayList <DrawingObject> town;
	
	
	private BambooFront bFront;
	private BambooBack bBack;
	private Rain rd1, rd2, rd3, rd4, rd5, rd6, rd7;
	ArrayList <DrawingObject> forest;
	
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
		mSignLeft = new Sign(85, 300, true, "Town", "<-");
		mSignRight = new Sign(560, 235, true, "Forest", "->");
		c1 = new Cloud(0,10, false);
		c2 = new Cloud(250,100, false);
		c3 = new Cloud(500,25, false);
		c4 = new Cloud(750,50, false);
		f1 = new Cloud(0,400, true);
		f2 = new Cloud(100,500, true);
		f3 = new Cloud(250,450, true);
		f4 = new Cloud(400,400, true);
		f5 = new Cloud(550,500, true);
		f6 = new Cloud(700,450, true);
		
		mountains = new ArrayList<DrawingObject>();
		mountains.add(m);
		mountains.add(sun);
		mountains.add(mSignLeft);
		mountains.add(mSignRight);
		mountains.add(d1);
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
		rgSignLeft = new Sign(-10, 525, true, "Forest", "<-");
		rgSignRight = new Sign(750, 525, true, "Mt.", "->");
		l1 = new Lantern(25);
		l2 = new Lantern(125);
		l3 = new Lantern(275);
		l4 = new Lantern(400);
		l5 = new Lantern(550);
		l6 = new Lantern(700);
		star1 = new Star(315, 25, 2, 1);
		star2 = new Star(415, 110, 1, 2);
		star3 = new Star(65, 250, 1, 2);
		moon = new Moon(new Color(231, 230, 230), new Color(136, 136, 136));

		town = new ArrayList<DrawingObject>();
		town.add(rg);
		town.add(rgSignLeft);
		town.add(rgSignRight);
		town.add(star1);
		town.add(star2);
		town.add(star3);
		town.add(moon);
		town.add(d1);
		town.add(l1);
		town.add(l2);
		town.add(l3);
		town.add(l4);
		town.add(l5);
		town.add(l6);
		
		bBack = new BambooBack();
		bFront = new BambooFront();
		rd1 = new Rain(100);
		rd2 = new Rain(200);
		rd3 = new Rain(305);
		rd4 = new Rain(400);
		rd5 = new Rain(500);
		rd6 = new Rain(605);
		rd7 = new Rain(705);
		forest = new ArrayList<DrawingObject>();
		fSignLeft = new Sign(-10, 455, false, "Mt.", "<-");
		fSignRight = new Sign(637, 355, false, "Town", "->");

		forest.add(bBack);
		forest.add(d1);
		forest.add(bFront);
		forest.add(fSignLeft);
		forest.add(fSignRight);
		forest.add(rd1);
		forest.add(rd2);
		forest.add(rd3);
		forest.add(rd4);
		forest.add(rd5);
		forest.add(rd6);
		forest.add(rd7);

		
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
			for(int i = 0; i<forest.size(); i++){
				forest.get(i).draw(g2d);
			}	
		}
		else if(backgroundNumber == 1){
			for(int i = 0; i<mountains.size(); i++){
				mountains.get(i).draw(g2d);
			}	
		}
		else if(backgroundNumber == 2){
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
		
		d1.levitate(stateCounter);
		
		if(backgroundNumber == 0){
			rd1.flow();
			rd2.flow();
			rd3.flow();
			rd4.flow();
			rd5.flow();
			rd6.flow();
			rd7.flow();
		}
		else if(backgroundNumber == 1){
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
		else if(backgroundNumber == 2){
			l1.flow(stateCounter);
			l2.flow(stateCounter);
			l3.flow(stateCounter);
			l4.flow(stateCounter);
			l5.flow(stateCounter);
			l6.flow(stateCounter);

			star1.glowFlow(stateCounter);
			star2.glowFlow(stateCounter);
			star3.glowFlow(stateCounter);

			moon.glowFlow(stateCounter);
		}
		
		repaint();
	}
	
	/**
		This changes the background by changing the backgroundNumber variable.
		@param spawnX the value of x where the duck should spawn in the next background
	**/ 
	public void changeBackground(double spawnX, boolean left){
		if (left == true){
			backgroundNumber++;
			if(backgroundNumber > 2){
				backgroundNumber = 0;
			}
		}
		else{
			backgroundNumber--;
			if(backgroundNumber < 0){
				backgroundNumber = 2;
			}
		}
		d1.spawnAt(spawnX, d1.giveY());
		repaint();
	}	

	/**
		Returns the Ducky object
		@return d1 the ducky object
	**/ 
	public Ducky getDucky(){
		return d1;
	}
}
