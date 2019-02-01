package functions;

import java.awt.*;
import java.awt.event.*;

import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import javax.swing.event.*;

public class FileNameHolderEditor extends JTextField implements TableCellEditor{
	private static final long serialVersionUID = -2482191931153760521L;
	public OkCancel helper=new OkCancel();
	protected transient Vector<CellEditorListener> listeners;
	protected transient String originalValue;
	protected transient boolean editing;
	
	public FileNameHolderEditor() {
		super(SwingConstants.HORIZONTAL);
		listeners=new Vector<>();
	}
	
	//Inner class for displaying window with ok and cancel buttons on each textfield
	public class OkCancel extends JWindow{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JButton ybtn=new JButton("OK",new ImageIcon("images/ok.gif"));
		private JButton nbtn=new JButton("Cancel",new ImageIcon("images/no.gif"));
		private int w=90;
		private int h=25;
		
		public OkCancel() {
			setSize(w,h);
			setBackground(Color.darkGray);
			JPanel p=new JPanel(new GridLayout(0,2));
			p.setBorder(new EmptyBorder(new Insets(3,3,3,3)));
			ybtn.setBorder(null);
			nbtn.setBorder(null);
			p.add(ybtn);
			p.add(nbtn);
			this.setContentPane(p);
			
			ybtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stopCellEditing();
				}
			});
			
			nbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelCellEditing();
				}
			});
		}		
	}
	
	public Component getTableCellEditorComponent(JTable table, 
			Object value, boolean isSelected, 	int row, int column) {
		if(value ==null) {
			return this;
		}
		if(value instanceof FileNameHolder) {
			setText(((FileNameHolder)value).getFileName());
		}else {
			setText("Untilted-empty!");
		}
		
		table.setRowSelectionInterval(row, row);
		table.setColumnSelectionInterval(column, column);
		originalValue=getText();
		editing=true;
		Point p=table.getLocationOnScreen();
		Rectangle r=table.getCellRect(row, column, true);
		helper.setLocation(r.x+p.x+getWidth()-50, r.y+p.y+getHeight());
		helper.setVisible(true);
		return this;
	}
	//Cell editing functions
	public void cancelCellEditing() {
		fireEditingCanceled();
		editing=false;
		helper.setVisible(false);
	}
	public Object getCellEditorValue() {
		return new String(getText());
	}
	
	public boolean isCellEditable(EventObject eo) {
		return true;
	}
	
	public boolean shouldSelectCell(EventObject eo) {
		return true;
	}
	
	public boolean stopCellEditing() {
		fireEditingStopped();
		editing=false;
		//make ok-cancel window visible
		helper.setVisible(false);
		//AbcTableContainer.renameFiles();
		return true;
	}
	
	public void addCellEditorListener(CellEditorListener cel) {
		listeners.addElement(cel);
	}
	
	public void removeCellEditorListener(CellEditorListener cel) {
		listeners.removeElement(cel);
	}
	
	protected void fireEditingCanceled() {
		setText(originalValue);
		ChangeEvent ce=new ChangeEvent(this);
		for (int i = listeners.size()-1; i >=0; i--) {
			((CellEditorListener)listeners.elementAt(i)).editingCanceled(ce);
		}
	}
	protected void fireEditingStopped() {
		ChangeEvent ce=new ChangeEvent(this);
		for(int i=listeners.size()-1;i>=0; i--) {
			((CellEditorListener)listeners.elementAt(i)).editingStopped(ce);
		}
	}
}
