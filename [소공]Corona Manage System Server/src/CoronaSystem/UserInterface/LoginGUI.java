//Front: �����
//Back: �����
//Last Update : 20.11.23
//Des: �α��� ������ �� ������

package CoronaSystem.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

import Addon.BubbleBorder;
import Addon.MyColor;
import Addon.MyUtility;
import CoronaSystem.CoronaSystem;

public class LoginGUI extends JFrame{

	private int frameWidth = 500; //������ ���� ũ��
	private int frameHeight = 400; //������ ����ũ��
	private JFormattedTextField tf_id; //id �Է� �ʵ�
	private JPasswordField tf_pw; //pw �Է� �ʵ�
	private JButton btn_findPassword; //��й�ȣ ã�� ��ư
	
	public LoginGUI() {
		setResizable(false); //������ ũ�� ���� ����
		Toolkit tk = Toolkit.getDefaultToolkit(); //������� ȭ�� ũ�Ⱚ�� ������� ��Ŷ Ŭ����
		
		setSize(frameWidth,frameHeight); //������ ũ�� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE); //�α��� ������ ������ ���α׷� ����
		addWindowListener(new JFrameWindowClosingEventHandler()); //â �ݱ� �̺�Ʈ
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("�ڷγ� ���� �ý��� - �α���"); //������ ���� ����
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(MyColor.ALICEBLUE); //���� ����
		
		//�ձ� �𼭸�
		AbstractBorder brdr = new BubbleBorder(Color.BLACK,2,16,0);
		
		//���ҽ� �̸� �ҷ�����
		URL titleIconSrc = LoginGUI.class.getResource("/resources/titleIcon.png");
		ImageIcon titleIcon = MyUtility.resizeImage(new ImageIcon(titleIconSrc), 70, 70);
		setIconImage(titleIcon.getImage());
		
		URL logoSrc = LoginGUI.class.getResource("/resources/logo.png");
		ImageIcon logoIcon = MyUtility.resizeImage(new ImageIcon(logoSrc), 70, 70);
		
		URL finderSrc = LoginGUI.class.getResource("/resources/finder.png");
		ImageIcon finderIcon = MyUtility.resizeImage(new ImageIcon(finderSrc), 20, 20);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(80, 167, 340, 150);
		getContentPane().add(centerPanel);
		centerPanel.setLayout(null);
		centerPanel.setBackground(MyColor.LIGHTSKY);
		
		JLabel lb_adminLogin = new JLabel("������ �α���");
		lb_adminLogin.setForeground(MyColor.PLUSIANBLUE);
		lb_adminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lb_adminLogin.setFont(new Font("���� ���", Font.BOLD, 18));
		lb_adminLogin.setBounds(70, 10, 200, 30);
		centerPanel.add(lb_adminLogin);
		centerPanel.setBorder(new LineBorder(MyColor.PLUSIANBLUE));
		
		JLabel lb_id = new JLabel("ID");
		lb_id.setForeground(MyColor.PLUSIANBLUE);
		lb_id.setFont(new Font("���� ���", Font.BOLD, 16));
		lb_id.setBounds(35, 65, 25, 20);
		centerPanel.add(lb_id);
		
		tf_id = new JFormattedTextField();
		tf_id.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_id.setBounds(90, 65, 220, 25);
		tf_id.setFont(new Font("���� ���", Font.PLAIN, 15));
		centerPanel.add(tf_id);
		tf_id.setColumns(10);
		tf_id.setBackground(MyColor.LIGHTGRAY);
		tf_id.setForeground(Color.black);
		tf_id.setBorder(new LineBorder(MyColor.WHITE, 2));
		tf_id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyCode() == 10) { // ����Ű Ű�� ��������
                	tryLogin(); //�α��� �õ�
                } 
            }
            
            @Override
            public void keyTyped(KeyEvent e) {
//            	char c = e.getKeyChar(); ���ڸ� �Է� ���� �� ���
//            	if(!Character.isDigit(c)) {
//            		e.consume();
//            	}
            	
            	JTextField tf = (JTextField) e.getSource();
            	if(tf.getText().length() >= 12) { //12�� �̻� �Է� ���ϰ� ����
            		e.consume();
            	}
            }
        });
		
		tf_pw = new JPasswordField();
		tf_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_pw.setBounds(90, 100, 220, 25);
		tf_pw.setEchoChar('*'); //�ش� ĭ���� �Է½� * �� ǥ����
		tf_pw.setColumns(10);
		tf_pw.setBackground(MyColor.LIGHTGRAY);
		tf_pw.setFont(new Font("���� ���", Font.PLAIN, 15));
		tf_pw.setForeground(Color.black);
		tf_pw.setBorder(new LineBorder(MyColor.WHITE, 2));	
		tf_pw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyCode() == 10) { // ����Ű Ű�� ��������
                	tryLogin();
                }
            }
            
            @Override
            public void keyTyped(KeyEvent e) {
            	JPasswordField tf = (JPasswordField) e.getSource();
            	if(tf.getText().length() >= 14) { //14�� �̻� �Է� ���ϰ� ����
            		e.consume();
            	}
            }
        });
		centerPanel.add(tf_pw);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setForeground(MyColor.PLUSIANBLUE);
		lblPw.setFont(new Font("���� ���", Font.BOLD, 16));
		lblPw.setBounds(35, 100, 45, 20);
		centerPanel.add(lblPw);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(124, 40, 260, 90);
		getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		titlePanel.setBackground(MyColor.STEELBLUE);
		titlePanel.setBorder(brdr);
		
		JLabel lb_icon_logo = new JLabel(logoIcon);
		lb_icon_logo.setBounds(12, 10, 70, 70);
		titlePanel.add(lb_icon_logo);
		
		JLabel lb_titleTop = new JLabel("Confirmed case -");
		lb_titleTop.setForeground(Color.WHITE);
		lb_titleTop.setHorizontalAlignment(SwingConstants.LEFT);
		lb_titleTop.setFont(new Font("���� ���", Font.BOLD, 18));
		lb_titleTop.setBounds(94, 17, 250, 20);
		titlePanel.add(lb_titleTop);
		
		JLabel lb_titleBottom = new JLabel("human traffic");
		lb_titleBottom.setForeground(Color.WHITE);
		lb_titleBottom.setFont(new Font("���� ���", Font.BOLD, 18));
		lb_titleBottom.setHorizontalAlignment(SwingConstants.CENTER);
		lb_titleBottom.setBounds(62, 47, 250, 20);
		titlePanel.add(lb_titleBottom);
		
		btn_findPassword = new JButton("Password ã��");
		btn_findPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		btn_findPassword.setFont(new Font("���� ���", Font.BOLD, 14));
		btn_findPassword.setBounds(350, 338, 130, 25);
		btn_findPassword.setOpaque(false);
		btn_findPassword.setBorder(null);
		btn_findPassword.setContentAreaFilled(false);
		btn_findPassword.setFocusable(false);
		btn_findPassword.setIcon(finderIcon);
		btn_findPassword.addActionListener(new ActionListener() { //��й�ȣ ã�� Ŭ���ߴٸ�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame findPasswordGUI = new FindPasswordGUI(); //��й�ȣ ã�� ������ ����
			}
		});
		getContentPane().add(btn_findPassword);
		
		//JLabel lb_icon_finder = new JLabel(finderIcon);
		//lb_icon_finder.setBounds(358, 339, 20, 25);
		//getContentPane().add(lb_icon_finder);
		
		setVisible(true);	
	}
	
	private void tryLogin() { //�α��� �õ�
		if (tf_id.getText().equals("")) { //ID�Է� Ȯ��
			CheckGUI cf = new CheckGUI(this, "ID�� �Է����ּ���.", false, false);
		} else if (tf_pw.getText().equals("")) { //pW�Է� Ȯ��
			CheckGUI cf = new CheckGUI(this, "PW�� �Է����ּ���.", false, false);
		} else {
			String id = tf_id.getText();
			String pw = ""; // �Է��� pw ������ ��
			char[] tmpPw = tf_pw.getPassword(); // ��ȯ���� char[] �̱� ������ string ���� �ٲٱ� ���� �۾� �ʿ�
			for (char tmpCh : tmpPw) {
				Character.toString(tmpCh); // �ѱ��ھ� �����ͼ� string���� ��ħ
				pw += tmpCh;
			}		
			
			String resPW = CoronaSystem.database.getPassword(id); //�����ͺ��̽����� id�� �̿��Ͽ� pw�� ������
			if(resPW == null) { //�����ͺ��̽��� �ش� id�� ���ٸ�
				new CheckGUI(this, "�������� �ʴ� ID�Դϴ�.", false, false); //���� �޽����� ���� ����
			} else { 
				if(!pw.equals(resPW)) { //�����ͺ��̽��� pw���� ����ڰ� ���� pw���� ��ġ���� �ʴٸ� 
					new CheckGUI(this, "��й�ȣ�� Ʋ���ϴ�.", false, false); //���� �޽����� ���� ����
				} else { //�α��� ���� �� 
					new HomeGUI(); // ���� �޴� ������ ����
					this.dispose(); //�α��� ������ �ݱ�
				}
				
			}
		}
	}
	
	
	private class JFrameWindowClosingEventHandler extends WindowAdapter { //â �ݱ��
		public void windowClosing(WindowEvent e) {
			if(e.getWindow() instanceof LoginGUI) { //�α��� ȭ�� ������
				System.exit(0); //���α׷� ����
			}	
		}
	}
}
