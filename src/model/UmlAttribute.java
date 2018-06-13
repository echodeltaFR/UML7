package model;

import java.util.Set;

import exception.ExceptionInitialization;

/**
 * Representation of attributes in a UML classes diagram.
 * @author echodeltaFR
 * @version 1.3
 */
public class UmlAttribute extends UmlEntity {

    /** Name of the attribute. */
    private String name;
    
    /** Type of the attribute. */
    private UmlType type;

    // Constructors

    /**
     * Constructor. Creates an attribute in a UML diagram.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     */
    public UmlAttribute(String attrName, UmlType attrType) {
        super();
        this.name = attrName;
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
        super(attrVisi, attrModifs);
        this.name = attrName;
        this.type = attrType;
    }

    // Getters & Setters

    /**
     * Gets attribute's name.
     * @return The name of the attribute
     */
    public String getName() {
        return name;
    }

    /**
     * Gets attribute's type.
     * @return The Type of the attribute
     */
    public UmlType getType() {
        return type;
    }

    /**
     * Sets attribute's name.
     * @param attrName Given name for the attribute
     */
    public void setName(String attrName) {
        this.name = attrName;
    }

    /**
     * Sets attribute's type.
     * @param attrType Given type for the attribute
     */
    public void setType(UmlType attrType) {
        this.type = attrType;
    }

	@Override
	protected void checkVisibility(Visibility visibility) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkModifier(Modifier modifier) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkModifier(Set<Modifier> modifiers) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		
	}

}
