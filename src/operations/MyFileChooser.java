package operations;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class MyFileChooser extends JFileChooser {
	private static final long serialVersionUID = -2982680088063068872L;
	protected final boolean SEL_FILES=true;
	public String statusMsg="";
	protected String fileList;
	
	public MyFileChooser(boolean selType) throws IOException{
		if(selType){
			createFileChooser();
		}else{
			createFolderChooser();
		}
	}
	public void createFileChooser() throws IOException{
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);
		setMultiSelectionEnabled(true);
		int option=showDialog(getParent(),"Open File");
		if(option==JFileChooser.APPROVE_OPTION){
			File sel=getSelectedFile();
			fileList=sel.getCanonicalPath();
			statusMsg=fileList ;
			Desktop.getDesktop().open(sel);
		}else{
			statusMsg="You cancelled Operation";
		}
	}
	public void createFolderChooser() throws IOException{
		this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		setMultiSelectionEnabled(false);
		int option=showDialog(getParent(),"Open Directory");
		if(option==JFileChooser.APPROVE_OPTION){
			fileList=(getSelectedFile()!=null)?getSelectedFile().getCanonicalPath():"Nothing Selected";
			statusMsg=fileList;
			Desktop.getDesktop().open(new File(fileList));
		}
	}
	
	public void createSaveDialog(){
		int option=showSaveDialog(getParent());
		if(option==JFileChooser.APPROVE_OPTION){
			saveFile();
			fileList=getSelectedFile().getName();
			statusMsg=fileList;
		}else{
			statusMsg="You cancelled Operation";
		}
	}
	public void saveFile(){
		
	}
}
