package action;

import entity.Applicant;
import entity.Stuff;
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

@WebServlet("/add_stuff_servlet")
public class add_stuff_servlet extends HttpServlet {

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

		String stuff_name = request.getParameter("stuff_name");
		String stuff_number = request.getParameter("stuff_number");
		//int status = (status_str.equals("")) ? 0 : Integer.parseInt(status_str);

		stuff_name = (stuff_name != null) ? stuff_number : "";
		stuff_number = (stuff_number != null) ? stuff_number : "";

		Stuff stuff = new Stuff(stuff_name, stuff_number);

		ApplicantService appService = new ApplicantService();
		int result = appService.add_stuff(stuff);
		System.out.println(result);

		if (result > 0) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript' >alert('��ӳɹ���');</script>");
				out.println("<script>window.location='stuff_manage.jsp'</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('���ʧ�ܣ�');</script>");
				out.println("<script>window.location='add_stuff.jsp'</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

