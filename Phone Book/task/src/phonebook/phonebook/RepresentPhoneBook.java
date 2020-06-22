package phonebook;
public class RepresentPhoneBook {
    private int phoneNumber;
    private final String firstName;
    private final String secondName;

    public RepresentPhoneBook(int phoneNumber, String firstName, String secondName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public  RepresentPhoneBook(int phoneNumber, String firstName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.secondName = "";
    }

    public  RepresentPhoneBook(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = -1;
    }

    public  RepresentPhoneBook(String firstName) {
        this.firstName = firstName;
        this.secondName = "";
        this.phoneNumber = -1;
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
