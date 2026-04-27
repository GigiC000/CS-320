//GigiCruz
//CS 320
//April 2026
//Version 3

package Contact;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private int currentIDNum = 0; // auto-increment ID
    private Map<String, Contact> contactMap = new HashMap<>();

    // Get all contacts
    public Collection<Contact> getContactList() {
        return contactMap.values();
    }

    // Add a new contact
    public void addContact(String firstName, String lastName, String phone, String address) {
        String id = Integer.toString(currentIDNum);

        if (contactMap.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate ID");
        }

        Contact newContact = new Contact(id, firstName, lastName, phone, address);
        contactMap.put(id, newContact);
        currentIDNum++;
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {
        if (contactMap.remove(contactId) == null) {
            throw new IllegalArgumentException("Contact not found: " + contactId);
        }
    }

    // Update first name
    public void editFirstName(String contactId, String firstName) {
        findContact(contactId).setFirstName(firstName);
    }

    // Update last name
    public void editLastName(String contactId, String lastName) {
        findContact(contactId).setLastName(lastName);
    }

    // Update phone number
    public void editPhoneNumber(String contactId, String phone) {
        findContact(contactId).setPhone(phone);
    }

    // Update address
    public void editAddress(String contactId, String address) {
        findContact(contactId).setAddress(address);
    }

    // Find contact
    private Contact findContact(String contactId) {
        Contact contact = contactMap.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found: " + contactId);
        }
        return contact;
    }
}