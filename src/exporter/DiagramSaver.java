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
 * @version 1.0
 */
public class DiagramSaver implements Saver {

	private File file;
	private UmlDiagram diagram;
	private JFileChooser jfc;
	private FileNameExtensionFilter filter;
	
	/**
	 * Build a diagram saver with a diagram.
	 * @param diagram the diagram export in a file .uml7
	 */
	public DiagramSaver(UmlDiagram diagram) {
		this.diagram = diagram;
		this.file = new File("");
		this.filter = new FileNameExtensionFilter("UML7 Format", "uml7");
		
		JFileChooser.setDefaultLocale(Locale.ENGLISH);
		this.jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		UIManager.put("FileChooser.acceptAllFileFilterText",
				UIManager.get( "FileChooser.acceptAllFileFilterText", Locale.ENGLISH));
		
		this.jfc.addChoosableFileFilter(filter);
		this.jfc.setDialogTitle("Save diagram");
	}
	
	/**
	 * Build a diagram saver.
	 */
	public DiagramSaver() {
		this.diagram = new UmlDiagram();
		this.file = new File("");
		this.filter = new FileNameExtensionFilter("UML7 file", "uml7");
		
		JFileChooser.setDefaultLocale(Locale.ENGLISH);
		this.jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		UIManager.put("FileChooser.acceptAllFileFilterText",
				UIManager.get( "FileChooser.acceptAllFileFilterText", Locale.ENGLISH));
		
		this.jfc.addChoosableFileFilter(filter);
		this.jfc.setDialogTitle("Save diagram");
	}
	
	@Override
	public void save() throws IOException {
		int returnValue = 0;
		boolean overwrite = true;
		String filePath = "";
		
		do {
			returnValue = this.jfc.showDialog(null, "Save");
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				this.file = new File(jfc.getSelectedFile().getAbsolutePath());
				// Absolute path of the file
				filePath = jfc.getSelectedFile().getAbsolutePath();
				
				// Add the extension if the file doesn't have this extension
				if(!filePath.endsWith(".uml7")) {
					this.file = new File(filePath + ".uml7");
				}
				
				overwrite = this.approveSelection();
			}
		} while (!overwrite && returnValue == JFileChooser.APPROVE_OPTION);
		
		if(returnValue == JFileChooser.APPROVE_OPTION && overwrite) {
			saveFile();
		}
	}
	
    private boolean approveSelection() throws IOException {
		 if(!this.file.exists() ||
				 JOptionPane.showConfirmDialog( null,
			                  "File " + this.file.getName() + " already exist, override?",
			                  "override?",
			                  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			 return true;
		 } else {
			 return false;
		 }
    }
    
    /**
     * Save the diagram in a uml7 format.
     * @throws IOException
     */
    private void saveFile() throws IOException {
    	FileOutputStream fileOut = new FileOutputStream(this.file);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		
		objectOut.writeObject(this.diagram);
		objectOut.close();
    }
	
	public void setDiagram(UmlDiagram diagram) {
		this.diagram = diagram;
	}
	
}
