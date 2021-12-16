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
		System.out.println("订单操作============");
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
		//存在问题无法获取该值。已解决，页面跳转的时候链接问题
		System.out.println("==========="+pageNo);
		//需要注意的是，页面跳转后的数据是从输入的时候获取pageNo，但是实在有该数据之前就会实现跳转，且默认是从第一页的开始，将pafeNo的默认值设置为1
		if (pageNo==null) {
			pageNo ="1";
		}
		a = (pageNo.equals("")) ? 1 : Integer.parseInt(pageNo) ;
		request.getSession().setAttribute("now_page", a);
		List<Vehicle> list = applicantService.get_vehicle(a);
		//list有值，不为空。
		System.out.println("=============" + list);
		request.getSession().setAttribute("list1", list);

		// 参数传递到显示页 all1，pages_dingdan变量值后续添加
		ApplicantService appService = new ApplicantService();
		
		int a_dd = appService.get_all_vehicle_count();
		request.setAttribute("all1", a_dd);
		if (a_dd % 6 != 0) {//处于第几页
			request.getSession().setAttribute("pages_dingdan", (a_dd/ 6 + 1));
		} else {
			request.getSession().setAttribute("pages_dingdan", a_dd/ 6);
		}
		
		
	}
}
