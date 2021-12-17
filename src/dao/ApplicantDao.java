package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.SQLDB;
import entity.Applicant;
import entity.Stuff;
import entity.Vehicle;
import service.ApplicantService;

public class ApplicantDao {

	public String srhpass(String user) { // 使用该方法查询密码，从传入账号，再返回再数据库中的密码。
		SQLDB db = new SQLDB();
		String sql = "select pass from user_pass where usernumber =?";
		String password1 = null;
		try {
			ResultSet rs1 = db.search(sql, user);
			while (rs1.next()) {
				Applicant t = new Applicant();
				password1 = rs1.getString(1);
				t.setMima(password1);
			}
			rs1.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password1;
	}

	public String srhFirstname(String user) { // 使用该方法查询密码，从传入账号，再返回再数据库中的名。
		SQLDB db = new SQLDB();
		String sql = "select Firstname from user_pass where user_name =?";
		String Firstname = null;
		try {
			ResultSet rs1 = db.search(sql, user);
			while (rs1.next()) {
				Applicant t = new Applicant();
				Firstname = rs1.getString(1);
				t.setFirstname(Firstname);
			}
			rs1.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Firstname;
	}

	public String srhLastname(String user) { // 使用该方法查询密码，从传入账号，再返回再数据库中的姓。
		SQLDB db = new SQLDB();
		String sql = "select Lastname from user_pass where user_name =?";
		String Lastname = null;
		try {
			ResultSet rs1 = db.search(sql, user);
			while (rs1.next()) {
				Applicant t = new Applicant();
				Lastname = rs1.getString(1);
				t.setFirstname(Lastname);
			}
			rs1.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Lastname;
	}

	public String srhaddr(String user) { // 使用该方法查询密码，从传入账号，再返回再数据库中的姓。
		SQLDB db = new SQLDB();
		String sql = "select addr from user_pass where user_name =?";
		String addr = null;
		try {
			ResultSet rs1 = db.search(sql, user);
			while (rs1.next()) {
				Applicant t = new Applicant();
				addr = rs1.getString(1);
				t.setFirstname(addr);
			}
			rs1.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addr;
	}

	// 添加个人用户信息
	public int add(Applicant app) {
		SQLDB db = new SQLDB();
		String sql = "insert into user_pass (user_name,"+" pass,"+"Firstname,"+"Lastname,"+"addr"+")values(?,?,?,?,?)";
		Object[] obj = { app.getZhanghao(), app.getMima(), app.getFirstname(), app.getLastname(), app.getAddr()};
		//打印参数，判断是否可以获取值，System.out.println(obj[0]);System.out.println(obj[1]);System.out.println(obj[2]);System.out.println(obj[3]);System.out.println(obj[4]);
		return db.update(sql, obj);
	}
	//添加订单信息
	public int add_order(Applicant app) {
		SQLDB db = new SQLDB();
		String sql = "insert into t_dingdan (goods_name,"+"goods_number,"+"goods_baozhuang,"+"goods_weight,"+"goods_volume,"+"fahuo_person,"+"shouhuo_person,"+"fahuo_date,"+"fahuo_addr,"+"shouhuo_addr,"+"tuoyun_money,"+"shonghuo_money,"+"baoxian_money,"+"jiehuo_money,"+"pay_money,"+"pick,"+"single"+")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = { app.getGoods_name(), app.getGoods_number(), app.getGoods_baozhuang(), app.getGoods_weight(), app.getGoods_volume(),app.getFahuo_person(),app.getShouhuo_person(),app.getFahuo_date(),app.getFahuo_addr(),app.getShouhuo_addr(),app.getTuoyun_money(),app.getShonghuo_money(),app.getBaoxian_money(),app.getJiehuo_money(),app.getPay_money(),app.getPick(),app.getSingle()};
		return db.update(sql, obj);
	}

	// 添加车辆信息
	public int add_vehicle(Vehicle vehicle) {
		SQLDB db = new SQLDB();
		String sql = "insert into vehicle (location,"+"license_number,"+"type,"+"status"+") values(?,?,?,?)";
		Object[] obj = { vehicle.getLocation(), vehicle.getLicense_number(), vehicle.getType(), vehicle.getStatus()};
		return db.update(sql, obj);
	}

//	 修改车辆信息
	public int update_vehicle(Vehicle vehicle) {
		SQLDB db = new SQLDB();
		String sql = "update vehicle set location=?, license_number=?, type=?, status=? where id = ?";
		Object[] obj = {vehicle.getLocation(), vehicle.getLicense_number(), vehicle.getType(), vehicle.getStatus(), vehicle.getId()};
		return db.update(sql, obj);
	}

//	 删除车辆信息
	public int delete_vehicle(int id) {
		SQLDB db = new SQLDB();
		String sql = "delete from vehicle where id = ?";
		Object[] obj = {id};
		return db.update(sql, obj);
	}

//	 查询车辆信息
	public List<Vehicle> get_vehicle(int pageNo) {

		List<Vehicle> list = new LinkedList<Vehicle>();
		// 调用SqlHelper对象，完成查询
		SQLDB db = new SQLDB();
		String sql = "select * from vehicle limit ?, 6;";
		//查询所有信息，每一页存放6条
		try {
			ResultSet rs = db.search(sql, (pageNo - 1) * 6);
			while (rs.next()) { // 判断所取得的结果集是否为空
				// 将结果集的每一条数据保存为对象，添加到list里

				int id = rs.getInt(1);
				String location = rs.getString(2);
				String license_number = rs.getString(3);
				String type = rs.getString(4);
				int status = rs.getInt(5);

				// 将书库中的一个记录的所有字段赋值给t，把t加入集合
				Vehicle vehicle = new Vehicle(id, location, license_number, type, status);
				list.add(vehicle);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询出错。");
		}
		return list;
	}


	public int get_all_vehicle_count() {
		SQLDB db = new SQLDB();
		String sql = "select count(*) from vehicle ;";
		int result = db.getAll(sql);
		db.close();
		return result;
	}


	public List<Vehicle> get_all_vehicle() {

		List<Vehicle> list = new LinkedList<Vehicle>();
		// 调用SqlHelper对象，完成查询
		SQLDB db = new SQLDB();
		String sql = "select * from vehicle ;";
		System.out.println("sql语句后，全部数据");
		//查询所有信息，每一页存放4条
		try {
			ResultSet rs = db.search(sql);
			while (rs.next()) { // 判断所取得的结果集是否为空
				// 将结果集的每一条数据保存为对象，添加到list里

				int id = rs.getInt(1);
				String location = rs.getString(2);
				String license_number = rs.getString(3);
				String type = rs.getString(4);
				int status = rs.getInt(5);

				// 将书库中的一个记录的所有字段赋值给t，把t加入集合
				Vehicle vehicle = new Vehicle(id, location, license_number, type, status);
				list.add(vehicle);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			System.out.println("查询出错。");
		}
		return list;
	}





	//修改密码
	public int repass(Applicant app) {
		SQLDB db = new SQLDB();
		String sql = "update user_pass set pass=? where user_name = ?";
		Object[] obj = {app.getMima(),app.getZhanghao()};
		return db.update(sql, obj);
	}

	//查询所有数据
	public List<Applicant> srhAll(int pageNo) {

		List<Applicant> list = new LinkedList<Applicant>();
		// 调用SqlHelper对象，完成查询
		SQLDB db = new SQLDB();
		String sql = "select * from user_pass limit ?,6;";
		//查询所有信息，每一页存放6条
		try {
			ResultSet rs = db.search(sql, (pageNo - 1) * 6);
			while (rs.next()) { // 判断所取得的结果集是否为空
				// 将结果集的每一条数据保存为对象，添加到list里
				Applicant t = new Applicant();
				//int zh_id = rs.getInt(1); // 将结果集中第一个对象的id取到
				String zh_name = rs.getString(1);
				String zh_pass = rs.getString(2);
				String zh_firstname = rs.getString(3);
				String zh_lastname = rs.getString(4);
				String zh_addr = rs.getString(5);

				// 将书库中的一个记录的所有字段赋值给t，把t加入集合
				t.setZhanghao(zh_name);
				t.setAddr(zh_addr);
				t.setFirstname(zh_firstname);
				t.setLastname(zh_lastname);
				t.setMima(zh_pass);
				list.add(t);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询出错。");
		}
		return list;
	}

	//查询所有的数据共有的列数
	public int getCount() {
		SQLDB db = new SQLDB();
		String sql = "select count(*) from user_pass ;";
		int result = db.getAll(sql);
		db.close();
		return result;
	}

	public int getCount_dingdan() {
		SQLDB db = new SQLDB();
		String sql = "select count(*) from t_dingdan ;";
		int result = db.getAll(sql);
		db.close();
		return result;
	}

	public int delete(String user_name) {		//根据user_name进行删除
		SQLDB db = new SQLDB();
		String sql = "delete from user_pass where user_name =? ;";
		Object[] obj = { user_name };
		return db.update(sql, obj);
	}


	public Applicant srhByOne(int id) {
		SQLDB db = new SQLDB();
		String sql = "select * from user_pass where id = ?";
		Object[] obj = { id };
		Applicant t = null;
		try {
			ResultSet rs = db.search(sql, obj);
			rs.next();
			t = new Applicant();
			int aid = rs.getInt(1); // 将结果集中第一个对象的id取到
			String sone_zhanghao = rs.getString(2);
			String sone_mima = rs.getString(3);
			String sone_firstname = rs.getString(4);
			String sone_lastname = rs.getString(5);
			String sone_addr = rs.getString(6);
			// 将书库中的一个记录的所有字段赋值给t，把t加入集合
			t.setId(aid);
			t.setZhanghao(sone_zhanghao);
			t.setMima(sone_mima);
			t.setFirstname(sone_firstname);
			t.setLastname(sone_lastname);
			t.setAddr(sone_addr);
			db.close();
		} catch (Exception e) {
			System.out.println("查询出错。");
		}
		return t;
	}


	public List<Applicant> srhAll_dingdan(int pageNo) {

		List<Applicant> list = new LinkedList<Applicant>();
		// 调用SqlHelper对象，完成查询
		SQLDB db = new SQLDB();
		String sql = "select * from t_dingdan limit ?,4;";
		System.out.println("sql语句后，分页查询");
		//查询所有信息，每一页存放4条
		try {
			ResultSet rs = db.search(sql, (pageNo - 1) * 4);
			while (rs.next()) { // 判断所取得的结果集是否为空
				// 将结果集的每一条数据保存为对象，添加到list里
				Applicant tding = new Applicant();
				int td_id=rs.getInt(1);
				String goods_name = rs.getString(2); // 将结果集中第一个对象的id取到
				String goods_number = rs.getString(3);
				String goods_baozhuang = rs.getString(4);
				String goods_weight = rs.getString(5);
				String goods_volume = rs.getString(6);
				String fahuo_person = rs.getString(7);
				String shouhuo_person=rs.getString(8);
				Date fahuo_date=rs.getDate(9);
				String fahuo_addr=rs.getString(10);
				String shouhuo_addr=rs.getString(11);
				String tuoyun_money=rs.getString(12);
				String shonghuo_money=rs.getString(13);
				String baoxian_money=rs.getString(14);
				String jiehuo_money=rs.getString(15);
				String pay_money=rs.getString(16);
				String pick=rs.getString(17);
				String single= rs.getString(18);
				// 将书库中的一个记录的所有字段赋值给tding，把tding加入集合
				tding.setTd_id(td_id);
				tding.setGoods_name(goods_name);
				tding.setGoods_number(goods_number);
				tding.setGoods_baozhuang(goods_baozhuang);
				tding.setGoods_weight(goods_weight);
				tding.setGoods_volume(goods_volume);
				tding.setFahuo_person(fahuo_person);
				tding.setShouhuo_person(shouhuo_person);
				tding.setFahuo_date(fahuo_date);
				tding.setFahuo_addr(fahuo_addr);
				tding.setShouhuo_addr(shouhuo_addr);
				tding.setTuoyun_money(tuoyun_money);
				tding.setShonghuo_money(shonghuo_money);
				tding.setBaoxian_money(baoxian_money);
				tding.setJiehuo_money(jiehuo_money);
				tding.setPay_money(pay_money);
				tding.setPick(pick);
				tding.setSingle(single);
				list.add(tding);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			System.out.println("查询出错。");
		}
		return list;
	}


	public List<Applicant> srhAll_dingdanall(int i) {

		List<Applicant> list = new LinkedList<Applicant>();
		// 调用SqlHelper对象，完成查询
		SQLDB db = new SQLDB();
		String sql = "select * from t_dingdan ;";
		System.out.println("sql语句后，全部数据");
		//查询所有信息，每一页存放4条
		try {
			ResultSet rs = db.search(sql);
			while (rs.next()) { // 判断所取得的结果集是否为空
				// 将结果集的每一条数据保存为对象，添加到list里
				Applicant tding = new Applicant();
				int td_id=rs.getInt(1);
				String goods_name = rs.getString(2); // 将结果集中第一个对象的id取到
				String goods_number = rs.getString(3);
				String goods_baozhuang = rs.getString(4);
				String goods_weight = rs.getString(5);
				String goods_volume = rs.getString(6);
				String fahuo_person = rs.getString(7);
				String shouhuo_person=rs.getString(8);
				Date fahuo_date=rs.getDate(9);
				String fahuo_addr=rs.getString(10);
				String shouhuo_addr=rs.getString(11);
				String tuoyun_money=rs.getString(12);
				String shonghuo_money=rs.getString(13);
				String baoxian_money=rs.getString(14);
				String jiehuo_money=rs.getString(15);
				String pay_money=rs.getString(16);
				String pick=rs.getString(17);
				String single= rs.getString(18);
				// 将书库中的一个记录的所有字段赋值给tding，把tding加入集合
				tding.setTd_id(td_id);
				tding.setGoods_name(goods_name);
				tding.setGoods_number(goods_number);
				tding.setGoods_baozhuang(goods_baozhuang);
				tding.setGoods_weight(goods_weight);
				tding.setGoods_volume(goods_volume);
				tding.setFahuo_person(fahuo_person);
				tding.setShouhuo_person(shouhuo_person);
				tding.setFahuo_date(fahuo_date);
				tding.setFahuo_addr(fahuo_addr);
				tding.setShouhuo_addr(shouhuo_addr);
				tding.setTuoyun_money(tuoyun_money);
				tding.setShonghuo_money(shonghuo_money);
				tding.setBaoxian_money(baoxian_money);
				tding.setJiehuo_money(jiehuo_money);
				tding.setPay_money(pay_money);
				tding.setPick(pick);
				tding.setSingle(single);
				list.add(tding);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			System.out.println("查询出错。");
		}
		return list;
	}

	//添加员工
	public int addAStuff(Stuff stuff){
		//TO-DO: 需要沟通数据库中的员工表名
		//Step 1: 建立连接
		SQLDB sqldb = new SQLDB();
		//Step 2: sql语句
		String sql = "insert into stuff_tb values (?,?);";
		//Step 3：sql语句执行
		Object[] obj = {stuff.getStuffName(), stuff.getStuffNumber()};
		return sqldb.update(sql, obj);
	}

	//查找员工
	public Stuff getAStuffbyNumber(String stuffNumber) throws SQLException {
		SQLDB sqldb = new SQLDB();
		String sql = "select * from stuff_tb where stuff_number = ?;";
		Object[] obj = {stuffNumber};
		ResultSet rs = sqldb.search(sql, obj);
		return new Stuff(rs.getString(1), rs.getString(2));
	}

	//查找所有员工
	public List<Stuff> get_all_stuff() {
		List<Stuff> list = new LinkedList<Stuff>();
		// 调用SqlHelper对象，完成查询
		SQLDB db = new SQLDB();
		String sql = "select * from stuff_tb ;";
		System.out.println("sql语句后，全部数据");
		//查询所有信息，每一页存放4条
		try {
			ResultSet rs = db.search(sql);
			while (rs.next()) { // 判断所取得的结果集是否为空
				// 将结果集的每一条数据保存为对象，添加到list里

				// 将书库中的一个记录的所有字段赋值给t，把t加入集合
				Stuff stuff = new Stuff(rs.getString(1), rs.getString(2));
				list.add(stuff);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			System.out.println("查询出错。");
		}
		return list;
	}


	//修改员工信息
	public int updateAStuffbyNumber(Stuff stuff){
		SQLDB sqldb = new SQLDB();
		String sql = "update stuff_tb set stuff_name = ? where stuff_number = ?;";
		Object[] obj = {stuff.getStuffName(), stuff.getStuffNumber()};
		return sqldb.update(sql, obj);
	}

	//删除员工信息
	public int deleteAStuffbyNumber(String stuff_number){
		SQLDB sqldb = new SQLDB();
		String sql = "delete from stuff_tb where stuff_number = ?;";
		Object[] obj = {stuff_number};
		return sqldb.update(sql, obj);
	}

	public int get_all_stuff_count() {
		SQLDB db = new SQLDB();
		String sql = "select count(*) from stuff ;";
		int result = db.getAll(sql);
		db.close();
		return result;
	}

	public static void main(String[] args) {

		//测试srhAll();
//		ApplicantDao appdao = new ApplicantDao();
//		List<Applicant> all = appdao.srhAll(1);
//		for (Applicant applicant : all) {
//			System.out.println(applicant.getId());//返回数据表的id那一列的值
//		}

		//测试srhAll_dingdan
//		ApplicantDao appdao = new ApplicantDao();
//		List<Applicant> all = appdao.srhAll_dingdan(1);
//		for (Applicant applicant : all) {
//			System.out.println(applicant.getGoods_name());//返回数据表的商品名称那一列的值
//		}

		//测试delete,删除id为5的哪一条记录
//		ApplicantDao appdao= new ApplicantDao();
//		int a = appdao.delete(5);
//		System.out.println(a);

		//测试getall返回所有数据的列数
//		ApplicantDao appdao = new ApplicantDao();
//		int a=appdao.getCount();
//		System.out.println("appdao 总列数"+a);

		//测试getall_dingdan返回所有订单数据的列数
//		ApplicantDao appdao = new ApplicantDao();
//		int a=appdao.getCount_dingdan();
//		System.out.println("appdao 总列数"+a);

		//以下为测试srhpass srhFirstname,srhaddr,srhpass代码，将返回密码，
//		ApplicantDao appdao = new ApplicantDao();
//		appdao.srhpass("admin");
//		获取密码
//		System.out.println(appdao.srhpass("admin"));
//		 获取Firstname
//		 System.out.println(appdao.srhFirstname("admin"));
//		 获取Lastname
//		System.out.println(appdao.srhLastname("admin"));
//		获取addr
//		System.out.println(appdao.srhaddr("admin"));

		//下述代码用于测试add方法，即注册界面
//		ApplicantDao appdao = new ApplicantDao();
//		Applicant a =new Applicant();
//		a.setFirstname("111");
//		a.setLastname("222");
//		a.setAddr("cs");
//		a.setZhanghao("yueyuedaniao");
//		a.setMima("1836");
//		System.out.println(appdao.add(a));

		//以下代码用于测试repass方法，修改密码
//		ApplicantDao appdao =new ApplicantDao();
//		Applicant a= new Applicant();
//		a.setMima("183602");
//		a.setZhanghao("yueyueniao");
//		System.out.println("repass : "+ appdao.repass(a));
//
		//测试srhbyone，将会输出id为1的那一列数据的账号（账户）
//		ApplicantDao appdao = new ApplicantDao();
//		Applicant a = appdao.srhByOne(1);
//		System.out.println(a.getZhanghao());

		ApplicantDao appdao = new ApplicantDao();
		List<Applicant> all = appdao.srhAll_dingdanall(5);
		for (Applicant applicant : all) {
			System.out.println(applicant.getGoods_name());//返回数据表的商品名称那一列的值
		}

	}
}