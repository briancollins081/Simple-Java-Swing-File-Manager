package layout;

import javax.swing.*;

import operations.CompressionOperationsPanel;
import operations.DecryptionPanel;
import operations.EncryptionPanel;
import operations.FileOperationsPanel;

public class TabbableTabs extends JTabbedPane {
	private static final long serialVersionUID = 7241100123191364937L;
	JPanel panel;
	public TabbableTabs(){
		super(JTabbedPane.TOP, JTabbedPane.HORIZONTAL);
		this.setSize(640,330);
		this.addTab("File Operations", new ImageIcon(getClass().getResource("/images/newfolder.jpg")), createFileOperationsTab());
		this.addTab("Compression", new ImageIcon(getClass().getResource("/images/compress.png")), createCompressionTab());
		this.addTab("Decrytpion", new ImageIcon(getClass().getResource("/images/decrypt.jpg")), createDecryptionTab());
		this.addTab("Encryption", new ImageIcon(getClass().getResource("/images/encrypt.jpg")),createEncryptionTab());
		
	}
	public JPanel createFileOperationsTab(){
		
		return new FileOperationsPanel();
	}
	
	public JPanel createCompressionTab(){
		
		return new CompressionOperationsPanel();	
	}
	public JPanel createDecryptionTab(){
		
		return new DecryptionPanel();
	}
	public JPanel createEncryptionTab(){
		
		return new EncryptionPanel();
		
	}
}
