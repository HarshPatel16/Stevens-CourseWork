/*This is super class and it's subclasses are Student and Employee*/

public class Person {
	String name;
    String address;
    String phoneNumber;
    String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                ", Email-Address='" + emailAddress + '\'';
    }
}
