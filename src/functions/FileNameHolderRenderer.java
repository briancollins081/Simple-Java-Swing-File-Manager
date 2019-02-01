package functions;

import java.awt.Component;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class FileNameHolderRenderer extends JTextField implements TableCellRenderer {
	private static final long serialVersionUID = -478977573055294085L;
	public FileNameHolderRenderer() {
		super(20);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, 
			Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if(value==null) {
			return this;
		}
		if(value instanceof FileNameHolder) {
			this.setText(((FileNameHolder)value).getFileName());
		}else {
			setText("Untilted");
		}
		return this;
	}
}
