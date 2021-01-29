package addon;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class MyUtility {

	//�α� ���, �Ŀ� gui�� ǥ��
	public static void printLog(String logMsg) {
		System.out.println(logMsg);
	}
	
	//�̹��� ũ�� ����
	public static ImageIcon resizeImage(ImageIcon baseIcon, int newWidth, int newHeight) {
		Image tmpImage = baseIcon.getImage();
		Image chgImage = tmpImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon chgIcon = new ImageIcon(chgImage);
		return chgIcon;
	}
	
	public static String lineSpacing(String text, int stand) { //stand �� �������� ���ڿ� ����
		String str = text; //���� �۾��� ���� �ӽ÷� str�� text ����
		if(text.length() > stand) { //���ڿ��� ���̰� 1�� ���ѹ��ڼ��� �ʰ��ߴٸ�
			List<String> tmpStr = new ArrayList<>(); //���� �۾��� ���� ���ڿ� list ����
			int i = 0; //���ڿ� ���� �۾��� ���� ����
			for(; i < text.length() - stand; i += stand) { //���� ��ȣ�� ���� ���ڿ� ������ŭ �ݺ�
				int subStart = i; //���� ��������
				int subEnd = subStart + stand; //���� ������
				tmpStr.add(text.substring(subStart, subEnd)); //������ ���ڿ��� tmpStr�� �߰�
			}
			tmpStr.add(text.substring(i, text.length())); //���� ���ڿ� ����
			str = ""; //str �ʱ�ȭ
			for(i = 0; i < tmpStr.size() - 1; i++) //tmpStr�� ����ִ� ���ڿ��� ������ ���ڿ��� ������ ���� ���� ó��
				str += tmpStr.get(i) + "<br>"; //���� ��ȣ �߰�
			str += tmpStr.get(i); //������ ���ڿ��� �߰��� �ʿ����
		}
		str = str.replaceAll("(\r|\n|\r\n|\n\r)","<br>");//�����ȣ��ȯ
		return str = "<html><body>" + str + "</body></html>"; //�� ��ȯ
	}
	
	public static boolean isAlphabet(String str) { //���ڿ��� ���� ���ĺ� Ȯ��
		if(str.matches("[a-z]") || str.matches("[A-Z]")) {
			return true;
		} else return false;
	}
	
	public static boolean isDigit(String str) { //���ڿ��� ���� ���� Ȯ��
		if(str.matches("[0-9]")) {
			return true;
		} else return false;
	}
	
	//min ~ max �� �� 1�� ��ȯ
	public static int getRandom(int min, int max) {
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
}