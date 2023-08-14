/*This is subclass of person so it can use super classes's methods and attributes*/

public class Student extends Person {


    final int freshman = 1;
    final int sophomore = 2;
    final int junior  = 3;
    final int senior = 4;

    String studentStatus = "";

    public Student(String name, String address,String phoneNumber, String emailAddress, int status)
    {
        super(name,address,phoneNumber,emailAddress);

        switch (status) {

            case 1: studentStatus = "freshman";
            break;
            case 2: studentStatus = "sophomore";
                break;
            case 3: studentStatus = "junior";
                break;
            case 4: studentStatus = "senior";
                break;
            default: studentStatus = "studemt";
                break;
        }
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", Email-Address='" + emailAddress + '\'' +
                ", StudentStatus='" + studentStatus + '\'';
    }
}


