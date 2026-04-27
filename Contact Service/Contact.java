//Gigi Cruz
//CS 320
//April 2026
//Version 3

package Contact;

public class Contact {
    private final String contactId; // immutable ID
    private String firstName;
    private String lastName;
    private String phone; 
    private String address;

    // Constructor to initialize the contact object
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name Invalid");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name Invalid");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contactId (no setter - immutable)
    public String getContactId() {
        return contactId;
    }

    // Getters and setters for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name Invalid");
        }
        this.firstName = firstName;
    }

    // Getters and setters for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name Invalid");
        }
        this.lastName = lastName;
    }

    // Getter and setter for phone number
    public String getPhone() {
        return phone; // fixed typo
    }

    public void setPhone(String phone) { //renamed from setNumber
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone Number Invalid");
        }
        this.phone = phone;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.address = address;
    }
}