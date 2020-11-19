package CoronaSystem.UserInterface;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

import Addon.BubbleBorder;
import Addon.MyColor;
import Addon.MyUtility;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class HomeGUI extends JFrame{

	private int frameWidth = 400;
	private int frameHeight = 600;
	
	public HomeGUI() {
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit(); //������� ȭ�� ũ�Ⱚ�� ������� ��Ŷ Ŭ����
		
		setSize(frameWidth,frameHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new JFrameWindowClosingEventHandler()); //â �ݱ� �̺�Ʈ
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("�ڷγ� ���� �ý���");
		getContentPane().setBackground(MyColor.ALICEBLUE);
		getContentPane().setLayout(null);

		// �ձ� �𼭸�
		AbstractBorder brdr = new BubbleBorder(Color.BLACK, 2, 16, 0);

		// ���ҽ� �̸� �ҷ�����
		URL titleIconSrc = LoginGUI.class.getResource("/resources/titleIcon.png");
		ImageIcon titleIcon = MyUtility.resizeImage(new ImageIcon(titleIconSrc), 70, 70);
		setIconImage(titleIcon.getImage());

		URL homeSrc = LoginGUI.class.getResource("/resources/home.png");
		ImageIcon homeIcon = MyUtility.resizeImage(new ImageIcon(homeSrc), 50, 50);

		URL settingSrc = LoginGUI.class.getResource("/resources/settingIcon.png");
		ImageIcon settingIcon = MyUtility.resizeImage(new ImageIcon(settingSrc), 40, 40);
		
		URL src = LoginGUI.class.getResource("/resources/check.png");
		ImageIcon checkIcon = MyUtility.resizeImage(new ImageIcon(src), 40, 40);
		
		src = LoginGUI.class.getResource("/resources/delete.png");
		ImageIcon deleteIcon = MyUtility.resizeImage(new ImageIcon(src), 40, 40);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(50, 30, 300, 70);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		topPanel.setBackground(MyColor.LIGHTSKY);
		topPanel.setBorder(brdr);
		
		JLabel lb_title = new JLabel("Database ����");
		lb_title.setFont(new Font("���� ���", Font.BOLD, 22));
		lb_title.setHorizontalAlignment(SwingConstants.LEFT);
		lb_title.setBounds(12, 10, 170, 50);
		lb_title.setForeground(MyColor.PLUSIANBLUE);
		topPanel.add(lb_title);
		
		JLabel lb_homeIcon = new JLabel(homeIcon);
		lb_homeIcon.setBounds(235, 12, 50, 50);
		topPanel.add(lb_homeIcon);
		
		JPanel adminInfoPanel = new JPanel();
		adminInfoPanel.setBounds(25, 150, 345, 100);
		getContentPane().add(adminInfoPanel);
		adminInfoPanel.setLayout(null);
		
		JLabel lb_icon_adminInfo = new JLabel("");
		lb_icon_adminInfo.setBounds(10, 5, 40, 40);
		adminInfoPanel.add(lb_icon_adminInfo);
		adminInfoPanel.setBackground(MyColor.STEELBLUE);
		
		JLabel lb_adminInfoTitle = new JLabel("������ ����");
		lb_adminInfoTitle.setForeground(MyColor.PLUSIANBLUE);
		lb_adminInfoTitle.setFont(new Font("���� ���", Font.BOLD, 16));
		lb_adminInfoTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lb_adminInfoTitle.setBounds(65, 12, 100, 25);
		adminInfoPanel.add(lb_adminInfoTitle);
		
		JLabel btn_adminInfoAdd1 = new JLabel(checkIcon);
		btn_adminInfoAdd1.setHorizontalAlignment(SwingConstants.LEFT);
		btn_adminInfoAdd1.setBounds(10, 55, 40, 40);
		btn_adminInfoAdd1.setOpaque(false);
		adminInfoPanel.add(btn_adminInfoAdd1);
		
		
		JLabel btn_adminInfoAdd2 = new JLabel("���� �߰�");
		btn_adminInfoAdd2.setForeground(MyColor.SMOOTHBLACK);
		btn_adminInfoAdd2.setFont(new Font("���� ���", Font.PLAIN, 13));
		btn_adminInfoAdd2.setHorizontalAlignment(SwingConstants.LEFT);
		btn_adminInfoAdd2.setBounds(65, 62, 100, 25);
		btn_adminInfoAdd2.setOpaque(false);
		btn_adminInfoAdd2.setBorder(new LineBorder(MyColor.STEELBLUE, 2));
		adminInfoPanel.add(btn_adminInfoAdd2);
		
		JLabel btn_adminInfoDel1 = new JLabel(deleteIcon);
		btn_adminInfoDel1.setHorizontalAlignment(SwingConstants.LEFT);
		btn_adminInfoDel1.setBounds(182, 54, 40, 40);
		btn_adminInfoDel1.setOpaque(false);

		adminInfoPanel.add(btn_adminInfoDel1);
		
		
		JLabel btn_adminInfoDel2 = new JLabel("���� ����");
		btn_adminInfoDel2.setForeground(MyColor.SMOOTHBLACK);
		btn_adminInfoDel2.setFont(new Font("���� ���", Font.PLAIN, 13));
		btn_adminInfoDel2.setHorizontalAlignment(SwingConstants.LEFT);
		btn_adminInfoDel2.setBounds(235, 62, 100, 25);
		btn_adminInfoDel2.setOpaque(false);
		btn_adminInfoDel2.setBorder(new LineBorder(MyColor.STEELBLUE, 2));
		adminInfoPanel.add(btn_adminInfoDel2);
	
		this.setVisible(true);
		
	}
	
	

	private class JFrameWindowClosingEventHandler extends WindowAdapter { //â �ݱ��
		public void windowClosing(WindowEvent e) {
			if(e.getWindow() instanceof LoginGUI) { //Ȩ ȭ�� ������
				System.exit(0); //���α׷� ����
			}	
		}
	}
	
}
