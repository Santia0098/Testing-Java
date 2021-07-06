package com.platzi.javatests.challengeOneIsEmpty;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyTest {

    @Test
    public void test_not_empty() {
        assertFalse(StringUtil.isEmpty("holaPrueba"));
    }

    @Test
    public void test_empty() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void test_null() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void test_with_space() {
        assertTrue(StringUtil.isEmpty(" "));
    }

}