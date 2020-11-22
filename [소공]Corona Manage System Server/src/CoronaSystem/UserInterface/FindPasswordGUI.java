//Front: 전재욱
//Back: 전재욱
//Last Update : 20.11.23
//Des: 비밀번호 찾기 기능 및 프레임창

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
	
	private int frameWidth = 350;
	private int frameHeight = 250;
	private JTextField tf_adminName;
	private JTextField tf_id;
	
	private JFrame frame; //자기 자신의 주소값
	
	private static FindPasswordGUI lastGUI; 

	public FindPasswordGUI() {
		frame = this;
		
		if(lastGUI != null) {
			try {
				lastGUI.dispose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		lastGUI = this;
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit(); //사용자의 화면 크기값을 얻기위한 툴킷 클래스
		
		setSize(frameWidth,frameHeight);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("코로나 관리 시스템");
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(MyColor.ALICEBLUE);
		
		//둥근 모서리
		AbstractBorder brdr = new BubbleBorder(Color.BLACK,2,16,0);
		
		//리소스 미리 불러오기
		URL finderSrc = FindPasswordGUI.class.getResource("/resources/finder.png");
		ImageIcon finderIcon = MyUtility.resizeImage(new ImageIcon(finderSrc), 30, 30);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(65, 10, 220, 40);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		topPanel.setBackground(MyColor.LIGHTSKY);
		topPanel.setBorder(brdr);
		
		JLabel lb_title = new JLabel("비밀번호 찾기");
		lb_title.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lb_title.setHorizontalAlignment(SwingConstants.LEFT);
		lb_title.setBounds(10, 5, 170, 30);
		lb_title.setForeground(MyColor.PLUSIANBLUE);
		topPanel.add(lb_title);
		
		JLabel lb_finderIcon = new JLabel(finderIcon);
		lb_finderIcon.setBounds(180, 5, 30, 30);
		topPanel.add(lb_finderIcon);
		
		JLabel lbl_tfDes1 = new JLabel("관리자명");
		lbl_tfDes1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
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
		lbl_tfDes2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_tfDes2.setBounds(35, 120, 55, 25);
		getContentPane().add(lbl_tfDes2);
		
		JButton btn_find = new JButton("찾기");
		btn_find.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn_find.setForeground(MyColor.WHITE);
		btn_find.setFocusPainted(false);
		btn_find.setBounds(220, 170, 100, 25);
		btn_find.setBackground(MyColor.NAVY);
		btn_find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String adminName = tf_adminName.getText();
				String id = tf_id.getText();
				findPassword(adminName, id);
			}
		});
		getContentPane().add(btn_find);
		
		setVisible(true);
	}
	
	private void findPassword(String adminName, String id) {
		String findAdminName = CoronaSystem.database.getAdminName(id); //데이터베이스에서 id 따른 어드민명 가져옴
		if(findAdminName != null && findAdminName.equals(adminName)) { //어드민 이름 일치하면
			String basePw = CoronaSystem.database.getPassword(id); //데이터베이스에서 id 따른 패스워드 가져옴
			CheckGUI checkGUI = new CheckGUI(frame, "비밀번호는 "+basePw+" 입니다.", false, true);
		} else {
			CheckGUI checkGUI = new CheckGUI(frame, "일치하는 정보가 없습니다.", false, false);
		}
	}
}
