package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import layout.LeftPanel;
import layout.MainMenuBar;
import layout.StatusBar;
import layout.TabbableTabs;
import layout.Titlebar;
import com.easynth.lookandfeel.EaSynthLookAndFeel;

public class App extends JFrame implements WindowListener{
	private static final long serialVersionUID = -7938707876112488534L;
	private JMenuBar menuBar;
	public App() throws Exception {
		setSize(1000, 700);
		setEasythLookAndFeel();
		setJMenuBar(new MainMenuBar().createMenuBar(menuBar));
		JPanel bodyPanel=(JPanel) getContentPane();
		bodyPanel.setLayout(new BorderLayout(5, 5));
		//Left Panel
		JPanel leftPanel=new JPanel(new BorderLayout( 5,5));
		leftPanel.add(new LeftPanel(),BorderLayout.CENTER);
		
		//Body Section
		JPanel centerPanel=new JPanel(new BorderLayout(5,5));
			//Title Section
			JPanel top=new JPanel(new GridLayout(1,3,3,3));
			top.add(new Titlebar());
			top.setSize(476,50);
			centerPanel.add(top,BorderLayout.NORTH);
			//Tabs section
			centerPanel.add(new TabbableTabs(),BorderLayout.CENTER);
			centerPanel.add(new StatusBar(), BorderLayout.SOUTH);
		
		bodyPanel.add(leftPanel, BorderLayout.WEST);
		bodyPanel.add(centerPanel,BorderLayout.CENTER);
		
		this.addWindowListener(this);
		
		StatusBar.setStatus("Launced AJF Manager");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	
	private void setEasythLookAndFeel() throws Exception {
		final EaSynthLookAndFeel eLAF=new EaSynthLookAndFeel();
		UIManager.setLookAndFeel(eLAF);
	}

	public static void main(String[] args) throws Exception {
		new App();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int winClose=JOptionPane.showConfirmDialog(App.this, "Are you sure you want to exit App?",
				"Exit System",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(winClose==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	public void setFrameVisible(boolean vis) {
		setVisible(vis);
	}
}
