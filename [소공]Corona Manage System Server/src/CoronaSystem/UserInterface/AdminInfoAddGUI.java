package CoronaSystem.UserInterface;

import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.AbstractBorder;

import Addon.BubbleBorder;
import Addon.MyColor;
import Addon.MyUtility;

public class AdminInfoAddGUI extends JFrame{

	private int frameWidth = 600;
	private int frameHeight = 400;
	
	public AdminInfoAddGUI() {
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit(); //������� ȭ�� ũ�Ⱚ�� ������� ��Ŷ Ŭ����
		
		setSize(frameWidth,frameHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("������ �߰�");
		getContentPane().setBackground(MyColor.ALICEBLUE);
		getContentPane().setLayout(null);

		// �ձ� �𼭸�
		AbstractBorder brdr = new BubbleBorder(Color.BLACK, 2, 16, 0);

		// ���ҽ� �̸� �ҷ�����
		URL src = LoginGUI.class.getResource("/resources/check.png");
		ImageIcon checkIcon = MyUtility.resizeImage(new ImageIcon(src), 70, 70);
	}
	
}
