package operations;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class DecryptionPanel extends JPanel {
	private static final long serialVersionUID = 3342035238702461927L;
	JLabel titlePanel;
	JPanel decryptionPanel;
	
	JButton decryptSingleFile;
	JButton decryptMultipleFiles;
	JButton decryptSingleArchive;
	JButton decryptMultipleArchives;
	
	public DecryptionPanel() {
		super();
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Box b=Box.createHorizontalBox();
		b.add(new JLabel("File Decryption Operations"));
		this.add(b);
		this.add(Box.createVerticalStrut(50));
		this.add(createDecryptionPanel());
	}
	
	public JPanel createDecryptionPanel(){
		decryptionPanel=new JPanel();
		decryptionPanel.setLayout(new BoxLayout(decryptionPanel, BoxLayout.Y_AXIS));
		decryptionPanel.setBorder(new CompoundBorder(
				new CompoundBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), 
						new TitledBorder("Main Fucntions")),new EmptyBorder(30, 30, 30, 30)));
		decryptionPanel.add(Box.createVerticalStrut(30));
		Box bv1=Box.createVerticalBox();
		Action action=new AbstractAction("Decrypt a Single File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		decryptSingleFile=new JButton(action);
		bv1.add(decryptSingleFile);
		bv1.add(Box.createVerticalStrut(10));
		action=new AbstractAction("Decrypt Multiple Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		decryptMultipleFiles=new JButton(action);
		bv1.add(decryptMultipleFiles);	
		decryptionPanel.add(bv1);
		
		decryptionPanel.add(Box.createVerticalStrut(70));
		
		Box bv2=Box.createVerticalBox();
		action=new AbstractAction("Decrypt a Single Archive",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		decryptSingleArchive=new JButton(action);
		bv2.add(decryptSingleArchive);
		bv2.add(Box.createVerticalStrut(10));
		action=new AbstractAction("Decrypt Multiple Archives",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		decryptMultipleArchives=new JButton(action);
		bv2.add(decryptMultipleArchives);
		decryptionPanel.add(bv2);
		decryptionPanel.add(Box.createVerticalStrut(30));
		decryptionPanel.setMinimumSize(new Dimension(360,390));
		decryptionPanel.setMaximumSize(new Dimension(360,390));
		decryptionPanel.setPreferredSize(new Dimension(360,390));
		return decryptionPanel;
	}
}
