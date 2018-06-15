package controller;

import javax.swing.JDialog;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import exception.ExceptionAttribute;
import exception.ExceptionModifier;
import exception.ExceptionVisibility;
import model.Modifier;
import model.PrimitiveType;
import model.UmlAttribute;
import model.UmlRefType;
import model.Visibility;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

/**
 * Class that represents the attribute editor controller.
 * @author Charly Courilleau
 */
public class AttributeEditorController extends JDialog {
	
	/**
	 * generated Serial ID
	 */
	private static final long serialVersionUID = -2220012312015127408L;

	/** Swing name textfield **/
	private JTextField nameTextField;
	
	/** Swing combobox type **/
	private JComboBox<String> comboBoxType;
	
	/** Swing button validate **/
	private JButton btnValidate;
	
	private JComboBox<String> comboBoxVisibility;
	
	private Set<Modifier> modifiers;

	private JCheckBox chckbxStatic;
	
	private JCheckBox chckbxVolatile;
	
	private JCheckBox chckbxFinal;
	
	/**
	 * Constructor called when we need to add an attribute.
	 * @param umlRef the uml element
	 */
	public AttributeEditorController(UmlRefType umlRef) {
		if (umlRef == null) {
			throw new IllegalArgumentException("Adding target can't be null");
		}
		this.modifiers = new HashSet<>();
		this.setTitle("Add an attribute");

		initializeNakedGUI();

		JDialog myself = this;

		this.btnValidate.setText("Add this attribute");

		this.btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					UmlAttribute umlAttr = new UmlAttribute(nameTextField.getText(), PrimitiveType.valueOf((String)comboBoxType.getSelectedItem()));
					umlAttr.setVisibility(Visibility.valueOf(comboBoxVisibility.getSelectedItem().toString()));
					umlAttr.setModifiers(modifiers);

					umlRef.addAttribute(umlAttr);
					dispose();
				} catch (ExceptionAttribute e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Attribute error", JOptionPane.ERROR_MESSAGE);
				} catch (ExceptionVisibility e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Visibility error", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Empty name", JOptionPane.ERROR_MESSAGE);
				} catch (ExceptionModifier e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Illegal modifier", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		JLabel lblModifiers = new JLabel("Modifiers :");
		lblModifiers.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblModifiers, "2, 10, right, default");
		
		chckbxFinal = new JCheckBox("final");
		getContentPane().add(chckbxFinal, "4, 10");
		
		EditorUtils.addItemListenerCheckBox(chckbxFinal, Modifier.FINAL, modifiers);

		chckbxStatic = new JCheckBox("static");
		getContentPane().add(chckbxStatic, "6, 10");
		
		EditorUtils.addItemListenerCheckBox(chckbxStatic, Modifier.STATIC, modifiers);
		
		chckbxVolatile = new JCheckBox("volatile");
		getContentPane().add(chckbxVolatile, "4, 12");
		
		EditorUtils.addItemListenerCheckBox(chckbxVolatile, Modifier.VOLATILE, modifiers);
		
		JButton btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel, "2, 14");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnValidate, "6, 14");
		

	}
	
	
	/**
	 * Constructor called when we need to update an attribute.
	 * @param umlAttr the attribute to update
	 */
	public AttributeEditorController(UmlAttribute umlAttr) {
		if (umlAttr == null) {
			throw new IllegalArgumentException("Modification target can't be null");
		}
		JDialog myself = this;

		Modifier[] modifiersArray = umlAttr.getModifiers().toArray(new Modifier[umlAttr.getModifiers().size()]);
		
		this.modifiers = new HashSet<>(umlAttr.getModifiers());
		
		for (int i = 0; i < modifiersArray.length; i++) {
			switch (modifiersArray[i]) {
				case FINAL:
					chckbxFinal.setSelected(true);
					break;
				case STATIC:
					chckbxStatic.setSelected(true);
					break;
				case VOLATILE:
					chckbxVolatile.setSelected(true);
					break;
				default:
					break;
			}
		}
		
		this.setTitle("Update an attribute");

		initializeNakedGUI();

		this.nameTextField.setText(umlAttr.getName());
		this.comboBoxType.setSelectedItem(umlAttr.getType().toString());
		this.comboBoxVisibility.setSelectedItem(umlAttr.getVisibility().toString());
		this.btnValidate.setText("Update this attribute");
		
		this.btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					umlAttr.setName(nameTextField.getText());
					umlAttr.setModifiers(modifiers);

					umlAttr.setType(PrimitiveType.valueOf((String)comboBoxType.getSelectedItem()));	
					umlAttr.setVisibility(Visibility.valueOf(comboBoxVisibility.getSelectedItem().toString()));
					dispose();

				} catch (ExceptionVisibility e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Visibility error", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Empty name", JOptionPane.ERROR_MESSAGE);
				} catch (ExceptionModifier e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Illegal modifier", JOptionPane.ERROR_MESSAGE);
				}

			}
			
		});

		
	}
	
	/**
	 * Method that permits to build the dialog.
	 */
	private void initializeNakedGUI() {
		
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(91dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(7dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),}));
		
		btnValidate = new JButton();

		JLabel lblAttributeName = new JLabel("Attribute name :");
		getContentPane().add(lblAttributeName, "2, 4, right, default");
		
		nameTextField = new JTextField();
		getContentPane().add(nameTextField, "4, 4, 3, 1, fill, default");
		nameTextField.setColumns(10);
		
		JLabel lblAttributeType = new JLabel("Attribute type :");
		getContentPane().add(lblAttributeType, "2, 6, right, default");
		
		comboBoxType = new JComboBox<>();
		getContentPane().add(comboBoxType, "4, 6, 3, 1, fill, default");
		
		JLabel lblVisibility = new JLabel("Visibility :");
		getContentPane().add(lblVisibility, "2, 8, right, default");
		
		comboBoxVisibility = new JComboBox<>();
		getContentPane().add(comboBoxVisibility, "4, 8, 3, 1, fill, default");
		
		EditorUtils.initializeVisibility(comboBoxVisibility);
		EditorUtils.initializeType(comboBoxType);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	


}
