package view;

import model.UmlClass;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ClassDisplay extends JPanel {
	
	private static final int HIGH = 20;
	private transient UmlClass umlclass;
	private JLabel classname;
	private List<AttributeDisplay> attributes;
	private List<MethodDisplay> methods;
	private int displayweight;
	private int displayhigh;
	
	public ClassDisplay(UmlClass umlclass) {
		this.umlclass = umlclass;
		attributes = new ArrayList<>();
		methods = new ArrayList<>();
		classname = new JLabel(this.umlclass.getName());
		this.setBackground(Color.white);
		this.setLayout(null);
		classname.setBounds(1, 0, 100, 20);
		this.add(classname);
		update();
	}
	
	/**
	 * update the information for display
	 */
	private void update() {
		attributes.clear();
		methods.clear();
		int count = 0;
		for(int i = 0; i < this.umlclass.getAttributesList().size();i++) {
			count = this.umlclass.getAttributesList().get(i).getName().length() > count ?
					this.umlclass.getAttributesList().get(i).getName().length() : count;
			AttributeDisplay ad = new AttributeDisplay(this.umlclass.getAttributesList().get(i));
			ad.setBounds(1, 20 * (1 + i), 100, 20);
			this.add(ad);
		}
		for(int i = 0; i<this.umlclass.getMethodsList().size();i++) {
			count = this.umlclass.getMethodsList().get(i).getName().length() > count ?
					this.umlclass.getMethodsList().get(i).getName().length() : count;
			MethodDisplay ad = new MethodDisplay(this.umlclass.getMethodsList().get(i));
			ad.setBounds(1, 20 * (i + this.umlclass.getAttributesList().size() + 1), 100, 20);
			this.add(ad);
		}
		this.displayweight = count * 20;
		this.displayhigh = 20 * (this.umlclass.getAttributesList().size() 
				+ this.umlclass.getAttributesList().size() + 1);
		display();
	}
	
	public void display()  
    {  
        this.repaint();  
    }  
	
	@Override
	public void paint(Graphics g)  
    {  
        super.paint(g);  
        //int count = 1 + umlclass.getAttributesList().size() + umlclass.getMethodsList().size();
        g.drawRect(1, this.displayhigh, this.displayweight, this.displayhigh);
        g.drawLine(1, 20, 40, 20);
        g.drawLine(1, 1 + umlclass.getAttributesList().size() * HIGH, 40, 1 + umlclass.getAttributesList().size() * HIGH);
        
    } 
}
