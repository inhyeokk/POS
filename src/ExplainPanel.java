
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExplainPanel extends JPanel {
	private JPanel explainmainpanel; // 초기 explain화면을 보여주는 메인 페널 선언
	private JPanel explainpanel, explainpanel2, explainpanel3, explainpanel4, explainpanel5, explainpanel6,
			explainpanel7, explainpanel8, explainpanel9, explainpanel10, explainpanel11; // 설명이 담긴 각각의 패널들을 선언
	private JButton nextbtn, previousbtn; // 다음화면과 이전화면으로 돌가가게 하기위해 버튼 두개 선언
	private JButton init, check1, check2, table; // 각각의 동작을 나타낸 버튼 4개 선언
	private int count = 0; // 각 패널을 이동하게 하기위한 조건으로 사용될 int 형 변수 선언

	private selectpageListener pagemove; // 버튼을 위한 actionlistener 선언

	private MenuButtonListener mouseevent; // 버튼의 변경을 위한 mouselistener 선언

	public ExplainPanel() { // explain패널 의 내부정의
		this.setPreferredSize(new Dimension(800, 640));
		this.setBackground(Color.white);
		this.setLayout(null); // 크기와 색을 설정한다

		ImageIcon main = new ImageIcon("MAIN.PNG"); // 각각의 동작의 설명이 담긴 image를 선언한다
		ImageIcon icon1 = new ImageIcon("first2.PNG");
		ImageIcon icon2 = new ImageIcon("INFO1.PNG");
		ImageIcon icon3 = new ImageIcon("INFO2.PNG");
		ImageIcon icon4 = new ImageIcon("INFO3.PNG");
		ImageIcon icon5 = new ImageIcon("INFO4.PNG");
		ImageIcon icon6 = new ImageIcon("SETTING 1.PNG");
		ImageIcon icon7 = new ImageIcon("SETTING 2.PNG");
		ImageIcon icon8 = new ImageIcon("SETTING 3.PNG");
		ImageIcon icon9 = new ImageIcon("SETTING 4.PNG");
		ImageIcon icon10 = new ImageIcon("SETTING 5.PNG");
		ImageIcon icon11 = new ImageIcon("SALES.PNG");

		JPanel explainmainpanel = new JPanel(); // explain의 메인 패널을 생성한다.

		explainpanel = new JPanel(); // 각각의 동작에 설명이 담긴 패널들을 생성한다.
		explainpanel2 = new JPanel();
		explainpanel3 = new JPanel();
		explainpanel4 = new JPanel();
		explainpanel5 = new JPanel();
		explainpanel6 = new JPanel();
		explainpanel7 = new JPanel();
		explainpanel8 = new JPanel();
		explainpanel9 = new JPanel();
		explainpanel10 = new JPanel();
		explainpanel11 = new JPanel();

		// label 생성
		JLabel mainlbl = new JLabel("", main, SwingConstants.CENTER); // 메인라벨을 설정한다.
		mainlbl.setBounds(0, 0, 800, 640);
		mainlbl.setForeground(Color.black);
		mainlbl.setVisible(true);

		JLabel first = new JLabel("", icon1, SwingConstants.CENTER); // 각각의 동작의 image를 불러오는 라벨을 선언한다.
		first.setBounds(0, 0, 800, 640);

		first.setVisible(true);

		JLabel second = new JLabel("", icon2, SwingConstants.CENTER);
		second.setBounds(0, 0, 800, 640);
		second.setVisible(true);

		JLabel third = new JLabel("", icon3, SwingConstants.CENTER);
		third.setBounds(0, 0, 800, 640);
		third.setVisible(true);

		JLabel four = new JLabel("", icon4, SwingConstants.CENTER);

		four.setBounds(0, 0, 800, 640);
		four.setVisible(true);

		JLabel five = new JLabel("", icon5, SwingConstants.CENTER);

		five.setBounds(0, 0, 800, 640);
		five.setVisible(true);

		JLabel six = new JLabel("", icon6, SwingConstants.CENTER);

		six.setBounds(0, 0, 800, 640);
		six.setVisible(true);

		explainmainpanel.setBounds(0, 0, 800, 640);

		JLabel seven = new JLabel("", icon7, SwingConstants.CENTER);

		seven.setBounds(0, 0, 800, 640);
		seven.setVisible(true);

		JLabel eight = new JLabel("", icon8, SwingConstants.CENTER);

		eight.setBounds(0, 0, 800, 640);
		eight.setVisible(true);

		JLabel nine = new JLabel("", icon9, SwingConstants.CENTER);

		nine.setBounds(0, 0, 800, 640);
		nine.setVisible(true);

		JLabel ten = new JLabel("", icon10, SwingConstants.CENTER);

		ten.setBounds(0, 0, 800, 640);
		ten.setVisible(true);

		JLabel eleven = new JLabel("", icon11, SwingConstants.CENTER);

		eleven.setBounds(0, 0, 800, 640);
		eleven.setVisible(true);

		explainmainpanel.setBounds(0, 0, 800, 640); // explainmainpanel 의 크기와 색을 설정후 set true로 한다.

		explainmainpanel.setPreferredSize(new Dimension(800, 640));

		explainmainpanel.setBackground(Color.white);

		explainmainpanel.setLayout(null);
		explainmainpanel.setVisible(true);

		// 설명이 담긴 패널들

		explainpanel.setBounds(0, 0, 800, 640); // 설명이 담긴 패널들의 크기와 색을 설정하고 set false로 한다.
		explainpanel.setPreferredSize(new Dimension(800, 640));
		explainpanel.setBackground(Color.white);
		explainpanel.setLayout(null);
		explainpanel.setVisible(false);

		explainpanel2.setBounds(0, 0, 800, 640);
		explainpanel2.setPreferredSize(new Dimension(800, 640));
		explainpanel2.setBackground(Color.white);
		explainpanel2.setLayout(null);
		explainpanel2.setVisible(false);

		explainpanel3.setBounds(0, 0, 800, 640);
		explainpanel3.setPreferredSize(new Dimension(800, 640));
		explainpanel3.setBackground(Color.white);
		explainpanel3.setLayout(null);
		explainpanel3.setVisible(false);

		explainpanel4.setBounds(0, 0, 800, 640);
		explainpanel4.setPreferredSize(new Dimension(800, 640));
		explainpanel4.setBackground(Color.white);
		explainpanel4.setLayout(null);
		explainpanel4.setVisible(false);

		explainpanel5.setBounds(0, 0, 800, 640);
		explainpanel5.setPreferredSize(new Dimension(800, 640));
		explainpanel5.setBackground(Color.white);
		explainpanel5.setLayout(null);
		explainpanel5.setVisible(false);

		explainpanel6.setBounds(0, 0, 800, 640);
		explainpanel6.setPreferredSize(new Dimension(800, 640));
		explainpanel6.setBackground(Color.white);
		explainpanel6.setLayout(null);
		explainpanel6.setVisible(false);

		explainpanel7.setBounds(0, 0, 800, 640);
		explainpanel7.setPreferredSize(new Dimension(800, 640));
		explainpanel7.setBackground(Color.white);
		explainpanel7.setLayout(null);
		explainpanel7.setVisible(false);

		explainpanel8.setBounds(0, 0, 800, 640);
		explainpanel8.setPreferredSize(new Dimension(800, 640));
		explainpanel8.setBackground(Color.white);
		explainpanel8.setLayout(null);
		explainpanel8.setVisible(false);

		explainpanel9.setBounds(0, 0, 800, 640);
		explainpanel9.setPreferredSize(new Dimension(800, 640));
		explainpanel9.setBackground(Color.white);
		explainpanel9.setLayout(null);
		explainpanel9.setVisible(false);

		explainpanel10.setBounds(0, 0, 800, 640);
		explainpanel10.setPreferredSize(new Dimension(800, 640));
		explainpanel10.setBackground(Color.white);
		explainpanel10.setLayout(null);
		explainpanel10.setVisible(false);

		explainpanel11.setBounds(0, 0, 800, 640);
		explainpanel11.setPreferredSize(new Dimension(800, 640));
		explainpanel11.setBackground(Color.white);
		explainpanel11.setLayout(null);
		explainpanel11.setVisible(false);

		// event 선언
		pagemove = new selectpageListener(); // event를 선언한다
		mouseevent = new MenuButtonListener();

		Font fnt = new Font("Verdana", Font.BOLD, 15); // 폰트를 선언한다.

		// 초기화면 목록

		// 버튼 생성
		init = new JButton("INIT PAGE"); // 처음 화면을 설명하는 버튼을 생성한다. 그리고 event 헨들링을 추가하낟.
		init.setBounds(220, 300, 160, 30);
		init.addActionListener(pagemove);
		init.addMouseListener(mouseevent);
		init.setFont(fnt); // 폰트도 추가한다.
		init.setBackground(Color.LIGHT_GRAY);
		explainmainpanel.add(init); // explainmainpanel 에 init 버튼을 추가시킨다.

		check1 = new JButton("INFORMATION"); // 식당의 정보를 입력하는 동작의 설명을 보여주는 버튼을 생성한다.
		check1.setBounds(420, 300, 160, 30); // 크기와 위치선언
		check1.addActionListener(pagemove); // 이벤트 핸들링을 추가
		check1.addMouseListener(mouseevent);
		check1.setFont(fnt);
		check1.setBackground(Color.LIGHT_GRAY); // 폰트와 버튼 색을 바꾼다.
		explainmainpanel.add(check1); // explainmainpanel 에 버튼을 추가

		check2 = new JButton("SETTING"); // 테이블 세팅의 설명을 보여주는 버튼을 추가
		check2.setBounds(220, 370, 160, 30); // 크기와 위치 선언
		check2.addActionListener(pagemove);
		check2.addMouseListener(mouseevent); // 이벤트 핸들링 추가
		check2.setFont(fnt); // 폰트와 색을 바꾼다.
		check2.setBackground(Color.LIGHT_GRAY);
		explainmainpanel.add(check2); // explainmainpanel 에 버튼을 추가

		table = new JButton("SALES"); // 가격을 정산하는버튼을 추가
		table.setBounds(420, 370, 160, 30); // 크기와 위치 선언
		table.addActionListener(pagemove); // 이벤트 핸들링 추가
		table.addMouseListener(mouseevent);
		table.setFont(fnt); // 폰트와 색을 바꾼다.
		table.setBackground(Color.LIGHT_GRAY);
		explainmainpanel.add(table); // explainmainpanel 에 버튼을 추가

		nextbtn = new JButton("Next"); // 다음 화면으로 넘어가는 버튼을 추가
		nextbtn.setBounds(650, 580, 120, 50);
		nextbtn.addActionListener(pagemove);
		nextbtn.addMouseListener(mouseevent);
		nextbtn.setFont(new Font("Vendana", Font.BOLD, 16)); // 이벤트 핸들링과 폰트를 바꾼다.
		nextbtn.setBackground(Color.LIGHT_GRAY);
		nextbtn.setForeground(Color.black);
		nextbtn.setVisible(false); // 조건이 주어지지 않으면 보이지 않게 한다.
		explainmainpanel.add(nextbtn); // 다음 버튼 추가

		previousbtn = new JButton("Back"); // 이전 화면으로 돌아가는 버튼을 추가
		previousbtn.setBounds(650, 580, 120, 50); // 버튼의 크기와 위치를 선언
		previousbtn.addActionListener(pagemove);
		previousbtn.addMouseListener(mouseevent);
		previousbtn.setFont(new Font("Vendana", Font.BOLD, 16)); // 이벤트 핸들링과 폰트를 추가
		previousbtn.setBackground(Color.LIGHT_GRAY);
		previousbtn.setForeground(Color.black); // 버튼의 색 변경
		previousbtn.setVisible(false); // 조건이 주어지지 않으면 보이지 않게 한다.
		explainmainpanel.add(previousbtn); // 이전 버튼 추가

		// 추가하기 add
		this.add(explainmainpanel); // 메인패널을 활성화 하기위해 추가시킨다

		explainmainpanel.add(explainpanel); // 각각의 설명이 담긴 패널들을 메인 패널에다 추가 시킨다
		explainmainpanel.add(explainpanel2);
		explainmainpanel.add(explainpanel3);
		explainmainpanel.add(explainpanel4);
		explainmainpanel.add(explainpanel5);

		explainmainpanel.add(explainpanel6);
		explainmainpanel.add(explainpanel7);
		explainmainpanel.add(explainpanel8);
		explainmainpanel.add(explainpanel9);
		explainmainpanel.add(explainpanel10);
		explainmainpanel.add(explainpanel11);

		explainpanel.add(first); // 설명이 담긴 패널에 이미지를 불러오는 라벨들을 추가 시킨다
		explainpanel2.add(second);
		explainpanel3.add(third);
		explainpanel4.add(four);
		explainpanel5.add(five);

		explainpanel6.add(six);
		explainpanel7.add(seven);
		explainpanel8.add(eight);
		explainpanel9.add(nine);
		explainpanel10.add(ten);
		explainpanel11.add(eleven);

		explainmainpanel.add(mainlbl); // 무조건 맨밑에놔야함 // 메인화면은 무조건 맨밑에다가 놓는

	}

	private class selectpageListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			Object obj = event.getSource(); // 이벤트가 발생한 컴포넌트가 저장

			if (obj == init) { // 처음 화면에 대한 설명을 불러오는 버튼을 누를때

				explainpanel.setVisible(true); // 초기 화면 설명이 담긴 패널을 활성화 시킨다

				previousbtn.setVisible(true); // 이전 버튼도 활성화 시킨다.

				init.setVisible(false); // 동작을 불러오는 버튼들은 비활성화 시킨다
				check1.setVisible(false);
				check2.setVisible(false);
				table.setVisible(false);

			} else if (obj == check1) { // 정보를 입력하는 설명을 불러오는 버튼을 누를떄

				explainpanel2.setVisible(true); // 첫번째 정보 설명 패널이 활성화되고

				nextbtn.setVisible(true); // 다음 버튼이 활성화된다
				count = count + 1; // count 에 1을 더한다

				init.setVisible(false); // 동작을 불러오는 버튼들은 비활성화 시킨다
				check1.setVisible(false);
				check2.setVisible(false);
				table.setVisible(false);

			}

			else if (obj == check2) { // 테이블 세팅에 대한 설명을 불러오는 버튼을 누를때

				explainpanel6.setVisible(true); // 첫번쨰 테이블 설명 패널이 활성화되고

				nextbtn.setVisible(true); // 다음버튼이 활성화 되며
				count = count + 10; // count 가 10이 된다

				init.setVisible(false); // 동작을 불러오는 버튼들은 비활성화 시킨다
				check1.setVisible(false);
				check2.setVisible(false);
				table.setVisible(false);

			}

			else if (obj == table) { // 가격정산을 설명하는 버튼을 누를떄

				explainpanel11.setVisible(true); // 정산 설명이 담긴 패널이 활성화되고

				previousbtn.setVisible(true); // 이전버튼 활성화

				init.setVisible(false);
				check1.setVisible(false); // 동작을 불러오는 버튼들은 비활성화 시킨다
				check2.setVisible(false);
				table.setVisible(false);

			} else if (obj == previousbtn) { // 이전버튼을 누를떄

				explainpanel.setVisible(false); // 모든 설명패널을 비활성화 시킨다
				explainpanel2.setVisible(false);
				explainpanel3.setVisible(false);
				explainpanel4.setVisible(false);
				explainpanel5.setVisible(false);

				explainpanel6.setVisible(false);
				explainpanel7.setVisible(false);
				explainpanel8.setVisible(false);
				explainpanel9.setVisible(false);
				explainpanel10.setVisible(false);
				explainpanel11.setVisible(false);

				previousbtn.setVisible(false); // 이전버튼도 비활성화 시킨다

				init.setVisible(true);
				check1.setVisible(true); // 동작을 설명하는 버튼들은 활성화 시킨다
				check2.setVisible(true);
				table.setVisible(true);
			}

			else if (obj == nextbtn && count == 1) { // 다음버튼을 누르고 count가 1일때( 정보입력을 설명하는 첫번쨰 패널일때)

				explainpanel2.setVisible(false); // 첫번쨰 정보패널을 비활성화시키고
				explainpanel3.setVisible(true); // 두번쨰 정보 설명패널을 활성화 시킨다

				count = count + 1; // count 는 2가된다

			} else if (obj == nextbtn && count == 2) { // 다음버튼을 누르고 count가 2일때( 정보입력을 설명하는 두번쨰 패널일때)

				explainpanel3.setVisible(false); // 두번재를 비활성화
				explainpanel4.setVisible(true); // 세번째를 활성화

				count = count + 1; // count 는 3

			}

			else if (obj == nextbtn && count == 3) { // 다음버튼을 누르고 count가 3일때( 정보입력을 설명하는 세번쨰 패널일때)

				explainpanel4.setVisible(false); // 세번쨰를 비활성화
				explainpanel5.setVisible(true); // 네번쨰를 활성화
				previousbtn.setVisible(true); // 이전버튼 활성화
				nextbtn.setVisible(false); // 다음버튼 비활성화
				count = 0; // count를 0으로 초기화시킨다(다시 처음화면으로 돌아가기떄문데)

			}

			else if (obj == nextbtn && count == 10) { // 다음버튼을 누르고 count가 10일때( 테이블 셋팅 을 설명하는 첫번쨰 패널일때)

				explainpanel6.setVisible(false); // 첫번쨰 비활성화
				explainpanel7.setVisible(true); // 두번쨰 활성화

				count = count + 1; // count 는 11

			} else if (obj == nextbtn && count == 11) { // 다음버튼을 누르고 count가 11일때( 테이블 셋팅 을 설명하는 두번쨰 패널일때)

				explainpanel7.setVisible(false); // 두번쨰 비활성화
				explainpanel8.setVisible(true); // 세번쨰 활성화

				count = count + 1; // count 는 12

			}

			else if (obj == nextbtn && count == 12) { // 다음버튼을 누르고 count가 12일때( 테이블 셋팅 을 설명하는 세번쨰 패널일때)

				explainpanel8.setVisible(false); // 세번쨰 비활성화
				explainpanel9.setVisible(true); // 네번쨰 활성화

				count = count + 1; // count 는 13
			} else if (obj == nextbtn && count == 13) { // 다음버튼을 누르고 count가 13일때( 테이블 셋팅 을 설명하는 네번쨰 패널일때)

				explainpanel9.setVisible(false); // 네번쨰 비활성화
				explainpanel10.setVisible(true); // 다섯번쨰 활성화
				previousbtn.setVisible(true); // 이전버튼 활성화
				nextbtn.setVisible(false); // 다음버튼 비활성화
				count = 0; // count 0으로 초기화
			}

		}
	}

	private class MenuButtonListener implements MouseListener { // 버튼의 색을 바꾸기위한 마우스 리스너 사용
		public void mouseClicked(MouseEvent event) {
		}

		public void mousePressed(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) { // 마우스가 버튼에 들어갈때
			JButton btnMenu = (JButton) event.getSource();
			btnMenu.setBackground(Color.white); // 색을 바꾼다
			btnMenu.setForeground(Color.black);

		} // mouseEntered()

		public void mouseExited(MouseEvent event) {
			JButton btnMenu = (JButton) event.getSource(); // 마우스가 버튼을 빠져나가면
			btnMenu.setBackground(Color.LIGHT_GRAY); // 버튼색이 원래대로 된다
			btnMenu.setForeground(Color.black);

		} // mouseExited()
	} // MenuButtonListener class

}
