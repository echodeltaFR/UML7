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
		//Nombre total de caractères
		int count = this.umlclass.getName().length();
		for(int i = 0; i < this.umlclass.getAttributesList().size();i++) {
			
			AttributeDisplay ad = new AttributeDisplay(this.umlclass.getAttributesList().get(i));
			count = ad.getText().length() > count ? ad.getText().length() : count;
			ad.setBounds(1, 20 * (1 + i), 100, 20);
			//ad.setLocation(1, 20 * (1 + i));
			this.add(ad);
		}
		for(int i = 0; i<this.umlclass.getMethodsList().size();i++) {
			
			MethodDisplay ad = new MethodDisplay(this.umlclass.getMethodsList().get(i));
			count = ad.getText().length() > count ? ad.getText().length() : count;
			ad.setBounds(1, 20 * (i + this.umlclass.getAttributesList().size() + 1), 100, 20);
			this.add(ad);
		}
		this.displayweight = count * 10;
		//System.out.println(displayweight);
		this.displayhigh = 20 * (this.umlclass.getAttributesList().size() 
				+ this.umlclass.getAttributesList().size() + 1);
		//display();
	}
	
	public void display()  
    {  
        //this.repaint();  
    }  
	
	@Override
	public void paint(Graphics g)  
    {  
        super.paint(g);  
        //Quantité totale de attribute et methode
        int count = 1 + umlclass.getAttributesList().size() + umlclass.getMethodsList().size();
        //Frontière de diagramme de classe
        g.drawRect(1, 1, this.displayweight, this.displayhigh);

        
        g.drawLine(1, 20, this.displayweight, 20);
        g.drawLine(1, (1 + umlclass.getAttributesList().size()) * this.HIGH, this.displayweight, (1 + umlclass.getAttributesList().size()) * this.HIGH);
        //Pourquoi a-t-il joué 2 fois
//        System.out.println(this.displayweight);
//       System.out.println(this.displayhigh);
    } 
}
