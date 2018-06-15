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

public class DiagramLoader implements Loader {

	private File file;
	private UmlDiagram diagram;
	private JFileChooser jfc;
	private FileNameExtensionFilter filter;
	
	public DiagramLoader() {
		this.diagram = null;
		this.file = new File("");
		this.filter = new FileNameExtensionFilter("UML7 Diagram", "uml7");
		
		JFileChooser.setDefaultLocale(Locale.ENGLISH);
		this.jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		UIManager.put("FileChooser.acceptAllFileFilterText",
				UIManager.get( "FileChooser.acceptAllFileFilterText", Locale.ENGLISH));
		
		this.jfc.addChoosableFileFilter(filter);
		this.jfc.setDialogTitle("Save diagram");
		jfc.setAcceptAllFileFilterUsed(false);
	}
	
	@Override
	public void load() throws ClassNotFoundException, IOException {
		int returnValue = 0;
		String fileName = "";
		
		returnValue = this.jfc.showDialog(null, "Import");
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			this.file = new File(fileName);
		}
		this.loadFile();
	}
	
	private void loadFile() throws ClassNotFoundException, IOException {
	    FileInputStream fileIn = new FileInputStream(this.file);
	    ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	    this.diagram = (UmlDiagram) objectIn.readObject();
	    objectIn.close();
	    fileIn.close();
	}
	
	public UmlDiagram getDiagram() {
		return this.diagram;
	}
	
}
