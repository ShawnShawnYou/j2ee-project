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


@WebServlet("/repassservlet")
public class repassservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		ApplicantDao appdao = new ApplicantDao();
	
		repass(request,response);
				   
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	private void repass(HttpServletRequest request, HttpServletResponse response) {
		//��ȡ��������ֵ�����޸ĺ��pass
		String repass = request.getParameter("rpass");
		System.out.println(repass);
		
		repass = (repass != null) ? repass : "";
		Applicant app = new Applicant();
		//��ȡ�˺ţ�Ҫ��jspҳ���ȡ �� app.setZhanghao();
		app.setMima(repass);
		String use= (String) request.getSession().getAttribute("use");
		System.out.println("��jsp��session��ȡ��ǰ���˻���"+use);
		app.setZhanghao(use);
		//���������������ֱ����˺�������
		ApplicantService appService = new ApplicantService();
		int result = appService.repass(app);
		System.out.println("result��ֵ��"+result);
		request.getSession().setAttribute("app", app);
		try {
			PrintWriter out = response.getWriter();	
			System.out.println("�޸�֮ǰ������������������������������������������");
			out.println("<script type='text/javascript'>alert('登录失败!');</script>");
			out.println("<script>window.location='login.jsp'</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
