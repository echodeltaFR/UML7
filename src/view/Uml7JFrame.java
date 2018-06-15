package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import exporter.DiagramSaver;
import importer.DiagramLoader;
import model.UmlDiagram;

public class Uml7JFrame extends JFrame{

	public static final String APPLICATION_NAME = "UML7";
	public static final int DEFAULT_WIDTH = 700;
	public static final int DEFAULT_HEIGHT = 400;
	
	public Uml7JFrame(UmlDiagram displayed) {
		super(APPLICATION_NAME);
		
		if (displayed == null) throw new IllegalArgumentException("Displayed diagram can't be null");
		
		DiagramDisplay display = new DiagramDisplay(displayed);
		this.getContentPane().add(display);
		
		this.setJMenuBar(buildApplicationMenuBar(this, displayed, display));
		
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setLocationRelativeTo(null); //Center frame
	}
	
	private static JMenuBar buildApplicationMenuBar(JFrame f, UmlDiagram diagram, DiagramDisplay displayer) {
		JMenu file = new JMenu("File");
		
		JMenuItem exit = new JMenuItem("Exit");
		
		exit.addActionListener(e ->
			f.dispose()
		);
		
		JMenuItem save = new JMenuItem("Save diagram");
		Uml7JFrame.SaveController saveControl = new Uml7JFrame.SaveController(diagram);
		save.addActionListener(saveControl);
		
		JMenuItem load = new JMenuItem("Load diagram");
		load.addActionListener(new Uml7JFrame.LoadController(saveControl, displayer));
		
		//TODO Add actionlistners
		
		file.add(load);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		
		JMenuBar appBar = new JMenuBar();
		
		appBar.add(file);
		
		return appBar;
	}
	
	private static class SaveController implements ActionListener{

		private UmlDiagram saveTarget;
		
		SaveController(UmlDiagram d){
			this.saveTarget = d;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DiagramSaver saver = new DiagramSaver(saveTarget);
			try {
				saver.save();
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: "+e1.getMessage(), "Error while saving", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private static class LoadController implements ActionListener{

		private SaveController saver;
		
		private DiagramDisplay displayer;
		
		LoadController(SaveController sc, DiagramDisplay dd){
			this.saver = sc;
			this.displayer = dd;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DiagramLoader loader = new DiagramLoader();
			try {
				loader.load();
				UmlDiagram d = loader.getDiagram();
				if (d != null) {
					displayer.setDisplayedDiagram(d);
					saver.saveTarget = d;
				}
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Error: the file does not seems to be a valid UML7 file", "Error while loading", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error: "+e1.getMessage(), "Error while loading", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
}
