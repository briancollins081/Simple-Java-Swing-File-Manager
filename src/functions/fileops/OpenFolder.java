package functions.fileops;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFolder {
	private String fileObjectToOpen;
	final Desktop desk=Desktop.getDesktop();
	
	public OpenFolder(String fileObject) throws IOException {
		fileObjectToOpen=fileObject;
		desk.open(new File(fileObjectToOpen));
	}
	
	
}
