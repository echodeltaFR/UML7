package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * La classe permettant de créer une méthode.
 * @author fmeslet
 * @version 1.0
 */
public class UmlMethod extends UmlEntity{

	/**
	 * Method parameters.
	 */
	private ArrayList<String> params;
	/**
	 * Method return type.
	 */
	private String returnType;
	/**
	 * Method name.
	 */
	private String name;
	
	/**
	 * Construire une méthode de classe.
	 * @param params paramètre de la méthode
	 * @param returnValue type de retour de la méthode
	 * @param name nom de la méthode
	 * @param visibility visibilité de la méthode
	 * @param modifier modifieur(s) de la méthode
	 */
	public UmlMethod(List<String> params,  
			String returnValue,
			String name,
			Visibility visibility,
			HashSet<Modifier> modifier) {
		super(visibility, modifier);
		this.returnType = returnValue;
		this.params = new ArrayList<String>(params);
		this.name = name;
	}
	
	/**
	 * Ajouter tous les paramètres de la méthodes.
	 * @param params le paramètre de la méthode à ajouter.
	 */
	public void addAllParams(List<String> params) {
		this.params.addAll(params);
	}
	
	public void addParams(String param) {
		this.params.add(param);
	}
	
	/**
	 * Ajouter des types de retour.
	 * @param returnType
	 */
	public void setReturn(String returnType) {
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
	public String getReturnType() {
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
	public List<String> getParams(){
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
