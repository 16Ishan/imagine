package com.imagine.book.utils;

import java.util.Random;

public class GenerateRandomHexCode
{
    public static final Random random = new Random();

    private GenerateRandomHexCode(){}
    public static String generateHex()
    {
        StringBuilder hexCodeBuilder = new StringBuilder(32);

        for (int i = 0; i < 32; i++) {
            int randomInt = random.nextInt(16);
            String hexDigit = Integer.toHexString(randomInt);
            hexCodeBuilder.append(hexDigit);
        }

        return hexCodeBuilder.toString();
    }
}
