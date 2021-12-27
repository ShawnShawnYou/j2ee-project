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

//�ý����������ڵ�¼������˺�������ж�
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �Ե�¼������˺����������֤����֤�ɹ�����ת��������index.jsp
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");


		String use = request.getParameter("username");
		String password = request.getParameter("password");
		ApplicantDao appdao = new ApplicantDao();
		String db_pass = appdao.srhpass(use); // �����ݿ��л�ȡ�����룬������db_pass��
//		System.out.println(use);
		// ��ȡ��
//		String db_fristname = appdao.srhFirstname(use);
//		System.out.println(db_fristname);
//		// ��ȡ��
//		String db_lastname = appdao.srhLastname(use);
//		System.out.println(db_lastname);
//		// ��ȡ��ַ
//		String db_addr = appdao.srhaddr(use);
//		System.out.println(db_addr);
//		// ʹ��getsession��������ȷ�����ݵ��������ڲ���̫���������ݶ�ʧ
//		request.getSession().setAttribute("LFname", (db_fristname + " " + db_lastname));
		// ����ֵ��
//		request.getSession().setAttribute("db_fristname", db_fristname);
//		request.getSession().setAttribute("db_lastname", db_lastname);
//		request.getSession().setAttribute("db_addr", db_addr);
//		request.getSession().setAttribute("use", use);
//		request.getSession().setAttribute("db_pass", db_pass);

//�˴���Ҫע�������ʹ�ñ��ύ���ݹ�������String���������ͣ��ڽ���equals�ж�ʱint�����String����ʱ������ȵģ���ʹ�ǿ�����ֵ�����
//		System.out.println(password);
//		System.out.println(db_pass);
		PrintWriter out = response.getWriter();
		// ��������û������user��ֵ�������ݿ���Ѱ�ң����ҷ��������롣
		if (password.equals(db_pass)) { // �ж������Ƿ���ȷ
			// ��¼�ɹ�����ת����ҳ
			if(use.equals("admin")){
				out.println("<script type='text/javascript' >alert('登录成功!');</script>");
				out.println("<script>window.location='http://localhost:8080/Logistics-system/Stuff.jsp'</script>");

				System.out.println("��¼�ɹ�");
			}
			else {
				out.println("<script type='text/javascript' >alert('登录成功!');</script>");
				out.println("<script>window.location='http://localhost:8080/Logistics-system/indexservlet'</script>");

				System.out.println("��¼�ɹ�");
			}
		} else { // ����½������˺����벻��ʱ��������ת����ǰҳ�棬��������ʹ��js�����������
			out.println("<script type='text/javascript' >alert('登录失败!');</script>");
			out.println("<script>window.location='login.jsp'</script>");
			// ʹ��js��������˵ʹ����out.println������ִ���������ת���
			// request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}