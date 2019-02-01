package operations;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class CompressionOperationsPanel extends JPanel {
	private static final long serialVersionUID = -3505068012939959459L;
	JPanel fileCompression;
	JPanel fileExtraction;
	
	JButton compressSingleFile;
	JButton compressMultipleFiles;
	JButton addSingleFileToArchive;
	JButton addMultipleFilesToArchive;
	JButton compressSingleFileToFolder;
	JButton compressMultipleFilesToFolder;
	
	JButton extractSingleFile;
	JButton extractMultipleFiles;
	JButton extractWholeArchive;
	JButton splitArchive;
	JButton extractSingleFileToFolder;
	JButton extractMultipleFilesToFolder;
	JButton extractAllFilesToFolder;
	
	public CompressionOperationsPanel() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EmptyBorder(5,5,5,5));
		Box b=Box.createHorizontalBox();
		b.add(new JLabel("File Compression Operations"));
		b.setAlignmentY(LEFT_ALIGNMENT);
		b.setAlignmentX(LEFT_ALIGNMENT);
		this.add(b);
		this.add(Box.createVerticalStrut(20));
		Box bb=Box.createHorizontalBox();
		bb.add(createCompressionPanel());
		bb.add(Box.createHorizontalStrut(30));
		bb.add(createExtractionPanel());
		this.add(bb);
	}
	public JPanel createCompressionPanel(){
		fileCompression=new JPanel();
		fileCompression.setLayout(new BoxLayout(fileCompression, BoxLayout.Y_AXIS));
		fileCompression.setBorder(new CompoundBorder(
				new CompoundBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), 
						new TitledBorder("Compression")),new EmptyBorder(30,30,30,30)));
		
		Box bv1=Box.createVerticalBox();
		bv1.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		Action action=new AbstractAction("Compress a Single File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		compressSingleFile=new JButton(action);
		bv1.add(compressSingleFile);
		bv1.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Compress Multiple Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		compressMultipleFiles=new JButton(action);
		bv1.add(compressMultipleFiles);
		fileCompression.add(bv1);
		fileCompression.add(Box.createVerticalStrut(20));
		
		Box bv2=Box.createVerticalBox();
		bv2.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		action=new AbstractAction("Add a Single File To Archive",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		addSingleFileToArchive=new JButton(action);
		bv2.add(addSingleFileToArchive);
		bv2.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Add Multiple Files To Archive",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		addMultipleFilesToArchive=new JButton(action);
		bv2.add(addMultipleFilesToArchive);
		fileCompression.add(bv2);
		fileCompression.add(Box.createVerticalStrut(20));
		
		Box bv3=Box.createVerticalBox();
		bv3.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		action=new AbstractAction("Compress a File To a Folder",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		compressSingleFileToFolder=new JButton(action);
		bv3.add(compressSingleFileToFolder);
		bv3.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Compress Files To a Folder",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		compressMultipleFilesToFolder=new JButton(action);
		bv3.add(compressMultipleFilesToFolder);
		fileCompression.add(bv3);
		fileCompression.add(Box.createVerticalStrut(10));
		
		fileCompression.setMinimumSize(new Dimension(360,415));
		fileCompression.setMaximumSize(new Dimension(360,415));
		fileCompression.setPreferredSize(getMaximumSize());
		return fileCompression;
	}
	public JPanel createExtractionPanel(){
		fileExtraction=new JPanel();
		fileExtraction.setLayout(new BoxLayout(fileExtraction, BoxLayout.Y_AXIS));
		fileExtraction.setBorder(new CompoundBorder(
				new CompoundBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), 
						new TitledBorder("Extraction")),new EmptyBorder(30,30,30,30)));
		
		Box bv4=Box.createVerticalBox();
		bv4.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		Action action=new AbstractAction("Extract a Single File",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		extractSingleFile=new JButton(action);
		bv4.add(extractSingleFile);
		bv4.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Extract Multiple Files",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		extractMultipleFiles=new JButton(action);
		bv4.add(extractMultipleFiles);
		fileExtraction.add(bv4);
		fileExtraction.add(Box.createVerticalStrut(20));
		
		Box bv5=Box.createVerticalBox();
		bv5.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		action=new AbstractAction("Extract Whole Archive",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		extractWholeArchive=new JButton(action);
		bv5.add(extractWholeArchive);
		bv5.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Split Archive",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		splitArchive=new JButton(action);
		bv5.add(splitArchive);
		fileExtraction.add(bv5);
		fileExtraction.add(Box.createVerticalStrut(20));
		
		Box bv6=Box.createVerticalBox();
		bv6.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
		action=new AbstractAction("Extract a File To a Folder",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		extractSingleFileToFolder=new JButton(action);
		bv6.add(extractSingleFileToFolder);
		bv6.add(Box.createVerticalStrut(10));
		
		action=new AbstractAction("Extract Files To a Folder",new ImageIcon(getClass().getResource("/images/b.jpg"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
			}
		};
		extractMultipleFilesToFolder=new JButton(action);
		bv6.add(extractMultipleFilesToFolder);
		fileExtraction.add(bv6);
		fileExtraction.add(Box.createVerticalStrut(10));
		
		fileExtraction.setMinimumSize(new Dimension(360,415));
		fileExtraction.setMaximumSize(new Dimension(360,415));
		fileExtraction.setPreferredSize(getMaximumSize());
		return fileExtraction;
	}
}
