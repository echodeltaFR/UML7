package exporter;

import java.io.IOException;

import model.UmlDiagram;

/**
 * Interface which allow to save diagram.
 * @author fmeslet
 * @see UmlDiagram
 * @version 1.0
 */
public interface Saver {

	/**
	 * Export the uml diagram in a uml7 format.
	 * @throws IOException
	 */
	public void save() throws IOException;
	
	/**
	 * Set a new diagram to save.
	 * @param diagram the new diagram to save
	 */
	public void setDiagram(UmlDiagram diagram);
	
}
