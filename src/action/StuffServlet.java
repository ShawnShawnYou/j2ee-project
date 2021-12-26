package action;

import entity.Applicant;
import entity.Stuff;
import entity.Vehicle;
import service.ApplicantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/StuffServlet")
public class StuffServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicantService applicantService = new ApplicantService();

		int stuff_count = applicantService.get_all_stuff_count();
		request.getSession().setAttribute("all1", stuff_count);
		if (stuff_count % 6 != 0) {
			request.getSession().setAttribute("pages_dingdan", (stuff_count/ 6 + 1));
		} else {
			request.getSession().setAttribute("pages_dingdan", stuff_count/ 6);
		}

		request.getSession().setAttribute("now_page", 1);

		List<Stuff> list = applicantService.get_all_stuff();
		request.getSession().setAttribute("list1", list);

		request.getRequestDispatcher("stuff_manage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
