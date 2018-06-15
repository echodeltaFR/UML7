package exporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Map.Entry;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import generator.JavaGenerator;
import model.UmlDiagram;

/**
 * Class which allow to save a diagram in java format.
 * @author fmeslet
 * @see JavaGenerator
 * @see UmlDiagram
 * @version 1.0
 */
public class JavaSaver implements Saver{
	
	/**
	 * The diagram to save in java file.
	 */
	private UmlDiagram diagram;
	
	/**
	 * The box for saving a diagram.
	 */
	private JFileChooser jfc;
	
	/**
	 * The java generator.
	 */
	private JavaGenerator generator;
	
	/**
	 * Build a java saver with a diagram.
	 * @param diagram the diagram export in a file .uml7
	 */
	public JavaSaver(UmlDiagram diagram) {
		if(diagram == null) {
			this.diagram = new UmlDiagram();
		} else {
			this.diagram = diagram;
		}
		
		this.generator = new JavaGenerator(this.diagram);
		this.jfc = buildSaverFrame();
	}
	
	/**
	 * Build a java saver.
	 */
	public JavaSaver() {
		this.diagram = new UmlDiagram();
		this.jfc = buildSaverFrame();
	}
	
	/**
	 * Create the box with specific parameters for saving the diagram.
	 * @return the box
	 */
	private static JFileChooser buildSaverFrame() {
		JFileChooser.setDefaultLocale(Locale.ENGLISH);
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		UIManager.put("FileChooser.acceptAllFileFilterText",
				UIManager.get( "FileChooser.acceptAllFileFilterText", Locale.ENGLISH));
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Java file", "java");
		
		jfc.addChoosableFileFilter(filter);
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setDialogTitle("Choose a directory");
		jfc.setAcceptAllFileFilterUsed(false);
		return jfc;
	}
	
	@Override
	public void save() throws IOException {
		int returnValue = 0;
		File file = null;
		String filePath = "";
		
		returnValue = this.jfc.showDialog(null, "Save");
		
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			
			// Generate java code
			this.generator.generateCode();
			
			for(Entry<String, String> map : this.generator.getCode().entrySet()) {
				
				// Absolute path of the file
				filePath = jfc.getSelectedFile().getAbsolutePath() + File.separator  + map.getKey();
				
				// The java file with the extension already add
				file = new File(filePath);
				
				// Autorize the override
				if(this.approveSelection(file)) {
					this.saveFile(file, map.getValue());
				}
			}
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
		 if (!file.exists() ||
				 JOptionPane.showConfirmDialog( null,
						 	"File " + file.getName() + " already exist, override ?",
			                  "Override ?",
			                  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			 return true;
		 } else {
			 return false;
		 }
    }
    
    /**
     * Save the diagram in a java format.
     * @param file the file created
     * @param code the code write in file
     * @throws IOException exception raise in case of I/O Exception
     */
    private void saveFile(File file, String code) throws IOException {
		
    	FileWriter writer = null;
    	try {
    		writer = new FileWriter(file);
    		writer.write(code);
    		writer.close();
    	} finally {
			if (writer != null)
				writer.close();
    	}
    }
	
    @Override
	public void setDiagram(UmlDiagram diagram) {
		this.diagram = diagram;
	}
	
}
