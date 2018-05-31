package vue;


import javax.swing.*;
public class test_vueClass {
	public static void main(String[] args) {
		VueUmlClass vue;
		JFrame frame;
		frame = new JFrame("test");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vue = new VueUmlClass();	
		frame.add(vue);
	    frame.setVisible(true);
	}
}
