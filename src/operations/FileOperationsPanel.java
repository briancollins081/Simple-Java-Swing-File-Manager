package operations;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import functions.fileops.MultipleFilesFetcher;
import functions.fileops.SingleFileFetcher;

public class FileOperationsPanel extends JPanel {
	private static final long serialVersionUID = 57865761005534909L;
	JPanel renamePanel;
	JPanel otherPanel;
	
	JButton renameSingleFile;
	JButton renameMultipleFiles;
	JButton createSinlgeTextFile;
	JButton createMultipleTextFiles;
	
	JButton moveSingleFile;
	JButton moveMultipleFiles;
	JButton duplicateSingleFile;
	JButton duplicateMultipleFiles;
	JButton deleteSingleFile;
	JButton deleteMultipleFiles;
	
	public FileOperationsPanel() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EmptyBorder(5,5,5,5));
		Box b=Box.createHorizontalBox();
		b.add(new JLabel("File Operations | Functions"));
		b.setAlignmentY(CENTER_ALIGNMENT);
		b.setAlignmentX(LEFT_ALIGNMENT);
		this.add(b);
		this.add(Box.createVerticalStrut(20));
		Box bb=Box.createHorizontalBox();
		bb.add(createRenamePanel());
		bb.add(Box.createHorizontalStrut(30));
		bb.add(createOtherPanel());
		this.add(bb);
	}
	public JPanel createRenamePanel(){
		renamePanel=new JPanel();
		renamePanel.setLayout(new BoxLayout(renamePanel, BoxLayout.Y_AXIS));
		renamePanel.setBorder(new CompoundBorder(
				new CompoundBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), 
						new TitledBorder("Renaming")),new EmptyBorder(30,30,30,30)));
		
		Box bv1=Box.createVerticalBox();
		bv1.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		Action action=new AbstractAction("Rename a Single File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				try {
					new SingleFileFetcher();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		};
		renameSingleFile=new JButton(action);
		bv1.add(renameSingleFile);
		bv1.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Rename Multiple Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				try {
					new MultipleFilesFetcher();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		};
		renameMultipleFiles=new JButton(action);
		bv1.add(renameMultipleFiles);
		renamePanel.add(bv1);
		renamePanel.add(Box.createVerticalStrut(20));
		
		Box bv2=Box.createVerticalBox();
		bv2.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		action=new AbstractAction("Create Single Text File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		createSinlgeTextFile=new JButton(action);
		bv2.add(createSinlgeTextFile);
		bv2.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Create Multiple Text Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		createMultipleTextFiles=new JButton(action);
		bv2.add(createMultipleTextFiles);
		renamePanel.add(bv2);
		renamePanel.add(Box.createVerticalStrut(20));
		
		renamePanel.setMinimumSize(new Dimension(360,415));
		renamePanel.setMaximumSize(new Dimension(360,415));
		renamePanel.setPreferredSize(getMaximumSize());
		return renamePanel;
	}
	public JPanel createOtherPanel(){
		otherPanel=new JPanel();
		otherPanel.setLayout(new BoxLayout(otherPanel, BoxLayout.Y_AXIS));
		otherPanel.setBorder(new CompoundBorder(
				new CompoundBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), 
						new TitledBorder("Other File Operations")),new EmptyBorder(30,30,30,30)));
		
		Box bv4=Box.createVerticalBox();
		bv4.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		Action action=new AbstractAction("Move a Single File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		moveSingleFile=new JButton(action);
		bv4.add(moveSingleFile);
		bv4.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Move Multiple Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		moveMultipleFiles=new JButton(action);
		bv4.add(moveMultipleFiles);
		otherPanel.add(bv4);
		otherPanel.add(Box.createVerticalStrut(20));
		
		Box bv5=Box.createVerticalBox();
		bv5.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		action=new AbstractAction("Duplicate a Single File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		duplicateSingleFile=new JButton(action);
		bv5.add(duplicateSingleFile);
		bv5.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Duplicate Multiple Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		duplicateMultipleFiles=new JButton(action);
		bv5.add(duplicateMultipleFiles);
		otherPanel.add(bv5);
		otherPanel.add(Box.createVerticalStrut(20));
		
		Box bv6=Box.createVerticalBox();
		bv6.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		action=new AbstractAction("Delete Single File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		deleteSingleFile=new JButton(action);
		bv6.add(deleteSingleFile);
		bv6.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Delete Multiple Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		deleteMultipleFiles=new JButton(action);
		bv6.add(deleteMultipleFiles);
		otherPanel.add(bv6);
		otherPanel.add(Box.createVerticalStrut(10));
		
		otherPanel.setMinimumSize(new Dimension(360,415));
		otherPanel.setMaximumSize(new Dimension(360,415));
		otherPanel.setPreferredSize(getMaximumSize());
		return otherPanel;
	}
}
