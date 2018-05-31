package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Class which allow to create a method
 * @author fmeslet
 * @version 1.0
 */
public class UmlMethod extends UmlEntity{

	/**
	 * Method parameters.
	 */
	private ArrayList<UmlParams> params;
	/**
	 * Method return type.
	 */
	private UmlComponent returnType;
	/**
	 * Method name.
	 */
	private String name;
	
	/**
	 * Build a class method.
	 * @param params method parameter
	 * @param returnType method return type
	 * @param name method name
	 * @param visibility method visibility
	 * @param modifier method modifiers
	 */
	public UmlMethod(List<UmlParams> params,  
			UmlComponent returnType,
			String name,
			Visibility visibility,
			HashSet<Modifier> modifier) {
		super(visibility, modifier);
		this.returnType = returnType;
		this.params = new ArrayList<UmlParams>(params);
		this.name = name;
	}
	
	/**
	 * Ajouter tous les paramètres de la méthodes.
	 * @param params le paramètre de la méthode à ajouter.
	 */
	public void addAllParams(List<UmlParams> params) {
		this.params.addAll(params);
	}
	
	public void addParams(UmlParams param) {
		this.params.add(param);
	}
	
	/**
	 * Ajouter des types de retour.
	 * @param returnType
	 */
	public void setReturn(UmlComponent returnType) {
		this.returnType = returnType;
	}
	
	/**
	 * Supprimer les types de retour.
	 */
	public void removeReturn() {
		this.returnType = null;
	}
	
	/**
	 * Obtenir les types de retour.
	 * @return Chaine de caractère
	 */
	public UmlComponent getReturnType() {
		return this.returnType;
	}
	
	/**
	 * Obtenir le nom de la méthode.
	 * @return le nom de la méthode.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Obtenir le(s) paramètre(s) de la méthodes.
	 * @return le(s) parametre(s) de la méthode
	 */
	public List<UmlParams> getParams(){
		return this.params;
	}
	
	/**
	 * Supprimer le paramètre de la méthode.
	 * @param params paramtre de la méthode
	 */
	public void removeParams(String params) {
		this.params.remove(params);
	}
	
	/**
	 * Supprimer les paramètres de la méthode.
	 * @param params les paramètres de la méhodes à
	 * supprimer
	 */
	public void removeAllParams(List<String> params) {
		this.params.removeAll(params);
	}
	
}
