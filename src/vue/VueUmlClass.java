package vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class VueUmlClass extends JPanel{
	//public ArrayList<JLabel> attribute;
	
	public VueUmlClass() {
		setLayout(null);
		JLabel label = new JLabel("the name of class:");

		label.setBounds(10,20,160,30);
        add(label);

        JTextField className = new JTextField(30);
        className.setBounds(10,50,160,30);
        add(className);

        
        JButton Button = new JButton("sure");
        Button.setBounds(10, 80, 80, 30);
        add(Button);
        Button.addActionListener(new ButtonActionListener());
	}  
	private class ButtonActionListener implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
            System.out.println("");     
        }     
    }  
	
}
