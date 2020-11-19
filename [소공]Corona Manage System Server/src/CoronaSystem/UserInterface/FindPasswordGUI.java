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

public class FindPasswordGUI extends JFrame{
	
	private int frameWidth = 300;
	private int frameHeight = 200;

	public FindPasswordGUI() {
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit(); //������� ȭ�� ũ�Ⱚ�� ������� ��Ŷ Ŭ����
		
		setSize(frameWidth,frameHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("�ڷγ� ���� �ý���");
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(MyColor.ALICEBLUE);
		
		//�ձ� �𼭸�
		AbstractBorder brdr = new BubbleBorder(Color.BLACK,2,16,0);
		
		//���ҽ� �̸� �ҷ�����
		URL finderSrc = LoginGUI.class.getResource("/resources/finder.png");
		ImageIcon finderIcon = MyUtility.resizeImage(new ImageIcon(finderSrc), 70, 70);
		
	}
	
}
