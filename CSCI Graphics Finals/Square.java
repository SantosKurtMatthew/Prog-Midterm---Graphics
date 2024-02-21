public class Square extends DrawingObject{
	private double x;
	private double y;
	private double size;
	private Color color;

	public Square(double x, double y, double size, double Color){
		this.x = x;
		this.y = y;
		this.size = size;
		this.Color = color;
	}

	public void draw(Graphics2D g2d){
		Rectangle2D.Double r = Rectangle2D.Double(x, y, size, size);
		g2d.setColor(color);
		g2d.fill(r);
	}
}