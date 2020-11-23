//Front: �����
//Back: �����
//Last Update: 20.11.22
//Des: �����ͺ��̽� ��ſ�

package Network;

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
	
	
}
