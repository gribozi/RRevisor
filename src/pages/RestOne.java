package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Restaurant;
import main.dbWork;

/**
 * Servlet implementation class RestOne
 */
@WebServlet("/RestOne")
public class RestOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ѕолучаем параметр (id ресторана), который был передан в сервлет из адресной строки
		int rest_id = (int)Integer.parseInt(request.getParameter("rest"));
		
		Restaurant restOne = dbWork.getOneRestaurant(rest_id);
		
		// √отовим параметр дл€ передачи в jsp-файл
		request.setAttribute("restOne", restOne);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/rest-one.jsp").forward(request, response);
	}

}
