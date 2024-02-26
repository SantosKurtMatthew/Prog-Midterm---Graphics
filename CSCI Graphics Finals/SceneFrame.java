import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SceneFrame{
	private JFrame frame;
	private SceneCanvas sc;

	public SceneFrame(){


		frame = new JFrame();
		sc = new SceneCanvas();
	}

	public void setUpGUI(){

		

		sc.setPreferredSize(new Dimension(800,600));
		frame.add(sc);
		frame.setTitle("Midterm Project - Pararuan - Santos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}