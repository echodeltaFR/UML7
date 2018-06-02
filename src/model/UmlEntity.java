package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class, an UML entity, parent of UmlComponent
 * @see UmlComponent
 * @author christian, fabien, bastien
 *
 */
public abstract class UmlEntity{
	
	// Attributes
	
	/**
	 * Visibility of an element.
	 */
	private Visibility visibility;

	/**
	 * Element modifier.
	 */
	private Set<Modifier> modifiers;
	
	// Constructor
	
	/**
	 * Constructor of an element with visibility and modifier(s).
	 * @param visibility the visibility
	 * @param modifier the method modifier(s)
	 */
	public UmlEntity(Visibility visibility, Set<Modifier> modifier) {
		this.visibility = visibility;
		this.modifiers = new HashSet<>(modifier);
	}
	
	/**
	 * Constructor of an element with visibility.
	 * @param visibility the visibility
	 */
	public UmlEntity(Visibility visibility) {
		this.visibility = visibility;
		this.modifiers = new HashSet<>();
	}
	
	/**
	 * Constructor of an element by default.
	 */
	public UmlEntity() {
		this.visibility = Visibility.PUBLIC;
		this.modifiers = new HashSet<>();
	}
	
	// Methods
	
	/**
	 * Add a modifier to the modifiers set.
	 * @param modifier a modifier of the entity
	 */
	public void addModifier(Modifier modifier) {
		this.modifiers.add(modifier);
	}
	
	/**
	 * Clear the modifiers set.
	 */
	public void clearModifiers() {
		this.modifiers.clear();
	}
	
	/**
	 * Remove a modifier from the modifiers list.
	 * @param modifier the modifier to remove
	 */
	public void removeModifier(Modifier modifier) {
		this.modifiers.remove(modifier);
	}
	
	/**
	 * Getter visibility.
	 * @return visibility the visibility
	 */
	public Visibility getVisibility() {
		return this.visibility;
	}
	
	/**
	 * Setter visibility.
	 * @param visibility the visibility
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	
	/**
	 * Getter set of modifiers.
	 * @return Set<Modifier> the set of modifiers
	 */
	public Set<Modifier> getModifier() {
		return this.modifiers;
	}
	
	/**
	 * Setter set of modifiers.
	 * @param modifiers a collection of modifiers
	 */
	public void setModifiers(Set<Modifier> modifiers) {
		this.modifiers = new HashSet<>(modifiers);
	}
}

