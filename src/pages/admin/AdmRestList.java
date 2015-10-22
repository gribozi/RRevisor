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
		
		// ”казание кодировки, в которой отправл€етс€ формируемый сервлетом HTML-код
		// response.setContentType("text/html; charset=utf-8");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		getServletContext().getRequestDispatcher("/adm-rest-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] restsCheckedStr;

		// ≈сли удал€етс€ один ресторан (со страницы adm-rest-one.jsp)
		if (request.getParameter("id") != null) {
			// ‘ормируем массив из одного ресторана
			restsCheckedStr = new String[1];
			restsCheckedStr[0] = request.getParameter("id");
		}
		// ≈сли удал€етс€ несколько ресторанов (со страницы adm-rest-list.jsp)
		else {
			// ѕолучение массива выбранных ресторанов, переданного из формы POST-ом
			restsCheckedStr = request.getParameterValues("checked");			
		}
		
		// ѕреобразуем массив строк в массив int дл€ того, что бы передать из в MySQL-запрос
		int[] restsChecketInt = new int[restsCheckedStr.length];
		for(int i = 0; i < restsChecketInt.length; i++) {
			restsChecketInt[i] = Integer.parseInt(restsCheckedStr[i]);
		}
		
		boolean dellOK = dbWork.removeRestaurants(restsChecketInt);
		
		// √отовим параметр дл€ передачи в jsp-файл
		request.setAttribute("dellOK", dellOK);
		
		doGet(request, response);
	}

}
