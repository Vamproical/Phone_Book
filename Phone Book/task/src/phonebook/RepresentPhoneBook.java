package phonebook;

import java.util.Objects;

public class RepresentPhoneBook {
    private int phoneNumber;
    private final String firstName;
    private final String secondName;

    public RepresentPhoneBook(int phoneNumber, String firstName, String secondName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public RepresentPhoneBook(int phoneNumber, String firstName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.secondName = "";
    }

    public RepresentPhoneBook(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = -1;
    }

    public RepresentPhoneBook(String firstName) {
        this.firstName = firstName;
        this.secondName = "";
        this.phoneNumber = -1;
    }

    public RepresentPhoneBook(RepresentPhoneBook representPhoneBook) {
        this.firstName = representPhoneBook.firstName == null ? "" : representPhoneBook.firstName;
        this.secondName = representPhoneBook.secondName == null ? "" : representPhoneBook.secondName;
        this.phoneNumber = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepresentPhoneBook that = (RepresentPhoneBook) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        if (secondName != null || firstName != null) {
            hash = (7 * hash) + this.secondName.hashCode();
            hash = 7 * hash + this.firstName.hashCode();
        }

        return Math.abs(hash);
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "RepresentPhoneBook{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
