package controller;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Launcher {
	
	public static final String APPLICATION_NAME = "UML7";
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 300;
	
	public static void main(String[] argv) {
		
		JFrame application = new JFrame(APPLICATION_NAME);
		application.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		application.setJMenuBar(buildApplicationMenuBar(application));
		application.setVisible(true);
	}

	private static JMenuBar buildApplicationMenuBar(JFrame f) {
		JMenu file = new JMenu("File");
		
		JMenuItem exit = new JMenuItem("Exit");
		
		exit.addActionListener(e ->
			f.dispose()
		);
		
		file.add(exit);
		
		JMenuBar appBar = new JMenuBar();
		
		appBar.add(file);
		
		return appBar;
	}
}
