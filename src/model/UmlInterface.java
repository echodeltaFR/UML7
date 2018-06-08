package model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import exception.ExceptionInitialization;
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
		try {
			this.checkMethods(methods);
		} catch(ExceptionInitialization e) {
			
		}

	}
	
	/**
	 * Constructor of an interface with a name, a list of methods and a list of attributes
	 * @param name name of the interface
	 * @param methods methods of the interface
	 * @param attributes attributes of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name, methods, attributes);
		try {
			this.checkMethods(methods);
			this.checkAttributes(attributes);
		} catch(ExceptionInitialization e) {
			
		}
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
		try {
			this.checkMethods(methods);
			this.checkAttributes(attributes);
			this.checkVisibility(visibility);
			this.checkModifier(modifiers);
		} catch(ExceptionInitialization e) {
			
		}
	}
	
	@Override
	public void addAttribute(UmlAttribute attribute) {
		//throw exception
		try {
			this.checkAttribute(attribute);
		} catch(ExceptionInitialization e) {
			
		}
		super.addAttribute(attribute);
	}
	@Override
	public void addMethod(UmlMethod method) {
		try {
			this.checkMethod(method);
		} catch(ExceptionInitialization e) {
			
		}
		super.addMethod(method);
	}
	@Override
	public void setAttributesList(List<UmlAttribute> attributesList) {
		try {
			this.checkAttributes(attributesList);
		} catch(ExceptionInitialization e) {
			
		}
		super.setAttributesList(attributesList);
	}
	@Override
	public void setMethodsList(List<UmlMethod> methodsList) {
		try {
			this.checkMethods(methodsList);
		} catch(ExceptionInitialization e) {
			
		}
		super.setMethodsList(methodsList);
	}
	
	//check attribute
	private void checkAttribute(UmlAttribute attribute) throws ExceptionInitialization {
		if(attribute.getVisibility() != null && attribute.getVisibility() != Visibility.PUBLIC) {
			throw new ExceptionInitialization("The visibility of the attribute should be public or default");
		}
		if(attribute.getModifier() == null ||
				(attribute.getModifier().size() == 2 &&
				attribute.getModifier().contains(Modifier.FINAL) &&
				attribute.getModifier().contains(Modifier.STATIC) ||
		(attribute.getModifier().size() == 1 &&
		(attribute.getModifier().contains(Modifier.FINAL) ||
				attribute.getModifier().contains(Modifier.STATIC))))) {
		} else {
			throw new ExceptionInitialization("The modifier of the attribute should be final static or default");
		}
	}
	//check method
	private void checkMethod(UmlMethod method) throws ExceptionInitialization {
		if(method.getModifier() == null ||
				(method.getModifier().size()==1 &&
						method.getModifier().contains(Modifier.ABSTRACT))) {
			} else {
				throw new ExceptionInitialization("The modifier of the method should be final static or default");
				}
		if(method.getVisibility() == null ||
				method.getVisibility() == Visibility.PUBLIC ) {
		} else {
			throw new ExceptionInitialization("The visibility of the method should be public or default");
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
	private void checkAttributes(List<UmlAttribute> attributes) throws ExceptionInitialization{
		if(attributes != null ) {
			for(int i=0;i < attributes.size(); i++) {
				//check modifiers of attributes
				if(attributes.get(i).getModifier() == null ||
					(attributes.get(i).getModifier().size() == 2 &&
					attributes.get(i).getModifier().contains(Modifier.FINAL) &&
					attributes.contains(Modifier.STATIC) ||
					(attributes.get(i).getModifier().size() == 1 &&
					(attributes.get(i).getModifier().contains(Modifier.FINAL) ||
					attributes.contains(Modifier.STATIC))))) {
				} else {
					throw new ExceptionInitialization("The modifier of the attribute should be final static or default");
				}
				//check visibility of attributes
				if(attributes.get(i).getVisibility() == null ||
						attributes.get(i).getVisibility() == Visibility.PUBLIC ) {
				} else {
					throw new ExceptionInitialization("The visibility of the attribute should be public or default");
				}
			}
		}
	}
	private void checkMethods(List<UmlMethod> methods) throws ExceptionInitialization{
		if(methods != null) {
			for(int i=0;i < methods.size(); i++) {
				//check modifiers of methods
				if(methods.get(i).getModifier() == null ||
					(methods.get(i).getModifier().size()==1 &&
							methods.get(i).getModifier().contains(Modifier.ABSTRACT))) {
				} else {
					throw new ExceptionInitialization("The modifier of the method should be final static or default");
				}
				//check visibility of methods
				if(methods.get(i).getVisibility() == null ||
						methods.get(i).getVisibility() == Visibility.PUBLIC ) {
				} else {
					throw new ExceptionInitialization("The modifier of the attribute should be final static or default");
				}
			}
		}
	}
	@Override
	public void accept(DiagramElementVisitor visitor) {
		visitor.visit(this);
	}
}
