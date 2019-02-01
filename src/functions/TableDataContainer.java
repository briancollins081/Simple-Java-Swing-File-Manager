package functions;

import java.util.Date;

public class TableDataContainer {
	private int label=1;
	private String oldNames[];
	private String newNames[];
	private int fileSize[];
	private Date fileCreated[];
	
	public TableDataContainer() {
		this.oldNames=null;
		this.newNames=null;
		this.fileSize=null;
		this.fileCreated=null;
	}
	public TableDataContainer(String[] oldNames, String[] newNames, int[] fileSize, Date[] fileCreated) {
		this.oldNames=oldNames;
		this.newNames=newNames;
		this.fileSize=fileSize;
		this.fileCreated=fileCreated;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int startLabel) {
		if(label!=startLabel) {
			label=startLabel;
		}
	}

	public String[] getOldNames() {
		return oldNames;
	}

	public void setOldNames(String[] oldNames) {
		this.oldNames = oldNames;
	}

	public String[] getNewNames() {
		return newNames;
	}

	public void setNewNames(String[] newNames) {
		this.newNames = newNames;
	}

	public int[] getFileSize() {
		return fileSize;
	}

	public void setFileSize(int[] fileSize) {
		this.fileSize = fileSize;
	}

	public Date[] getFileCreated() {
		return fileCreated;
	}

	public void setFileCreated(Date[] fileCreated) {
		this.fileCreated = fileCreated;
	}
	
}
