package main;

import java.sql.*;
import java.util.ArrayList;

public class dbWork {

	static final String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/revisor";
	
	// Возвращает список всех ресторанов, выбранных из БД
	public static ArrayList<Restaurant> getAllRestaurants() {
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			
			Statement stmt = conn.createStatement();
			ResultSet rslt = stmt.executeQuery("select id, name, cuisine_rating, interior_rating, service_rating from restaurants");

			while (rslt.next()) {
				list.add(new Restaurant(rslt.getInt("id"), rslt.getString("name"), rslt.getByte("cuisine_rating"), rslt.getByte("interior_rating"), rslt.getByte("service_rating")));
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			//e.printStackTrace();
			//System.exit(0);
	    }
	
	    finally {
	    	try {
	    		if (conn != null)
	    			conn.close();
	        } catch (SQLException e) {
	        	System.err.println("Connection close error");
				//e.printStackTrace();
				//System.exit(0);
	        }
	   }
		
		return list; 
	}

	// Возвращает один заданный ресторан, выбранный из БД
	public static Restaurant getOneRestaurant(int rest_id) {
		Restaurant selectedRest = null;
		
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			
			PreparedStatement stmt = conn.prepareStatement("select id, name, review, cuisine_rating, interior_rating, service_rating from restaurants where id = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			stmt.setInt(1, rest_id);
			ResultSet rslt = stmt.executeQuery();
			// Изначально курсор расположен непосредственно перед первой строкой объекта ResultSet. 
			// Первый вызов метода next() устанавливает курсор на первой строке и делает ее текущей.
			rslt.next();
			
			selectedRest = new Restaurant(rslt.getInt("id"), rslt.getString("name"), rslt.getString("review"), rslt.getByte("cuisine_rating"), rslt.getByte("interior_rating"), rslt.getByte("service_rating"));
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			//e.printStackTrace();
			//System.exit(0);
	    }
	
	    finally {
	    	try {
	    		if (conn != null)
	    			conn.close();
	        } catch (SQLException e) {
	        	System.err.println("Connection close error");
				//e.printStackTrace();
				//System.exit(0);
	        }
	   }
		
		return selectedRest; 
	}
	
}
