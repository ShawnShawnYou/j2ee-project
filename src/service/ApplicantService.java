package service;

import java.util.List;

import dao.ApplicantDao;
import entity.Applicant;

public class ApplicantService {

	private ApplicantDao appDao;

	public ApplicantService() {
		appDao = new ApplicantDao();
	}

//	public Applicant srhByOne(int id) {
//		return appDao.srhByOne(id);
//	}
	
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
}
