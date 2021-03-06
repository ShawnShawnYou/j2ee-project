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
		System.out.println("订单操作============");
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
		//存在问题无法获取该值。已解决，页面跳转的时候链接问题
		System.out.println("==========="+pageNo);
		//需要注意的是，页面跳转后的数据是从输入的时候获取pageNo，但是实在有该数据之前就会实现跳转，且默认是从第一页的开始，将pafeNo的默认值设置为1
			if (pageNo==null) {
				pageNo ="1";
			}
		a= Integer.parseInt(pageNo) ;
		List<Applicant> list = teachService.srhAll_dingdan(a);
		//list有值，不为空。
		//System.out.println("============="+list);
		request.getSession().setAttribute("list1", list);
		// 参数传递到显示页 all1，pages_dingdan变量值后续添加
		ApplicantService appService = new ApplicantService();
		
		int a_dd = appService.getAll_dingdan();
		request.setAttribute("all1",a_dd);
		if (a_dd % 4 != 0) {//处于第几页		
			request.getSession().setAttribute("pages_dingdan", (a_dd/ 4 + 1));
		} else {
			request.getSession().setAttribute("pages_dingdan", a_dd/ 4);
		}
		
		
	}
}
