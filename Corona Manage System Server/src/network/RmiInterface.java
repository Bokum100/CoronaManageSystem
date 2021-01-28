//Front: �����
//Back: �����
//Last Update : 20.11.20
//RMI ��� �������̽�

package network;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface RmiInterface {
    
    public boolean checkConnection();
    
    public ArrayList<String[]> requestCoronaMapData(); //��� �ڷγ� ���� ������
    //0. date, 1.time, 2.latitude, 3.logitude, 4.detail, 5coronicId
    
    public ArrayList<String[]> requestCoronicData(); //��� Ȯ���� ������
    
    public ArrayList<String[]> requestCoronicDataFromDate(String date); //date�� [2020-01-11] ���� ���ڿ� ����
    
    public ArrayList<String[]> requestCoronicDataFromAddress(String address); //address�� [��⵵ �Ⱦ�õ��ȱ� �Ⱦ�1��] ���� ���ڿ� ����
    
    public ArrayList<String[]> requestCoronaMapDataFromId(String coronicId); //coronidID �� ���� ���ڿ���
    
    public LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> requestAreaData();
}
