package layout;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StatusBar extends JPanel {
	private static final long serialVersionUID = -1925950411641164017L;
	static JLabel status;
	static JTextField field;
	public StatusBar() {
		super();
		this.setLayout(new BorderLayout());
		this.setSize(1000,50);
		this.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new TitledBorder(new LineBorder(getForeground()),"App Events")));
		status=new JLabel("Status : ");
		field=new JTextField();
		field.setEditable(false);
		this.add(status);
		this.add(field);
	}
	public static void setStatus(String state){
		field.setText(state);
	}
	public static JTextField getStatusAreaPane() {
		return field;
	}
}
