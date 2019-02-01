package functions.fileops;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

import layout.NavigationTable;
import layout.StatusBar;

@SuppressWarnings(value = { "unused" })
public class MultipleFileRenamer {
	private  File[] oldFileObjects;
	private  String[] newFileNames;
	private  String[] newFilePaths;
	private  String[] fileExtensions;
	public final String sep=File.separator;
	private String parentDir;
	
	private JProgressBar jpg;
	private JTextPane text;
	Frame[] frames=NavigationTable.getFrames();
	
	FileSystemView fsv=FileSystemView.getFileSystemView();
	
	public MultipleFileRenamer(File[] filesObjects, String[] newNames) throws IOException, InterruptedException, UnsupportedLookAndFeelException {
		oldFileObjects=filesObjects;
		newFileNames=stripOffExtensions(newNames);
		fileExtensions=new String[filesObjects.length];
		newFilePaths=new String[filesObjects.length];
		
				
		//parent directory
		parentDir=fsv.getParentDirectory(oldFileObjects[0]).getCanonicalPath();
		for (int i = 0; i < newFileNames.length; i++) {
			//extension
			if(!(oldFileObjects[i].isDirectory())) {
				String fileName=oldFileObjects[i].getName();
				int pos=fileName.lastIndexOf('.');
				int pos2=fileName.indexOf('.');
				if(pos>0 && pos2!=0) {
					fileExtensions[i]=(fileName.substring(pos));
				}else {
					fileExtensions[i]="";
				}
			}else {
				fileExtensions[i]="";
			}
			
			//new file paths
			newFilePaths[i]=parentDir+sep+newFileNames[i]+fileExtensions[i];
			
		}
		int num=0;
		//now rename Files using threads
		for (int i = 0; i < newNames.length; i++) {
			Rename r=new Rename(oldFileObjects[i], new File(newFilePaths[i]));			
			Thread thread=new Thread(r);
			Thread.sleep(50);
			thread.start();
			num++;
		}
		
		for (int i = 0; i < frames.length; i++) {
			if(i!=0) frames[i].setVisible(false);
		}
		/*
		 * 							*****************************
		 * Direct the user how to move after finishing Rename Exercise
		 *  						*****************************
		 */
		String msg="*************** Renamed "+num+" Files Successfully *************** \n *************** Thank you for Using AJF Manager ***************";
		JOptionPane.showMessageDialog(new JFrame(), msg, "Information", JOptionPane.INFORMATION_MESSAGE);
		//Prompt the user for next actions
		int opt=JOptionPane.showConfirmDialog(new JFrame(), "Compress the Current Files ?", "Compression", JOptionPane.INFORMATION_MESSAGE);
		if(opt==JOptionPane.OK_OPTION) {
			if(filesObjects.length == 1) {
				new FileCompression(newFilePaths[0]);
				/*//open archive location
				int archiveLocation=JOptionPane.showConfirmDialog(new JFrame(), "Do you want to open Zip File Location System Explorer?", "Open File in OS", JOptionPane.INFORMATION_MESSAGE);
				if(archiveLocation==JOptionPane.OK_OPTION) {
					new OpenFolder((new File(parentDir)).getParent());
				}*/
			}else {
				new FileCompression(parentDir);	
				/*//open archive location
				int archiveLocation=JOptionPane.showConfirmDialog(new JFrame(), "Do you want to open Zip File Location System Explorer?", "Open File in OS", JOptionPane.INFORMATION_MESSAGE);
				if(archiveLocation==JOptionPane.OK_OPTION) {
					new OpenFolder((new File(parentDir)).getParent());
				}*/
			}
			
		}
		int openExplorer=JOptionPane.showConfirmDialog(new JFrame(), "Do you want to View the Single files in System Explorer?", "Open File in OS", JOptionPane.INFORMATION_MESSAGE);
		if(openExplorer==JOptionPane.OK_OPTION) {
			new OpenFolder(parentDir);
		}
	}
	public String[] stripOffExtensions(String[] newNames) {
		for (int i = 0; i < newNames.length; i++) {
			int pos=newNames[i].lastIndexOf('.');
			if(pos>1) {
				newNames[i]=(String) newNames[i].subSequence(0, pos);
			}
		}
		return newNames;
	}
	public String[] sortFileNamesRead(String[] fileNamesToSort) {
		
		return fileNamesToSort;
	}
	
}
class Rename implements Runnable{
	private File oldFile;
	private File newFile;
	private String outputString;
	public Rename(File oldFile, File newFile) throws IOException {
		this.oldFile=oldFile;
		this.newFile=newFile;
	}
	@Override
	public void run() {
		try {
			oldFile.renameTo(newFile);
			outputString=oldFile.getCanonicalPath()+" File Renamed Successful to "+newFile.getCanonicalPath();
			StatusBar.setStatus(outputString);
			System.out.println(outputString);
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
	}
	public String getOutputString() {
		return outputString;
	}
	
}
