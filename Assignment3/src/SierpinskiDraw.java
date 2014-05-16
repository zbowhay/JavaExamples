/**
 * @author Zac R Bowhay
 * SierpinskiDraw will create a JPanel that will draw a Sierpinski Triangle
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SierpinskiDraw extends JPanel{
	protected int height;
	protected int width;
	protected Polygon square;
	public SierpinskiDraw(){
		setBackground(Color.BLACK);
	}
	/**
	 * paintComponent(Graphics g) overrides the original method. This method creates the original square
	 * @param g the Graphics component that is passed into this method
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		height = Sierpinski.frame.getHeight();
		width = Sierpinski.frame.getWidth();
		/*int area = height*width;
		String s = "" + area;
		System.out.println(s);
		System.out.println("W: " + width);
		g.drawString(s, width - 100, height - 50);*/
		Point P1 = new Point(0,0);
		Point P2 = new Point(0,height);
		Point P3 = new Point(width,height);
		Point P4 = new Point(width,0);
		g.setColor(Color.GREEN);
		Draw(g, P1, P2, P3, P4, 7);
	}
	/**
	 * Draw(Graphics g, Point p1, Point p2, Point p3, Point p4 ,int row) is a recursive method that will create a Sierpinski Triangle
	 * @param g Graphics component that is passed into the method
	 * @param p1 first Point of square, top left corner
	 * @param p2 second Point of square, bottom left corner
	 * @param p3 third Point of square, bottom right corner
	 * @param p4 fourth Point of square, top right corner
	 * @param row Int that represents the number of times you want the Draw() method to run (Recursively)
	 */
	public void Draw(Graphics g, Point p1, Point p2, Point p3, Point p4 ,int row){
		if(row <= 0){
			g.setColor(randomColor());
			//creates the original Square that covers the entire Panel
			square = new Polygon();
			square.addPoint(p1.x,p1.y);
			square.addPoint(p2.x,p2.y);
			square.addPoint(p3.x, p3.y);
			square.addPoint(p4.x,p4.y);
			g.fillPolygon(square);// draws the square
		}else{
			// Next 10 Point objects are required for creating the three smaller squares of the Sierpinski Triangle
			Point midPoint1 = new Point(findMidPoint(p1,p3));
			Point midPoint2 = new Point(findMidPoint(p1,p2));
			Point midPoint3 = new Point(findMidPoint(p1,midPoint1.x,p4.y));
			Point midPoint4 = new Point(findMidPoint(p4,midPoint1.x, p1.y));
			Point midPoint5 = new Point(findMidPoint(p2,p3));
			Point midPoint6 = new Point(findMidPoint(midPoint1,midPoint2));
			Point midPoint7 = new Point(findMidPoint(p4,p3));
			Point midPoint8 = new Point(findMidPoint(midPoint1, midPoint7));
			Point newPoint2 = new Point(p2);
			Point newPoint3 = new Point(p3);
			// Begin Recursion by drawing the newly created 3 squares
			Draw(g, midPoint3, midPoint6, midPoint8, midPoint4, row - 1);//1
			Draw(g, midPoint2, newPoint2, midPoint5, midPoint1, row - 1);//2
			Draw(g, midPoint1, midPoint5, newPoint3, midPoint7, row - 1);//3
		}
	}
	/**
	 * findMidPoint(Point p1, Point p2) will return the Point between the two Points entered
	 * @param p1 Point 1
	 * @param p2 Point 2
	 * @return	midPoint, the Point between p1 and p2
	 */
	public static Point findMidPoint(Point p1, Point p2){
		Point midPoint = new Point(((p1.x + p2.x)/2), ((p1.y + p2.y)/2));
		return midPoint;
	}
	/**
	 * findMidPoint(Point p1, int x, int y) will return the Point between a Point and another coordinate specified by x and y
	 * @param p1 Point 1
	 * @param x X coordinate of second Point
	 * @param y Y coordinate of second Point
	 * @return	midPoint, the Point between p1 and int x & y
	 */
	public static Point findMidPoint(Point p1, int x, int y){
		Point midPoint = new Point(((p1.x + x)/2),((p1.y + y)/2));
		return midPoint; 
	}
	/**
	 * randomColor() will return a random color
	 * @return returns a color
	 */
	public static Color randomColor(){
		Random rand = new Random();
		int rnum = rand.nextInt(3);
		if(rnum == 0 ){
			return Color.blue;
		}
		if(rnum == 1){
			return Color.red;
		}
		if(rnum == 2){
			return Color.GREEN;
		}
		if(rnum == 3){
			return Color.BLACK;
		}else
			return Color.CYAN;// should never return cyan.....
	}
}
