package model;

import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionInitialization;
import exception.ExceptionMethode;
import generator.DiagramElementVisitor;


public class UmlClass extends UmlRefType{
	/**
	 * Constructor with a name
	 * @param name the name of the UmlClass
	 */
	public UmlClass(String name) {
		super(name);
	}
	
	/**
	 * Constructor with a name and a list of methods
	 * @param name the name of the UmlClass
	 * @param methods all of methods of the UmlClass
	 */
	public UmlClass(String name, List<UmlMethod> methods) {
		super(name, methods);
	}
	
	/**
	 * Constructor with a name, a list of methods and a list of attributes
	 * @param name the name of the component
	 * @param methods all of methods of the UmlClass
	 * @param attributes all of attributes of the UmlClass
	 */
	public UmlClass(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name, methods, attributes);
	}
	/**
	 * Constructor with a name, a list of methods, a list of attributes, a visibility and a set of modifiers
	 * @param name the name of the component
	 * @param methods all of methods of the UmlClass
	 * @param attributes all of attributes of the UmlClass
	 * @param visibility visibility of the component
	 * @param modifiers modifiers of the component
	 */
	public UmlClass(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) {
		super(name, methods, attributes, visibility, modifiers);
	}
	/*private Boolean check(List<UmlMethod> methods, 
			List<UmlAttribute> attributes,
			Visibility visibility,
			Modifier modifier,
			Set<Modifier> modifiers,
			UmlAttribute attribute,
			UmlMethod method) {
		//check visibility of the Class
		if(visibility != null && visibility != Visibility.PUBLIC && visibility != Visibility.PACKAGE) {
			return false;
		}
		//check the conflict between final and abstract
		if(modifiers.contains(Modifier.FINAL) || modifier == Modifier.FINAL) {
			//check class
			if(modifiers.contains(Modifier.ABSTRACT))
				return false;
			//check attributes
			for(int i = 0; i < attributes.size(); i++) {
				if(attributes.get(i).getModifiers().contains(Modifier.ABSTRACT)) {
					return false;
				}
			}
			//check methods
			for(int i = 0; i < methods.size(); i++) {
				if(methods.get(i).getModifiers().contains(Modifier.ABSTRACT)) {
					return false;
				}
			}
		}
		
		return true;
	}*/
	
	@Override
	public void accept(DiagramElementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	protected void checkAttribute(UmlAttribute attribute) throws ExceptionAttribute {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkAttributes(List<UmlAttribute> attributes) throws ExceptionAttribute {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkMethod(UmlMethod method) throws ExceptionMethode {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkMethods(List<UmlMethod> methods) throws ExceptionMethode {
		// TODO Auto-generated method stub
		
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
