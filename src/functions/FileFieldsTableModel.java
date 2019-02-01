package functions;

import java.io.File;
import java.sql.Date;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import functions.fileops.MultipleFilesFetcher;
import functions.fileops.SingleFileFetcher;
import layout.NavigationTable;

public class FileFieldsTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -5989397933472550777L;
	private static int mode;
	private static JTable jt;
	String headers[]= {"No","Type","Old File Name","New File Name","Time Created","AbsolutePath"};
	Class<?> columnClasses[]= {int.class,String.class,String.class,FileNameHolder.class,Date.class, File.class};
	
	static Object data[][]=null;
	
	public FileFieldsTableModel(int fileMode,JTable t) {
		super();
		jt=t;
		mode=fileMode;
		getTableData();
		dump();
	}
	public static Object[][] setModelData(){
		jt.revalidate();
		if(mode==NavigationTable.SINGLE_FILE_MODE) {
			data=SingleFileFetcher.createTableModelData();
		}else if(mode==NavigationTable.MULTIPLE_FILES_MODE) {
			data=MultipleFilesFetcher.createTableModelData();
		}else {
			data=null;
		}
		return data;
		
	}
	public int getRowCount() { return data.length; }
	public int getColumnCount() {return headers.length;}
	public Class<?> getColumnClass(int c) {return columnClasses[c];}
	public String getColumnName(int c) {return headers[c];}
	public boolean isCellEditable(int r,int c) {return true;}
	public Object getValueAt(int r, int c) {
		((AbstractTableModel) jt.getModel()).fireTableCellUpdated(r, c);
		return data[r][c];}
	
	public void setValueAt(Object value,int r, int c) {
		((AbstractTableModel) jt.getModel()).fireTableCellUpdated(r, c);
		if(c==3) {
			((FileNameHolder)data[r][c]).setFileName(value);
		}else {
			data[r][c]=value;
		}
	}
	
	public static Object[][] getTableData(){
		((AbstractTableModel) jt.getModel()).fireTableDataChanged();
		
		setModelData();
		return data;
	}
	
	//debug contents of our data structure
	public void dump() {
		for(int i=0; i<data.length; ++i) {
			System.out.print("|");
			for(int j=0; j<data[0].length; j++) {
				System.out.print(data[i][j]+"|");
			}
			System.out.println();
		}
	}
}
