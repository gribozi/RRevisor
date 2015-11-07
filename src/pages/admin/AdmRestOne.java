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
		// Заложим возможность открывать в админке страницу одного ресторана через GET-запрос
		
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
		getServletContext().getRequestDispatcher("/adm-rest-one.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int restId = 0;
		boolean savedOK;
		String operationType = "";
		
		// Указание кодировки, в которой поступают в сервлет данные, отправленные пользователем (актуально для POST-запросов с русск. парам.)
		request.setCharacterEncoding("utf-8");
		
		String restName = request.getParameter("name");
		String restReview = request.getParameter("review");
		Byte restCuisine = Byte.parseByte(request.getParameter("cuisine"));
		Byte restInterior = Byte.parseByte(request.getParameter("interior"));
		Byte restService = Byte.parseByte(request.getParameter("service"));		
		
		// Если id не задан, значит обрабатываем добавление
		if (request.getParameter("id").equals("")) {
			restId = DBWork.addRestaurant(restName, restReview, restCuisine, restInterior, restService);
			if (restId != 0) savedOK = true;
			else savedOK = false;
			
			operationType = "add";
			
			//// Создаем фото-папку для добавляемого ресторана
			//// filesWork.createFolder(restId);
		}
		// Если есть id, значит обрабатываем редактирование
		else {
			restId = Integer.parseInt(request.getParameter("id"));
			
			savedOK = DBWork.editRestaurant(restId, restName, restReview, restCuisine, restInterior, restService);
			
			operationType = "edit";
			
			//// Принимаем фотографии, отправленные пользователем
			//// String photo = request.getParameter("photo");
			//// filesWork.savePhoto(photo);
			
			
			//// Читаем или считаем фотки из папки ресторана
			//// filesWork.readPhoto(restId);
			//// request.setAttribute("aAa", bBb);			
		}
		
		// Теперь выведем отредактированный или добавленный ресторан
		
		Restaurant restOne = DBWork.getRestaurant(restId);
		
		// Готовим параметры для передачи в jsp-файл
		request.setAttribute("restOne", restOne);
		request.setAttribute("savedOK", savedOK);
		request.setAttribute("operationType", operationType);
		
		// Указание кодировки, в которой отправляется формируемый сервлетом HTML-код
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/adm-rest-one.jsp").forward(request, response);		
		
	}
	
}