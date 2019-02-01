package functions;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

import functions.fileops.MultipleFileRenamer;
import layout.NavigationTable;
import layout.StatusBar;

public class AbcTableContainer extends JPanel {
	private static final long serialVersionUID = -6967494308095255666L;
	private String[] oldNames;
	private String[] newNames;
	private File[] filePathObjects;
	private JTable jt;
	Frame[] frames=NavigationTable.getFrames();
	public AbcTableContainer(int mode) throws IOException {
		super();
		setSize(1000,600);
		this.setLayout(new BorderLayout());
		jt=new JTable();
		FileFieldsTableModel fftm=new FileFieldsTableModel(mode,jt); //Table Model
		jt.setModel(fftm);
		jt.setDefaultRenderer(FileNameHolder.class, new FileNameHolderRenderer());//Table Cell Renderer
		jt.setDefaultEditor(FileNameHolder.class, new FileNameHolderEditor());//Cell Editor
		TableColumnModel tcm=jt.getColumnModel();
		int w=getWidth();
		tcm.getColumn(0).setPreferredWidth((int)(w*0.03));
		tcm.getColumn(1).setPreferredWidth((int)(w*0.03));
		tcm.getColumn(2).setPreferredWidth((int)(w*0.30));
		tcm.getColumn(3).setPreferredWidth((int)(w*0.30));
		tcm.getColumn(4).setPreferredWidth((int)(w*0.03));
		tcm.getColumn(5).setPreferredWidth((int)(w*0.30));
		//row height
		jt.setRowHeight(25);
		
		
		//fetch data 
		jt.revalidate();
		parseTableDataFiles(FileFieldsTableModel.getTableData(),jt);
		JScrollPane jsp=new JScrollPane(jt);
		add(jsp,BorderLayout.CENTER);
		
		StatusBar.setStatus("Renaming Initialized now .........");
		Action a=new AbstractAction("Rename Now") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
				try {
					try {
						renameAllNow();
					} catch (UnsupportedLookAndFeelException e1) {
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		};
		JButton renF=new JButton(a);
		add(renF,BorderLayout.SOUTH);
		
		a=new AbstractAction("Close | Go Home") {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				StatusBar.setStatus("Back to Main App Screen .........");
				for (int i = 0; i < frames.length; i++) {
					if(i!=0) frames[i].setVisible(false);
				}
			}
		};
		
		JButton closeB=new JButton(a);
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		
		Box hb=Box.createHorizontalBox();
		hb.setBorder(new EmptyBorder(new Insets(10, 40, 10, 40)));
		hb.add(renF);
		hb.add(Box.createHorizontalStrut((int) (this.getWidth()*0.55)));
		hb.add(closeB);
		p.add(hb);
		this.add(p, BorderLayout.SOUTH);
	}
	
	
	public String[] getOldNames() {
		return oldNames;
	}


	public String[] getNewNames() {
		jt.revalidate();
		jt.repaint();
		((AbstractTableModel) jt.getModel()).fireTableDataChanged();
		int rows=jt.getRowCount();
		final int col=3;
		if(rows==newNames.length) {
			for (int i = 0; i < rows; i++) {
				newNames[i]=((FileNameHolder) jt.getValueAt(i, col)).getFileName();
			}
		}
		return newNames;
	}


	public File[] getFilePathObjects() {
		return filePathObjects;
	}


	/*
	 * Parses table data and 
	 */
	public void parseTableDataFiles(Object[][] updatedTableData,JTable jt) throws IOException {
		((AbstractTableModel) jt.getModel()).fireTableDataChanged();
		//MultipleFilesFetcher.createTableModelData();
		int oldN=2; 
		int newN=3; 
		int pathObj=5;
		//get number of file records read to the navigation table
		int l=updatedTableData.length;
		//Initialize all arrays for carrying this data
		this.oldNames=new String[l];
		this.newNames=new String[l];
		this.filePathObjects=new File[l];
		
		//fill the arrays with matching data for renaming
		for (int i = 0; i < l; i++) {
			oldNames[i]=(String) updatedTableData[i][oldN];
			newNames[i]=((FileNameHolder) updatedTableData[i][newN]).getFileName();
			filePathObjects[i]=(File) updatedTableData[i][pathObj];
		}
		
		//Dump data for testing
		//dumpD();
	}
	/*
	 * Carries out the file renaming by calling Renamer class
	 */
	public void  renameAllNow() throws IOException, InterruptedException, UnsupportedLookAndFeelException {
		((AbstractTableModel)jt.getModel()).fireTableDataChanged();
		new MultipleFileRenamer(filePathObjects, getNewNames());
	}
	/*
	 * Dump the data to confirm its correct
	 */
	public void dumpD() throws IOException {
		System.out.println("==================================\nDump from AAA777");
		for (int i = 0; i < getFilePathObjects().length; i++) {
			System.out.println((getFilePathObjects()[i]).getCanonicalPath());
		}
	}
}
