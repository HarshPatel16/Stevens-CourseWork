/**
 * This program shows inheritance relation between Person, Employee, Staff, Faculty and student class.
 * when program will print each class with toString() message it will print class name and it's attributes.
 *
 * @author Harsh Patel
 * @date 04/07/2022
 */

import java.time.LocalDate;

public class Exercise_11_2 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("THIS PROGRAM SHOWS INHERITED CHILD CLASSES FROM SUPER CLASSES AND RELATION BETWEEN THEM");
		
		System.out.println();
		
        try {
		Person person = new Person("Will Wagner", "259 North Bristol Avenue, Los Angeles, CA 90049 USA",
                					"201-333-1235","wwagner@mail.com","A63GF89HG2");
		System.out.println(person.toString());
        }
        catch(Exception e){
        	System.out.println(e);
        }
        
        try {
        Person employee = new Employee("Harsh Patel", "85 JEFFERSON HOBOKEN NJ 07030-1865 USA",
                						"201-095-5342", "hpatel@mail.com" , "Hoboken Main Campus",
                						10000.00, LocalDate.parse("2021-10-04"),"G62GFF9H32");
        System.out.println(employee.toString());
        }
        catch(Exception e){
        	System.out.println(e);
        }
        
        try {
        Person staff = new Staff("Chris Paul", "132 VAN WINKLE JERSEY CITY NJ 07302 USA",
                				 "901-077-2469", "cpaul@mail.com", "NYC Campus", 150000,
                				  LocalDate.parse("2020-11-25"), "Accountant","W53G8Y9H72");
        System.out.println(staff.toString());
        }
        catch(Exception e){
        	System.out.println(e);
        }
        
        try {
        Person faculty = new Faculty("Chole King", "111 VAN JEFFERSON JERSEY CITY NJ 07302 USA", "540-328-1354",
                					 "cking@mail.com", "Jersey City Campus", 125000, "10AM - 2PM",
                					 "Assistant", LocalDate.parse("2019-08-31"),"ADG9FE9HD2");
        System.out.println(faculty.toString());
        }
        catch(Exception e){
        	System.out.println(e);
        }
        
        try {
        Person student = new Student("Gregorio Santonio", "PO BOX 3221 HOBOKEN NJ 07030-1630 USA",
                					 "732-878-4231", "gsantonio@mail.com", 3,"A643FG92F2");
        System.out.println(student.toString());
        }
        catch(Exception e){
        	System.out.println(e);
        }
        
        System.out.println();
        /////
        try {
    		Person person = new Person("Will Wagner", "259 North Bristol Avenue, Los Angeles, CA 90049 USA",
                    					"201-333-1225","wwagner@mail.com","A6GF89HG2");
    		System.out.println(person.toString());
            }
            catch(Exception e){
            	System.out.println(e);
            }
            
            try {
            Person employee = new Employee("", "85 JEFFERSON HOBOKEN NJ 07030-1865 USA",
                    						"201-095-5342", "hpatel@mail.com" , "Hoboken Main Campus",
                    						10000.00, LocalDate.parse("2021-10-04"),"G62G2F9H32");
            System.out.println(employee.toString());
            }
            catch(Exception e){
            	System.out.println(e);
            }
            
            try {
            Person staff = new Staff("Chris Paul", "132 VAN WINKLE JERSEY CITY NJ 07302 USA",
                    				 "901-0277-2469", "cpaul@mail.com", "NYC Campus", 150000,
                    				  LocalDate.parse("2020-11-25"), "Accountant","W53G8Y9H72");
            System.out.println(staff.toString());
            }
            catch(Exception e){
            	System.out.println(e);
            }
            
            try {
            Person faculty = new Faculty("Chole King", "111 VAN JEFFERSON JERSEY CITY NJ 07302 USA", "540-328-1354",
                    					 "cking@mail.com", "", 125000, "10AM - 2PM",
                    					 "Assistant", LocalDate.parse("2019-08-31"),"ADG9FE9HD2");
            System.out.println(faculty.toString());
            }
            catch(Exception e){
            	System.out.println(e);
            }
            
            try {
            Person student = new Student("Gregorio Santonio", "PO BOX 3221 HOBOKEN NJ 07030-1630 USA",
                    					 "732-878-4231", "", 3,"A643FG92F2");
            System.out.println(student.toString());
            }
            catch(Exception e){
            	System.out.println(e);
            }
        
	}

}
