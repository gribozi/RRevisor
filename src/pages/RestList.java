package pages;

import main.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestList
 */
@WebServlet("/RestList")
public class RestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Restaurant> restList = DBWork.getAllRestaurants("total_rating");
		
		// Готовим параметр для передачи в jsp-файл
		request.setAttribute("restList", restList);
		
		// Указание кодировки, в которой отправляется формируемый сервлетом HTML-код
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/rest-list.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Restaurant> restList;
		
		// Указание кодировки, в которой поступают в сервлет данные, отправленные пользователем
		request.setCharacterEncoding("utf-8");
		
		// Если обрабатываем POST-запрос поиска
		if (request.getParameter("queary") != null) {
			restList = DBWork.getAllRestaurantsBySearch(request.getParameter("queary"));
		}
		// Если обрабатываеми POST-запрос сортировки
		else {
			restList = DBWork.getAllRestaurants(request.getParameter("sort"));
		}
		
		// Готовим параметры для передачи в jsp-файл
		request.setAttribute("restList", restList);
		request.setAttribute("quearyFromPost", request.getParameter("queary"));
		request.setAttribute("sortFromPost", request.getParameter("sort"));
		// Вместо этого в jsp можно просто обращаться к переданному в сервлет параметру таким образом: ${param.sort}
		
		// Указание кодировки, в которой отправляется формируемый сервлетом HTML-код
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/rest-list.jsp").forward(request, response);
	}
	
}
