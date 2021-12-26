package db;

import java.sql.*;


//��������������ӵ����ݿ�
public class SQLDB {
	private String driverName = "com.mysql.jdbc.Driver";
	private String dbURL = "jdbc:mysql://localhost:3306/datadb?useSSL=false&characterEncoding=utf-8&serverTimezone=GMT&autoReconnect=true&failOverReadOnly=false";
	private Connection dbConn = null;
	public PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String user = "root";
	private String pass = "root";

	public SQLDB() { // ���췽���������ݿ����ӡ�һ�������������ݿ⽨������
		 this.getConnection();
	}

	public void getConnection() {
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("�������ݿ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("����ʧ��");
		}
	}

	public static void main(String[] args) {
		SQLDB sq = new SQLDB();
		sq.getConnection();
		System.out.println("=====================");

//		String sql="select count(*) from user_pass";
//		sq.getAll(sql);

	}


	public void close() { // �����ر����ݿ����
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (dbConn != null) {
				dbConn.close();
				dbConn = null;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public ResultSet search(String sql, Object... obj) {
		// ʵ�ִ������Ĳ�ѯ
		try {
			 stmt = dbConn.prepareStatement(sql);
			if (obj != null) {
				int len = obj.length;
				for (int i = 0; i < len; i++) {
					stmt.setObject(i + 1, obj[i]);
				}
			}
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}
		return rs;
	}

	public int getAll(String sql) {
		int result = -1;
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	// ��ɾ��ͨ�÷���      insert delete update����һ������
	public int update(String sql, Object... obj) {
		int result = -1;
		try {
			stmt = dbConn.prepareStatement(sql);
			if (obj != null) {
				int len = obj.length;
				for (int i = 0; i < len; i++) {
					stmt.setObject(i + 1, obj[i]);
				}
			}
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
