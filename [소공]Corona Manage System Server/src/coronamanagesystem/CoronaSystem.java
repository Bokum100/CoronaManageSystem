//Front: �����
//Back: �����
//Last Update : 20.11.23
//Des: ����Ʈ���� ���� �ڷγ� ���� �ľ� �� ��ȸ �ý����� ���� �κ�

package coronamanagesystem;

import coronamanagesystem.userinterface.LoginGUI;
import network.MyDatabase;
import network.RmiServer;

public class CoronaSystem {

	public static MyDatabase database = new MyDatabase(); //�����ͺ��̽� ��ſ� ��ü ����
	
	public static void main(String[] args) {
		LoginGUI home = new LoginGUI();
		
		//new HomeGUI();
		
		//new AdminInfoAddGUI();
		
		//new AdminInfoDeleteGUI();
		
		//new InformationAdd();
		
		//new CoronaMapAdd();
		
		RmiServer rmiServer = new RmiServer(); //���� ����
	}
	
}
