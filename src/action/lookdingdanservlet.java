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

@WebServlet("/lookdingdanservlet")
public class lookdingdanservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicantService teachService = new ApplicantService();

		int dingdan = teachService.getAll_dingdan();
		System.out.println(dingdan);
		request.getSession().setAttribute("dingdan", dingdan);

		List<Applicant> list = teachService.srhAll_dingdanall(dingdan);
		request.getSession(). setAttribute("dingdan_alllist", list);
		System.out.println(list);
		request.getRequestDispatcher("lookdingdan.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
