package CoronaSystem;

import CoronaSystem.UserInterface.HomeGUI;
import Network.RmiServer;

public class CoronaSystem {

	public static void main(String[] args) {
		RmiServer rmiServer = new RmiServer(); //���� ����
		HomeGUI home = new HomeGUI();
	}
	
}
