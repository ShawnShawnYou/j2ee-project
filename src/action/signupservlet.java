package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplicantDao;
import entity.Applicant;
import service.ApplicantService;

@WebServlet("/signupservlet")
public class signupservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//ApplicantDao appdao =new ApplicantDao();
		add(request,response);		
		PrintWriter out = response.getWriter();		      			   
		out.println("<script type='text/javascript' >alert('注册成功');</script>");
		out.println("<script>window.location='index.jsp'</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);		
	}

	public void add(HttpServletRequest request, HttpServletResponse response) {

		//��ȡ��ע��ҳ�������ֵ
		String zcfname = request.getParameter("zc_fname");
		String zclname = request.getParameter("zc_lname");
		String zcaddr=request.getParameter("zc_addr");
		String zcuser=request.getParameter("zc_name");
		String zcpass=request.getParameter("zc_pass");
		
		//��֤�Ƿ������ 
		System.out.println(zcfname+zclname+zcaddr+zcuser+zcpass);
		zcfname = (zcfname != null) ? zcfname : "";
		zclname = (zclname != null) ? zclname : "";
		zcaddr = (zcaddr != null) ? zcaddr : "";
		zcuser = (zcuser != null) ? zcuser : "";
		zcpass = (zcpass != null) ? zcpass : "";
		
		Applicant app = new Applicant();
		app.setZhanghao(zcuser);
		app.setMima(zcpass);
		app.setFirstname(zcfname);
		app.setLastname(zclname);
		app.setAddr(zcaddr);
		
		ApplicantService appService = new ApplicantService();
		int result = appService.add(app);
		System.out.println(result);
		if (result > 0) {
			try {
				PrintWriter out = response.getWriter();	
				out.println("<script type='text/javascript' >alert('注册成功');</script>");
				out.println("<script>window.location='login.jsp'</script>");
				//request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (IOException e) {				
				e.printStackTrace();
			}
		} else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('注册失败');window.location.href=\"sign-up.jsp\"</script>");
				out.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}

