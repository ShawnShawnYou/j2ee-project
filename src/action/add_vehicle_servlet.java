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
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/add_vehicle_servlet")
public class add_vehicle_servlet extends HttpServlet {

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

		String location = request.getParameter("location");
		String license_number = request.getParameter("license_number");
		String type = request.getParameter("type");
		String status_str = request.getParameter("status");
		int status = (status_str.equals("")) ? 0 : Integer.parseInt(status_str);

		location = (location != null) ? location : "";
		license_number = (license_number != null) ? license_number : "";
		type = (type != null) ? type : "";

		Vehicle vehicle = new Vehicle(0, location, license_number, type, status);
		
		ApplicantService appService = new ApplicantService();
		int result = appService.add_vehicle(vehicle);
		System.out.println(result);

		if (result > 0) {
			try {
				PrintWriter out = response.getWriter();	
				out.println("<script type='text/javascript' >alert('添加成功！');</script>"); 
				out.println("<script>window.location='vehicle_manage.jsp'</script>");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		} else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('添加失败！');</script>");
				out.println("<script>window.location='add_vehicle.jsp'</script>");
				out.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}

