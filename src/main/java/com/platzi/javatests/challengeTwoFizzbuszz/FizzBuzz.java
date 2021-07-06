package com.platzi.javatests.challengeTwoFizzbuszz;


public class FizzBuzz {

    public static String FizzBuzz(int data) {
        String result = "";
        boolean divisible = false;
        if (data % 3 == 0) {
            result += "Fizz";
            divisible = true;
        }
        if (data % 5 == 0) {
            result += "Buzz";
            divisible = true;
        }
        return divisible ? result : "" + data;
    }

    public static String arabicToRoman(int numero) {
        String result = "";

        for (int i = 0; i < numero; i++) {
            result += "I";

            result = result.replaceAll("IIII", "IV");
            result = result.replaceAll("IVI", "V");

            result = result.replaceAll("VIV", "IX");
            result = result.replaceAll("IXI", "X");

            result = result.replaceAll("XXXX", "XL");
            result = result.replaceAll("XLX", "L");

            result = result.replaceAll("LXL", "XC");
            result = result.replaceAll("XCX", "C");

            result = result.replaceAll("CCCC", "CD");
            result = result.replaceAll("CDC", "D");

            result = result.replaceAll("DCD", "CM");
            result = result.replaceAll("CMC", "M");
        }
        return result;
    }
}