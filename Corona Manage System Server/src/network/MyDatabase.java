//Front: �����
//Back: �����
//Last Update: 20.11.22
//Des: �����ͺ��̽� ��ſ�

package network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MyDatabase { //�����ͺ��̽� ��ſ�
	
	private String url = "jdbc:mysql://127.0.0.1:3306/coronaDB?serverTimezone=Asia/Seoul"; //������ ���̽� �ּ�
	private String rootId = "root"; //��Ʈ id
	private String rootPw = "6789"; //��Ʈ pw
	private Connection con; //�����ͺ��̽� ��ſ�
	private Statement stmt; //�����ͺ��̽� ��� ���ؿ뤷
	
	public MyDatabase() { //���� �� �ʱ�ȭ
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			e.printStackTrace();
			return;
		} 
		try {
			con = DriverManager.getConnection(url, rootId, rootPw); //������ ���̽� �α���
			stmt = con.createStatement();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	
	public String getPassword(String id) { //ID���� �̿��Ͽ� AdminInfo(�������� ���̺�)���� PW �޾ƿ�
		String pw = null;
		try {
			ResultSet result = stmt.executeQuery("SELECT PW FROM AdminInfo where ID = '"+id+"'");
			if(!result.next()) return null;
			pw = result.getString("pw");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return pw;
	}
	
	public String getAdminName(String id) { //ID���� �̿��Ͽ� AdminInfo(�������� ���̺�)����  ���θ� �޾ƿ�
		String adminName = null;
		try {
			ResultSet result = stmt.executeQuery("SELECT AdminName FROM AdminInfo where ID = '"+id+"'");
			if(!result.next()) return null;
			adminName = result.getString("adminName");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return adminName;
	}
	
	public boolean insertAdminInfo(String id, String pw, String adminName) { //AminInfo(�α������� ���̺�)�� ���ο� ID,PW, AdminName���� �Ǵ� PW�� ����
		try {
			String chekcpw = getPassword(id); //�̹� ���̵� �����ϴ��� Ȯ���ϱ� ����
			if(chekcpw == null) { //������ϸ�
				stmt.executeUpdate("INSERT INTO AdminInfo VALUES ('"+id+"','"+pw+"','"+adminName+"')");
			} else {
				stmt.executeUpdate("UPDATE AdminInfo SET PW = '"+pw+"' WHERE ID = '"+id+"'");
				stmt.executeUpdate("UPDATE AdminInfo SET AdminName = '"+adminName+"' WHERE ID = '"+id+"'");
			}
			return true;
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	
	public boolean deleteAdminInfo(String id) {
		try {
			stmt.executeUpdate("DELETE From AdminInfo WHERE ID = '"+id+"'");
			return true;
		}catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	
	public String[] getCoronicInfo(String id) { //coronicInfo(����� ���� ���̺�)���� ȯ�� ID���� �̿��Ͽ� ������ �ҷ���
        String args[] = new String[5];
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM coronicInfo where coronicID = '"+id+"'");//����� ȯ�� ���̵��
            if(!result.next()) return null;
            args[0] = result.getString("name");
            args[1] = result.getString("age");
            args[2] = result.getString("gender");
            args[3] = result.getString("address");
            args[4] = result.getString("date");
        } catch (SQLException e) {
            args = null;
            e.printStackTrace();
        }
        return args;
    }

	public boolean editCoronicInfo(String id, String name, String age, String gender, String address, String date) { // UserInfo(�����
		// ����
		// ���̺�)
		// ���ο�
		// ��
		// ����
		// �Ǵ�
		// ����
		try {
			stmt.executeUpdate("UPDATE coronicInfo SET name= '" + name + "' WHERE coronicID = '" + id + "'");
			stmt.executeUpdate("UPDATE coronicInfo SET age = '" + age + "' WHERE coronicID = '" + id + "'");
			stmt.executeUpdate("UPDATE coronicInfo SET gender = '" + gender + "' WHERE coronicID = '" + id + "'");
			stmt.executeUpdate("UPDATE coronicInfo SET address = '" + address + "' WHERE coronicID = '" + id + "'");
			stmt.executeUpdate("UPDATE coronicInfo SET date = '" + date + "' WHERE coronicID = '" + id + "'");
			return true;
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	
	public boolean insertCoronicInfo(String coronicId, String name, String age, String gender, String address,
			String date) { // MapInfo�� ���� ����
		try {
			stmt.executeUpdate("INSERT INTO CoronicInfo VALUES ('" + coronicId + "','" + name + "','" + age + "','"
					+ gender + "','" + address + "','" + date + "')");
			return true;
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	
	public boolean insertCoronaMapInfo(String date, String time, String latitude, String longitude, String detail,
			String coronicId, String address) { // MapInfo�� ���� ����
		try {
			stmt.executeUpdate("INSERT INTO CoronaMap VALUES ('" + date + "','" + time + "','" + latitude + "','"
					+ longitude + "','" + detail + "','" + coronicId + "','"+ address +"')");
			return true;
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	
	public boolean updateCoronicInfo(String coronicId, String name, String age, String gender, String address, String date) {
		try {
			stmt.executeUpdate("UPDATE CoronicInfo SET name = '"+name+"' WHERE coronicId = '"+coronicId+"'");
			stmt.executeUpdate("UPDATE CoronicInfo SET age = '"+age+"' WHERE coronicId = '"+coronicId+"'");
			stmt.executeUpdate("UPDATE CoronicInfo SET gender = '"+gender+"' WHERE coronicId = '"+coronicId+"'");
			stmt.executeUpdate("UPDATE CoronicInfo SET address = '"+address+"' WHERE coronicId = '"+coronicId+"'");
			stmt.executeUpdate("UPDATE CoronicInfo SET date = '"+date+"' WHERE coronicId = '"+coronicId+"'");
			return true;
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	
	public String getMaxId() {
		int i;
		String insertId;
		insertId = "1";
		while(true) {
			if(getCoronicInfo(insertId)==null)
				break;
			i = Integer.parseInt(insertId);
			i++;
			insertId = Integer.toString(i);
		}
		return insertId;
	}

	public ArrayList<String[]> getAllCoronaMapInfo(){
		ArrayList<String[]> coronaMapData = new ArrayList<String[]>();
		
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM coronaMap");//��� ���� ��ȸ
            while(result.next()) {
                String args[] = new String[7];
                args[0] = result.getString("date");
                args[1] = result.getString("time");
                args[2] = result.getString("place_latitude");
                args[3] = result.getString("place_longitude");
                args[4] = result.getString("detail");
                args[5] = result.getString("coronicid");
                args[6] = result.getString("address");
                coronaMapData.add(args);
            };          
        } catch (SQLException e) {
        	coronaMapData = null;
            e.printStackTrace();
        }
        return coronaMapData;
	}
	
	public ArrayList<String[]> getAllCoronicInfo(){
		ArrayList<String[]> coronicData = new ArrayList<String[]>();
		
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM coronicInfo");//��� ���� ��ȸ
            while(result.next()) {
                String args[] = new String[5];
                args[0] = result.getString("coronicId");
                //args[1] = result.getString("name"); //���� �̸��� ������ ���� ����
                args[1] = result.getString("age");
                args[2] = result.getString("gender");
                args[3] = result.getString("address");
                args[4] = result.getString("date");        
                coronicData.add(args);
            };          
        } catch (SQLException e) {
        	coronicData = null;
            e.printStackTrace();
        }
        return coronicData;
	}
	
	public boolean deleteCoronaInfo(String date, String time, String id) {
		try {
			stmt.executeUpdate("DELETE From coronaMap WHERE coronicId = '"+id+"' and date = '"+date+"' and time = '"+time+"'");
			return true;
		}catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	
	public LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> getAreaInfo() { //��ü ������� ���, <(��) , <(��),(��)>> 
		LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> areaList = new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>(); //hashmap�� ����, list�� �� ������ ���׵�
		try {
			ResultSet result = stmt.executeQuery("SELECT distinct city FROM areainfo"); //���ø�� ���
			if(!result.next()) return null; 
			do { //������ ���� �̸��� areaList�� Ű�μ� ����
				String cityName = result.getString("city");
				areaList.put(cityName, new LinkedHashMap<String, ArrayList<String>>()); //���� ��, �� ���� �������
			}while(result.next());
			
			for(String cityName : areaList.keySet()) { //�� �����̸����� ���׸� ��ȸ�� ����
				LinkedHashMap<String, ArrayList<String>> townList = areaList.get(cityName); //�� �̸��� ���� �ʾ��
				ResultSet rs = stmt.executeQuery("SELECT distinct town FROM areainfo where city = '"+cityName+"'"); //�� ��� ��� 
				while(rs.next()) {
					String townName = rs.getString("town");
					townList.put(townName, new ArrayList<String>()); //�ش� ���� ��,�� �ʿ� �ֱ�, �� ����Ʈ�� �������
					
					ArrayList<String> sareaList = townList.get(townName); //�� �̸��� ���� ����Ʈ���
					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery("SELECT sarea FROM areainfo where city = '"+cityName+"'" 
							+ " and " + "town = '" + townName + "'"); //��, �� �̸��� ���� �� ��� ���
					while(rs2.next()) {
						String sarea = rs2.getString("sarea").trim();
						sareaList.add(sarea);
					}
					
				}
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		return areaList.size() == 0 ? null : areaList; //areaList�� ��������� null ��ȯ
	}
	
	
}
