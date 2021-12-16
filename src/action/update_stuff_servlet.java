package action;

import entity.Stuff;
import service.ApplicantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update_stuff_servlet")
public class update_stuff_servlet extends HttpServlet {

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

        String stuff_number = request.getParameter("stuff_number");
        String stuff_name = request.getParameter("stuff_name");

//		int pageNo = Integer.parseInt(request.getParameter("pageNo"));

        Stuff stuff = new Stuff(stuff_name, stuff_number);

        ApplicantService appService = new ApplicantService();
        int result = appService.update_stuff(stuff);
        System.out.println(result);

        if (result > 0) {
            try {
                PrintWriter out = response.getWriter();
                out.println("<script type='text/javascript' >alert('更新成功！');</script>");
                out.println("<script>window.location.href=" +
                        "\"http://localhost:8080/Logistics-system/all_stuff_servlet?pageNo=" + 1 + "\";" +
                        "</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PrintWriter out = response.getWriter();
                out.println("<script>alert('更新失败！');</script>");
                out.println("<script>window.location.href=" +
                        "\"http://localhost:8080/Logistics-system/all_stuff_servlet?pageNo=" + 1 + "\";" +
                        "</script>");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

