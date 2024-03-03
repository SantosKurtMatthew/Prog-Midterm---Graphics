import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//KeyListener tutorial https://www.youtube.com/watch?v=BJ7fr9XwS2o
public class SceneFrame implements KeyListener{
	private JFrame frame;
	private SceneCanvas sc;

	public SceneFrame(){
		frame = new JFrame();
		sc = new SceneCanvas();	
		frame.addKeyListener(this);
	}

	public void setUpGUI(){
		frame.add(sc);

		frame.setTitle("Midterm Project - Pararuan - Santos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}





	@Override
	public void keyTyped(KeyEvent e){
	}
	@Override
	public void keyPressed(KeyEvent e){
		Ducky d = sc.getDucky();

		switch(e.getKeyCode()){
		case 65:
			d.moveLeft();
			d.waddle();

			System.out.println(d.giveX());
			System.out.println("THIS IS HELD: "+ e.getKeyCode());
			break;
		case 68:
			d.moveRight();
			d.waddle();

			System.out.println(d.giveX());
			System.out.println("THIS IS HELD: "+ e.getKeyCode());
			break;
		case 83:
			d.moveDown();
			d.waddle();

			System.out.println(d.giveX());
			System.out.println("THIS IS HELD: "+ e.getKeyCode());
			break;
		case 87:
			d.moveUp();
			d.waddle();

			System.out.println(d.giveX());
			System.out.println("THIS IS HELD: "+ e.getKeyCode());
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
			sc.changeBackground(2210);
		}
		else if(d.giveX() > 2520){
			sc.changeBackground(-140);
		}
		sc.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e){
		System.out.println("THIS IS RELEASED: "+ e.getKeyCode());
	}

}