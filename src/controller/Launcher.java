package controller;

import java.util.HashSet;
import java.util.Set;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import exception.ExceptionAttribute;
import exception.ExceptionMethode;
import generator.JavaGenerator;
import model.Modifier;
import model.PrimitiveType;
import model.UmlAttribute;
import model.UmlClass;
import model.UmlDiagram;
import model.UmlMethod;
import model.UmlParams;
import model.Visibility;
import view.CompositionRelationDisplay;
import view.RelationDisplay;
import view.UMLObjectDisplay;

public class Launcher {
	
	public static final String APPLICATION_NAME = "UML7";
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 300;
	
	public static void main(String[] argv) throws ExceptionAttribute, ExceptionMethode {
		UmlDiagram showedDiagram = new UmlDiagram();
		
		GridBagLayout layout = new GridBagLayout(); 
		GridBagConstraints gc = new GridBagConstraints();
		
		JFrame application = new JFrame(APPLICATION_NAME);
		gc.weightx = 1;
		gc.weighty = 1;
		
		JPanel editingArea = new JPanel(layout);
		editingArea.setBackground(Color.WHITE);
		
		application.setContentPane(editingArea);
		application.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		application.setLocationRelativeTo(null);
		application.setJMenuBar(buildApplicationMenuBar(application));
		
		
		buildDebugDiagram(editingArea, showedDiagram);
				
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
	
	private static void buildDebugDiagram(JPanel ea, UmlDiagram showedDiagram) throws ExceptionAttribute, ExceptionMethode {
		Set<Modifier> mod;
		Set<UmlParams> param;
		
		
		// BUILDING CLASS
		UmlClass c1 = new UmlClass("Classe_1");
		
		c1.addAttribute(new UmlAttribute("The_Default_letter", PrimitiveType.CHAR));
		mod = new HashSet<>();
		mod.add(Modifier.FINAL);
		mod.add(Modifier.STATIC);
		c1.addMethod(new UmlMethod("A_Method", new HashSet<UmlParams>(), null, Visibility.PUBLIC, mod));
		mod = new HashSet<>();
		mod.add(Modifier.VOLATILE);
		param = new HashSet<>();
		param.add(new UmlParams(PrimitiveType.CHAR, "letter"));
		c1.addMethod(new UmlMethod("Another_Method", param, PrimitiveType.INT, Visibility.PUBLIC, mod));
		
		GridBagConstraints gc1 = new GridBagConstraints();
		
		gc1.gridx = 0;
		gc1.gridy = 1;
		gc1.fill = GridBagConstraints.BOTH;

		ea.add(new UMLObjectDisplay(c1),gc1);
		
	
		// BUILDING CLASS 2
		UmlClass c2 = new UmlClass("Entreprise");

		c2.addAttribute(new UmlAttribute("The_Default_letter", PrimitiveType.CHAR));
		mod = new HashSet<>();
		mod.add(Modifier.FINAL);
		mod.add(Modifier.STATIC);
		c2.addMethod(new UmlMethod("A_Method", new HashSet<UmlParams>(), null, Visibility.PUBLIC, mod));
		mod = new HashSet<>();
		mod.add(Modifier.VOLATILE);
		param = new HashSet<>();
		c2.addMethod(new UmlMethod("getA()", param, PrimitiveType.INT, Visibility.PUBLIC, mod));

		
		GridBagConstraints gc3 = new GridBagConstraints();
		
		gc3.gridx = 3;
		gc3.gridy = 1;
		gc3.fill = GridBagConstraints.BOTH;

		ea.add(new UMLObjectDisplay(c2),gc3);
		
		GridBagConstraints gc4 = new GridBagConstraints();
		RelationDisplay relation = new CompositionRelationDisplay(null,null,null);
		gc4.gridx = 1;
		gc4.gridy = 1;
		gc4.ipadx = 100;
		gc4.fill = GridBagConstraints.BOTH;
		gc4.anchor = GridBagConstraints.LINE_START;

		ea.add(relation,gc4);
	}
	
	/**private static GridBagConstraints getConstraintObject(GridBagLayout layout, Component[] components) {
		
		List<Point> occupee = new ArrayList<Point>();
		
		int[][] dimensions = layout.getLayoutDimensions();
				
		GridBagConstraints freeGbc = new GridBagConstraints();
		
		double xMax = 0;
		double yMax = 0;

		for (Component comp : components) {
		    GridBagConstraints gbc = layout.getConstraints(comp);
		    occupee.add(new Point(gbc.gridx, gbc.gridy));   
		    if (gbc.gridx > xMax) {
		    	xMax = gbc.gridx;
		    }
		    
		    if (gbc.gridy > yMax) {
		    	yMax = gbc.gridy;
		    }
		}
		
		Random random = new Random();
		
		do {
			freeGbc.gridx = random.nextInt((int)xMax+2);
			freeGbc.gridy = random.nextInt((int)yMax+2);
		} while (contains(occupee, new Point(freeGbc.gridx, freeGbc.gridy)));
		
		freeGbc.fill = GridBagConstraints.BOTH;

		return freeGbc;
	}
	
	private static boolean contains(List<Point> list, Point recherche) {
		for (Point p : list) {
			if (p.getX() == recherche.getX() && p.getY() == recherche.getY())
				return true;
		}
		return false;
	}**/
	
	
}
