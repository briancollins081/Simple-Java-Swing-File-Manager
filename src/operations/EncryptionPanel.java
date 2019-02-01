package operations;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class EncryptionPanel extends JPanel {
	private static final long serialVersionUID = 1850489055182572082L;

	JPanel encryptionPanel;
	
	JButton encryptSingleFile;
	JButton encryptMultipleFiles;
	JButton encryptSingleArchive;
	JButton encryptMultipleArchives;
	
	public EncryptionPanel() {
		super();
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Box b=Box.createHorizontalBox();
		b.add(new JLabel("File Encryption Operations"));
		this.add(b);
		this.add(Box.createVerticalStrut(50));
		this.add(createEncryptionPanel());
	}
	
	public JPanel createEncryptionPanel(){
		encryptionPanel=new JPanel();
		encryptionPanel.setLayout(new BoxLayout(encryptionPanel, BoxLayout.Y_AXIS));
		encryptionPanel.setBorder(new CompoundBorder(
				new CompoundBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), 
						new TitledBorder("Main Fucntions")),new EmptyBorder(30, 30, 30, 30)));
		encryptionPanel.add(Box.createVerticalStrut(30));
		Box bv1=Box.createVerticalBox();
		Action action=new AbstractAction("Encrypt a Single File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		encryptSingleFile=new JButton(action);
		bv1.add(encryptSingleFile);
		bv1.add(Box.createVerticalStrut(10));
		action=new AbstractAction("Encrypt Multiple Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		encryptMultipleFiles=new JButton(action);
		bv1.add(encryptMultipleFiles);	
		encryptionPanel.add(bv1);
		
		encryptionPanel.add(Box.createVerticalStrut(70));
		
		Box bv2=Box.createVerticalBox();
		action=new AbstractAction("Encrypt a Single Archive",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		encryptSingleArchive=new JButton(action);
		bv2.add(encryptSingleArchive);
		bv2.add(Box.createVerticalStrut(10));
		action=new AbstractAction("Encrypt Multiple Archives",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		encryptMultipleArchives=new JButton(action);
		bv2.add(encryptMultipleArchives);
		encryptionPanel.add(bv2);
		encryptionPanel.add(Box.createVerticalStrut(30));
		encryptionPanel.setMinimumSize(new Dimension(360,390));
		encryptionPanel.setMaximumSize(new Dimension(360,390));
		encryptionPanel.setPreferredSize(new Dimension(360,390));
		return encryptionPanel;
	}
}
