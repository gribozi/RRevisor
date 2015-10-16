package pages;

import main.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

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
		
		ArrayList<Restaurant> restList = dbWork.getAllRestaurants();
		
//		Реализация сортировки списка через локальное определение компоратора 
/* 		
		Collections.sort(restlList, new Comparator<Restaurant>() {
			@Override
			public int compare(Restaurant rest1, Restaurant rest2) {
				Float rait1 = (Float) rest1.getRaitTotal();
				Float rait2 = (Float) rest2.getRaitTotal();
				
				// Так как сортировка обратная, меняем местами rait1 и rait2
				return rait2.compareTo(rait1);
			}
		});
*/
		Collections.sort(restList);
		
		// Готовим параметр для передачи в jsp-файл
		request.setAttribute("restList", restList);
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/rest-list.jsp").forward(request, response);
	}

}
