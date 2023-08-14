/*This is subclass of Employee and which is also a subclass of person superclass*/

import java.time.LocalDate;

public class Faculty extends Employee{

    String officeHours;
    String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress, String office
            , double salary, String officeHours, String rank, LocalDate dateHired){
        super(name,address,phoneNumber,emailAddress,office,salary,dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                ", EmailAddress='" + emailAddress + '\'' +
                ", Office='" + office + '\'' +
                ", Salary=" + salary +
                ", Date Hired=" + dateHired +
                ", OfficeHours='" + officeHours + '\'' +
                ", Rank='" + rank + '\'';
    }
}

