package functions.fileops;
import java.util.*;
import java.awt.BorderLayout;
import java.io.*;

import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import layout.StatusBar;

public class FileCompression extends JPanel{
	private static final long serialVersionUID = 3270007469827693881L;
	List<String> filesListInDirectory=new ArrayList<>();
	
	public FileCompression(String filePath) throws IOException {
		this.setSize(400,400);
		this.setLocation(200,200);
		setLayout(new BorderLayout(5, 5));
			File refFileObj=new File(filePath);
			if(refFileObj.isDirectory()) {
				zipDirectory(refFileObj, filePath+".zip");
			}
			/*else {
				String zipName=refFileObj.getName()+".zip";
				zipSingleFile(refFileObj, zipName);
			}*/
		JTextField ta=StatusBar.getStatusAreaPane();
		add(new JScrollPane(ta), BorderLayout.CENTER);
		this.setVisible(true);
		this.setEnabled(true);
	}
	//fill our files list
	public void fetchFileList(File dir) {
		File[] files=dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if(files[i].isFile()) {
				filesListInDirectory.add(files[i].getAbsolutePath());
			}else {
				fetchFileList(files[i]);
			}
		}
	}
	
	//Zip a directory
	public void zipDirectory(File dir, String zippedName) {
		fetchFileList(dir);
		try {
			FileOutputStream fos=new FileOutputStream(zippedName);
			ZipOutputStream zos=new ZipOutputStream(fos);
			
			for (String filePath : filesListInDirectory) {
				StatusBar.setStatus("Zipping ... "+filePath);
				System.out.println("Zipping ... "+filePath);
				//pick only relative path
				zos.putNextEntry(new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length())));
				//read file writing it to zos
				FileInputStream fis=new FileInputStream(filePath);
				byte[] buffer=new byte[1024];
				int len=0;
				while((len = fis.read(buffer))> 0) {
					zos.write(buffer,0, len);
				}
				zos.closeEntry();
				fis.close();				
			}
			zos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Zip a single file
	public void zipSingleFile(File file, String zipFileName) {
		File useFile=(file.isFile() ? file : null);
		try {
			//write to a zip file using zipoutput stream
			FileOutputStream fos=new FileOutputStream(zipFileName);
			ZipOutputStream zos=new ZipOutputStream(fos);
			//create new zip entry to the zipoutputstream
			zos.putNextEntry(new ZipEntry(useFile.getName()));
			//read and write file to zos
			FileInputStream fin=new FileInputStream(useFile);
			byte[] buffer=new byte[1024];
			int len;
			while((len=fin.read(buffer))>0) {
				zos.write(buffer,0,len);
			}
			zos.closeEntry();
			
			zos.close();
			fin.close();
			fos.close();
			StatusBar.setStatus(useFile.getCanonicalPath()+" is zipped to "+ zipFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Testing for functionality
	 * public static void main(String[] args) throws IOException {
		new FileCompression("C:\\Users\\brian\\Dropbox\\My Notes\\BSE Y3S2");
	}*/
}
