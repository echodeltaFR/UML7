package view;

import model.UmlAttribute;
import model.UmlComponent;
import model.UmlEnum;
import model.UmlInterface;
import model.UmlMethod;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the visual representation of an UML Object (e.g. a class, an interface...).<br>
 * It is a JPanel with added functionality to automatically update it's content to match
 * a given UmlComponent.
 *
 * <b>ATTENTION:</b> while this object is a JPanel and have all JPanel methods, it is 
 * discouraged to use them.
 */
public class UMLObjectDisplay extends JPanel {
	
	/** The yellow,wide border of a class */
	private static final Border umlObjectBorders = BorderFactory.createLineBorder(
			new Color(250, 240, 50),
			2);
	
	/** The represented object */
	private UmlComponent umlobject;
	
	/** The inner label that display the name*/
	private JLabel classname;
	
	/** The inner AttributeDisplays that shows the backed object's attributes */
	private List<AttributeDisplay> attributes;
	
	/** the container of the attribute displays */
	private JPanel attributeContainer;
	
	/** The inner MethodDisplays that shows the backed object's methods*/
	private List<MethodDisplay> methods;

	/** the container of the function/method displays */
	private JPanel functionContainer;
	
	/**
	 * Construct a new UMLObjectDisplay backed by an UmlComponent and 
	 * potentially display an archetype.
	 * @param umlobject
	 * 		The (non null) object to visually represent
	 * @param specialType
	 * 		The archetype to display, or null if there is no archetype
	 */
	private UMLObjectDisplay(UmlComponent umlobject, String specialType) {
		super();
		
		if (umlobject == null) throw new IllegalArgumentException("uml object can't be null");
		
		//creating object attributes
		this.umlobject = umlobject;
		this.attributes = new ArrayList<AttributeDisplay>();
		this.methods = new ArrayList<MethodDisplay>();
		
		//Creating Swing architecture
		this.buildSwingArchitecture(specialType);
		
		//Filling Swing display
		this.updateDisplay();
	}
	
	/**
	 * Build a display for a generic UmlComponent
	 * @param c
	 * 		The uml component to display
	 */
	public UMLObjectDisplay(UmlComponent c) {
		this(c,null);
	}
	
	/**
	 * Build a display for an interface.<br>
	 * Will add "<<interface>>" above the class name.
	 * @param i
	 * 		The interface to display
	 */
	public UMLObjectDisplay(UmlInterface i) {
		this(i,"interface");
	}
	
	/**
	 * Build a display for an enum.<br>
	 * Will add "<<enum>>" above the class name.
	 * @param e
	 * 		The enum to display
	 */
	public UMLObjectDisplay(UmlEnum e) {
		this(e, "enum");
	}

	/**
	 * Generate the inner SWING Architecture of this JPanel to properly display
	 * an UML Object.
	 */
	private void buildSwingArchitecture(String specialType) {
		this.setLayout(new BorderLayout());
		this.setBorder(umlObjectBorders);
		this.classname = new JLabel();
		classname.setHorizontalAlignment(JLabel.CENTER);;
		
		//Creating title area
		JPanel titleArea = new JPanel(new BorderLayout());
		titleArea.setBorder(umlObjectBorders);
		titleArea.add(this.classname,BorderLayout.CENTER);
		if (specialType != null) {
			JLabel archetype = new JLabel("<<"+specialType+">>");
			archetype.setHorizontalAlignment(JLabel.CENTER);
			titleArea.add(archetype, BorderLayout.NORTH);
		}
		
		this.add(titleArea, BorderLayout.NORTH);
		
		//Content has 2 categories : attributes and methods/functions
		JPanel listsContainer = new JPanel(new GridLayout(2, 0));
		listsContainer.setBorder(umlObjectBorders);
		
		this.attributeContainer = new JPanel();
		attributeContainer.setLayout(new BoxLayout(attributeContainer,BoxLayout.Y_AXIS));
		attributeContainer.setBorder(umlObjectBorders);
		
		this.functionContainer = new JPanel();
		functionContainer.setLayout(new BoxLayout(functionContainer,BoxLayout.Y_AXIS));
		functionContainer.setBorder(umlObjectBorders);
		
		listsContainer.add(attributeContainer);
		listsContainer.add(functionContainer);
		
		this.add(listsContainer, BorderLayout.CENTER);
	}
	
	/**
	 * Refresh this element to match it's backed object.
	 */
	private void updateDisplay() {
		this.classname.setText(this.umlobject.getName());
		this.updateAttribute();
		this.updateMethods();
	}
	
	/**
	 * Update the list of displayed methods
	 */
	private void updateMethods() {
		List<UmlMethod> objectMethods = new ArrayList<UmlMethod>(this.umlobject.getMethodsList());
		List<UmlMethod> foundMethods = new ArrayList<UmlMethod>();
		for (MethodDisplay methodDisp : this.methods) {
			if (! objectMethods.contains(methodDisp.getMethod())) {
				//Method was removed
				this.functionContainer.remove(methodDisp);
			} else {
				//Still present, update text and add to found list
				methodDisp.updateLabel();
				foundMethods.add(methodDisp.getMethod());
			}
		}
		
		//All display of removed methods removed, other updated, adding new methods
		objectMethods.removeAll(foundMethods);
		for (UmlMethod newMethod : objectMethods) {
			MethodDisplay disp = new MethodDisplay(newMethod);
			this.methods.add(disp);
			this.functionContainer.add(disp);
		}
	}
	
	/**
	 * Update the list of displayed attributes
	 */
	private void updateAttribute() {
		List<UmlAttribute> objectAttributes = new ArrayList<UmlAttribute>(this.umlobject.getAttributesList());
		List<UmlAttribute> foundAttributes = new ArrayList<UmlAttribute>();
		for (AttributeDisplay attrDisp : this.attributes) {
			if (! objectAttributes.contains(attrDisp.getAttribute())) {
				//Method was removed
				this.functionContainer.remove(attrDisp);
			} else {
				//Still present, update text and add to found list
				attrDisp.updateLabel();
				foundAttributes.add(attrDisp.getAttribute());
			}
		}
		
		//All display of removed methods removed, other updated, adding new methods
		objectAttributes.removeAll(foundAttributes);
		for (UmlAttribute newAttr : objectAttributes) {
			AttributeDisplay disp = new AttributeDisplay(newAttr);
			this.attributes.add(disp);
			this.attributeContainer.add(disp);
		}
	}
}
