//Front: �����
//Back: �����
//Last Update: 20.11.22
//Des: �����ͺ��̽� ��ſ�

package network;

import java.sql.*;

public class MyDatabase { //�����ͺ��̽� ��ſ�
	
	String url = "jdbc:mysql://127.0.0.1:3306/coronaDB?serverTimezone=Asia/Seoul"; //������ ���̽� �ּ�
	String rootId = "root"; //��Ʈ id
	String rootPw = "6789"; //��Ʈ pw
	Connection con; //�����ͺ��̽� ��ſ�
	Statement stmt; //�����ͺ��̽� ��� ���ؿ뤷
	
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
	
	public String[] getUserInfo(String id) { //UserInfo(����� ���� ���̺�)���� ID���� �̿��Ͽ� ����(�̸�, ����ó, �г���) �ҷ���
		String args[] = new String[3];
		try {
			ResultSet result = stmt.executeQuery("SELECT * FROM UserInfo where ID = '"+id+"'");
			if(!result.next()) return null;
			args[0] = result.getString("�̸�");
			args[1] = result.getString("����ó");
			args[2] = result.getString("�г���");
		} catch (SQLException e) {		
			args = null;
			e.printStackTrace();
		}
		return args;
	}
	
	public String[] getPatientInfo(String id) { //coronicInfo(����� ���� ���̺�)���� ȯ�� ID���� �̿��Ͽ� ������ �ҷ���
        String args[] = new String[7];
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM coronicInfo where ID = '"+id+"'");//����� ȯ�� ���̵��
            if(!result.next()) return null;
            args[0] = result.getString("�̸�");
            args[1] = result.getString("����");
            args[2] = result.getString("����");
            args[3] = result.getString("������");
            args[4] = result.getString("��");
            args[5] = result.getString("��");
            args[6] = result.getString("��");
        } catch (SQLException e) {
            args = null;
            e.printStackTrace();
        }
        return args;
    }
	
	public boolean insertUserInfo(String id, String name, String telNum, String nickName) { //UserInfo(����� ���� ���̺�) ���ο� �� ���� �Ǵ� ����
		try {
			String userInfo[] = getUserInfo(id);
			if(userInfo == null) {
				stmt.executeUpdate("INSERT INTO USERINFO VALUES ('"+id+"','"+name+"','"+telNum+"','"+nickName+"')");
			} else {
				stmt.executeUpdate("UPDATE USERINFO SET �̸� = '"+name+"', ����ó = '"+telNum+"', �г��� = '"+nickName+"' WHERE ID = '"+id+"'");
			}
			return true;
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	
	public boolean editInformation(String id, String name, int age, String address, Date date) { //UserInfo(����� ���� ���̺�) ���ο� �� ���� �Ǵ� ����
		try {
			ResultSet result = stmt.executeQuery("SELECT PW FROM CoronicInfo where ID = '"+id+"'");
			if(!result.next()) return false;
			name = result.getString("name");
			age = result.getInt("age");
			address = result.getString("address");
			date = result.getDate("date");
			return true;
		} catch (SQLException ex) {		
			System.err.println("SQLException: " + ex.getMessage());
		}
		return false;
	}
	public String getName_Info(String id) { //ID���� �̿��Ͽ� CoronicInfo���� name �޾ƿ�
		String name = null;
		try {
			ResultSet result = stmt.executeQuery("SELECT name FROM CoronicInfo where coronicID = '"+id+"'");
			if(!result.next()) return null;
			name = result.getString("name");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return name;
	}
	public String getAge_Info(String id) { //ID���� �̿��Ͽ�CoronicInfo���� age �޾ƿ�
		String age = null;
		try {
			ResultSet result = stmt.executeQuery("SELECT age FROM CoronicInfo where coronicID = '"+id+"'");
			if(!result.next()) return null;
			age = result.getString("age");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return age;
	}
	public String getGender_Info(String id) { //ID���� �̿��Ͽ� CoronicInfo���� gender �޾ƿ�
		String gender = null;
		try {
			ResultSet result = stmt.executeQuery("SELECT gender FROM CoronicInfo where coronicID = '"+id+"'");
			if(!result.next()) return null;
			gender = result.getString("gender");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return gender;
	}
	public String getAddress_Info(String id) { //ID���� �̿��Ͽ�  CoronicInfo���� Address �޾ƿ�
		String address = null;
		try {
			ResultSet result = stmt.executeQuery("SELECT address FROM CoronicInfo where coronicID = '"+id+"'");
			if(!result.next()) return null;
			address = result.getString("address");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return address;
	}

	
	
}
