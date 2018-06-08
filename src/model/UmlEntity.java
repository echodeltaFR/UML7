package model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

import generator.DiagramElementVisitor;

/**
 * Abstract class, an UML entity with a visibility and modifiers.
 * @see UmlRefType
 * @author christian, fabien, bastien, echodeltaFR
 * @version 1.2
 *
 */
public abstract class UmlEntity extends Observable {

	
	// Attributes
	
	/**
	 * Visibility of an element.
	 */
	private Visibility visibility;

	/**
	 * Element modifier.
	 */
	private Set<Modifier> modifiers;
	

	// Constructors

	
	/**
	 * Constructor of an element with visibility and modifiers.
	 * @param visibility the visibility
	 * @param modifiers the modifiers
	 */
	public UmlEntity(Visibility visibility, Set<Modifier> modifiers) {
		if (visibility == null) {
			this.visibility = Visibility.PUBLIC;
		} else {
			this.visibility = visibility;
		}
		if (modifiers == null) {
			this.modifiers = new HashSet<Modifier>();
		} else {
			this.modifiers = new HashSet<Modifier>(modifiers);
		}
	}

	/**
	 * Constructor of an element with modifiers.
	 * @param modifiers the modifiers
	 */
	public UmlEntity(Set<Modifier> modifiers) {
		this(null, new HashSet<Modifier>(modifiers));
	}

	
	/**
	 * Constructor of an element with visibility.
	 * @param visibility the visibility
	 */
	public UmlEntity(Visibility visibility) {
		this(visibility, null);
	}
	
	/**
	 * Constructor of an element by default.
	 */
	public UmlEntity() {
		this.visibility = Visibility.PUBLIC;
		this.modifiers = new HashSet<Modifier>();
	}
	
	// Methods
	
	/**
	 * Add a modifier to the modifiers set.
	 * @param modifier a modifier of the entity
	 */
	public void addModifier(Modifier modifier) {

		if (this.modifiers.add(modifier)) {
			this.setChangedAndNotify();
		}
	}
	
	/**
	 * Empty the modifiers set.
	 */
	public void clearModifiers() {
		if (! this.modifiers.isEmpty()) {
			this.modifiers.clear();
			this.setChangedAndNotify();
		}
	}
	
	/**
	 * Remove a modifier from the modifiers list.
	 * @param modifier the modifier to remove
	 */
	public void removeModifier(Modifier modifier) {
		if (this.modifiers.remove(modifier)) {
			this.setChangedAndNotify();
		}

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
		this.setChangedAndNotify();
	}
	
	/**
	 * Getter set of modifiers.
	 * @return Set<Modifier> the set of modifiers
	 */
	public Set<Modifier> getModifiers() {
		return this.modifiers;
	}
	
	/**
	 * Setter set of modifiers.
	 * @param modifiers a collection of modifiers
	 */
	public void setModifiers(Set<Modifier> modifiers) {
		this.modifiers = new HashSet<>(modifiers);
		this.setChangedAndNotify();
	}

	/**
	 * Sugar coating for calling setChanged() then notify()
	 */
	protected void setChangedAndNotify() {
		this.setChanged();
		this.notifyObservers();
	}
}
