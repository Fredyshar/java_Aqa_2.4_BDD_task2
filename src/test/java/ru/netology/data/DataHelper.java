package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class DataHelper {
    private DataHelper() {
    }

    private static Faker faker;

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo() {
        return new AuthInfo("petya", "123qwerty");
    }

    public static AuthInfo getAuthInfoWithOtherLogin() {
        faker = new Faker(new Locale("en"));
        return new AuthInfo(faker.name().username(), "123qwerty");
    }

    public static AuthInfo getAuthInfoWithOtherPassword() {
        faker = new Faker(new Locale("en"));
        return new AuthInfo("vasya", faker.internet().password());
    }


    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }


    public static VerificationCode getNotVerificationCodeFor() {
        return new VerificationCode("12348");
    }

    @Value
    public static class CardData {
        private String cardNumber;
    }

    public static String cardNumber(String id) {
        var city = Arrays.asList("5559000000000001", "5559000000000002");
        if (Objects.equals(id, "0001")) {
            return city.get(1);
        } else {
            return city.get(0);
        }
    }

}