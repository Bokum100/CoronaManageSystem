//Front: �����
//Back: �����
//Last Update : 20.11.23
//Des: ����Ʈ���� ���� �ڷγ� ���� �ľ� �� ��ȸ �ý����� ���� �κ�

package CoronaSystem;

import CoronaSystem.UserInterface.LoginGUI;
import Network.MyDatabase;
import Network.RmiServer;

public class CoronaSystem {

	public static MyDatabase database = new MyDatabase();
	
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
