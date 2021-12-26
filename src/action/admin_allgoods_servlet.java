package action;

import entity.Applicant;
import service.ApplicantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/admin_allgoods_servlet")
public class admin_allgoods_servlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		srhAll_dingdan(request, response);
		System.out.println("��������============");
		request.getRequestDispatcher("dingdan_admin.jsp").forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	private void srhAll_dingdan(HttpServletRequest request, HttpServletResponse response) {
		ApplicantService teachService = new ApplicantService();
		
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
		a= Integer.parseInt(pageNo) ;
		List<Applicant> list = teachService.srhAll_dingdan(a);
		//list��ֵ����Ϊ�ա�
		//System.out.println("============="+list);
		request.getSession().setAttribute("list1", list);
		// �������ݵ���ʾҳ all1��pages_dingdan����ֵ�������
		ApplicantService appService = new ApplicantService();
		
		int a_dd = appService.getAll_dingdan();
		request.setAttribute("all1",a_dd);
		if (a_dd % 4 != 0) {//���ڵڼ�ҳ		
			request.getSession().setAttribute("pages_dingdan", (a_dd/ 4 + 1));
		} else {
			request.getSession().setAttribute("pages_dingdan", a_dd/ 4);
		}
		
		
	}
}
