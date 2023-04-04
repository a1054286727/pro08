package ex5;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoadAppConfig
 */
@WebServlet(name = "loadConfig", urlPatterns = "/loadConfig", loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LoadAppConfig의 init 메서드 호출");
        context = config.getServletContext();

        // Typo correction on parameter names
        String menu_member = context.getInitParameter("menu_member");
        String menu_order = context.getInitParameter("menu_order");
        String menu_goods = context.getInitParameter("menu_goods");

        // Typo correction on attribute names
        context.setAttribute("menu_member", menu_member);
        context.setAttribute("menu_order", menu_order);
        context.setAttribute("menu_goods", menu_goods);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // Get attribute values from the ServletContext
        String menu_member = (String) context.getAttribute("menu_member");
        String menu_order = (String) context.getAttribute("menu_order");
        String menu_goods = (String) context.getAttribute("menu_goods");

        out.print("<html><body>");
        out.print("<table border=1 cellspacing=0><tr><td>메뉴 이름</td></tr>"); // Fix missing <td> tag
        out.print("<tr><td>" + menu_member + "</td></tr>");
        out.print("<tr><td>" + menu_order + "</td></tr>");
        out.print("<tr><td>" + menu_goods + "</td></tr>");
        out.print("</table></body></html>");
    }
}
