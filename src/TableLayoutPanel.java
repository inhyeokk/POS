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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TableLayoutPanel extends JPanel {
	// *11.14 ����
	private JPanel mainPanel;
	// ���̺� �г�
	private JPanel tableMainPanel;

	// *11.21 ���̺�� �޴��� �迭�� ����
	private JPanel[] tablePanelArray;
	private int[] tablePriceSumArray;
	private JButton[] tableBtnArray;
	private JLabel[] tableSumlblArray;

	// *11.21 �޴�, ���� �Է� �г� ����
	private JPanel[] menuPanelArray;
	// *11.21 ����
	private JButton[] menuBtnArray;
	private JLabel[] menuPricelblArray;
	private int[] menuPriceArray;
	// *11.27 ���� �޴��� �ֹ��ɶ����� �� Ƚ���� ī��Ʈ�ϱ� ���� �󺧰� ������ ���� ����
	private JLabel[] menuOrderCntArray;
	private int[] menuOrderCnt;

	// ���̺� ��� ����
	private int totalSum = 0;
	private int tableSelect = 11;

	// �޴����� ������ �Է��� �ޱ����� �г� ����
	private JPanel menuInputPanel;
	private JPanel menuMainPanel;
	private JLabel menuNameMainlbl, menuPricelbl, menuCntlbl;
	private JTextField menuNameInput, menuPriceInput, menuCntInput;

	// �޴� ���Է�(�ʱ�ȭ)
	private JPanel ResetPanel;
	private JLabel Resetlbl;
	private JButton ResetAllBtn, ResetTableBtn, ResetMenuBtn;

	// *11.24 ����
	private int menuNameBtnSelect, menuPriceBtnSelect, menuCntBtnSelect;

	// *11.25 ���� ����� �޴����� �� ���̺� �гο� �������� �ֹ��� �߰��Ǹ� ī��Ʈ ����
	private JLabel[][] menuTableArray;
	private int[][] menuTableCntArray;

	// *11.25 ��� �� ���� ��ư�� ������� �г� ����
	private JPanel settingPanel;
	private JLabel settinglbl;

	// *11.25 �޴� ������ �����ϱ� ���� ��ư ����
	private int menuSelect = 6;
	private JButton menuModifyBtn;

	// *11.25 �� ���̺��� ����� �Ϸ�Ǹ� ���� �г��� �������� ��ư ����
	private JButton tableCalculationBtn;

	// �Ϸ� *11.28 �Է� �Ϸ�� ������ ǥ���ϱ� ���� �гη� �Ѿ������ �Ϸ��ư
	private JPanel completePanel;
	private JButton completeBtn;

	// *12.02 �ʱ��Էµ� ���� �� �޴� �Ǹ� ������ ���������� ǰ���޼��� ��������� ����
	private int[] menuCntArray;

	// �Էµ� ��¥�� �����ִ� �г�
	private JPanel dateShowPanel;
	private JLabel yearlbl, monthlbl, daylbl;
	private int nYear, nMonth, nDay;

	// ����ڿ��� ������ �޼����� ����ϱ� ���� �г� ����
	private JPanel MessagePanel;
	// ���� ������� ��
	private JLabel defaultMessagelbl;
	// �Է°� ������ �����޼��� ����ϱ� ���� �� ����
	private JLabel ErrorMessagelbl;

	// ����
	private JPanel CountPanel;
	private JLabel Countlbl, Cardlbl, Cashlbl, totallbl, totalShowlbl;
	private JButton CardBtn, CashBtn;
	private int cardSum = 0, cashSum = 0, sum = 0;
	private JTextField CashInput;
	private JButton calculationCompleteBtn;
	private JLabel tableCalMessage;

	// �̺�Ʈ �ڵ鷯 ��ü ����
	private TableSumListener TableSum;
	private ValueResetListener ValueReset;
	private MenuModifyListener MenuModify;
	private ResetButtonListener ResetBtn;
	private MenuButtonListener mouseevent;
	private InputCompleteListener InputCompleteL;

	// ����� ���� Ŭ���� ����
	private InputDataCheck IDC;
	private DefaultSettingPanel DSP;
	private SalesPrintPanel SPP;

	// ���� �г�
	public TableLayoutPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(null);

		// ����� ���� Ŭ������ ��ü ����
		IDC = new InputDataCheck();
		DSP = new DefaultSettingPanel(this);
		SPP = new SalesPrintPanel();

		// �̺�Ʈ �ڵ鷯 ��ü ����
		TableSum = new TableSumListener();
		ValueReset = new ValueResetListener();
		MenuModify = new MenuModifyListener();
		ResetBtn = new ResetButtonListener();
		mouseevent = new MenuButtonListener();
		InputCompleteL = new InputCompleteListener();

		// ����� ��Ʈ�� ��ü�� ���� �� ����
		Font Vdn24 = new Font("Verdana", Font.BOLD, 24);
		Font Vdn18 = new Font("Verdana", Font.BOLD, 18);
		Font Vdn14 = new Font("Verdana", Font.BOLD, 14);
		Font Vdn12 = new Font("Verdana", Font.BOLD, 12);
		Font Vdn10 = new Font("Verdana", Font.BOLD, 10);
		Font Vdn8 = new Font("Verdana", Font.BOLD, 8);

		// ������ �����ϴ� ������ �迭 ���� �� �ʱ�ȭ
		menuPriceArray = new int[5];
		tablePriceSumArray = new int[10];
		menuCntArray = new int[5];

		for (int i = 0; i < 10; i++) {
			tablePriceSumArray[i] = 0;
		}

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 800);
		mainPanel.setVisible(true);
		mainPanel.setLayout(null);
		this.add(mainPanel);

		// // ������ ǥ�õ� �г��� ���� �� ���� �гο� �߰�
		SPP.setLayout(null);
		SPP.setVisible(false);
		this.add(SPP);

		// ���̺� ����� ���� ����ϰ� �޴��� ����� �̸��� ������ �����ϱ� ���� �г� ����
		settingPanel = new JPanel();
		settingPanel.setBounds(1125, 530, 50, 95);
		settingPanel.setBackground(Color.black);
		mainPanel.add(settingPanel);

		settinglbl = new JLabel("FUNC");
		settinglbl.setForeground(Color.white);
		settinglbl.setHorizontalAlignment(SwingConstants.CENTER);
		settinglbl.setFont(Vdn12);
		settingPanel.add(settinglbl);

		menuModifyBtn = new JButton("MODIFY");
		menuModifyBtn.setFont(Vdn10);
		menuModifyBtn.setHorizontalAlignment(SwingConstants.CENTER);
		menuModifyBtn.addActionListener(MenuModify);
		settingPanel.add(menuModifyBtn);

		tableCalculationBtn = new JButton("CALC");
		tableCalculationBtn.setFont(Vdn12);
		tableCalculationBtn.setHorizontalAlignment(SwingConstants.CENTER);
		tableCalculationBtn.addActionListener(TableSum);
		settingPanel.add(tableCalculationBtn);

		// ------------------------------------------------------------------
		// ����ڿ��� �޼����� ����ϱ����� �г�
		MessagePanel = new JPanel();
		MessagePanel.setBounds(300, 20, 600, 50);
		MessagePanel.setBackground(Color.black);
		MessagePanel.setLayout(null);
		mainPanel.add(MessagePanel);

		// ���� ������� ��
		defaultMessagelbl = new JLabel("Running Program");
		defaultMessagelbl.setBounds(10, 5, 580, 40);
		defaultMessagelbl.setFont(Vdn24);
		defaultMessagelbl.setForeground(Color.white);
		defaultMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		defaultMessagelbl.setVisible(true);
		MessagePanel.add(defaultMessagelbl);

		// ����� �Է½� �߻��� ������ ����ϱ� ���� ��
		ErrorMessagelbl = new JLabel("");
		ErrorMessagelbl.setBounds(10, 5, 580, 40);
		ErrorMessagelbl.setFont(Vdn24);
		ErrorMessagelbl.setForeground(Color.red);
		ErrorMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorMessagelbl.setVisible(false);
		MessagePanel.add(ErrorMessagelbl);

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

		// -----------------------------------------------------------
		// ���̺��� �Էµ� ������ �°� ��ġ�ϴ� �г� ����
		tableMainPanel = new JPanel();
		tableMainPanel.setBounds(25, 100, 1150, 400);
		tableMainPanel.setBackground(Color.white);
		tableMainPanel.setLayout(new GridLayout(2, 5));
		tableMainPanel.setBorder(BorderFactory.createTitledBorder("TABLE"));
		mainPanel.add(tableMainPanel);

		// �Էµ� ���� ��ŭ �� ���̺� �г��� ����
		tablePanelArray = new JPanel[10];
		for (int i = 0; i < 10; i++) {
			tablePanelArray[i] = new JPanel();
			tablePanelArray[i].setBackground(Color.cyan);
			tablePanelArray[i].setBorder(BorderFactory.createTitledBorder("" + (i + 1)));
			tablePanelArray[i].setLayout(new GridLayout(4, 2));
			tableMainPanel.add(tablePanelArray[i]);
		}

		// -------------------------------------------------------------
		// �޴��� �Էµ� ������ �°� ��ġ�ϴ� �г� ����
		menuMainPanel = new JPanel();
		menuMainPanel.setBounds(25, 530, 800, 150);
		menuMainPanel.setBackground(Color.white);
		menuMainPanel.setLayout(new GridLayout(1, 5));
		menuMainPanel.setBorder(BorderFactory.createTitledBorder("MENU"));
		mainPanel.add(menuMainPanel);

		// �Էµ� ���� ��ŭ �� �޴� �г��� ����
		menuPanelArray = new JPanel[5];
		for (int i = 0; i < 5; i++) {
			menuPanelArray[i] = new JPanel();
			menuPanelArray[i].setBackground(Color.cyan);
			menuPanelArray[i].setBorder(BorderFactory.createTitledBorder("" + (i + 1)));
			menuPanelArray[i].setLayout(new GridLayout(3, 1));
			menuMainPanel.add(menuPanelArray[i]);
		}

		// �� �޴� �г� ���ο� �޴� �̸��� �����ϴ� ��ư�� ������ �����ϴ� ���� ����
		menuBtnArray = new JButton[5];
		menuPricelblArray = new JLabel[5];
		menuOrderCntArray = new JLabel[5];
		menuOrderCnt = new int[5];
		for (int i = 0; i < 5; i++) {
			menuBtnArray[i] = new JButton("NAME");
			menuBtnArray[i].setFont(Vdn14);
			menuBtnArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			menuBtnArray[i].setBackground(Color.cyan);
			menuBtnArray[i].setBorder(BorderFactory.createLineBorder(new Color(0, true)));
			menuBtnArray[i].addActionListener(TableSum);
			menuPanelArray[i].add(menuBtnArray[i]);

			menuPricelblArray[i] = new JLabel("PRICE");
			menuPricelblArray[i].setFont(Vdn14);
			menuPricelblArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			menuPanelArray[i].add(menuPricelblArray[i]);

			menuOrderCnt[i] = 0;
			menuOrderCntArray[i] = new JLabel("Order Count: " + menuOrderCnt[i]);
			menuOrderCntArray[i].setFont(Vdn14);
			menuOrderCntArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			menuPanelArray[i].add(menuOrderCntArray[i]);
		}

		// �Էµ� �޴��� ������ �����Է��ϱ� ���� �г� ����
		menuInputPanel = new JPanel();
		menuInputPanel.setBounds(25, 700, 800, 70);
		menuInputPanel.setBorder(BorderFactory.createTitledBorder("INPUT"));
		menuInputPanel.setBackground(Color.white);
		menuInputPanel.setVisible(false);
		menuInputPanel.setLayout(new GridLayout(1, 6));
		mainPanel.add(menuInputPanel);

		// �Էµ� �޴��� ������ �����Է��ϱ� ���� �󺧰� �ؽ�Ʈ �ʵ� ����
		menuNameMainlbl = new JLabel("Menu's Name: ");
		menuNameMainlbl.setFont(Vdn12);
		menuNameMainlbl.setForeground(Color.black);
		menuNameMainlbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuInputPanel.add(menuNameMainlbl);

		menuNameInput = new JTextField();
		menuNameInput.setHorizontalAlignment(SwingConstants.CENTER);
		menuNameInput.setFont(Vdn18);
		menuNameInput.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		menuNameInput.addActionListener(MenuModify);
		menuNameInput.setEnabled(true);
		menuInputPanel.add(menuNameInput);

		menuPricelbl = new JLabel("Menu's Price: ");
		menuPricelbl.setFont(Vdn12);
		menuPricelbl.setForeground(Color.black);
		menuPricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuInputPanel.add(menuPricelbl);

		menuPriceInput = new JTextField();
		menuPriceInput.setHorizontalAlignment(SwingConstants.CENTER);
		menuPriceInput.setFont(Vdn18);
		menuPriceInput.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		menuPriceInput.addActionListener(MenuModify);
		menuPriceInput.setEnabled(true);
		menuInputPanel.add(menuPriceInput);

		menuCntlbl = new JLabel("Menu's Cnt: ");
		menuCntlbl.setFont(Vdn12);
		menuCntlbl.setForeground(Color.black);
		menuCntlbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuInputPanel.add(menuCntlbl);

		menuCntInput = new JTextField();
		menuCntInput.setHorizontalAlignment(SwingConstants.CENTER);
		menuCntInput.setFont(Vdn18);
		menuCntInput.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		menuCntInput.addActionListener(MenuModify);
		menuCntInput.setEnabled(true);
		menuInputPanel.add(menuCntInput);

		// ------------------------------------------------------------------
		// �Էµ� ���̺�� �޴� ������ �ʱ�ȭ �ϱ� ���� �гΰ� �� ��ư ����
		ResetPanel = new JPanel();
		ResetPanel.setBounds(1125, 650, 50, 120);
		ResetPanel.setBackground(Color.black);
		ResetPanel.addMouseListener(ResetBtn);
		mainPanel.add(ResetPanel);

		Resetlbl = new JLabel("RESET");
		Resetlbl.setBounds(5, 5, 40, 20);
		Resetlbl.setForeground(Color.white);
		Resetlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Resetlbl.setFont(Vdn12);
		ResetPanel.add(Resetlbl);

		ResetAllBtn = new JButton("ALL");
		ResetAllBtn.setBounds(5, 30, 40, 20);
		ResetAllBtn.setFont(Vdn12);
		ResetAllBtn.setHorizontalAlignment(SwingConstants.CENTER);
		ResetAllBtn.addActionListener(ValueReset);
		ResetAllBtn.setVisible(false);
		ResetAllBtn.addMouseListener(ResetBtn);
		ResetPanel.add(ResetAllBtn);

		ResetTableBtn = new JButton("TABLE");
		ResetTableBtn.setBounds(5, 55, 40, 20);
		ResetTableBtn.setFont(Vdn12);
		ResetTableBtn.setHorizontalAlignment(SwingConstants.CENTER);
		ResetTableBtn.addActionListener(ValueReset);
		ResetTableBtn.setVisible(false);
		ResetTableBtn.addMouseListener(ResetBtn);
		ResetPanel.add(ResetTableBtn);

		ResetMenuBtn = new JButton("MENU");
		ResetMenuBtn.setBounds(5, 80, 40, 20);
		ResetMenuBtn.setFont(Vdn12);
		ResetMenuBtn.setHorizontalAlignment(SwingConstants.CENTER);
		ResetMenuBtn.addActionListener(ValueReset);
		ResetMenuBtn.setVisible(false);
		ResetMenuBtn.addMouseListener(ResetBtn);
		ResetPanel.add(ResetMenuBtn);

		// ���� �г�
		CountPanel = new JPanel();
		CountPanel.setBounds(850, 530, 250, 240);
		CountPanel.setBackground(Color.black);
		CountPanel.setVisible(false);
		CountPanel.setLayout(null);
		mainPanel.add(CountPanel);

		Countlbl = new JLabel("Calculator");
		Countlbl.setBounds(25, 10, 200, 30);
		Countlbl.setForeground(Color.white);
		Countlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Countlbl.setFont(Vdn24);
		CountPanel.add(Countlbl);

		CardBtn = new JButton("Card");
		CardBtn.setBounds(25, 80, 50, 30);
		CardBtn.setFont(Vdn12);
		CardBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		CardBtn.setBackground(Color.black);
		CardBtn.setForeground(Color.white);
		CardBtn.setHorizontalAlignment(SwingConstants.CENTER);
		CardBtn.addActionListener(TableSum);
		CountPanel.add(CardBtn);

		Cardlbl = new JLabel("0");
		Cardlbl.setBounds(75, 80, 50, 30);
		Cardlbl.setForeground(Color.white);
		Cardlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Cardlbl.setFont(Vdn12);
		CountPanel.add(Cardlbl);

		CashBtn = new JButton("Cash");
		CashBtn.setBounds(125, 80, 50, 30);
		CashBtn.setFont(Vdn12);
		CashBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		CashBtn.setBackground(Color.black);
		CashBtn.setForeground(Color.white);
		CashBtn.setHorizontalAlignment(SwingConstants.CENTER);
		CashBtn.addActionListener(TableSum);
		CountPanel.add(CashBtn);

		Cashlbl = new JLabel("0");
		Cashlbl.setBounds(175, 80, 50, 30);
		Cashlbl.setForeground(Color.white);
		Cashlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Cashlbl.setFont(Vdn12);
		CountPanel.add(Cashlbl);

		totallbl = new JLabel("Total");
		totallbl.setBounds(25, 130, 50, 30);
		totallbl.setForeground(Color.white);
		totallbl.setHorizontalAlignment(SwingConstants.CENTER);
		totallbl.setFont(Vdn12);
		CountPanel.add(totallbl);

		totallbl = new JLabel("0");
		totallbl.setBounds(75, 130, 50, 30);
		totallbl.setForeground(Color.white);
		totallbl.setHorizontalAlignment(SwingConstants.CENTER);
		totallbl.setFont(Vdn12);
		CountPanel.add(totallbl);

		CashInput = new JTextField();
		CashInput.setBounds(125, 130, 100, 30);
		CashInput.setHorizontalAlignment(SwingConstants.CENTER);
		CashInput.setFont(Vdn12);
		CashInput.setEnabled(true); // �ڹ�ư Ȱ��ȭ
		CountPanel.add(CashInput);

		// *11.27 ���� ���⿡ ������̺��� �� ������ ������ �ȳ��� �ֱ� ���� �󺧷� ����
		tableCalMessage = new JLabel("");
		tableCalMessage.setBounds(25, 180, 225, 30);
		tableCalMessage.setHorizontalAlignment(SwingConstants.LEFT);
		tableCalMessage.setForeground(Color.white);
		tableCalMessage.setFont(Vdn14);
		tableCalMessage.setVisible(false);
		CountPanel.add(tableCalMessage);

		calculationCompleteBtn = new JButton("DONE");
		calculationCompleteBtn.setBounds(200, 210, 50, 30);
		calculationCompleteBtn.setHorizontalAlignment(SwingConstants.CENTER);
		calculationCompleteBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		calculationCompleteBtn.setBackground(Color.black);
		calculationCompleteBtn.setForeground(Color.red);
		calculationCompleteBtn.setFont(Vdn12);
		calculationCompleteBtn.addActionListener(TableSum);
		calculationCompleteBtn.setVisible(false);
		CountPanel.add(calculationCompleteBtn);

		tableBtnArray = new JButton[10];
		tableSumlblArray = new JLabel[10];
		menuTableArray = new JLabel[10][5];
		menuTableCntArray = new int[10][5];

		for (int i = 0; i < 10; i++) {
			tableBtnArray[i] = new JButton("ORDER");
			tableBtnArray[i].setFont(Vdn14);
			tableBtnArray[i].addActionListener(TableSum);
			tablePanelArray[i].add(tableBtnArray[i]);

			// ���̺� �޴�,���� �� ����
			tableSumlblArray[i] = new JLabel("");
			tableSumlblArray[i].setFont(Vdn14);
			tableSumlblArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			tablePanelArray[i].add(tableSumlblArray[i]);

			for (int j = 0; j < 5; j++) {
				menuTableCntArray[i][j] = 0;
				menuTableArray[i][j] = new JLabel(menuBtnArray[j].getText() + " " + menuTableCntArray[i][j]);
				menuTableArray[i][j].setFont(Vdn12);
				menuTableArray[i][j].setVisible(false);
				tablePanelArray[i].add(menuTableArray[i][j]);
			}
		}

		// �Է� �Ϸ�� ���� �гη� �Ѿ�� ���� �гΰ� ��ư ����
		completePanel = new JPanel();
		completePanel.setBounds(1000, 20, 140, 50);
		completePanel.setLayout(null);
		completePanel.setVisible(true);
		mainPanel.add(completePanel);

		completeBtn = new JButton("NEXT");
		completeBtn.setBounds(5, 5, 130, 45);
		completeBtn.setFont(new Font("Verdana", Font.BOLD, 16));
		completeBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		completeBtn.setBackground(Color.lightGray);
		completeBtn.setForeground(Color.black);
		completeBtn.addMouseListener(mouseevent);
		completeBtn.addActionListener(InputCompleteL);
		completePanel.add(completeBtn);

	} // TableLayoutPanel()

	public void setName(String name) {
		defaultMessagelbl.setText(name + "'s SALE MANEGEMENT");
	}

	public void setYear(int year) {
		nYear = year;
		yearlbl.setText("" + nYear);
	}

	public void setMonth(int month) {
		nMonth = month;
		monthlbl.setText("" + nMonth);
	}

	public void setDay(int day) {
		nDay = day;
		daylbl.setText("" + nDay);
	}

	public void setTable(int table) {
		// nTable = table;
	}

	public void setMenu(int menu) {
		// nMenu = menu;
	}

	public void setMenuName(int i, String str) {
		menuBtnArray[i].setText(str);
	}

	public void setMenuPrice(int i, int price) {
		menuPriceArray[i] = price;
		menuPricelblArray[i].setText("" + price);
	}

	public void setMenuCnt(int i, int cnt) {
		menuCntArray[i] = cnt;
	}

	public TableLayoutPanel(SalesPrintPanel p) {
		SPP = p;
	}

	// ���̺�, �޴� ��ư�� ����� ����ϴ� �׼Ǹ����� ����
	private class TableSumListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			int result;
			for (int i = 0; i < 10; i++) {
				// ���̺� ��ư�� ���ȴٸ�
				if (obj == tableBtnArray[i]) {
					result = JOptionPane.showConfirmDialog(mainPanel, (i + 1) + "�� ���̺��� �½��ϱ�?"); // �ȳ�â
					if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
						// �ش� ���̺��� ������ ����
						tableSelect = i;
						// tableSumlblArray[i].setText("Selected");
						// �ش� ���̺� ����� �հ踦 ����������
						tableSumlblArray[i].setVisible(true);
						// �г� ��� �޼����� �⺻���� ����
						defaultMessagelbl.setVisible(true);
						ErrorMessagelbl.setVisible(false);
						// �Ļ縦 ��ġ�� ����� ���Ҷ� ���⿡ ����� ������ ���
						tableCalMessage.setText((tableSelect + 1) + "Table's price is " + tablePriceSumArray[i]);
						tableCalMessage.setVisible(true);
					}
				}
			}
			for (int i = 0; i < 5; i++) {
				// �޴��� ��ư�� ���ȴٸ�
				if (obj == menuBtnArray[i]) {
					// �ش� �޴��� ������ ����
					menuSelect = i;
					// �޴��� �������� ������ ����Ǿ��ִٸ�
					if (menuPriceArray[i] != 0 && menuCntArray[i] != menuOrderCnt[i]) {
						// �г� ��� �޼����� �⺻���� ����
						defaultMessagelbl.setVisible(true);
						ErrorMessagelbl.setVisible(false);
						for (int j = 0; j < 10; j++) {
							if (tableSelect == j) {
								tablePriceSumArray[j] += menuPriceArray[i];
								tableSumlblArray[j].setText("" + tablePriceSumArray[j]);
								menuTableCntArray[j][i]++;
								menuTableArray[j][i].setText(menuBtnArray[i].getText() + " " + menuTableCntArray[j][i]);
								menuTableArray[j][i].setVisible(true);
								tableSumlblArray[j].setVisible(true);
								++menuOrderCnt[i];
								SPP.setMenuCnt(i, menuOrderCnt[i]);
								menuOrderCntArray[i].setText("Order Count: " + menuOrderCnt[i]);
								tablePanelArray[j].setBackground(Color.pink);
							}
						}
						// �޴��� ������ ����Ǿ����� �ʴٸ�
					} else if (menuPriceArray[i] == 0) {
						// ������ �������� �ʰ� �г� ��ܿ� �����޼����� ���
						ErrorMessagelbl.setText((i + 1) + "Menu has not been set");
						defaultMessagelbl.setVisible(false);
						ErrorMessagelbl.setVisible(true);
						// ���� �гο��� �Է��� ���� �� �޴��� �� �ǸŰ����� ���� �ȸ������� �����ϴٸ�
					} else if (menuCntArray[i] == menuOrderCnt[i]) {
						// ������ �������� �ʰ� ��ܿ� �����޼����� ���
						ErrorMessagelbl.setText((i + 1) + "Menu is sold out");
						defaultMessagelbl.setVisible(false);
						ErrorMessagelbl.setVisible(true);
					}
				}
			}

			// ������ ī���ư�� ���ȴٸ�
			if (obj == CardBtn) {
				for (int i = 0; i < 10; i++) {
					// �� �Էµ� ���̺��� ������ ���� ������ ����
					if (tableSelect == i) {
						// �����Է�â�� ������ ���������� ����
						int a = Integer.parseInt(CashInput.getText());
						// �Էµ� ���ݰ� �ش� ���̺� ����� ���ݰ� ��
						// ũ�ٸ� �������� �������� ����
						if (tablePriceSumArray[i] - a > 0) {
							// ��ü �հ迡 �߰�
							totalSum += a;
							// ī�� �հ迡 �߰�
							cardSum += a;
							// ������ ����ϴ� ���� ����� ������ �°� ����
							Cardlbl.setText("" + cardSum);
							totallbl.setText("" + totalSum);
							CashInput.setText(""); // �ؽ�Ʈ �ʵ� �ʱ�ȭ
							tablePriceSumArray[i] -= a;
							tableSumlblArray[i].setText("" + tablePriceSumArray[i]);
							// �г� ��� �޼����� �⺻���� ����
							defaultMessagelbl.setVisible(true);
							ErrorMessagelbl.setVisible(false);
							// ����� ���� ��ġ�Ѵٸ� ��� �Ϸ������ ����
						} else if (tablePriceSumArray[i] == a) {
							// ��� �Ϸ�
							// ��ü �հ迡 �߰�
							totalSum += a;
							// ī�� �հ迡 �߰�
							cardSum += a;
							// ������ ����ϴ� ���� ����� ������ �°� ����
							Cardlbl.setText("" + cardSum);
							totallbl.setText("" + totalSum);
							tablePriceSumArray[i] -= a;
							tableSumlblArray[i].setText("");
							CashInput.setText("");
							// ���Ϸ� ��ư�� ����������
							calculationCompleteBtn.setVisible(true);
							// �г� ��� �޼����� �⺻���� ����
							defaultMessagelbl.setVisible(true);
							ErrorMessagelbl.setVisible(false);
							// ����� ������ ���� �߸��� �Է��� �Էµȴٸ�
						} else // tablePriceSumArray[i] < a
						{
							CashInput.setText(""); // �ؽ�Ʈ �ʵ� �ʱ�ȭ
							// �Է��� �߸��Ǿ��ٴ� �����޼����� ���
							ErrorMessagelbl.setText("Inputted Value is bigger than PriceSum");
							defaultMessagelbl.setVisible(false);
							ErrorMessagelbl.setVisible(true);
						}
					}
				}
				// ������ ���ݹ�ư�� ���ȴٸ�
			} else if (obj == CashBtn) {
				for (int i = 0; i < 10; i++) {
					// �� �Էµ� ���̺��� ������ ���� ������ ����
					if (tableSelect == i) {
						// �����Է�â�� ������ ���������� ����
						int a = Integer.parseInt(CashInput.getText());
						// �Էµ� ���ݰ� �ش� ���̺� ����� ���ݰ� ��
						// ũ�ٸ� �������� �������� ����
						if (tablePriceSumArray[i] - a > 0) {
							// ��ü �հ迡 �߰�
							totalSum += a;
							// ���� �հ迡 �߰�
							cashSum += a;
							// ������ ����ϴ� ���� ����� ������ �°� ����
							Cashlbl.setText("" + cashSum);
							totallbl.setText("" + totalSum);
							CashInput.setText(""); // �ؽ�Ʈ �ʵ� �ʱ�ȭ
							tablePriceSumArray[i] -= a;
							tableSumlblArray[i].setText("" + tablePriceSumArray[i]);
							// �г� ��� �޼����� �⺻���� ����
							defaultMessagelbl.setVisible(true);
							ErrorMessagelbl.setVisible(false);
							// ����� ���� ��ġ�Ѵٸ� ��� �Ϸ������ ����
						} else if (tablePriceSumArray[i] == a) {
							// ��ü �հ迡 �߰�
							totalSum += a;
							// ���� �հ迡 �߰�
							cashSum += a;
							// ������ ����ϴ� ���� ����� ������ �°� ����
							Cashlbl.setText("" + cashSum);
							totallbl.setText("" + totalSum);
							tablePriceSumArray[i] -= a;
							tableSumlblArray[i].setText("");
							CashInput.setText("");
							// ���Ϸ� ��ư�� ����������
							calculationCompleteBtn.setVisible(true);
							// �г� ��� �޼����� �⺻���� ����
							defaultMessagelbl.setVisible(true);
							ErrorMessagelbl.setVisible(false);
							// ����� ������ ���� �߸��� �Է��� �Էµȴٸ�
						} else // tablePriceSumArray[i] < a
						{
							CashInput.setText(""); // �ؽ�Ʈ �ʵ� �ʱ�ȭ
							// �Է��� �߸��Ǿ��ٴ� �����޼����� ���
							ErrorMessagelbl.setText("Inputted Value is bigger than PriceSum");
							defaultMessagelbl.setVisible(false);
							ErrorMessagelbl.setVisible(true);
						}
					}
				}
			}
			// ��� ��ư�� ���ȴٸ�
			if (obj == tableCalculationBtn) {
				// ���� �г��� ���������� ����
				CountPanel.setVisible(true);
				// ���̺� ��ư�� �������� �ʾ��� �� �ùٸ��� ���� �Է��̶�� ��츦 ����
				if (tableSelect == 11) {
					// ���̺� ��ư�� �������� �ʾҴٴ� �����޼����� ���
					ErrorMessagelbl.setText("Please select a table before calculating");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				}
			}
			// ��� �Ϸ��ư�� ���ȴٸ�
			if (obj == calculationCompleteBtn) {
				// �ش� ���̺��� �Ѱ����� �޼���â�� ���
				result = JOptionPane.showConfirmDialog(mainPanel, totalSum + "���� �����Ͻðڽ��ϱ�?"); // �ȳ�â
				if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
					// ����� �Ϸ�Ǹ� ���̺��� ��� ���� ��ü ���⿡ �߰��Ѵ�.
					// �ش� ���̺��� ��� ������ �ʱ�ȭ
					sum += totalSum;
					cardSum = 0;
					cashSum = 0;
					totalSum = 0;
					Cardlbl.setText("" + cardSum);
					Cashlbl.setText("" + cashSum);
					totallbl.setText("" + totalSum);
					calculationCompleteBtn.setVisible(false);
					CountPanel.setVisible(false);
					tablePanelArray[tableSelect].setBackground(Color.cyan);
					tablePanelArray[tableSelect].setBackground(Color.cyan);
					for (int j = 0; j < 5; j++) {
						menuTableCntArray[tableSelect][j] = 0;
						menuTableArray[tableSelect][j]
								.setText(menuBtnArray[j].getText() + "     " + menuTableCntArray[tableSelect][j]);
						menuTableArray[tableSelect][j].setVisible(false);
					}
					tableSelect = 11;
					tableCalMessage.setText("");
					tableCalMessage.setVisible(false);
				}
			}
		}// menuBtn if-else()
	}

	// �� �ʱ�ȭ�� ����ϴ� �׼Ǹ����� ����
	private class ValueResetListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// �̺�Ʈ�� �߻��� ������Ʈ�� ����
			int result;

			// ��ü�� �ʱ�ȭ �Ѵٴ� ��ư�� ���ȴٸ�
			if (obj == ResetAllBtn) {
				// ����ڿ��� �ѹ� �� Ȯ���� ��Ű�� ���� �޼���â ���
				result = JOptionPane.showConfirmDialog(null, "��� ���� �ʱ�ȭ ��Ű�ڽ��ϱ�?"); // �ȳ�â
				if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
					// ���̺�� �޴��� ����� ��� ���� �ʱ�� ����
					totalSum = 0;
					for (int i = 0; i < 5; i++) {
						menuBtnArray[i].setText("NAME");
						menuPricelblArray[i].setText("PRICE");
						menuPriceArray[i] = 0;
						menuOrderCnt[i] = 0;
						menuOrderCntArray[i].setText("Order Count: " + menuOrderCnt[i]);
					}
					for (int i = 0; i < 10; i++) {
						tableSumlblArray[i].setText("");
						tablePriceSumArray[i] = 0;
						for (int j = 0; j < 5; j++) {
							menuTableCntArray[i][j] = 0;
							menuTableArray[i][j].setText(menuBtnArray[j].getText() + "     " + menuTableCntArray[i][j]);
							menuTableArray[i][j].setVisible(false);
						}
					}
					menuNameInput.setEnabled(true);
					menuPriceInput.setEnabled(true);

					// �ʱ�ȭ�� �Ϸ�Ǿ��ٴ� �޼����� ���
					ErrorMessagelbl.setText("Reset Complete");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				}
				// ���̺��� ������ �ʱ�ȭ ��Ű�� ���Ѵٸ�
			} else if (obj == ResetTableBtn) {
				// ����ڿ��� �ѹ� �� Ȯ���� ��Ű�� ���� �޼���â ���
				result = JOptionPane.showConfirmDialog(null, "�� ���̺� ����� ���� �ʱ�ȭ ��Ű�ڽ��ϱ�?"); // �ȳ�â
				if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
					// ���̺� ����� ��� ���� �ʱ�ȭ
					for (int i = 0; i < 10; i++) {
						tableSumlblArray[i].setText("");
						tablePriceSumArray[i] = 0;
						for (int j = 0; j < 5; j++) {
							menuTableCntArray[i][j] = 0;
							menuTableArray[i][j].setText(menuBtnArray[j].getText() + "     " + menuTableCntArray[i][j]);
							menuTableArray[i][j].setVisible(false);
						}
					}
				}
				// �޴��� ������ �ʱ�ȭ ��Ű�� ���Ѵٸ�
			} else if (obj == ResetMenuBtn) {
				// ����ڿ��� �ѹ� �� Ȯ���� ��Ű�� ���� �޼���â ���
				result = JOptionPane.showConfirmDialog(null, "�޴��� �̸��� ������ ��� �ʱ�ȭ ��Ű�ڽ��ϱ�?"); // �ȳ�â
				if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
					// �޴��� ����� ��� ���� �ʱ�ȭ
					for (int i = 0; i < 5; i++) {
						menuBtnArray[i].setText("NAME");
						menuPricelblArray[i].setText("PRICE");
						menuPriceArray[i] = 0;
						menuOrderCnt[i] = 0;
						menuOrderCntArray[i].setText("Order Count: " + menuOrderCnt[i]);
					}
					menuNameInput.setEnabled(true);
					menuPriceInput.setEnabled(true);
				} else {
					defaultMessagelbl.setVisible(true);
					ErrorMessagelbl.setVisible(false);
				}
			}
		}
	} // ValueResetListener()

	// ����� �޴��� ���� ������ ����ϴ� �׼Ǹ����� ����
	private class MenuModifyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// �̺�Ʈ�� �߻��� ������Ʈ�� ����
			int result;
			// �޴� ���� ��ư�� ���ȴٸ�
			if (obj == menuModifyBtn) {
				for (int i = 0; i < 5; i++) {
					// �� ����� �޴��� ���� ������ ����
					if (menuSelect == i) {
						// ����ڿ��� �ٽ� �ѹ� Ȯ���� ���� �޼��� â ���
						result = JOptionPane.showConfirmDialog(mainPanel, (i + 1) + "�� �޴������� �����Ͻðڽ��ϱ�?"); // �ȳ�â
						if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
							// �� ��ư�� ������ �����Ŵ
							menuNameBtnSelect = i;
							menuPriceBtnSelect = i;
							menuCntBtnSelect = i;
							// �޴��� ���õǾ��ٴ� �޼����� �г� ��ܿ� ���
							ErrorMessagelbl.setText((menuNameBtnSelect + 1) + "Menu is selected");
							defaultMessagelbl.setVisible(false);
							ErrorMessagelbl.setVisible(true);
							menuInputPanel.setVisible(true);
						}
					}
				}
				// �� ����� �޴��� ������ ���ٸ�(�ʱ� ����� ���̶��)
				if (menuSelect == 6) {
					// �޴��� ���õ��� �ʾҴٴ� �����޼����� ���
					ErrorMessagelbl.setText("Please Click Menu Button");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				}
			}
			// �޴��� �̸��� �����Ǿ��ٸ�
			if (obj == menuNameInput) {
				// �� ����� �޴��� �ش��ϴ� ������ ����
				menuBtnArray[menuNameBtnSelect].setText("" + menuNameInput.getText());
				// �� ���̺� ����� �̸� ���� ����
				for (int i = 0; i < 10; i++) {
					menuTableCntArray[i][menuNameBtnSelect] = 0;
					menuTableArray[i][menuNameBtnSelect].setText(menuBtnArray[menuNameBtnSelect].getText() + "     "
							+ menuTableCntArray[i][menuNameBtnSelect]);
					menuTableArray[i][menuNameBtnSelect].setVisible(false);
				}
				// �ش� �޴��� ������ �����Ǿ��ٴ� �޼����� �г� ��ܿ� ���
				ErrorMessagelbl.setText((menuNameBtnSelect + 1) + "Menu's info is modified");
				defaultMessagelbl.setVisible(false);
				ErrorMessagelbl.setVisible(true);
				menuNameInput.setText(""); // �ؽ�Ʈ�ʵ� �ʱ�ȭ
			}
			// �޴��� ������ �����Ǿ��ٸ�
			else if (obj == menuPriceInput) {
				// �ؽ�Ʈ�ʵ��� ���� IDC�� �޼ҵ�� �����Ŵ
				IDC.setMenuPrice(Integer.parseInt(menuPriceInput.getText()));
				// �ش� �޴��� ������ ������ ����
				if (menuPriceBtnSelect == 0) {
					menuPriceArray[0] = IDC.getMenuPrice();
					SPP.setMenuPrice(menuPriceBtnSelect, menuPriceArray[0]);
					menuPricelblArray[0].setText("" + menuPriceArray[0]);
				} else if (menuPriceBtnSelect == 1) {
					menuPriceArray[1] = IDC.getMenuPrice();
					SPP.setMenuPrice(menuPriceBtnSelect, menuPriceArray[1]);
					menuPricelblArray[1].setText("" + menuPriceArray[1]);
				} else if (menuPriceBtnSelect == 2) {
					menuPriceArray[2] = IDC.getMenuPrice();
					SPP.setMenuPrice(menuPriceBtnSelect, menuPriceArray[2]);
					menuPricelblArray[2].setText("" + menuPriceArray[2]);
				} else if (menuPriceBtnSelect == 3) {
					menuPriceArray[3] = IDC.getMenuPrice();
					menuPricelblArray[3].setText("" + menuPriceArray[3]);
					SPP.setMenuPrice(menuPriceBtnSelect, menuPriceArray[3]);
				} else if (menuPriceBtnSelect == 4 && IDC.getMenuPrice() == 0) {
					menuPriceArray[4] = IDC.getMenuPrice();
					SPP.setMenuPrice(menuPriceBtnSelect, menuPriceArray[4]);
					menuPricelblArray[4].setText("" + menuPriceArray[4]);
				} else if (menuPriceBtnSelect == 4 && IDC.getMenuPrice() != 0) {
					menuPriceArray[4] = IDC.getMenuPrice();
					SPP.setMenuPrice(menuPriceBtnSelect, menuPriceArray[4]);
					menuPricelblArray[4].setText("" + menuPriceArray[4]);
				}
				// �޴��� ������ �����Ǿ��ٴ� �޼����� �г� ��ܿ� ���
				ErrorMessagelbl.setText((menuPriceBtnSelect + 1) + "Menu's info is modified");
				defaultMessagelbl.setVisible(false);
				ErrorMessagelbl.setVisible(true);
				menuPriceInput.setText(""); // �ؽ�Ʈ�ʵ� �ʱ�ȭ
				// �Է��� �߸��Ǿ��ٸ� ���Է� �ϵ��� ����
				if (IDC.getMenuPrice() == 0) {
					// �Է��� �߸��Ǿ��ٴ� �޼����� �г� ��ܿ� ���
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				} else {
					// �׷��� �ʴٸ� �⺻ �޼����� ���
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
				}
			}
			// �޴��� ������ �����Ǿ��ٸ�
			else if (obj == menuCntInput) {
				// �ؽ�Ʈ�ʵ��� ���� IDC�� �޼ҵ�� �����Ŵ
				IDC.setMenuCnt(Integer.parseInt(menuCntInput.getText()));
				// �� ����� ī��Ʈ���� �ʱ�ȭ��Ŵ
				menuOrderCnt[menuSelect] = 0;
				// �ش� �޴��� ������ ������ ����
				if (menuCntBtnSelect == 0) {
					menuCntArray[0] = IDC.getMenuCnt();
				} else if (menuCntBtnSelect == 1) {
					menuCntArray[1] = IDC.getMenuCnt();
				} else if (menuCntBtnSelect == 2) {
					menuCntArray[2] = IDC.getMenuCnt();
				} else if (menuCntBtnSelect == 3) {
					menuCntArray[3] = IDC.getMenuCnt();
				} else if (menuCntBtnSelect == 4 && IDC.getMenuCnt() == 0) {
					menuCntArray[4] = IDC.getMenuCnt();
				} else if (menuCntBtnSelect == 4 && IDC.getMenuCnt() != 0) {
					menuCntArray[4] = IDC.getMenuCnt();
				}
				// �޴��� ������ �����Ǿ��ٴ� �޼����� �г� ��ܿ� ���
				ErrorMessagelbl.setText((menuCntBtnSelect + 1) + "Menu's info is modified");
				defaultMessagelbl.setVisible(false);
				ErrorMessagelbl.setVisible(true);
				menuCntInput.setText(""); // �ؽ�Ʈ�ʵ� �ʱ�ȭ
				// �Է��� �߸��Ǿ��ٸ� ���Է� �ϵ��� ����
				if (IDC.getMenuCnt() == 0) {
					// �Է��� �߸��Ǿ��ٴ� �����޼����� ���
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				} else {
					// �Է��� �������̶�� �⺻ �޼����� ���
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
					// �Է� ����� �޴� ���� �г��� �������� �ʰ� ��
					menuInputPanel.setVisible(false);
				}
			}
		}
	} // actionPerformed()
		// ���콺�������� ��ġ�� ���� ������ ������ �̺�Ʈ�ڵ鷯 Ŭ����

	// �޴��� �ʱ�ȭ ��Ű�� ��ư�� �г� ���ο� ���콺 �̵��ÿ��� ���������� �����ϴ� ���콺 ������
	private class ResetButtonListener implements MouseListener {
		public void mouseClicked(MouseEvent event) {
		}

		public void mousePressed(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
			Object obj = event.getSource();
			if (obj == ResetPanel || obj == ResetAllBtn || obj == ResetTableBtn || obj == ResetMenuBtn) {
				ResetAllBtn.setVisible(true);
				ResetTableBtn.setVisible(true);
				ResetMenuBtn.setVisible(true);
			}
		} // mouseEntered()

		public void mouseExited(MouseEvent event) {
			Object obj = event.getSource();
			if (obj == ResetPanel || obj == ResetAllBtn || obj == ResetTableBtn || obj == ResetMenuBtn) {
				ResetAllBtn.setVisible(false);
				ResetTableBtn.setVisible(false);
				ResetMenuBtn.setVisible(false);
			}
		} // mouseExited()
	} // MenuButtonListener class

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
			// �Է� �Ϸ� ��ư�� ���ȴٸ�
			if (obj == completeBtn) {
				int result;
				// ����ڿ��� �ѹ� �� �г��� �Ѿ ������ Ȯ�ν����ִ� �޼���â ���
				result = JOptionPane.showConfirmDialog(mainPanel, "�ǸŸ� ��ġ�� ������ �����Ͻðڽ��ϱ�?"); // �ȳ�â
				if (result == JOptionPane.YES_OPTION) { // YES�� ������ ��
					int priceSum = 0, estimatedSales = 0;
					int temp;
					for (int i = 0; i < 5; i++) {
						// ������ �հ踦 �޴��� ���ݰ� ����� ������ �°� ����
						priceSum += menuPriceArray[i] * SPP.getMenuCnt(i);
					}
					// �Ѵ� ���� �հ踦 �����ϱ� ���� �ݺ���
					for (int i = 0; i < 30; i++) {
						for (int j = 0; j < 5; j++) {
							if (SPP.getMenuCnt(j) != 0)
								// �ֹ��� �޴��� ������ 0�� �ƴ϶�� �������� ���������� ����
								temp = SPP.getMenuCnt(j) + (int) (Math.random() * 10) - 5;
							else
								// �ֹ��� ������ 0�̶�� ���� ����
								temp = SPP.getMenuCnt(j);
							estimatedSales += menuPriceArray[j] * ((temp < 0) ? SPP.getMenuCnt(j) : temp);
						}
					}

					// ����� �Ѵ� ����ġ ���� 30���� ���� �� 1�� ����ġ�� ����
					SPP.setEstimatedDailySales((int) estimatedSales / 30);
					// ���� ���� �հ踦 ����
					SPP.setDailySale(priceSum);
					// �Ѵ� ����ġ ���� ����
					SPP.setEstimatedSales(estimatedSales);
					// *11.28 ���� ���� ����гο� ��¥�� ����
					SPP.setYear(nYear);
					SPP.setMonth(nMonth);
					SPP.setDay(nDay);
					mainPanel.setVisible(false);
					SPP.setVisible(true);
				}
			}
		}
	} // actionPerformed()
} // TableLayoutPanel Class
