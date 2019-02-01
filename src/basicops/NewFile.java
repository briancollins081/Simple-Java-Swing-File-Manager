package basicops;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import functions.fileops.OpenFolder;
import layout.StatusBar;
import main.App;

public class NewFile extends JFrame {
	private static final long serialVersionUID = -5439063672447265323L;
	public final static int FOLDER_MODE=0;
	public final static int FILE_MODE=1;
	
	private File destinationObject;
	private File newFileObject;
	private int mode;
	public String dumpLog=null;
	
	public NewFile(int mode) throws IOException {
		StatusBar.setStatus("Creating Files and Folders operation started ...");
		destinationObject=new File(getDestinationObject());
		this.mode=mode;		
		performCreation(destinationObject);
	}

	public String getDestinationObject() {
		String source=null;
		JFileChooser jfc=new JFileChooser("");
		jfc.setDialogTitle("Please Select The Location of your File");
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
	
	private void performCreation(File destinationObject2) throws IOException {
		String destPath=destinationObject2.getCanonicalPath();
		String inputString=null;
		
		do {
			if(mode==FILE_MODE){
				inputString=(JOptionPane.showInputDialog(App.getFrames()[0], "Enter the File name with Extension", 
					"Capture File Name", JOptionPane.INFORMATION_MESSAGE)).trim();
				destPath+=File.separator+inputString;
				if(Files.exists(Paths.get(destinationObject2.getCanonicalPath()))) {
					newFileObject=new File(destPath);
					FileOutputStream fos=new FileOutputStream(newFileObject);
					String str="";
					fos.write(str.getBytes());
					fos.close();
					
					dumpLog="Created File .....\n"+newFileObject.getCanonicalPath()+"\n Successfully ";
					StatusBar.setStatus(dumpLog);
				}
			}
			if(mode==FOLDER_MODE) {
				inputString=(JOptionPane.showInputDialog(App.getFrames()[0], "Enter the Folder name ", 
						"Capture File Name", JOptionPane.INFORMATION_MESSAGE)).trim();
				destPath+=File.separator+inputString;
				if(Files.exists(Paths.get(destinationObject2.getCanonicalPath()))) {
					Path desPath=Paths.get(destPath);
					Files.createDirectories(desPath);
					dumpLog="Created File .....\n"+desPath.toString()+"\n Successfully ";
					StatusBar.setStatus(dumpLog);
				}
			}
		}while(inputString.equals(null)||inputString.length()==0);
		
		int opt=JOptionPane.showConfirmDialog(App.getFrames()[0], "Do you want to open the file Location ?");
		if(opt==JOptionPane.OK_OPTION) {
			new OpenFolder(destinationObject2.getCanonicalPath());
		}
		
	}
}
