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
		
		sc.setPreferredSize(new Dimension(800,600));
		frame.add(sc);

		frame.setTitle("Midterm Project - Pararuan - Santos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent ae){
		System.out.println("SOMETHING HAPPENED 0");
		sc.repaint();
	}
	@Override
	public void keyTyped(KeyEvent e){
	}
	@Override
	public void keyPressed(KeyEvent e){
		Lantern s = sc.getLantern();
		switch(e.getKeyChar()){
		case'a':
			sc.repaint();

			System.out.println(s.giveX());
			System.out.println("THIS IS HELD: "+ e.getKeyCode());
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e){
		System.out.println("THIS IS RELEASED: "+ e.getKeyCode());
	}
	



}