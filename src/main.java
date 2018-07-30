import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame mainFrame = new JFrame("CHECK POS");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);

		InitialPanel IP = new InitialPanel();
		mainFrame.getContentPane().add(IP);

		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
