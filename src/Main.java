import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main {
	public static void main(String[] args){
		MainFrame frame = new MainFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				if(JOptionPane.showConfirmDialog(null,"ÍË³ö")==JOptionPane.YES_OPTION)
				System.exit(0);
				else return;////////////////////////////////////////////
			}
		});
		frame.setVisible(true);
	}
}
