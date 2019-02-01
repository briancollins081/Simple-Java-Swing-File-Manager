package functions.fileops;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.sql.Date;
import functions.FileNameHolder;
import layout.NavigationTable;

public class SingleFileFetcher {
	private static int entrylabel=1;
	private static String fileTypeHolder;
	private static String oldFilename;
	private static String newFilename;
	private static Date creationDate;
	private static File thisFile;
	private String realFilePath;
	private FileSystemView fsv;
	
	public SingleFileFetcher() throws IOException {
		/*
		 * Initialize file dialog to pick  a single file|directory to rename by setting mode to Files and directory
		 * Single selection because we are renaming a single file object
		 */
		boolean success=false;
		JFileChooser jfc=new JFileChooser(System.getProperty("user.home"));
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfc.setMultiSelectionEnabled(false);
		
		fsv=jfc.getFileSystemView();
		
		//loop if file object not selected
		do {
			int result=jfc.showDialog(new JFrame(), "Choose Item To Rename");
			jfc.setDialogTitle("Please You Must Select an Item to Continue");
			if(result==JFileChooser.APPROVE_OPTION) {
				thisFile=jfc.getSelectedFile();
				success=true;
			}else {
				JOptionPane.showMessageDialog(jfc, "Requirement Skipped!!! \nSelect an Item to Continue", "Handle Erroe", JOptionPane.WARNING_MESSAGE);
			}
		}while(!success);
		realFilePath=thisFile.getCanonicalPath();
		
		//File type if directory or file
		fileTypeHolder=(thisFile.isFile()?"File":"Dir");
		
		oldFilename=fsv.getSystemDisplayName(new File(realFilePath));
		
		//initialize it to old name that will be changed later
		newFilename=oldFilename;
		
		//initialize the file date/time
		creationDate=new Date(thisFile.lastModified());
		
		//Create the gui with change
		new NavigationTable(NavigationTable.SINGLE_FILE_MODE);
		
	}
	
	public static int getEntrylabel() {
		return entrylabel;
	}

	public static  String getOldFilename() {
		return oldFilename;
	}

	public static  String getNewFilename() {
		return newFilename;
	}

	public  Date getCreationDate() {
		return creationDate;
	}
	
	public static String getFileTypeHolder() {
		return fileTypeHolder;
	}

	public File getThisFile() {
		return thisFile;
	}

	public String getRealFilePath() {
		return realFilePath;
	}
	
	/*
	 * Creates table model data in compatible structure
	 * returns an array of objects
	 */
	public static Object[][] createTableModelData(){
		Object[][] tableData= {
				{getEntrylabel(),getFileTypeHolder(), getOldFilename(),new FileNameHolder(getNewFilename()), creationDate, thisFile},
		};		
		return tableData;
	}
}
