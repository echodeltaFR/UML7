package controller;

import javax.swing.JDialog;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import exception.ExceptionAttribute;
import exception.ExceptionVisibility;
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

import javax.swing.JButton;

/**
 * Class that represents the attribute editor controller.
 * @author Charly Courilleau
 */
public class AttributeEditorController extends JDialog {
	
	/** Swing name textfield **/
	private JTextField nameTextField;
	
	/** Swing combobox type **/
	private JComboBox<String> comboBoxType;
	
	/** Swing button validate **/
	private JButton btnValidate;
	
	private JComboBox<String> comboBoxVisibility;
	
	/**
	 * Constructor called when we need to add an attribute.
	 * @param umlRef the uml element
	 */
	public AttributeEditorController(UmlRefType umlRef) {
		if (umlRef == null) {
			throw new IllegalArgumentException("Adding target can't be null");
		}
		
		initializeNakedGUI();
		this.setTitle("Add an attribute");
		JDialog myself = this;
		this.btnValidate.setText("Add this attribute");

		this.btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					UmlAttribute umlAttr = new UmlAttribute(nameTextField.getText(), PrimitiveType.valueOf((String)comboBoxType.getSelectedItem()));
					umlAttr.setVisibility(Visibility.valueOf(comboBoxVisibility.getSelectedItem().toString()));
					
					umlRef.addAttribute(umlAttr);
					dispose();
				} catch (ExceptionAttribute e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Attribute error", JOptionPane.ERROR_MESSAGE);
				} catch (ExceptionVisibility e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Visibility error", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Empty name", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		

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
		initializeNakedGUI();

		this.setTitle("Update an attribute");
		this.nameTextField.setText(umlAttr.getName());
		this.comboBoxType.setSelectedItem(umlAttr.getType().toString());
		this.comboBoxVisibility.setSelectedItem(umlAttr.getVisibility().toString());
		this.btnValidate.setText("Update this attribute");
		
		this.btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					umlAttr.setName(nameTextField.getText());
					umlAttr.setType(PrimitiveType.valueOf((String)comboBoxType.getSelectedItem()));	
					umlAttr.setVisibility(Visibility.valueOf(comboBoxVisibility.getSelectedItem().toString()));
					dispose();

				} catch (ExceptionVisibility e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Visibility error", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(myself, "Error: " + e.getMessage(), "Empty name", JOptionPane.ERROR_MESSAGE);
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
				RowSpec.decode("max(14dlu;default)"),}));
		
		JLabel lblAttributeName = new JLabel("Attribute name");
		getContentPane().add(lblAttributeName, "2, 4, right, default");
		
		nameTextField = new JTextField();
		getContentPane().add(nameTextField, "4, 4, 3, 1, fill, default");
		nameTextField.setColumns(10);
		
		JLabel lblAttributeType = new JLabel("Attribute type");
		getContentPane().add(lblAttributeType, "2, 6, right, default");
		
		comboBoxType = new JComboBox<>();
		getContentPane().add(comboBoxType, "4, 6, 3, 1, fill, default");
		
		JLabel lblVisibility = new JLabel("Visibility");
		getContentPane().add(lblVisibility, "2, 8, right, default");
		
		comboBoxVisibility = new JComboBox<>();
		getContentPane().add(comboBoxVisibility, "4, 8, 3, 1, fill, default");
		
		
		JButton btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel, "2, 10");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		initializeVisibility(comboBoxVisibility);
		initializeType(comboBoxType);
		
		btnValidate = new JButton("Add attribute");
		getContentPane().add(btnValidate, "6, 10");
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	/**
	 * Method that permits to initialize combobox type.
	 * @param combo the swing combobox
	 */
	private void initializeType(JComboBox<String> combo) {
		for (PrimitiveType type : PrimitiveType.values()) {
			combo.addItem(type.name());
		}
	}
	
	/**
	 * Method that permits to initialize combobox visibility.
	 * @param combo the swing combobox
	 */
	private void initializeVisibility(JComboBox<String> combo) {
		for (Visibility visibility : Visibility.values()) {
			combo.addItem(visibility.name());
		}
	}
	

}
