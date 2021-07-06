package com.platzi.javatests.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public  void repeat_string_once() {
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola", 3));
        //Assert.assertEquals(StringUtil.repeat("hola", 1), "hola");
    }

    @Test
    public  void repeat_string_multiple_times() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public  void repeat_string_negative_times() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", -1));
    }

}