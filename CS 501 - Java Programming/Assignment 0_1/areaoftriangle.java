import java.util.*;
import java.lang.Math;

public class areaoftriangle {
	public static double area(double x1, double y1, double x2, double y2, double x3, double y3) {
		double side1 = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		double side2 = Math.sqrt((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2));
		double side3 = Math.sqrt((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3));
		double s = (side1+side2+side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double x1,y1,x2,y2,x3,y3;
		System.out.print("Enter the coordinates of three points seperated by spaces like x1 y1 x2 y2 x3 y3: ");
		x1=sc.nextDouble();
		y1=sc.nextDouble();
		x2=sc.nextDouble();
		y2=sc.nextDouble();
		x3=sc.nextDouble();
		y3=sc.nextDouble();
		System.out.println("The area of the triangle is "+area(x1,y1,x2,y2,x3,y3));
		sc.close();
	}

}
