
public class estimateareas {

	 private static final double Radius = 6371.01;

	    public static void main(String[] args) {
	    	/*Here, all the GPS location has been given already given*/
	   
	        double atlantaY = -84.3879824;
	        double atlantaX = 33.7489954;
	        double orlandoY = -81.3792364999;
	        double orlandoX = 28.5383355;
	        double savannahY = -81.09983419999998;
	        double savannahX = 32.0835407;
	        double charlotteY = -80.84312669999997;
	        double charlotteX = 35.2270869;

	        double t1Side1 = distancebetweenpoints(atlantaX, atlantaY, savannahX, savannahY);
	        double t1Side2 = distancebetweenpoints(savannahX, savannahY, charlotteX, charlotteY);
	        double t1Side3 = distancebetweenpoints(charlotteX, charlotteY, atlantaX, atlantaY);

	        double t2Side1 = distancebetweenpoints(atlantaX, atlantaY, orlandoX, orlandoY);
	        double t2Side2 = distancebetweenpoints(orlandoX, orlandoY, savannahX, savannahY);
	        double t2Side3 = distancebetweenpoints(savannahX, savannahY, atlantaX, atlantaY);

	        boolean isTriangle1 = isTriangle(t1Side1, t1Side2, t1Side3);
	        boolean isTriangle2 = isTriangle(t1Side1, t1Side2, t1Side3);


	        if (isTriangle1 && isTriangle2) {
	            double area1 = areaoftriangle(t1Side1, t1Side2, t1Side3);
	            double area2 = areaoftriangle(t2Side1, t2Side2, t2Side3);
	            System.out.println("Triangle 1: side-1: "+t1Side1+" |side-2: "+t1Side2+ " |side-3: "+t1Side3+ "  : area = "+area1);
	            System.out.println();
	            System.out.println("Triangle 2: side-1: "+t2Side1+" |side-2: "+t2Side2+ " |side-3: "+t2Side3+ "  : area = "+area2);
	            System.out.println();
	            double totalArea = area1 + area2;
	            System.out.println("The area of the triangle is " + totalArea);
	        } else {
	            System.out.println("Sorry the coordinates are incorrect");
	        }

	    }

	    public static double distancebetweenpoints(double x1, double y1, double x2, double y2) {
	    	/*Calculates distance between points*/
	        double distance = Radius *
	        		Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) +
	                        Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1 - y2)));

	        return distance;
	    }

	    public static double areaoftriangle(double side1, double side2, double side3) {
	    	/*If they are triangle this function calculates area of triangle they make*/
	        double s = (side1 + side2 + side3) / 2.0;
	        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	    }

	    public static boolean isTriangle(double side1, double side2, double side3) {
	    	/*This function checks for given locations  if they make triangle or not*/
	        return  ((side1 + side2 > side3) && (side1 + side3 > side2) && (side3 + side2 > side1));

	    }
}
