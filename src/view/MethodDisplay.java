package view;

import javax.swing.JLabel;

import model.Modifier;
import model.UmlMethod;
import model.UmlParams;

public class MethodDisplay extends JLabel{

	private UmlMethod method;
	
	public MethodDisplay(UmlMethod method) {
		super();
		if (method == null) throw new IllegalArgumentException("Method can't be null");
		this.method = method;
		updateLabel();
	}
	
	public UmlMethod getMethod() {
		return this.method;
	}
	
	public void updateLabel() {
		StringBuilder str = new StringBuilder();
		
		str.append(method.getName()+"(");
		if (!method.getParams().isEmpty()) {
			for (UmlParams attr : method.getParams()) {
				str.append(
						attr.getName() + ":" + 
						attr.getType().getTypeName() + ",");
			}

			String tmp = str.substring(0, str.length()-1);
			str.setLength(0);
			str.append(tmp);
		}
		
		str.append(") : ");
		
		if (method.getReturnType() == null) {
			str.append("void");
		} else {
			str.append(method.getReturnType().getTypeName());
		}
		
		if (!method.getModifier().isEmpty()) {
			str.append(" {");
			for (Modifier m : method.getModifier()) {
				str.append(m.toString() + ",");
			}
			String tmp = str.substring(0,str.length()-1)+"}";
			str.setLength(0);
			str.append(tmp);
		}
		
		this.setText(str.toString());
	}
	
}
