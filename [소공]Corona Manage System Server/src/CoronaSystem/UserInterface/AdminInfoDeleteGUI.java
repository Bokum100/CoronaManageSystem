package CoronaSystem.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
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
import javax.swing.JButton;

public class AdminInfoDeleteGUI extends JFrame{

	private int frameWidth = 400;
	private int frameHeight = 400;
	private JTextField tf_adminName;
	private JTextField tf_id;
	private JPasswordField tf_password;
	private JPasswordField tf_confirmPassword;
	
	public AdminInfoDeleteGUI() {
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit(); //사용자의 화면 크기값을 얻기위한 툴킷 클래스
		
		setSize(frameWidth,frameHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("관리자 추가");
		getContentPane().setBackground(MyColor.ALICEBLUE);
		getContentPane().setLayout(null);

		// 둥근 모서리
		AbstractBorder brdr = new BubbleBorder(Color.BLACK, 2, 16, 0);

		// 리소스 미리 불러오기
		URL src = LoginGUI.class.getResource("/resources/check.png");
		ImageIcon checkIcon = MyUtility.resizeImage(new ImageIcon(src), 70, 70);
		
		src = LoginGUI.class.getResource("/resources/home.png");
		ImageIcon homeIcon = MyUtility.resizeImage(new ImageIcon(src), 50, 50);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(50, 10, 300, 70);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		topPanel.setBackground(MyColor.LIGHTSKY);
		topPanel.setBorder(brdr);
		
		JLabel lb_title = new JLabel("계정 삭제");
		lb_title.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lb_title.setHorizontalAlignment(SwingConstants.LEFT);
		lb_title.setBounds(12, 10, 170, 50);
		lb_title.setForeground(MyColor.PLUSIANBLUE);
		topPanel.add(lb_title);
		
		JLabel lb_homeIcon = new JLabel(homeIcon);
		lb_homeIcon.setBounds(235, 12, 50, 50);
		topPanel.add(lb_homeIcon);
		
		JLabel lbl_tfDes1 = new JLabel("관리자명");
		lbl_tfDes1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_tfDes1.setBounds(50, 115, 55, 25);
		getContentPane().add(lbl_tfDes1);
		
		tf_adminName = new JTextField();
		tf_adminName.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_adminName.setBounds(125, 115, 210, 25);
		tf_adminName.setBackground(MyColor.LIGHTGRAY);
		tf_adminName.setForeground(Color.black);
		tf_adminName.setBorder(new LineBorder(MyColor.WHITE, 2));	
		getContentPane().add(tf_adminName);
		tf_adminName.setColumns(10);
		
		tf_id = new JTextField();
		tf_id.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_id.setColumns(10);
		tf_id.setBounds(125, 160, 210, 25);
		tf_id.setBackground(MyColor.LIGHTGRAY);
		tf_id.setForeground(Color.black);
		tf_id.setBorder(new LineBorder(MyColor.WHITE, 2));	
		getContentPane().add(tf_id);
		
		JLabel lbl_tfDes2 = new JLabel("ID");
		lbl_tfDes2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_tfDes2.setBounds(50, 160, 55, 25);
		getContentPane().add(lbl_tfDes2);
		
		tf_password = new JPasswordField();
		tf_password.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_password.setColumns(10);
		tf_password.setBounds(125, 205, 210, 25);
		tf_password.setBackground(MyColor.LIGHTGRAY);
		tf_password.setForeground(Color.black);
		tf_password.setEchoChar('*'); //해당 칸에는 입력시 * 로 표시함
		tf_password.setBorder(new LineBorder(MyColor.WHITE, 2));	
		getContentPane().add(tf_password);
		
		JLabel lbl_tfDes3 = new JLabel("Password");
		lbl_tfDes3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_tfDes3.setBounds(50, 205, 55, 25);
		getContentPane().add(lbl_tfDes3);
		
		tf_confirmPassword = new JPasswordField();
		tf_confirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_confirmPassword.setColumns(10);
		tf_confirmPassword.setBounds(125, 250, 210, 25);
		tf_confirmPassword.setBackground(MyColor.LIGHTGRAY);
		tf_confirmPassword.setForeground(Color.black);
		tf_confirmPassword.setBorder(new LineBorder(MyColor.WHITE, 2));	
		tf_confirmPassword.setEchoChar('*'); //해당 칸에는 입력시 * 로 표시함
		getContentPane().add(tf_confirmPassword);
		
		JLabel lbl_tfDes4 = new JLabel("PW 확인");
		lbl_tfDes4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_tfDes4.setForeground(MyColor.PLUSIANBLUE);
		lbl_tfDes4.setBounds(50, 250, 55, 25);
		getContentPane().add(lbl_tfDes4);
		
		JLabel lbl_tempMessage = new JLabel("tmpMsg");
		lbl_tempMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tempMessage.setBounds(50, 300, 285, 30);
		getContentPane().add(lbl_tempMessage);
		
		JButton btn_add = new JButton("삭제");
		btn_add.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn_add.setForeground(MyColor.WHITE);
		btn_add.setFocusPainted(false);
		btn_add.setBounds(238, 340, 97, 23);
		btn_add.setBackground(MyColor.NAVY);
		getContentPane().add(btn_add);
		
		
		
		setVisible(true);
	}
}
