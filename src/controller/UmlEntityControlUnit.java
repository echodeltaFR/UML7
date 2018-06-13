package controller;

import javax.swing.JOptionPane;

import exception.ExceptionUml;
import model.UmlEntity;
import model.Visibility;

public class UmlEntityControlUnit {

	public static void askAndChangeName(UmlEntity umle) {
		boolean done = false;
		while (!done){
			try {
				String newName = JOptionPane.showInputDialog("What is the new method name?", umle.getName());
				if (newName != null) {
					umle.setName(newName);
					done = true;
				}
			} catch(IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Error : "+ex.getMessage(),"An error happened",JOptionPane.ERROR_MESSAGE);
			}
		}	
	}
	
	public static void askAndChangeVisibility(UmlEntity umle) {
		boolean done = false;
		while (! done) {
			Object[] possibilities = Visibility.values();
			Visibility v = (Visibility)JOptionPane.showInputDialog(
			                    null,
			                    "Choose a visibility",
			                    "Visibility choosing",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null,
			                    possibilities,
			                    Visibility.PUBLIC);
			if (v != null) {
				try {
					umle.setVisibility(v);
					done = true;
				} catch (ExceptionUml ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				done = true;
			}
		}
	}
	
}
