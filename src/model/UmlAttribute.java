package model;

import java.util.HashSet;
import java.util.Set;
import exception.ExceptionModifier;
import exception.ExceptionVisibility;

/**
 * Representation of attributes in a UML classes diagram.
 * @author echodeltaFR
 * @see UmlEntity
 * @see Visibility
 * @see Modifier
 * @version 1.3
 */
public class UmlAttribute extends UmlEntity {
    
    /**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -3165621216117722756L;
	
	/** Type of the attribute. */
    private UmlType type;
    // Constructors

    /**
     * Constructor. Creates an attribute in a UML diagram.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     */
    public UmlAttribute(String attrName, UmlType attrType) {
        super(attrName);
        this.type = attrType;
    }

    /**
     * Constructor. Creates an attribute in a UML diagram
     * with visibility and modifiers.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     * @param attrVisi Visibility of the attribute to create
     * @param attrModifs Modifiers of the attribute to create
     */
    public UmlAttribute(String attrName, UmlType attrType, Visibility attrVisi, Set<Modifier> attrModifs) {
        super(attrName, attrVisi, attrModifs);
        this.type = attrType;
    }

    // Getters & Setters

    /**
     * Gets attribute's type.
     * @return The Type of the attribute
     */
    public UmlType getType() {
        return type;
    }

    /**
     * Sets attribute's type.
     * @param attrType Given type for the attribute
     */
    public void setType(UmlType attrType) {
        this.type = attrType;
        setChangedAndNotify();
    }

	@Override
	protected void checkVisibility(Visibility visibility) throws ExceptionVisibility {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkModifier(Modifier modifier) throws ExceptionModifier {
		// TODO Auto-generated method stub
		if(modifier == Modifier.ABSTRACT)
			throw new ExceptionModifier("Attribute cannot be set to abstract");
	}

	@Override
	protected void checkModifiers(Set<Modifier> modifiers) throws ExceptionModifier {
		// TODO Auto-generated method stub
		if(modifiers.contains(Modifier.ABSTRACT))
			throw new ExceptionModifier("Attribute cannot be set to abstract");
		if(modifiers.contains(Modifier.FINAL) && modifiers.contains(Modifier.VOLATILE))
			throw new ExceptionModifier("the modifier of attribute conflicts");
	}

	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlAttribute) {
			UmlAttribute a = (UmlAttribute) o;
			if ( 
					a.getName().equals(this.getName()) &&
					a.getModifiers().equals(this.getModifiers()) &&
					a.getVisibility().equals(this.getVisibility()) &&
 					a.type.equals(this.type)
					) {
				return true;
			}
		}
		return false;
	}
}
