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


@WebServlet("/indexservlet")
public class indexservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicantService appService = new ApplicantService();
		
		
		ApplicantService teachService = new ApplicantService();
		List<Applicant> list = teachService.srhAll_dingdan(1);
		request.getSession().setAttribute("list_index", list);
		int all_index = appService.getAll_dingdan();
		request.getSession().setAttribute("all_index", all_index);
		System.out.println("all_index="+all_index);
		
		int all_user=appService.getAll();
		System.out.println("all user ="+all_user);
		request.getSession().setAttribute("all_user", all_user);
		
		if (all_user / 4 !=0) {
			request.getSession().setAttribute("pages_dingdan", (all_user/ 4 + 1));
		} else {
			request.getSession().setAttribute("pages_dingdan", all_user/ 4);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
