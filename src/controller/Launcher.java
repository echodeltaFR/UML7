package controller;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashSet;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Modifier;
import model.PrimitiveType;
import model.UmlAttribute;
import model.UmlClass;
import model.UmlInterface;
import model.UmlMethod;
import model.UmlParams;
import model.Visibility;
import view.UMLObjectDisplay;

public class Launcher {
	
	public static final String APPLICATION_NAME = "UML7";
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 300;
	
	public static void main(String[] argv) {
		GridBagLayout layout = new GridBagLayout(); 
		GridBagConstraints gc = new GridBagConstraints();
		
		
		JFrame application = new JFrame(APPLICATION_NAME);
		gc.weightx = 20;
		gc.weighty = 20;
		
		JPanel editingArea = new JPanel(layout);
		editingArea.setBackground(Color.WHITE);
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;

		application.setContentPane(editingArea);
		application.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		application.setLocationRelativeTo(null);
		application.setJMenuBar(buildApplicationMenuBar(application));
		buildDebugDiagram(editingArea, gc);
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
	
	private static void buildDebugDiagram(JPanel ea, GridBagConstraints gc) {
		HashSet<Modifier> mod;
		HashSet<UmlParams> param;
		
		
		// BUILDING CLASS
		UmlClass c1 = new UmlClass("Classe 1");
		
		c1.addAttribute(new UmlAttribute("The_Default_letter", PrimitiveType.CHAR));
		mod = new HashSet<Modifier>();
		mod.add(Modifier.FINAL);
		mod.add(Modifier.STATIC);
		c1.addMethod(new UmlMethod("A_Method", new HashSet<UmlParams>(), null, Visibility.PUBLIC, mod));
		mod = new HashSet<Modifier>();
		mod.add(Modifier.VOLATILE);
		param = new HashSet<UmlParams>();
		param.add(new UmlParams(PrimitiveType.CHAR, "letter"));
		c1.addMethod(new UmlMethod("Another_Method", param, PrimitiveType.INT, Visibility.PUBLIC, mod));
		gc.gridx = 2;
		gc.gridy = 2;
		ea.add(new UMLObjectDisplay(c1),gc);
		
		//BUILDING INTERFACE
		UmlInterface i = new UmlInterface("some_interface");
		i.addMethod(new UmlMethod("Method 1", new HashSet<UmlParams>(), PrimitiveType.BOOLEAN, Visibility.PROTECTED, null));
		gc.gridx = 15;
		gc.gridy = 15;
		ea.add(new UMLObjectDisplay(i),gc);
	}
}
