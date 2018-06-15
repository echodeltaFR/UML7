package model;

import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionUml;
import exception.ExceptionVisibility;
import exception.ExceptionMethode;
import exception.ExceptionModifier;
import generator.DiagramElementVisitor;


public class UmlClass extends UmlRefType{
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -3471557595290681719L;

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
	 * @throws ExceptionUml 
	 */
	public UmlClass(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) throws ExceptionUml {
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
	 * @throws ExceptionUml 
	 */
	public UmlClass(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) throws ExceptionUml {
		super(name, methods, attributes, visibility, modifiers);
		this.checkAttributes(attributes);
		this.checkMethods(methods);
		this.checkVisibility(visibility);
		this.checkModifiers(modifiers);
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
	protected void checkVisibility(Visibility visibility) throws ExceptionVisibility  {
		// TODO Auto-generated method stub
		if(visibility == Visibility.PRIVATE || visibility == Visibility.PROTECTED)
			throw new ExceptionVisibility("Class can only set access limiters to public or empty");
		
	}

	@Override
	protected void checkModifier(Modifier modifier) throws ExceptionModifier {
		// TODO Auto-generated method stub
		//String table_modifier = Modifier.ABSTRACT.toString() + Modifier.FINAL.toString();table_modifier.indexOf(Modifier.ABSTRACT.toString()) == -1
		if(modifier != Modifier.ABSTRACT && modifier != Modifier.FINAL)
			throw new ExceptionModifier("the modifier of class should be abstract or final");
		if(modifier ==  Modifier.FINAL) {
			for (int i = 0; i< this.getMethodsList().size(); i++) {
				if(this.getMethodsList().get(i).getModifiers().contains(Modifier.ABSTRACT))
					throw new ExceptionModifier("This class has an abstract method that cannot be added to the final modifier");
			}
		}
	}

	@Override
	protected void checkModifiers(Set<Modifier> modifiers) throws ExceptionModifier {
		if (modifiers != null) {
			if (modifiers.size()>1) throw new ExceptionModifier("The class may only have one of the abstract modifier or the final modifier");
			if(modifiers.contains(Modifier.FINAL)) {
				for (int i = 0; i< this.getMethodsList().size(); i++) {
					if(this.getMethodsList().get(i).getModifiers().contains(Modifier.ABSTRACT))
						throw new ExceptionModifier("This class has an abstract method that cannot be added to the final modifier");
				}
			}
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlClass) {
			return super.equals(o);
		}
		return false;
	}
}
