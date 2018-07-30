
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
	private JPanel explainmainpanel; // �ʱ� explainȭ���� �����ִ� ���� ��� ����
	private JPanel explainpanel, explainpanel2, explainpanel3, explainpanel4, explainpanel5, explainpanel6,
			explainpanel7, explainpanel8, explainpanel9, explainpanel10, explainpanel11; // ������ ��� ������ �гε��� ����
	private JButton nextbtn, previousbtn; // ����ȭ��� ����ȭ������ �������� �ϱ����� ��ư �ΰ� ����
	private JButton init, check1, check2, table; // ������ ������ ��Ÿ�� ��ư 4�� ����
	private int count = 0; // �� �г��� �̵��ϰ� �ϱ����� �������� ���� int �� ���� ����

	private selectpageListener pagemove; // ��ư�� ���� actionlistener ����

	private MenuButtonListener mouseevent; // ��ư�� ������ ���� mouselistener ����

	public ExplainPanel() { // explain�г� �� ��������
		this.setPreferredSize(new Dimension(800, 640));
		this.setBackground(Color.white);
		this.setLayout(null); // ũ��� ���� �����Ѵ�

		ImageIcon main = new ImageIcon("MAIN.PNG"); // ������ ������ ������ ��� image�� �����Ѵ�
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

		JPanel explainmainpanel = new JPanel(); // explain�� ���� �г��� �����Ѵ�.

		explainpanel = new JPanel(); // ������ ���ۿ� ������ ��� �гε��� �����Ѵ�.
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

		// label ����
		JLabel mainlbl = new JLabel("", main, SwingConstants.CENTER); // ���ζ��� �����Ѵ�.
		mainlbl.setBounds(0, 0, 800, 640);
		mainlbl.setForeground(Color.black);
		mainlbl.setVisible(true);

		JLabel first = new JLabel("", icon1, SwingConstants.CENTER); // ������ ������ image�� �ҷ����� ���� �����Ѵ�.
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

		explainmainpanel.setBounds(0, 0, 800, 640); // explainmainpanel �� ũ��� ���� ������ set true�� �Ѵ�.

		explainmainpanel.setPreferredSize(new Dimension(800, 640));

		explainmainpanel.setBackground(Color.white);

		explainmainpanel.setLayout(null);
		explainmainpanel.setVisible(true);

		// ������ ��� �гε�

		explainpanel.setBounds(0, 0, 800, 640); // ������ ��� �гε��� ũ��� ���� �����ϰ� set false�� �Ѵ�.
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

		// event ����
		pagemove = new selectpageListener(); // event�� �����Ѵ�
		mouseevent = new MenuButtonListener();

		Font fnt = new Font("Verdana", Font.BOLD, 15); // ��Ʈ�� �����Ѵ�.

		// �ʱ�ȭ�� ���

		// ��ư ����
		init = new JButton("INIT PAGE"); // ó�� ȭ���� �����ϴ� ��ư�� �����Ѵ�. �׸��� event ��鸵�� �߰��ϳ�.
		init.setBounds(220, 300, 160, 30);
		init.addActionListener(pagemove);
		init.addMouseListener(mouseevent);
		init.setFont(fnt); // ��Ʈ�� �߰��Ѵ�.
		init.setBackground(Color.LIGHT_GRAY);
		explainmainpanel.add(init); // explainmainpanel �� init ��ư�� �߰���Ų��.

		check1 = new JButton("INFORMATION"); // �Ĵ��� ������ �Է��ϴ� ������ ������ �����ִ� ��ư�� �����Ѵ�.
		check1.setBounds(420, 300, 160, 30); // ũ��� ��ġ����
		check1.addActionListener(pagemove); // �̺�Ʈ �ڵ鸵�� �߰�
		check1.addMouseListener(mouseevent);
		check1.setFont(fnt);
		check1.setBackground(Color.LIGHT_GRAY); // ��Ʈ�� ��ư ���� �ٲ۴�.
		explainmainpanel.add(check1); // explainmainpanel �� ��ư�� �߰�

		check2 = new JButton("SETTING"); // ���̺� ������ ������ �����ִ� ��ư�� �߰�
		check2.setBounds(220, 370, 160, 30); // ũ��� ��ġ ����
		check2.addActionListener(pagemove);
		check2.addMouseListener(mouseevent); // �̺�Ʈ �ڵ鸵 �߰�
		check2.setFont(fnt); // ��Ʈ�� ���� �ٲ۴�.
		check2.setBackground(Color.LIGHT_GRAY);
		explainmainpanel.add(check2); // explainmainpanel �� ��ư�� �߰�

		table = new JButton("SALES"); // ������ �����ϴ¹�ư�� �߰�
		table.setBounds(420, 370, 160, 30); // ũ��� ��ġ ����
		table.addActionListener(pagemove); // �̺�Ʈ �ڵ鸵 �߰�
		table.addMouseListener(mouseevent);
		table.setFont(fnt); // ��Ʈ�� ���� �ٲ۴�.
		table.setBackground(Color.LIGHT_GRAY);
		explainmainpanel.add(table); // explainmainpanel �� ��ư�� �߰�

		nextbtn = new JButton("Next"); // ���� ȭ������ �Ѿ�� ��ư�� �߰�
		nextbtn.setBounds(650, 580, 120, 50);
		nextbtn.addActionListener(pagemove);
		nextbtn.addMouseListener(mouseevent);
		nextbtn.setFont(new Font("Vendana", Font.BOLD, 16)); // �̺�Ʈ �ڵ鸵�� ��Ʈ�� �ٲ۴�.
		nextbtn.setBackground(Color.LIGHT_GRAY);
		nextbtn.setForeground(Color.black);
		nextbtn.setVisible(false); // ������ �־����� ������ ������ �ʰ� �Ѵ�.
		explainmainpanel.add(nextbtn); // ���� ��ư �߰�

		previousbtn = new JButton("Back"); // ���� ȭ������ ���ư��� ��ư�� �߰�
		previousbtn.setBounds(650, 580, 120, 50); // ��ư�� ũ��� ��ġ�� ����
		previousbtn.addActionListener(pagemove);
		previousbtn.addMouseListener(mouseevent);
		previousbtn.setFont(new Font("Vendana", Font.BOLD, 16)); // �̺�Ʈ �ڵ鸵�� ��Ʈ�� �߰�
		previousbtn.setBackground(Color.LIGHT_GRAY);
		previousbtn.setForeground(Color.black); // ��ư�� �� ����
		previousbtn.setVisible(false); // ������ �־����� ������ ������ �ʰ� �Ѵ�.
		explainmainpanel.add(previousbtn); // ���� ��ư �߰�

		// �߰��ϱ� add
		this.add(explainmainpanel); // �����г��� Ȱ��ȭ �ϱ����� �߰���Ų��

		explainmainpanel.add(explainpanel); // ������ ������ ��� �гε��� ���� �гο��� �߰� ��Ų��
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

		explainpanel.add(first); // ������ ��� �гο� �̹����� �ҷ����� �󺧵��� �߰� ��Ų��
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

		explainmainpanel.add(mainlbl); // ������ �ǹؿ������� // ����ȭ���� ������ �ǹؿ��ٰ� ����

	}

	private class selectpageListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			Object obj = event.getSource(); // �̺�Ʈ�� �߻��� ������Ʈ�� ����

			if (obj == init) { // ó�� ȭ�鿡 ���� ������ �ҷ����� ��ư�� ������

				explainpanel.setVisible(true); // �ʱ� ȭ�� ������ ��� �г��� Ȱ��ȭ ��Ų��

				previousbtn.setVisible(true); // ���� ��ư�� Ȱ��ȭ ��Ų��.

				init.setVisible(false); // ������ �ҷ����� ��ư���� ��Ȱ��ȭ ��Ų��
				check1.setVisible(false);
				check2.setVisible(false);
				table.setVisible(false);

			} else if (obj == check1) { // ������ �Է��ϴ� ������ �ҷ����� ��ư�� ������

				explainpanel2.setVisible(true); // ù��° ���� ���� �г��� Ȱ��ȭ�ǰ�

				nextbtn.setVisible(true); // ���� ��ư�� Ȱ��ȭ�ȴ�
				count = count + 1; // count �� 1�� ���Ѵ�

				init.setVisible(false); // ������ �ҷ����� ��ư���� ��Ȱ��ȭ ��Ų��
				check1.setVisible(false);
				check2.setVisible(false);
				table.setVisible(false);

			}

			else if (obj == check2) { // ���̺� ���ÿ� ���� ������ �ҷ����� ��ư�� ������

				explainpanel6.setVisible(true); // ù���� ���̺� ���� �г��� Ȱ��ȭ�ǰ�

				nextbtn.setVisible(true); // ������ư�� Ȱ��ȭ �Ǹ�
				count = count + 10; // count �� 10�� �ȴ�

				init.setVisible(false); // ������ �ҷ����� ��ư���� ��Ȱ��ȭ ��Ų��
				check1.setVisible(false);
				check2.setVisible(false);
				table.setVisible(false);

			}

			else if (obj == table) { // ���������� �����ϴ� ��ư�� ������

				explainpanel11.setVisible(true); // ���� ������ ��� �г��� Ȱ��ȭ�ǰ�

				previousbtn.setVisible(true); // ������ư Ȱ��ȭ

				init.setVisible(false);
				check1.setVisible(false); // ������ �ҷ����� ��ư���� ��Ȱ��ȭ ��Ų��
				check2.setVisible(false);
				table.setVisible(false);

			} else if (obj == previousbtn) { // ������ư�� ������

				explainpanel.setVisible(false); // ��� �����г��� ��Ȱ��ȭ ��Ų��
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

				previousbtn.setVisible(false); // ������ư�� ��Ȱ��ȭ ��Ų��

				init.setVisible(true);
				check1.setVisible(true); // ������ �����ϴ� ��ư���� Ȱ��ȭ ��Ų��
				check2.setVisible(true);
				table.setVisible(true);
			}

			else if (obj == nextbtn && count == 1) { // ������ư�� ������ count�� 1�϶�( �����Է��� �����ϴ� ù���� �г��϶�)

				explainpanel2.setVisible(false); // ù���� �����г��� ��Ȱ��ȭ��Ű��
				explainpanel3.setVisible(true); // �ι��� ���� �����г��� Ȱ��ȭ ��Ų��

				count = count + 1; // count �� 2���ȴ�

			} else if (obj == nextbtn && count == 2) { // ������ư�� ������ count�� 2�϶�( �����Է��� �����ϴ� �ι��� �г��϶�)

				explainpanel3.setVisible(false); // �ι��縦 ��Ȱ��ȭ
				explainpanel4.setVisible(true); // ����°�� Ȱ��ȭ

				count = count + 1; // count �� 3

			}

			else if (obj == nextbtn && count == 3) { // ������ư�� ������ count�� 3�϶�( �����Է��� �����ϴ� ������ �г��϶�)

				explainpanel4.setVisible(false); // �������� ��Ȱ��ȭ
				explainpanel5.setVisible(true); // �׹����� Ȱ��ȭ
				previousbtn.setVisible(true); // ������ư Ȱ��ȭ
				nextbtn.setVisible(false); // ������ư ��Ȱ��ȭ
				count = 0; // count�� 0���� �ʱ�ȭ��Ų��(�ٽ� ó��ȭ������ ���ư��⋚����)

			}

			else if (obj == nextbtn && count == 10) { // ������ư�� ������ count�� 10�϶�( ���̺� ���� �� �����ϴ� ù���� �г��϶�)

				explainpanel6.setVisible(false); // ù���� ��Ȱ��ȭ
				explainpanel7.setVisible(true); // �ι��� Ȱ��ȭ

				count = count + 1; // count �� 11

			} else if (obj == nextbtn && count == 11) { // ������ư�� ������ count�� 11�϶�( ���̺� ���� �� �����ϴ� �ι��� �г��϶�)

				explainpanel7.setVisible(false); // �ι��� ��Ȱ��ȭ
				explainpanel8.setVisible(true); // ������ Ȱ��ȭ

				count = count + 1; // count �� 12

			}

			else if (obj == nextbtn && count == 12) { // ������ư�� ������ count�� 12�϶�( ���̺� ���� �� �����ϴ� ������ �г��϶�)

				explainpanel8.setVisible(false); // ������ ��Ȱ��ȭ
				explainpanel9.setVisible(true); // �׹��� Ȱ��ȭ

				count = count + 1; // count �� 13
			} else if (obj == nextbtn && count == 13) { // ������ư�� ������ count�� 13�϶�( ���̺� ���� �� �����ϴ� �׹��� �г��϶�)

				explainpanel9.setVisible(false); // �׹��� ��Ȱ��ȭ
				explainpanel10.setVisible(true); // �ټ����� Ȱ��ȭ
				previousbtn.setVisible(true); // ������ư Ȱ��ȭ
				nextbtn.setVisible(false); // ������ư ��Ȱ��ȭ
				count = 0; // count 0���� �ʱ�ȭ
			}

		}
	}

	private class MenuButtonListener implements MouseListener { // ��ư�� ���� �ٲٱ����� ���콺 ������ ���
		public void mouseClicked(MouseEvent event) {
		}

		public void mousePressed(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) { // ���콺�� ��ư�� ����
			JButton btnMenu = (JButton) event.getSource();
			btnMenu.setBackground(Color.white); // ���� �ٲ۴�
			btnMenu.setForeground(Color.black);

		} // mouseEntered()

		public void mouseExited(MouseEvent event) {
			JButton btnMenu = (JButton) event.getSource(); // ���콺�� ��ư�� ����������
			btnMenu.setBackground(Color.LIGHT_GRAY); // ��ư���� ������� �ȴ�
			btnMenu.setForeground(Color.black);

		} // mouseExited()
	} // MenuButtonListener class

}
