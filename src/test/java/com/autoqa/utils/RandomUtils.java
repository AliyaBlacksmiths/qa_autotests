package com.autoqa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class RandomUtils {
    public static String[] genderArray = {"Male", "Female", "Other"};
    public static Faker fakerRu = new Faker(new Locale("ru"));

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(1111, 9999));
        System.out.println(getRandomEmail());
        System.out.println(getRandomPhone());

    }
    //Чтобы сгенерить любое значение, далее вызываем этот метод и указываем, сколько букв/цифр должно быть в сгенерированной строке
    public static String getRandomString(int length) {
//        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdifghigklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    //Чтобы сгенерить целое значение, далее вызываем этот метод и указываем промежуток
    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    //Генерация почты, но данный метод зависит от генерации строки, те getRandomString
    public static String getRandomEmail() {
        String emailDomain = "@qa.guru";

        return getRandomString(10) + emailDomain;
    }

    public static String getRandomPhone() {
        Random generator = new Random();
        int num1 = 0;
        int num2 = 0;

        num1 = generator.nextInt(999) + 100;//numbers can't include an 8 or 9, can't go below 100.
//        num2 = generator.nextInt(99) + 10;//number has to be less than 742//can't go below 100.

        String phoneNumber = "8" + num1 + num1 + num1;
        return phoneNumber;
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }

    public static String getRandomFullAddress() {
        return fakerRu.address().fullAddress();
    }
}
