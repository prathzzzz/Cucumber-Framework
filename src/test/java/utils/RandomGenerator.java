package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateRandomAlphanumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String generateRandomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String generateRandomEmail() {
        return generateRandomString(8).toLowerCase() + "@test.com";
    }

    public static String generateRandomUsername() {
        return "user_" + generateRandomAlphanumeric(8).toLowerCase();
    }

    public static String generateRandomPassword() {
        return "Pass_" + generateRandomAlphanumeric(8) + "!";
    }

    public static String generateRandomPhoneNumber() {
        return "+" + generateRandomNumeric(10);
    }
}