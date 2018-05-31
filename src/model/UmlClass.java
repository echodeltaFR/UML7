package model;

import javafx.scene.input.KeyCombination.Modifier;

public class UmlClass {
	/**
	 *le Nom de class
	 */
	private String className;
	/**
	 * le stractu
	 * @param name le Nom de class
	 */
	public UmlClass(String name) {

		className = name;
	}
	public void setName(String name) {

		className = name;
	}
	public String getName() {
		return className;
	}
}
