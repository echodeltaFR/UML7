package view;

import javax.swing.JLabel;

import model.Modifier;
import model.UmlMethod;

public class MethodDisplay extends JLabel{

	private UmlMethod method;
	
	public MethodDisplay(UmlMethod method) {
		super();
		this.method = method;
		updateLabel();
	}
	
	public void updateLabel() {
		String str = method.getName()+"(";
		if (method.getParams().size()!=0) {
			for (String attr : method.getParams()) {
				str+=attr+",";
			}
			str=str.substring(0, str.length()-1);
		}
		str+=") : ";
		
		if (method.getReturnType() == null) {
			str+="void";
		} else {
			str+=method.getReturnType();
		}
		if (method.getModifier().size()!=0) {
			str+=" {";
			for (Modifier m : method.getModifier()) {
				str+=m.toString()+",";
			}
			str=str.substring(0,str.length()-1)+"}";
		}
		this.setText(str);
	}
	
}
