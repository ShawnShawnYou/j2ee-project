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
		//存在问题无法获取该值。已解决，页面跳转的时候链接问题
		System.out.println("==========="+pageNo);
		//需要注意的是，页面跳转后的数据是从输入的时候获取pageNo，但是实在有该数据之前就会实现跳转，且默认是从第一页的开始，将pafeNo的默认值设置为1
			if (pageNo==null) {
				pageNo ="1";
			}
		a= Integer.parseInt(pageNo) ;
		List<Applicant> list = teachService.srhAll(a);
		request.setAttribute("list", list);
		// 参数传递到显示页 【all，pages变量值后续添加】
		ApplicantService appService = new ApplicantService();
		request.setAttribute("all", appService.getAll());
		System.out.println("=========");
		if (appService.getAll() % 6 != 0) {//处于第几页
			request.setAttribute("pages", (appService.getAll() / 6 + 1));
		} else {
			request.setAttribute("pages", appService.getAll() / 6);
		}
		
		
	}
}
