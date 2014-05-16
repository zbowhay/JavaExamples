//Problem 1, Message in a Bottle
// Message class, responsible for running MessageFrame and MessagePanel within the main method.
import java.awt.*;
import javax.swing.*;

public class Message{

	public static void main(String[] args){
		MessageFrame frame = new MessageFrame();
		MessagePanel panel = new MessagePanel();
		Container contentPane = frame.getContentPane();
		contentPane.add(panel);
		frame.setVisible(true);		
	}
}
