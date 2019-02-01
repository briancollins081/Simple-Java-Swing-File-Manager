package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class NavigationTable extends JFrame{
	private static final long serialVersionUID = 6108992429894086481L;
	public static final int SINGLE_FILE_MODE=1;
	public static final int MULTIPLE_FILES_MODE=2;
	private int mode;
	public NavigationTable(int mode) throws IOException {
		this.mode=mode;
		JPanel body=new JPanel();
		body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
		body.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
		
		Box vb=Box.createVerticalBox();
		vb.add(createTopPanel());
		vb.add(Box.createVerticalStrut(20));
		vb.add(createMainPanel());
		
		body.add(vb);
		setSize(1000,600);
		this.add(body,BorderLayout.CENTER);
		setVisible(true);
	}
	public JPanel createTopPanel() {
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		
		JLabel title=new JLabel("File Display Area");
		title.setSize(p.getWidth(), p.getHeight());
		
		Box bh=Box.createHorizontalBox();
		bh.add(Box.createGlue());
		bh.add(title);
		bh.add(Box.createGlue());
		
		p.add(bh);
		
		return p;
	}
	public JPanel createMainPanel() throws IOException {
		JPanel mp=new JPanel(new BorderLayout());
		mp.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED,Color.gray,Color.gray),"Files List: Perform Your Operations From Here:", TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
		mp.add(new functions.AbcTableContainer(this.mode),BorderLayout.CENTER);
		return mp;
	}
}
