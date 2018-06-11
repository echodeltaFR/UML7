package view;
import model.UmlInterface;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class InterfaceDisplay extends JPanel {
	private final static int high = 20;
	private UmlInterface umlinterface;
	private JLabel interfacename;
	private ArrayList<AttributeDisplay> attributes;
	private ArrayList<MethodDisplay> methods;
	private int displayweight;
	private int displayhigh;
	
	public InterfaceDisplay(UmlInterface umlinterface ) {
		this.umlinterface = umlinterface;
		attributes = new ArrayList<AttributeDisplay>();
		methods = new ArrayList<MethodDisplay>();
		interfacename = new JLabel(this.umlinterface.getName());
		this.setBackground(Color.white);
		this.setLayout(null);
		interfacename.setBounds(1, 0, 100, 20);
		this.add(interfacename);
		update();
	}
	private void update() {
		attributes.clear();
		methods.clear();
		//Nombre total de caractères
		int count = this.umlinterface.getName().length();
		for(int i = 0; i < this.umlinterface.getAttributesList().size();i++) {
			AttributeDisplay ad = new AttributeDisplay(this.umlinterface.getAttributesList().get(i));
			count = ad.getText().length() > count ? ad.getText().length() : count;
			ad.setBounds(1, 20 * (1 + i), 100, 20);
			//ad.setLocation(1, 20 * (1 + i));
			this.add(ad);
		}
		for(int i = 0; i<this.umlinterface.getMethodsList().size();i++) {
			MethodDisplay ad = new MethodDisplay(this.umlinterface.getMethodsList().get(i));
			count = ad.getText().length() > count ? ad.getText().length() : count;
			ad.setBounds(1, 20 * (i + this.umlinterface.getAttributesList().size() + 1), 100, 20);
			this.add(ad);
		}
		this.displayweight = count * 10;
		this.displayhigh = 20 * (this.umlinterface.getAttributesList().size() 
				+ this.umlinterface.getAttributesList().size() + 1);
		//display();
	}
	
	public void display()  
    {  
        //this.repaint();  
    }  
	
	public void paint(Graphics g)  
    {  
        super.paint(g);  
        //Quantité totale de attribute et methode
        int count = 1 + umlinterface.getAttributesList().size() + umlinterface.getMethodsList().size();
        //Frontière de diagramme de classe
        g.drawRect(1, 1, this.displayweight, this.displayhigh);
        
        g.drawLine(1, 20, this.displayweight, 20);
        g.drawLine(1, (1 + this.umlinterface.getAttributesList().size()) * this.high, this.displayweight,
        		(1 + umlinterface.getAttributesList().size()) * this.high);

    } 
}
