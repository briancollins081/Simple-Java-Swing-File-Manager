package functions.fileops;

import java.io.*;

import javax.swing.filechooser.FileSystemView;

public class SingleFileRenamer {
	private File oldFileObject;
	private String newFileName;
	private String parentPath;
	private String fileExtension;
	private FileSystemView fsv=FileSystemView.getFileSystemView();
	
	public SingleFileRenamer(File file, String newName)throws IOException {
		oldFileObject=file;
		newFileName=newName;
		parentPath=fsv.getParentDirectory(file).getCanonicalPath();
		String fname=file.getName();
		fileExtension=fname.substring(fname.lastIndexOf('.'));
		
	}

	public  File getOldFileObject() {
		return oldFileObject;
	}

	public  void setOldFileObject(File oldFileObject) {
		this.oldFileObject = oldFileObject;
	}

	public  String getNewFileName() {
		return newFileName;
	}

	public  void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public  String getParentPath() {
		return parentPath;
	}

	public  void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	public  String getFileExtension() {
		return fileExtension;
	}

	public  void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	
	public  void renameFile() {
		String sep=File.separator;
		int lastIndex=newFileName.lastIndexOf('.');
		if((lastIndex==-1) ||
			(newFileName.substring(lastIndex).equals(null))||
			!(newFileName.substring(lastIndex).length()<=5)
			) {
			if(oldFileObject.renameTo(new File(parentPath+sep+newFileName+fileExtension))) {
				System.out.println("Rename Successful");
			}
		}
	}
	
	/*public static void main(String[] args) throws IOException {
		SingleFileRenamer sfr=new SingleFileRenamer(new File("C:\\Users\\brian\\Desktop\\JavaWork\\Renaming Work\\Task.class"), "ABCTASKFORCE.FORCE");
		sfr.renameFile();
	}*/
}
