package layout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import main.App;
import operations.MyFileChooser;

public class MainMenuBar extends JMenuBar {
	private static final long serialVersionUID = -7908099261672588577L;
	protected JMenu file;
	protected JMenu edit;
	protected JMenu view;
	protected JMenu window;
	protected JMenu about;
	protected JMenuItem item;
	protected JMenuBar menuBar;
	
	public MainMenuBar() {
		super();
		createMenuBar(menuBar);
		this.setVisible(true);
	}
	public JMenuBar createMenuBar(JMenuBar menuBar){
		menuBar=new JMenuBar();
		//File Menu
		file=new JMenu("File");
		file.setPreferredSize(new Dimension(70,30));
		//file.setBorder(new EmptyBorder(new Insets(5, 5,5, 5)));
		file.setMnemonic('f');
		ImageIcon openIcon=new ImageIcon("/icons/open.png");
		Action action=new AbstractAction("Open File",openIcon) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		};
		item=new JMenuItem(action);
		file.add(item);
		
		ImageIcon openDirIcon=new ImageIcon("/icons/opendir.png");
		action=new AbstractAction("Open Folder",openDirIcon) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				openDirectory();				
			}
		};
		item=new JMenuItem(action);
		file.add(item);
		
		ImageIcon closeIcon=new ImageIcon("icons/close.png");
		action=new AbstractAction("Close",closeIcon) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		};
		item=new JMenuItem(action);
		file.add(item);
		
		ImageIcon exitIcon=new ImageIcon("icons/exit.png");
		action=new AbstractAction("Exit",exitIcon) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				exitSystem();
			}
		};
		item=new JMenuItem(action);
		file.addSeparator();
		file.add(item);
		
		add(file);
		menuBar.add(file);
		
		//Edit Menu
		edit=new JMenu("Edit");
		edit.setPreferredSize(new Dimension(70,30));
		//edit.setBorder(new EmptyBorder(new Insets(5, 25,5, 25)));
		edit.setMnemonic('e');
				
		ImageIcon undoImage=new ImageIcon("/icons/undo.png");
		action=new AbstractAction("Undo Last Action",undoImage) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				undoAction();
			}
		};
		item=new JMenuItem(action);
		edit.add(item);
		ImageIcon redoImage=new ImageIcon("/icons/redo.png");
		action=new AbstractAction("Redo Last Action",redoImage) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				redoAction();
			}
		};
		item=new JMenuItem(action);
		edit.add(item);
		menuBar.add(edit);
		
		//View Menu
		view=new JMenu("View");
		view.setPreferredSize(new Dimension(70,30));
		view.setMnemonic('v');
		
		//Sub Menu
		JMenu viewSubMenu=new JMenu("Sort");
		
		ImageIcon sortImage=new ImageIcon("/icons/sort.png");
		action=new AbstractAction("Sort By Name",sortImage) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				sortFiles();
			}
		};
		item=new JMenuItem(action);
		viewSubMenu.add(item);
		
		action=new AbstractAction("Sort By Size",sortImage) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				sortFiles();
			}
		};
		item=new JMenuItem(action);
		viewSubMenu.add(item);
		
		action=new AbstractAction("Sort By Modified",sortImage) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				sortFiles();
			}
		};
		item=new JMenuItem(action);
		viewSubMenu.add(item);
		
		view.add(viewSubMenu);
		menuBar.add(view);
		
		//Window Menu
		window=new JMenu("Window");
		window.setPreferredSize(new Dimension(70,30));
		window.setMnemonic('w');
				
		ImageIcon newWinImage=new ImageIcon("/icons/newWin.png");
		action=new AbstractAction("New Window",newWinImage) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				try {
					newWindow();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
		item=new JMenuItem(action);
		window.add(item);
		
		ImageIcon closeWinImage=new ImageIcon("/icons/closeWin.png");
		action=new AbstractAction("Close Window",closeWinImage) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		};
		item=new JMenuItem(action);
		window.add(item);
		menuBar.add(window);
		
		//About Menu
		about=new JMenu("About");
		about.setPreferredSize(new Dimension(70,30));
		about.setMnemonic('a');
				
		ImageIcon aboutImage=new ImageIcon("/icons/about.png");
		action=new AbstractAction("About Us",aboutImage) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				aboutUs();
			}
		};
		item=new JMenuItem(action);
		about.add(item);
		menuBar.add(about);
				
		return menuBar;
	}
	
	public void openFile(){
		try {
			new MyFileChooser(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openDirectory(){
		try {
			new MyFileChooser(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void exitSystem(){
		System.exit(0);
	}
	
	public void sortFiles(){
		
	}
	
	public void undoAction(){
		
	}
	
	public void redoAction(){
			
	}
	
	public void 	newWindow() throws Exception{
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				try {
					App a=new App();
					a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		SwingUtilities.invokeLater(runnable);
	}
	public void 	closeWindow(){
		JOptionPane.showMessageDialog(getParent(), "Exiting the Application Shortly ...", "System Warning!", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	public void aboutUs(){
		String msg="Welcome to AJF Manager\n"
				+ "Our aim is to ensure that the our users experience the best when it comes to file management\n"
				+ "This appliction is the start of our journey. It was released in August  15 2018 as the first prototype\n"
				+ "Tune in to get any updates:\n "
				+ "You can visit the application site from: https://www.andereproducts.com\n\r";
		JOptionPane.showMessageDialog(getParent(), msg, "About Us", JOptionPane.INFORMATION_MESSAGE);
	}
}
