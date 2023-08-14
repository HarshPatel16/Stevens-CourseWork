
import java.util.Scanner;

public class cramersrule {

	public static void main(String[] args) {
		
		/*Takes inputs from user of 2x2 linear equations and program solves it with the Cramer's rule */
		
		System.out.print("Enter a, b, c, d, e, f:");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double d = sc.nextDouble();
		double e = sc.nextDouble();
		double f = sc.nextDouble();
		if(((a*d)-(b*c))==0) {
			System.out.println("The equation has no solution");
		}
		else {
		double x = ((e*d)-(b*f))/((a*d)-(b*c));
		double y =	((a*f)-(e*c))/((a*d)-(b*c));
		System.out.println("X is "+x+" and Y is "+y);
	}
	}
}
