package model;
/**
 * Rerpesentation of attributes in
 * a UML classes diagram.
 * @author echodeltaFR
 * @version 1.2
 */
public class UmlAttribute extends UmlEntity{

    /** Name of the attribute. */
    private String name;
    /** Type of the attribute. */
    private String type;

    /**
     * Constructor. Creates an attribute in a
     * UML diagram.
     * @param attrName Name of the attribute to create
     * @param attrType Type of the attribute to create
     */
    public UmlAttribute(String attrName, String attrType) {
        this.name = attrName;
        this.type = attrType;
    }

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
    public String getType() {
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
    public void setType(String attrType) {
        this.type = attrType;
    }

}