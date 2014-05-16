//Browser, makes a simple browser

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Browser extends JFrame{
	
	private JTextField adressBar;
	private JEditorPane mainDisplay;

	public static void main(String[] args){
		Browser zBrowse = new Browser();
	}
	
	public Browser(){
		super("Zac's Browser");
		adressBar = new JTextField("Enter a URL here");
		adressBar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					loadPage(e.getActionCommand());
				}
			}
		);
		add(adressBar, BorderLayout.NORTH);
		mainDisplay = new JEditorPane();
		mainDisplay.setEditable(false);
		mainDisplay.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent e){
						if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
							loadPage(e.getURL().toString());
					}
				}
		);
		add(new JScrollPane(mainDisplay), BorderLayout.CENTER);
		setSize(800,600);
		setVisible(true);
	}
	
	private void loadPage(String textEntered){
		String URL = textEntered;
		try{
			mainDisplay.setPage(URL);
		}catch(Exception e){
			System.out.println("URL Error: type this: http://www.websitegoeshere.com/");
		}
	}
}

