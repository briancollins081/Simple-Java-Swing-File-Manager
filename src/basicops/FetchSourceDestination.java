package basicops;

import java.io.IOException;

import javax.swing.JFileChooser;

import main.App;

public class FetchSourceDestination {
	static String sourceString;
	static String destinationString;
	public FetchSourceDestination() {
		setSourceString(getSourceObject());
		setDestinationString(getDestinationObject());
	}
	
	public static void setSourceString(String sourceString) {
		FetchSourceDestination.sourceString = sourceString;
	}

	public static void setDestinationString(String destinationString) {
		FetchSourceDestination.destinationString = destinationString;
	}

	public static String getSourceString() {
		return sourceString;
	}

	public static String getDestinationString() {
		return destinationString;
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
	public String getDestinationObject() {
		String source=null;
		JFileChooser jfc=new JFileChooser("");
		jfc.setDialogTitle("Please Select Destination Folder for File");
		jfc.setApproveButtonText("Select this Folder");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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
}
