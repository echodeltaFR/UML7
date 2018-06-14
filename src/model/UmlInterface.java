package model;

import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionUml;
import exception.ExceptionVisibility;
import exception.ExceptionMethode;
import exception.ExceptionModifier;
import generator.DiagramElementVisitor;

/**
 * Class representing Interface type in UML, extends UmlComponent.
 * @see DiagramElementVisitor
 * @see UmlRefType
 * @see UmlEntity
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
	 * @throws ExceptionMethode 
	 */
	public UmlInterface(String name, List<UmlMethod> methods) throws ExceptionMethode {
		super(name, methods);
		this.checkMethods(methods);
		
	}
	
	/**
	 * Constructor of an interface with a name, a list of methods and a list of attributes
	 * @param name name of the interface
	 * @param methods methods of the interface
	 * @param attributes attributes of the interface
	 * @throws ExceptionAttribute 
	 * @throws ExceptionMethode 
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) throws ExceptionUml  {
		super(name, methods, attributes);
		this.checkMethods(methods);
		this.checkAttributes(attributes);
	}
	
	
	/**
	 * Constructor of an interface with a name, a list of methods, a list of attributes a visibility and a set of modifiers
	 * @param name name of the interface
	 * @param methods  methods of the interface
	 * @param attributes attributes of the interface
	 * @param visibility visibility of the interface
	 * @param modifiers a set of modifiers of the interface
	 * @throws ExceptionInitialization 
	 * @throws ExceptionMethode 
	 * @throws ExceptionAttribute 
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) throws ExceptionUml {
		super(name, methods, attributes, visibility, modifiers);
		this.checkMethods(methods);
		this.checkAttributes(attributes);
		this.checkVisibility(visibility);
		this.checkModifiers(modifiers);
		
	}
	
	//check attribute
	protected void checkAttribute(UmlAttribute attribute) throws ExceptionAttribute {
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
	protected void checkMethod(UmlMethod method) throws ExceptionMethode {
		if(method.getModifiers() == null ||
				(method.getModifiers().size()==1 &&
						method.getModifiers().contains(Modifier.ABSTRACT))) {
			} else {
				throw new ExceptionMethode("The modifier of the method should be abstract");
				}
		if(method.getVisibility() == null ||
				method.getVisibility() == Visibility.PUBLIC) {
		} else {
			throw new ExceptionMethode("The visibility of the method should be public or default");
		}
	}
	//check visibility of the interface 
	protected void checkVisibility(Visibility visibility) throws ExceptionVisibility {
		if(!(visibility == null || visibility != Visibility.PUBLIC ||
				visibility != Visibility.PACKAGE)) {
			throw new ExceptionVisibility("The visibility of the interface should be public or default");
		}
	}
	//check modifier of the interface
	protected void checkModifier(Modifier modifier) throws ExceptionModifier {
		if(!(modifier == null || modifier != Modifier.ABSTRACT)) {
			throw new ExceptionModifier("The modifier of the interface should be abstract or default");
		}
	}
	//check modifiers of the interface
	protected void checkModifiers(Set<Modifier> modifiers) throws ExceptionModifier {
		if(!(modifiers == null || (modifiers.size()==1 && modifiers.contains(Modifier.ABSTRACT)))) {
			throw new ExceptionModifier("The modifier of the interface should be abstract or default");
		}
	}
	@Override
	protected void checkAttributes(List<UmlAttribute> attributes) throws ExceptionAttribute {
		if(attributes != null ) {
			for(int i=0;i < attributes.size(); i++) {
				//check modifiers of attributes
				if(attributes.get(i).getModifiers() == null ||
					(attributes.get(i).getModifiers().size() == 2 &&
					attributes.get(i).getModifiers().contains(Modifier.FINAL) &&
					attributes.get(i).getModifiers().contains(Modifier.STATIC) ||
					(attributes.get(i).getModifiers().size() == 1 &&
					(attributes.get(i).getModifiers().contains(Modifier.FINAL) ||
					attributes.get(i).getModifiers().contains(Modifier.STATIC))))) {
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
	protected void checkMethods(List<UmlMethod> methods) throws ExceptionMethode {
		if(methods != null) {
			for(int i=0;i < methods.size(); i++) {
				//check modifiers of methods
				if(methods.get(i).getModifiers() == null ||
					(methods.get(i).getModifiers().size()==1 &&
							methods.get(i).getModifiers().contains(Modifier.ABSTRACT))) {
				} else {
					throw new ExceptionMethode("The modifier of the method should be abstract");
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
