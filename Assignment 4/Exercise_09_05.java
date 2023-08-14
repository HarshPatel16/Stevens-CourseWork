
import java.util.GregorianCalendar;

/*
 * Program will use GregorianCalendar class to display the
 * current year, month, and day.
 * The GregorianCalendar class has the setTimeInMillis(long), which
 * can be used to set a specified elapsed time since January 1, 1970. Set the value
 * to 1234567898765L and display the year, month, and day.

 * @author Harsh Patel
 * @date 03/18/2022
 */
/*
(Use the GregorianCalendar class) Java API has the GregorianCalendar class
in the java.util package, which you can use to obtain the year, month, and day of a
date. The no-arg constructor constructs an instance for the current date, and the methods
get(GregorianCalendar.YEAR), get(GregorianCalendar.MONTH),
and get(GregorianCalendar.DAY_OF_MONTH) return the year, month, and day.
Write a program to perform two tasks:
* Display the current year, month, and day.
* The GregorianCalendar class has the setTimeInMillis(long), which
can be used to set a specified elapsed time since January 1, 1970. Set the value
to 1234567898765L and display the year, month, and day.
*/

public class Exercise_09_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final long TIME = 1234567898765L;

        // Months of the year
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        //Set today's date
        GregorianCalendar todayDate = new GregorianCalendar();

        System.out.println("This program will show you the current date");
        System.out.println("It will also show the date after an elapsed time of "+
                "1234567898765 milliseconds starting at Jan 1, 1970\n");

        //Display current date
        System.out.println("Year of the today's date : " + todayDate.get(GregorianCalendar.YEAR));
		System.out.println("Month of the today's date : " + months[todayDate.get(GregorianCalendar.MONTH)]);
        System.out.println("Day of the today's date : " + todayDate.get(GregorianCalendar.DAY_OF_MONTH));


        todayDate.setTimeInMillis(TIME);

        //Display new date from elapsed time
        System.out.println("\nDate 1234567898765 milliseconds after 1/1/1970:");
        System.out.println("***************************************************");
      
        System.out.println("Year of the date since 1/1/78: " + todayDate.get(GregorianCalendar.YEAR));
	 System.out.println("Month of the date since 1/1/78: " + months[todayDate.get(GregorianCalendar.MONTH)]);
        System.out.println("Day of the date since 1/1/78: " + todayDate.get(GregorianCalendar.DAY_OF_MONTH));
	}

}
