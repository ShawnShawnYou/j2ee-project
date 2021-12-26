package action;

import entity.Applicant;
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

@WebServlet("/update_dingdan_servlet")
public class update_dingdan_servlet extends HttpServlet {

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

		int td_id = Integer.parseInt(request.getParameter("td_id"));
		String goods_name = request.getParameter("goods_name"); 
		String goods_number = request.getParameter("goods_number");
		String goods_baozhuang = request.getParameter("goods_baozhuang");
		String goods_weight = request.getParameter("goods_weight");
		String goods_volume = request.getParameter("goods_volume");
		String fahuo_person = request.getParameter("fahuo_person");
		String shouhuo_person = request.getParameter("shouhuo_person");
		String date_tmp = request.getParameter("fahuo_date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fahuo_date = null;
		try {
			  fahuo_date = sdf.parse(date_tmp);
			 } catch (ParseException e) {
			  e.printStackTrace();
			 }
		String fahuo_addr = request.getParameter("fahuo_addr");
		String shouhuo_addr = request.getParameter("shouhuo_addr");
		String tuoyun_money = request.getParameter("tuoyun_money");
		String shonghuo_money = request.getParameter("shonghuo_money");
		String baoxian_money = request.getParameter("baoxian_money");
		String jiehuo_money = request.getParameter("jiehuo_money");
		String pay_money = request.getParameter("pay_money");
		String pick = request.getParameter("pick");
		String single = request.getParameter("single");
		
		System.out.println(goods_name+goods_number+goods_baozhuang+goods_weight+goods_volume+fahuo_person+shouhuo_person+fahuo_date+fahuo_addr+shouhuo_addr+tuoyun_money+shonghuo_money+baoxian_money+jiehuo_money+pay_money+pick+single);
		goods_name = (goods_name != null) ? goods_name : "";
		goods_number = (goods_number != null) ? goods_number : "";
		goods_baozhuang = (goods_baozhuang != null) ? goods_baozhuang : "";
		goods_weight = (goods_weight != null) ? goods_weight : "";
		goods_volume = (goods_volume != null) ? goods_volume : "";
		fahuo_person = (fahuo_person != null) ? fahuo_person : "";
		shouhuo_person = (shouhuo_person != null) ? shouhuo_person : "";
		fahuo_addr = (fahuo_addr != null) ? fahuo_addr : "";
		shouhuo_addr = (shouhuo_addr != null) ? shouhuo_addr : "";
		tuoyun_money = (tuoyun_money != null) ? tuoyun_money : "";
		shonghuo_money = (shonghuo_money != null) ? shonghuo_money : "";
		baoxian_money = (baoxian_money != null) ? baoxian_money : "";
		jiehuo_money = (jiehuo_money != null) ? jiehuo_money : "";
		pay_money = (pay_money != null) ? pay_money : "";
		pick = (pick != null) ? pick : "";
		single = (single != null) ? single : "";
		
		Applicant tding = new Applicant();
		tding.setGoods_name(goods_name);
		tding.setGoods_number(goods_number);
		tding.setGoods_baozhuang(goods_baozhuang);
		tding.setGoods_weight(goods_weight);
		tding.setGoods_volume(goods_volume);
		tding.setFahuo_person(fahuo_person);
		tding.setShouhuo_person(shouhuo_person);
		tding.setFahuo_date(fahuo_date);
		tding.setFahuo_addr(fahuo_addr);
		tding.setShouhuo_addr(shouhuo_addr);
		tding.setTuoyun_money(tuoyun_money);
		tding.setShonghuo_money(shonghuo_money);		
		tding.setBaoxian_money(baoxian_money);
		tding.setJiehuo_money(jiehuo_money);
		tding.setPay_money(pay_money);
		tding.setPick(pick);
		tding.setSingle(single);
		tding.setTd_id(td_id);
		
		ApplicantService appService = new ApplicantService();
		int result = appService.update_order(tding);
		System.out.println(result);
		if (result > 0) {
			try {
				PrintWriter out = response.getWriter();	
				out.println("<script type='text/javascript' >alert('更新成功！');</script>");
				out.println("<script>window.location='http://localhost:8080/Logistics-system/admin_allgoods_servlet'</script>");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		} else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('更新失败！');</script>");
				out.println("<script>window.location='admin_update_dingdan.jsp?td_id=" + td_id  + "</script>");
				out.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}

