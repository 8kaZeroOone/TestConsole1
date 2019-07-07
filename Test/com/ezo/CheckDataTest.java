package com.ezo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckDataTest {
    CheckData data = new CheckData();

    @Test
    void checkAction() {
        int actual = data.checkAction((byte)3);
        int expected = (byte)3;
        assertEquals(expected,actual);

        int actual1 = data.checkAction((byte)1);
        int expected1 = (byte)1;
        assertEquals(expected1,actual1);

        int actual2 = data.checkAction((byte)7);
        int expected2 = (byte)-1;
        assertEquals(expected2,actual2);

        int actual3 = data.checkAction((byte)33);
        int expected3 = (byte)-1;
        assertEquals(expected3,actual3);

        int actual4 = data.checkAction((byte)-10);
        int expected4 = (byte)-1;
        assertEquals(expected4,actual4);
    }

    @Test
    void checkLine() {
        String actual = data.checkLine("hello, World!");
        String expected = "hello, World!";
        assertEquals(expected,actual);

        String actual1 = data.checkLine("12");
        String expected1 = "12";
        assertEquals(expected1,actual1);

        String actual2 = data.checkLine("question is?");
        String expected2 = "question is?";
        assertEquals(expected2,actual2);

        String actual3 = data.checkLine("Igor");
        String expected3 = "Igor";
        assertEquals(expected3,actual3);

        String actual4 = data.checkLine("Alexander");
        String expected4 = "Alexander";
        assertEquals(expected4,actual4);

    }
}