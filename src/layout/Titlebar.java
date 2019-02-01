package layout;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

public class Titlebar extends JPanel {
	private static final long serialVersionUID = -4490911758411482837L;
	JLabel horMenuBtn;
	JLabel titleBtn;
	JLabel vertMenuBtn;
	public Titlebar() {
		this.setLayout(new BorderLayout(5,5));
		this.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		
		this.add(this.createTitlePane(), BorderLayout.CENTER);
	}
	public JPanel createTitlePane(){
		JPanel t=new JPanel(new BorderLayout(4,8));
		ImageIcon img=new ImageIcon(getClass().getResource("/images/menubar.jpeg"));
		horMenuBtn=new JLabel(img,JLabel.LEFT);
		
		img=new ImageIcon(getClass().getResource("/images/title.jpeg"));
		titleBtn=new JLabel(img,JLabel.CENTER);
		
		img=new ImageIcon(getClass().getResource("/images/menuv.jpeg"));
		vertMenuBtn=new JLabel(img,JLabel.LEFT);
		
		t=new JPanel(new BorderLayout(5, 5));
		t.add(horMenuBtn,BorderLayout.WEST);
		t.add(titleBtn,BorderLayout.CENTER);
		t.add(vertMenuBtn,BorderLayout.EAST);
		/*	t.setMaximumSize(new Dimension(380,35));
			t.setMinimumSize(new Dimension(380,35));
			t.setPreferredSize(getMaximumSize());
		*/
		return t;
	}
}
