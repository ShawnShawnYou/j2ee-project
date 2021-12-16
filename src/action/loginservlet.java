package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ApplicantDao;
import db.SQLDB;
import entity.Applicant;
import service.ApplicantService;

//该界面适用于在登录界面的账号密码等判断
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 对登录界面的账号密码进行验证，验证成功后跳转到主界面index.jsp
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

	
		String use = request.getParameter("username");
		String password = request.getParameter("password");
		ApplicantDao appdao = new ApplicantDao();
		String db_pass = appdao.srhpass(use); // 从数据库中获取的密码，保存再db_pass中
//		System.out.println(use);
		// 获取名
		String db_fristname = appdao.srhFirstname(use);
		System.out.println(db_fristname);
		// 获取姓
		String db_lastname = appdao.srhLastname(use);
		System.out.println(db_lastname);
		// 获取地址
		String db_addr = appdao.srhaddr(use);
		System.out.println(db_addr);
		// 使用getsession保存数据确保数据的生命周期不会太短以免数据丢失
		request.getSession().setAttribute("LFname", (db_fristname + " " + db_lastname));
		// 将该值绑定
		request.getSession().setAttribute("db_fristname", db_fristname);
		request.getSession().setAttribute("db_lastname", db_lastname);
		request.getSession().setAttribute("db_addr", db_addr);
		request.getSession().setAttribute("use", use);
		request.getSession().setAttribute("db_pass", db_pass);

//此处需要注意的是在使用表单提交数据过来的是String的数据类型，在进行equals判断时int对象和String对象时不会相等的，即使是看起来值是相等
//		System.out.println(password);
//		System.out.println(db_pass);
		PrintWriter out = response.getWriter();
		// 传入接受用户输入的user的值，在数据库中寻找，并且返回其密码。
		if (password.equals(db_pass)) { // 判断密码是否正确
			// 登录成功后跳转到主页
			if(use.charAt(0) == '1'){
				out.println("<script type='text/javascript' >alert('登陆成功，即将跳转!');</script>");
				out.println("<script>window.location='http://localhost:8080/Logistics-system/'</script>");

				System.out.println("登录成功");
			}
			else if(use.charAt(0) == '0'){
				out.println("<script type='text/javascript' >alert('登陆成功，即将跳转!');</script>");
				out.println("<script>window.location='http://localhost:8080/Logistics_system/Stuff.jsp'</script>");

				System.out.println("登录成功");
			}
		} else { // 当登陆输入的账号密码不对时，还是跳转到当前页面，重新输入使用js代码进行提醒
			out.println("<script type='text/javascript' >alert('登陆失败，请重新登陆!');</script>");
			out.println("<script>window.location='login.jsp'</script>");
			// 使用js代码后或者说使用了out.println将不再执行下面的跳转语句
			// request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}