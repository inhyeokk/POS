import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// ó��ȭ���� ǥ���ϴ� �г�
public class InitialPanel extends JPanel {
	// *11.14 ���� main Ŭ������ �����ӿ� �߰��ϱ� ���� ���� �г� ����
	private JPanel mainPanel;

	// ��ܿ� �޼����� ����ϱ����� �гΰ� ���� ������ ǥ���ϱ����� �޼��� �г� ����
	private JPanel mainMessagePanel, selectMessagePanel;
	// ��ܿ� �޼����� ����ϱ� ���� �󺧼���
	private JLabel mainMessagelbl;
	// ���� ������ �����ϱ� ���� ��ư ����
	private JButton startProgramBtn, explainProgramBtn, exitBtn;

	// *11.24 ���� ����̹����� �ֱ� ���� �� ����
	private JLabel imagePrintlbl;

	// �̺�Ʈ �ڵ鷯 ��ü ����
	private selectMessageListener selectEvent;
	private MenuButtonListener mouseEvent;

	// ����� ���� �г� ��ü ����
	private DefaultSettingPanel DSP;
	private TableLayoutPanel TLP;

	// ����� ���� �г��� ����
	public InitialPanel() {
		// �����г��� ũ��� ���� ����
		this.setPreferredSize(new Dimension(1200, 800));
		this.setBackground(Color.white);
		this.setLayout(null);

		// �̺�Ʈ �ڵ鷯 ��ü ����
		selectEvent = new selectMessageListener();
		mouseEvent = new MenuButtonListener();

		// ����̹����� ���� �� �ҷ���
		ImageIcon img = new ImageIcon("image.jpg");

		// ����� ��Ʈ�� ��ü�� ���� �� ����
		Font Vdn60 = new Font("Verdana", Font.BOLD, 60);
		Font Vdn20 = new Font("Verdana", Font.BOLD, 20);

		// ���� �����ӿ� �߰��� ���� �г� ���� �� ����
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 800);
		mainPanel.setBackground(Color.white);
		mainPanel.setOpaque(false);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		this.add(mainPanel);

		// ������ ǥ�õ� �г��� ���� �� ���� �гο� �߰�
		DSP = new DefaultSettingPanel();
		DSP.setVisible(false);
		this.add(DSP);

		// �� Ȯ���� ���� �׽�Ʈ
		TLP = new TableLayoutPanel();
		TLP.setVisible(false);
		// this.add(TLP);

		// ����ڿ��� ������ �޼����� ����ϱ� ���� �г� ����
		mainMessagePanel = new JPanel();
		mainMessagePanel.setBounds(0, 0, 1200, 300);
		mainMessagePanel.setBackground(new Color(0, true));
		mainMessagePanel.setLayout(null);
		mainPanel.add(mainMessagePanel);

		mainMessagelbl = new JLabel("CHECK POS");
		mainMessagelbl.setBounds(400, 10, 400, 150);
		mainMessagelbl.setForeground(Color.black);
		mainMessagelbl.setFont(Vdn60);
		mainMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		mainMessagelbl.setVerticalAlignment(SwingConstants.CENTER);
		mainMessagePanel.add(mainMessagelbl);

		// ���α׷��� ���������� ��ư�� ��� �гλ���
		selectMessagePanel = new JPanel();
		selectMessagePanel.setBounds(1000, 500, 150, 150);
		selectMessagePanel.setBackground(new Color(0, true));
		selectMessagePanel.setLayout(new GridLayout(3, 1));
		mainPanel.add(selectMessagePanel);

		startProgramBtn = new JButton("LAUNCH");
		startProgramBtn.setFont(Vdn20);
		startProgramBtn.setBackground(Color.lightGray);
		startProgramBtn.setForeground(Color.black);
		startProgramBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		startProgramBtn.addActionListener(selectEvent);
		startProgramBtn.addMouseListener(mouseEvent);
		selectMessagePanel.add(startProgramBtn);

		explainProgramBtn = new JButton("EXPLAIN");
		explainProgramBtn.setFont(Vdn20);
		explainProgramBtn.setBackground(Color.lightGray);
		explainProgramBtn.setForeground(Color.black);
		explainProgramBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		explainProgramBtn.addActionListener(selectEvent);
		explainProgramBtn.addMouseListener(mouseEvent);
		selectMessagePanel.add(explainProgramBtn);

		exitBtn = new JButton("EXIT");
		exitBtn.setFont(Vdn20);
		exitBtn.setBackground(Color.lightGray);
		exitBtn.setForeground(Color.black);
		exitBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		exitBtn.addActionListener(selectEvent);
		exitBtn.addMouseListener(mouseEvent);
		selectMessagePanel.add(exitBtn);

		// ����̹����� ����
		imagePrintlbl = new JLabel(img);
		imagePrintlbl.setBounds(0, 0, 1200, 800);
		mainPanel.add(imagePrintlbl);
	}

	private class selectMessageListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// �̺�Ʈ�� �߻��� ������Ʈ�� ����
			int result;
			if (obj == startProgramBtn) {
				mainPanel.setVisible(false);
				DSP.setVisible(true);
				// TLP.setVisible(true);
			} else if (obj == explainProgramBtn) {
				// ����ڿ��� ���α׷� ��� ���ظ� �������� ���ο� �������� ������ ���α׷��� ���� ����� �� �ֵ��� ��
				JFrame explainFrame = new JFrame("����");
				explainFrame.setResizable(false);

				ExplainPanel exp = new ExplainPanel();

				explainFrame.getContentPane().add(exp);
				explainFrame.pack();
				explainFrame.setVisible(true);
			} else if (obj == exitBtn) {
				// �����ϱ� ���� ����ڿ��� �ѹ� �� ������ν� �߸� ������ ��츦 ����
				result = JOptionPane.showConfirmDialog(mainPanel, "���α׷��� �����Ͻðڽ��ϱ�?"); // �ȳ�â
				if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
					System.exit(0);
				}
			}
		} // actionPerformed()
	} // selectMessageListener class

	// ��ư�� ���콺�� ���������� ��ư ���� ����Ǵ� ���콺 ������
	private class MenuButtonListener implements MouseListener {
		public void mouseClicked(MouseEvent event) {
		}

		public void mousePressed(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
			JButton btnMenu = (JButton) event.getSource();
			btnMenu.setBackground(Color.white);
			btnMenu.setForeground(Color.black);
		} // mouseEntered()

		public void mouseExited(MouseEvent event) {
			JButton btnMenu = (JButton) event.getSource();
			btnMenu.setBackground(Color.LIGHT_GRAY);
			btnMenu.setForeground(Color.black);
		} // mouseExited()
	} // MenuButtonListener class
}// InitialPanel class
