package model;

import java.util.ArrayList;

public abstract class UmlEntity{

	private Visibility visibility;
	private ArrayList<Modifier> modifier;
	
	public UmlEntity(Visibility visibility, ArrayList<Modifier> modifier) {
		this.visibility = visibility;
		this.modifier = modifier;
	}
	
	public void addModifier(Modifier modifier) {
		this.modifier.add(modifier);
	}
	
	public void clearModifiers() {
		for(int i = 0; i<this.modifier.size(); i++) {
			this.modifier.remove(this.modifier.get(i)); 
		}
	}
	
	public void removeModifier(Modifier modifier) {
		this.modifier.remove(modifier);
	}
	
	public Visibility getVisibility() {
		return this.visibility;
	}
	
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	
	public Visibility getModifier() {
		return this.visibility;
	}
	
	public void setModifier(ArrayList<Modifier> modifier) {
		this.modifier = modifier;
	}
}

