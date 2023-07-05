package ch25_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMain1 extends JFrame {
	
	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";

	private JPanel contentPane;
	private CardLayout loginPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUIMain1 frame = new GUIMain1();
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
	public GUIMain1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// 로그인 화면에서 mainCardPane으로 넘기기?
		loginPane = new CardLayout(0, 0);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(104, 51, 214, 27);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(104, 102, 214, 27);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton signinButton = new JButton("Login");
		signinButton.setForeground(new Color(0, 0, 0));
		signinButton.setBackground(new Color(255, 255, 255));
		signinButton.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signinButton.setBounds(104, 172, 214, 27);
		contentPane.add(signinButton);
		/* 익명 클래스  */
		signinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				if(!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
					JOptionPane.showInternalMessageDialog(contentPane, "사용자 정보가 일치하지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showInternalMessageDialog(contentPane, "환영합니다.", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				
				
			}
		});
	}
}
