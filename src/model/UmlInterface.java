package model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import generator.DiagramElementVisitor;

/**
 * Class representing Interface type in UML, extends UmlComponent
 * @see UmlComponent
 * @author bastien
 *
 */
public class UmlInterface extends UmlComponent {
	
	// Constructor
	
	/**
	 * Constructor of an interface with a name
	 * @param name name of the interface
	 */
	public UmlInterface(String name) {
		super(name);
	}
	
	/**
	 * Constructor of an interface with a name and a list of methods
	 * @param name name name of the interface
	 * @param methods methods of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods) 	{
		super(name, methods);
		
	}
	
	/**
	 * Constructor of an interface with a name, a list of methods and a list of attributes
	 * @param name name of the interface
	 * @param methods methods of the interface
	 * @param attributes attributes of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name, methods, attributes);
	}
	
	
	/**
	 * Constructor of an interface with a name, a list of methods, a list of attributes a visibility and a set of modifiers
	 * @param name name of the interface
	 * @param methods  methods of the interface
	 * @param attributes attributes of the interface
	 * @param visibility visibility of the interface
	 * @param modifiers a set of modifiers of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) {
		super(name, methods, attributes, visibility, modifiers);
	}
	
	@Override
	public void addAttribute(UmlAttribute attribute) {
		//throw exception
		if(check(null, null, null, null, null, attribute, null))
			super.addAttribute(attribute);
	}
	@Override
	public void addMethod(UmlMethod method) {
		if(check(null, null, null, null, null, null, method))
			super.addMethod(method);
	}
	@Override
	public void setAttributesList(List<UmlAttribute> attributesList) {
		if(check(null, attributesList, null, null, null, null, null))
			super.setAttributesList(attributesList);
	}
	@Override
	public void setMethodsList(List<UmlMethod> methodsList) {
		if(check(methodsList, null, null, null, null, null, null))
			super.setMethodsList(methodsList);
	}
	/**
	 * 	Check if the creation complies with the rules
	 * @param methods methods of the interface
	 * @param attributes attributes of the interface
	 * @param visibility visibility of the interface
	 * @param modifier modifiers of the interface
	 * @param modifiers a set of modifiers of the interface
	 * @return
	 */
	private Boolean check(List<UmlMethod> methods, 
			List<UmlAttribute> attributes,
			Visibility visibility,
			Modifier modifier,
			Set<Modifier> modifiers,
			UmlAttribute attribute,
			UmlMethod method) {
		//check methods
		if(methods != null) {
			for(int i=0;i < methods.size(); i++) {
				//check modifiers of methods
				if(methods.get(i).getModifiers() == null ||
					(methods.get(i).getModifiers().size()==1 &&
							methods.get(i).getModifiers().contains(Modifier.ABSTRACT))) {
				} else {
					return false;
				}
				//check visibility of methods
				if(methods.get(i).getVisibility() == null ||
						methods.get(i).getVisibility() == Visibility.PUBLIC ) {
				} else {
					return false;
				}
			}
		}
		//check attributes
		if(attributes != null ) {
			for(int i=0;i < attributes.size(); i++) {
				//check modifiers of attributes
				if(attributes.get(i).getModifiers() == null ||
					(attributes.get(i).getModifiers().size() == 2 &&
					attributes.get(i).getModifiers().contains(Modifier.FINAL) &&
					attributes.contains(Modifier.STATIC) ||
					(attributes.get(i).getModifiers().size() == 1 &&
					(attributes.get(i).getModifiers().contains(Modifier.FINAL) ||
					attributes.contains(Modifier.STATIC))))) {
				} else {
					return false;
				}
				//check visibility of attributes
				if(attributes.get(i).getVisibility() == null ||
						attributes.get(i).getVisibility() == Visibility.PUBLIC ) {
				} else {
					return false;
				}
			}
		}
		//check visibility of the interface 
		if(!(visibility == null || visibility != Visibility.PUBLIC)) {
			return false;
		}
		//check modifier of the interface 
		if(!(modifier == null || modifier != Modifier.ABSTRACT)) {
			return false;
		}
		//check modifiers of the interface 
		if(!(modifiers == null || (modifiers.size()==1 && modifiers.contains(Modifier.ABSTRACT)))) {
			return false;
		}
		//check visibility of attribute
		if(attribute.getVisibility() != null && attribute.getVisibility() != Visibility.PUBLIC) {
			return false;
		}
		//check modifier of attribute
		if(attribute.getModifiers() == null ||
				(attribute.getModifiers().size() == 2 &&
						attribute.getModifiers().contains(Modifier.FINAL) &&
						attribute.getModifiers().contains(Modifier.STATIC) ||
				(attribute.getModifiers().size() == 1 &&
				(attribute.getModifiers().contains(Modifier.FINAL) ||
						attribute.getModifiers().contains(Modifier.STATIC))))) {
			} else {
				return false;
			}
		//check visibility of method
		if(method.getModifiers() == null ||
				(method.getModifiers().size()==1 &&
						method.getModifiers().contains(Modifier.ABSTRACT))) {
			} else {
				return false;
			}
		//check modifier of method
		if(method.getVisibility() == null ||
				method.getVisibility() == Visibility.PUBLIC ) {
		} else {
			return false;
		}
		return true;
	}
	
	@Override
	public void accept(DiagramElementVisitor visitor) {
		visitor.visit(this);
	}
}
