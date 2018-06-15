package importer;

import java.io.IOException;

/**
 * Interface which allow to load diagram in various format.
 * @author fmeslet
 * @version 1.0
 */
public interface Loader {

	/**
	 * Load a diagram in various format.
	 * @throws ClassNotFoundException raise if the format is not the format expected
	 * @throws IOException raise in case of I/O Exception
	 */
	public void load() throws ClassNotFoundException, IOException;
	
}
