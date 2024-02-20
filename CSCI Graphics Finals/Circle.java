public class Circle{
	private double x;
	private double y;
	private double size;
	private Color color;

	public Circle(double x, double y, double size, double Color){
		this.x = x;
		this.y = y;
		this.size = size;
		this.Color = color;
	}

	public void draw(Graphics2D g2d){
		Ellipse2D.Double r = Ellipse2D.Double(x, y, size, size);
		g2d.setColor(color);
		g2d.fill(r);
	}
}