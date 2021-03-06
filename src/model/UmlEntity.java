package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

import exception.ExceptionVisibility;
import exception.ExceptionModifier;

/**
 * Abstract class, an UML entity with a visibility and modifiers.
 * @see Visibility
 * @see Modifier
 * @author christian, fabien, bastien, echodeltaFR
 * @version 1.2
 *
 */
public abstract class UmlEntity extends Observable implements Serializable {

	/**
	 * generated serial ID
	 */
	private static final long serialVersionUID = 5120529213137305290L;

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
	public UmlEntity(String name, Visibility visibility, Set<Modifier> modifiers) throws IllegalArgumentException{
		if (name == null) throw new IllegalArgumentException("Name can't be null");
		if (name.trim().isEmpty()) throw new IllegalArgumentException("Name can't be empty");
		if (name.contains(" ")) throw new IllegalArgumentException("Name can't contain spaces");
		this.name = name;
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
	public UmlEntity(String name, Set<Modifier> modifiers) throws IllegalArgumentException {
		this(name, null, new HashSet<>(modifiers));
	}

	
	/**
	 * Constructor of an element with visibility.
	 * @param name Name of the element
	 * @param visibility Visibility of the element
	 */
	public UmlEntity(String name, Visibility visibility) throws IllegalArgumentException {
		this(name, visibility, null);
	}
	
	/**
	 * Constructor of an element by default.
	 * @param name Name of the element
	 */
	public UmlEntity(String name) {
		if (name == null) throw new IllegalArgumentException("Name can't be null");
		if (name.trim().isEmpty()) throw new IllegalArgumentException("Name can't be empty");
		if (name.contains(" ")) throw new IllegalArgumentException("Name can't contain spaces");
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
//		String name_ = "class_1";
//		String pt = "[a-zA-Z_$].[a-zA-Z_$0-9]*";
//		if(!Pattern.matches(pt, name_))throw new IllegalArgumentException("Does not meet the naming convention");
		this.setChangedAndNotify();
	}

	/**
	 * Add a modifier to the modifiers set.
	 * @throws ExceptionInitialization 
	 * @param modifier A modifier to add to the element
	 */
	public void addModifier(Modifier modifier) throws ExceptionModifier {
		Set<Modifier> temp= new HashSet<>();
		temp=this.getModifiers();
		temp.add(modifier);
		this.checkModifiers(temp);
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
	
	/**
	 * Method to check if the given visibility is valid for the current entity.
	 * @param visibility
	 * 		The visibility that would be set.
	 * @throws ExceptionVisibility
	 * 		if the visibility is not valid.
	 */
	protected abstract void checkVisibility(Visibility visibility) throws ExceptionVisibility;
	
	/**
	 * Method to check if the modifier could be added without issue.
	 * @param modifier
	 * 		The modifier that would be added.
	 * @throws ExceptionModifier
	 * 		if the modifier can't be added
	 */
	protected abstract void checkModifier(Modifier modifier) throws ExceptionModifier;
	
	/**
	 * Method to check if all modifier could be added without issue.
	 * @param modifiers
	 * 		The modifiers that would be added.
	 * @throws ExceptionModifier
	 * 		if the modifiers can't all be added.
	 */
	protected abstract void checkModifiers(Set<Modifier> modifiers) throws ExceptionModifier;
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlEntity) {
			UmlEntity e = (UmlEntity) o;
			if (
					e.modifiers.equals(this.modifiers) &&
					e.name.equals(this.name) &&
					e.visibility.equals(this.visibility)
					) {
				return true;
			}
		}
		return false;
	}
}
