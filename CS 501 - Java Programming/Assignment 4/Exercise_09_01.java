import java.util.Scanner;

/*
 * (The Rectangle class) Following the example of the Circle class in Section 9.2,
 * design a class named Rectangle to represent a rectangle. The class contains:
 *  Two double data fields named width and height that specify the width and
 * height of the rectangle. The default values are 1 for both width and height.
 *  A no-arg constructor that creates a default rectangle.
 *  A constructor that creates a rectangle with the specified width and height.
 *  A method named getArea() that returns the area of this rectangle.
 *  A method named getPerimeter() that returns the perimeter.
 * Draw the UML diagram for the class then implement the class. Write a test program
 * that creates two Rectangle objects—one with width 4 and height 40, and
 * three objectives
 * Programming Exercises 363
 * the other with width 3.5 and height 35.9. Display the width, height, area, and
 * perimeter of each rectangle in this order.
 *
 * @author Harsh Patel
 * @date 03/18/2022
 */

public class Exercise_09_01 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		double width;
        double height;
       
		Rectangle rectangle1 = new Rectangle();
		
		String introStatement = "This program will calculate area and perimeter of the rectangle.";
        System.out.println(introStatement);
        System.out.println("You will enter values for width and height to see the "
                +"perimeter and area of your Rectangle object\n");
		
		int check=1;
		while(check==1) {
		System.out.println("Enter width:");
		width=sc.nextDouble();
		System.out.println("Enter height:");
		height=sc.nextDouble();
			try {
				rectangle1 = new Rectangle(width,height);
				System.out.println();
				System.out.println("Rectangle's Width:     " + rectangle1.width);
				System.out.println("Rectangle's Height:    " + rectangle1.height);
				System.out.println("Rectangle's Area:      " + rectangle1.getArea());
				System.out.println("Rectangle's Perimeter: " + rectangle1.getPerimeter());
			}
			catch(Exception e){
				System.out.println(e);
			}
			System.out.println();
			System.out.println("Input 1 to repeat the program/ Input 0 to exit: ");
			check = sc.nextInt();
		}	
	}

}
