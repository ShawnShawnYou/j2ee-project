package service;

import java.util.List;

import dao.ApplicantDao;
import entity.Applicant;
import entity.Stuff;
import entity.Vehicle;

public class ApplicantService {

	private ApplicantDao appDao;

	public ApplicantService() {
		appDao = new ApplicantDao();
	}

	public Applicant srhByOne(int id) {
		return appDao.srhByOne(id);
	}
	
	public int  repass(Applicant app) {
		return appDao.repass(app);
	}
	
	public String srhpass(String user) {
		return appDao.srhpass(user);
	}

	public String srhFirstname(String user) {
		return appDao.srhFirstname(user);

	}

	public int add(Applicant app) {
		return appDao.add(app);
	}
	
	public int add_order(Applicant app) {
		return appDao.add_order(app);
	}

	public int update_order(Applicant app) {
		return appDao.update_order(app);
	}

	public List<Applicant> srhAll(int pageNo) {
		return appDao.srhAll(pageNo);
	}

	public int getAll() {
		return appDao.getCount();
	}
	
	public int getAll_dingdan() {
		return appDao.getCount_dingdan();
	}
	
	public int delete(String user_name) {
		return appDao.delete(user_name);
	}

	public List<Applicant> srhAll_dingdan(int pageNo) {
		
		return appDao.srhAll_dingdan(pageNo);
	}

	public List<Applicant> srhAll_dingdanall(int i) {
		
		return appDao.srhAll_dingdanall(i);
	}

	public int delete_dingdan(int id) {return appDao.delete_dingdan(id);}

	// 车辆管理
	public int add_vehicle(Vehicle vehicle) {return appDao.add_vehicle(vehicle);}

	public int update_vehicle(Vehicle vehicle) {return appDao.update_vehicle(vehicle);}

	public int delete_vehicle(int id) {return appDao.delete_vehicle(id);}

	public List<Vehicle> get_vehicle(int pageNo) {return appDao.get_vehicle(pageNo);}

	public int get_all_vehicle_count() {return appDao.get_all_vehicle_count();}

	public List<Vehicle> get_all_vehicle() {
		return appDao.get_all_vehicle();
	}

	//增加员工
	public int add_stuff(Stuff stuff) {return appDao.addAStuff(stuff);}

	public int update_stuff(Stuff stuff) {return appDao.updateAStuffbyNumber(stuff);}

	public List<Stuff> get_all_stuff(){
		return appDao.get_all_stuff();
	}

	public int get_all_stuff_count() {return appDao.get_all_stuff_count();}

	public int delete_stuff(String stuff_number) {return appDao.deleteAStuffbyNumber(stuff_number);};
}
