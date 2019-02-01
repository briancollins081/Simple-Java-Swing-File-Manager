package basicops;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import layout.StatusBar;
import main.App;

public class Copy extends JFrame {
	public final int DIRECTORY_MODE=0;
	public final int FILE_MODE=1;
	
	private File sourceObject;
	private File destinationObject;
	private int mode;
	public String dumpLog=null;
	private static final long serialVersionUID = 1L;
	public Copy() throws IOException {
		StatusBar.setStatus("Copying of  Files and Folders operation started ...");
		new FetchSourceDestination();
		sourceObject=new File(FetchSourceDestination.getSourceString());
		destinationObject=new File(FetchSourceDestination.getDestinationString());
		mode=sourceObject.isDirectory()?DIRECTORY_MODE:FILE_MODE;
		
		performCopy(mode, sourceObject, destinationObject);
	}
	
	public void performCopy(int mode, File srcObject, File destObject) throws IOException {
		if(mode==DIRECTORY_MODE) {
			FileUtils.copyDirectoryToDirectory(srcObject, destObject);
			dumpLog="Folder copied successfully from \n"+srcObject.getCanonicalPath()+"\n to Folder \n"+destObject.getCanonicalPath();
			StatusBar.setStatus(dumpLog);
		}
		if(mode==FILE_MODE) {
			FileUtils.copyFileToDirectory(srcObject, destObject);
			dumpLog="File copied successfully from \n"+srcObject.getCanonicalPath()+"\n to Folder \n"+destObject.getCanonicalPath();
			StatusBar.setStatus(dumpLog);
		}
		JOptionPane.showMessageDialog(App.getFrames()[0], dumpLog, "File Copy Dialog", JOptionPane.INFORMATION_MESSAGE);
	}

}
