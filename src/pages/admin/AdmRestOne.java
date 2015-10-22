package pages.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.*;

/**
 * Servlet implementation class AdmRestOne
 */
@WebServlet("/AdmRestOne")
public class AdmRestOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmRestOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������� ����������� ��������� � ������� �������� ������ ��������� ����� GET-������
		
		// �������� �������� (id ���������), ������� ��� ������� � ������� �� �������� ������
		int restId = (int)Integer.parseInt(request.getParameter("rest"));
		
		Restaurant restOne = dbWork.getRestaurant(restId);
		
		// ������� �������� ��� �������� � jsp-����
		request.setAttribute("restOne", restOne);

		// �������� ���������, � ������� ������������ ����������� ��������� HTML-���
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/adm-rest-one.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rest_id = 0;
		boolean savedOK;
		String operationType = "";
		
		// �������� ���������, � ������� ��������� � ������� ������, ������������ ������������� (��������� ��� POST-�������� � �����. �����.)
		request.setCharacterEncoding("utf-8");

		String rest_name = request.getParameter("name");
		String rest_review = request.getParameter("review");
		Byte rest_cuisine = Byte.parseByte(request.getParameter("cuisine"));
		Byte rest_interior = Byte.parseByte(request.getParameter("interior"));
		Byte rest_service = Byte.parseByte(request.getParameter("service"));		
		
		// ���� id �� �����, ������ ������������ ����������
		if (request.getParameter("id").equals("")) {
			rest_id = dbWork.addRestaurant(rest_name, rest_review, rest_cuisine, rest_interior, rest_service);
			if (rest_id != 0) savedOK = true;
			else savedOK = false;
			
			operationType = "add";
		}
		// ���� ���� id, ������ ��� ������������ ��������������
		else {
			rest_id = Integer.parseInt(request.getParameter("id"));

			savedOK = dbWork.editRestaurant(rest_id, rest_name, rest_review, rest_cuisine, rest_interior, rest_service);
			
			operationType = "edit";
		}
		
		// ������ ������� ����������������� ��� ����������� ��������
		
		Restaurant restOne = dbWork.getRestaurant(rest_id);
		
		// ������� ��������� ��� �������� � jsp-����
		request.setAttribute("restOne", restOne);
		request.setAttribute("savedOK", savedOK);
		request.setAttribute("operationType", operationType);
		
		// �������� ���������, � ������� ������������ ����������� ��������� HTML-���
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/adm-rest-one.jsp").forward(request, response);		

	}

}