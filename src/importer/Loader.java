package importer;

import java.io.IOException;

public interface Loader {

	public void load() throws ClassNotFoundException, IOException;
	
}
