package com.platzi.javatests.util;

import org.junit.Test;

import static com.platzi.javatests.util.PasswordUtil.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {


    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(SecurityLevel.WEAK, assesPassword("1234657"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(SecurityLevel.WEAK, assesPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(SecurityLevel.MEDIUM, assesPassword("a1b2cd3e"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols() {
        assertEquals(SecurityLevel.STRONG, assesPassword("a1b2cd3e4fgh?"));
    }


}