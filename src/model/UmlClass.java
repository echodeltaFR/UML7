package model;

public class UmlClass {
	/**
	 *le Nom de class
	 */
	private String className;
//	private ArrayList<UmlMethod> umlMethod;
//	private ArrayList<UmlAttribute> umlAttribute;
//	private ArrayList<Modifier> modifier;
	/**
	 * le stractu
	 * @param name le Nom de class
	 */
	public UmlClass(String name) {
//		umlMethod = new ArrayList<UmlMethod>();
//		umlAttribute = new ArrayList<UmlAttribute>;
		className = name;
	}
	public void setName(String name) {

		className = name;
	}
	public String getName() {
		return className;
	}
//	public 	void addMethod(Umlmethod method) {
//		umlMethod.add(method);
//	}
//	public 	void addAttribute(UmlAttribute attribute) {
//		umlAttribute.add(attribute);
//	}
//	
//	public addModifier(Modifier m) {
//		modifier.add(m);
//	}
	
}
