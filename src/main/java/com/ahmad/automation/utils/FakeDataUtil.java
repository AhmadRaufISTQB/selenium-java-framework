package com.ahmad.automation.utils;

import com.github.javafaker.Faker;

public class FakeDataUtil {
    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomFullName() {
        return faker.name().fullName();
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomUsername() {
        return faker.name().username();
    }

    public static String getRandomPassword() {
        return faker.internet().password(8, 16);
    }
}
