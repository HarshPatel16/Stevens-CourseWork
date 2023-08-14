/**
 * Program to ask user to enter three sides of the triangle and
 * check if sum of the side of two triangle should not be less than
 * third side.
 *
 * @author Harsh Patel
 * @date 04/07/2022
 */

import java.util.Scanner;
public class Exercise_12_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("THIS PROGRAM CHECKS THE SUM OF TWO SIDES IS GREATER OR EQUAL THAN THE THIRD SIDE. IF NOT THEN"
							+ " IT WILL THROW AN EXCEPTION WITH MESSAGE OTHERWISE IT WILL PRINT SIDES OF TRIANGLES");
		System.out.println();
        int repeatSidesInput = 1;
        while (repeatSidesInput == 1){
           System.out.println("Enter three side of the triangle: ");

            double side1 = input.nextDouble();
            double side2 = input.nextDouble();
            double side3 = input.nextDouble();

            try {

                Triangle triangle = new Triangle(side1, side2, side3);
               
                System.out.println(triangle.toString());

            }
            catch (IllegalTriangleException ex) {
                System.out.println(ex.getClass().getName() + " - " + ex.getMessage());
            }

	    System.out.println("Enter 1 to check triangle again / Enter 0 to exit");
	    repeatSidesInput = input.nextInt();

        }
	}

}
