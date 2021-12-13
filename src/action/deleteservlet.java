package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ApplicantService;

@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		delete(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {

		String user_name = request.getParameter("user_name");
		System.out.println(user_name);

		
		ApplicantService appService = new ApplicantService();
		int result = appService.delete(user_name);

		if (result > 0) {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script type='text/javascript' >alert('删除成功，即将跳转!');</script>");
				out.println("<script>window.location='indexservlet'</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
