import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;



public class FileManage extends JPanel{

	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode oldNode;
	private DefaultMutableTreeNode cloneNode;
	private JTree tree ;
	public static final ImageIcon folderIcon = new ImageIcon("img/folderimg.png");
	public static final ImageIcon fileIcon = new ImageIcon("img/fileimg.png");
	private DefaultTreeModel treeModel;
	private JSplitPane splitPane;
	private JScrollPane textscrollPane;
	private JTextPane textPane;
	private boolean isCopy = false;
	public FileManage(){
		setLayout(null);
		setBackground(Color.black);
		Border border = BorderFactory.createEtchedBorder(Color.red, Color.red);
		setBorder(border);
		root= new DefaultMutableTreeNode("root");
		root.isRoot();
		tree = new JTree(root);
		tree.setBackground(Color.orange);
		tree.setToggleClickCount(1);
		tree.addTreeSelectionListener(new treeClickListener());
		tree.setEditable(false);
		treeModel = (DefaultTreeModel)tree.getModel();		
		DefaultTreeCellRenderer renderer =  new DefaultTreeCellRenderer();
		tree.setCellRenderer(renderer);
		
		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setMinimumSize(new Dimension(200, 500));
		scrollPane.setBackground(Color.black);
		
		textPane = new JTextPane(){
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				ImageIcon img = new ImageIcon("img/background.png");
				g.drawImage(img.getImage(), 0, 0, 380, 500, this);
				super.paintComponent(g);
				{setOpaque(false);}
			}
		};
		textPane.setBackground(Color.orange);
		textPane.setEditable(true);
		textPane.setMinimumSize(new Dimension(380,500));
		textPane.setOpaque(false);
		textscrollPane= new JScrollPane(textPane);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(scrollPane);
		splitPane.setRightComponent(textscrollPane);
		splitPane.setSize(600, 500);
		add(splitPane);
		
	}

	
	public void initText(){
		textPane.setText("");
	}
	
	public void addFile(){
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(node==null||!node.getAllowsChildren()){
			return;
		}
		else{
			String name = JOptionPane.showInputDialog("input file name","New File");
		if(name!=null){
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("helloworld");
			newNode.setAllowsChildren(false);
			FileMessage file =new FileMessage();
			file.setName(name);
			newNode.setUserObject(file);
			node.add(newNode);
			TreeNode[] nodes = treeModel.getPathToRoot(newNode);  
			TreePath path = new TreePath(nodes);  
			tree.scrollPathToVisible(path); 
			tree.updateUI();
		}
	}
	}
	
	public void addFolder(){
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(node==null||!node.getAllowsChildren()){
			return;
		}
		else{
			String name = JOptionPane.showInputDialog("input folder name","New Folder");
		    if(name!=null){
			    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(name);
			    newNode.setAllowsChildren(true);
			    newNode.setUserObject(new FolderMessage(name));
			    node.add(newNode);
			    tree.updateUI();
		}
	}
	}
	public void delete(){
		
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(node==null||node.getParent()==null) return;
		if(JOptionPane.showConfirmDialog(null, "确认删除？")==JOptionPane.YES_OPTION){
		if(node!=null&&node.getParent()!=null){
			textPane.setText("");
			treeModel.removeNodeFromParent(node);			
		}	
		}
	}
	public void format(){
		if(JOptionPane.showConfirmDialog(null, "确认格式化？")==JOptionPane.YES_OPTION){
			root.removeAllChildren();
			tree.updateUI();
			textPane.setText("");
		}
		
	}
	public void copy(){
		isCopy = true;
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(node!=null&&node.getParent()!=null){
			cloneNode = (DefaultMutableTreeNode)node.clone();
		}
	}
	public void paste(){
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(node==null&&!node.getAllowsChildren()) return;
		if(isCopy){
			node.add(cloneNode);
			tree.updateUI();
		}
	}
	

	
	class treeClickListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			// TODO Auto-generated method stub
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if(node==null)return;
			if(oldNode!=node&&oldNode!=null&&!oldNode.getAllowsChildren()){
				String s = ((FileMessage)oldNode.getUserObject()).getText();
				String s2 = textPane.getText();
				if(s.equals(s2)){
					
				}
				else{
					((FileMessage)oldNode.getUserObject()).setSaved(false);
				}
				if(!((FileMessage)oldNode.getUserObject()).Saved()){
				if(JOptionPane.showConfirmDialog(null, "需要保存吗？")==JOptionPane.YES_OPTION){
					textPane.setEditable(true);
					((FileMessage)oldNode.getUserObject()).setText(textPane.getText());
					((FileMessage)oldNode.getUserObject()).setSaved(true);
				}
				
			}
			}
			oldNode=node;
			if(!node.getAllowsChildren()){
				textPane.setEditable(true);
				FileMessage file = (FileMessage)node.getUserObject();
				textPane.setText(file.getText());
			}
			else if(node.getAllowsChildren()){
				textPane.setText("");
				textPane.setEditable(true);
				
			}
			
		}

	}
	public void saveText(){
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(!node.getAllowsChildren()){
			textPane.setEditable(true);
			((FileMessage)node.getUserObject()).setText(textPane.getText());
			
		}
		else{
			textPane.setText("");
			textPane.setEditable(true);
			
		}
	}
	public void clearText(){
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(!node.getAllowsChildren()){
			textPane.setEditable(true);
			((FileMessage)node.getUserObject()).setText("");
			
		}
		else{
			textPane.setText("");
			textPane.setEditable(true);
	}
	}

}


