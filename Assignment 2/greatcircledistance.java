import java.util.*;
import java.lang.*;

public class greatcircledistance {

	public static void main(String[] args) {
		/*Takes two point's latitude and longitude in degrees from user and prints circle distance between those two points*/
		Scanner sc = new Scanner(System.in);
		double radius =	6371.01;
		System.out.print("Enter point 1 (latitude) and longitude) in degrees:");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		System.out.print("Enter point 2 (latitude and longitude) in degrees:");
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		
		x1= Math.toRadians(x1);
		y1= Math.toRadians(y1);
		x2= Math.toRadians(x2);
		y2= Math.toRadians(y2);

		double d = radius * Math.acos(Math.sin (x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		System.out.println("The distance between the two points is "+d+" km");
	}

}
