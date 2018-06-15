package exporter;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.UmlDiagram;

public class JFileChooserOverwrite extends JFileChooser {
	
	public static void main(String args[]) {
		UmlDiagram diagram = new UmlDiagram();
		DiagramSaver saver = new DiagramSaver(diagram);
		// Locale.setDefault(Locale.US
				
		try {
			saver.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
}
