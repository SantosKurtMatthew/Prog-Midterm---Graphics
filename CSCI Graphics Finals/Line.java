public class Line extends DrawingObject{
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	private double thickness;
	private Color color;

	public Line(double x1, double y1, double x2, double y2, double thickness, double Color){
		this.x1 = startX;
		this.y1 = startY;
		this.x2 = endX;
		this.y2 = endY;
		this.thickness = thickness;
		this.Color = color;
	}

	public void draw(Graphics2D g2d){
		Line2D.Double l = new Line2D.Double(startX, startY, endX, endY);
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(thickness));
		g2d.draw(l);
	}
}