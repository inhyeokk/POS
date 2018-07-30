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

// 처음화면을 표시하는 패널
public class InitialPanel extends JPanel {
	// *11.14 수정 main 클래스의 프레임에 추가하기 위한 메인 패널 선언
	private JPanel mainPanel;

	// 상단에 메세지를 출력하기위한 패널과 다음 동작을 표시하기위한 메세지 패널 선언
	private JPanel mainMessagePanel, selectMessagePanel;
	// 상단에 메세지를 출력하기 위한 라벨선언
	private JLabel mainMessagelbl;
	// 다음 동작을 설정하기 위한 버튼 선언
	private JButton startProgramBtn, explainProgramBtn, exitBtn;

	// *11.24 수정 배경이미지를 넣기 위한 라벨 선언
	private JLabel imagePrintlbl;

	// 이벤트 핸들러 객체 선언
	private selectMessageListener selectEvent;
	private MenuButtonListener mouseEvent;

	// 사용자 정의 패널 객체 선언
	private DefaultSettingPanel DSP;
	private TableLayoutPanel TLP;

	// 사용자 정의 패널의 내부
	public InitialPanel() {
		// 메인패널의 크기와 배경색 설정
		this.setPreferredSize(new Dimension(1200, 800));
		this.setBackground(Color.white);
		this.setLayout(null);

		// 이벤트 핸들러 객체 생성
		selectEvent = new selectMessageListener();
		mouseEvent = new MenuButtonListener();

		// 배경이미지를 생성 후 불러옴
		ImageIcon img = new ImageIcon("image.jpg");

		// 사용할 폰트를 객체로 선언 후 생성
		Font Vdn60 = new Font("Verdana", Font.BOLD, 60);
		Font Vdn20 = new Font("Verdana", Font.BOLD, 20);

		// 메인 프레임에 추가될 메인 패널 생성 및 설정
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 800);
		mainPanel.setBackground(Color.white);
		mainPanel.setOpaque(false);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		this.add(mainPanel);

		// 다음에 표시될 패널을 생성 후 메인 패널에 추가
		DSP = new DefaultSettingPanel();
		DSP.setVisible(false);
		this.add(DSP);

		// 값 확인을 위한 테스트
		TLP = new TableLayoutPanel();
		TLP.setVisible(false);
		// this.add(TLP);

		// 사용자에게 전달할 메세지를 출력하기 위한 패널 생성
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

		// 프로그램의 실행을위한 버튼을 담는 패널생성
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

		// 배경이미지를 생성
		imagePrintlbl = new JLabel(img);
		imagePrintlbl.setBounds(0, 0, 1200, 800);
		mainPanel.add(imagePrintlbl);
	}

	private class selectMessageListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();// 이벤트가 발생한 컴포넌트가 저장
			int result;
			if (obj == startProgramBtn) {
				mainPanel.setVisible(false);
				DSP.setVisible(true);
				// TLP.setVisible(true);
			} else if (obj == explainProgramBtn) {
				// 사용자에게 프로그램 사용 이해를 돕기위해 새로운 프레임을 생성해 프로그램과 같이 사용할 수 있도록 함
				JFrame explainFrame = new JFrame("도움말");
				explainFrame.setResizable(false);

				ExplainPanel exp = new ExplainPanel();

				explainFrame.getContentPane().add(exp);
				explainFrame.pack();
				explainFrame.setVisible(true);
			} else if (obj == exitBtn) {
				// 종료하기 전에 사용자에게 한번 더 물어봄으로써 잘못 눌렀을 경우를 방지
				result = JOptionPane.showConfirmDialog(mainPanel, "프로그램을 종료하시겠습니까?"); // 안내창
				if (result == JOptionPane.YES_OPTION) { // YES를 눌렀을 때
					System.exit(0);
				}
			}
		} // actionPerformed()
	} // selectMessageListener class

	// 버튼에 마우스를 적용했을때 버튼 색이 변경되는 마우스 리스너
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
