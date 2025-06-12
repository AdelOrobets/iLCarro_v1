package utils;

import dto.CarLombok;
import dto.UserLombok;

public class TestDataFactory {

    public static UserLombok validUser() {
        return new UserLombok(
                RandomUtils.generateFirstNameFromList(),
                RandomUtils.generateLastNameFromList(),
                RandomUtils.generateEmail(8),
                RandomUtils.generatePassword(10)
        );
    }

    public static UserLombok userWithoutEmail() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username("") // ❌
                .password(RandomUtils.generatePassword(10))
                .build();
    }

    public static UserLombok userWithoutPassword() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateEmail(8))
                .password("") // ❌
                .build();
    }

    public static UserLombok userWithoutFirstName() {
        return UserLombok.builder()
                .firstName("") // ❌
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateEmail(8))
                .password(RandomUtils.generatePassword(10))
                .build();
    }

    public static UserLombok userWithoutLastName() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName("") // ❌
                .username(RandomUtils.generateEmail(8))
                .password(RandomUtils.generatePassword(10))
                .build();
    }

    public static UserLombok invalidEmailNoAtSymbol() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateInvalidEmailNoAtSymbol(10)) // ❌
                .password(RandomUtils.generatePassword(10))
                .build();
    }

    public static UserLombok invalidEmailNoDomain() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateInvalidEmailNoDomain(10)) // ❌
                .password(RandomUtils.generatePassword(10))
                .build();
    }

    public static UserLombok invalidEmailWithSpace() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateEmail(4) + " " + RandomUtils.generateEmail(4)) // ❌
                .password(RandomUtils.generatePassword(10))
                .build();
    }

    public static UserLombok invalidPasswordTooShort() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateEmail(8))
                .password(RandomUtils.generatePassword(1)) // ❌
                .build();
    }

    public static UserLombok invalidPasswordTooLong() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateEmail(8))
                .password(RandomUtils.generatePassword(16)) // ❌
                .build();
    }

    public static UserLombok invalidPasswordNoDigit() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateEmail(8))
                .password(RandomUtils.generatePasswordInvalidNoDigit(10)) // ❌
                .build();
    }

    public static UserLombok invalidPasswordNoSymbol() {
        return UserLombok.builder()
                .firstName(RandomUtils.generateFirstNameFromList())
                .lastName(RandomUtils.generateLastNameFromList())
                .username(RandomUtils.generateEmail(8))
                .password(RandomUtils.generatePasswordInvalidNoSymbol(10)) // ❌
                .build();
    }

    public static CarLombok validCar() {
        return CarLombok.builder()
                .city(RandomUtils.generateCity())
                .manufacture(RandomUtils.generateManufacture())
                .model(RandomUtils.generateModel())
                .year(RandomUtils.generateYear())
                .fuel(RandomUtils.generateFuelType())
                .seats(RandomUtils.generateSeats())
                .carClass(RandomUtils.generateCarClass())
                .serialNumber(RandomUtils.generateSerialNumber())
                .pricePerDay(RandomUtils.generatePricePerDay())
                .about(RandomUtils.generateAboutText())
                .build();
    }
}
