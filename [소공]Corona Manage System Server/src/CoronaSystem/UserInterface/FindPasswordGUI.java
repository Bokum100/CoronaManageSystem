//Front: �����
//Back: �����
//Last Update : 20.11.23
//Des: ��й�ȣ ã�� ��� �� ������â

package CoronaSystem.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

import Addon.BubbleBorder;
import Addon.MyColor;
import Addon.MyUtility;
import CoronaSystem.CoronaSystem;

public class FindPasswordGUI extends JFrame{
	
	private int frameWidth = 350; //������ ���� ũ��
	private int frameHeight = 250; //������ ���� ũ��
	private JTextField tf_adminName; //�����ڸ� �Է� �ʵ�
	private JTextField tf_id; //id �Է� �ʵ�
	
	private JFrame frame; //�ڱ� �ڽ��� �ּҰ�
	
	private static FindPasswordGUI lastGUI; //�������� ���� �ش� ������ ��ü 

	public FindPasswordGUI() {
		frame = this; //�ش� ��ü �ּҰ� ����
		
		if(lastGUI != null) { //������ ���� �����Ӱ�ü�� null �� �ƴ϶��
			try {
				lastGUI.dispose(); //���� ��й�ȣ ã�� �������� �ݾƹ���, ��й�ȣ �������� 2�� ���� ���� ����
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		lastGUI = this; //������ ���� ��ü�� �ڱ� �ڽ����� ����
		setResizable(false); //������ ũ�� ���� ����
		Toolkit tk = Toolkit.getDefaultToolkit(); //������� ȭ�� ũ�Ⱚ�� ������� ��Ŷ Ŭ����
		
		setSize(frameWidth,frameHeight); //������ ũ�� ����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ش� �������� ������ �׳� ����
		//ȭ�� ����� ������ ����
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("�ڷγ� ���� �ý���"); //������ ���� ����
		
		getContentPane().setLayout(null); //���� ��ġ ���
		getContentPane().setBackground(MyColor.ALICEBLUE); //���� ����
		
		//�ձ� �𼭸�
		AbstractBorder brdr = new BubbleBorder(Color.BLACK,2,16,0);
		
		//���ҽ� �̸� �ҷ�����
		URL finderSrc = FindPasswordGUI.class.getResource("/resources/finder.png");
		ImageIcon finderIcon = MyUtility.resizeImage(new ImageIcon(finderSrc), 30, 30);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(65, 10, 220, 40);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		topPanel.setBackground(MyColor.LIGHTSKY);
		topPanel.setBorder(brdr);
		
		JLabel lb_title = new JLabel("��й�ȣ ã��");
		lb_title.setFont(new Font("���� ���", Font.BOLD, 16));
		lb_title.setHorizontalAlignment(SwingConstants.LEFT);
		lb_title.setBounds(10, 5, 170, 30);
		lb_title.setForeground(MyColor.PLUSIANBLUE);
		topPanel.add(lb_title);
		
		JLabel lb_finderIcon = new JLabel(finderIcon);
		lb_finderIcon.setBounds(180, 5, 30, 30);
		topPanel.add(lb_finderIcon);
		
		JLabel lbl_tfDes1 = new JLabel("�����ڸ�");
		lbl_tfDes1.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes1.setBounds(35, 75, 55, 25);
		getContentPane().add(lbl_tfDes1);
		
		tf_adminName = new JTextField();
		tf_adminName.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_adminName.setBounds(110, 75, 210, 25);
		tf_adminName.setBackground(MyColor.LIGHTGRAY);
		tf_adminName.setForeground(Color.black);
		tf_adminName.setBorder(new LineBorder(MyColor.WHITE, 2));	
		getContentPane().add(tf_adminName);
		tf_adminName.setColumns(10);
		
		tf_id = new JTextField();
		tf_id.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_id.setColumns(10);
		tf_id.setBounds(110, 120, 210, 25);
		tf_id.setBackground(MyColor.LIGHTGRAY);
		tf_id.setForeground(Color.black);
		tf_id.setBorder(new LineBorder(MyColor.WHITE, 2));	
		getContentPane().add(tf_id);
		
		JLabel lbl_tfDes2 = new JLabel("ID");
		lbl_tfDes2.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbl_tfDes2.setBounds(35, 120, 55, 25);
		getContentPane().add(lbl_tfDes2);
		
		JButton btn_find = new JButton("ã��");
		btn_find.setFont(new Font("���� ���", Font.BOLD, 14));
		btn_find.setForeground(MyColor.WHITE);
		btn_find.setFocusPainted(false);
		btn_find.setBounds(220, 170, 100, 25);
		btn_find.setBackground(MyColor.NAVY);
		btn_find.addActionListener(new ActionListener() { //ã�� ��ư Ŭ����
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				String adminName = tf_adminName.getText(); //�����ڸ� �Է� �ʵ忡�� �Է°� ������
				String id = tf_id.getText(); //id �Է� �ʵ忡�� �Է°� ������
				findPassword(adminName, id); //��й�ȣ ã�� �޼��� ȣ��
			}
		});
		getContentPane().add(btn_find);
		
		setVisible(true); //������ ǥ��
	}
	
	private void findPassword(String adminName, String id) { //��й�ȣ ã��
		String findAdminName = CoronaSystem.database.getAdminName(id); //�����ͺ��̽����� id ���� ���θ� ������
		if(findAdminName != null && findAdminName.equals(adminName)) { //���� �̸� ��ġ�ϸ�
			String basePw = CoronaSystem.database.getPassword(id); //�����ͺ��̽����� id ���� �н����� ������
			CheckGUI checkGUI = new CheckGUI(frame, "��й�ȣ�� "+basePw+" �Դϴ�.", false, true);
		} else {
			CheckGUI checkGUI = new CheckGUI(frame, "��ġ�ϴ� ������ �����ϴ�.", false, false);
		}
	}
}
