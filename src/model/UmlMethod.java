package model;
import java.util.Collections;
import java.util.List;

/**
 * La classe permettant de créer une méthode.
 * @author fmeslet
 * @version 1.0
 */
public class UmlMethod extends UmlEntity{

	/**
	 * Paramètre de la méthode.
	 */
	private ArrayList<String> params;
	/**
	 * Type de retour de la méthode.
	 */
	private String returnType;
	/**
	 * Nom de la méthode.
	 */
	private String name;
	/**
	 * Visibilité de la méthode.
	 */
	private Visibility visibility;
	/**
	 * Le(s) modifieur(s) de la méthode.
	 */
	private ArrayList<Modifier> modifier;
	
	/**
	 * Construire une méthode de classe.
	 * @param params paramètre de la méthode
	 * @param returnValue type de retour de la méthode
	 * @param name nom de la méthode
	 * @param visibility visibilité de la méthode
	 * @param modifier modifieur(s) de la méthode
	 */
	public UmlMethod(ArrayList<String> params,  
			String returnValue,
			String name,
			Visibility visibility,
			ArrayList<Modifier> modifier) {
		super(visibility, modifier);
		this.returnType = returnValue;
		this.params = params;
		this.name = name;
		this.visibility = visibility;
		this.modifier = modifier;
	}
	
	/**
	 * 
	 * @param params le paramètre de la méthode à ajouter.
	 */
	public void addAllParams(Collections<String> params) {
		this.params.addAll(params);
	}
	
	public void addParams(String param) {
		this.params.add(param);
	}
	
	public void setReturn(String returnType) {
		this.returnType = returnType;
	}
	
	public void removeReturn() {
		this.returnType = null;
	}
	
	public String getReturnType() {
		return this.returnType;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<String> getParams(){
		return this.params;
	}
	
	public void removeParams(ArrayList<String> params) {
		this.params.removeAll(params);
	}
	
}
