package ch26_socket.simpleGUI.client;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import lombok.Getter;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class SimpleGUIClient extends JFrame {
	
	// Receiver에서 SimpleGUI client의 메서드등을 사용하기 위해
	private static SimpleGUIClient instance;
	public static SimpleGUIClient getInstance() {
		if(instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}

	private String username;
	private Socket socket;

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane userListScrollPane;
	private DefaultListModel<String> userListModel;
	private JList userList;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUIClient frame = SimpleGUIClient.getInstance();
					frame.setVisible(true);
										
					ClientReceiver clientReceiver = new ClientReceiver(); // receiver 스레드에서 getter로 변수를 받아가기 때문에 매개변수가 필요없음
					clientReceiver.start();
				
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimpleGUIClient() {

		username = JOptionPane.showInputDialog(contentPane, "아이디를 입렫하세요.");	
		
		if(Objects.isNull(username)) {
			System.exit(0);
		}
		if(username.isBlank()) {
			System.exit(0);
		}
		
		try {
			socket = new Socket("127.0.0.1", 8000); // > 생성되면 .accept와 연결
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 291, 210);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					SendMessage sendMessage = SendMessage.builder()
							.fromUsername(username)
							.messageBody(textField.getText())
							.build();
					
					RequestBodyDto<SendMessage> requestBodyDto = 
							new RequestBodyDto<>("sendMessage", sendMessage);
					
					ClientSender.getInstance().send(requestBodyDto);
					textField.setText("");
				}
			}
		});
		textField.setBounds(12, 230, 410, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(315, 10, 107, 210);
		contentPane.add(userListScrollPane);

		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScrollPane.setViewportView(userList);
		
		
		
	
	}
}
