package model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

import exception.ExceptionUml;
import exception.ExceptionVisibility;
import exception.ExceptionInitialization;
import exception.ExceptionModifier;

/**
 * Abstract class, an UML entity with a visibility and modifiers.
 * @see Visibility
 * @see Modifier
 * @author christian, fabien, bastien, echodeltaFR
 * @version 1.2
 *
 */
public abstract class UmlEntity extends Observable {

	
	// Attributes

	/** Name of an element. */
	private String name;

	/** Visibility of an element. */
	private Visibility visibility;

	/** Element modifier. */
	private Set<Modifier> modifiers;

	// Constructors
	
	/**
	 * Constructor of an element with visibility and modifiers.
	 * @param name Name of the element
	 * @param visibility Visibility of the element
	 * @param modifiers Set of modifiers of the element
	 */
	public UmlEntity(String name, Visibility visibility, Set<Modifier> modifiers) {
		this.name = name;
		if (visibility == null) {
			this.visibility = Visibility.PUBLIC;
		} else {
			this.visibility = visibility;
		}
		if (modifiers == null) {
			this.modifiers = new HashSet<>();
		} else {
			this.modifiers = new HashSet<>(modifiers);
		}
	}

	/**
	 * Constructor of an element with modifiers.
	 * @param name Name of the element
	 * @param modifiers Set modifiers of an element
	 */
	public UmlEntity(String name, Set<Modifier> modifiers) {
		this(name, null, new HashSet<>(modifiers));
	}

	
	/**
	 * Constructor of an element with visibility.
	 * @param name Name of the element
	 * @param visibility Visibility of the element
	 */
	public UmlEntity(String name, Visibility visibility) {
		this(name, visibility, null);
	}
	
	/**
	 * Constructor of an element by default.
	 * @param name Name of the element
	 */
	public UmlEntity(String name) {
		this.name = name;
		this.visibility = Visibility.PUBLIC;
		this.modifiers = new HashSet<>();
	}
	
	// Methods

	/**
	 * Get element name.
	 * @return The name of the element
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set element name.
	 * @param name 
	 */
	public void setName(String name) {
		if (name == null) throw new IllegalArgumentException("Name can't be null");
		if (name.trim().isEmpty()) throw new IllegalArgumentException("Name can't be empty");
		if (name.contains(" ")) throw new IllegalArgumentException("Name can't contain spaces");
		this.name = name;
		this.setChangedAndNotify();
	}

	/**
	 * Add a modifier to the modifiers set.
	 * @throws ExceptionInitialization 
	 * @param modifier A modifier to add to the element
	 */
	public void addModifier(Modifier modifier) throws ExceptionModifier {
		this.checkModifier(modifier);
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
	 * @param modifier The modifier to remove from the element
	 */
	public void removeModifier(Modifier modifier) {
		if (this.modifiers.remove(modifier)) {
			this.setChangedAndNotify();
		}

	}
	
	/**
	 * Getter visibility.
	 * @return The visibility of the element
	 */
	public Visibility getVisibility() {
		return this.visibility;
	}
	
	/**
	 * Setter visibility.
	 * @throws ExceptionInitialization 
	 * @param visibility The visibility to set
	 * @throws ExceptionVisibility 
	 */
	public final void setVisibility(Visibility visibility) throws ExceptionVisibility  {
		this.checkVisibility(visibility);
		this.visibility = visibility;
		this.setChangedAndNotify();
	}
	
	/**
	 * Getter set of modifiers.
	 * @return The set of modifiers of the element
	 */
	public final Set<Modifier> getModifiers() {
		return this.modifiers;
	}
	
	/**
	 * Setter set of modifiers.
	 * @throws ExceptionInitialization 
	 * @param modifiers A set of modifiers
	 */
	public final void setModifiers(Set<Modifier> modifiers) throws ExceptionModifier {
		this.checkModifiers(modifiers);
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
	protected abstract void checkVisibility(Visibility visibility) throws ExceptionVisibility;
	protected abstract void checkModifier(Modifier modifier) throws ExceptionModifier;
	protected abstract void checkModifiers(Set<Modifier> modifiers) throws ExceptionModifier;
}
