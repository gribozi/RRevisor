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
		
		ArrayList<Restaurant> restList = dbWork.getAllRestaurants("total_rating");
		
		// ������� �������� ��� �������� � jsp-����
		request.setAttribute("restList", restList);

		// �������� ���������, � ������� ������������ ����������� ��������� HTML-���
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/rest-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Restaurant> restList;
		
		// �������� ���������, � ������� ��������� � ������� ������, ������������ �������������
		request.setCharacterEncoding("utf-8");
		
		// ���� ������������ POST-������ ������
		if (request.getParameter("queary") != null) {
			restList = dbWork.getAllRestaurantsBySearch(request.getParameter("queary"));
		}
		// ���� ������������� POST-������ ����������
		else {
			restList = dbWork.getAllRestaurants(request.getParameter("sort"));
		}
		
		// ������� ��������� ��� �������� � jsp-����
		request.setAttribute("restList", restList);
		request.setAttribute("quearyFromPost", request.getParameter("queary"));
		request.setAttribute("sortFromPost", request.getParameter("sort"));
		
		// �������� ���������, � ������� ������������ ����������� ��������� HTML-���
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/rest-list.jsp").forward(request, response);
	}

}
