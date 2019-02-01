package display;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.easynth.lookandfeel.EaSynthLookAndFeel;
@SuppressWarnings(value = { "unused"})
public class ProgressBarDemo extends JPanel{
	private static final long serialVersionUID = 253222517625096039L;
	private static JProgressBar pb;
	private static JTextArea dspa;
	private int progressValue;
	private int totalVal;
	private int currentVal;
	private String dispalyStr;
	
	static final int MY_MINIMUM=0;
	static final int MY_MAXIMUM=100;
	public ProgressBarDemo(JFrame wind) throws UnsupportedLookAndFeelException {
		final EaSynthLookAndFeel eLAF=new EaSynthLookAndFeel();
		UIManager.setLookAndFeel(eLAF);
		wind.setSize(new Dimension(150,150));
		pb=new JProgressBar();
		dspa=new JTextArea();
		
		pb.setMinimum(MY_MINIMUM);
		pb.setMaximum(MY_MAXIMUM);
		pb.setPreferredSize(new Dimension(500,20));
		add(pb,BorderLayout.CENTER);
		
		wind.getContentPane().add(pb, BorderLayout.PAGE_START);
		wind.getContentPane().add(new JScrollPane(dspa), BorderLayout.CENTER);
		wind.setVisible(true);
	}
	public void updateBar() {
		pb.setValue(100*(currentVal/totalVal));
	}
	public void setCurrentValue(int cVal) {
		currentVal=cVal;
	}
	public void setTotalValue(int tVal) {
		totalVal=tVal;
	}
	public void setDisplayText(String displayString) {
		dispalyStr=displayString;
		dspa.append(displayString);
	}
	public static void main(String[] args) {
		
		JFrame frame=new JFrame("Test Me");
	}
}
