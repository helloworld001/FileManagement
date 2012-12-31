import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class helpPanel extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextArea text;
	public helpPanel() {
		// TODO Auto-generated constructor stub
		setName("Help");
		setSize(400, 500);
		text = new JTextArea();
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		add(scrollPane);
		setText();
	}
	private void setText(){
		text.setText("lksdajflkasdjfklsadjf;klsajdf");
		text.append("helloworld");
	}
	

}
