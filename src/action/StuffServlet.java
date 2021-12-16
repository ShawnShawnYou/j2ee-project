package action;

import entity.Applicant;
import entity.Stuff;
//import entity.Vehicle;
import service.ApplicantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/stuffServlet")
public class StuffServlet {

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

        stuff_number = (stuff_number != null) ? stuff_number : "";
        stuff_name = (stuff_name != null) ? stuff_name : "";

        Stuff stuff = new Stuff(stuff_name, stuff_number);

        ApplicantService appService = new ApplicantService();
        int result = appService.add_stuff(stuff);
        System.out.println(result);
        if (result > 0) {
            try {
                PrintWriter out = response.getWriter();
                out.println("<script type='text/javascript' >alert('添加成功！');</script>");
                out.println("<script>window.location='Stuff.jsp'</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PrintWriter out = response.getWriter();
                out.println("<script>alert('添加失败！');</script>");
                out.println("<script>window.location='add_stuff.jsp'</script>");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
