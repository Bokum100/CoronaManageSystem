//Front: �����
//Back: 
//Last Update : 20.11.23
//Des : �����ͺ��̽����� ������ ���� ������ �� �ִ� ������ �� ���

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

	private int frameWidth = 400; //����
	private int frameHeight = 450; //����
	private JTextField tf_adminName; //���θ� �Է� �ʵ�
	private JTextField tf_id; //id �Է� �ʵ�
	private JPasswordField tf_password; //pw �Է� �ʵ�
	private JPasswordField tf_confirmPassword; //pw Ȯ�� �Է� �ʵ�
	
	public AdminInfoDeleteGUI() {
		setResizable(false); //â ������ ���� �Ұ���
		Toolkit tk = Toolkit.getDefaultToolkit(); //������� ȭ�� ũ�Ⱚ�� ������� ��Ŷ Ŭ����
		 
		setSize(frameWidth,frameHeight); //������ ������ ����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //â ������ ����
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("������ ����"); //Ÿ��Ʋ ����
		getContentPane().setBackground(MyColor.ALICEBLUE); //����
		getContentPane().setLayout(null);

		// �ձ� �𼭸�
		AbstractBorder brdr = new BubbleBorder(Color.BLACK, 2, 16, 0);

		// ���ҽ� �̸� �ҷ�����
		URL src = AdminInfoDeleteGUI.class.getResource("/resources/check.png");
		ImageIcon checkIcon = MyUtility.resizeImage(new ImageIcon(src), 70, 70);
		
		src = AdminInfoDeleteGUI.class.getResource("/resources/delete.png");
		ImageIcon deleteIcon = MyUtility.resizeImage(new ImageIcon(src), 50, 50);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(50, 10, 300, 70);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		topPanel.setBackground(MyColor.LIGHTSKY);
		topPanel.setBorder(brdr);
		
		JLabel lb_title = new JLabel("���� ����");
		lb_title.setFont(new Font("���� ���", Font.BOLD, 22));
		lb_title.setHorizontalAlignment(SwingConstants.LEFT);
		lb_title.setBounds(12, 10, 170, 50);
		lb_title.setForeground(MyColor.PLUSIANBLUE);
		topPanel.add(lb_title);
		
		JLabel lb_homeIcon = new JLabel(deleteIcon);
		lb_homeIcon.setBounds(235, 12, 50, 50);
		topPanel.add(lb_homeIcon);
		
		JLabel lbl_tfDes1 = new JLabel("�����ڸ�");
		lbl_tfDes1.setFont(new Font("���� ���", Font.PLAIN, 12));
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
		lbl_tfDes2.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes2.setBounds(50, 160, 55, 25);
		getContentPane().add(lbl_tfDes2);
		
		tf_password = new JPasswordField(); //�н����� �ʵ� ���
		tf_password.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_password.setColumns(10);
		tf_password.setBounds(125, 205, 210, 25);
		tf_password.setBackground(MyColor.LIGHTGRAY);
		tf_password.setForeground(Color.black);
		tf_password.setEchoChar('*'); //�ش� ĭ���� �Է½� * �� ǥ����
		tf_password.setBorder(new LineBorder(MyColor.WHITE, 2));	
		getContentPane().add(tf_password);
		
		JLabel lbl_tfDes3 = new JLabel("Password");
		lbl_tfDes3.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes3.setBounds(50, 205, 55, 25);
		getContentPane().add(lbl_tfDes3);
		
		tf_confirmPassword = new JPasswordField();
		tf_confirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_confirmPassword.setColumns(10);
		tf_confirmPassword.setBounds(125, 250, 210, 25);
		tf_confirmPassword.setBackground(MyColor.LIGHTGRAY);
		tf_confirmPassword.setForeground(Color.black);
		tf_confirmPassword.setBorder(new LineBorder(MyColor.WHITE, 2));	
		tf_confirmPassword.setEchoChar('*'); //�ش� ĭ���� �Է½� * �� ǥ����
		getContentPane().add(tf_confirmPassword);
		
		JLabel lbl_tfDes4 = new JLabel("PW Ȯ��");
		lbl_tfDes4.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes4.setForeground(MyColor.PLUSIANBLUE);
		lbl_tfDes4.setBounds(50, 250, 55, 25);
		getContentPane().add(lbl_tfDes4);
		
		JLabel lbl_tempMessage = new JLabel("tmpMsg"); //���߿� �ൿ�� ���� ������� �����ϰ� ǥ������ ��
		lbl_tempMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tempMessage.setBounds(50, 300, 285, 30);
		getContentPane().add(lbl_tempMessage);
		
		JButton btn_add = new JButton("����");
		btn_add.setFont(new Font("���� ���", Font.BOLD, 14));
		btn_add.setForeground(MyColor.WHITE);
		btn_add.setFocusPainted(false);
		btn_add.setBounds(238, 340, 97, 23);
		btn_add.setBackground(MyColor.NAVY);
		getContentPane().add(btn_add);
		
		
		
		setVisible(true);
	}
}
