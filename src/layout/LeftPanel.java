package layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.*;

import basicops.*;
import functions.fileops.SingleFileFetcher;

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = 8359920667364471604L;
	JButton undo;
	JButton redo;
	
	JButton saveAs;
	JButton save;
	JButton move;
	JButton delete;
	
	JButton cut;
	JButton paste;
	JButton copy;
	JButton rename;
	
	JButton newFile;
	JButton newFolder;
	
	public LeftPanel() {
		super();
		this.setPreferredSize(new Dimension(200,450));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//First Part
		Box bh1=Box.createHorizontalBox();
		Action action=new AbstractAction("Undo", new ImageIcon(getClass().getResource("/images/undo.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		undo=new JButton(action);
		undo.setVerticalTextPosition(SwingConstants.BOTTOM);
		undo.setHorizontalTextPosition(SwingConstants.CENTER);
		undo.setToolTipText("Undo Action");
		undo.setMinimumSize(new Dimension(65,45));
		undo.setMaximumSize(new Dimension(65,45));
		undo.setEnabled(false);
		bh1.add(undo);
		bh1.add(Box.createHorizontalStrut(40));
		
		action=new AbstractAction("Redo", new ImageIcon(getClass().getResource("/images/redo.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		redo=new JButton(action);
		redo.setVerticalTextPosition(SwingConstants.BOTTOM);
		redo.setHorizontalTextPosition(SwingConstants.CENTER);
		redo.setToolTipText("Redo Undone Action");
		redo.setMinimumSize(new Dimension(65,45));
		redo.setMaximumSize(new Dimension(65,45));
		redo.setEnabled(false);
		bh1.add(redo);
		this.add(bh1);
		add(Box.createVerticalStrut(20));
		
		//Second Part
		Box bh2=Box.createHorizontalBox();
		action=new AbstractAction("Save As", new ImageIcon(getClass().getResource("/images/saveas.jpg"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		saveAs=new JButton(action);
		saveAs.setVerticalTextPosition(SwingConstants.BOTTOM);
		saveAs.setHorizontalTextPosition(SwingConstants.CENTER);
		saveAs.setMinimumSize(new Dimension(65,45));
		saveAs.setMaximumSize(new Dimension(65,45));
		saveAs.setToolTipText("Save Current File As ...");
		saveAs.setEnabled(false);
		bh2.add(saveAs);
		bh2.add(Box.createHorizontalStrut(40));
		action=new AbstractAction("Save", new ImageIcon(getClass().getResource("/images/save.jpg"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		save=new JButton(action);
		save.setVerticalTextPosition(SwingConstants.BOTTOM);
		save.setHorizontalTextPosition(SwingConstants.CENTER);
		save.setMinimumSize(new Dimension(65,45));
		save.setMaximumSize(new Dimension(65,45));
		save.setToolTipText("Save Current File ...");
		save.setEnabled(false);
		bh2.add(save);
		add(bh2);
		
		Box bh3=Box.createHorizontalBox();
		action=new AbstractAction("Move", new ImageIcon(getClass().getResource("/images/move.jpg"))) {
			
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				try {
					new Move();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		move=new JButton(action);
		move.setVerticalTextPosition(SwingConstants.BOTTOM);
		move.setHorizontalTextPosition(SwingConstants.CENTER);
		move.setMinimumSize(new Dimension(65,45));
		move.setMaximumSize(new Dimension(65,45));
		move.setToolTipText("Move Current File ...");
		bh3.add(move);
		bh3.add(Box.createHorizontalStrut(40));
		action=new AbstractAction("Delete", new ImageIcon(getClass().getResource("/images/delete.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				try {
					new Delete();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		delete=new JButton(action);
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setMinimumSize(new Dimension(65,45));
		delete.setMaximumSize(new Dimension(65,45));
		delete.setToolTipText("Delete Current File ...");
		bh3.add(delete);
		add(bh3);
		add(Box.createVerticalStrut(20));
			
		//Third Part
		Box bh4=Box.createHorizontalBox();
		action=new AbstractAction("Cut", new ImageIcon(getClass().getResource("/images/cut.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		cut=new JButton(action);
		cut.setVerticalTextPosition(SwingConstants.BOTTOM);
		cut.setHorizontalTextPosition(SwingConstants.CENTER);
		cut.setMinimumSize(new Dimension(65,45));
		cut.setMaximumSize(new Dimension(65,45));
		cut.setToolTipText("Cut Current File ...");
		cut.setEnabled(false);
		bh4.add(cut);
		bh4.add(Box.createHorizontalStrut(40));
		action=new AbstractAction("Paste", new ImageIcon(getClass().getResource("/images/paste.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		paste=new JButton(action);
		paste.setVerticalTextPosition(SwingConstants.BOTTOM);
		paste.setHorizontalTextPosition(SwingConstants.CENTER);
		paste.setMinimumSize(new Dimension(65,45));
		paste.setMaximumSize(new Dimension(65,45));
		paste.setToolTipText("Paste Previously Cut File ...");
		paste.setEnabled(false);
		bh4.add(paste);
		add(bh4);
		
		Box bh5=Box.createHorizontalBox();
		action=new AbstractAction("Copy", new ImageIcon(getClass().getResource("/images/copy.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				try {
					new Copy();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		copy=new JButton(action);
		copy.setVerticalTextPosition(SwingConstants.BOTTOM);
		copy.setHorizontalTextPosition(SwingConstants.CENTER);
		copy.setMinimumSize(new Dimension(65,45));
		copy.setMaximumSize(new Dimension(65,45));
		copy.setToolTipText("Copy Current File ...");
		bh5.add(copy);
		bh5.add(Box.createHorizontalStrut(40));
		action=new AbstractAction("Rename", new ImageIcon(getClass().getResource("/images/rename.jpg"))) {
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
		rename=new JButton(action);
		rename.setVerticalTextPosition(SwingConstants.BOTTOM);
		rename.setHorizontalTextPosition(SwingConstants.CENTER);
		rename.setMinimumSize(new Dimension(65,45));
		rename.setMaximumSize(new Dimension(65,45));
		rename.setToolTipText("Rename Current File ...");
		bh5.add(rename);
		add(bh5);
		add(Box.createVerticalStrut(20));
	
		//Fourth Part
		Box bh6=Box.createHorizontalBox();
		action=new AbstractAction("New File", new ImageIcon(getClass().getResource("/images/newfile.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				try {
					new NewFile(NewFile.FILE_MODE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		newFile=new JButton(action);
		newFile.setVerticalTextPosition(SwingConstants.BOTTOM);
		newFile.setHorizontalTextPosition(SwingConstants.CENTER);
		newFile.setMinimumSize(new Dimension(65,45));
		newFile.setMaximumSize(new Dimension(65,45));
		newFile.setToolTipText("Create New File...");
		bh6.add(newFile);
		bh6.add(Box.createHorizontalStrut(40));
		
		action=new AbstractAction("New Folder", new ImageIcon(getClass().getResource("/images/newfolder.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				try {
					new NewFile(NewFile.FOLDER_MODE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		newFolder=new JButton(action);
		newFolder.setVerticalTextPosition(SwingConstants.BOTTOM);
		newFolder.setHorizontalTextPosition(SwingConstants.CENTER);
		newFolder.setMinimumSize(new Dimension(65,45));
		newFolder.setMaximumSize(new Dimension(65,45));
		newFolder.setToolTipText("Create New Folder ...");
		bh6.add(newFolder);
		this.add(bh6);
	}
}
