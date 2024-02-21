import javax.swing.*;

public class SceneStarter {
	public static void main(String[] args){
		int w = 800;
		int h = 600;
		JFrame f = new JFrame();
		SceneCanvas sc = new SceneCanvas(w,h);
		f.setSize(w,h);
		f.setTitle("Drawing in Java");
		f.add(sc);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}