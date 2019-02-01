package basicops;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import layout.StatusBar;
import main.App;

public class Delete {
	public final int DIRECTORY_MODE=0;
	public final int FILE_MODE=1;
	
	private File sourceObject;
	private int mode;
	public String dumpLog=null;
	
	public Delete() throws IOException {
		StatusBar.setStatus("Deletion of Files and Folders operation started ...");
		sourceObject=new File(getSourceObject());
		mode=sourceObject.isDirectory()?DIRECTORY_MODE:FILE_MODE;
		performDeletion(mode, sourceObject);
	}
	
	public String getSourceObject() {
		String source=null;
		JFileChooser jfc=new JFileChooser("");
		jfc.setDialogTitle("Please Select your Source File or Folder");
		jfc.setApproveButtonText("Select this Item");
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int select=jfc.showOpenDialog(App.getFrames()[0]);
		if(select==JFileChooser.APPROVE_OPTION) {
			try {
				source=jfc.getSelectedFile().getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return source.trim();
	}
	
	public void performDeletion(int mode, File sourceObject) throws IOException {
		int choice=JOptionPane.showConfirmDialog(App.getFrames()[0], "Delete "+sourceObject.getName()+"!!!\nContinue?");
		if(choice==JOptionPane.OK_OPTION) {
			if(mode==DIRECTORY_MODE) {
				FileUtils.deleteDirectory(sourceObject);
				dumpLog="Folder Deleted successfully from \n"+sourceObject.getCanonicalPath();
				StatusBar.setStatus(dumpLog);
			}
			if(mode==FILE_MODE) {
				Files.deleteIfExists(Paths.get(sourceObject.getCanonicalPath()));
				dumpLog="Folder Deleted successfully from \n"+sourceObject.getCanonicalPath();
				StatusBar.setStatus(dumpLog);
			}
		}
		JOptionPane.showMessageDialog(App.getFrames()[0], dumpLog, "File Delete Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
}
