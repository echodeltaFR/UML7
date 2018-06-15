package controller;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Modifier;
import model.PrimitiveType;
import model.UmlMethod;
import model.UmlParams;
import model.UmlRefType;
import model.UmlType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import exception.ExceptionMethode;
import exception.ExceptionModifier;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JCheckBox;

public class MethodEditorController extends JDialog {
	
	private Set<UmlParams> umlParams;
	
	private UmlRefType umlRefType;
	
	private JDialog myself;
	
	private DefaultTableModel model;
	
	private JTable table;
	
	private JTextField nameMethodtextField;
	
	private JCheckBox chckbxFinal;
	
	private JCheckBox chckbxStatic;
	
	private JCheckBox chckbxAbstract;
	
	private JComboBox<String> typeParamComboBox;
	
	private JButton btnValidate;
	
	private JComboBox<String> returnTypeMethodComboBox;
	
	private JCheckBox chckbxVolatile;
	
	private Set<Modifier> modifiers;
	
	/**
	 * @wbp.parser.constructor
	 */
	public MethodEditorController(UmlMethod umlMethod) {
		if (umlMethod == null) {
			throw new IllegalArgumentException("Modification target can't be null");
		}
		this.umlParams = new HashSet<>(umlMethod.getParams());
		this.umlRefType = null;
		this.myself = this;
		initializeNakedGUI();
		this.btnValidate.setText("Apply and close");
		this.setTitle("Edit a method");
				
		UmlType umlType = umlMethod.getReturnType();

		returnTypeMethodComboBox.setSelectedItem(umlType.toString());
				
		Modifier[] modifiersArray = umlMethod.getModifiers().toArray(new Modifier[umlMethod.getModifiers().size()]);
		
		this.modifiers = new HashSet<>(umlMethod.getModifiers());
		
		for (int i = 0; i < modifiersArray.length; i++) {
			switch (modifiersArray[i]) {
				case ABSTRACT:
					chckbxAbstract.setSelected(true);
					break;
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
		
		nameMethodtextField.setText(umlMethod.getName());
				
		for (UmlParams param : this.umlParams) {
			model.addRow(new Object[]{param.getName(), param.getType().getTypeName()});				
		}
		
		btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
	
					umlMethod.setName(nameMethodtextField.getText());
					
					umlMethod.removeParams(umlMethod.getParams());
					umlMethod.addParams(umlParams);
	
					try {
						
						umlMethod.setModifiers(modifiers);
						umlMethod.setReturnType(PrimitiveType.valueOf((String)returnTypeMethodComboBox.getSelectedItem()));
						myself.dispose();
	
					} catch (ExceptionModifier e1) {
							JOptionPane.showMessageDialog(myself, "Error: "+e1.getMessage(), "Can't add this modifier", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(myself, "Error: "+ex.getMessage(), "Name can't be empty", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
	}
	
	
	public MethodEditorController(UmlRefType umlRef) {
		if (umlRef == null) {
			throw new IllegalArgumentException("Add target can't be null");
		}
		this.umlParams = new HashSet<>();
		this.umlRefType = umlRef;

		this.myself = this;
		initializeNakedGUI();
		this.btnValidate.setText("Add this method");
		this.setTitle("Add a method");
		this.modifiers = new HashSet<>();

		btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					UmlMethod newMethod = new UmlMethod(nameMethodtextField.getText());

					newMethod.addParams(umlParams);
					
					try {
						
						newMethod.setModifiers(modifiers);

					} catch (ExceptionModifier e1) {
							JOptionPane.showMessageDialog(myself, "Error: "+e1.getMessage(), "Can't add this modifier", JOptionPane.ERROR_MESSAGE);
					}
					
					newMethod.setReturnType(PrimitiveType.valueOf((String)returnTypeMethodComboBox.getSelectedItem()));
					
					try {
						umlRefType.addMethod(newMethod);
						dispose();
					} catch (ExceptionMethode e1) {
						JOptionPane.showMessageDialog(myself, "Error: "+e1.getMessage(), "Can't add method", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch(IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(myself, "Error: "+ex.getMessage(), "Name can't be empty", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
		});
		
	}
	
	
	private void initializeNakedGUI() {
		
		JDialog myself = this;

		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
				RowSpec.decode("default:grow"),
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
				FormSpecs.RELATED_GAP_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Name : ");
		getContentPane().add(lblName, "4, 6, right, default");
		
		nameMethodtextField = new JTextField();
		getContentPane().add(nameMethodtextField, "8, 6, 3, 1, fill, default");
		nameMethodtextField.setColumns(10);

		JLabel lblParameters = new JLabel("Parameters : ");
		getContentPane().add(lblParameters, "4, 10");
		
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Type");
        table = new JTable(model);
                
		JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, "8, 10, 3, 5, default, default");

		JButton btnAddParams = new JButton("Add params");
		getContentPane().add(btnAddParams, "8, 16");
		
		JButton btnRemoveParams = new JButton("Remove params");
		btnRemoveParams.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {
					removeParameter((String)table.getValueAt(table.getSelectedRow(), 0));
					model.removeRow(table.getSelectedRow());
				}
			}
			
		});
		
		getContentPane().add(btnRemoveParams, "10, 16");
		
		JLabel lblModifiers = new JLabel("Modifiers :");
		getContentPane().add(lblModifiers, "4, 18");
		
		chckbxFinal = new JCheckBox("final");
		getContentPane().add(chckbxFinal, "8, 18");
		
		addItemListenerCheckBox(chckbxFinal, Modifier.FINAL);
		
		chckbxStatic = new JCheckBox("static");
		getContentPane().add(chckbxStatic, "10, 18");
		
		addItemListenerCheckBox(chckbxStatic, Modifier.STATIC);
		
		chckbxAbstract = new JCheckBox("abstract");
		getContentPane().add(chckbxAbstract, "8, 20");
		
		addItemListenerCheckBox(chckbxAbstract, Modifier.ABSTRACT);
		
		chckbxVolatile = new JCheckBox("volatile");
		getContentPane().add(chckbxVolatile, "10, 20");
		addItemListenerCheckBox(chckbxVolatile, Modifier.VOLATILE);

		JLabel lblReturnType = new JLabel("Return type :");
		getContentPane().add(lblReturnType, "4, 22");
		
		returnTypeMethodComboBox = new JComboBox<>();
		getContentPane().add(returnTypeMethodComboBox, "8, 22, 3, 1");
		
		JButton btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel, "4, 26");
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		
		btnValidate = new JButton();
		
		getContentPane().add(btnValidate, "10, 26");
		
		btnAddParams.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JDialog dialog = new JDialog(myself);

				
				dialog.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
						FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),},
					new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,}));
				
				JLabel lblName = new JLabel("Name");
				dialog.getContentPane().add(lblName, "2, 4, right, default");
				
				JTextField nameTextField = new JTextField();
				dialog.getContentPane().add(nameTextField, "6, 4, 5, 1, fill, default");
				nameTextField.setColumns(10);
				
				JLabel lblType = new JLabel("Type");
				dialog.getContentPane().add(lblType, "2, 6, right, default");
				
				typeParamComboBox = new JComboBox<>();
				initializeType(typeParamComboBox);
				dialog.getContentPane().add(typeParamComboBox, "6, 6, 5, 1, fill, default");

				
				JButton btnCancel = new JButton("Cancel");
				dialog.getContentPane().add(btnCancel, "6, 8");
				btnCancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.dispose();
					}
					
				});
				
				JButton btnAddParam = new JButton("Add this param");
				dialog.getContentPane().add(btnAddParam, "10, 8");
				btnAddParam.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						UmlParams umlParam = new UmlParams(PrimitiveType.valueOf((String)typeParamComboBox.getSelectedItem()), nameTextField.getText());
						umlParams.add(umlParam);
						model.addRow(new Object[]{umlParam.getName(), umlParam.getType().getTypeName()});				
						dialog.dispose();
					}
					
				});
				
				dialog.setLocationRelativeTo(null);
				dialog.pack();
				dialog.setVisible(true);
				
			}
			
		});
		
		initializeType(returnTypeMethodComboBox);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	
	private void initializeType(JComboBox<String> combo) {
		for (PrimitiveType type : PrimitiveType.values()) {
			combo.addItem(type.name());
		}
	}
	
	
	private void removeParameter(String methodName) {
		
		UmlParams found = null;
				
		UmlParams[] tab = umlParams.toArray(new UmlParams[umlParams.size()]);
		
		for (int i = 0; i < tab.length && found == null; i++) {

			if (tab[i].getName().equals(methodName)) {
				found = tab[i];
			}
		}
		
		if (found != null) {
			umlParams.remove(found);
		}
		
		
	}
	
	private void addItemListenerCheckBox(JCheckBox checkBox, Modifier modifier) {
		checkBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
		        if (arg0.getStateChange() == ItemEvent.SELECTED) {
		            modifiers.add(modifier);
		        } else {
		        	modifiers.remove(modifier);
		        }	
			}
		});
	}

	
}
