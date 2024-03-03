import java.awt.*;
import java.awt.geom.*;

public class Ducky extends DrawingObject{
	private Path2D.Double torso, hanfuInner, hanfuOuterLeft, hanfuOuterRight, hanfuRightSleeve, sleeveOutline, hanfuAccent, leftLeg, rightLeg, hanfuBelt, ahoge, happyEyes, goggle, bill, salbabida;
	private Ellipse2D.Double hanfuOuterBack, head, leftEye, rightEye;
	private Triangle hat;
	private int rotation;
	private double x, y;
	private boolean waddleState, slitEyes, enableGoggles, enableSalbabida, enableHat;


	public Ducky(double x, double y){
		this.x = x;
		this.y = y;
		rotation = 0;
		waddleState = false;
		slitEyes = false;
		enableGoggles = true;
		enableSalbabida = true;
		enableHat = true;
	}

	public void draw(Graphics2D g2d){
		g2d.scale(0.3, 0.3);
		hanfuOuterBack = new Ellipse2D.Double(x+233, y+330, 140, 100);
		torso = new Path2D.Double();
		hanfuInner = new Path2D.Double();
		hanfuOuterLeft = new Path2D.Double();
		hanfuOuterRight = new Path2D.Double();
		hanfuRightSleeve = new Path2D.Double(); 
		sleeveOutline = new Path2D.Double();
		hanfuAccent = new Path2D.Double(); 
		leftLeg = new Path2D.Double();
		rightLeg = new Path2D.Double();
		hanfuBelt = new Path2D.Double();
		head = new Ellipse2D.Double(x+200, y+100, 150, 150); //(200-350, 100-250)
		ahoge = new Path2D.Double();
		leftEye = new Ellipse2D.Double(x+208, y+155, 22, 22);
		rightEye = new Ellipse2D.Double(x+265, y+160, 24, 24);
		happyEyes = new Path2D.Double();
		goggle = new Path2D.Double();
		bill = new Path2D.Double();
		hat = new Triangle(x+275, y+50, x+160, y+140, x+390, y+140, Color.DARK_GRAY, "fill");
		salbabida = new Path2D.Double();
		

		AffineTransform absoluteReset = g2d.getTransform();

		g2d.rotate(Math.toRadians(rotation),x+275,y+400);
		
		AffineTransform reset = g2d.getTransform();
		
		g2d.setColor(Color.BLACK);
		g2d.fill(hanfuOuterBack);
		g2d.setStroke(new BasicStroke(8));
		g2d.setColor(Color.RED);
		g2d.draw(hanfuOuterBack);
		
		
		torso.moveTo(x+230, y+235);
		torso.curveTo(x+180, y+400, x+370, y+500, x+440, y+280); //lower curve
		torso.curveTo(x+375, y+325, x+325, y+300, x+320, y+235); //upper curve
		g2d.setColor(new Color(247, 245, 218));
		g2d.fill(torso);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.BLACK);
		g2d.draw(torso);

		//hanfu
		g2d.setStroke(new BasicStroke(1));

		hanfuInner.moveTo(x+230, y+245);
		hanfuInner.lineTo(x+270, y+280);
		hanfuInner.lineTo(x+320, y+240);
		hanfuInner.curveTo(x+325, y+300, x+375, y+315, x+410, y+295); //upper curve //tail tip 440, 280
		hanfuInner.lineTo(x+410, y+345);
		hanfuInner.curveTo(x+350, y+470, x+180, y+390, x+230, y+245); //lower curve
		//g2d.setColor(Color.BLACK);
		//g2d.draw(hanfuInner);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fill(hanfuInner);
		
		
		hanfuOuterLeft.moveTo(x+227, y+245);
		hanfuOuterLeft.curveTo(x+185, y+290, x+215, y+340, x+185, y+375); // left curve
		hanfuOuterLeft.curveTo(x+190, y+380, x+210, y+390, x+235, y+400); // bottom curve
		hanfuOuterLeft.moveTo(x+230, y+235);
		hanfuOuterLeft.curveTo(x+210, y+290, x+210, y+375, x+245, y+415); // middle curve
		hanfuOuterLeft.curveTo(x+235, y+375, x+235, y+290, x+240, y+243); // right curve
		hanfuOuterLeft.lineTo(x+230, y+235); // collar line
		g2d.setColor(Color.BLACK);
		g2d.fill(hanfuOuterLeft);
		g2d.setColor(Color.DARK_GRAY);
		g2d.draw(hanfuOuterLeft);
		
		
		
		hanfuOuterRight.moveTo(x+320, y+235);
		hanfuOuterRight.curveTo(x+320, y+235, x+310, y+245, x+300, y+245); // collar curve
		hanfuOuterRight.curveTo(x+300, y+420, x+360, y+425, x+400, y+425); // left curve
		hanfuOuterRight.curveTo(x+430, y+430, x+460, y+420, x+450, y+390); // bottom-right curve
		hanfuOuterRight.curveTo(x+435, y+360, x+450, y+320, x+410, y+295); // right-most curve
		hanfuOuterRight.curveTo(x+375, y+315, x+330, y+295, x+320, y+235); // back curve
		g2d.setColor(Color.BLACK);
		g2d.fill(hanfuOuterRight);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.DARK_GRAY);
		g2d.draw(hanfuOuterRight);
		
		
		
		hanfuRightSleeve.moveTo(x+320, y+240);
		hanfuRightSleeve.curveTo(x+360, y+260, x+390, y+360, x+400, y+360); // right curve
		hanfuRightSleeve.curveTo(x+390, y+380, x+380, y+395, x+365, y+410); // bottom right curve
		hanfuRightSleeve.curveTo(x+355, y+375, x+350, y+370, x+335, y+365); // bottom left curve
		hanfuRightSleeve.curveTo(x+330, y+335, x+320, y+280, x+310, y+255); // left curve
		hanfuRightSleeve.closePath();
		g2d.setColor(Color.BLACK);
		g2d.fill(hanfuRightSleeve);
		//g2d.setColor(Color.DARK_GRAY);
		//g2d.draw(hanfuRightSleeve);
		
		
		sleeveOutline.moveTo(x+320, y+240);
		sleeveOutline.curveTo(x+360, y+260, x+390, y+360, x+400, y+360); // right curve
		sleeveOutline.moveTo(x+365, y+410);
		sleeveOutline.curveTo(x+355, y+375, x+350, y+370, x+340, y+365); // bottom left curve
		sleeveOutline.curveTo(x+330, y+335, x+320, y+280, x+310, y+265); // left curve
		sleeveOutline.moveTo(x+325, y+310); // right sleeve line
		sleeveOutline.curveTo(x+320, y+285, x+325, y+250, x+346, y+265); 
		sleeveOutline.moveTo(x+218, y+285); // left sleeve line
		sleeveOutline.curveTo(x+215, y+270, x+210, y+270, x+209, y+275); 
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.DARK_GRAY);
		g2d.draw(sleeveOutline);
		
		 
		hanfuAccent.moveTo(x+185, y+375); //left
		hanfuAccent.curveTo(x+190, y+380, x+210, y+390, x+230, y+395);
		hanfuAccent.moveTo(x+245, y+412); //left
		hanfuAccent.curveTo(x+235, y+375, x+235, y+290, x+240, y+240);
		hanfuAccent.moveTo(x+300, y+245); //right
		hanfuAccent.curveTo(x+300, y+420, x+360, y+425, x+400, y+425); 
		hanfuAccent.curveTo(x+430, y+430, x+460, y+420, x+450, y+390);
		hanfuAccent.curveTo(x+435, y+360, x+450, y+320, x+410, y+295);
		hanfuAccent.moveTo(x+340, y+365); //right sleeve
		hanfuAccent.curveTo(x+345, y+350, x+375, y+350, x+400, y+360);
		hanfuAccent.curveTo(x+390, y+380, x+380, y+395, x+365, y+410);
		hanfuAccent.curveTo(x+365, y+390, x+370, y+390, x+375, y+375);
		hanfuAccent.curveTo(x+360, y+360, x+345, y+365, x+340, y+365);	
		hanfuAccent.moveTo(x+240, y+250); // collar
		hanfuAccent.lineTo(x+265, y+275);
		hanfuAccent.moveTo(x+300, y+250);
		hanfuAccent.lineTo(x+240, y+300);
		hanfuAccent.moveTo(x+240, y+320); // belt
		hanfuAccent.curveTo(x+260, y+330, x+290, y+330, x+303, y+315);
		hanfuAccent.moveTo(x+240, y+335);
		hanfuAccent.curveTo(x+260, y+350, x+290, y+350, x+305, y+335);
		BasicStroke accent = new BasicStroke(8.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND); //https://docs.oracle.com/javase/tutorial/2d/geometry/strokeandfill.html, http://www.java2s.com/Tutorials/Java/java.awt/BasicStroke/0060__BasicStroke.CAP_ROUND.htm
		g2d.setStroke(accent);
		g2d.setColor(Color.RED);
		g2d.draw(hanfuAccent);
		
		
		leftLeg.moveTo(x+270, y+390); 
		leftLeg.lineTo(x+270, y+430); // left line going down
		leftLeg.lineTo(x+250, y+435); // piatos 1
		leftLeg.lineTo(x+260, y+455); // piatos 2
		leftLeg.lineTo(x+285, y+450); // piatos 3
		leftLeg.lineTo(x+285, y+430); // piatos 4
		leftLeg.lineTo(x+285, y+390); // right line going up
		leftLeg.curveTo(x+280, y+385, x+275, y+385, x+270, y+390); // top curve going left
		rightLeg.moveTo(x+290, y+385);
		rightLeg.lineTo(x+290, y+435); // left line going down
		rightLeg.lineTo(x+270, y+440); // piatos 1
		rightLeg.lineTo(x+280, y+465); // piatos 2
		rightLeg.lineTo(x+315, y+460); // piatos 3
		rightLeg.lineTo(x+310, y+435); // piatos 4
		rightLeg.lineTo(x+310, y+385); // right line going up
		rightLeg.curveTo(x+305, y+380, x+295, y+380, x+290, y+385); // top curve going left
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.rotate(Math.toRadians(15), x+275, y+390);
		g2d.setColor(Color.ORANGE);
		g2d.fill(leftLeg);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(leftLeg);
		g2d.setTransform(reset);
		g2d.rotate(Math.toRadians(-15), x+275, y+390);
		g2d.translate(0, 5);
		g2d.setColor(Color.ORANGE);
		g2d.fill(rightLeg);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(rightLeg);
		g2d.setTransform(reset);
		
		 
		hanfuBelt.moveTo(x+245, y+330);
		hanfuBelt.curveTo(x+260, y+340, x+285, y+340, x+298, y+327);
		hanfuBelt.moveTo(x+260, y+335);
		hanfuBelt.lineTo(x+260, y+385);
		hanfuBelt.moveTo(x+280, y+335);
		hanfuBelt.lineTo(x+280, y+405);
		BasicStroke beltStroke = new BasicStroke(12.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2d.setStroke(beltStroke);
		g2d.setColor(Color.BLACK);
		g2d.draw(hanfuBelt);
		
		
		
		g2d.setStroke(new BasicStroke(3));
		
		
		// ducky head
		g2d.setStroke(new BasicStroke(1));
		g2d.rotate(Math.toRadians(15), x+275, y+175);
		ahoge.moveTo(x+245, y+110);
		ahoge.curveTo(x+245, y+60, x+272, y+80, x+275, y+90); // Left Curve (245-275, 110-90)
		ahoge.curveTo(x+290, y+85, x+305, y+85, x+305, y+110); // Right Curve (275-305, 90-110)
		//It is like this to prevent weird textures/overlapping cause the fill covers the draw
		g2d.setColor(Color.YELLOW);
		g2d.setColor(new Color(247, 245, 218));
		g2d.fill(ahoge);
		g2d.setColor(Color.BLACK);
		g2d.draw(ahoge);
		g2d.setColor(Color.YELLOW);
		g2d.setColor(new Color(247, 245, 218));
		g2d.fill(head);
		g2d.setColor(Color.BLACK);
		g2d.draw(head);
		
		
		if(slitEyes == false){
			g2d.setColor(Color.BLACK);
			g2d.fill(leftEye);
			g2d.fill(rightEye);	
		}
		else{
			happyEyes.moveTo(x+210, y+170);
			happyEyes.curveTo(x+220, y+160, x+230, y+160, x+235, y+165);
			happyEyes.moveTo(x+260, y+165);
			happyEyes.curveTo(x+265, y+160, x+280, y+160, x+285, y+175);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2d.draw(happyEyes);
		}

		if (enableGoggles == true){
			goggle.moveTo(x+205, y+150);
			goggle.curveTo(x+245, y+120, x+290, y+145, x+300, y+170); //Top Curve (205-300, 150-170)
			goggle.curveTo(x+310, y+185, x+295, y+210, x+280, y+200); //Right Curve (310-280, 170-200)
			goggle.curveTo(x+264, y+180, x+231, y+175, x+225, y+180); //Bottom Curve (290-225, 200-180)
			goggle.curveTo(x+210, y+180, x+195, y+210, x+205, y+150); //Left Curve (225-205, 180-150)
			g2d.setColor(new Color(119, 209, 242, 120));
			g2d.fill(goggle);
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(Color.BLACK);
			g2d.draw(goggle);
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.YELLOW);
			g2d.draw(goggle);	
		}

		
		
		bill.moveTo(x+265, y+190);
		bill.lineTo(x+245, y+210);
		bill.curveTo(x+250, y+235, x+175, y+215, x+190, y+200);
		bill.lineTo(x+230, y+180);
		bill.curveTo(x+240, y+175, x+245, y+180, x+265, y+190);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.ORANGE);
		g2d.fill(bill);
		g2d.setColor(Color.BLACK);
		g2d.draw(bill);
		g2d.setColor(Color.BLACK);
		g2d.rotate(Math.toRadians(45), x+245, y+190);
		g2d.fill(new Ellipse2D.Double(x+245, y+190, 2, 5)); //right nostril
		g2d.fill(new Ellipse2D.Double(x+235, y+195, 2, 5)); //left nostril
		g2d.setTransform(reset);
	
		// hat
		if(enableHat == true){
			g2d.rotate(Math.toRadians(20), x+275, y+175);
			hat.draw(g2d);
			g2d.setColor(Color.DARK_GRAY);
			g2d.fill(new Ellipse2D.Double(x+160, y+125, 230, 30));
			g2d.setTransform(reset);	
		}

		//Salbabida
		if(enableSalbabida == true){
			double salbabidaLeftTipX = x+170;
			double salbabidaRightTipX = x+380;
			salbabida.moveTo(salbabidaLeftTipX, y+255);
			salbabida.curveTo(salbabidaLeftTipX, y+245, salbabidaLeftTipX, y+230, x+220, y+225); // left curve going up
			salbabida.curveTo(x+230, y+250, x+320, y+250, x+330, y+225); // top curve
			salbabida.curveTo(salbabidaRightTipX, y+230, salbabidaRightTipX, y+245, salbabidaRightTipX, y+255); // right curve going down
			salbabida.curveTo(x+355, y+310, x+195, y+310, salbabidaLeftTipX, y+255); // bottom curve
			g2d.setColor(Color.BLUE);
			g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2d.fill(salbabida);		
		}	



		g2d.setTransform(absoluteReset);
		rotation = -5;


	}


	public void rotateLeft(){
		rotation += -15;
	}
	public void rotateRight(){
		rotation += 15;
	}
	public void moveLeft(){
		x -= 20;
	}
	public void moveRight(){
		x += 20;
	}
	public void moveUp(){
		y -= 20;
	}
	public void moveDown(){
		y += 20;
	}
	public void waddle(){
		if(waddleState == false){
			rotateLeft();
			waddleState = true;
		}
		else{
			rotateRight();
			waddleState = false;
		}
	}
	public double giveX(){
		System.out.println("THE RETURNED  X IS " + x);
		return x;
	}

	public double giveY(){
		System.out.println("THE RETURNED  Y IS " + x);
		return y;
	}	

	public void spawnAt(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void swapEyes(){
		if(slitEyes == false){
			slitEyes = true;
		}
		else{
			slitEyes = false;
		}
	}
	public void swapGoggles(){
		if(enableGoggles == false){
			enableGoggles = true;
		}
		else{
			enableGoggles = false;
		}
	}
	public void swapHat(){
		if(enableHat == false){
			enableHat = true;
		}
		else{
			enableHat = false;
		}
	}
	public void swapSalbabida(){
		if(enableSalbabida == false){
			enableSalbabida = true;
		}
		else{
			enableSalbabida = false;
		}
	}

}