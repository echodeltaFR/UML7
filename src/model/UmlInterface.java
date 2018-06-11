package model;

import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionComposition;
import exception.ExceptionInitialization;
import exception.ExceptionMethode;
import generator.DiagramElementVisitor;

/**
 * Class representing Interface type in UML, extends UmlComponent
 * @see UmlRefType
 * @author bastien
 *
 */
public class UmlInterface extends UmlRefType {
	
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
//		try {
//			this.checkMethods(methods);
//		} catch(ExceptionInitialization e) {
//			
//		}

	}
	
	/**
	 * Constructor of an interface with a name, a list of methods and a list of attributes
	 * @param name name of the interface
	 * @param methods methods of the interface
	 * @param attributes attributes of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name, methods, attributes);
//		try {
//			this.checkMethods(methods);
//			this.checkAttributes(attributes);
//		} catch(ExceptionInitialization e) {
//			
//		}
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
//		this.checkMethods(methods);
//		this.checkAttributes(attributes);
//		this.checkVisibility(visibility);
//		this.checkModifier(modifiers);
		
	}
	
	@Override
	public void addAttribute(UmlAttribute attribute) {
		//throw exception
		/**try {
			this.checkAttribute(attribute);
		} catch(ExceptionInitialization e) {
			
		}
		super.addAttribute(attribute);**/
	}
	public void addMethod(UmlMethod method) {
		/**this.checkMethod(method);
		super.addMethod(method);**/
	}
	public void setAttributesList(List<UmlAttribute> attributesList) {
		//this.checkAttributes(attributesList);
		super.setAttributesList(attributesList);
	}
	public void setMethodsList(List<UmlMethod> methodsList) {	
		//this.checkMethods(methodsList);
		super.setMethodsList(methodsList);
	}
	
	//check attribute
	private void checkAttribute(UmlAttribute attribute) throws ExceptionAttribute {
		if(attribute.getVisibility() != null && attribute.getVisibility() != Visibility.PUBLIC) {
			throw new ExceptionAttribute("The visibility of the attribute should be public or default");
		}
		if(attribute.getModifiers() == null ||
				(attribute.getModifiers().size() == 2 &&
				attribute.getModifiers().contains(Modifier.FINAL) &&
				attribute.getModifiers().contains(Modifier.STATIC) ||
		(attribute.getModifiers().size() == 1 &&
		(attribute.getModifiers().contains(Modifier.FINAL) ||
				attribute.getModifiers().contains(Modifier.STATIC))))) {
		} else {
			throw new ExceptionAttribute("The modifier of the attribute should be final static or default");
		}
	}
	//check method
	private void checkMethod(UmlMethod method) throws ExceptionMethode {
		if(method.getModifiers() == null ||
				(method.getModifiers().size()==1 &&
						method.getModifiers().contains(Modifier.ABSTRACT))) {
			} else {
				throw new ExceptionMethode("The modifier of the method should be final static or default");
				}
		if(method.getVisibility() == null ||
				method.getVisibility() == Visibility.PUBLIC ) {
		} else {
			throw new ExceptionMethode("The visibility of the method should be public or default");
		}
	}
	//check visibility of the interface 
	private void checkVisibility(Visibility visibility) throws ExceptionInitialization {
		if(!(visibility == null || visibility != Visibility.PUBLIC)) {
			throw new ExceptionInitialization("The visibility of the interface should be public or default");
		}
	}
	//check modifier of the interface
	private void checkModifier(Modifier modifier) throws ExceptionInitialization {
		if(!(modifier == null || modifier != Modifier.ABSTRACT)) {
			throw new ExceptionInitialization("The modifier of the interface should be abstract or default");
		}
	}
	//check modifiers of the interface
	private void checkModifier(Set<Modifier> modifiers) throws ExceptionInitialization {
		if(!(modifiers == null || (modifiers.size()==1 && modifiers.contains(Modifier.ABSTRACT)))) {
			throw new ExceptionInitialization("The modifier of the interface should be abstract or default");
		}
	}
	private void checkAttributes(List<UmlAttribute> attributes) throws ExceptionAttribute{
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
					throw new ExceptionAttribute("The modifier of the attribute should be final static or default");
				}
				//check visibility of attributes
				if(attributes.get(i).getVisibility() == null ||
						attributes.get(i).getVisibility() == Visibility.PUBLIC ) {
				} else {
					throw new ExceptionAttribute("The visibility of the attribute should be public or default");
				}
			}
		}
	}
	private void checkMethods(List<UmlMethod> methods) throws ExceptionMethode{
		if(methods != null) {
			for(int i=0;i < methods.size(); i++) {
				//check modifiers of methods
				if(methods.get(i).getModifiers() == null ||
					(methods.get(i).getModifiers().size()==1 &&
							methods.get(i).getModifiers().contains(Modifier.ABSTRACT))) {
				} else {
					throw new ExceptionMethode("The modifier of the method should be final static or default");
				}
				//check visibility of methods
				if(methods.get(i).getVisibility() == null ||
						methods.get(i).getVisibility() == Visibility.PUBLIC ) {
				} else {
					throw new ExceptionMethode("The visibility of the attribute should be final static or default");
				}
			}
		}
	}
	
	@Override
	public void accept(DiagramElementVisitor visitor) {
		visitor.visit(this);
	}
}
