package pages.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.*;

/**
 * Servlet implementation class AdmRestAddEdit
 */
@WebServlet("/AdmRestAddEdit")
public class AdmRestAddEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmRestAddEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ѕолучаем параметр (id ресторана), который был передан в сервлет из адресной строки
		int rest_id = (int)Integer.parseInt(request.getParameter("id"));
		
		Restaurant restOne = dbWork.getRestaurant(rest_id);
		
		// √отовим параметр дл€ передачи в jsp-файл
		request.setAttribute("restOne", restOne);
		
		// ”казание кодировки, в которой отправл€етс€ формируемый сервлетом HTML-код
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/adm-rest-add-edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/adm-rest-add-edit.jsp").forward(request, response);
	}

}
