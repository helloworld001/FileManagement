import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class information extends JPanel{

	private String path;
	JLabel pathLabel ;
	JLabel informLabel;
	public information() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		pathLabel =new JLabel("helloworld");
		informLabel = new JLabel("sdlkfj");
		pathLabel.setBounds(0, 0, 300, 30);
		informLabel.setBounds(300, 0, 300, 30);
		pathLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		informLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(pathLabel);
		add(informLabel);
		setBackground(Color.red);
	}
	public void setPath(String path){
		this.path = path;
		pathLabel.setText("Path>>>>"+path);
	}

}
