// MessagePanel Class, responsible for creating a panel and drawing a bottle in that panel
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class MessagePanel extends JPanel{
	public MessagePanel(){
		setVisible(true);
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// used to draw a grid on the panel so that it would be easier to make the bottle.
		/*String xAxis = "";
		String yAxis = "";
		int yAx = 0;
		int xAx = 0;
		for(int a = 40; a <= 390; a += 25){
			xAx = a;
			xAxis += xAx;
			g.drawLine(a, 50, a, 400);
			g.drawString(xAxis, a, 410);
			xAxis = "";
		}
		for(int b = 50; b <= 400; b += 25){
			yAx = b;
			yAxis += yAx;
			g.drawLine(40, b, 390, b);
			g.drawString(yAxis, 20, b);
			yAxis = "";
		}*/
		g.setColor(Color.BLUE);
		// bottle base and sides
		g.drawArc(115, 350, 200, 25, 180, 180);
		g.drawLine(115, 363, 115, 150);
		g.drawLine(315, 363, 315, 150);
		//bottle shoulders
		g.drawArc(115, 111, 50, 75, 180, -90);
		g.drawArc(265, 111, 50, 75, 0, 90);
		g.drawLine(140, 110, 190, 110);
		g.drawLine(290, 110, 240, 110);
		g.drawLine(190, 110, 190, 75);
		g.drawLine(240, 110, 240, 75);
		//bottle top
		g.drawArc(190, 70, 50, 10, 180, 180);
		g.drawArc(190, 70, 50, 10, 180, -180);
		//bottle String
		g.drawString("Help i'm stranded in CSII!", 145,225);
	}
}
