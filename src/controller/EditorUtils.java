package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import model.Modifier;
import model.PrimitiveType;
import model.Visibility;

/**
 * Class that represents a set of utils methods.
 * @author Charly Courilleau
 *
 */
public class EditorUtils {

	/**
	 * Method that permits to add an item listener on a checkbox.
	 * @param checkBox the swing checkbox
	 * @param modifier the modifier handled by the swing checkbox
	 */
	public static void addItemListenerCheckBox(JCheckBox checkBox, Modifier modifier, Set<Modifier> modifiers) {
		checkBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
		        if (arg0.getStateChange() == ItemEvent.SELECTED) {
		            modifiers.add(modifier);
		        } else {
		        	modifiers.remove(modifier);
		        }	
			}
		});
	}
	

	/**
	 * Method that permits to initialize a combobox visibility.
	 * @param combo the swing combobox
	 */
	public static void initializeVisibility(JComboBox<String> combo) {
		for (Visibility visibility : Visibility.values()) {
			combo.addItem(visibility.name());
		}
	}
	
	/**
	 * Method that permits to initialize the combobox type.
	 * @param combo the swing combobox type
	 */
	public static void initializeType(JComboBox<String> combo) {
		for (PrimitiveType type : PrimitiveType.values()) {
			combo.addItem(type.name());
		}
	}
}
