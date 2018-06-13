package model;

import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionComposition;
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
	 * @throws ExceptionMethode 
	 */
	public UmlClass(String name, List<UmlMethod> methods) throws ExceptionMethode {
		super(name, methods);
		this.checkMethods(methods);
	}
	
	/**
	 * Constructor with a name, a list of methods and a list of attributes
	 * @param name the name of the component
	 * @param methods all of methods of the UmlClass
	 * @param attributes all of attributes of the UmlClass
	 * @throws ExceptionComposition 
	 */
	public UmlClass(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) throws ExceptionComposition {
		super(name, methods, attributes);
		this.checkAttributes(attributes);
		this.checkMethods(methods);
	}
	/**
	 * Constructor with a name, a list of methods, a list of attributes, a visibility and a set of modifiers
	 * @param name the name of the component
	 * @param methods all of methods of the UmlClass
	 * @param attributes all of attributes of the UmlClass
	 * @param visibility visibility of the component
	 * @param modifiers modifiers of the component
	 * @throws ExceptionComposition 
	 */
	public UmlClass(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) throws ExceptionComposition {
		super(name, methods, attributes, visibility, modifiers);
		this.checkAttributes(attributes);
		this.checkMethods(methods);
		this.checkVisibility(visibility);
		this.checkModifier(modifiers);
	}
	
	@Override
	public void accept(DiagramElementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	protected void checkAttribute(UmlAttribute attribute) throws ExceptionAttribute {
		// TODO Auto-generated method stub
		if(attribute.getModifiers().contains(Modifier.ABSTRACT))
			throw new ExceptionAttribute("Member variable cannot be set to abstract");
	}

	@Override
	protected void checkAttributes(List<UmlAttribute> attributes) throws ExceptionAttribute {
		// TODO Auto-generated method stub
		for(int i = 0 ;i < attributes.size(); i++) {
			if(attributes.get(i).getModifiers().contains(Modifier.ABSTRACT))
				throw new ExceptionAttribute("Member variable cannot be set to abstract");
		}
	}

	@Override
	protected void checkMethod(UmlMethod method) throws ExceptionMethode {
		// TODO Auto-generated method stub
		if(!this.getModifiers().contains(Modifier.ABSTRACT) && method.getModifiers().contains(Modifier.ABSTRACT))
			throw new ExceptionMethode("Normal classes cannot include abstract methods");
	}

	@Override
	protected void checkMethods(List<UmlMethod> methods) throws ExceptionMethode {
		// TODO Auto-generated method stub
		if(!this.getModifiers().contains(Modifier.ABSTRACT)) {
			for(int i = 0 ;i < methods.size(); i++) {
				if(methods.get(i).getModifiers().contains(Modifier.ABSTRACT))
					throw new ExceptionMethode("Normal classes cannot include abstract methods");
			}
		}
	}

	@Override
	protected void checkVisibility(Visibility visibility) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		if(visibility == Visibility.PRIVATE || visibility == Visibility.PROTECTED)
			throw new ExceptionInitialization("Class can only set access limiters to public or defaut");
		
	}

	@Override
	protected void checkModifier(Modifier modifier) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		//String table_modifier = Modifier.ABSTRACT.toString() + Modifier.FINAL.toString();table_modifier.indexOf(Modifier.ABSTRACT.toString()) == -1
		if(modifier != Modifier.ABSTRACT && modifier != Modifier.FINAL)
			throw new ExceptionInitialization("the modifier of class should be abstract or final");
		if(modifier ==  Modifier.FINAL) {
			for (int i = 0; i< this.getMethodsList().size(); i++) {
				if(this.getMethodsList().get(i).getModifiers().contains(Modifier.ABSTRACT))
					throw new ExceptionInitialization("This class has an abstract method that cannot be added to the final modifier");
			}
		}
	}

	@Override
	protected void checkModifier(Set<Modifier> modifiers) throws ExceptionInitialization {
		if (modifiers.size()>1) throw new ExceptionInitialization("The class may only have one of the abstract modifier or the final modifier");
		if(modifiers.contains(Modifier.FINAL)) {
			for (int i = 0; i< this.getMethodsList().size(); i++) {
				if(this.getMethodsList().get(i).getModifiers().contains(Modifier.ABSTRACT))
					throw new ExceptionInitialization("This class has an abstract method that cannot be added to the final modifier");
			}
		}
	}
	
}
