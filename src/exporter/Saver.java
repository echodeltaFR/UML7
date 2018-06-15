package exporter;

import java.io.IOException;

public interface Saver {

	/**
	 * Export the uml diagram in a uml7 format.
	 * @throws IOException
	 */
	public void save() throws IOException;
	
}
