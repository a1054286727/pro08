package sec;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")

public class FirstSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("address","부산시 사상구");
		RequestDispatcher dispatch = request.getRequestDispatcher("second");
		dispatch.forward(request, response);
			 
	}


	

}
