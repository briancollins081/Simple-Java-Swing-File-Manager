package functions.fileops;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

import functions.FileNameHolder;
import layout.NavigationTable;

public class MultipleFilesFetcher {
	//Directories Fields and Data
	private File containerDir;
	private static String realContainerDirPath;
	
	//Files Fields & data
	private static int[] entryLabels;
	private static String[] oldFilenames;
	private static String[] newFilenames;
	private static Date[] creationDates;
	private static String[] fileTypeHolders;
	private static File[] realFilePaths;
	
	private static ArrayList<File>selectedFiles;
	private static FileSystemView fsv;
	
	public MultipleFilesFetcher() throws IOException {
		/*
		 * Initialize file dialog to pick  a single directory to rename its contents by setting mode to directory
		 * and single selection mode because we are selecting a single file directory that contains files we need to rename
		 */
		boolean success=false;
		JFileChooser jfc=new JFileChooser(System.getProperty("user.home"));
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setMultiSelectionEnabled(false);
		
		fsv=jfc.getFileSystemView();
		
		//loop if file object not selected
		do {
			int result=jfc.showDialog(new JFrame(), "Choose Item To Rename");
			jfc.setDialogTitle("Please You Must Select an Item to Continue");
			if(result==JFileChooser.APPROVE_OPTION) {
				containerDir=jfc.getSelectedFile();
				success=true;
			}
		}while(!success);
		realContainerDirPath=containerDir.getCanonicalPath();
		
		initializeFileData();
		setFileData();
		
		//Create the gui with change
		new NavigationTable(NavigationTable.MULTIPLE_FILES_MODE);
	}
	
	public static void  initializeFileData() {
		//Fetch the file list from the directory selected
		File[] files=fsv.getFiles(new File(realContainerDirPath), false);
		//initialize all the arrays sizes
		int l=files.length;
		entryLabels=new int[l];
		oldFilenames=new String[l];
		newFilenames=new String[l];
		creationDates=new Date[l];
		fileTypeHolders=new String[l];
		realFilePaths=new File[l];
		selectedFiles=new ArrayList<>(l);
		for (int i = 0; i < files.length; i++) {
			selectedFiles.add(i, files[i]);
		}
	}
	
	public static void setFileData() throws IOException {
		setEntryLabels();
		setOldFilenames();
		setNewFilenames();
		setCreationDates();
		setFileTypeHolder();
		setRealFilePaths();
	}
	
	public static int[] getEntryLabels() {
		return entryLabels;
	}
	
	public static void setEntryLabels() {
		int l=selectedFiles.size();
		for (int i = 0; i < l; i++) {
			entryLabels[i]=i;
		}
	}

	public static String[] getOldFilenames() {
		return oldFilenames;
	}
	
	public static void setOldFilenames() {
		int len=selectedFiles.size();
		for (int i = 0; i <len ; i++) {
			oldFilenames[i]=fsv.getSystemDisplayName(selectedFiles.get(i));
		}
	}
	
	public static String[] getNewFilenames() {
		return newFilenames;
	}
	
	

	public static void setNewFilenames() {
		newFilenames =oldFilenames;
	}
	
	public static Date[] getCreationDates() {
		return creationDates;
	}
	
	public static void setCreationDates() {
		int len=selectedFiles.size();
		for (int i = 0; i < len; i++) {
			Date date=new Date(selectedFiles.get(i).lastModified());
			creationDates[i]=date;
		}
	}
	
	public static String[] getFileTypeHolder() {
		return fileTypeHolders;
	}

	public static void setFileTypeHolder() {
		int len=selectedFiles.size();
		for (int i = 0; i < len; i++) {
			fileTypeHolders[i]=(selectedFiles.get(i).isDirectory()?"Dir":"File");
		}
	}

	//other getters
	public File getContainerDir() {
		return containerDir;
	}
	
	public static String getRealContainerDirPath() {
		return realContainerDirPath;
	}
	public static void setRealFilePaths() throws IOException {
		//Fetch the file list from the directory selected
		File[] files=fsv.getFiles(new File(realContainerDirPath), false);
		for (int i = 0; i < files.length; i++) {
			realFilePaths[i]=files[i];
		}
	}
	public static File[] getRealFilePaths() {
		return realFilePaths;
	}

	public static ArrayList<File> getSelectedFiles() {
		return selectedFiles;
	}
	//Table Model Data 
	public static Object[][] createTableModelData(){
		int rows=selectedFiles.size();
		int cols=6;
		//initialize the object array
		Object[][] tableData=new Object[rows][cols];
		for (int i = 0; i <rows ; i++) {
			tableData[i][0]=getEntryLabels()[i];
			tableData[i][1]=getFileTypeHolder()[i];
			tableData[i][2]=getOldFilenames()[i];
			tableData[i][3]=new FileNameHolder(getNewFilenames()[i]);
			tableData[i][4]=getCreationDates()[i];
			tableData[i][5]=getRealFilePaths()[i];
		}
			
		return tableData;
	}
	
}
