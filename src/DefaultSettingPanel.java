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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//�ش� �гο����� InputDataCheck Ŭ������ �ҷ��� ��¥�� �Է¹޴´�.
public class DefaultSettingPanel extends JPanel {
	// *11.14 ���� main Ŭ������ �����ӿ� �߰��ϱ� ���� ���� �г� ����
	private JPanel mainPanel;

	// *11.21���� ������ �Է��ϴ� �гΰ� �Էµ� ������ �����ϰ� ����ڿ��� �����ֱ� ���� �г� ����
	private JPanel mainInfoPanel;
	private JPanel infoInputPanel;
	private JPanel savedInfoPanel;
	private JPanel savedLeftPanel;
	private JPanel savedRightPanel;

	// ����ڿ��� ������ �޼����� ����ϱ� ���� �г� ����
	private JPanel MessagePanel;
	// ���� ������� ��
	private JLabel defaultMessagelbl;
	// �Է°� ������ �����޼��� ����ϱ� ���� �� ����
	private JLabel ErrorMessagelbl;

	// �������� �Է¹ޱ����� �󺧰� �ؽ�Ʈ �ʵ� ����
	private JLabel nameShowlbl;
	private JTextField nameInput;
	private JLabel yearShowlbl, monthShowlbl, dayShowlbl;
	private JTextField yearInput, monthInput, dayInput;
	// ���̺�� �޴��� ������ �Է¹ޱ����� �󺧰� �ؽ�Ʈ �ʵ� ����
	private JLabel tableShowlbl, menuShowlbl;
	private JTextField tableInput, menuInput;

	// ����� ������ ����ϱ����� �󺧰� ������ ���� ����
	private JLabel namelbl, nameInputtedlbl;
	private JLabel yearlbl, yearInputtedlbl;
	private JLabel monthlbl, monthInputtedlbl;
	private JLabel daylbl, dayInputtedlbl;
	private JLabel tablelbl, tableInputtedlbl;
	private JLabel menulbl, menuInputtedlbl;
	private int nYear, nMonth, nDay;
	private int nTable, nMenu;

	// *11.23 ���� - �޴��� �̸��� ������ �Է� �ޱ� ���� �󺧰� �ؽ�Ʈ �ʵ� ����
	private JLabel menuNameMainlbl, menuPricelbl;
	private JTextField menuNameInput, menuPriceInput;
	private int menuNameInputCnt = 0, menuPriceInputCnt = 0;

	// 12.02 ���� - ���� �Ǹ��� �޴��� ���� �߰�
	private JLabel menuCntlbl;
	private JTextField menuCntInput;
	private int menuCntInputCnt = 0;

	// �Է¹޾� ����� �޴��� �̸��� ������ �����ϱ� ���� �󺧰� ������ ���� ����
	private JLabel menuInputtedName, menuInputtedPrice;
	private JLabel[] menuNameArray, menuPricelblArray;
	private int[] menuPriceArray;

	// *12.02 ���� ���� �Ǹ��� �޴��� ���� �߰�
	private JLabel menuInputtedCnt;
	private JLabel[] menuCntlblArray;
	private int[] menuCntArray;

	// ����Է��� �������̸� �����гη� �Ѿ������ �Ϸ��г� ����
	private JPanel completePanel;
	private JButton completeBtn;

	// *11.25 ���� ����Է��� �Ϸ�Ǹ� ����� ��¥�� ����ϴ� �гΰ� �� ����
	private JPanel dateShowPanel;
	private JLabel yearMainlbl, monthMainlbl, dayMainlbl;

	// �̺�Ʈ �ڵ鷯 ��ü ����
	private InputCompleteListener ICL;
	private menuInputListener InputSum;
	private MenuButtonListener mouseevent;

	// ����� ���� �г��� ��ü ����
	// NEXT��ư�� Ŭ���� �� ������ ǥ���� �г�
	private TableLayoutPanel TLP;
	// �Էµ� �������� �ùٸ� ������ �˻� �� �����ϱ� ����
	private InputDataCheck IDC;
	private SalesPrintPanel SPP;

	// ����� ���� �г��� ����
	public DefaultSettingPanel() {
		// ������ ������ �г� �°� �ֱ� ���� ����
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(null);

		// �̺�Ʈ �ڵ鷯 ��ü ����
		ICL = new InputCompleteListener();
		InputSum = new menuInputListener();
		mouseevent = new MenuButtonListener();

		// InputDataCheck Ŭ������ ��ü ����
		TLP = new TableLayoutPanel();
		IDC = new InputDataCheck();
		SPP = new SalesPrintPanel();

		// ����� ��Ʈ�� ��ü�� ���� �� ����
		Font Vdn30 = new Font("Verdana", Font.BOLD, 40);
		Font Vdn24 = new Font("Verdana", Font.BOLD, 24);
		Font Vdn15 = new Font("Verdana", Font.BOLD, 15);
		Font Vdn12 = new Font("Verdana", Font.BOLD, 12);

		// �г��� ũ�⿡ �°� �ش� Ŭ������ ���� �г��� ����
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 800);
		mainPanel.setVisible(true);
		// mainPanel.setBackground(Color.white);
		mainPanel.setLayout(null);
		this.add(mainPanel);

		// // ������ ǥ�õ� �г��� ���� �� ���� �гο� �߰�
		TLP.setLayout(null);
		TLP.setVisible(false);
		this.add(TLP);

		// ����ڿ��� ������ �޼����� ����ϱ� ���� �г� ����
		MessagePanel = new JPanel();
		MessagePanel.setBounds(300, 20, 600, 50);
		MessagePanel.setBackground(Color.black);
		MessagePanel.setLayout(null);
		mainPanel.add(MessagePanel);

		// �⺻ �޼����� ����ϱ� ���� �� ����
		defaultMessagelbl = new JLabel("Please Enter Information");
		defaultMessagelbl.setBounds(10, 5, 580, 40);
		defaultMessagelbl.setFont(Vdn24);
		defaultMessagelbl.setForeground(Color.white);
		defaultMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		defaultMessagelbl.setVisible(true);
		MessagePanel.add(defaultMessagelbl);

		// ����� �Է½� �߻��� ������ ����ϱ� ���� �� ����
		ErrorMessagelbl = new JLabel("");
		ErrorMessagelbl.setBounds(10, 5, 580, 40);
		ErrorMessagelbl.setFont(Vdn24);
		ErrorMessagelbl.setForeground(Color.red);
		ErrorMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorMessagelbl.setVisible(false);
		MessagePanel.add(ErrorMessagelbl);

		// ������ �Է� �ް� �����ϱ� ���� �г� ����
		mainInfoPanel = new JPanel();
		mainInfoPanel.setBounds(25, 100, 1150, 650);
		mainInfoPanel.setBackground(Color.white);
		mainInfoPanel.setLayout(null);
		mainPanel.add(mainInfoPanel);

		// ������ �Է¹ޱ� ���� �г� ����
		infoInputPanel = new JPanel();
		infoInputPanel.setBounds(10, 10, 1130, 140);
		infoInputPanel.setBackground(Color.white);
		infoInputPanel.setBorder(BorderFactory.createTitledBorder("INPUT INFO"));
		infoInputPanel.setLayout(null);
		mainInfoPanel.add(infoInputPanel);

		// �Է¹��� ������ �����ϱ� ���� �г� ����
		savedInfoPanel = new JPanel();
		savedInfoPanel.setBounds(10, 150, 1130, 490);
		savedInfoPanel.setBackground(Color.white);
		savedInfoPanel.setBorder(BorderFactory.createTitledBorder("SAVED INFO"));
		savedInfoPanel.setLayout(null);
		mainInfoPanel.add(savedInfoPanel);

		// �̸�, ��¥, ���̺�� �޴��� ������ �����ϱ� ���� �г� ����
		savedLeftPanel = new JPanel();
		savedLeftPanel.setBounds(10, 30, 550, 450);
		savedLeftPanel.setBackground(Color.white);
		savedLeftPanel.setBorder(BorderFactory.createTitledBorder("INITIAL INFO"));
		savedLeftPanel.setLayout(new GridLayout(6, 2));
		savedInfoPanel.add(savedLeftPanel);

		// �Էµ� �޴��� ������ŭ �����ϱ����� �г� ����
		savedRightPanel = new JPanel();
		savedRightPanel.setBounds(570, 30, 550, 450);
		savedRightPanel.setBackground(Color.white);
		savedRightPanel.setBorder(BorderFactory.createTitledBorder("MENU INFO"));
		savedRightPanel.setLayout(new GridLayout(6, 3));
		savedInfoPanel.add(savedRightPanel);

		// �Ĵ��̸��� �Է��ϱ� ���� �� ����
		nameShowlbl = new JLabel("Restaurant Name: ");
		nameShowlbl.setBounds(0, 0, 565, 140);
		nameShowlbl.setForeground(Color.black);
		nameShowlbl.setFont(Vdn30);
		nameShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameShowlbl.setVisible(true);
		infoInputPanel.add(nameShowlbl);

		// �Ĵ��̸��� �Է��ϱ� ���� �ؽ�Ʈ �ʵ� ����
		nameInput = new JTextField();
		nameInput.setBounds(565, 15, 560, 120);
		nameInput.setFont(Vdn30);
		nameInput.setBorder(BorderFactory.createLineBorder(Color.white));
		nameInput.setHorizontalAlignment(SwingConstants.CENTER);
		nameInput.addActionListener(ICL);
		nameInput.setEnabled(true);
		nameInput.setVisible(true);
		infoInputPanel.add(nameInput);

		// ��¥ �� ���� �Է��ϱ� ���� �� ����
		yearShowlbl = new JLabel("Year: ");
		yearShowlbl.setBounds(0, 0, 565, 140);
		yearShowlbl.setForeground(Color.black);
		yearShowlbl.setFont(Vdn30);
		yearShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		yearShowlbl.setVisible(false);
		infoInputPanel.add(yearShowlbl);

		// ��¥ �� ���� �Է¹ޱ� ���� �ؽ�Ʈ �ʵ� ����
		yearInput = new JTextField();
		yearInput.setBounds(565, 15, 560, 120);
		yearInput.setFont(Vdn30);
		yearInput.setBorder(BorderFactory.createLineBorder(Color.white));
		yearInput.setHorizontalAlignment(SwingConstants.CENTER);
		yearInput.addActionListener(ICL);
		yearInput.setEnabled(false);
		yearInput.setVisible(false);
		infoInputPanel.add(yearInput);

		// ��¥ �� ���� �Է��ϱ� ���� �� ����
		monthShowlbl = new JLabel("Month: ");
		monthShowlbl.setBounds(0, 0, 565, 140);
		monthShowlbl.setForeground(Color.black);
		monthShowlbl.setFont(Vdn30);
		monthShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		monthShowlbl.setVisible(false);
		infoInputPanel.add(monthShowlbl);

		// ��¥ �� ���� �Է¹ޱ� ���� �ؽ�Ʈ �ʵ� ����
		monthInput = new JTextField();
		monthInput.setBounds(565, 15, 560, 120);
		monthInput.setFont(Vdn30);
		monthInput.setBorder(BorderFactory.createLineBorder(Color.white));
		monthInput.setHorizontalAlignment(SwingConstants.CENTER);
		monthInput.addActionListener(ICL);
		monthInput.setEnabled(false);
		monthInput.setVisible(false);
		infoInputPanel.add(monthInput);

		// ��¥ �� ���� �Է��ϱ� ���� �� ����
		dayShowlbl = new JLabel("Day: ");
		dayShowlbl.setBounds(0, 0, 565, 140);
		dayShowlbl.setForeground(Color.black);
		dayShowlbl.setFont(Vdn30);
		dayShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dayShowlbl.setVisible(false);
		infoInputPanel.add(dayShowlbl);

		// ��¥ �� ���� �Է¹ޱ� ���� �ؽ�Ʈ �ʵ� ����
		dayInput = new JTextField();
		dayInput.setBounds(565, 15, 560, 120);
		dayInput.setFont(Vdn30);
		dayInput.setBorder(BorderFactory.createLineBorder(Color.white));
		dayInput.setHorizontalAlignment(SwingConstants.CENTER);
		dayInput.addActionListener(ICL);
		dayInput.setEnabled(false);
		dayInput.setVisible(false);
		infoInputPanel.add(dayInput);

		// ���̺� ������ �Է��ϱ� ���� �� ����
		tableShowlbl = new JLabel("Table: ");
		tableShowlbl.setBounds(0, 0, 565, 140);
		tableShowlbl.setForeground(Color.black);
		tableShowlbl.setFont(Vdn30);
		tableShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		tableShowlbl.setVisible(false);
		infoInputPanel.add(tableShowlbl);

		// ���̺� ������ �Է¹ޱ� ���� �ؽ�Ʈ �ʵ� ����
		tableInput = new JTextField();
		tableInput.setBounds(565, 15, 560, 120);
		tableInput.setFont(Vdn30);
		tableInput.setBorder(BorderFactory.createLineBorder(Color.white));
		tableInput.setHorizontalAlignment(SwingConstants.CENTER);
		tableInput.addActionListener(ICL);
		tableInput.setVisible(false);
		tableInput.setVisible(false);
		infoInputPanel.add(tableInput);

		// �޴� ������ �Է��ϱ� ���� �� ����
		menuShowlbl = new JLabel("Menu: ");
		menuShowlbl.setBounds(0, 0, 565, 140);
		menuShowlbl.setForeground(Color.black);
		menuShowlbl.setFont(Vdn30);
		menuShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuShowlbl.setVisible(false);
		infoInputPanel.add(menuShowlbl);

		// �޴� ������ �Է¹ޱ� ���� �ؽ�Ʈ �ʵ� ����
		menuInput = new JTextField();
		menuInput.setBounds(565, 15, 560, 120);
		menuInput.setFont(Vdn30);
		menuInput.setBorder(BorderFactory.createLineBorder(Color.white));
		menuInput.setHorizontalAlignment(SwingConstants.CENTER);
		menuInput.addActionListener(ICL);
		menuInput.setVisible(false);
		menuInput.setVisible(false);
		infoInputPanel.add(menuInput);

		// ----------------------------------------------------------------------------
		// �Էµ� ���� �� ���� �гο� ������ ����
		// �Էµ� �̸��� ǥ���ϱ����� �� ����
		namelbl = new JLabel("Restaurant Name: ");
		namelbl.setForeground(Color.black);
		namelbl.setFont(Vdn24);
		namelbl.setHorizontalAlignment(SwingConstants.LEFT);
		namelbl.setVisible(false);
		savedLeftPanel.add(namelbl);

		// �Էµ� �̸��� ����ϱ� ���� �� ����
		nameInputtedlbl = new JLabel();
		nameInputtedlbl.setForeground(Color.black);
		nameInputtedlbl.setFont(Vdn24);
		nameInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		nameInputtedlbl.setVisible(false);
		savedLeftPanel.add(nameInputtedlbl);

		// �Էµ� ��¥ �� ���� ǥ���ϱ� ���� �� ����
		yearlbl = new JLabel("Year: ");
		yearlbl.setForeground(Color.black);
		yearlbl.setFont(Vdn24);
		yearlbl.setHorizontalAlignment(SwingConstants.LEFT);
		yearlbl.setVisible(false);
		savedLeftPanel.add(yearlbl);

		// �Էµ� ��¥ �� ���� ����ϱ� ���� �� ����
		yearInputtedlbl = new JLabel();
		yearInputtedlbl.setForeground(Color.black);
		yearInputtedlbl.setFont(Vdn24);
		yearInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		yearInputtedlbl.setVisible(false);
		savedLeftPanel.add(yearInputtedlbl);

		// �Էµ� ��¥ �� ���� ǥ���ϱ� ���� �� ����
		monthlbl = new JLabel("Month: ");
		monthlbl.setForeground(Color.black);
		monthlbl.setFont(Vdn24);
		monthlbl.setHorizontalAlignment(SwingConstants.LEFT);
		monthlbl.setVisible(false);
		savedLeftPanel.add(monthlbl);

		// �Էµ� ��¥ �� ���� ����ϱ� ���� �� ����
		monthInputtedlbl = new JLabel();
		monthInputtedlbl.setForeground(Color.black);
		monthInputtedlbl.setFont(Vdn24);
		monthInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		monthInputtedlbl.setVisible(false);
		savedLeftPanel.add(monthInputtedlbl);

		// �Էµ� ��¥ �� ���� ǥ���ϱ� ���� �� ����
		daylbl = new JLabel("Day: ");
		daylbl.setForeground(Color.black);
		daylbl.setFont(Vdn24);
		daylbl.setHorizontalAlignment(SwingConstants.LEFT);
		daylbl.setVisible(false);
		savedLeftPanel.add(daylbl);

		// �Էµ� ��¥ �� ���� ����ϱ� ���� �� ����
		dayInputtedlbl = new JLabel();
		dayInputtedlbl.setForeground(Color.black);
		dayInputtedlbl.setFont(Vdn24);
		dayInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		dayInputtedlbl.setVisible(false);
		savedLeftPanel.add(dayInputtedlbl);

		// �Էµ� ���̺� ������ ǥ���ϱ� ���� �� ����
		tablelbl = new JLabel("Table: ");
		tablelbl.setForeground(Color.black);
		tablelbl.setFont(Vdn24);
		tablelbl.setHorizontalAlignment(SwingConstants.LEFT);
		tablelbl.setVisible(false);
		savedLeftPanel.add(tablelbl);

		// �Էµ� ���̺� ������ ����ϱ� ���� �� ����
		tableInputtedlbl = new JLabel();
		tableInputtedlbl.setForeground(Color.black);
		tableInputtedlbl.setFont(Vdn24);
		tableInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		tableInputtedlbl.setVisible(false);
		savedLeftPanel.add(tableInputtedlbl);

		// �Էµ� �޴� ������ ǥ���ϱ� ���� �� ����
		menulbl = new JLabel("Menu: ");
		menulbl.setForeground(Color.black);
		menulbl.setFont(Vdn24);
		menulbl.setHorizontalAlignment(SwingConstants.LEFT);
		menulbl.setVisible(false);
		savedLeftPanel.add(menulbl);

		// �Էµ� �޴� ������ ����ϱ� ���� �� ����
		menuInputtedlbl = new JLabel();
		menuInputtedlbl.setForeground(Color.black);
		menuInputtedlbl.setFont(Vdn24);
		menuInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		menuInputtedlbl.setVisible(false);
		savedLeftPanel.add(menuInputtedlbl);
		// -----------------------------------------------------------------------------
		// �޴��̸��� �Է��ϱ� ���� �󺧰� �ؽ�Ʈ�ʵ� ����
		menuNameMainlbl = new JLabel("Menu's Name: ");
		menuNameMainlbl.setBounds(10, 0, 200, 140);
		menuNameMainlbl.setFont(Vdn24);
		menuNameMainlbl.setForeground(Color.black);
		menuNameMainlbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuNameMainlbl.setVisible(false);
		infoInputPanel.add(menuNameMainlbl);

		menuNameInput = new JTextField();
		menuNameInput.setBounds(210, 15, 170, 120);
		menuNameInput.setHorizontalAlignment(SwingConstants.CENTER);
		menuNameInput.setFont(Vdn24);
		menuNameInput.setBorder(BorderFactory.createLineBorder(Color.white));
		menuNameInput.addActionListener(InputSum);
		menuNameInput.setEnabled(false); // �ڹ�ư Ȱ��ȭ
		menuNameInput.setVisible(false);
		infoInputPanel.add(menuNameInput);

		// �޴� ������ �Է��ϱ� ���� �󺧰� �ؽ�Ʈ�ʵ� ����
		menuPricelbl = new JLabel("Menu's Price: ");
		menuPricelbl.setBounds(380, 0, 200, 140);
		menuPricelbl.setFont(Vdn24);
		menuPricelbl.setForeground(Color.black);
		menuPricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuPricelbl.setVisible(false);
		infoInputPanel.add(menuPricelbl);

		menuPriceInput = new JTextField();
		menuPriceInput.setBounds(580, 15, 170, 120);
		menuPriceInput.setHorizontalAlignment(SwingConstants.CENTER);
		menuPriceInput.setFont(Vdn24);
		menuPriceInput.setBorder(BorderFactory.createLineBorder(Color.white));
		menuPriceInput.addActionListener(InputSum);
		menuPriceInput.setEnabled(false); // �ڹ�ư Ȱ��ȭ
		menuPriceInput.setVisible(false);
		infoInputPanel.add(menuPriceInput);

		// �޴� ������ �Է��ϱ� ���� �󺧰� �ؽ�Ʈ�ʵ� ����
		menuCntlbl = new JLabel("Menu's Cnt: ");
		menuCntlbl.setBounds(750, 0, 200, 140);
		menuCntlbl.setFont(Vdn24);
		menuCntlbl.setForeground(Color.black);
		menuCntlbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuCntlbl.setVisible(false);
		infoInputPanel.add(menuCntlbl);

		menuCntInput = new JTextField();
		menuCntInput.setBounds(950, 15, 170, 120);
		menuCntInput.setHorizontalAlignment(SwingConstants.CENTER);
		menuCntInput.setFont(Vdn24);
		menuCntInput.setBorder(BorderFactory.createLineBorder(Color.white));
		menuCntInput.addActionListener(InputSum);
		menuCntInput.setEnabled(false); // �ڹ�ư Ȱ��ȭ
		menuCntInput.setVisible(false);
		infoInputPanel.add(menuCntInput);

		// �Է¹޾� ����� �޴��� �̸��� ������ ����ϱ� ���� �� ����
		menuInputtedName = new JLabel("Name");
		menuInputtedName.setForeground(Color.black);
		menuInputtedName.setFont(Vdn24);
		menuInputtedName.setHorizontalAlignment(SwingConstants.CENTER);
		menuInputtedName.setVisible(false);
		savedRightPanel.add(menuInputtedName);

		menuInputtedPrice = new JLabel("Price");
		menuInputtedPrice.setForeground(Color.black);
		menuInputtedPrice.setFont(Vdn24);
		menuInputtedPrice.setHorizontalAlignment(SwingConstants.CENTER);
		menuInputtedPrice.setVisible(false);
		savedRightPanel.add(menuInputtedPrice);

		// 12.02 ���� - ���� �Ǹ��� �޴��� ���� �߰�
		menuInputtedCnt = new JLabel("Cnt");
		menuInputtedCnt.setForeground(Color.black);
		menuInputtedCnt.setFont(Vdn24);
		menuInputtedCnt.setHorizontalAlignment(SwingConstants.CENTER);
		menuInputtedCnt.setVisible(false);
		savedRightPanel.add(menuInputtedCnt);

		menuNameArray = new JLabel[5];
		menuPricelblArray = new JLabel[5];
		menuPriceArray = new int[5];
		menuCntlblArray = new JLabel[5];
		menuCntArray = new int[5];
		for (int i = 0; i < 5; i++) {
			menuNameArray[i] = new JLabel();
			menuNameArray[i].setForeground(Color.black);
			menuNameArray[i].setFont(Vdn15);
			menuNameArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			menuNameArray[i].setVisible(false);
			savedRightPanel.add(menuNameArray[i]);

			menuPricelblArray[i] = new JLabel();
			menuPricelblArray[i].setForeground(Color.black);
			menuPricelblArray[i].setFont(Vdn24);
			menuPricelblArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			menuPricelblArray[i].setVisible(false);
			savedRightPanel.add(menuPricelblArray[i]);

			menuCntlblArray[i] = new JLabel();
			menuCntlblArray[i].setForeground(Color.black);
			menuCntlblArray[i].setFont(Vdn24);
			menuCntlblArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			menuCntlblArray[i].setVisible(false);
			savedRightPanel.add(menuCntlblArray[i]);
		}

		// �Է� �Ϸ�� ���� �гη� �Ѿ�� ���� �гΰ� ��ư ����
		completePanel = new JPanel();
		completePanel.setBounds(1000, 20, 140, 50);
		completePanel.setLayout(null);
		completePanel.setVisible(false);
		mainPanel.add(completePanel);

		completeBtn = new JButton("NEXT");
		completeBtn.setBounds(5, 5, 130, 45);
		completeBtn.setFont(new Font("Verdana", Font.BOLD, 16));
		completeBtn.setBorder(BorderFactory.createLineBorder(new Color(0, true)));
		completeBtn.setBackground(Color.lightGray);
		completeBtn.setForeground(Color.black);
		completeBtn.addMouseListener(mouseevent);
		completeBtn.addActionListener(ICL);
		completePanel.add(completeBtn);

		// �Է¹޾� ����� ��¥�� �����ִ� �гΰ� �� ����
		dateShowPanel = new JPanel();
		dateShowPanel.setBounds(25, 20, 150, 50);
		dateShowPanel.setBackground(Color.white);
		dateShowPanel.setLayout(new GridLayout(1, 3));
		dateShowPanel.setVisible(false);
		dateShowPanel.setBorder(BorderFactory.createTitledBorder("Today"));
		mainPanel.add(dateShowPanel);

		yearMainlbl = new JLabel();
		yearMainlbl.setForeground(Color.black);
		yearMainlbl.setFont(Vdn12);
		yearMainlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowPanel.add(yearMainlbl);

		monthMainlbl = new JLabel();
		monthMainlbl.setForeground(Color.black);
		monthMainlbl.setFont(Vdn12);
		monthMainlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowPanel.add(monthMainlbl);

		dayMainlbl = new JLabel();
		dayMainlbl.setForeground(Color.black);
		dayMainlbl.setFont(Vdn12);
		dayMainlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowPanel.add(dayMainlbl);
	}

	// ����� ���� �г��� TableLayoutPanel�� ���� �������� ������
	public DefaultSettingPanel(TableLayoutPanel p) {
		TLP = p;
	}

	public DefaultSettingPanel(SalesPrintPanel p) {
		SPP = p;
	}

	// ������ �Է¹޾� �����ϱ� ���� �̺�Ʈ�ڵ鷯 Ŭ����
	private class InputCompleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// �̺�Ʈ�� �߻��� ������Ʈ�� ����
			if (obj == nameInput) {
				// ���� �̸��� �ԷµǾ��ٸ� �ش� �󺧰� �ؽ�Ʈ�ʵ带 ��Ȱ��ȭ��Ű�� ���� ���� ��¥ �� ���� �󺧰� �ؽ�Ʈ �ʵ带 Ȱ��ȭ
				nameShowlbl.setVisible(false);
				nameInput.setEnabled(false);
				nameInput.setVisible(false);
				yearShowlbl.setVisible(true);
				yearInput.setEnabled(true);
				yearInput.setVisible(true);
				nameInputtedlbl.setText(nameInput.getText());
				namelbl.setVisible(true);
				nameInputtedlbl.setVisible(true);
				// TableLayoutPanel Ŭ������ �޼ҵ�� �Էµ� �̸��� ����
				TLP.setName(nameInput.getText());
			} else if (obj == yearInput) {
				IDC.setYear(Integer.parseInt(yearInput.getText()));
				// �ؽ�Ʈ�ʵ忡 �Էµ� ���ڿ��� ���ڷ� ��ȯ�� InputDataCheck Ŭ������ ����
				yearShowlbl.setVisible(false);
				yearInput.setEnabled(false);
				yearInput.setVisible(false);
				nYear = IDC.getYear();
				// TableLayoutPanel Ŭ������ �޼ҵ�� �Էµ� ��¥ �� ���� ����
				TLP.setYear(nYear);
				SPP.setYear(nYear);
				yearMainlbl.setText("" + nYear);
				if (nYear == 0) {
					// �Էµ� ���� �߸��� ���̶� 0���� �缳���Ǿ��ٸ�
					yearInput.setText("");
					// �ؽ�Ʈ�ʵ带 �ʱ�ȭ�ϰ� �ٽ��Է� �޵����Ѵ�.
					yearShowlbl.setVisible(true);
					yearInput.setEnabled(true);
					yearInput.setVisible(true);
					// ���� �޼����� ����ڿ��� ����Ѵ�.
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					ErrorMessagelbl.setVisible(true);
					defaultMessagelbl.setVisible(false);
				} else {
					yearInputtedlbl.setText(yearInput.getText());
					yearlbl.setVisible(true);
					yearInputtedlbl.setVisible(true);
					monthShowlbl.setVisible(true);
					monthInput.setVisible(true);
					monthInput.setEnabled(true);
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
				}
			} else if (obj == monthInput) {
				// �ؽ�Ʈ�ʵ忡 �Էµ� ���ڿ��� ���ڷ� ��ȯ�� InputDataCheck Ŭ������ ����
				IDC.setMonth(Integer.parseInt(monthInput.getText()));
				monthShowlbl.setVisible(false);
				monthInput.setVisible(false);
				monthInput.setEnabled(false);
				nMonth = IDC.getMonth();
				// TableLayoutPanel Ŭ������ �޼ҵ�� �Էµ� ��¥ �� ���� ����
				TLP.setMonth(nMonth);
				SPP.setMonth(nMonth);
				monthMainlbl.setText("" + nMonth);
				if (nMonth == 0) {
					// �Էµ� ���� �߸��� ���̶� 0���� �缳���Ǿ��ٸ�
					monthInput.setText("");
					// �ؽ�Ʈ�ʵ带 �ʱ�ȭ�ϰ� �ٽ��Է� �޵����Ѵ�.
					monthShowlbl.setVisible(true);
					monthInput.setVisible(true);
					monthInput.setEnabled(true);
					// �����޼����� ���
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					ErrorMessagelbl.setVisible(true);
					defaultMessagelbl.setVisible(false);
				} else {
					monthInputtedlbl.setText(monthInput.getText());
					monthlbl.setVisible(true);
					monthInputtedlbl.setVisible(true);
					dayShowlbl.setVisible(true);
					dayInput.setVisible(true);
					dayInput.setEnabled(true);
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
				}
			} else if (obj == dayInput) {
				IDC.setDay(Integer.parseInt(dayInput.getText()));
				// �ؽ�Ʈ�ʵ忡 �Էµ� ���ڿ��� ���ڷ� ��ȯ�� InputDataCheck Ŭ������ ����
				dayShowlbl.setVisible(false);
				dayInput.setVisible(false);
				dayInput.setEnabled(false);
				nDay = IDC.getDay();
				// TableLayoutPanel Ŭ������ �޼ҵ带 �̿��� ��¥ �� ���� ����
				TLP.setDay(nDay);
				SPP.setDay(nDay);
				dayMainlbl.setText("" + nDay);
				if (nDay == 0) {
					// �Էµ� ���� �߸��� ���̶� 0���� �缳���Ǿ��ٸ�
					dayInput.setText("");
					// �ؽ�Ʈ�ʵ带 �ʱ�ȭ�ϰ� �ٽ��Է� �޵����Ѵ�.
					dayShowlbl.setVisible(true);
					dayInput.setVisible(true);
					dayInput.setEnabled(true);
					// �����޼����� ���
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					ErrorMessagelbl.setVisible(true);
					defaultMessagelbl.setVisible(false);
				} else {
					dayInputtedlbl.setText(dayInput.getText());
					daylbl.setVisible(true);
					dayInputtedlbl.setVisible(true);
					tableShowlbl.setVisible(true);
					tableInput.setVisible(true);
					tableInput.setEnabled(true);
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
				}
			} else if (obj == tableInput) {
				IDC.setTable(Integer.parseInt(tableInput.getText()));
				// �ؽ�Ʈ�ʵ忡 �Էµ� ���ڿ��� ���ڷ� ��ȯ�� InputDataCheck Ŭ������ ����
				tableShowlbl.setVisible(false);
				tableInput.setVisible(false);
				tableInput.setEnabled(false);
				nTable = IDC.getTable();
				// TLPŬ������ �޼ҵ�� ���� ����
				TLP.setTable(nTable);
				if (nTable == 0) {
					// �Էµ� ���� �߸��� ���̶� 0���� �缳���Ǿ��ٸ�
					tableInput.setText("");
					// �ؽ�Ʈ�ʵ带 �ʱ�ȭ�ϰ� �ٽ��Է� �޵����Ѵ�.
					tableShowlbl.setVisible(true);
					tableInput.setVisible(true);
					tableInput.setEnabled(true);
					// ���̺� ������ 10�̴�.
					ErrorMessagelbl.setText("Input Error! Table is only 10");
					ErrorMessagelbl.setVisible(true);
					defaultMessagelbl.setVisible(false);
				} else {
					tableInputtedlbl.setText(tableInput.getText());
					tablelbl.setVisible(true);
					tableInputtedlbl.setVisible(true);
					menuShowlbl.setVisible(true);
					menuInput.setVisible(true);
					menuInput.setEnabled(true);
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
				}
			} else if (obj == menuInput) {
				IDC.setMenu(Integer.parseInt(menuInput.getText()));
				// �ؽ�Ʈ�ʵ忡 �Էµ� ���ڿ��� ���ڷ� ��ȯ�� InputDataCheck Ŭ������ ����
				menuShowlbl.setVisible(false);
				menuInput.setVisible(false);
				menuInput.setEnabled(false);
				nMenu = IDC.getMenu();
				// TLPŬ������ �޼ҵ带 �̿��� �޴� ������ ����
				TLP.setMenu(nMenu);
				if (nMenu == 0) {
					// �Էµ� ���� �߸��� ���̶� 0���� �缳���Ǿ��ٸ�
					menuInput.setText("");
					// �ؽ�Ʈ�ʵ带 �ʱ�ȭ�ϰ� �ٽ��Է� �޵����Ѵ�.
					menuShowlbl.setVisible(true);
					menuInput.setVisible(true);
					menuInput.setEnabled(true);
					// �޴��� 5��
					ErrorMessagelbl.setText("Input Error! Menu is only 5");
					ErrorMessagelbl.setVisible(true);
					defaultMessagelbl.setVisible(false);
				} else {
					menuInputtedlbl.setText(menuInput.getText());
					menulbl.setVisible(true);
					menuInputtedlbl.setVisible(true);
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
					menuNameMainlbl.setVisible(true);
					menuNameInput.setEnabled(true);
					menuNameInput.setVisible(true);
					menuPricelbl.setVisible(true);
					menuPriceInput.setEnabled(true);
					menuPriceInput.setVisible(true);
					menuCntlbl.setVisible(true);
					menuCntInput.setEnabled(true);
					menuCntInput.setVisible(true);
				}
			}
			if (obj == completeBtn) {
				mainPanel.setVisible(false);
				TLP.setVisible(true);
			}
		} // actionPerformed()
	} // HighLowListener class

	// �޴��� �̸��� ������ �Է¹޾� �����ϱ� ���� �̺�Ʈ�ڵ鷯 Ŭ����
	private class menuInputListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// �̺�Ʈ�� �߻��� ������Ʈ�� ����
			// �޴� �̸� �Է½�
			if (obj == menuNameInput) {
				// �ش� �޴��� �̸��� �����ϰ� ���
				if (menuNameInputCnt == 0) {
					menuNameArray[0].setText("" + menuNameInput.getText());
					TLP.setMenuName(menuNameInputCnt, menuNameArray[0].getText());
					menuInputtedName.setVisible(true);
					menuNameArray[0].setVisible(true);
					menuNameInputCnt++;
				} else if (menuNameInputCnt == 1) {
					menuNameArray[1].setText("" + menuNameInput.getText());
					TLP.setMenuName(menuNameInputCnt, menuNameArray[1].getText());
					menuNameArray[1].setVisible(true);
					menuNameInputCnt++;
				} else if (menuNameInputCnt == 2) {
					menuNameArray[2].setText("" + menuNameInput.getText());
					TLP.setMenuName(menuNameInputCnt, menuNameArray[2].getText());
					menuNameArray[2].setVisible(true);
					menuNameInputCnt++;
				} else if (menuNameInputCnt == 3) {
					menuNameArray[3].setText("" + menuNameInput.getText());
					TLP.setMenuName(menuNameInputCnt, menuNameArray[3].getText());
					menuNameArray[3].setVisible(true);
					menuNameInputCnt++;
				} else if (menuNameInputCnt == 4) {
					menuNameArray[4].setText("" + menuNameInput.getText());
					TLP.setMenuName(menuNameInputCnt, menuNameArray[4].getText());
					menuNameArray[4].setVisible(true);
					menuNameInput.setEnabled(false); // �޴� �ټ��� �Է��ϸ� �ؽ�Ʈ�ʵ� ��Ȱ��ȭ
				}
				menuNameInput.setText(""); // �ؽ�Ʈ�ʵ� �ʱ�ȭ
			}
			// �޴� ���� �Է½�
			else if (obj == menuPriceInput) {
				// �ؽ�Ʈ�ʵ��� ���� IDC�� �޼ҵ�� �����Ŵ
				IDC.setMenuPrice(Integer.parseInt(menuPriceInput.getText()));
				// �ش�޴��� �Էµ� ������ �����ϰ� ���
				if (menuPriceInputCnt == 0) {
					menuPriceArray[0] = IDC.getMenuPrice();
					menuInputtedPrice.setVisible(true);
					menuPricelblArray[0].setText("" + menuPriceArray[0]);
					menuPricelblArray[0].setVisible(true);
					TLP.setMenuPrice(menuPriceInputCnt, menuPriceArray[0]);
					SPP.setMenuPrice(menuPriceInputCnt, menuPriceArray[0]);
					menuPriceInputCnt++;
				} else if (menuPriceInputCnt == 1) {
					menuPriceArray[1] = IDC.getMenuPrice();
					menuPricelblArray[1].setText("" + menuPriceArray[1]);
					menuPricelblArray[1].setVisible(true);
					TLP.setMenuPrice(menuPriceInputCnt, menuPriceArray[1]);
					SPP.setMenuPrice(menuPriceInputCnt, menuPriceArray[1]);
					menuPriceInputCnt++;
				} else if (menuPriceInputCnt == 2) {
					menuPriceArray[2] = IDC.getMenuPrice();
					menuPricelblArray[2].setText("" + menuPriceArray[2]);
					menuPricelblArray[2].setVisible(true);
					TLP.setMenuPrice(menuPriceInputCnt, menuPriceArray[2]);
					SPP.setMenuPrice(menuPriceInputCnt, menuPriceArray[2]);
					menuPriceInputCnt++;
				} else if (menuPriceInputCnt == 3) {
					menuPriceArray[3] = IDC.getMenuPrice();
					menuPricelblArray[3].setText("" + menuPriceArray[3]);
					menuPricelblArray[3].setVisible(true);
					TLP.setMenuPrice(menuPriceInputCnt, menuPriceArray[3]);
					SPP.setMenuPrice(menuPriceInputCnt, menuPriceArray[3]);
					menuPriceInputCnt++;
				} else if (menuPriceInputCnt == 4 && IDC.getMenuPrice() == 0) {
					menuPriceArray[4] = IDC.getMenuPrice();
					menuPricelblArray[4].setText("" + menuPriceArray[4]);
					menuPricelblArray[4].setVisible(true);
					TLP.setMenuPrice(menuPriceInputCnt, menuPriceArray[4]);
					SPP.setMenuPrice(menuPriceInputCnt, menuPriceArray[4]);
					menuPriceInputCnt++;
				} else if (menuPriceInputCnt == 4 && IDC.getMenuPrice() != 0) {
					menuPriceArray[4] = IDC.getMenuPrice();
					menuPricelblArray[4].setText("" + menuPriceArray[4]);
					TLP.setMenuPrice(menuPriceInputCnt, menuPriceArray[4]);
					SPP.setMenuPrice(menuPriceInputCnt, menuPriceArray[4]);
					menuPricelblArray[4].setVisible(true);
					menuPriceInput.setEnabled(false);
				}
				menuPriceInput.setText(""); // �ؽ�Ʈ�ʵ� �ʱ�ȭ
				// �Է��� �߸��Ǿ��ٸ� ���Է� �ϵ��� ����
				if (IDC.getMenuPrice() == 0) {
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
					menuPriceInputCnt--;
				} else {
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
				}
			}
			// �޴� ���� �Է½�
			else if (obj == menuCntInput) {
				// �ؽ�Ʈ�ʵ��� ���� IDC�� �޼ҵ�� �����Ŵ
				IDC.setMenuCnt(Integer.parseInt(menuCntInput.getText()));
				// �ش� �޴��� �Էµ� �� �޴��� ���� �ǸŰ����� ����
				if (menuCntInputCnt == 0) {
					menuCntArray[0] = IDC.getMenuCnt();
					menuInputtedCnt.setVisible(true);
					menuCntlblArray[0].setText("" + menuCntArray[0]);
					menuCntlblArray[0].setVisible(true);
					TLP.setMenuCnt(menuCntInputCnt, menuCntArray[0]);
					menuCntInputCnt++;
				} else if (menuCntInputCnt == 1) {
					menuCntArray[1] = IDC.getMenuCnt();
					menuCntlblArray[1].setText("" + menuCntArray[1]);
					menuCntlblArray[1].setVisible(true);
					TLP.setMenuCnt(menuCntInputCnt, menuCntArray[1]);
					menuCntInputCnt++;
				} else if (menuCntInputCnt == 2) {
					menuCntArray[2] = IDC.getMenuCnt();
					menuCntlblArray[2].setText("" + menuCntArray[2]);
					menuCntlblArray[2].setVisible(true);
					TLP.setMenuCnt(menuCntInputCnt, menuCntArray[2]);
					menuCntInputCnt++;
				} else if (menuCntInputCnt == 3) {
					menuCntArray[3] = IDC.getMenuCnt();
					menuCntlblArray[3].setText("" + menuCntArray[3]);
					menuCntlblArray[3].setVisible(true);
					TLP.setMenuCnt(menuCntInputCnt, menuCntArray[3]);
					menuCntInputCnt++;
				} else if (menuCntInputCnt == 4 && IDC.getMenuCnt() == 0) {
					menuCntArray[4] = IDC.getMenuCnt();
					menuCntlblArray[4].setText("" + menuCntArray[4]);
					menuCntlblArray[4].setVisible(true);
					TLP.setMenuCnt(menuCntInputCnt, menuCntArray[4]);
					menuCntInputCnt++;
				} else if (menuCntInputCnt == 4 && IDC.getMenuCnt() != 0) {
					menuCntArray[4] = IDC.getMenuCnt();
					menuCntlblArray[4].setText("" + menuCntArray[4]);
					TLP.setMenuCnt(menuCntInputCnt, menuCntArray[4]);
					menuCntlblArray[4].setVisible(true);
					menuCntInput.setEnabled(false);
					// �Ϸ��г��� ���̰� ��
					completePanel.setVisible(true);
					defaultMessagelbl.setText("Setting Complete. Click NEXT Button!");
					defaultMessagelbl.setFont(new Font("Verdana", Font.BOLD, 20));
					dateShowPanel.setVisible(true);
				}
				menuCntInput.setText(""); // �ؽ�Ʈ�ʵ� �ʱ�ȭ
				// �Է��� �߸��Ǿ��ٸ� ���Է� �ϵ��� ����
				if (IDC.getMenuCnt() == 0) {
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
					menuCntInputCnt--;
				} else {
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
				}
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
			btnMenu.setBackground(Color.white);
			btnMenu.setForeground(Color.black);
		} // mouseEntered()

		public void mouseExited(MouseEvent event) {
			JButton btnMenu = (JButton) event.getSource();
			btnMenu.setBackground(Color.LIGHT_GRAY);
			btnMenu.setForeground(Color.black);
		} // mouseExited()
	} // MenuButtonListener class
}
