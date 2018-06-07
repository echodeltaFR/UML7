package model;

import java.util.HashSet;
import java.util.Set;

import generator.DiagramElementVisitor;

/**
 * Abstract class, an UML entity, parent of UmlComponent
 * @see UmlComponent
 * @author christian, fabien, bastien, echodeltaFR
 *
 */
public abstract class UmlEntity {
	
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
	 * Constructor of an element with visibility and modifier.
	 * @param visibility the visibility
	 * @param modifier the modifier
	 */
	public UmlEntity(Visibility visibility, Modifier modifier) {
		if (visibility == null) {
			this.visibility = Visibility.PUBLIC;
		} else {
			this.visibility = visibility;
		}
		this.modifiers = new HashSet<Modifier>();
		if (modifier != null) {
			this.modifiers.add(modifier);
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
	 * Constructor of an element with modifier.
	 * @param modifier The modifier
	 */
	public UmlEntity(Modifier modifier) {
		this(null, modifier);
	}
	
	/**
	 * Constructor of an element with visibility.
	 * @param visibility the visibility
	 */
	public UmlEntity(Visibility visibility) {
		/* HashSet instead of null enforces use of one of
		the two visibility and modifier(s) constructors. */
		this(visibility, new HashSet<Modifier>());
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

