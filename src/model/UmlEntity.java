package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class UmlEntity{

	private Visibility visibility;
	private HashSet<Modifier> modifiers;
	
	public UmlEntity(Visibility visibility, Collection<Modifier> modifier) {
		this.visibility = visibility;
		this.modifiers = new HashSet<Modifier>(modifier);
	}
	
	public void addModifier(Modifier modifier) {
		this.modifiers.add(modifier);
	}
	
	public void clearModifiers() {
		this.modifiers.clear();
	}
	
	public void removeModifier(Modifier modifier) {
		this.modifiers.remove(modifier);
	}
	
	public Visibility getVisibility() {
		return this.visibility;
	}
	
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	
	public Set<Modifier> getModifier() {
		return this.modifiers;
	}
	
	public void setModifiers(Collection<Modifier> modifiers) {
		this.modifiers = new HashSet<Modifier>(modifiers);
	}
}

