
public abstract class UmlEntity extends UmlLabeledElement{

	private Visibility visibility;
	private ArrayList<Modifier> modifier;
	
	public UmlEntity(Visibility visibility, ArrayListe<Modifier> modifier) {
		this.visibility = visibility;
		this.modifier = modifier;
	}
	
	public void addModifier(Modifer modifier) {
		this.modifier.add(modifier);
	}
	
	public void clearModifiers() {
		for(int i = 0; this.modifier.size(); i++) {
			this.modifier.remove(this.modifier.get(i)); 
		}
	}
	
	public void removeModifier(Modifier modifier) {
		this.modifier.remove(modifier);
	}
	
	public Visibility getVisibility() {
		return this.visibility;
	}
	
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
}
