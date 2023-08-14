import java.util.*;
public class pointsintriangle {

	public static void main(String[] args) {
		/*Takes Co-ordinates of a point from users and checks if the points on the triangle*/
		
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a point's x- and y-coordinates: ");
		double x = input.nextDouble();
		double y = input.nextDouble();

		double intersectx = (-x * (200 * 100)) / (-y * 200 - x * 100);
		double intersecty = (-y * (200 * 100)) / (-y * 200 - x * 100);
		
		if(x>intersectx || y > intersecty) {
			System.out.println("The point is not in the triangle");
		}
		else {
			System.out.println("The point is in the triangle");
		}
	}

}
