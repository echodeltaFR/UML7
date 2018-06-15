package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import exporter.DiagramSaver;
import importer.DiagramLoader;
import model.UmlClass;
import model.UmlDiagram;
import model.UmlEnum;
import model.UmlInterface;

public class Uml7JFrame extends JFrame{

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -6668736329185551481L;
	
	public static final String APPLICATION_NAME = "UML7";
	public static final int DEFAULT_WIDTH = 700;
	public static final int DEFAULT_HEIGHT = 400;
	
	public static final Border deleteButtonBorder = BorderFactory.createLineBorder(Color.gray, 1);
	public static final Color objectBackgroundColor = new Color(255,250,196);
	public static final Border objectInnerSeparation = BorderFactory.createLineBorder(new Color(150,0,0), 1);
	public static final Border objectBorder = BorderFactory.createCompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 4, 4, Color.LIGHT_GRAY),
			objectInnerSeparation
	);
	
	
	private UmlDiagram displayed;
	
	private ActionListener addClassActionListner;
	private ActionListener addInterfaceActionListner;
	private ActionListener addEnumActionListner;
	
	public Uml7JFrame(UmlDiagram displayed) {
		super(APPLICATION_NAME);
		
		this.buildListeners();
		
		if (displayed == null) throw new IllegalArgumentException("Displayed diagram can't be null");
		
		this.displayed = displayed;
		
		DiagramDisplay display = new DiagramDisplay(displayed);
		this.getContentPane().add(display);
		
		this.setJMenuBar(buildApplicationMenuBar(this, displayed, display));
		
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setLocationRelativeTo(null); //Center frame
	}
	
	private JMenuBar buildApplicationMenuBar(JFrame f, UmlDiagram diagram, DiagramDisplay displayer) {
		JMenu file = new JMenu("File");
		
		JMenuItem exit = new JMenuItem("Exit");
		
		exit.addActionListener(e ->
			f.dispose()
		);
		
		JMenuItem save = new JMenuItem("Save diagram");
		Uml7JFrame.SaveController saveControl = new SaveController();
		save.addActionListener(saveControl);
		
		JMenuItem load = new JMenuItem("Load diagram");
		load.addActionListener(new Uml7JFrame.LoadController(saveControl, displayer));
		
		file.add(load);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		
		JMenu add = new JMenu("Add");
		
		JMenuItem addClass = new JMenuItem("Class");
		addClass.addActionListener(this.addClassActionListner);
		JMenuItem addInterface = new JMenuItem("Interface");
		addInterface.addActionListener(this.addInterfaceActionListner);
		JMenuItem addEnum = new JMenuItem("Enum");
		addEnum.addActionListener(this.addEnumActionListner);
		
		add.add(addClass);
		add.add(addInterface);
		add.add(addEnum);
		
		JMenuBar appBar = new JMenuBar();
		
		appBar.add(file);
		appBar.add(add);
		
		return appBar;
	}
	
	private class SaveController implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DiagramSaver saver = new DiagramSaver(displayed);
			try {
				saver.save();
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: "+e1.getMessage(), "Error while saving", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private class LoadController implements ActionListener{

		private DiagramDisplay displayer;
		
		LoadController(SaveController sc, DiagramDisplay dd){
			this.displayer = dd;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DiagramLoader loader = new DiagramLoader();
			try {
				loader.load();
				UmlDiagram d = loader.getDiagram();
				if (d != null) {
					displayed = d;
					displayer.setDisplayedDiagram(d);
				}
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Error: the file does not seems to be a valid UML7 file", "Error while loading", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error: "+e1.getMessage(), "Error while loading", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private void buildListeners() {
		this.addClassActionListner = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "What is the name of the class?", "Add class", JOptionPane.PLAIN_MESSAGE);
				if (name != null) {
					displayed.addUmlElements(new UmlClass(name));
				}
			}
		};
		
		this.addInterfaceActionListner = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "What is the name of the interface?", "Add interface", JOptionPane.PLAIN_MESSAGE);
				if (name != null) {
					displayed.addUmlElements(new UmlInterface(name));
				}
			}
		};
		
		this.addEnumActionListner = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "What is the name of the enum?","Add enum",JOptionPane.PLAIN_MESSAGE);
				if (name != null) {
					displayed.addUmlElements(new UmlEnum(name));
				}
			}
		};
	}
	
	
}
