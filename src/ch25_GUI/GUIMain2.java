package ch25_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMain2 extends JFrame {

	private JPanel mainCardPane;
	private CardLayout mainCardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUIMain2 frame = new GUIMain2();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIMain2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		/*	<<< mainCard >>>  */
		mainCardPane = new JPanel();
//		카드 레이아웃을 사용할 때는 화면 하나를 변수로 선언하고 생성해서 변수를 setLayout에 넣어서 사용 해야만 함
		mainCardLayout = new CardLayout(0, 0);
		
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainCardPane.setLayout(mainCardLayout);

		setContentPane(mainCardPane);
		
		/*	<<< subPanel1 >>>  */
		/* 중요부분 */
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "subPanel1");
		subPanel1.setLayout(null);
		
		JButton subPanel2ShowBtn = new JButton("2번 페이지");
		subPanel2ShowBtn.setBounds(315, 105, 97, 23);
		subPanel1.add(subPanel2ShowBtn);

		subPanel2ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});
		
		/*	<<< subPanel2 >>>  */
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);
		
		JButton subPanel1ShowBtn = new JButton("1번 페이지");
		subPanel1ShowBtn.setBounds(12, 105, 97, 23);
		subPanel2.add(subPanel1ShowBtn);
		subPanel1ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel1");
			}
		});
		
		JButton subPanel3ShowBtn = new JButton("3번 페이지");
		subPanel3ShowBtn.setBounds(315, 105, 97, 23);
		subPanel2.add(subPanel3ShowBtn);
		subPanel3ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel3");
			}
		});
		
		/*	<<< subPanel3 >>>  */
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "subPanel3");
		subPanel3.setLayout(null);
		
		JButton subPanel2ShowBtn2 = new JButton("2번 페이지");
		subPanel2ShowBtn2.setBounds(12, 105, 97, 23);
		subPanel3.add(subPanel2ShowBtn2);
		subPanel2ShowBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});

		
	}

}
