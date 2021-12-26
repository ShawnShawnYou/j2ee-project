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

	public String srhpass(String user) { // ʹ�ø÷�����ѯ���룬�Ӵ����˺ţ��ٷ��������ݿ��е����롣
		SQLDB db = new SQLDB();
		String sql = "select pass from user_pass where user_name =?";
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

	public String srhFirstname(String user) { // ʹ�ø÷�����ѯ���룬�Ӵ����˺ţ��ٷ��������ݿ��е�����
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

	public String srhLastname(String user) { // ʹ�ø÷�����ѯ���룬�Ӵ����˺ţ��ٷ��������ݿ��е��ա�
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

	public String srhaddr(String user) { // ʹ�ø÷�����ѯ���룬�Ӵ����˺ţ��ٷ��������ݿ��е��ա�
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

	// ��Ӹ����û���Ϣ
	public int add(Applicant app) {
		SQLDB db = new SQLDB();
		String sql = "insert into user_pass (user_name,"+" pass,"+"Firstname,"+"Lastname,"+"addr"+")values(?,?,?,?,?)";
		Object[] obj = { app.getZhanghao(), app.getMima(), app.getFirstname(), app.getLastname(), app.getAddr()};
		//��ӡ�������ж��Ƿ���Ի�ȡֵ��System.out.println(obj[0]);System.out.println(obj[1]);System.out.println(obj[2]);System.out.println(obj[3]);System.out.println(obj[4]);
		return db.update(sql, obj);
	}
	//��Ӷ�����Ϣ
	public int add_order(Applicant app) {
		SQLDB db = new SQLDB();
		String sql = "insert into t_dingdan (goods_name,"+"goods_number,"+"goods_baozhuang,"+"goods_weight,"+"goods_volume,"+"fahuo_person,"+"shouhuo_person,"+"fahuo_date,"+"fahuo_addr,"+"shouhuo_addr,"+"tuoyun_money,"+"shonghuo_money,"+"baoxian_money,"+"jiehuo_money,"+"pay_money,"+"pick,"+"single"+")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = { app.getGoods_name(), app.getGoods_number(), app.getGoods_baozhuang(), app.getGoods_weight(), app.getGoods_volume(),app.getFahuo_person(),app.getShouhuo_person(),app.getFahuo_date(),app.getFahuo_addr(),app.getShouhuo_addr(),app.getTuoyun_money(),app.getShonghuo_money(),app.getBaoxian_money(),app.getJiehuo_money(),app.getPay_money(),app.getPick(),app.getSingle()};
		return db.update(sql, obj);
	}

	//���¶�����Ϣ
	public int update_order(Applicant app) {
		SQLDB db = new SQLDB();
		String sql = "update t_dingdan set goods_name = ?,"+"goods_number = ?,"+"goods_baozhuang = ?,"+
				"goods_weight = ?,"+"goods_volume = ?,"+"fahuo_person = ?,"+"shouhuo_person = ?,"+"fahuo_date = ?,"+
				"fahuo_addr = ?,"+"shouhuo_addr = ?,"+"tuoyun_money = ?,"+"shonghuo_money = ?,"+"baoxian_money = ?,"+
				"jiehuo_money = ?,"+"pay_money = ?,"+"pick = ?,"+"single = ?"+" where td_id = ?";
		Object[] obj = { app.getGoods_name(), app.getGoods_number(), app.getGoods_baozhuang(), app.getGoods_weight(), app.getGoods_volume(),app.getFahuo_person(),app.getShouhuo_person(),app.getFahuo_date(),app.getFahuo_addr(),app.getShouhuo_addr(),app.getTuoyun_money(),app.getShonghuo_money(),app.getBaoxian_money(),app.getJiehuo_money(),app.getPay_money(),app.getPick(),app.getSingle(),app.getTd_id()};
		return db.update(sql, obj);
	}

	//	 ɾ��������Ϣ
	public int delete_dingdan(int id) {
		SQLDB db = new SQLDB();
		String sql = "delete from t_dingdan where td_id = ?";
		Object[] obj = {id};
		return db.update(sql, obj);
	}

	// ��ӳ�����Ϣ
	public int add_vehicle(Vehicle vehicle) {
		SQLDB db = new SQLDB();
		String sql = "insert into vehicle (location,"+"license_number,"+"type,"+"status"+") values(?,?,?,?)";
		Object[] obj = { vehicle.getLocation(), vehicle.getLicense_number(), vehicle.getType(), vehicle.getStatus()};
		return db.update(sql, obj);
	}

//	 �޸ĳ�����Ϣ
	public int update_vehicle(Vehicle vehicle) {
		SQLDB db = new SQLDB();
		String sql = "update vehicle set location=?, license_number=?, type=?, status=? where id = ?";
		Object[] obj = {vehicle.getLocation(), vehicle.getLicense_number(), vehicle.getType(), vehicle.getStatus(), vehicle.getId()};
		return db.update(sql, obj);
	}

//	 ɾ��������Ϣ
	public int delete_vehicle(int id) {
		SQLDB db = new SQLDB();
		String sql = "delete from vehicle where id = ?";
		Object[] obj = {id};
		return db.update(sql, obj);
	}

//	 ��ѯ������Ϣ
	public List<Vehicle> get_vehicle(int pageNo) {

		List<Vehicle> list = new LinkedList<Vehicle>();
		// ����SqlHelper������ɲ�ѯ
		SQLDB db = new SQLDB();
		String sql = "select * from vehicle limit ?, 6;";
		//��ѯ������Ϣ��ÿһҳ���6��
		try {
			ResultSet rs = db.search(sql, (pageNo - 1) * 6);
			while (rs.next()) { // �ж���ȡ�õĽ�����Ƿ�Ϊ��
				// ���������ÿһ�����ݱ���Ϊ������ӵ�list��

				int id = rs.getInt(1);
				String location = rs.getString(2);
				String license_number = rs.getString(3);
				String type = rs.getString(4);
				int status = rs.getInt(5);

				// ������е�һ����¼�������ֶθ�ֵ��t����t���뼯��
				Vehicle vehicle = new Vehicle(id, location, license_number, type, status);
				list.add(vehicle);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯ����");
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
		// ����SqlHelper������ɲ�ѯ
		SQLDB db = new SQLDB();
		String sql = "select * from vehicle ;";
		System.out.println("sql����ȫ������");
		//��ѯ������Ϣ��ÿһҳ���4��
		try {
			ResultSet rs = db.search(sql);
			while (rs.next()) { // �ж���ȡ�õĽ�����Ƿ�Ϊ��
				// ���������ÿһ�����ݱ���Ϊ������ӵ�list��

				int id = rs.getInt(1);
				String location = rs.getString(2);
				String license_number = rs.getString(3);
				String type = rs.getString(4);
				int status = rs.getInt(5);

				// ������е�һ����¼�������ֶθ�ֵ��t����t���뼯��
				Vehicle vehicle = new Vehicle(id, location, license_number, type, status);
				list.add(vehicle);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			System.out.println("��ѯ����");
		}
		return list;
	}





	//�޸�����
	public int repass(Applicant app) {
		SQLDB db = new SQLDB();
		String sql = "update user_pass set pass=? where user_name = ?";
		Object[] obj = {app.getMima(),app.getZhanghao()};
		return db.update(sql, obj);
	}

	//��ѯ��������
	public List<Applicant> srhAll(int pageNo) {

		List<Applicant> list = new LinkedList<Applicant>();
		// ����SqlHelper������ɲ�ѯ
		SQLDB db = new SQLDB();
		String sql = "select * from user_pass limit ?,6;";
		//��ѯ������Ϣ��ÿһҳ���6��
		try {
			ResultSet rs = db.search(sql, (pageNo - 1) * 6);
			while (rs.next()) { // �ж���ȡ�õĽ�����Ƿ�Ϊ��
				// ���������ÿһ�����ݱ���Ϊ������ӵ�list��
				Applicant t = new Applicant();
				//int zh_id = rs.getInt(1); // ��������е�һ�������idȡ��
				String zh_name = rs.getString(1);
				String zh_pass = rs.getString(2);
				String zh_firstname = rs.getString(3);
				String zh_lastname = rs.getString(4);
				String zh_addr = rs.getString(5);

				// ������е�һ����¼�������ֶθ�ֵ��t����t���뼯��
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
			System.out.println("��ѯ����");
		}
		return list;
	}

	//��ѯ���е����ݹ��е�����
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

	public int delete(String user_name) {		//����user_name����ɾ��
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
			int aid = rs.getInt(1); // ��������е�һ�������idȡ��
			String sone_zhanghao = rs.getString(2);
			String sone_mima = rs.getString(3);
			String sone_firstname = rs.getString(4);
			String sone_lastname = rs.getString(5);
			String sone_addr = rs.getString(6);
			// ������е�һ����¼�������ֶθ�ֵ��t����t���뼯��
			t.setId(aid);
			t.setZhanghao(sone_zhanghao);
			t.setMima(sone_mima);
			t.setFirstname(sone_firstname);
			t.setLastname(sone_lastname);
			t.setAddr(sone_addr);
			db.close();
		} catch (Exception e) {
			System.out.println("��ѯ����");
		}
		return t;
	}


	public List<Applicant> srhAll_dingdan(int pageNo) {

		List<Applicant> list = new LinkedList<Applicant>();
		// ����SqlHelper������ɲ�ѯ
		SQLDB db = new SQLDB();
		String sql = "select * from t_dingdan limit ?,4;";
		System.out.println("sql���󣬷�ҳ��ѯ");
		//��ѯ������Ϣ��ÿһҳ���4��
		try {
			ResultSet rs = db.search(sql, (pageNo - 1) * 4);
			while (rs.next()) { // �ж���ȡ�õĽ�����Ƿ�Ϊ��
				// ���������ÿһ�����ݱ���Ϊ������ӵ�list��
				Applicant tding = new Applicant();
				int td_id=rs.getInt(1);
				String goods_name = rs.getString(2); // ��������е�һ�������idȡ��
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
				// ������е�һ����¼�������ֶθ�ֵ��tding����tding���뼯��
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
			System.out.println("��ѯ����");
		}
		return list;
	}


	public List<Applicant> srhAll_dingdanall(int i) {

		List<Applicant> list = new LinkedList<Applicant>();
		// ����SqlHelper������ɲ�ѯ
		SQLDB db = new SQLDB();
		String sql = "select * from t_dingdan ;";
		System.out.println("sql����ȫ������");
		//��ѯ������Ϣ��ÿһҳ���4��
		try {
			ResultSet rs = db.search(sql);
			while (rs.next()) { // �ж���ȡ�õĽ�����Ƿ�Ϊ��
				// ���������ÿһ�����ݱ���Ϊ������ӵ�list��
				Applicant tding = new Applicant();
				int td_id=rs.getInt(1);
				String goods_name = rs.getString(2); // ��������е�һ�������idȡ��
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
				// ������е�һ����¼�������ֶθ�ֵ��tding����tding���뼯��
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
			System.out.println("��ѯ����");
		}
		return list;
	}

	//���Ա��
	public int addAStuff(Stuff stuff){
		//TO-DO: ��Ҫ��ͨ���ݿ��е�Ա������
		//Step 1: ��������
		SQLDB sqldb = new SQLDB();
		//Step 2: sql���
		String sql = "insert into stuff_tb values (?,?);";
		//Step 3��sql���ִ��
		Object[] obj = {stuff.getStuffName(), stuff.getStuffNumber()};
		return sqldb.update(sql, obj);
	}

	//����Ա��
	public Stuff getAStuffbyNumber(String stuffNumber) throws SQLException {
		SQLDB sqldb = new SQLDB();
		String sql = "select * from stuff_tb where stuff_number = ?;";
		Object[] obj = {stuffNumber};
		ResultSet rs = sqldb.search(sql, obj);
		return new Stuff(rs.getString(1), rs.getString(2));
	}

	//��������Ա��
	public List<Stuff> get_all_stuff() {
		List<Stuff> list = new LinkedList<Stuff>();
		// ����SqlHelper������ɲ�ѯ
		SQLDB db = new SQLDB();
		String sql = "select * from stuff_tb ;";
		System.out.println("sql����ȫ������");
		//��ѯ������Ϣ��ÿһҳ���4��
		try {
			ResultSet rs = db.search(sql);
			while (rs.next()) { // �ж���ȡ�õĽ�����Ƿ�Ϊ��
				// ���������ÿһ�����ݱ���Ϊ������ӵ�list��

				// ������е�һ����¼�������ֶθ�ֵ��t����t���뼯��
				Stuff stuff = new Stuff(rs.getString(1), rs.getString(2));
				list.add(stuff);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			System.out.println("��ѯ����");
		}
		return list;
	}


	//�޸�Ա����Ϣ
	public int updateAStuffbyNumber(Stuff stuff){
		SQLDB sqldb = new SQLDB();
		String sql = "update stuff_tb set stuff_name = ? where stuff_number = ?;";
		Object[] obj = {stuff.getStuffName(), stuff.getStuffNumber()};
		return sqldb.update(sql, obj);
	}

	//ɾ��Ա����Ϣ
	public int deleteAStuffbyNumber(String stuff_number){
		SQLDB sqldb = new SQLDB();
		String sql = "delete from stuff_tb where stuff_number = ?;";
		Object[] obj = {stuff_number};
		return sqldb.update(sql, obj);
	}

	public int get_all_stuff_count() {
		SQLDB db = new SQLDB();
		String sql = "select count(*) from stuff_tb ;";
		int result = db.getAll(sql);
		db.close();
		return result;
	}

	public static void main(String[] args) {

		//����srhAll();
//		ApplicantDao appdao = new ApplicantDao();
//		List<Applicant> all = appdao.srhAll(1);
//		for (Applicant applicant : all) {
//			System.out.println(applicant.getId());//�������ݱ��id��һ�е�ֵ
//		}

		//����srhAll_dingdan
//		ApplicantDao appdao = new ApplicantDao();
//		List<Applicant> all = appdao.srhAll_dingdan(1);
//		for (Applicant applicant : all) {
//			System.out.println(applicant.getGoods_name());//�������ݱ����Ʒ������һ�е�ֵ
//		}

		//����delete,ɾ��idΪ5����һ����¼
//		ApplicantDao appdao= new ApplicantDao();
//		int a = appdao.delete(5);
//		System.out.println(a);

		//����getall�����������ݵ�����
//		ApplicantDao appdao = new ApplicantDao();
//		int a=appdao.getCount();
//		System.out.println("appdao ������"+a);

		//����getall_dingdan�������ж������ݵ�����
//		ApplicantDao appdao = new ApplicantDao();
//		int a=appdao.getCount_dingdan();
//		System.out.println("appdao ������"+a);

		//����Ϊ����srhpass srhFirstname,srhaddr,srhpass���룬���������룬
//		ApplicantDao appdao = new ApplicantDao();
//		appdao.srhpass("admin");
//		��ȡ����
//		System.out.println(appdao.srhpass("admin"));
//		 ��ȡFirstname
//		 System.out.println(appdao.srhFirstname("admin"));
//		 ��ȡLastname
//		System.out.println(appdao.srhLastname("admin"));
//		��ȡaddr
//		System.out.println(appdao.srhaddr("admin"));

		//�����������ڲ���add��������ע�����
//		ApplicantDao appdao = new ApplicantDao();
//		Applicant a =new Applicant();
//		a.setFirstname("111");
//		a.setLastname("222");
//		a.setAddr("cs");
//		a.setZhanghao("yueyuedaniao");
//		a.setMima("1836");
//		System.out.println(appdao.add(a));

		//���´������ڲ���repass�������޸�����
//		ApplicantDao appdao =new ApplicantDao();
//		Applicant a= new Applicant();
//		a.setMima("183602");
//		a.setZhanghao("yueyueniao");
//		System.out.println("repass : "+ appdao.repass(a));
//
		//����srhbyone���������idΪ1����һ�����ݵ��˺ţ��˻���
//		ApplicantDao appdao = new ApplicantDao();
//		Applicant a = appdao.srhByOne(1);
//		System.out.println(a.getZhanghao());

		ApplicantDao appdao = new ApplicantDao();
		List<Applicant> all = appdao.srhAll_dingdanall(5);
		for (Applicant applicant : all) {
			System.out.println(applicant.getGoods_name());//�������ݱ����Ʒ������һ�е�ֵ
		}

	}
}