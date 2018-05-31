package model;

public class UmlPackage extends UmlLabeled_Element {
	private String nom;
	private UmlLabeled_Element[] label;
	public UmlPackage(String name) {
		nom = name;
	}
	public void setName(String name) {
		nom = name;
	}
	public String getName() {
		return nom;
	}
}
