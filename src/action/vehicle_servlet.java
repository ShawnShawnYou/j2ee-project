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

@WebServlet("/vehicle_servlet")
public class vehicle_servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicantService applicantService = new ApplicantService();

		int vehicle_count = applicantService.get_all_vehicle_count();
		request.getSession().setAttribute("all1", vehicle_count);
		if (vehicle_count % 6 != 0) {
			request.getSession().setAttribute("pages_dingdan", (vehicle_count/ 6 + 1));
		} else {
			request.getSession().setAttribute("pages_dingdan", vehicle_count/ 6);
		}

		request.getSession().setAttribute("now_page", 1);

		List<Vehicle> list = applicantService.get_vehicle(1);
		request.getSession().setAttribute("list1", list);


		request.getRequestDispatcher("vehicle_manage.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
