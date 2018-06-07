package model;

import java.util.Set;

/**
 * Representation of attributes in
 * a UML classes diagram.
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
     * Constructor. Creates an attribute in a
     * UML diagram.
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
     * with visibility.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     * @param attrVisi Visibility of the attribute to create
     */
    public UmlAttribute(String attrName, UmlType attrType, Visibility attrVisi) {
        super(attrVisi);
        this.name = attrName;
        this.type = attrType;
    }

    /**
     * Constructor. Creates an attribute in a UML diagram
     * with modifier.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     * @param attrModif Modifier of the attrbiute to create
     */
    public UmlAttribute(String attrName, UmlType attrType, Modifier attrModif) {
        super(attrModif);
        this.name = attrName;
        this.type = attrType;
    }

    /**
     * Constructor. Creates an attribute in a UML diagram
     * with modifiers.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     * @param attrModifs Modifiers of the attrbiute to create
     */
    public UmlAttribute(String attrName, UmlType attrType, Set<Modifier> attrModifs) {
        super(attrModifs);
        this.name = attrName;
        this.type = attrType;
    }

    /**
     * Constructor. Creates an attribute in a UML diagram
     * with visibility and modifier.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     * @param attrVisi Visibility of the attribute to create
     * @param attrModif Modifier of the attrbiute to create
     */
    public UmlAttribute(String attrName, UmlType attrType, Visibility attrVisi, Modifier attrModif) {
        super(attrVisi, attrModif);
        this.name = attrName;
        this.type = attrType;
    }

    /**
     * Constructor. Creates an attribute in a UML diagram
     * with visibility and modifiers.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     * @param attrVisi Visibility of the attribute to create
     * @param attrModifs Modifier of the attribute to create
     */
    public UmlAttribute(String attrName, UmlType attrType, Visibility attrVisi, Modifier attrModifs) {
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

}