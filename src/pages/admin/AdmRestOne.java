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
		// «аложим возможность открывать в админке страницу одного ресторана через GET-запрос
		
		// ѕолучаем параметр (id ресторана), который был передан в сервлет из адресной строки
		int restId = (int)Integer.parseInt(request.getParameter("rest"));
		
		Restaurant restOne = dbWork.getRestaurant(restId);
		
		// √отовим параметр дл€ передачи в jsp-файл
		request.setAttribute("restOne", restOne);

		// ”казание кодировки, в которой отправл€етс€ формируемый сервлетом HTML-код
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
		
		// ”казание кодировки, в которой поступают в сервлет данные, отправленные пользователем (актуально дл€ POST-запросов с русск. парам.)
		request.setCharacterEncoding("utf-8");

		String rest_name = request.getParameter("name");
		String rest_review = request.getParameter("review");
		Byte rest_cuisine = Byte.parseByte(request.getParameter("cuisine"));
		Byte rest_interior = Byte.parseByte(request.getParameter("interior"));
		Byte rest_service = Byte.parseByte(request.getParameter("service"));		
		
		// ≈сли id не задан, значит обрабатываем добавление
		if (request.getParameter("id").equals("")) {
			rest_id = dbWork.addRestaurant(rest_name, rest_review, rest_cuisine, rest_interior, rest_service);
			if (rest_id != 0) savedOK = true;
			else savedOK = false;
			
			operationType = "add";
		}
		// ≈сли есть id, значит это обрабатываем редактирование
		else {
			rest_id = Integer.parseInt(request.getParameter("id"));

			savedOK = dbWork.editRestaurant(rest_id, rest_name, rest_review, rest_cuisine, rest_interior, rest_service);
			
			operationType = "edit";
		}
		
		// “еперь выведем отредактированный или добавленный ресторан
		
		Restaurant restOne = dbWork.getRestaurant(rest_id);
		
		// √отовим параметры дл€ передачи в jsp-файл
		request.setAttribute("restOne", restOne);
		request.setAttribute("savedOK", savedOK);
		request.setAttribute("operationType", operationType);
		
		// ”казание кодировки, в которой отправл€етс€ формируемый сервлетом HTML-код
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/adm-rest-one.jsp").forward(request, response);		

	}

}