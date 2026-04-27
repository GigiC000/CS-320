//GigiCruz
//CS 320
//April 2026
//Version 3

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.ContactService;
import Contact.Contact;

class ContactServiceTest {

    private ContactService service;

    @AfterEach
    void tearDown() {
        service = null;
    }

    // Add contact tests 
    @Test
    @DisplayName("Add a single contact")
    void testAddContact() {
        service = new ContactService();
        service.addContact("Jane", "Doe", "1234567890", "123 Home Street");

        assertEquals(1, service.getContactList().size());

        Contact c = service.getContactList().iterator().next();
        assertEquals("Jane", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Home Street", c.getAddress());
    }

    @Test
    @DisplayName("Add multiple contacts")
    void testAddMultipleContacts() {
        service = new ContactService();
        service.addContact("Jane", "Doe", "1234567890", "123 Home Street");
        service.addContact("John", "Smith", "0987654321", "456 Main Street");

        assertEquals(2, service.getContactList().size());
    }

    // Delete tests 
    @Test
    @DisplayName("Delete existing contact")
    void testDeleteContact() {
        service = new ContactService();
        service.addContact("Jane", "Doe", "1234567890", "123 Home Street");
        service.addContact("John", "Smith", "0987654321", "456 Main Street");

        service.deleteContact("0");
        assertEquals(1, service.getContactList().size());
    }

    @Test
    @DisplayName("Delete non-existent contact")
    void testDeleteNonExistent() {
        service = new ContactService();
        service.addContact("Jane", "Doe", "1234567890", "123 Home Street");

        assertThrows(IllegalArgumentException.class,
                () -> service.deleteContact("99"));
    }

    // Update tests 
    @Test
    @DisplayName("Edit first name")
    void testEditFirstName() {
        service = new ContactService();
        service.addContact("Jane", "Doe", "1234567890", "123 Home Street");

        service.editFirstName("0", "Janet");
        Contact c = service.getContactList().iterator().next();
        assertEquals("Janet", c.getFirstName());
    }

    @Test
    @DisplayName("Edit phone")
    void testEditPhone() {
        service = new ContactService();
        service.addContact("Jane", "Doe", "1234567890", "123 Home Street");

        service.editPhoneNumber("0", "0987654321");
        Contact c = service.getContactList().iterator().next();
        assertEquals("0987654321", c.getPhone());
    }
}