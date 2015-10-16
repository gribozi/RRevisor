package main;

public class Restaurant implements Comparable<Object> {
	private int id;
	private String name;
	private String review;
	private byte raitCuisine;
	private byte raitInterior;
	private byte raitService;
	private String geo;
	
	public Restaurant(int rId, String rName, byte rRaitCuisine, byte rRaitInterior, byte rRaitService) {
		id = rId;
		name = rName;
		raitCuisine = rRaitCuisine;
		raitInterior = rRaitInterior;
		raitService = rRaitService;
	}
	
	// Уточнить, правильно ли создавать разные конструкторы под разные варианты (например при генерации из БД)
	public Restaurant(int rId, String rName, String rReview, byte rRaitCuisine, byte rRaitInterior, byte rRaitService) {
		id = rId;
		name = rName;
		review = rReview;
		raitCuisine = rRaitCuisine;
		raitInterior = rRaitInterior;
		raitService = rRaitService;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getReview() {
		return review;
	}
	
	public byte getRaitCuisine() {
		return raitCuisine;
	}
	
	public byte getRaitInterior() {
		return raitInterior;
	}
	
	public byte getRaitService() {
		return raitService;
	}

	public String getGeo() {
		return geo;
	}
	
	public float getRaitTotal() {
		float RaitTotal = (float) (raitCuisine * 0.4 + raitInterior * 0.3 + raitService * 0.3);
		return RaitTotal;
	}

	@Override
	public int compareTo(Object rest) {
		
		Restaurant tmp = (Restaurant)rest;
		
		// Так как сортировка обратная, меняем местами знаки сравнивания
		
		if (this.getRaitTotal() < tmp.getRaitTotal()) {
			/* текущее меньше полученного */
			return 1;
	    }
	    else if (this.getRaitTotal() > tmp.getRaitTotal())
	    {
	    	/* текущее больше полученного */
	    	return -1;
	    }
		
    	/* текущее равно полученному */
    	return 0;  
	}

}