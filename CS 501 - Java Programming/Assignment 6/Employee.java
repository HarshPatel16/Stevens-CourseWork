/*This is another subclass of person so it can use super classes's methods and attributes*/

import java.time.LocalDate;

public class Employee extends Person{
		String office;
		double salary;
		LocalDate dateHired;

		public Employee(String name,String address,String phoneNumber,String emailAddress,
                    String office,double salary, LocalDate dateHired) {
        super(name,address,phoneNumber,emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;

    }

    public String toString() {
        return getClass().getName() +
                "  Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                ", Email-Address='" + emailAddress + '\'' +
                ", Office='" + office + '\'' +
                ", Salary=" + salary +
                ", Date Hired=" + dateHired;
    }
}
