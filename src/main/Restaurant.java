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
	
	// ��������, ��������� �� ��������� ������ ������������ ��� ������ �������� (�������� ��� ��������� �� ��)
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
		return review.replaceAll("\n", "<br />");
	}
	public String getReviewAdm() {
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
		
		// ��� ��� ���������� ��������, ������ ������� ����� �����������
		
		if (this.getRaitTotal() < tmp.getRaitTotal()) {
			/* ������� ������ ����������� */
			return 1;
	    }
	    else if (this.getRaitTotal() > tmp.getRaitTotal())
	    {
	    	/* ������� ������ ����������� */
	    	return -1;
	    }
		
    	/* ������� ����� ����������� */
    	return 0;  
	}


/*	���������� ���������� ������ ����� ��������� ����������� �����������
	�������������� �� ������� ������, ������ ����� ����� �����������)  
 		
	Collections.sort(restlList, new Comparator<Restaurant>() {
		@Override
		public int compare(Restaurant rest1, Restaurant rest2) {
			Float rait1 = (Float) rest1.getRaitTotal();
			Float rait2 = (Float) rest2.getRaitTotal();
			
			// ��� ��� ���������� ��������, ������ ������� rait1 � rait2
			return rait2.compareTo(rait1);
		}
	});

*/

// Collections.sort(restList);	

}