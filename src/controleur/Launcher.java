package controleur;

import javax.swing.JFrame;

public class Launcher {
	
	public static final String APPLICATION_NAME = "UML7";
	public static final int default_width = 500;
	public static final int default_height = 300;
	
	public static void main(String[] argv) {
		
		JFrame application = new JFrame(APPLICATION_NAME);
		application.setSize(default_width, default_height);
		
		application.setVisible(true);
	}

}
