package exporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import model.UmlDiagram;

/**
 * Class which allow to save a diagram in uml7 format.
 * @author fmeslet
 * @see UmlDiagram
 * @version 1.0
 */
public class DiagramSaver implements Saver {

	/**
	 * The Umldiagram saved.
	 */
	private UmlDiagram diagram;
	
	/**
	 * The box for saving the file.
	 */
	private JFileChooser jfc;
	
	/**
	 * Build a diagram saver with a diagram.
	 * @param diagram the diagram export in a file .uml7
	 */
	public DiagramSaver(UmlDiagram diagram) {
		if(diagram == null) {
			this.diagram = new UmlDiagram();
		} else {
			this.diagram = diagram;
		}
				
		this.jfc = buildSaverFrame(this.jfc);
	}
	
	/**
	 * Build a diagram saver.
	 */
	public DiagramSaver() {
		this.diagram = new UmlDiagram();
		this.jfc = buildSaverFrame(this.jfc);
	}
	
	/**
	 * Create the box with specific parameters for saving the diagram.
	 * @param jfc the box
	 * @return the box modified
	 */
	private static JFileChooser buildSaverFrame(JFileChooser jfc) {
		JFileChooser.setDefaultLocale(Locale.ENGLISH);
		jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		UIManager.put("FileChooser.acceptAllFileFilterText",
				UIManager.get("FileChooser.acceptAllFileFilterText", Locale.ENGLISH));
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("UML7 file", "uml7");
		jfc.addChoosableFileFilter(filter);
		jfc.setDialogTitle("Save your diagram");
		return jfc;
	}
	
	@Override
	public void save() throws IOException {
		int returnValue = 0;
		boolean overwrite = true;
		String filePath = "";
		File file = new File("");
		
		do {
			returnValue = this.jfc.showDialog(null, "Save");
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				file = new File(jfc.getSelectedFile().getAbsolutePath());
				// Absolute path of the file
				filePath = jfc.getSelectedFile().getAbsolutePath();
				
				// Add the extension if the file doesn't have this extension
				if(!filePath.endsWith(".uml7")) {
					file = new File(filePath + ".uml7");
				}
				
				overwrite = this.approveSelection(file);
			}
		} while (!overwrite && returnValue == JFileChooser.APPROVE_OPTION);
		
		if(returnValue == JFileChooser.APPROVE_OPTION && overwrite) {
			saveFile(file);
		}
	}
	
	/**
	 * Approve the overwriting of a file.
	 * @param file the file to save
	 * @return true if the file does not exist or the user accept the override
	 * either false
	 * @throws IOException exception raise in case of I/O Exception
	 */
    private boolean approveSelection(File file) throws IOException {
		 if(!file.exists() ||
				 JOptionPane.showConfirmDialog( null,
			                  "File " + file.getName() + " already exist, override ?",
			                  "Override?",
			                  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			 return true;
		 } else {
			 return false;
		 }
    }
    
    /**
     * Save the diagram in a uml7 format.
     * @param file the file created
     * @throws IOException raise in case of I/O Exception
     */
    private void saveFile(File file) throws IOException {
    	FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		objectOut.writeObject(this.diagram);
		objectOut.close();
    }
	
    @Override
	public void setDiagram(UmlDiagram diagram) {
		this.diagram = diagram;
	}
	
}
