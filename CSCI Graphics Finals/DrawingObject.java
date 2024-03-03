/**
The DrawingObject abstract class contains the draw method.
It is to be extended by all the components of the picture that will be drawn.

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

public abstract class DrawingObject{
	Graphics g;
	Graphics2D g2d = (Graphics2D) g;

	public abstract void draw(Graphics2D g2d);
}