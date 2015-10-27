package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Restaurant;
import main.DBWork;

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
		
		// Получаем параметр (id ресторана), который был передан в сервлет из адресной строки
		int restId = (int)Integer.parseInt(request.getParameter("rest"));
		
		Restaurant restOne = DBWork.getRestaurant(restId);
		
		// Готовим параметр для передачи в jsp-файл
		request.setAttribute("restOne", restOne);
		
		//// Читаем или считаем фотки из папки ресторана
		//// filesWork.readPhoto(restId);
		//// request.setAttribute("aAa", bBb);
		
		// Указание кодировки, в которой отправляется формируемый сервлетом HTML-код
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		getServletContext().getRequestDispatcher("/rest-one.jsp").forward(request, response);
	}
	
}
