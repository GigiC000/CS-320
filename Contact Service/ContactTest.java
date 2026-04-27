//GigiCruz
//CS 320
//March 2026
//Version 2

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.Contact;

class ContactTest {

    // Constructor tests 
    @Test
    @DisplayName("Valid constructor")
    void testGoodConstructor() {
        Contact testContact = new Contact("1", "Jane", "Doe", "1023456789", "123 Home Street");
        assertEquals("1", testContact.getContactId());
        assertEquals("Jane", testContact.getFirstName());
        assertEquals("Doe", testContact.getLastName());
        assertEquals("1023456789", testContact.getPhone());
        assertEquals("123 Home Street", testContact.getAddress());
    }

    @Test
    @DisplayName("Constructor with invalid phone")
    void testBadConstructorPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("2", "Jane", "Doe", "123", "123 Home Street"));
    }

    @Test
    @DisplayName("Constructor with too long ID")
    void testBadConstructorId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Jane", "Doe", "1023456789", "123 Home Street"));
    }

    @Test
    @DisplayName("Valid setPhone")
    void testGoodPhone() {
        Contact c = new Contact("6", "Jane", "Doe", "1023456789", "123 Home Street");
        c.setPhone("1234561234");
        assertEquals("1234561234", c.getPhone());
    }
}