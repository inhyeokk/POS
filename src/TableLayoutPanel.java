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
	// *11.14 수정
	private JPanel mainPanel;
	// 테이블 패널
	private JPanel tableMainPanel;

	// *11.21 테이블과 메뉴를 배열로 선언
	private JPanel[] tablePanelArray;
	private int[] tablePriceSumArray;
	private JButton[] tableBtnArray;
	private JLabel[] tableSumlblArray;

	// *11.21 메뉴, 가격 입력 패널 선언
	private JPanel[] menuPanelArray;
	// *11.21 수정
	private JButton[] menuBtnArray;
	private JLabel[] menuPricelblArray;
	private int[] menuPriceArray;
	// *11.27 수정 메뉴가 주문될때마다 그 횟수를 카운트하기 위한 라벨과 정수형 변수 선언
	private JLabel[] menuOrderCntArray;
	private int[] menuOrderCnt;

	// 테이블 계산 관련
	private int totalSum = 0;
	private int tableSelect = 11;

	// 메뉴정보 수정시 입력을 받기위한 패널 선언
	private JPanel menuInputPanel;
	private JPanel menuMainPanel;
	private JLabel menuNameMainlbl, menuPricelbl, menuCntlbl;
	private JTextField menuNameInput, menuPriceInput, menuCntInput;

	// 메뉴 재입력(초기화)
	private JPanel ResetPanel;
	private JLabel Resetlbl;
	private JButton ResetAllBtn, ResetTableBtn, ResetMenuBtn;

	// *11.24 수정
	private int menuNameBtnSelect, menuPriceBtnSelect, menuCntBtnSelect;

	// *11.25 수정 저장된 메뉴들을 각 테이블 패널에 저장한후 주문이 추가되면 카운트 증가
	private JLabel[][] menuTableArray;
	private int[][] menuTableCntArray;

	// *11.25 계산 및 수정 버튼을 담기위한 패널 선언
	private JPanel settingPanel;
	private JLabel settinglbl;

	// *11.25 메뉴 정보를 수정하기 위한 버튼 선언
	private int menuSelect = 6;
	private JButton menuModifyBtn;

	// *11.25 각 테이블에서 계산이 완료되면 정산 패널을 띄우기위한 버튼 선언
	private JButton tableCalculationBtn;

	// 완료 *11.28 입력 완료시 매출을 표시하기 위한 패널로 넘어가기위한 완료버튼
	private JPanel completePanel;
	private JButton completeBtn;

	// *12.02 초기입력된 당일 각 메뉴 판매 개수와 동일해지면 품절메세지 출력을위한 선언
	private int[] menuCntArray;

	// 입력된 날짜를 보여주는 패널
	private JPanel dateShowPanel;
	private JLabel yearlbl, monthlbl, daylbl;
	private int nYear, nMonth, nDay;

	// 사용자에게 보여줄 메세지를 출력하기 위한 패널 선언
	private JPanel MessagePanel;
	// 평상시 출력중인 라벨
	private JLabel defaultMessagelbl;
	// 입력값 오류시 에러메세지 출력하기 위한 라벨 선언
	private JLabel ErrorMessagelbl;

	// 정산
	private JPanel CountPanel;
	private JLabel Countlbl, Cardlbl, Cashlbl, totallbl, totalShowlbl;
	private JButton CardBtn, CashBtn;
	private int cardSum = 0, cashSum = 0, sum = 0;
	private JTextField CashInput;
	private JButton calculationCompleteBtn;
	private JLabel tableCalMessage;

	// 이벤트 핸들러 객체 선언
	private TableSumListener TableSum;
	private ValueResetListener ValueReset;
	private MenuModifyListener MenuModify;
	private ResetButtonListener ResetBtn;
	private MenuButtonListener mouseevent;
	private InputCompleteListener InputCompleteL;

	// 사용자 정의 클래스 선언
	private InputDataCheck IDC;
	private DefaultSettingPanel DSP;
	private SalesPrintPanel SPP;

	// 메인 패널
	public TableLayoutPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(null);

		// 사용자 정의 클래스의 객체 생성
		IDC = new InputDataCheck();
		DSP = new DefaultSettingPanel(this);
		SPP = new SalesPrintPanel();

		// 이벤트 핸들러 객체 생성
		TableSum = new TableSumListener();
		ValueReset = new ValueResetListener();
		MenuModify = new MenuModifyListener();
		ResetBtn = new ResetButtonListener();
		mouseevent = new MenuButtonListener();
		InputCompleteL = new InputCompleteListener();

		// 사용할 폰트의 객체를 선언 및 생성
		Font Vdn24 = new Font("Verdana", Font.BOLD, 24);
		Font Vdn18 = new Font("Verdana", Font.BOLD, 18);
		Font Vdn14 = new Font("Verdana", Font.BOLD, 14);
		Font Vdn12 = new Font("Verdana", Font.BOLD, 12);
		Font Vdn10 = new Font("Verdana", Font.BOLD, 10);
		Font Vdn8 = new Font("Verdana", Font.BOLD, 8);

		// 가격을 저장하는 정수형 배열 저장 및 초기화
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

		// // 다음에 표시될 패널을 생성 후 메인 패널에 추가
		SPP.setLayout(null);
		SPP.setVisible(false);
		this.add(SPP);

		// 테이블에 저장된 값을 계산하고 메뉴에 저장된 이름과 가격을 수정하기 위한 패널 생성
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
		// 사용자에게 메세지를 출력하기위한 패널
		MessagePanel = new JPanel();
		MessagePanel.setBounds(300, 20, 600, 50);
		MessagePanel.setBackground(Color.black);
		MessagePanel.setLayout(null);
		mainPanel.add(MessagePanel);

		// 평상시 출력중인 라벨
		defaultMessagelbl = new JLabel("Running Program");
		defaultMessagelbl.setBounds(10, 5, 580, 40);
		defaultMessagelbl.setFont(Vdn24);
		defaultMessagelbl.setForeground(Color.white);
		defaultMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		defaultMessagelbl.setVisible(true);
		MessagePanel.add(defaultMessagelbl);

		// 사용자 입력시 발생한 에러를 출력하기 위한 라벨
		ErrorMessagelbl = new JLabel("");
		ErrorMessagelbl.setBounds(10, 5, 580, 40);
		ErrorMessagelbl.setFont(Vdn24);
		ErrorMessagelbl.setForeground(Color.red);
		ErrorMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorMessagelbl.setVisible(false);
		MessagePanel.add(ErrorMessagelbl);

		// -----------------------------------------------------------
		// DefaultSettingPanel에서 입력받아 저장된 날짜를 출력하는 패널 및 라벨 생성
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
		// 테이블을 입력된 개수에 맞게 배치하는 패널 생성
		tableMainPanel = new JPanel();
		tableMainPanel.setBounds(25, 100, 1150, 400);
		tableMainPanel.setBackground(Color.white);
		tableMainPanel.setLayout(new GridLayout(2, 5));
		tableMainPanel.setBorder(BorderFactory.createTitledBorder("TABLE"));
		mainPanel.add(tableMainPanel);

		// 입력된 개수 만큼 각 테이블 패널을 생성
		tablePanelArray = new JPanel[10];
		for (int i = 0; i < 10; i++) {
			tablePanelArray[i] = new JPanel();
			tablePanelArray[i].setBackground(Color.cyan);
			tablePanelArray[i].setBorder(BorderFactory.createTitledBorder("" + (i + 1)));
			tablePanelArray[i].setLayout(new GridLayout(4, 2));
			tableMainPanel.add(tablePanelArray[i]);
		}

		// -------------------------------------------------------------
		// 메뉴를 입력된 개수에 맞게 배치하는 패널 생성
		menuMainPanel = new JPanel();
		menuMainPanel.setBounds(25, 530, 800, 150);
		menuMainPanel.setBackground(Color.white);
		menuMainPanel.setLayout(new GridLayout(1, 5));
		menuMainPanel.setBorder(BorderFactory.createTitledBorder("MENU"));
		mainPanel.add(menuMainPanel);

		// 입력된 개수 만큼 각 메뉴 패널을 생성
		menuPanelArray = new JPanel[5];
		for (int i = 0; i < 5; i++) {
			menuPanelArray[i] = new JPanel();
			menuPanelArray[i].setBackground(Color.cyan);
			menuPanelArray[i].setBorder(BorderFactory.createTitledBorder("" + (i + 1)));
			menuPanelArray[i].setLayout(new GridLayout(3, 1));
			menuMainPanel.add(menuPanelArray[i]);
		}

		// 각 메뉴 패널 내부에 메뉴 이름을 저장하는 버튼과 가격을 저장하는 라벨을 생성
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

		// 입력된 메뉴의 정보를 수정입력하기 위한 패널 생성
		menuInputPanel = new JPanel();
		menuInputPanel.setBounds(25, 700, 800, 70);
		menuInputPanel.setBorder(BorderFactory.createTitledBorder("INPUT"));
		menuInputPanel.setBackground(Color.white);
		menuInputPanel.setVisible(false);
		menuInputPanel.setLayout(new GridLayout(1, 6));
		mainPanel.add(menuInputPanel);

		// 입력된 메뉴의 정보를 수정입력하기 위한 라벨과 텍스트 필드 생성
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
		// 입력된 테이블과 메뉴 정보를 초기화 하기 위한 패널과 라벨 버튼 생성
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

		// 정산 패널
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
		CashInput.setEnabled(true); // ★버튼 활성화
		CountPanel.add(CashInput);

		// *11.27 수정 계산기에 몇번테이블의 총 가격이 얼마인지 안내해 주기 위해 라벨로 생성
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

			// 테이블 메뉴,가격 라벨 생성
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

		// 입력 완료시 다음 패널로 넘어가기 위한 패널과 버튼 생성
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

	// 테이블, 메뉴 버튼과 계산을 담당하는 액션리스너 선언
	private class TableSumListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			int result;
			for (int i = 0; i < 10; i++) {
				// 테이블 버튼이 눌렸다면
				if (obj == tableBtnArray[i]) {
					result = JOptionPane.showConfirmDialog(mainPanel, (i + 1) + "번 테이블이 맞습니까?"); // 안내창
					if (result == JOptionPane.YES_OPTION) { // YES를 눌렀을 때
						// 해당 테이블의 정보를 저장
						tableSelect = i;
						// tableSumlblArray[i].setText("Selected");
						// 해당 테이블에 저장된 합계를 보여지게함
						tableSumlblArray[i].setVisible(true);
						// 패널 상단 메세지를 기본으로 변경
						defaultMessagelbl.setVisible(true);
						ErrorMessagelbl.setVisible(false);
						// 식사를 마치고 계산을 원할때 계산기에 저장된 가격을 출력
						tableCalMessage.setText((tableSelect + 1) + "Table's price is " + tablePriceSumArray[i]);
						tableCalMessage.setVisible(true);
					}
				}
			}
			for (int i = 0; i < 5; i++) {
				// 메뉴의 버튼이 눌렸다면
				if (obj == menuBtnArray[i]) {
					// 해당 메뉴의 정보를 저장
					menuSelect = i;
					// 메뉴에 정상적인 정보가 저장되어있다면
					if (menuPriceArray[i] != 0 && menuCntArray[i] != menuOrderCnt[i]) {
						// 패널 상단 메세지를 기본으로 변경
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
						// 메뉴에 가격이 저장되어있지 않다면
					} else if (menuPriceArray[i] == 0) {
						// 동작을 실행하지 않고 패널 상단에 에러메세지를 출력
						ErrorMessagelbl.setText((i + 1) + "Menu has not been set");
						defaultMessagelbl.setVisible(false);
						ErrorMessagelbl.setVisible(true);
						// 이전 패널에서 입력한 정보 중 메뉴의 총 판매개수와 오늘 팔린개수와 동일하다면
					} else if (menuCntArray[i] == menuOrderCnt[i]) {
						// 동작을 실행하지 않고 상단에 에러메세지를 출력
						ErrorMessagelbl.setText((i + 1) + "Menu is sold out");
						defaultMessagelbl.setVisible(false);
						ErrorMessagelbl.setVisible(true);
					}
				}
			}

			// 계산기의 카드버튼이 눌렸다면
			if (obj == CardBtn) {
				for (int i = 0; i < 10; i++) {
					// 기 입력된 테이블의 정보에 대한 동작을 설정
					if (tableSelect == i) {
						// 가격입력창의 정보를 정수형으로 변경
						int a = Integer.parseInt(CashInput.getText());
						// 입력된 가격과 해당 테이블에 저장된 가격과 비교
						// 크다면 정상적인 계산과정을 실행
						if (tablePriceSumArray[i] - a > 0) {
							// 전체 합계에 추가
							totalSum += a;
							// 카드 합계에 추가
							cardSum += a;
							// 가격을 출력하는 라벨을 변경된 정보에 맞게 변경
							Cardlbl.setText("" + cardSum);
							totallbl.setText("" + totalSum);
							CashInput.setText(""); // 텍스트 필드 초기화
							tablePriceSumArray[i] -= a;
							tableSumlblArray[i].setText("" + tablePriceSumArray[i]);
							// 패널 상단 메세지를 기본으로 변경
							defaultMessagelbl.setVisible(true);
							ErrorMessagelbl.setVisible(false);
							// 저장된 값과 일치한다면 계산 완료과정을 실행
						} else if (tablePriceSumArray[i] == a) {
							// 계산 완료
							// 전체 합계에 추가
							totalSum += a;
							// 카드 합계에 추가
							cardSum += a;
							// 가격을 출력하는 라벨을 변경된 정보에 맞게 변경
							Cardlbl.setText("" + cardSum);
							totallbl.setText("" + totalSum);
							tablePriceSumArray[i] -= a;
							tableSumlblArray[i].setText("");
							CashInput.setText("");
							// 계산완료 버튼을 보여지게함
							calculationCompleteBtn.setVisible(true);
							// 패널 상단 메세지를 기본으로 변경
							defaultMessagelbl.setVisible(true);
							ErrorMessagelbl.setVisible(false);
							// 저장된 값보다 작은 잘못된 입력이 입력된다면
						} else // tablePriceSumArray[i] < a
						{
							CashInput.setText(""); // 텍스트 필드 초기화
							// 입력이 잘못되었다는 에러메세지를 출력
							ErrorMessagelbl.setText("Inputted Value is bigger than PriceSum");
							defaultMessagelbl.setVisible(false);
							ErrorMessagelbl.setVisible(true);
						}
					}
				}
				// 계산기의 현금버튼이 눌렸다면
			} else if (obj == CashBtn) {
				for (int i = 0; i < 10; i++) {
					// 기 입력된 테이블의 정보에 대한 동작을 설정
					if (tableSelect == i) {
						// 가격입력창의 정보를 정수형으로 변경
						int a = Integer.parseInt(CashInput.getText());
						// 입력된 가격과 해당 테이블에 저장된 가격과 비교
						// 크다면 정상적인 계산과정을 실행
						if (tablePriceSumArray[i] - a > 0) {
							// 전체 합계에 추가
							totalSum += a;
							// 현금 합계에 추가
							cashSum += a;
							// 가격을 출력하는 라벨을 변경된 정보에 맞게 변경
							Cashlbl.setText("" + cashSum);
							totallbl.setText("" + totalSum);
							CashInput.setText(""); // 텍스트 필드 초기화
							tablePriceSumArray[i] -= a;
							tableSumlblArray[i].setText("" + tablePriceSumArray[i]);
							// 패널 상단 메세지를 기본으로 변경
							defaultMessagelbl.setVisible(true);
							ErrorMessagelbl.setVisible(false);
							// 저장된 값과 일치한다면 계산 완료과정을 실행
						} else if (tablePriceSumArray[i] == a) {
							// 전체 합계에 추가
							totalSum += a;
							// 현금 합계에 추가
							cashSum += a;
							// 가격을 출력하는 라벨을 변경된 정보에 맞게 변경
							Cashlbl.setText("" + cashSum);
							totallbl.setText("" + totalSum);
							tablePriceSumArray[i] -= a;
							tableSumlblArray[i].setText("");
							CashInput.setText("");
							// 계산완료 버튼을 보여지게함
							calculationCompleteBtn.setVisible(true);
							// 패널 상단 메세지를 기본으로 변경
							defaultMessagelbl.setVisible(true);
							ErrorMessagelbl.setVisible(false);
							// 저장된 값보다 작은 잘못된 입력이 입력된다면
						} else // tablePriceSumArray[i] < a
						{
							CashInput.setText(""); // 텍스트 필드 초기화
							// 입력이 잘못되었다는 에러메세지를 출력
							ErrorMessagelbl.setText("Inputted Value is bigger than PriceSum");
							defaultMessagelbl.setVisible(false);
							ErrorMessagelbl.setVisible(true);
						}
					}
				}
			}
			// 계산 버튼이 눌렸다면
			if (obj == tableCalculationBtn) {
				// 계산기 패널을 보여지도록 설정
				CountPanel.setVisible(true);
				// 테이블 버튼이 눌려지지 않았을 때 올바르지 않은 입력이라는 경우를 설정
				if (tableSelect == 11) {
					// 테이블 버튼이 눌려지지 않았다는 에러메세지를 출력
					ErrorMessagelbl.setText("Please select a table before calculating");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				}
			}
			// 계산 완료버튼이 눌렸다면
			if (obj == calculationCompleteBtn) {
				// 해당 테이블의 총가격을 메세지창에 출력
				result = JOptionPane.showConfirmDialog(mainPanel, totalSum + "원을 결제하시겠습니까?"); // 안내창
				if (result == JOptionPane.YES_OPTION) { // YES를 눌렀을 때
					// 계산이 완료되면 테이블의 계산 합을 전체 매출에 추가한다.
					// 해당 테이블의 모든 정보를 초기화
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

	// 값 초기화를 담당하는 액션리스너 선언
	private class ValueResetListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// 이벤트가 발생한 컴포넌트가 저장
			int result;

			// 전체를 초기화 한다는 버튼이 눌렸다면
			if (obj == ResetAllBtn) {
				// 사용자에게 한번 더 확인을 시키기 위한 메세지창 출력
				result = JOptionPane.showConfirmDialog(null, "모든 값을 초기화 시키겠습니까?"); // 안내창
				if (result == JOptionPane.YES_OPTION) { // YES를 눌렀을 때
					// 테이블과 메뉴에 저장된 모든 값을 초기로 설정
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

					// 초기화가 완료되었다는 메세지를 출력
					ErrorMessagelbl.setText("Reset Complete");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				}
				// 테이블의 정보만 초기화 시키기 원한다면
			} else if (obj == ResetTableBtn) {
				// 사용자에게 한번 더 확인을 시키기 위한 메세지창 출력
				result = JOptionPane.showConfirmDialog(null, "각 테이블에 저장된 값을 초기화 시키겠습니까?"); // 안내창
				if (result == JOptionPane.YES_OPTION) { // YES를 눌렀을 때
					// 테이블에 저장된 모든 값을 초기화
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
				// 메뉴이 정보만 초기화 시키기 원한다면
			} else if (obj == ResetMenuBtn) {
				// 사용자에게 한번 더 확인을 시키기 위한 메세지창 출력
				result = JOptionPane.showConfirmDialog(null, "메뉴의 이름과 가격을 모두 초기화 시키겠습니까?"); // 안내창
				if (result == JOptionPane.YES_OPTION) { // YES를 눌렀을 때
					// 메뉴에 저장된 모든 값을 초기화
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

	// 저장된 메뉴의 정보 수정을 담당하는 액션리스너 선언
	private class MenuModifyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// 이벤트가 발생한 컴포넌트가 저장
			int result;
			// 메뉴 수정 버튼이 눌렸다면
			if (obj == menuModifyBtn) {
				for (int i = 0; i < 5; i++) {
					// 기 저장된 메뉴에 대한 동작을 설정
					if (menuSelect == i) {
						// 사용자에게 다시 한번 확인을 위한 메세지 창 출력
						result = JOptionPane.showConfirmDialog(mainPanel, (i + 1) + "번 메뉴정보를 수정하시겠습니까?"); // 안내창
						if (result == JOptionPane.YES_OPTION) { // YES를 눌렀을 때
							// 각 버튼의 정보를 저장시킴
							menuNameBtnSelect = i;
							menuPriceBtnSelect = i;
							menuCntBtnSelect = i;
							// 메뉴가 선택되었다는 메세지를 패널 상단에 출력
							ErrorMessagelbl.setText((menuNameBtnSelect + 1) + "Menu is selected");
							defaultMessagelbl.setVisible(false);
							ErrorMessagelbl.setVisible(true);
							menuInputPanel.setVisible(true);
						}
					}
				}
				// 기 저장된 메뉴의 정보가 없다면(초기 저장된 값이라면)
				if (menuSelect == 6) {
					// 메뉴가 선택되지 않았다는 에러메세지를 출력
					ErrorMessagelbl.setText("Please Click Menu Button");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				}
			}
			// 메뉴의 이름이 수정되었다면
			if (obj == menuNameInput) {
				// 기 저장된 메뉴의 해당하는 정보를 수정
				menuBtnArray[menuNameBtnSelect].setText("" + menuNameInput.getText());
				// 각 테이블에 저장된 이름 또한 수정
				for (int i = 0; i < 10; i++) {
					menuTableCntArray[i][menuNameBtnSelect] = 0;
					menuTableArray[i][menuNameBtnSelect].setText(menuBtnArray[menuNameBtnSelect].getText() + "     "
							+ menuTableCntArray[i][menuNameBtnSelect]);
					menuTableArray[i][menuNameBtnSelect].setVisible(false);
				}
				// 해당 메뉴의 정보가 수정되었다는 메세지를 패널 상단에 출력
				ErrorMessagelbl.setText((menuNameBtnSelect + 1) + "Menu's info is modified");
				defaultMessagelbl.setVisible(false);
				ErrorMessagelbl.setVisible(true);
				menuNameInput.setText(""); // 텍스트필드 초기화
			}
			// 메뉴의 가격이 수정되었다면
			else if (obj == menuPriceInput) {
				// 텍스트필드의 값을 IDC의 메소드로 저장시킴
				IDC.setMenuPrice(Integer.parseInt(menuPriceInput.getText()));
				// 해당 메뉴에 수정된 정보를 저장
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
				// 메뉴의 정보가 수정되었다는 메세지를 패널 상단에 출력
				ErrorMessagelbl.setText((menuPriceBtnSelect + 1) + "Menu's info is modified");
				defaultMessagelbl.setVisible(false);
				ErrorMessagelbl.setVisible(true);
				menuPriceInput.setText(""); // 텍스트필드 초기화
				// 입력이 잘못되었다면 재입력 하도록 설정
				if (IDC.getMenuPrice() == 0) {
					// 입력이 잘못되었다는 메세지를 패널 상단에 출력
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				} else {
					// 그렇지 않다면 기본 메세지를 출력
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
				}
			}
			// 메뉴의 개수가 수정되었다면
			else if (obj == menuCntInput) {
				// 텍스트필드의 값을 IDC의 메소드로 저장시킴
				IDC.setMenuCnt(Integer.parseInt(menuCntInput.getText()));
				// 기 저장된 카운트값을 초기화시킴
				menuOrderCnt[menuSelect] = 0;
				// 해당 메뉴에 수정된 정보를 저장
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
				// 메뉴의 정보가 수정되었다는 메세지를 패널 상단에 출력
				ErrorMessagelbl.setText((menuCntBtnSelect + 1) + "Menu's info is modified");
				defaultMessagelbl.setVisible(false);
				ErrorMessagelbl.setVisible(true);
				menuCntInput.setText(""); // 텍스트필드 초기화
				// 입력이 잘못되었다면 재입력 하도록 설정
				if (IDC.getMenuCnt() == 0) {
					// 입력이 잘못되었다는 에러메세지를 출력
					ErrorMessagelbl.setText("Input Error! Please Re-Enter");
					defaultMessagelbl.setVisible(false);
					ErrorMessagelbl.setVisible(true);
				} else {
					// 입력이 정상적이라면 기본 메세지를 출력
					ErrorMessagelbl.setVisible(false);
					defaultMessagelbl.setVisible(true);
					// 입력 종료시 메뉴 수정 패널을 보여지지 않게 함
					menuInputPanel.setVisible(false);
				}
			}
		}
	} // actionPerformed()
		// 마우스포인터의 위치에 따라 동작을 설정할 이벤트핸들러 클래스

	// 메뉴를 초기화 시키는 버튼을 패널 내부에 마우스 이동시에만 보여지도록 설정하는 마우스 리스너
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

	// 마우스포인터의 위치에 따라 동작을 설정할 이벤트핸들러 클래스
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

	// 해당패널에서의 모든 입력이 완료되었다면 다음패널로 넘어가기위한 이벤트핸들러 클래스
	private class InputCompleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// 이벤트가 발생한 컴포넌트가 저장
			// 입력 완료 버튼이 눌렸다면
			if (obj == completeBtn) {
				int result;
				// 사용자에게 한번 더 패널을 넘어갈 것인지 확인시켜주는 메세지창 출력
				result = JOptionPane.showConfirmDialog(mainPanel, "판매를 마치고 매출을 정산하시겠습니까?"); // 안내창
				if (result == JOptionPane.YES_OPTION) { // YES를 눌렀을 때
					int priceSum = 0, estimatedSales = 0;
					int temp;
					for (int i = 0; i < 5; i++) {
						// 가격의 합계를 메뉴의 가격과 저장된 개수에 맞게 더함
						priceSum += menuPriceArray[i] * SPP.getMenuCnt(i);
					}
					// 한달 가격 합계를 추정하기 위한 반복문
					for (int i = 0; i < 30; i++) {
						for (int j = 0; j < 5; j++) {
							if (SPP.getMenuCnt(j) != 0)
								// 주문된 메뉴의 개수가 0이 아니라면 정상적인 랜덤값으로 추정
								temp = SPP.getMenuCnt(j) + (int) (Math.random() * 10) - 5;
							else
								// 주문된 개수가 0이라면 값을 저장
								temp = SPP.getMenuCnt(j);
							estimatedSales += menuPriceArray[j] * ((temp < 0) ? SPP.getMenuCnt(j) : temp);
						}
					}

					// 저장된 한달 추정치 값을 30으로 나눈 후 1일 추정치를 저장
					SPP.setEstimatedDailySales((int) estimatedSales / 30);
					// 금일 매출 합계를 저장
					SPP.setDailySale(priceSum);
					// 한달 추정치 값을 저장
					SPP.setEstimatedSales(estimatedSales);
					// *11.28 수정 매출 출력패널에 날짜를 저장
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
