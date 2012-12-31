import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import org.omg.CORBA.PUBLIC_MEMBER;


public class EditManage extends JPanel{
	JScrollPane scrollPane;
	JTextPane textPane;
	public EditManage(){
		setLayout(null);
		textPane = new JTextPane(){
			public void paintComponent(Graphics g){
				//super.paintComponents(g);
				ImageIcon img = new ImageIcon("img/background.png");
				g.drawImage(img.getImage(), 0, 0, 380, 500, this);
			}
			private static final long serialVersionUID = 1L;

			{setOpaque(false);}
		};
		textPane.setEditable(true);
		textPane.setBounds(0, 70, 380, 500);
		scrollPane= new JScrollPane(textPane);
		add(textPane);
	}
	public void paintComponent(Graphics g){
		//super.paintComponents(g);
		ImageIcon img = new ImageIcon("img/background.png");
		g.drawImage(img.getImage(), 0, 0, 380, 500, this);
	}
	public void initText(){
		textPane.setText("");
	}
}

