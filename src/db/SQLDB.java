package db;

import java.sql.*;


//定义该类用于连接到数据库
public class SQLDB {
	private String driverName = "com.mysql.jdbc.Driver";
	private String dbURL = "jdbc:mysql://localhost:3306/datadb?useSSL=false&characterEncoding=utf-8&serverTimezone=GMT&autoReconnect=true&failOverReadOnly=false";
	private Connection dbConn = null;
	public PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String user = "root";
	private String pass = "root";

	public SQLDB() { // 构造方法调用数据库连接。一旦创建对象，数据库建立连接
		 this.getConnection();
	}

	public void getConnection() {
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("连接数据库成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("连接失败");
		}
	}

	public static void main(String[] args) {
		SQLDB sq = new SQLDB();
		sq.getConnection();
		System.out.println("=====================");

//		String sql="select count(*) from user_pass";
//		sq.getAll(sql);

	}


	public void close() { // 做完后关闭数据库操作
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
		// 实现带参数的查询
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
			System.out.println("查询失败");
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

	// 增删改通用方法      insert delete update都是一个方法
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
