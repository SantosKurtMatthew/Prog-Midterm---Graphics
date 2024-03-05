/**
The SceneFrame class implements the KeyListener interface to allow inputs using the keyboard and.
It creates the JFrame and adds all the necessary components, such as the SceneCanvas object and plays sounds for specific actions.


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
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SceneFrame implements KeyListener{
	private JFrame frame;
	private SceneCanvas sc;
	private File file;
	private Clip clip;
	/**
		Constructor takes the arguments and initializes the values and adds the KeyListeners
	**/ 
	public SceneFrame(){
		frame = new JFrame();
		sc = new SceneCanvas();	
		frame.addKeyListener(this);
	}

	/**
		The SceneCanvas is put into the GUI and the other settings of the GUI are set, such as the title.
		It also prints the keybinds into the console.
		The size is created using the pack() method.
	**/ 
	public void setUpGUI(){
		frame.add(sc);
		frame.setTitle("Midterm Project - Pararuan - Santos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		System.out.print("The keybinds are as follows:\na - move left\nd - move right\nw - move up\ns - move down\n1 - change the duck's eyes\n2 - enable or disable his goggles\n3 - enable or disable his hat\n4 - enable or disable his lifesaver");
	}

	/**
		A part of the KeyListener interface for when a key is typed.
		@param e the KeyEvent 
	**/ 
	@Override
	public void keyTyped(KeyEvent e){
	}

	/**
		A part of the Keylistener interface for when a key is pressed.
		The Keybinds are set to move the duck object around the canvas and to enable/disable his clothes. 
		The keybinds are as follows:
			a - move left
			d - move right
			w - move up
			s - move down
			1 - change the duck's eyes
			2 - enable or disable his goggles
			3 - enable or disable his hat
			4 - enable or disable his lifesaver
		If the duck moves beyond the left of the canvas, he is transported to the next background by calling the changeBackground() method of the SceneCanvas.
		Otherwise, he is transported to the other edge; if he moves beyond the topmost of the canvas, he is looped back to the bottom of the canvas.
		The duck also quacks if he moves. 
		KeyListener tutorial: https://www.youtube.com/watch?v=BJ7fr9XwS2o
		Sounds tutorial: https://www.youtube.com/watch?v=SyZQVJiARTQ 
		Quack Sound: https://www.myinstants.com/en/instant/quackmp3/
		@param e the KeyEvent 
	**/ 
	@Override
	public void keyPressed(KeyEvent e){
		boolean fileFound = true;
		do {
			try{
				file = new File("quack.wav");
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
			}
			catch( UnsupportedOperationException f){
				fileFound = false;
				System.out.println("UnsupportedOperationException");
			}
			catch( LineUnavailableException g){
				fileFound = false;
				System.out.println("LineUnavailableException");
			}
			catch( UnsupportedAudioFileException h){
				fileFound = false;
				System.out.println("UnsupportedAudioFileException");
			}
			catch( IOException i){
				fileFound = false;
				System.out.println("IOException");
			}
		} while(!fileFound);
		
		Ducky d = sc.getDucky();

		switch(e.getKeyCode()){
		case 65:
			d.moveLeft();
			d.waddle(clip);
			break;
		case 68:

			d.moveRight();
			d.waddle(clip);
			break;
		case 83:
			d.moveDown();
			d.waddle(clip);
			break;
		case 87:
			d.moveUp();
			d.waddle(clip);
			break;	
		case 49:
			d.swapEyes();	
			break;
		case 50:
			d.swapGoggles();
			break;
		case 51:
			d.swapHat();
			break;
		case 52: 
			d.swapSalbabida();
			break;
		}
		if(d.giveX() < -460){
			sc.changeBackground(2220, true);
		}
		else if(d.giveX() > 2520){

			sc.changeBackground(-140, false);
		}
		else if(d.giveY() > 1940){
			d.spawnAt(d.giveX(), -40);
		}
		else if(d.giveY() < -480){
			d.spawnAt(d.giveX(), 1520);
		}
		sc.repaint();
	}

	/**
		A part of the KeyListener interface for when a key is released.
		@param e the KeyEvent 
	**/ 
	@Override
	public void keyReleased(KeyEvent e){
	}

}