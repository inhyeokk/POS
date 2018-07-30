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

//해당 패널에서는 InputDataCheck 클래스를 불러와 날짜를 입력받는다.
public class DefaultSettingPanel extends JPanel {
	// *11.14 수정 main 클래스의 프레임에 추가하기 위한 메인 패널 선언
	private JPanel mainPanel;

	// *11.21수정 정보를 입력하는 패널과 입력된 정보를 저장하고 사용자에게 보여주기 위한 패널 선언
	private JPanel mainInfoPanel;
	private JPanel infoInputPanel;
	private JPanel savedInfoPanel;
	private JPanel savedLeftPanel;
	private JPanel savedRightPanel;

	// 사용자에게 보여줄 메세지를 출력하기 위한 패널 선언
	private JPanel MessagePanel;
	// 평상시 출력중인 라벨
	private JLabel defaultMessagelbl;
	// 입력값 오류시 에러메세지 출력하기 위한 라벨 선언
	private JLabel ErrorMessagelbl;

	// 연월일을 입력받기위한 라벨과 텍스트 필드 선언
	private JLabel nameShowlbl;
	private JTextField nameInput;
	private JLabel yearShowlbl, monthShowlbl, dayShowlbl;
	private JTextField yearInput, monthInput, dayInput;
	// 테이블과 메뉴의 개수를 입력받기위한 라벨과 텍스트 필드 선언
	private JLabel tableShowlbl, menuShowlbl;
	private JTextField tableInput, menuInput;

	// 저장된 정보를 출력하기위한 라벨과 정수형 변수 선언
	private JLabel namelbl, nameInputtedlbl;
	private JLabel yearlbl, yearInputtedlbl;
	private JLabel monthlbl, monthInputtedlbl;
	private JLabel daylbl, dayInputtedlbl;
	private JLabel tablelbl, tableInputtedlbl;
	private JLabel menulbl, menuInputtedlbl;
	private int nYear, nMonth, nDay;
	private int nTable, nMenu;

	// *11.23 수정 - 메뉴의 이름과 가격을 입력 받기 위한 라벨과 텍스트 필드 선언
	private JLabel menuNameMainlbl, menuPricelbl;
	private JTextField menuNameInput, menuPriceInput;
	private int menuNameInputCnt = 0, menuPriceInputCnt = 0;

	// 12.02 수정 - 당일 판매할 메뉴의 개수 추가
	private JLabel menuCntlbl;
	private JTextField menuCntInput;
	private int menuCntInputCnt = 0;

	// 입력받아 저장된 메뉴의 이름과 가격을 저장하기 위한 라벨과 정수형 변수 선언
	private JLabel menuInputtedName, menuInputtedPrice;
	private JLabel[] menuNameArray, menuPricelblArray;
	private int[] menuPriceArray;

	// *12.02 수정 당일 판매할 메뉴의 개수 추가
	private JLabel menuInputtedCnt;
	private JLabel[] menuCntlblArray;
	private int[] menuCntArray;

	// 모든입력이 정상적이면 다음패널로 넘어가기위한 완료패널 선언
	private JPanel completePanel;
	private JButton completeBtn;

	// *11.25 수정 모든입력이 완료되면 저장된 날짜를 출력하는 패널과 라벨 선언
	private JPanel dateShowPanel;
	private JLabel yearMainlbl, monthMainlbl, dayMainlbl;

	// 이벤트 핸들러 객체 선언
	private InputCompleteListener ICL;
	private menuInputListener InputSum;
	private MenuButtonListener mouseevent;

	// 사용장 정의 패널의 객체 선언
	// NEXT버튼이 클릭된 후 다음에 표시할 패널
	private TableLayoutPanel TLP;
	// 입력된 연월일을 올바른 값인지 검사 후 저장하기 위함
	private InputDataCheck IDC;
	private SalesPrintPanel SPP;

	// 사용자 정의 패널의 내부
	public DefaultSettingPanel() {
		// 이전에 생성된 패널 맞게 넣기 위한 설정
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(null);

		// 이벤트 핸들러 객체 생성
		ICL = new InputCompleteListener();
		InputSum = new menuInputListener();
		mouseevent = new MenuButtonListener();

		// InputDataCheck 클래스의 객체 생성
		TLP = new TableLayoutPanel();
		IDC = new InputDataCheck();
		SPP = new SalesPrintPanel();

		// 사용할 폰트를 객체로 선언 후 생성
		Font Vdn30 = new Font("Verdana", Font.BOLD, 40);
		Font Vdn24 = new Font("Verdana", Font.BOLD, 24);
		Font Vdn15 = new Font("Verdana", Font.BOLD, 15);
		Font Vdn12 = new Font("Verdana", Font.BOLD, 12);

		// 패널의 크기에 맞게 해당 클래스의 메인 패널을 생성
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 800);
		mainPanel.setVisible(true);
		// mainPanel.setBackground(Color.white);
		mainPanel.setLayout(null);
		this.add(mainPanel);

		// // 다음에 표시될 패널을 생성 후 메인 패널에 추가
		TLP.setLayout(null);
		TLP.setVisible(false);
		this.add(TLP);

		// 사용자에게 전달할 메세지를 출력하기 위한 패널 생성
		MessagePanel = new JPanel();
		MessagePanel.setBounds(300, 20, 600, 50);
		MessagePanel.setBackground(Color.black);
		MessagePanel.setLayout(null);
		mainPanel.add(MessagePanel);

		// 기본 메세지를 출력하기 위한 라벨 생성
		defaultMessagelbl = new JLabel("Please Enter Information");
		defaultMessagelbl.setBounds(10, 5, 580, 40);
		defaultMessagelbl.setFont(Vdn24);
		defaultMessagelbl.setForeground(Color.white);
		defaultMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		defaultMessagelbl.setVisible(true);
		MessagePanel.add(defaultMessagelbl);

		// 사용자 입력시 발생한 에러를 출력하기 위한 라벨 생성
		ErrorMessagelbl = new JLabel("");
		ErrorMessagelbl.setBounds(10, 5, 580, 40);
		ErrorMessagelbl.setFont(Vdn24);
		ErrorMessagelbl.setForeground(Color.red);
		ErrorMessagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorMessagelbl.setVisible(false);
		MessagePanel.add(ErrorMessagelbl);

		// 정보를 입력 받고 저장하기 위한 패널 생성
		mainInfoPanel = new JPanel();
		mainInfoPanel.setBounds(25, 100, 1150, 650);
		mainInfoPanel.setBackground(Color.white);
		mainInfoPanel.setLayout(null);
		mainPanel.add(mainInfoPanel);

		// 정보를 입력받기 위한 패널 생성
		infoInputPanel = new JPanel();
		infoInputPanel.setBounds(10, 10, 1130, 140);
		infoInputPanel.setBackground(Color.white);
		infoInputPanel.setBorder(BorderFactory.createTitledBorder("INPUT INFO"));
		infoInputPanel.setLayout(null);
		mainInfoPanel.add(infoInputPanel);

		// 입력받은 정보를 저장하기 위한 패널 생성
		savedInfoPanel = new JPanel();
		savedInfoPanel.setBounds(10, 150, 1130, 490);
		savedInfoPanel.setBackground(Color.white);
		savedInfoPanel.setBorder(BorderFactory.createTitledBorder("SAVED INFO"));
		savedInfoPanel.setLayout(null);
		mainInfoPanel.add(savedInfoPanel);

		// 이름, 날짜, 테이블과 메뉴의 개수를 저장하기 위한 패널 생성
		savedLeftPanel = new JPanel();
		savedLeftPanel.setBounds(10, 30, 550, 450);
		savedLeftPanel.setBackground(Color.white);
		savedLeftPanel.setBorder(BorderFactory.createTitledBorder("INITIAL INFO"));
		savedLeftPanel.setLayout(new GridLayout(6, 2));
		savedInfoPanel.add(savedLeftPanel);

		// 입력된 메뉴의 개수만큼 저장하기위한 패널 생성
		savedRightPanel = new JPanel();
		savedRightPanel.setBounds(570, 30, 550, 450);
		savedRightPanel.setBackground(Color.white);
		savedRightPanel.setBorder(BorderFactory.createTitledBorder("MENU INFO"));
		savedRightPanel.setLayout(new GridLayout(6, 3));
		savedInfoPanel.add(savedRightPanel);

		// 식당이름을 입력하기 위한 라벨 생성
		nameShowlbl = new JLabel("Restaurant Name: ");
		nameShowlbl.setBounds(0, 0, 565, 140);
		nameShowlbl.setForeground(Color.black);
		nameShowlbl.setFont(Vdn30);
		nameShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameShowlbl.setVisible(true);
		infoInputPanel.add(nameShowlbl);

		// 식당이름을 입력하기 위한 텍스트 필드 생성
		nameInput = new JTextField();
		nameInput.setBounds(565, 15, 560, 120);
		nameInput.setFont(Vdn30);
		nameInput.setBorder(BorderFactory.createLineBorder(Color.white));
		nameInput.setHorizontalAlignment(SwingConstants.CENTER);
		nameInput.addActionListener(ICL);
		nameInput.setEnabled(true);
		nameInput.setVisible(true);
		infoInputPanel.add(nameInput);

		// 날짜 중 연을 입력하기 위한 라벨 생성
		yearShowlbl = new JLabel("Year: ");
		yearShowlbl.setBounds(0, 0, 565, 140);
		yearShowlbl.setForeground(Color.black);
		yearShowlbl.setFont(Vdn30);
		yearShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		yearShowlbl.setVisible(false);
		infoInputPanel.add(yearShowlbl);

		// 날짜 중 연을 입력받기 위한 텍스트 필드 생성
		yearInput = new JTextField();
		yearInput.setBounds(565, 15, 560, 120);
		yearInput.setFont(Vdn30);
		yearInput.setBorder(BorderFactory.createLineBorder(Color.white));
		yearInput.setHorizontalAlignment(SwingConstants.CENTER);
		yearInput.addActionListener(ICL);
		yearInput.setEnabled(false);
		yearInput.setVisible(false);
		infoInputPanel.add(yearInput);

		// 날짜 중 월을 입력하기 위한 라벨 생성
		monthShowlbl = new JLabel("Month: ");
		monthShowlbl.setBounds(0, 0, 565, 140);
		monthShowlbl.setForeground(Color.black);
		monthShowlbl.setFont(Vdn30);
		monthShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		monthShowlbl.setVisible(false);
		infoInputPanel.add(monthShowlbl);

		// 날짜 중 월을 입력받기 위한 텍스트 필드 생성
		monthInput = new JTextField();
		monthInput.setBounds(565, 15, 560, 120);
		monthInput.setFont(Vdn30);
		monthInput.setBorder(BorderFactory.createLineBorder(Color.white));
		monthInput.setHorizontalAlignment(SwingConstants.CENTER);
		monthInput.addActionListener(ICL);
		monthInput.setEnabled(false);
		monthInput.setVisible(false);
		infoInputPanel.add(monthInput);

		// 날짜 중 일을 입력하기 위한 라벨 생성
		dayShowlbl = new JLabel("Day: ");
		dayShowlbl.setBounds(0, 0, 565, 140);
		dayShowlbl.setForeground(Color.black);
		dayShowlbl.setFont(Vdn30);
		dayShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dayShowlbl.setVisible(false);
		infoInputPanel.add(dayShowlbl);

		// 날짜 중 일을 입력받기 위한 텍스트 필드 생성
		dayInput = new JTextField();
		dayInput.setBounds(565, 15, 560, 120);
		dayInput.setFont(Vdn30);
		dayInput.setBorder(BorderFactory.createLineBorder(Color.white));
		dayInput.setHorizontalAlignment(SwingConstants.CENTER);
		dayInput.addActionListener(ICL);
		dayInput.setEnabled(false);
		dayInput.setVisible(false);
		infoInputPanel.add(dayInput);

		// 테이블 개수를 입력하기 위한 라벨 생성
		tableShowlbl = new JLabel("Table: ");
		tableShowlbl.setBounds(0, 0, 565, 140);
		tableShowlbl.setForeground(Color.black);
		tableShowlbl.setFont(Vdn30);
		tableShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		tableShowlbl.setVisible(false);
		infoInputPanel.add(tableShowlbl);

		// 테이블 개수를 입력받기 위한 텍스트 필드 생성
		tableInput = new JTextField();
		tableInput.setBounds(565, 15, 560, 120);
		tableInput.setFont(Vdn30);
		tableInput.setBorder(BorderFactory.createLineBorder(Color.white));
		tableInput.setHorizontalAlignment(SwingConstants.CENTER);
		tableInput.addActionListener(ICL);
		tableInput.setVisible(false);
		tableInput.setVisible(false);
		infoInputPanel.add(tableInput);

		// 메뉴 개수를 입력하기 위한 라벨 생성
		menuShowlbl = new JLabel("Menu: ");
		menuShowlbl.setBounds(0, 0, 565, 140);
		menuShowlbl.setForeground(Color.black);
		menuShowlbl.setFont(Vdn30);
		menuShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuShowlbl.setVisible(false);
		infoInputPanel.add(menuShowlbl);

		// 메뉴 개수를 입력받기 위한 텍스트 필드 생성
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
		// 입력된 정보 중 왼쪽 패널에 저장할 정보
		// 입력된 이름을 표시하기위한 라벨 생성
		namelbl = new JLabel("Restaurant Name: ");
		namelbl.setForeground(Color.black);
		namelbl.setFont(Vdn24);
		namelbl.setHorizontalAlignment(SwingConstants.LEFT);
		namelbl.setVisible(false);
		savedLeftPanel.add(namelbl);

		// 입력된 이름을 출력하기 위한 라벨 생성
		nameInputtedlbl = new JLabel();
		nameInputtedlbl.setForeground(Color.black);
		nameInputtedlbl.setFont(Vdn24);
		nameInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		nameInputtedlbl.setVisible(false);
		savedLeftPanel.add(nameInputtedlbl);

		// 입력된 날짜 중 연을 표시하기 위한 라벨 생성
		yearlbl = new JLabel("Year: ");
		yearlbl.setForeground(Color.black);
		yearlbl.setFont(Vdn24);
		yearlbl.setHorizontalAlignment(SwingConstants.LEFT);
		yearlbl.setVisible(false);
		savedLeftPanel.add(yearlbl);

		// 입력된 날짜 중 연을 출력하기 위한 라벨 생성
		yearInputtedlbl = new JLabel();
		yearInputtedlbl.setForeground(Color.black);
		yearInputtedlbl.setFont(Vdn24);
		yearInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		yearInputtedlbl.setVisible(false);
		savedLeftPanel.add(yearInputtedlbl);

		// 입력된 날짜 중 월을 표시하기 위한 라벨 생성
		monthlbl = new JLabel("Month: ");
		monthlbl.setForeground(Color.black);
		monthlbl.setFont(Vdn24);
		monthlbl.setHorizontalAlignment(SwingConstants.LEFT);
		monthlbl.setVisible(false);
		savedLeftPanel.add(monthlbl);

		// 입력된 날짜 중 월을 출력하기 위한 라벨 생성
		monthInputtedlbl = new JLabel();
		monthInputtedlbl.setForeground(Color.black);
		monthInputtedlbl.setFont(Vdn24);
		monthInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		monthInputtedlbl.setVisible(false);
		savedLeftPanel.add(monthInputtedlbl);

		// 입력된 날짜 중 일을 표시하기 위한 라벨 생성
		daylbl = new JLabel("Day: ");
		daylbl.setForeground(Color.black);
		daylbl.setFont(Vdn24);
		daylbl.setHorizontalAlignment(SwingConstants.LEFT);
		daylbl.setVisible(false);
		savedLeftPanel.add(daylbl);

		// 입력된 날짜 중 일을 출력하기 위한 라벨 생성
		dayInputtedlbl = new JLabel();
		dayInputtedlbl.setForeground(Color.black);
		dayInputtedlbl.setFont(Vdn24);
		dayInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		dayInputtedlbl.setVisible(false);
		savedLeftPanel.add(dayInputtedlbl);

		// 입력된 테이블 개수를 표시하기 위한 라벨 생성
		tablelbl = new JLabel("Table: ");
		tablelbl.setForeground(Color.black);
		tablelbl.setFont(Vdn24);
		tablelbl.setHorizontalAlignment(SwingConstants.LEFT);
		tablelbl.setVisible(false);
		savedLeftPanel.add(tablelbl);

		// 입력된 테이블 개수를 출력하기 위한 라벨 생성
		tableInputtedlbl = new JLabel();
		tableInputtedlbl.setForeground(Color.black);
		tableInputtedlbl.setFont(Vdn24);
		tableInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		tableInputtedlbl.setVisible(false);
		savedLeftPanel.add(tableInputtedlbl);

		// 입력된 메뉴 개수를 표시하기 위한 라벨 생성
		menulbl = new JLabel("Menu: ");
		menulbl.setForeground(Color.black);
		menulbl.setFont(Vdn24);
		menulbl.setHorizontalAlignment(SwingConstants.LEFT);
		menulbl.setVisible(false);
		savedLeftPanel.add(menulbl);

		// 입력된 메뉴 개수를 출력하기 위한 라벨 생성
		menuInputtedlbl = new JLabel();
		menuInputtedlbl.setForeground(Color.black);
		menuInputtedlbl.setFont(Vdn24);
		menuInputtedlbl.setHorizontalAlignment(SwingConstants.LEFT);
		menuInputtedlbl.setVisible(false);
		savedLeftPanel.add(menuInputtedlbl);
		// -----------------------------------------------------------------------------
		// 메뉴이름을 입력하기 위한 라벨과 텍스트필드 생성
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
		menuNameInput.setEnabled(false); // ★버튼 활성화
		menuNameInput.setVisible(false);
		infoInputPanel.add(menuNameInput);

		// 메뉴 가격을 입력하기 위한 라벨과 텍스트필드 생성
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
		menuPriceInput.setEnabled(false); // ★버튼 활성화
		menuPriceInput.setVisible(false);
		infoInputPanel.add(menuPriceInput);

		// 메뉴 가격을 입력하기 위한 라벨과 텍스트필드 생성
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
		menuCntInput.setEnabled(false); // ★버튼 활성화
		menuCntInput.setVisible(false);
		infoInputPanel.add(menuCntInput);

		// 입력받아 저장된 메뉴의 이름과 가격을 출력하기 위한 라벨 생성
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

		// 12.02 수정 - 당일 판매할 메뉴의 개수 추가
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

		// 입력 완료시 다음 패널로 넘어가기 위한 패널과 버튼 생성
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

		// 입력받아 저장된 날짜를 보여주는 패널과 라벨 생성
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

	// 사용자 정의 패널인 TableLayoutPanel에 값을 쓰기위한 생성자
	public DefaultSettingPanel(TableLayoutPanel p) {
		TLP = p;
	}

	public DefaultSettingPanel(SalesPrintPanel p) {
		SPP = p;
	}

	// 정보를 입력받아 저장하기 위한 이벤트핸들러 클래스
	private class InputCompleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// 이벤트가 발생한 컴포넌트가 저장
			if (obj == nameInput) {
				// 매장 이름이 입력되었다면 해당 라벨과 텍스트필드를 비활성화시키고 다음 값인 날짜 중 연의 라벨과 텍스트 필드를 활성화
				nameShowlbl.setVisible(false);
				nameInput.setEnabled(false);
				nameInput.setVisible(false);
				yearShowlbl.setVisible(true);
				yearInput.setEnabled(true);
				yearInput.setVisible(true);
				nameInputtedlbl.setText(nameInput.getText());
				namelbl.setVisible(true);
				nameInputtedlbl.setVisible(true);
				// TableLayoutPanel 클래스의 메소드로 입력된 이름을 저장
				TLP.setName(nameInput.getText());
			} else if (obj == yearInput) {
				IDC.setYear(Integer.parseInt(yearInput.getText()));
				// 텍스트필드에 입력된 문자열을 숫자로 변환해 InputDataCheck 클래스에 저장
				yearShowlbl.setVisible(false);
				yearInput.setEnabled(false);
				yearInput.setVisible(false);
				nYear = IDC.getYear();
				// TableLayoutPanel 클래스의 메소드로 입력된 날짜 중 연을 저장
				TLP.setYear(nYear);
				SPP.setYear(nYear);
				yearMainlbl.setText("" + nYear);
				if (nYear == 0) {
					// 입력된 값이 잘못된 값이라 0으로 재설정되었다면
					yearInput.setText("");
					// 텍스트필드를 초기화하고 다시입력 받도록한다.
					yearShowlbl.setVisible(true);
					yearInput.setEnabled(true);
					yearInput.setVisible(true);
					// 에러 메세지를 사용자에게 출력한다.
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
				// 텍스트필드에 입력된 문자열을 숫자로 변환해 InputDataCheck 클래스에 저장
				IDC.setMonth(Integer.parseInt(monthInput.getText()));
				monthShowlbl.setVisible(false);
				monthInput.setVisible(false);
				monthInput.setEnabled(false);
				nMonth = IDC.getMonth();
				// TableLayoutPanel 클래스의 메소드로 입력된 날짜 중 월을 저장
				TLP.setMonth(nMonth);
				SPP.setMonth(nMonth);
				monthMainlbl.setText("" + nMonth);
				if (nMonth == 0) {
					// 입력된 값이 잘못된 값이라 0으로 재설정되었다면
					monthInput.setText("");
					// 텍스트필드를 초기화하고 다시입력 받도록한다.
					monthShowlbl.setVisible(true);
					monthInput.setVisible(true);
					monthInput.setEnabled(true);
					// 에러메세지를 출력
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
				// 텍스트필드에 입력된 문자열을 숫자로 변환해 InputDataCheck 클래스에 저장
				dayShowlbl.setVisible(false);
				dayInput.setVisible(false);
				dayInput.setEnabled(false);
				nDay = IDC.getDay();
				// TableLayoutPanel 클래스의 메소드를 이용해 날짜 중 일을 저장
				TLP.setDay(nDay);
				SPP.setDay(nDay);
				dayMainlbl.setText("" + nDay);
				if (nDay == 0) {
					// 입력된 값이 잘못된 값이라 0으로 재설정되었다면
					dayInput.setText("");
					// 텍스트필드를 초기화하고 다시입력 받도록한다.
					dayShowlbl.setVisible(true);
					dayInput.setVisible(true);
					dayInput.setEnabled(true);
					// 에러메세지르 출력
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
				// 텍스트필드에 입력된 문자열을 숫자로 변환해 InputDataCheck 클래스에 저장
				tableShowlbl.setVisible(false);
				tableInput.setVisible(false);
				tableInput.setEnabled(false);
				nTable = IDC.getTable();
				// TLP클래스의 메소드로 값을 저장
				TLP.setTable(nTable);
				if (nTable == 0) {
					// 입력된 값이 잘못된 값이라 0으로 재설정되었다면
					tableInput.setText("");
					// 텍스트필드를 초기화하고 다시입력 받도록한다.
					tableShowlbl.setVisible(true);
					tableInput.setVisible(true);
					tableInput.setEnabled(true);
					// 테이블 개수는 10이다.
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
				// 텍스트필드에 입력된 문자열을 숫자로 변환해 InputDataCheck 클래스에 저장
				menuShowlbl.setVisible(false);
				menuInput.setVisible(false);
				menuInput.setEnabled(false);
				nMenu = IDC.getMenu();
				// TLP클래스의 메소드를 이용해 메뉴 개수를 저장
				TLP.setMenu(nMenu);
				if (nMenu == 0) {
					// 입력된 값이 잘못된 값이라 0으로 재설정되었다면
					menuInput.setText("");
					// 텍스트필드를 초기화하고 다시입력 받도록한다.
					menuShowlbl.setVisible(true);
					menuInput.setVisible(true);
					menuInput.setEnabled(true);
					// 메뉴는 5개
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

	// 메뉴의 이름과 가격을 입력받아 저장하기 위한 이벤트핸들러 클래스
	private class menuInputListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// 이벤트가 발생한 컴포넌트가 저장
			// 메뉴 이름 입력시
			if (obj == menuNameInput) {
				// 해당 메뉴에 이름을 저장하고 출력
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
					menuNameInput.setEnabled(false); // 메뉴 다섯번 입력하면 텍스트필드 비활성화
				}
				menuNameInput.setText(""); // 텍스트필드 초기화
			}
			// 메뉴 가격 입력시
			else if (obj == menuPriceInput) {
				// 텍스트필드의 값을 IDC의 메소드로 저장시킴
				IDC.setMenuPrice(Integer.parseInt(menuPriceInput.getText()));
				// 해당메뉴에 입력된 가격을 저장하고 출력
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
				menuPriceInput.setText(""); // 텍스트필드 초기화
				// 입력이 잘못되었다면 재입력 하도록 설정
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
			// 메뉴 개수 입력시
			else if (obj == menuCntInput) {
				// 텍스트필드의 값을 IDC의 메소드로 저장시킴
				IDC.setMenuCnt(Integer.parseInt(menuCntInput.getText()));
				// 해당 메뉴에 입력된 각 메뉴의 금일 판매개수를 저장
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
					// 완료패널을 보이게 함
					completePanel.setVisible(true);
					defaultMessagelbl.setText("Setting Complete. Click NEXT Button!");
					defaultMessagelbl.setFont(new Font("Verdana", Font.BOLD, 20));
					dateShowPanel.setVisible(true);
				}
				menuCntInput.setText(""); // 텍스트필드 초기화
				// 입력이 잘못되었다면 재입력 하도록 설정
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
}
