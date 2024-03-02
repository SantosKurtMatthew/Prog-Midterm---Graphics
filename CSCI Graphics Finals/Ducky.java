import java.awt.*;
import java.awt.geom.*;

public class Ducky extends DrawingObject{
	private Path2D.Double torso, hanfuInner, hanfuOuterLeft, hanfuOuterRight, hanfuRightSleeve, sleeveOutline, hanfuAccent, leftLeg, rightLeg, hanfuBelt, ahoge, happyEyes, goggle, bill, salbabida;
	private Ellipse2D.Double hanfuOuterBack, head, leftEye, rightEye;
	private Triangle hat;
	private int rotation;

	public Ducky(){
		hanfuOuterBack = new Ellipse2D.Double(233, 330, 140, 100);
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
		head = new Ellipse2D.Double(200, 100, 150, 150); //(200-350, 100-250)
		ahoge = new Path2D.Double();
		happyEyes = new Path2D.Double();
		goggle = new Path2D.Double();
		bill = new Path2D.Double();
		hat = new Triangle(275, 50, 160, 140, 390, 140, Color.DARK_GRAY);
		salbabida = new Path2D.Double();
		rotation = 0;

	}

	public void draw(Graphics2D g2d){

		AffineTransform absoluteReset = g2d.getTransform();

		g2d.rotate(Math.toRadians(rotation),275,400);
		
		AffineTransform reset = g2d.getTransform();
		
		g2d.setColor(Color.BLACK);
		g2d.fill(hanfuOuterBack);
		g2d.setStroke(new BasicStroke(8));
		g2d.setColor(Color.RED);
		g2d.draw(hanfuOuterBack);
		
		
		torso.moveTo(230, 235);
		torso.curveTo(180, 400, 370, 500, 440, 280); //lower curve
		torso.curveTo(375, 325, 325, 300, 320, 235); //upper curve
		g2d.setColor(new Color(247, 245, 218));
		g2d.fill(torso);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.BLACK);
		g2d.draw(torso);

		//hanfu
		g2d.setStroke(new BasicStroke(1));

		hanfuInner.moveTo(230, 245);
		hanfuInner.lineTo(270, 280);
		hanfuInner.lineTo(320, 240);
		hanfuInner.curveTo(325, 300, 375, 315, 410, 295); //upper curve //tail tip 440, 280
		hanfuInner.lineTo(410, 345);
		hanfuInner.curveTo(350, 470, 180, 390, 230, 245); //lower curve
		//g2d.setColor(Color.BLACK);
		//g2d.draw(hanfuInner);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fill(hanfuInner);
		
		
		hanfuOuterLeft.moveTo(227, 245);
		hanfuOuterLeft.curveTo(185, 290, 215, 340, 185, 375); // left curve
		hanfuOuterLeft.curveTo(190, 380, 210, 390, 235, 400); // bottom curve
		hanfuOuterLeft.moveTo(230, 235);
		hanfuOuterLeft.curveTo(210, 290, 210, 375, 245, 415); // middle curve
		hanfuOuterLeft.curveTo(235, 375, 235, 290, 240, 243); // right curve
		hanfuOuterLeft.lineTo(230, 235); // collar line
		g2d.setColor(Color.BLACK);
		g2d.fill(hanfuOuterLeft);
		g2d.setColor(Color.DARK_GRAY);
		g2d.draw(hanfuOuterLeft);
		
		
		
		hanfuOuterRight.moveTo(320, 235);
		hanfuOuterRight.curveTo(320, 235, 310, 245, 300, 245); // collar curve
		hanfuOuterRight.curveTo(300, 420, 360, 425, 400, 425); // left curve
		hanfuOuterRight.curveTo(430, 430, 460, 420, 450, 390); // bottom-right curve
		hanfuOuterRight.curveTo(435, 360, 450, 320, 410, 295); // right-most curve
		hanfuOuterRight.curveTo(375, 315, 330, 295, 320, 235); // back curve
		g2d.setColor(Color.BLACK);
		g2d.fill(hanfuOuterRight);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.DARK_GRAY);
		g2d.draw(hanfuOuterRight);
		
		
		
		hanfuRightSleeve.moveTo(320, 240);
		hanfuRightSleeve.curveTo(360, 260, 390, 360, 400, 360); // right curve
		hanfuRightSleeve.curveTo(390, 380, 380, 395, 365, 410); // bottom right curve
		hanfuRightSleeve.curveTo(355, 375, 350, 370, 335, 365); // bottom left curve
		hanfuRightSleeve.curveTo(330, 335, 320, 280, 310, 255); // left curve
		hanfuRightSleeve.closePath();
		g2d.setColor(Color.BLACK);
		g2d.fill(hanfuRightSleeve);
		//g2d.setColor(Color.DARK_GRAY);
		//g2d.draw(hanfuRightSleeve);
		
		
		sleeveOutline.moveTo(320, 240);
		sleeveOutline.curveTo(360, 260, 390, 360, 400, 360); // right curve
		sleeveOutline.moveTo(365, 410);
		sleeveOutline.curveTo(355, 375, 350, 370, 340, 365); // bottom left curve
		sleeveOutline.curveTo(330, 335, 320, 280, 310, 265); // left curve
		sleeveOutline.moveTo(325, 310); // right sleeve line
		sleeveOutline.curveTo(320, 285, 325, 250, 346, 265); 
		sleeveOutline.moveTo(218, 285); // left sleeve line
		sleeveOutline.curveTo(215, 270, 210, 270, 209, 275); 
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.DARK_GRAY);
		g2d.draw(sleeveOutline);
		
		 
		hanfuAccent.moveTo(185, 375); //left
		hanfuAccent.curveTo(190, 380, 210, 390, 230, 395);
		hanfuAccent.moveTo(245, 412); //left
		hanfuAccent.curveTo(235, 375, 235, 290, 240, 240);
		hanfuAccent.moveTo(300, 245); //right
		hanfuAccent.curveTo(300, 420, 360, 425, 400, 425); 
		hanfuAccent.curveTo(430, 430, 460, 420, 450, 390);
		hanfuAccent.curveTo(435, 360, 450, 320, 410, 295);
		hanfuAccent.moveTo(340, 365); //right sleeve
		hanfuAccent.curveTo(345, 350, 375, 350, 400, 360);
		hanfuAccent.curveTo(390, 380, 380, 395, 365, 410);
		hanfuAccent.curveTo(365, 390, 370, 390, 375, 375);
		hanfuAccent.curveTo(360, 360, 345, 365, 340, 365);	
		hanfuAccent.moveTo(240, 250); // collar
		hanfuAccent.lineTo(265, 275);
		hanfuAccent.moveTo(300, 250);
		hanfuAccent.lineTo(240, 300);
		hanfuAccent.moveTo(240, 320); // belt
		hanfuAccent.curveTo(260, 330, 290, 330, 303, 315);
		hanfuAccent.moveTo(240, 335);
		hanfuAccent.curveTo(260, 350, 290, 350, 305, 335);
		BasicStroke accent = new BasicStroke(8.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND); //https://docs.oracle.com/javase/tutorial/2d/geometry/strokeandfill.html, http://www.java2s.com/Tutorials/Java/java.awt/BasicStroke/0060__BasicStroke.CAP_ROUND.htm
		g2d.setStroke(accent);
		g2d.setColor(Color.RED);
		g2d.draw(hanfuAccent);
		
		
		
		
		leftLeg.moveTo(270, 390); 
		leftLeg.lineTo(270, 430); // left line going down
		leftLeg.lineTo(250, 435); // piatos 1
		leftLeg.lineTo(260, 455); // piatos 2
		leftLeg.lineTo(285, 450); // piatos 3
		leftLeg.lineTo(285, 430); // piatos 4
		leftLeg.lineTo(285, 390); // right line going up
		leftLeg.curveTo(280, 385, 275, 385, 270, 390); // top curve going left
		rightLeg.moveTo(290, 385);
		rightLeg.lineTo(290, 435); // left line going down
		rightLeg.lineTo(270, 440); // piatos 1
		rightLeg.lineTo(280, 465); // piatos 2
		rightLeg.lineTo(315, 460); // piatos 3
		rightLeg.lineTo(310, 435); // piatos 4
		rightLeg.lineTo(310, 385); // right line going up
		rightLeg.curveTo(305, 380, 295, 380, 290, 385); // top curve going left
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.rotate(Math.toRadians(15), 275, 390);
		g2d.setColor(Color.ORANGE);
		g2d.fill(leftLeg);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(leftLeg);
		g2d.setTransform(reset);
		g2d.rotate(Math.toRadians(-15), 275, 390);
		g2d.translate(0, 5);
		g2d.setColor(Color.ORANGE);
		g2d.fill(rightLeg);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(rightLeg);
		g2d.setTransform(reset);
		
		 
		hanfuBelt.moveTo(245, 330);
		hanfuBelt.curveTo(260, 340, 285, 340, 298, 327);
		hanfuBelt.moveTo(260, 335);
		hanfuBelt.lineTo(260, 385);
		hanfuBelt.moveTo(280, 335);
		hanfuBelt.lineTo(280, 405);
		BasicStroke beltStroke = new BasicStroke(12.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2d.setStroke(beltStroke);
		g2d.setColor(Color.BLACK);
		g2d.draw(hanfuBelt);
		
		
		
		g2d.setStroke(new BasicStroke(3));
		

		
		/*
		BasicStroke bs = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		int x = 100;
		int y = 100;
		Path2D.Double lilyPad = new Path2D.Double(); 
		lilyPad.moveTo(x,y);
		lilyPad.curveTo(x, y-20 , x+60, y-20, x+60, y);
		lilyPad.curveTo(x+60, y+20, x, y+20, x, y);
		g2d.setStroke(bs);
		g2d.setColor(Color.GREEN);
		g2d.draw(lilyPad);
		*/
		
		// ducky head
		g2d.setStroke(new BasicStroke(1));
		g2d.rotate(Math.toRadians(15), 275, 175);
		ahoge.moveTo(245, 110);
		ahoge.curveTo(245, 60, 272, 80, 275, 90); // Left Curve (245-275, 110-90)
		ahoge.curveTo(290, 85, 305, 85, 305, 110); // Right Curve (275-305, 90-110)
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
		/*
		Ellipse2D.Double leftEye = new Ellipse2D.Double(208, 155, 22, 22);
		Ellipse2D.Double rightEye = new Ellipse2D.Double(265, 160, 24, 24);
		g2d.setColor(Color.BLACK);
		g2d.fill(leftEye);
		g2d.fill(rightEye);
		*/
		
		happyEyes.moveTo(210, 170);
		happyEyes.curveTo(220, 160, 230, 160, 235, 165);
		happyEyes.moveTo(260, 165);
		happyEyes.curveTo(265, 160, 280, 160, 285, 175);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.draw(happyEyes);
		//

		goggle.moveTo(205,150);
		goggle.curveTo(245,120,290,145,300,170); //Top Curve (205-300, 150-170)
		goggle.curveTo(310, 185, 295, 210, 280, 200); //Right Curve (310-280, 170-200)
		goggle.curveTo(264, 180, 231, 175, 225, 180); //Bottom Curve (290-225, 200-180)
		goggle.curveTo(210, 180, 195, 210, 205, 150); //Left Curve (225-205, 180-150)
		g2d.setColor(new Color(119, 209, 242, 120));
		g2d.fill(goggle);
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.BLACK);
		g2d.draw(goggle);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.YELLOW);
		g2d.draw(goggle);
		
		bill.moveTo(265, 190);
		bill.lineTo(245, 210);
		bill.curveTo(250, 235, 175, 215, 190, 200);
		bill.lineTo(230,180);
		bill.curveTo(240, 175, 245, 180, 265,190);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.ORANGE);
		g2d.fill(bill);
		g2d.setColor(Color.BLACK);
		g2d.draw(bill);
		g2d.setColor(Color.BLACK);
		g2d.rotate(Math.toRadians(45),245,190);
		g2d.fill(new Ellipse2D.Double(245, 190, 2, 5)); //right nostril
		g2d.fill(new Ellipse2D.Double(235, 195, 2, 5)); //left nostril
		g2d.setTransform(reset);
		// hat
		g2d.rotate(Math.toRadians(20), 275, 175);
		hat.fillTriangle(g2d);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fill(new Ellipse2D.Double(160, 125, 230, 30));
		
		
		g2d.setTransform(reset);
		
		
		
		int salbabidaLeftTipX = 170;
		int salbabidaRightTipX = 380;
		salbabida.moveTo(salbabidaLeftTipX, 255);
		salbabida.curveTo(salbabidaLeftTipX, 245, salbabidaLeftTipX, 230, 220, 225); // left curve going up
		salbabida.curveTo(230, 250, 320, 250, 330, 225); // top curve
		salbabida.curveTo(salbabidaRightTipX, 230, salbabidaRightTipX, 245, salbabidaRightTipX, 255); // right curve going down
		salbabida.curveTo(355, 310, 195, 310, salbabidaLeftTipX, 255); // bottom curve
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.fill(salbabida);	

		g2d.setTransform(absoluteReset);
		rotation = -5;
	}


	public void rotateLeft(){
		rotation += -15;
	}
	public void rotateRight(){
		rotation += 15;
	}


}