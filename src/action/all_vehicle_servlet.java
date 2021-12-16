package action;

import entity.Applicant;
import entity.Vehicle;
import service.ApplicantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/all_vehicle_servlet")
public class all_vehicle_servlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		get_page_vehicle(request, response);
		System.out.println("��������============");
		request.getRequestDispatcher("vehicle_manage.jsp").forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	private void get_page_vehicle(HttpServletRequest request, HttpServletResponse response) {
		ApplicantService applicantService = new ApplicantService();
		
		int a = 1;
		System.out.println("===========1111=====");
		
		//int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		String pageNo = request.getParameter("pageNo");
		//���������޷���ȡ��ֵ���ѽ����ҳ����ת��ʱ����������
		System.out.println("==========="+pageNo);
		//��Ҫע����ǣ�ҳ����ת��������Ǵ������ʱ���ȡpageNo������ʵ���и�����֮ǰ�ͻ�ʵ����ת����Ĭ���Ǵӵ�һҳ�Ŀ�ʼ����pafeNo��Ĭ��ֵ����Ϊ1
		if (pageNo==null) {
			pageNo ="1";
		}
		a = (pageNo.equals("")) ? 1 : Integer.parseInt(pageNo) ;
		request.getSession().setAttribute("now_page", a);
		List<Vehicle> list = applicantService.get_vehicle(a);
		//list��ֵ����Ϊ�ա�
		System.out.println("=============" + list);
		request.getSession().setAttribute("list1", list);

		// �������ݵ���ʾҳ all1��pages_dingdan����ֵ�������
		ApplicantService appService = new ApplicantService();
		
		int a_dd = appService.get_all_vehicle_count();
		request.setAttribute("all1", a_dd);
		if (a_dd % 6 != 0) {//���ڵڼ�ҳ
			request.getSession().setAttribute("pages_dingdan", (a_dd/ 6 + 1));
		} else {
			request.getSession().setAttribute("pages_dingdan", a_dd/ 6);
		}
		
		
	}
}
