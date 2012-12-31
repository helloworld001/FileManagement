import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;


public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	FileManage fileManage;	
	information inform;
	helpPanel hFrame = new helpPanel();
	aboutUsPanel aboutFrame = new aboutUsPanel();
	JPanel panel;
	public MainFrame(){
		setLayout(null);
		setResizable(false);
		setTitle("FileManagment");
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu fileMenu = new JMenu("File");
		JMenu viewMenu = new JMenu("View");
		JMenu helpMenu = new JMenu("Help");
		bar.add(fileMenu);
		bar.add(viewMenu);
		bar.add(helpMenu);
		
		JMenuItem newFile = new JMenuItem("New File",new ImageIcon("img/newFile.png"));
		newFile.addActionListener(new newFileAcion());
		newFile.setAccelerator(KeyStroke.getKeyStroke("ctrl o"));
		
		JMenuItem newFolder = new JMenuItem("New Folder",new ImageIcon("img/newFolder.png"));
		newFolder.addActionListener(new newFolderAcion());
		
		JMenuItem saveFile = new JMenuItem("Save",new ImageIcon("img/save.png"));
		saveFile.addActionListener(new saveFileAcion());
		saveFile.setAccelerator(KeyStroke.getKeyStroke("ctrl s"));
		
		JMenuItem format = new JMenuItem("Formate",new ImageIcon("img/saveAs.png"));
		format.addActionListener(new formatAcion());
		
		JMenuItem copyFile = new JMenuItem("Copy",new ImageIcon("img/copy.png"));
		copyFile.addActionListener(new copyFileAcion());
		
		copyFile.setAccelerator(KeyStroke.getKeyStroke("ctrl c"));
		JMenuItem pastFile = new JMenuItem("Past",new ImageIcon("img/past.png"));
		pastFile.addActionListener(new pastFileAction());		
		pastFile.setAccelerator(KeyStroke.getKeyStroke("ctrl v"));
		
		JMenuItem deleteFile = new JMenuItem("Delete",new ImageIcon("img/delete.png"));
		deleteFile.addActionListener(new deleteFileAcion());
		
		JMenuItem exit = new JMenuItem("Exit",new ImageIcon("img/exit.png"));
		exit.addActionListener(new exitAcion());
		
		fileMenu.add(newFile);
		fileMenu.add(newFolder);
		fileMenu.add(saveFile);
		fileMenu.add(format);
		fileMenu.add(copyFile);
		fileMenu.add(pastFile);
		fileMenu.add(deleteFile);
		fileMenu.add(exit);
		
		JMenuItem listShow = new JMenuItem("List",new ImageIcon("img/list.png"));
		listShow.addActionListener(new listShowAction());
		JMenuItem iconShow = new JMenuItem("Icon",new ImageIcon("img/icon.png"));
		iconShow.addActionListener(new iconShowAction());
		
		viewMenu.add(listShow);
		viewMenu.add(iconShow);
		
		JMenuItem aboutItem = new JMenuItem("About Us",new ImageIcon("img/aboutus.png"));
		aboutItem.addActionListener(new aboutUsAcion());
		JMenuItem helpItem = new JMenuItem("Help",new ImageIcon("img/help.png"));
		helpItem.addActionListener(new helpAction());
		
		helpMenu.add(aboutItem);
		helpMenu.add(helpItem);
		
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem popnewFile = new JMenuItem("New File",new ImageIcon("img/newFile.png"));
		popnewFile.addActionListener(new newFileAcion());
		JMenuItem popnewFolder = new JMenuItem("New Folder",new ImageIcon("img/newFolder.png"));
		popnewFolder.addActionListener(new newFolderAcion());
		JMenuItem popcopyFile = new JMenuItem("Copy",new ImageIcon("img/copy.png"));
		popcopyFile.addActionListener(new copyFileAcion());
		JMenuItem poppastFile = new JMenuItem("Past",new ImageIcon("img/past.png"));
		poppastFile.addActionListener(new pastFileAction());
		JMenuItem popdeleteFile = new JMenuItem("Delete",new ImageIcon("img/delete.png"));
		popdeleteFile.addActionListener(new deleteFileAcion());
		popupMenu.add(popnewFile);
		popupMenu.add(popnewFolder);
		popupMenu.add(popdeleteFile);
		popupMenu.add(popcopyFile);
		popupMenu.add(poppastFile);
		
		fileManage = new FileManage();
		fileManage.setBounds(5,30,600, 500);
		add(fileManage);
				
		inform  = new information();
		inform.setBounds(0, 0, 600, 30);
		//add(inform);
		
		
	}
	
	class newFileAcion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fileManage.addFile();
		}
		
	}
	class newFolderAcion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fileManage.addFolder();
		}
		
	}
	class copyFileAcion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fileManage.copy();
		}
		
	}
	class pastFileAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fileManage.paste();
		}
		
	}
	class deleteFileAcion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fileManage.delete();
			
		}
		
	}
	class exitAcion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
			
		}
		
	}
	class saveFileAcion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fileManage.saveText();
			
		}
		
	}
	class formatAcion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fileManage.format();
		}
		
	}
	class listShowAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class iconShowAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class aboutUsAcion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			aboutFrame.setVisible(true);
		}
		
	}
	class helpAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//JOptionPane.showMessageDialog(null, hPanel);
			hFrame.setVisible(true);
		}
	}
}
