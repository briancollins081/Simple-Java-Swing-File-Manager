package functions;

import javax.swing.table.*;
import javax.swing.*;
public class TableCustomColumnModel {
	private double colPercentages[]= {5,5,40,40,10};
	private int cols;
	JTable table;
	
	public TableCustomColumnModel(JTable t,  int prefWidth) {
		super();
		table=t;
		cols=table.getColumnCount();
		
		setColumnsSizes();
	}

	void setColumnsSizes() {
		double total=0;	
		for (int i = 0; i < cols; i++) {
			total+=colPercentages[i];
		}
		for (int i = 0; i < cols; i++) {
			TableColumn tc=table.getColumnModel().getColumn(i);
			tc.setPreferredWidth((int) (colPercentages[i]/total));
		}
	}
}
