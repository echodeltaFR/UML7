package controller;

import model.UmlDiagram;
import view.Uml7JFrame;

/**
 * 
 * This class goal is to be the entry point of UML7 application and only define the start behavior.
 *
 */
public class Launcher {
	
	/**
	 * Start UML7.
	 */
	public static void main(String[] argv) {
		UmlDiagram showedDiagram = new UmlDiagram();
		Uml7JFrame jf = new Uml7JFrame(showedDiagram);
		jf.setVisible(true);
	}
}
