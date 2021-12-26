package action;

import service.ApplicantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete_dingdan_servlet")
public class delete_dingdan_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		add(request,response);
		PrintWriter out = response.getWriter();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void add(HttpServletRequest request, HttpServletResponse response)   {

		int pageNo;
		int vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (Exception e) {
			pageNo = 1;
		}

		ApplicantService appService = new ApplicantService();
		int result = appService.delete_dingdan(vehicle_id);
		System.out.println(result);

		if (result > 0) {
			try {
				PrintWriter out = response.getWriter();
//				out.println("<script type='text/javascript' >alert('É¾³ý³É¹¦£¡');</script>");
				out.println("<script>window.location.href=" +
						"\"http://localhost:8080/Logistics-system/admin_allgoods_servlet?pageNo=" + pageNo + "\";" +
						"</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				PrintWriter out = response.getWriter();
//				out.println("<script>alert('É¾³ýÊ§°Ü£¡');</script>");
				out.println("<script>window.location.href=" +
						"\"http://localhost:8080/Logistics-system/admin_allgoods_servlet?pageNo=" + pageNo + "\";" +
						"</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

