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
 * Class which allow to save a diagram in java format.
 * @author fmeslet
 * @version 1.0
 */
public class JavaSaver implements Saver{
	
	private UmlDiagram diagram;
	private JFileChooser jfc;
	private FileNameExtensionFilter filter;
	
	/**
	 * Build a java saver with a diagram.
	 * @param diagram the diagram export in a file .uml7
	 */
	public JavaSaver(UmlDiagram diagram) {
		this.diagram = diagram;
		this.filter = new FileNameExtensionFilter("Java file", ".java");
		
		JFileChooser.setDefaultLocale(Locale.ENGLISH);
		this.jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		UIManager.put("FileChooser.acceptAllFileFilterText",
				UIManager.get( "FileChooser.acceptAllFileFilterText", Locale.ENGLISH));
		
		this.jfc.addChoosableFileFilter(filter);
		this.jfc.setDialogTitle("Save diagram");
	}
	
	/**
	 * Build a java saver.
	 */
	public JavaSaver() {
		this.diagram = new UmlDiagram();
		this.filter = new FileNameExtensionFilter("Java file", ".java");
		
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
		File file = new File("");
		
		do {
			returnValue = this.jfc.showDialog(null, "Save");
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				file = new File(jfc.getSelectedFile() + ".uml7");
				overwrite = this.approveSelection(file);
			}
		} while (!overwrite && returnValue == JFileChooser.APPROVE_OPTION);
		
		if(returnValue == JFileChooser.APPROVE_OPTION || overwrite) {
			saveFile(file);
		}
	}
	
    private boolean approveSelection(File file) throws IOException {
		 if(file.exists() ||
				 JOptionPane.showConfirmDialog( null,
			                  "File already exist, override?",
			                  "override?",
			                  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			 return true;
		 } else {
			 return false;
		 }
    }
    
    /**
     * Save the diagram in a java format.
     * @throws IOException
     */
    private void saveFile(File file) throws IOException {
    	FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		
		objectOut.writeObject(this.diagram);
		objectOut.close();
    }
	
	public void setDiagram(UmlDiagram diagram) {
		this.diagram = diagram;
	}
	
}
