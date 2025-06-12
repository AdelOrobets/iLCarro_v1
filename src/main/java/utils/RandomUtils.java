package utils;

import java.security.SecureRandom;
import java.util.List;

public class RandomUtils {

    private static final SecureRandom random = new SecureRandom();

    // firstName
    private static final List<String> FIRST_NAMES = List.of(
            "Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona",
            "George", "Hannah", "Ivan", "Julia", "Kevin", "Laura",
            "Mike", "Nina", "Oscar", "Paula", "Quentin", "Rachel");

    //lastName
    private static final List<String> LAST_NAMES = List.of(
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia",
            "Miller", "Davis", "Wilson", "Anderson", "Taylor", "Thomas",
            "Moore", "Martin", "Lee", "Clark", "Lewis", "Walker");

    public static String generateFirstNameFromList() {
        return FIRST_NAMES.get(random.nextInt(FIRST_NAMES.size()));
    }

    public static String generateLastNameFromList() {
        return LAST_NAMES.get(random.nextInt(LAST_NAMES.size()));
    }

    public static String generateEmail(int length) {
        return generateRandomString(length, "abcdefghijklmnopqrstuvwxyz0123456789") + "@gmail.com";
    }

    public static String generateInvalidEmailNoAtSymbol(int length) {
        return generateRandomString(length, "abcdefghijklmnopqrstuvwxyz0123456789") + "gmail.com";
    }

    public static String generateInvalidEmailNoDomain(int length) {
        return generateRandomString(length, "abcdefghijklmnopqrstuvwxyz0123456789") + ".com";
    }

    public static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "@$#^&*!";

        String allChars = upper + lower + digits + special;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }
        return password.toString();
    }

    public static String generatePasswordInvalidNoSymbol(int length) {
        return generateRandomString(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
    }

    public static String generatePasswordInvalidNoDigit(int length) {
        return generateRandomString(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@$#^&*!");
    }

    private static String generateRandomString(int length, String characters) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}
