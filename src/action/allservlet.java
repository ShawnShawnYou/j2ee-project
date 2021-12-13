package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Applicant;
import service.ApplicantService;


@WebServlet("/allservlet")
public class allservlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		srhAll(request, response);
		request.getRequestDispatcher("users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	private void srhAll(HttpServletRequest request, HttpServletResponse response) {
		ApplicantService teachService = new ApplicantService();
		
		int a = 1;
		System.out.println("===========1111");
		
		//int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		String pageNo = request.getParameter("pageNo"); 
		//���������޷���ȡ��ֵ���ѽ����ҳ����ת��ʱ����������
		System.out.println("==========="+pageNo);
		//��Ҫע����ǣ�ҳ����ת��������Ǵ������ʱ���ȡpageNo������ʵ���и�����֮ǰ�ͻ�ʵ����ת����Ĭ���Ǵӵ�һҳ�Ŀ�ʼ����pafeNo��Ĭ��ֵ����Ϊ1
			if (pageNo==null) {
				pageNo ="1";
			}
		a= Integer.parseInt(pageNo) ;
		List<Applicant> list = teachService.srhAll(a);
		request.setAttribute("list", list);
		// �������ݵ���ʾҳ ��all��pages����ֵ������ӡ�
		ApplicantService appService = new ApplicantService();
		request.setAttribute("all", appService.getAll());
		System.out.println("=========");
		if (appService.getAll() % 6 != 0) {//���ڵڼ�ҳ
			request.setAttribute("pages", (appService.getAll() / 6 + 1));
		} else {
			request.setAttribute("pages", appService.getAll() / 6);
		}
		
		
	}
}
