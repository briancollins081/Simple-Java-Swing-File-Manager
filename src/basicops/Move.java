package basicops;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import layout.StatusBar;
import main.App;

public class Move {
	public final int DIRECTORY_MODE=0;
	public final int FILE_MODE=1;
	
	private File sourceObject;
	private File destinationObject;
	private int mode;
	public String dumpLog=null;
	
	public Move() throws IOException {
		StatusBar.setStatus("Moving Files and Folders operation started ...");
		new FetchSourceDestination();
		sourceObject=new File(FetchSourceDestination.getSourceString());
		destinationObject=new File(FetchSourceDestination.getDestinationString());
		mode=sourceObject.isDirectory()?DIRECTORY_MODE:FILE_MODE;
		//do move
		this.performMovement(mode, sourceObject, destinationObject);
		
	}
	
	public void performMovement(int mode,File source, File destination) throws IOException {
		if(mode==this.DIRECTORY_MODE) {
			try {
				FileUtils.moveDirectoryToDirectory(source, destination, true);
				dumpLog="Folder moved successfully from \n"+source.getCanonicalPath()+"\n to Folder \n"+destination.getCanonicalPath();
				StatusBar.setStatus(dumpLog);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(mode==this.FILE_MODE) {
			if(destination.isDirectory()) {
				FileUtils.moveFileToDirectory(source, destination, true);
				dumpLog="File moved successfully from \n"+source.getCanonicalPath()+" \nto Folder\n"+destination.getCanonicalPath();
			}else {
				FileUtils.moveFile(source, destination);
				dumpLog="File moved successfully from \n"+source.getCanonicalPath()+"\n to File\n"+destination.getCanonicalPath();
			}
		}
		JOptionPane.showMessageDialog(App.getFrames()[0], dumpLog, "File Movement Dialog", JOptionPane.INFORMATION_MESSAGE);
	}

}
