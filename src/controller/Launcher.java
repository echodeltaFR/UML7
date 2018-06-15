package controller;

import model.UmlDiagram;
import view.Uml7JFrame;

public class Launcher {
	
	public static void main(String[] argv) {
		UmlDiagram showedDiagram = new UmlDiagram();
		Uml7JFrame jf = new Uml7JFrame(showedDiagram);
		jf.setVisible(true);
	}
}
