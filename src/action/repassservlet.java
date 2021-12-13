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
		//获取传过来的值，即修改后的pass
		String repass = request.getParameter("rpass");
		System.out.println(repass);
		
		repass = (repass != null) ? repass : "";
		Applicant app = new Applicant();
		//获取账号，要从jsp页面获取 。 app.setZhanghao();
		app.setMima(repass);
		String use= (String) request.getSession().getAttribute("use");
		System.out.println("从jsp的session获取当前的账户："+use);
		app.setZhanghao(use);
		//传入俩个参数，分别是账号与密码
		ApplicantService appService = new ApplicantService();
		int result = appService.repass(app);
		System.out.println("result的值："+result);
		request.getSession().setAttribute("app", app);
		try {
			PrintWriter out = response.getWriter();	
			System.out.println("修改之前。。。。。。。。。。。。。。。。。。。。。");
			out.println("<script type='text/javascript'>alert('修改成功，将返回登录界面!');</script>"); 
			out.println("<script>window.location='login.jsp'</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
