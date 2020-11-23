//Front: �����
//Back: 
//Last Update : 20.11.23
//Des : �����ͺ��̽��� ������ ���� �߰��� �� �ִ� ������ �� ���

package coronamanagesystem.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;

import addon.BubbleBorder;
import addon.IDFilter;
import addon.MyColor;
import addon.MyUtility;
import coronamanagesystem.CoronaSystem;

public class AdminInfoAddGUI extends JFrame{

	private int frameWidth = 400; //����
	private int frameHeight = 450; //����
	private JTextField tf_adminName; //���θ� �Է� �ؽ�Ʈ�ʵ�
	private JTextField tf_id; //id �Է� �ؽ�Ʈ�ʵ�
	private JPasswordField tf_password; //pw �Է� �ؽ�Ʈ�ʵ�
	private JPasswordField tf_confirmPassword; //pw Ȯ�� �Է� �׽�Ʈ �ʵ�
	private JLabel lbl_tempMessage;
	
	private JFrame frame; //�ڱ� �ڽ��� �ּ� �����
	
	public AdminInfoAddGUI() {
		frame = this;
		
		setResizable(false); //â ������ ����  �Ұ���
		Toolkit tk = Toolkit.getDefaultToolkit(); //������� ȭ�� ũ�Ⱚ�� ������� ��Ŷ Ŭ����
		
		setSize(frameWidth,frameHeight); //������ ����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //â ������ �׳� ����
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		//ȭ�� ���
		
		setTitle("������ �߰�"); //Ÿ��Ʋ ����
		getContentPane().setBackground(MyColor.ALICEBLUE); //������ �ٸ��� ���
		getContentPane().setLayout(null); //���� ��ġ ���

		// �ձ� �𼭸�
		AbstractBorder brdr = new BubbleBorder(Color.BLACK, 2, 16, 0);

		// ���ҽ� �̸� �ҷ�����
		URL src = AdminInfoAddGUI.class.getResource("/resources/check.png");
		ImageIcon checkIcon = MyUtility.resizeImage(new ImageIcon(src), 70, 70);
		
		src = AdminInfoAddGUI.class.getResource("/resources/check.png");
		ImageIcon homeIcon = MyUtility.resizeImage(new ImageIcon(src), 50, 50);
		
		JPanel topPanel = new JPanel(); //���� ���� �г�
		topPanel.setBounds(50, 10, 300, 70);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		topPanel.setBackground(MyColor.LIGHTSKY);
		topPanel.setBorder(brdr);
		
		JLabel lb_title = new JLabel("���� �߰�"); //����
		lb_title.setFont(new Font("���� ���", Font.BOLD, 22));
		lb_title.setHorizontalAlignment(SwingConstants.LEFT);
		lb_title.setBounds(12, 10, 170, 50);
		lb_title.setForeground(MyColor.PLUSIANBLUE);
		topPanel.add(lb_title);
		
		JLabel lb_homeIcon = new JLabel(homeIcon);
		lb_homeIcon.setBounds(235, 12, 50, 50);
		topPanel.add(lb_homeIcon);
		
		JLabel lbl_tfDes1 = new JLabel("�����ڸ�"); 
		lbl_tfDes1.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes1.setBounds(50, 115, 55, 25);
		lbl_tfDes1.setForeground(MyColor.PLUSIANBLUE);
		getContentPane().add(lbl_tfDes1);
		
		tf_adminName = new JTextField();
		tf_adminName.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_adminName.setBounds(125, 115, 210, 25);
		tf_adminName.setBackground(MyColor.LIGHTGRAY);
		tf_adminName.setForeground(Color.black);
		tf_adminName.setBorder(new LineBorder(MyColor.WHITE, 2));	
		getContentPane().add(tf_adminName);
		tf_adminName.setColumns(10);
		tf_adminName.setFont(new Font("���� ���", Font.PLAIN, 15));
		tf_adminName.addKeyListener(new KeyAdapter() { //�����ڸ��� �ִ� 10���ڱ����� �Է� ����
			
			 @Override
	            public void keyTyped(KeyEvent e) {
				 JTextField tf = (JTextField) e.getSource();
	            	if(tf.getText().length() >= 10) {
	            		e.consume();
	            	}
	            }
			
		});
		
		tf_id = new JTextField();
		tf_id.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_id.setColumns(10);
		tf_id.setBounds(125, 160, 210, 25);
		tf_id.setBackground(MyColor.LIGHTGRAY);
		tf_id.setForeground(Color.black);
		tf_id.setBorder(new LineBorder(MyColor.WHITE, 2));
		tf_id.setFont(new Font("���� ���", Font.PLAIN, 15));
		((AbstractDocument) tf_id.getDocument()).setDocumentFilter(new IDFilter()); //���ĺ�, ���ڸ� ���
		tf_id.addKeyListener(new KeyAdapter() { //id�� 12���ڱ����� �Է°���
			
			 @Override
	            public void keyTyped(KeyEvent e) {
	            	JTextField tf = (JTextField) e.getSource();
	            	if(tf.getText().length() >= 12) { //12�� �̻� �Է� ���ϰ� ����
	            		e.consume();
	            	}      	
	            	
	            }
			
		});
		getContentPane().add(tf_id);
		
		JLabel lbl_tfDes2 = new JLabel("ID");
		lbl_tfDes2.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes2.setBounds(50, 160, 55, 25);
		lbl_tfDes2.setForeground(MyColor.PLUSIANBLUE);
		getContentPane().add(lbl_tfDes2);
		
		tf_password = new JPasswordField();
		tf_password.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_password.setColumns(10);
		tf_password.setBounds(125, 205, 210, 25);
		tf_password.setBackground(MyColor.LIGHTGRAY);
		tf_password.setForeground(Color.black);
		tf_password.setEchoChar('*'); //�ش� ĭ���� �Է½� * �� ǥ����
		tf_password.setBorder(new LineBorder(MyColor.WHITE, 2));	
		tf_password.setFont(new Font("���� ���", Font.PLAIN, 15));
		tf_password.addKeyListener(new KeyAdapter() { //pw�� 14���ڱ����� �Է� ����
			
			 @Override
	            public void keyTyped(KeyEvent e) {
	            	JPasswordField tf = (JPasswordField) e.getSource();
	            	if(tf.getText().length() >= 14) {
	            		e.consume();
	            	}
	            }
			
		});
		getContentPane().add(tf_password);
		
		JLabel lbl_tfDes3 = new JLabel("Password");
		lbl_tfDes3.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes3.setBounds(50, 205, 55, 25);
		lbl_tfDes3.setForeground(MyColor.PLUSIANBLUE);
		getContentPane().add(lbl_tfDes3);
		
		tf_confirmPassword = new JPasswordField();
		tf_confirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_confirmPassword.setColumns(10);
		tf_confirmPassword.setBounds(125, 250, 210, 25);
		tf_confirmPassword.setBackground(MyColor.LIGHTGRAY);
		tf_confirmPassword.setForeground(Color.black);
		tf_confirmPassword.setBorder(new LineBorder(MyColor.WHITE, 2));	
		tf_confirmPassword.setFont(new Font("���� ���", Font.PLAIN, 15));
		tf_confirmPassword.setEchoChar('*'); //�ش� ĭ���� �Է½� * �� ǥ����
		tf_confirmPassword.addKeyListener(new KeyAdapter() { //pwȮ���� 14���ڱ����� �Է°���
			
			 @Override
	            public void keyTyped(KeyEvent e) {
	            	JPasswordField tf = (JPasswordField) e.getSource();
	            	if(tf.getText().length() >= 14) {
	            		e.consume();
	            	}
	            }
			
		});
		getContentPane().add(tf_confirmPassword);
		
		JLabel lbl_tfDes4 = new JLabel("PW Ȯ��");
		lbl_tfDes4.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes4.setForeground(MyColor.PLUSIANBLUE);
		lbl_tfDes4.setBounds(50, 250, 55, 25);
		getContentPane().add(lbl_tfDes4);
		
		lbl_tempMessage = new JLabel("");
		lbl_tempMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tempMessage.setBounds(50, 300, 285, 30);
		lbl_tempMessage.setFont(new Font("���� ���", Font.PLAIN, 15));
		getContentPane().add(lbl_tempMessage);
		
		JButton btn_add = new JButton("�߰�");
		btn_add.setFont(new Font("���� ���", Font.BOLD, 14));
		btn_add.setForeground(MyColor.WHITE);
		btn_add.setFocusPainted(false);
		btn_add.setBounds(238, 340, 97, 23);
		btn_add.setBackground(MyColor.NAVY);
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //�߰� ��ư ������ �� 
				String inputId = tf_id.getText(); //�Է��� id��
				if(inputId.equals("")) {
					sendTempMsg("�߰��� ID�� �Է����ּ���.");
					return;
				}
				String inputPw = tf_password.getText(); //�Է��� pw��
				if(inputPw.equals("")) {
					sendTempMsg("PW�� �Է����ּ���.");
					return;
				}
				String inputAdminName = tf_adminName.getText(); //�Է��� �����ڸ� ��
				if(inputAdminName.equals("")) {
					sendTempMsg("�����ڸ��� �Է����ּ���.");
					return;
				}
				String inputCfPw = tf_confirmPassword.getText(); //�Է��� pwȮ�ΰ�
				if(!inputPw.equals(inputCfPw)) { //���� pw���� pwȮ�ΰ� ����ġ��
					sendTempMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				} else {
					String baseId = CoronaSystem.database.getPassword(inputId); 
					if(baseId != null) { //�̹� �����ϴ� id��
						sendTempMsg("�̹� �����ϴ� ID�Դϴ�.");
					} else { //������ϸ�
						CoronaSystem.database.insertAdminInfo(inputId, inputPw, inputAdminName);//���� �߰�
						CheckGUI checkGUI = new CheckGUI(frame, "������ �߰��ƽ��ϴ�.", false, true);
						//������ ���� �߰� �����ӱ��� �ݱ�
					}
				}
			}
		});
		getContentPane().add(btn_add);
		
		
		
		setVisible(true);
	}
	
	private void sendTempMsg(String tmpMsg) { //������ �޽��� ǥ��
		lbl_tempMessage.setText(tmpMsg);
	}
}
