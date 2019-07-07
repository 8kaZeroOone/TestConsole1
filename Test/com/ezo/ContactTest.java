package com.ezo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void setName() {
        Contact c = new Contact();
        c.setName("Linar");
        String expected = "Linar";
        assertEquals(expected, c.name());

        c.setName("Alexander");
        String expected1 = "Alexander";
        assertEquals(expected1, c.name());

        c.setName("Igor");
        String expected2 = "Igor";
        assertEquals(expected2, c.name());
    }

    @Test
    void setPhone() {
        Contact c = new Contact();
        c.setPhone("79514876655");
        String expected = "79514876655";
        assertEquals(expected, c.phone());

        c.setPhone("12543568795");
        String expected1 = "12543568795";
        assertEquals(expected1, c.phone());

        c.setPhone("+79874562254");
        String expected2 = "+79874562254";
        assertEquals(expected2, c.phone());
    }

    @Test
    void setAddress() {
        Contact c = new Contact();
        c.setAddress("Gryaznova street #31");
        String expected = "Gryaznova street #31";
        assertEquals(expected, c.address());

        c.setAddress("Chelyabinskaya oblast', Kopeysk");
        String expected1 = "Chelyabinskaya oblast', Kopeysk";
        assertEquals(expected1, c.address());

        c.setAddress("Moscow, Chapaeva street #33");
        String expected2 = "Moscow, Chapaeva street #33";
        assertEquals(expected2, c.address());
    }

    @Test
    void name() {
        Contact c = new Contact();
        c.setName("Igor");
        String actual = c.name();
        String expected = "Igor";
        assertEquals(expected, actual);

        c.setName("Inga");
        c.setPhone("79514321444");
        c.setAddress("Moscow, Chapaeva street #33");
        String actual1 = c.name();
        String expected1 = "Inga";
        assertEquals(expected1, actual1);

        c.setName("Matvey");
        c.setPhone("+73214445655");
        String actual2 = c.name();
        String expected2 = "Matvey";
        assertEquals(expected2, actual2);
    }

    @Test
    void phone() {
        Contact c = new Contact();
        c.setName("Igor");
        c.setPhone("79514876655");
        String actual = c.phone();
        String expected = "79514876655";
        assertEquals(expected, actual);

        c.setName("Ilya");
        c.setPhone("79514321444");
        c.setAddress("Moscow, Chapaeva street #33");
        String actual1 = c.phone();
        String expected1 = "79514321444";
        assertEquals(expected1, actual1);

        c.setName("Matvey");
        c.setPhone("+73214445655");
        String actual2 = c.phone();
        String expected2 = "+73214445655";
        assertEquals(expected2, actual2);
    }

    @Test
    void address() {
        Contact c = new Contact();
        c.setName("Igor");
        c.setAddress("Moscow, Lenina street #33");
        String actual = c.address();
        String expected = "Moscow, Lenina street #33";
        assertEquals(expected, actual);

        c.setName("Ilya");
        c.setPhone("79514321444");
        c.setAddress("Moscow, Chapaeva street #33");
        String actual1 = c.address();
        String expected1 = "Moscow, Chapaeva street #33";
        assertEquals(expected1, actual1);

        c.setName("Matvey");
        c.setPhone("+73214445655");
        c.setAddress("Chelyabinskaya oblast', Kopeysk, Lenina street #43");
        String actual2 = c.address();
        String expected2 = "Chelyabinskaya oblast', Kopeysk, Lenina street #43";
        assertEquals(expected2, actual2);
    }

    @Test
    void toString1() {
        Contact contact = new Contact();
        contact.setName("Dinar");
        contact.setPhone ("89946155546");
        contact.setAddress ("Kaliningrad, Yakovleva street #41");

        String actual = contact.toString();
        String expected = "Dinar, 89946155546, Kaliningrad, Yakovleva street #41";
        assertEquals(expected, actual);


        contact.setName("Ignat");
        contact.setPhone ("+7959555546");
        contact.setAddress ("Saints-Petersburg, Yakovleva street #41");

        String actual1 =contact.toString();
        String expected1 ="Ignat, +7959555546, Saints-Petersburg, Yakovleva street #41";
        assertEquals(expected1, actual1);

        contact.setName("Ahmad");
        contact.setPhone ("89478955546");
        contact.setAddress ("Chelyabinsk, Lenina street #41");

        String actual2 =contact.toString();
        String expected2 ="Ahmad, 89478955546, Chelyabinsk, Lenina street #41";
        assertEquals(expected2, actual2);
    }
}