package importer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import model.UmlDiagram;

/**
 * Class which allow to build a diagram loader.
 * @author fmeslet
 * @see UmlDiagram
 * @version 1.0
 */
public class DiagramLoader implements Loader {

	/**
	 * The diagram load.
	 */
	private UmlDiagram diagram;
	
	/**
	 * The box for loading the file.
	 */
	private JFileChooser jfc;
	
	/**
	 * Build a diagram loader.
	 */
	public DiagramLoader() {
		this.diagram = null;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("UML7 file", "uml7");
		
		JFileChooser.setDefaultLocale(Locale.ENGLISH);
		this.jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		UIManager.put("FileChooser.acceptAllFileFilterText",
				UIManager.get( "FileChooser.acceptAllFileFilterText", Locale.ENGLISH));
		
		this.jfc.addChoosableFileFilter(filter);
		this.jfc.setDialogTitle("Import a diagram");
		jfc.setAcceptAllFileFilterUsed(false);
	}
	
	@Override
	public void load() throws ClassNotFoundException, IOException {
		int returnValue = 0;
		String fileName = "";
		File file = new File("");
		
		returnValue = this.jfc.showDialog(null, "Import");
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			file = new File(fileName);
			this.loadFile(file);
		}
	}
	
	/**
	 * Load a file.
	 * @param file the file loaded
	 * @throws ClassNotFoundException raise if the format is not the format expected
	 * @throws IOException raise in case of I/O Exception
	 */
	private void loadFile(File file) throws ClassNotFoundException, IOException {
		ObjectInputStream objectIn = null;
		FileInputStream fileIn = null;
		try {
		    fileIn = new FileInputStream(file);
		    objectIn = new ObjectInputStream(fileIn);
		    this.diagram = (UmlDiagram) objectIn.readObject();
		} finally {
			if (objectIn != null)
				  objectIn.close();
			
			if (fileIn != null)
				fileIn.close();
		}
	}
	
	/**
	 * Get the diagram loaded.
	 * @return the diagram loaded
	 */
	public UmlDiagram getDiagram() {
		return this.diagram;
	}
	
}
