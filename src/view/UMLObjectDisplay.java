package view;

import model.UmlRefType;
import model.UmlInterface;
import model.UmlEnum;

import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ClassEditorController;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is the visual representation of an UML Object (e.g. a class, an interface...).<br>
 * It is a JPanel with added functionality to automatically update it's content to match
 * a given UmlComponent.
 *
 * <b>ATTENTION:</b> while this object is a JPanel and have all JPanel methods, it is 
 * discouraged to use them.
 */
public class UMLObjectDisplay extends JPanel implements Observer {
	
	private static final HashMap<Class<? extends UmlRefType>,String> stereotypeMap;
	
	/** The yellow,wide border of a class */
	private static final Border umlObjectBorders = BorderFactory.createLineBorder(
			new Color(250, 240, 50),
			2);
	
	static {
		stereotypeMap = new HashMap<Class<? extends UmlRefType>,String>();
		stereotypeMap.put(UmlInterface.class, "interface");
		stereotypeMap.put(UmlEnum.class, "enum");
	}
	
	/** The inner label that display the name*/
	private JLabel classname;
	
	/** The inner AttributeDisplays that shows the backed object's attributes */
	private List<AttributeDisplay> attributes;
	
	/** the container of the attribute displays */
	private JPanel attributeContainer;
	
	/** The inner MethodDisplays that shows the backed object's methods*/
	private List<MethodDisplay> methods;

	/** the container of the function/method displays */
	private JPanel functionContainer;
	
	/**
	 * Construct a new UMLObjectDisplay backed by an UmlComponent and 
	 * potentially display an archetype.
	 * @param umlobject
	 * 		The (non null) object to visually represent
	 */
	public UMLObjectDisplay(UmlRefType umlobject) {
		super();
		
		if (umlobject == null) throw new IllegalArgumentException("uml object can't be null");
		
		//creating object attributes
		umlobject.addObserver(this);
		this.attributes = new ArrayList<AttributeDisplay>();
		this.methods = new ArrayList<MethodDisplay>();
		
		//Creating Swing architecture
		this.buildInnerSwingArchitecture(umlobject);
		
		this.addMouseListener(new ClassEditorController(umlobject));
		this.updateDisplay(umlobject);
	}

	/**
	 * Generate the inner SWING Architecture of this JPanel to properly display
	 * an UML Object.
	 */
	private void buildInnerSwingArchitecture(UmlRefType umlobject) {
		this.setLayout(new BorderLayout());
		this.setBorder(umlObjectBorders);
		this.classname = new JLabel();
		classname.setHorizontalAlignment(JLabel.CENTER);;
		
		//Creating title area
		JPanel titleArea = new JPanel(new BorderLayout());
		titleArea.setBorder(umlObjectBorders);
		titleArea.add(this.classname,BorderLayout.CENTER);
		
		String stereotype = stereotypeMap.get(umlobject.getClass());
		if (stereotype != null) {
			titleArea.add(new JLabel("<<"+stereotype+">>"),BorderLayout.NORTH);
		}
		
		this.add(titleArea, BorderLayout.NORTH);
		
		//Content has 2 categories : attributes and methods/functions
		JPanel listsContainer = new JPanel(new GridLayout(2, 0));
		listsContainer.setBorder(umlObjectBorders);
		
		this.attributeContainer = new JPanel();
		attributeContainer.setLayout(new BoxLayout(attributeContainer,BoxLayout.Y_AXIS));
		attributeContainer.setBorder(umlObjectBorders);
		
		this.functionContainer = new JPanel();
		functionContainer.setLayout(new BoxLayout(functionContainer,BoxLayout.Y_AXIS));
		functionContainer.setBorder(umlObjectBorders);
		
		listsContainer.add(attributeContainer);
		listsContainer.add(functionContainer);
		
		this.add(listsContainer, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof UmlRefType) {
			this.updateDisplay((UmlRefType) o);
		}
	}
	
	private void updateDisplay(UmlRefType uc) {
		this.classname.setText(uc.getName());
	}
}
