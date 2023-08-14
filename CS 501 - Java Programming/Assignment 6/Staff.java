/*This is subclass of Employee and which is also a subclass of person superclass*/

import java.time.LocalDate;

public class Staff extends Employee {

    String title;

    public Staff(String name, String address, String phoneNumber, String emailAddress,
                 String office, double salary, LocalDate dateHired, String title) {
        super(name,address,phoneNumber,emailAddress,office,salary, dateHired);
        this.title = title;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", EmailAddress='" + emailAddress + '\'' +
                ", Office='" + office + '\'' +
                ", Salary=" + salary +
                ", Date Hired=" + dateHired +
                ", Title='" + title + '\'';
    }
}

