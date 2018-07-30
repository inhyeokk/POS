import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// *11.28 �ۼ�
public class SalesPrintPanel extends JPanel {
	private JPanel mainPanel;

	// ����ڿ��� �޼����� ����ϱ� ���� �гΰ� �� ����
	private JPanel MessagePanel;
	private JLabel defaultMessagelbl;
	private LabelThread lblThread;

	// ����� ��¥�� �����ֱ� ���� �гΰ� �� ����
	private JPanel dateShowPanel;
	private JLabel yearlbl, monthlbl, daylbl;

	// ����� �Ϸ� ����� ���� �Ѵ� ����, ���� �ϸ����� ���� ��ư�� �г� �� ����
	private JPanel salesMainPanel;
	private JPanel salesLeftPanel, salesRightPanel;
	private JButton dailySalesBtn;
	private JLabel dailySaleslbl;
	private JButton estimatedMonthlySalesBtn;
	private JLabel estimatedMonthlySaleslbl;
	private JButton estimatedDailySalesBtn;
	private JLabel estimatedDailySaleslbl;

	private int dailySale, estimatedMonthlySales, estimatedDailySales;
	private int[] menuPrice;
	private int[] menuCnt;

	// �Է¿Ϸ� �� ���α׷� ���Ḧ ������ �г� �� ��ư�� ��ü ����
	private JPanel completePanel;
	private JButton completeBtn;

	// ����� �����г��� ��ü ����
	private DefaultSettingPanel DSP;
	private TableLayoutPanel TLP;

	// �̺�Ʈ �ڵ鷯 ��ü ����
	private showSalesListener showSalesL;
	private MenuButtonListener menuBtnL;
	private MouseMovementListener mouseMovementL;
	private InputCompleteListener inputCompleteL;

	public SalesPrintPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(null);

		DSP = new DefaultSettingPanel(this);
		TLP = new TableLayoutPanel(this);

		showSalesL = new showSalesListener();
		menuBtnL = new MenuButtonListener();
		mouseMovementL = new MouseMovementListener();
		inputCompleteL = new InputCompleteListener();

		// ����� ��Ʈ�� ��ü�� ���� �� ����
		Font Vdn50 = new Font("Verdana", Font.BOLD, 50);
		Font Vdn28 = new Font("Verdana", Font.BOLD, 28);
		Font Vdn24 = new Font("Verdana", Font.BOLD, 24);
		Font Vdn12 = new Font("Verdana", Font.BOLD, 12);

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 800);
		mainPanel.setVisible(true);
		mainPanel.setLayout(null);
		this.add(mainPanel);

		// ����ڿ��� �޼����� ����ϱ����� �г�
		MessagePanel = new JPanel();
		MessagePanel.setBounds(300, 20, 600, 50);
		MessagePanel.setBackground(Color.black);
		MessagePanel.setLayout(null);
		mainPanel.add(MessagePanel);

		// ���� ������� ��
		defaultMessagelbl = new JLabel("Sales Arrangement");
		defaultMessagelbl.setBounds(10, 5, 580, 40);
		defaultMessagelbl.setFont(Vdn24);
		defaultMessagelbl.setForeground(Color.white);
		defaultMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		defaultMessagelbl.setVisible(true);
		MessagePanel.add(defaultMessagelbl);

		lblThread = new LabelThread(this);
		lblThread.setBounds(10, 5, 580, 40);
		lblThread.setFont(Vdn24);
		lblThread.setForeground(Color.white);
		lblThread.setHorizontalAlignment(SwingConstants.CENTER);
		lblThread.setVisible(false);
		MessagePanel.add(lblThread);

		// -----------------------------------------------------------
		// DefaultSettingPanel���� �Է¹޾� ����� ��¥�� ����ϴ� �г� �� �� ����
		dateShowPanel = new JPanel();
		dateShowPanel.setBounds(25, 20, 150, 50);
		dateShowPanel.setBackground(Color.white);
		dateShowPanel.setLayout(new GridLayout(1, 3));
		dateShowPanel.setBorder(BorderFactory.createTitledBorder("Today"));
		mainPanel.add(dateShowPanel);

		yearlbl = new JLabel();
		yearlbl.setForeground(Color.black);
		yearlbl.setFont(Vdn12);
		yearlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowPanel.add(yearlbl);

		monthlbl = new JLabel();
		monthlbl.setForeground(Color.black);
		monthlbl.setFont(Vdn12);
		monthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowPanel.add(monthlbl);

		daylbl = new JLabel();
		daylbl.setForeground(Color.black);
		daylbl.setFont(Vdn12);
		daylbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowPanel.add(daylbl);

		salesMainPanel = new JPanel();
		salesMainPanel.setBounds(25, 100, 1150, 650);
		salesMainPanel.setBackground(Color.white);
		salesMainPanel.setLayout(null);
		mainPanel.add(salesMainPanel);

		salesLeftPanel = new JPanel();
		salesLeftPanel.setBounds(10, 30, 560, 610);
		salesLeftPanel.setBackground(Color.white);
		salesLeftPanel.setBorder(BorderFactory.createTitledBorder("Daily Sales"));
		salesLeftPanel.setLayout(new GridLayout(2, 1));
		salesMainPanel.add(salesLeftPanel);

		dailySalesBtn = new JButton("Show Daily Sales");
		dailySalesBtn.setBackground(Color.white);
		dailySalesBtn.setFont(Vdn28);
		dailySalesBtn.setHorizontalAlignment(SwingConstants.CENTER);
		dailySalesBtn.addMouseListener(menuBtnL);
		dailySalesBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		dailySalesBtn.addActionListener(showSalesL);
		salesLeftPanel.add(dailySalesBtn);

		dailySaleslbl = new JLabel("" + dailySale);
		dailySaleslbl.setFont(Vdn50);
		dailySaleslbl.setHorizontalAlignment(SwingConstants.CENTER);
		dailySaleslbl.setVisible(false);
		salesLeftPanel.add(dailySaleslbl);

		salesRightPanel = new JPanel();
		salesRightPanel.setBounds(580, 30, 560, 610);
		salesRightPanel.setBackground(Color.white);
		salesRightPanel.setBorder(BorderFactory.createTitledBorder("Estimated monthly sales"));
		salesRightPanel.setLayout(new GridLayout(4, 1));
		salesMainPanel.add(salesRightPanel);

		estimatedMonthlySalesBtn = new JButton("Estimated Monthly Sales");
		estimatedMonthlySalesBtn.setBackground(Color.white);
		estimatedMonthlySalesBtn.setFont(Vdn28);
		estimatedMonthlySalesBtn.setHorizontalAlignment(SwingConstants.CENTER);
		estimatedMonthlySalesBtn.addMouseListener(menuBtnL);
		estimatedMonthlySalesBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		estimatedMonthlySalesBtn.addActionListener(showSalesL);
		salesRightPanel.add(estimatedMonthlySalesBtn);

		estimatedMonthlySaleslbl = new JLabel("" + estimatedMonthlySales);
		estimatedMonthlySaleslbl.setFont(Vdn50);
		estimatedMonthlySaleslbl.setHorizontalAlignment(SwingConstants.CENTER);
		estimatedMonthlySaleslbl.setVisible(false);
		salesRightPanel.add(estimatedMonthlySaleslbl);

		estimatedDailySalesBtn = new JButton("Estimated Daily Sales");
		estimatedDailySalesBtn.setBackground(Color.white);
		estimatedDailySalesBtn.setFont(Vdn28);
		estimatedDailySalesBtn.setHorizontalAlignment(SwingConstants.CENTER);
		estimatedDailySalesBtn.addMouseListener(menuBtnL);
		estimatedDailySalesBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		estimatedDailySalesBtn.addActionListener(showSalesL);
		salesRightPanel.add(estimatedDailySalesBtn);

		estimatedDailySaleslbl = new JLabel("" + estimatedDailySales);
		estimatedDailySaleslbl.setFont(Vdn50);
		estimatedDailySaleslbl.setHorizontalAlignment(SwingConstants.CENTER);
		estimatedDailySaleslbl.setVisible(false);
		salesRightPanel.add(estimatedDailySaleslbl);

		menuPrice = new int[5];
		menuCnt = new int[5];

		for (int i = 0; i < 5; i++) {
			menuPrice[i] = 0;
			menuCnt[i] = 0;
		}

		// �Է� �Ϸ�� ���� �гη� �Ѿ�� ���� �гΰ� ��ư ����
		completePanel = new JPanel();
		completePanel.setBounds(1000, 20, 140, 50);
		completePanel.setLayout(null);
		completePanel.setVisible(true);
		mainPanel.add(completePanel);

		completeBtn = new JButton("EXIT");
		completeBtn.setBounds(5, 5, 130, 45);
		completeBtn.setFont(new Font("Verdana", Font.BOLD, 16));
		completeBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		completeBtn.setBackground(Color.lightGray);
		completeBtn.setForeground(Color.black);
		completeBtn.addMouseListener(mouseMovementL);
		completeBtn.addActionListener(inputCompleteL);
		completePanel.add(completeBtn);
	}

	public void setYear(int year) {
		yearlbl.setText("" + year);
	}

	public void setMonth(int month) {
		monthlbl.setText("" + month);
	}

	public void setDay(int day) {
		daylbl.setText("" + day);
	}

	public int getMenuPrice(int i) {
		return menuPrice[i];
	}

	public int getMenuCnt(int i) {
		return menuCnt[i];
	}

	public void setMenuPrice(int i, int price) {
		menuPrice[i] = price;
	}

	public void setMenuCnt(int i, int cnt) {
		menuCnt[i] = cnt;
	}

	public void setDailySale(int priceSum) {
		dailySale = priceSum;
		dailySaleslbl.setText("" + dailySale);
	}

	public void setEstimatedSales(int price) {
		estimatedMonthlySales = price;
		estimatedMonthlySaleslbl.setText("" + estimatedMonthlySales);
	}

	public void setEstimatedDailySales(int price) {
		estimatedDailySales = price;
		estimatedDailySaleslbl.setText("" + estimatedDailySales);
	}

	public void showValue() {
		this.estimatedMonthlySaleslbl.setVisible(true);
	}

	// �̺�Ʈ �߻��� ����� ������ ����ϱ� ���� �̺�Ʈ �ڵ鷯
	private class showSalesListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// �̺�Ʈ�� �߻��� ������Ʈ�� ����
			// ������ ������ ��½�Ű�� ���� ��ư
			if (obj == dailySalesBtn) {
				// ����� ���� ����������
				dailySaleslbl.setVisible(true);
				// �⺻ �޼����� ���
				defaultMessagelbl.setVisible(true);
				lblThread.setVisible(false);
			} else if (obj == estimatedMonthlySalesBtn) {
				defaultMessagelbl.setVisible(false);
				// �Ѵ� ����ġ�� ��½�Ű�� ������ ������̶�� �޼����� ���
				lblThread.setVisible(true);
				lblThread.setRange(0, 100);
				lblThread.start();
			} else if (obj == estimatedDailySalesBtn) {
				// 1�� ���� ����ġ ���� ��½�Ŵ
				estimatedDailySaleslbl.setVisible(true);
				defaultMessagelbl.setVisible(true);
				lblThread.setVisible(false);
			}
		}
	} // actionPerformed()

	// ���콺�������� ��ġ�� ���� ������ ������ �̺�Ʈ�ڵ鷯 Ŭ����
	private class MenuButtonListener implements MouseListener {
		public void mouseClicked(MouseEvent event) {
		}

		public void mousePressed(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
			JButton btnMenu = (JButton) event.getSource();
			btnMenu.setFont(new Font("Verdana", Font.BOLD, 36));
		} // mouseEntered()

		public void mouseExited(MouseEvent event) {
			JButton btnMenu = (JButton) event.getSource();
			btnMenu.setFont(new Font("Verdana", Font.BOLD, 28));
		} // mouseExited()
	} // MenuButtonListener class

	// ���콺�������� ��ġ�� ���� ������ ������ �̺�Ʈ�ڵ鷯 Ŭ����
	private class MouseMovementListener implements MouseListener {
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

	// �ش��гο����� ��� �Է��� �Ϸ�Ǿ��ٸ� �����гη� �Ѿ������ �̺�Ʈ�ڵ鷯 Ŭ����
	private class InputCompleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// �̺�Ʈ�� �߻��� ������Ʈ�� ����
			if (obj == completeBtn) {
				int result;
				result = JOptionPane.showConfirmDialog(mainPanel, "���α׷��� ���� �Ͻðڽ��ϱ�?"); // �ȳ�â
				if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
					System.exit(0);
				}
			}
		}
	} // actionPerformed()
}
