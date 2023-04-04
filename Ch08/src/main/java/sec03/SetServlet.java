package sec03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletContext;

/**
 * Servlet implementation class SetServlet
 */
@WebServlet("/cset")
public class SetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        List<Object> member = new ArrayList<Object>();
        member.add("이순신");
        member.add(30);
        context.setAttribute("member", member);
        out.print("<html><body>");
        out.print("이순신과 30 설정");
        out.print("</body></html>");
    }
}
