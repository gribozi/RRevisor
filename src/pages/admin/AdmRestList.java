package pages.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.*;

/**
 * Servlet implementation class AdmRestList
 */
@WebServlet("/AdmRestList")
public class AdmRestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmRestList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Restaurant> restList = dbWork.getAllRestaurants("total_rating");
		Collections.sort(restList);
		
		request.setAttribute("restList", restList);
		
		// �������� ���������, � ������� ������������ ����������� ��������� HTML-���
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		getServletContext().getRequestDispatcher("/adm-rest-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] restsCheckedStr;

		// ���� ��������� ���� �������� (�� �������� adm-rest-one.jsp)
		if (request.getParameter("id") != null) {
			// ��������� ������ �� ������ ���������
			restsCheckedStr = new String[1];
			restsCheckedStr[0] = request.getParameter("id");
		}
		// ���� ��������� ��������� ���������� (�� �������� adm-rest-list.jsp)
		else {
			// ��������� ������� ��������� ����������, ����������� �� ����� POST-��
			restsCheckedStr = request.getParameterValues("checked");			
		}
		
		// ����������� ������ ����� � ������ int ��� ����, ��� �� �������� �� � MySQL-������
		int[] restsChecketInt = new int[restsCheckedStr.length];
		for(int i = 0; i < restsChecketInt.length; i++) {
			restsChecketInt[i] = Integer.parseInt(restsCheckedStr[i]);
		}
		
		boolean dellOK = dbWork.removeRestaurants(restsChecketInt);
		
		// ������� �������� ��� �������� � jsp-����
		request.setAttribute("dellOK", dellOK);
		
		doGet(request, response);
	}

}
