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
	 * Method parameters.
	 */
	private List<String> params;
	/**
	 * Method return type.
	 */
	private String returnType;
	/**
	 * Method name.
	 */
	private String name;
	/**
	 * Method Visibility.
	 */
	private Visibility visibility;
	/**
	 * Le(s) modifieur(s) de la méthode.
	 */
	private Collections<Modifier> modifier;
	
	/**
	 * Construire une méthode de classe.
	 * @param params paramètre de la méthode
	 * @param returnValue type de retour de la méthode
	 * @param name nom de la méthode
	 * @param visibility visibilité de la méthode
	 * @param modifier modifieur(s) de la méthode
	 */
	public UmlMethod(Collections<String> params,  
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
	 * Ajouter tous les paramètres de la méthodes.
	 * @param params le paramètre de la méthode à ajouter.
	 */
	public void addAllParams(Collections<String> params) {
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
